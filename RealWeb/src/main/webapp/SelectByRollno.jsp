

<%@page import="com.example.bean.EmployeeBean" %>
<%@page import="com.example.dao.EmployeeDao" %>

<html>
<body bgcolor="yellow">
<%
int rollno=Integer.parseInt(request.getParameter("rollno"));
EmployeeBean sb=EmployeeDao.selectByRollno(rollno);
%>
<table border="4">
<tr><th>Rollno</th><th>Name</th><th>Branch</th></tr>
<tr><td><%=sb.getRollno() %></td><td><%=sb.getName() %></td><td><%=sb.getBranch() %></td></tr>
</table>

</body>
</html>