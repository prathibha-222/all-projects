
<%@page import="com.example.dao.EmployeeDao" %>
<%@page import="com.example.bean.EmployeeBean" %>
<%@page import="java.util.ArrayList" %>
<html>
<body bgcolor="green">
<%
ArrayList<EmployeeBean> allstudents =EmployeeDao.selectAll();
%>
<table border="4">
<tr><th>Rollno</th><th>Name</th><th>Branch</th></tr>
<%
for(EmployeeBean sb:allStudent) {
%>
<tr><td><%=sb.getRollno() %></td><td><%=sb.getName() %></td><td><%=sb.getBranch() %></td></tr>
<%} %>
</table>
</body>
</html>