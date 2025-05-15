<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello JSP!" %>
</h1>
<ul>
    <li><a href="table.jsp">Table JSP</a></li>
    <li><a href="tableform.jsp">Table Form JSP</a></li>

</ul>

<h2>Summe von Integers</h2>
<%
    int x = 5;
    int y = 10;

    int sum = x + y;

    out.println("The sum of " + x + " and " + y + " is: " + sum);
%>
 <h2> Zahlen von 1 bis 10</h2>
<%
    for (int i = 1; i <= 10; i++) {
        out.println("Number: " + i + "<br/>");
    }
%>

<br/>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>