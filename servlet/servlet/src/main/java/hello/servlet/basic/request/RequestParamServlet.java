package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/*
* 파라미터 전송 기능
* http://localhost:8080/request-param?username=hello&age=20
* */
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("[전체 파라미터 조회] - start");
        request.getParameterNames().asIterator()
                        .forEachRemaining(paramName -> System.out.println(paramName + "= " + request.getParameter(paramName)));

        System.out.println("[전체 파라미터 조회] - end");
        //request.getParameterNames(); //모든 요청 파라미터

        System.out.println("[단일 파라미터 조회]");
        String username = request.getParameter("username");
        String age = request.getParameter("age");

        System.out.println("username = " + username);
        System.out.println("age = " + age);

        System.out.println("[이름이 같은 복수 파라미터 조회]");
        String[] usernames = request.getParameterValues("username"); //getParameterValues, 한 파라미터에 중복값 넣을 수 있음.
        for (String name : usernames) {
            System.out.println("username = " + name);
        }

        response.getWriter().write("ok");
    }
}
