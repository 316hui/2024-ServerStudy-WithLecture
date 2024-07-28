<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<!--/save.. 상대경로 사용중 -->
<form action="save" method="post">
    username: <input type="text" name="username"/>
    age:      <input type="text" name="age"/>
    <button type="submit">전송</button>
</form>
</body>
</html>



<!-- WEB-INF 디렉토리 밑 JSP파일들은 전부 서버를 통해야만 접근 할 수 있다.-->