<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.text.DecimalFormat" %>
<html>
<head>
    <title>Resistor Result</title>
</head>
<body>
<%
    double r1 = Double.parseDouble(request.getParameter("resistor1"));
    double r2 = Double.parseDouble(request.getParameter("resistor2"));
    double r3 = Double.parseDouble(request.getParameter("resistor3"));
    String calculationType = request.getParameter("calculationType");

    double totalResistance = 0.0;
    if ("serial".equals(calculationType)) {
        totalResistance = r1 + r2 + r3;
    } else if ("parallel".equals(calculationType)) {
        totalResistance = 1 / (1 / r1 + 1 / r2 + 1 / r3);
    }

    DecimalFormat df = new DecimalFormat("#.##");
%>
<h1>Resistor Calculation Result</h1>

<p>Resistor 1: <%= df.format(r1) %> Ω</p>
<p>Resistor 2: <%= df.format(r2) %> Ω</p>
<p>Resistor 3: <%= df.format(r3) %> Ω</p>
<p>Calculation Type: <%= calculationType.equals("serial") ? "Series" : "Parallel" %></p>

<p>Total Resistance: <%= df.format(totalResistance) %> Ω</p>

<h2>Current (I) for Voltages from 0V to 10V</h2>
<table>
    <tr>
        <th>Voltage (V)</th>
        <th>Current (I) (A)</th>
    </tr>
    <%
        for (int voltage = 0; voltage <= 10; voltage++) {
            double current = voltage / totalResistance;
    %>
    <tr>
        <td><%= voltage %></td>
        <td><%= df.format(current) %></td>
    </tr>
    <% } %>
</table>

<br>
<a href="resistorCalculation.jsp">Back to Form</a>
</body>
</html>