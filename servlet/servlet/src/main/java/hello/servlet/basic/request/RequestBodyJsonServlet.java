package hello.servlet.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name= "requestBodyJsonServlet", urlPatterns= "/request-body-json")
public class RequestBodyJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper(); //spring 지원 jackson

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        System.out.println("messageBody = " + messageBody);
        HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
        //바이트코드로 값 읽음 -> 문자열로 변환 -> 잭슨으로 json 형식으로 변환 ==> 값은 롬북에 의해 자동으로 set

        System.out.println("helloData.username = " + helloData.getUsername());
        System.out.println("helloDataage = " + helloData.getAge());

        response.getWriter().write("ok");
    }

    //http form 처럼 바디에 값을 보내는것은 같음. key value로 보낼뿐.
}
