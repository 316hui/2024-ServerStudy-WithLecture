package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletInputStream inputStream = request.getInputStream(); //메세지 바디 내용을 바이트 코드로 얻음.
        String messeageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8); //byte를 문자로 변형할땐 인코딩 정보필수 (반대도)

        System.out.println("messeageBody = " + messeageBody);

        response.getWriter().write("ok");
    }
}
