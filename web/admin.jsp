<%-- 
    Document   : admin
    Created on : Sep 25, 2013, 10:45:09 AM
    Author     : bit
--%>

<%@page import="Model.MenuItem"%>
<%@page import="java.util.List"%>
<%@page import="java.text.NumberFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CssResources/homeCss.css">
        <title>Administration</title>
    </head>
    <body>
        
        <form id="orderForm" name="orderForm" action="AdminController" method="GET">
            
            <p id="italic">Select item you want to modify</p><br/>
            
            <table class="tableBorder">
                
            <%
                List<MenuItem> menu = (List<MenuItem>) request.getAttribute("menuItems");
                int i = 0;
                
                for (MenuItem m : menu) {
                    out.println("<tr>");
                    out.println("<td><input type='checkbox' name='menuItem" + i + "'/></td><td>" + m.getName() + "</td><td> " + (m.getPrice()) + "</td>");
                    out.println("</tr>");
                    i++;
                }
            %>
            
            </table>
            
            <br/>
            <form action="AdminController?id=modifyAdd">
                <input class="button" type="Submit" value="Modify/Add"> 
            </form>
            
            <form action="AdminController?id=delete">
                <input class="button" type="Submit" value="Delete">
            </form>
            <br/>
            <br/>
            <a id="a" href="index.html">Home</a>   
        
        </form>
    </body>
</html>
