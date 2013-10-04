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
        <link rel="stylesheet" type="text/css" href="CssResources/homeCss.css">
        <title>Receipt</title>
    </head>
    <body>
        <img class="logo" src="ImageResources/dans-restaurant_logo.gif"/>
        
        <br/>
            <p id="tab">Receipt</p>
        
        <table>
        <%
            NumberFormat nf = NumberFormat.getCurrencyInstance();
            List<MenuItem> menu = (List<MenuItem>) session.getAttribute("order");
            
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
        <hr/>
        <br/>
        <br/>
        <p>If you have any questions regarding your order please call ${phone}</p>
        <a id="a" href="index.html">Home</a> 
        
    </body>
</html>
