<html>

<body bgcolor="green">

<jsp:useBean id="s1" class="com.example.Student">

<jsp:setProperty name="s1" property="*"/>

</jsp:useBean>

<p>Rollno <%=s1.getRollno() %></p>

<p>Name <jsp:getProperty property="name" name="s1"/>

<p>Branch <jsp:getProperty property="branch" name="s1"/>

</body>

</html>

