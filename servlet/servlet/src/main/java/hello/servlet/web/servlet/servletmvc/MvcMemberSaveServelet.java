package hello.servlet.web.servlet.servletmvc;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "mvcMemberSaveServelet", urlPatterns = "/servelet-mvc/members/save")
public class MvcMemberSaveServelet extends HttpServlet {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age")); //getParameter는 항상 String

        Member member = new Member(username, age);
        memberRepository.save(member);

        //model에 데이터를 보관한다.
        request.setAttribute("member", member); //request 에 저장공간이 있음!
        
    }
}
