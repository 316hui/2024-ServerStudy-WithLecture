package hello.servlet.web.servlet.servletmvc;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "mvcMemberFormServelet", urlPatterns = "/servelet-mvc/members/new-form")
public class MvcMemberFormServelet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewPath = "WEB-INF/views/new-form.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath); //컨트롤러에서 뷰로 이동할 때 사용
        dispatcher.forward(request, response); //>>서버끼리<< 다시호출
    }
}
