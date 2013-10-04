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
        
        
            
            <p id="italic">Select item you want to modify</p><br/>
            
            <table class="tableBorder">
                
            <%
                List<MenuItem> menu = (List<MenuItem>) session.getAttribute("menuItems");
                                
                for (MenuItem m : menu) {
                    out.println("<tr>");
                    out.println("</td><td>" + m.getName() + "</td><td> " + 
                            (m.getPrice()) + 
                            "</td><td><a href='AdminController?formAction=modify&id=" + m.getId() + "'/>Modify</a>" +
                            "</td><td><a href='AdminController?formAction=delete&id=" + m.getId() + "'/>Delete</a>" 
                            + "</td>" );
                    out.println("</tr>");
                    
                }
            %>
            
            </table>
            
            <br/>
            <a href="AdminController?formAction=add">Add</a>
            
            
            <br/>
            <br/>
            <a id="a" href="index.html">Home</a>   
        
        
    </body>
</html>
