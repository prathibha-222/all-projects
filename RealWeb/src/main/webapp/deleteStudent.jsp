
<%@page import="com.example.dao.EmployeeDao"%>
<html>
<body bgcolor="pink">
<%
int rollno=Integer.parseInt(request.getParameter("rollno"));
out.println(EmployeeDao.deletestudent(rollno)+" record deleted successfully...");
%>
</body>
</html>