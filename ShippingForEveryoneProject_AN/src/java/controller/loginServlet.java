/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import Impl.AccountShippingImpl;
import Impl.AccountUserImpl;
import QueryStatement.IRepository;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.AccountShipping;
import model.UserAccount;

/**
 *
 * @author ASUS
 */
public class loginServlet extends HttpServlet {
private IRepository usimpl=new AccountUserImpl();
private IRepository shipimpl= new AccountShippingImpl();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        Cookie[] cookies = request.getCookies();
        String number = null;
        String pwd =null;
        for (Cookie o : cookies){
            if(o.getName().equals("Account")){
                number=o.getValue();
                request.setAttribute("number", number);
            
            }
            if (o.getName().equals("pass")) {
                pwd = o.getValue();
                request.setAttribute("pass",pwd);
            }
        }       
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            String role = request.getParameter("role");
            String remember=request.getParameter("remember");
            if(role==null){
                //lỗi khi người dùng không chọn role
                String msg="vui lòng chọn user hoặc shipper";
                request.setAttribute("MSG_Login", msg);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }else{
                
                if("user".equals(role)){
                    //phần đăng nhập của User 
                    List<UserAccount> listUsers = new ArrayList<>();
                    String number = request.getParameter("phoneNumber");
                    String password = request.getParameter("password");
                    Account account = new Account(number, password);
                    UserAccount usAcc = new UserAccount(account);
                    listUsers=usimpl.find(usAcc);
                    if(listUsers.isEmpty()){
                        String msg = "Sai Số điện thoại hoặc mật khẩu!";
                       request.setAttribute("MSG_Login", msg);                        
                       request.getRequestDispatcher("login.jsp").forward(request, response);
                    } else{
                        if(remember !=null){
                            Cookie cookieU= new Cookie("Account",number);
                            cookieU.setMaxAge(7*24*60*60);
                            response.addCookie(cookieU);
                            
                            Cookie cookieP = new Cookie("pass", password);
                            cookieP.setMaxAge(7 * 24 * 60 * 60);
                            response.addCookie(cookieP);
                        }
                        int id_account = listUsers.get(0).getAccount().getIdAccount();
                        Account accountLogin = new Account(id_account, number, password);
                        HttpSession session = request.getSession();
                        session.setAttribute("loginSession", accountLogin);
                        String fistName=listUsers.get(0).getPeople().getFirstName();
                        String lastName=listUsers.get(0).getPeople().getLastName();
                        String name = fistName + " " + lastName;
                        session.setAttribute("name", name);
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    }
                                       
                }else{
                        //phần đăng nhập của Shiper
                       AccountShippingImpl impl = new AccountShippingImpl();
                       List<AccountShipping> listShippers = new ArrayList<>();
                       String number = request.getParameter("phoneNumber");
                       String password = request.getParameter("password");
                       Account account = new Account(number, password);
                       AccountShipping accShipping = new AccountShipping(account);
                       listShippers=shipimpl.find(accShipping);
                       if (listShippers.isEmpty()) {
                        String msg = "Sai Số điện thoại hoặc mật khẩu!";
                        request.setAttribute("MSG_Login", msg);
                        request.getRequestDispatcher("login.jsp").forward(request, response);
                    } else {
                        if (remember != null) {
                            Cookie cookieU = new Cookie("Account", number);
                            cookieU.setMaxAge(7 * 24 * 60 * 60);
                            response.addCookie(cookieU);

                            Cookie cookieP = new Cookie("pass", password);
                            cookieP.setMaxAge(7 * 24 * 60 * 60);
                            response.addCookie(cookieP);
                        }
                        
                        int id_account = listShippers.get(0).getAccount().getIdAccount();
                        if(listShippers.get(0).isActive_status()==false){  //sửa Active Status
                            if(impl.updateActiveStatusOn(id_account)==true){ //sửa Active Status trong AccountShipping implement
                                accShipping.setActive_status(true);  //sửa Active Status
                            }
                            // em sửa thêm logOutShipperServlet nha
                            //sửa headerShiper cái logout chuyển thành servlet logOutShipperServlet
                        }
//                        else{
//                            String msg = "tài khoản của bạn đang hoạt động không thể đăng nhập!";
//                            request.setAttribute("MSG_Login", msg);
//                            request.getRequestDispatcher("login.jsp").forward(request, response);
//                        }    
                        Account accountLogin = new Account(id_account, number, password);
                        HttpSession session = request.getSession();
                        session.setAttribute("loginSession", accountLogin);
                        boolean activeStatus=accShipping.isActive_status();          //sửa Active Status trong model   
                        session.setAttribute("activeStatus",activeStatus); //sửa Active Status
                        String name = listShippers.get(0).getNameAccount();
                        session.setAttribute("name", name);
                        request.getRequestDispatcher("indexShipper.jsp").forward(request, response);
                    }
                }
            }
                    
                    
           
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
