<%@page import="java.util.Date" %>
<html>
<body bgcolor="yellow">

<%Date d= new Date(); 
out.println(d.getDate()+" / "+(d.getMonth()+1) + " / " + (d.getYear() + 1900)); %>
<br/>
<%out.println(d.getHours()+" : "+d.getMinutes() + " : " + d.getSeconds()); %>


</body>
</html>