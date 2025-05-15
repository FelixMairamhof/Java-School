<%--
  Created by IntelliJ IDEA.
  User: feber
  Date: 15.05.2025
  Time: 09:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Table Form</title>
</head>
<body>

<form method="get" action="table.jsp">
    <label for="rows">Rows:</label>
    <input type="number" id="rows" name="rows" value="<%= request.getParameter("rows") != null ? request.getParameter("rows") : 5 %>" min="1"><br><br>

    <label for="cols">Columns:</label>
    <input type="number" id="cols" name="cols" value="<%= request.getParameter("cols") != null ? request.getParameter("cols") : 8 %>" min="1"><br><br>

    <input type="submit" value="Generate Table">
</form>

</body>
</html>
