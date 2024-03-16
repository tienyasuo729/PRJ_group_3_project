/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.example.demo112.controller;



import org.example.demo112.Impl.AccountUserImpl;
import org.example.demo112.QueryStatement.IRepository;
import org.example.demo112.model.Account;
import org.example.demo112.model.UserAccount;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author ASUS
 */
public class loginServlet extends HttpServlet {
private IRepository usimpl=new AccountUserImpl();
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
                request.setAttribute("MSG", msg);
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
                    if(listUsers==null){
                        String msg = "Sai Số điện thoại hoặc mật khẩu!";
                       request.setAttribute("MSG", msg);                        
                       request.getRequestDispatcher("login.jsp").forward(request, response);
                    } else{
                        HttpSession session = request.getSession();
                        session.setAttribute("loginSession", account);
                        String fistName=listUsers.get(0).getPeople().getFirstName();
                        String lastName=listUsers.get(0).getPeople().getLastName();
                        System.out.println(fistName);
                        String name = fistName + " " + lastName;
                        request.setAttribute("userName", name);
                        request.getRequestDispatcher("loginSuccess.jsp").forward(request, response);
                    }
                    
//                    HttpSession session = request.getSession();
//                    session.setAttribute("loginSession", account);
//                    AccountDB acc = new AccountDB();
//                    UserAccount a = acc.login(number, password);
//                    if (a == null) {
//                        String msg = "Sai Số điện thoại hoặc mật khẩu!";
//                        request.setAttribute("MSG", msg);
//                        request.getRequestDispatcher("login.jsp").forward(request, response);
//                    } else {
//                        String fistName = a.getPeople().getFirstName();
//                        String lastName = a.getPeople().getLastName();
//                        String name = fistName + " " + lastName;
//                        request.setAttribute("userName", name);
//                        request.getRequestDispatcher("loginSuccess.jsp").forward(request, response);
//                    }   
                    
                }else{
                  //phần đăng nhập của Shipper  
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
