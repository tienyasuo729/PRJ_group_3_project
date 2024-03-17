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
            String role = request.getParameter("role");
            if(role==null){
                //lỗi khi người dùng không chọn role
                String msg="vui lòng chọn user hoặc shipper";
                request.setAttribute("MSG_Login", msg);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }else{
                if("user".equals(role)){
                    //phần đăng nhập của User 
                    List<UserAccount> listUsers = new ArrayList<>();
                    String number = request.getParameter("number");
                    String password = request.getParameter("pass");
                    Account account = new Account(number, password);
                    UserAccount usAcc = new UserAccount(account);
                    listUsers=usimpl.find(usAcc);
                    if(listUsers.isEmpty()){
                        String msg = "Sai Số điện thoại hoặc mật khẩu!";
                       request.setAttribute("MSG_Login", msg);                        
                       request.getRequestDispatcher("login.jsp").forward(request, response);
                    } else{
                        HttpSession session = request.getSession();
                        
                        session.setAttribute("loginSession", account);
                        String fistName=listUsers.get(0).getPeople().getFirstName();
                        String lastName=listUsers.get(0).getPeople().getLastName();
                        String name = fistName + " " + lastName;
                        session.setAttribute("name", name);
//                        request.setAttribute("userName", name);
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    }
                                       
                }else{
                        //phần đăng nhập của Shiper
                      List<AccountShipping> listShippers = new ArrayList<>();
                      String number = request.getParameter("number");
                       String password = request.getParameter("pass");
                       Account account = new Account(number, password);
                       AccountShipping accShipping = new AccountShipping(account);
                       listShippers=shipimpl.find(accShipping);
                       if(listShippers.isEmpty()){
                           String msg = "Sai Số điện thoại hoặc mật khẩu!";
                           request.setAttribute("MSG_Login", msg);                        
                           request.getRequestDispatcher("login.jsp").forward(request, response);
                       }else{
                           HttpSession session = request.getSession();
                           session.setAttribute("loginSession", account);
                           String name =listShippers.get(0).getNameAccount();
                           session.setAttribute("name", name);
//                           request.setAttribute("userName", name);
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
