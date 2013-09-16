<%-- 
    Document   : order
    Created on : Sep 11, 2013, 8:24:41 PM
    Author     : dsmith110
--%>

<%@page import="java.text.NumberFormat"%>
<%@page import="Model.MenuItem"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CssResources/homeCss.css">
        <title>Order</title>
    </head>
    <body>
        <form id="orderForm" name="orderForm" action="OrderController" method="GET">
            <table>
                <tr>
                    <td><img src="ImageResources/dans-restaurant_logo.gif"/></td>
                    <td><a id="a" href="index.html">Home</a></td>
                </tr>
            </table>
            <br/>
            <p id="tab">Menu</p>
            <table>
            <%
                NumberFormat nf = NumberFormat.getCurrencyInstance();
                List<MenuItem> menu = (List<MenuItem>) request.getAttribute("menuItems");
                int i = 0;
                
                for (MenuItem m : menu) {
                    out.println("<tr>");
                    out.println("<td><input type='checkbox' name='menuItem" + i + "'/>" + m.getName() + "</td><td> " + nf.format(m.getPrice()) + "</td>");
                    out.println("</tr>");
                    i++;
                }
            %>
            <tr><td></td><td><input class="button" type="Submit" value="Order"></td></tr>
            </table>
        
        
        </form>
    </body>
</html>
