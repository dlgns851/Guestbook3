<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <%String no2=request.getParameter("no2"); %> --%>
<form action="delete?no2=<%=request.getParameter("no2")%>" method="post">
비밀번호 <input type="password" name="password"><input type="submit" value="확인"><br>
<a href="list">메인으로 돌아가기</a>



</form>

</body>
</html>