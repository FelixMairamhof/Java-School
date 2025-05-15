<%@ page import="java.util.Random" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Table JSP</title>
</head>
<body>
<%
    int rows = 5; // Default value
    int cols = 8; // Default value

    try {
        String rowsParam = request.getParameter("rows");
        String colsParam = request.getParameter("cols");

        if (rowsParam != null) {
            rows = Integer.parseInt(rowsParam);
        }
        if (colsParam != null) {
            cols = Integer.parseInt(colsParam);
        }
    } catch (NumberFormatException e) {
        out.println("<p style='color:red;'>Invalid input for rows or columns. Using default values.</p>");
    }
%>
<h1>Table with <%= rows %> rows and <%= cols %> columns and random numbers between 10 and 99</h1>
<table border="1">
    <%
        Random random = new Random();
        for (int i = 1; i <= rows; i++) {
            out.println("<tr>");
            for (int j = 1; j <= cols; j++) {
                int number = random.nextInt(90) + 10;
                String color = (number % 2 == 0) ? "green" : "red";
                out.println("<td style='background-color:" + color + ";'>" + number + "</td>");
            }
            out.println("</tr>");
        }
    %>
</table>

<h1>
    <a href="tableform.jsp?rows=<%=rows%>&cols=<%=cols%>">Table Form JSP</a>
</h1>
</body>
</html>