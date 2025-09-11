<%--
  Created by IntelliJ IDEA.
  User: feber
  Date: 22.05.2025
  Time: 08:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Resistor Calculation</title>
</head>
<body>

<h1>Resistor Calculation</h1>
<form method="post" action="resistorResult.jsp">
    <label for="resistor1">Resistor 1 (Ω):</label>
    <input type="number" id="resistor1" name="resistor1" step="0.01" required><br><br>

    <label for="resistor2">Resistor 2 (Ω):</label>
    <input type="number" id="resistor2" name="resistor2" step="0.01" required><br><br>

    <label for="resistor3">Resistor 3 (Ω):</label>
    <input type="number" id="resistor3" name="resistor3" step="0.01" required><br><br>

    <button type="submit" name="calculationType" value="serial">Calculate Serial</button>
    <button type="submit" name="calculationType" value="parallel">Calculate Parallel</button>
</form>
</body>
</html>
