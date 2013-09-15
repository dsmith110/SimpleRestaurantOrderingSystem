<%-- 
    Document   : reciept
    Created on : Sep 13, 2013, 2:49:52 PM
    Author     : bit
--%>

<%@page import="java.text.NumberFormat"%>
<%@page import="Model.MenuItem"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order</title>
    </head>
    <body>
        <table>
        <%
            NumberFormat nf = NumberFormat.getCurrencyInstance();
            List<MenuItem> menu = (List<MenuItem>) request.getAttribute("order");
            
                for (MenuItem m : menu) {
                    out.println("<tr>");
                    out.println("<td>" + m.getName() + "</td><td>" + m.getPrice() + "</td>" );
                    out.println("</tr>");
                }
            %>
        </table>
        <br/>
        <br/>
        <table>
            <tr><td>Subtotal: </td><td>${total}</td></tr>
            <tr><td>Tax: </td><td>${tax}</td></tr>
            <tr><td>Suggested Gratuity: </td><td>${gratuity}</td></tr>
            <tr><td></td><td><hr/></td></tr>
            <tr><td>Total: </td><td>${subtotal}</td></tr>
        </table>
    </body>
</html>
