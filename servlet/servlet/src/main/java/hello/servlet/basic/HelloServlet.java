package hello.servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.rmi.server.ServerCloneException;


@WebServlet(name = "helloServlet", urlPatterns = "/hello") //name, pattern 겹치면 안됌.
public class HelloServlet extends HttpServlet {


    //servlet 이 호출되면 서비스 메서드가 호출
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HelloServletRequest.service");

        String name = request.getParameter("username");
        System.out.println("username = " + name);

        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("hello" + name);
    }
}
