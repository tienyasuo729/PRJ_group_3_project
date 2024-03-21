package org.example.shipping_services_for_everyone.controller;

import org.example.shipping_services_for_everyone.model.Account;
import org.example.shipping_services_for_everyone.model.AccountShipping;
import org.example.shipping_services_for_everyone.model.UserAccount;
import org.example.shipping_services_for_everyone.repository.IRepository;
import org.example.shipping_services_for_everyone.repository.Impl.AccountShippingRepositoryImpl;
import org.example.shipping_services_for_everyone.repository.Impl.UserAccountRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "loginServlet", value = "/loginServlet")
public class loginServlet extends HttpServlet {
    private IRepository usimpl=new UserAccountRepositoryImpl();
    private IRepository shipimpl= new AccountShippingRepositoryImpl();

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
                    Account accountLogin = new Account(id_account, number, password);
                    HttpSession session = request.getSession();
                    session.setAttribute("loginSession", accountLogin);
                    String name = listShippers.get(0).getNameAccount();
                    session.setAttribute("name", name);
                    request.getRequestDispatcher("indexShipper.jsp").forward(request, response);
                }
            }
        }



    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
