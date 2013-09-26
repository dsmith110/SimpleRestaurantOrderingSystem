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
                List<MenuItem> menu = (List<MenuItem>) request.getAttribute("menuItems");
                int i = 0;
                
                for (MenuItem m : menu) {
                    out.println("<tr>");
                    out.println("<td><input type='checkbox' name='menuItem" + i +
                            "'/></td><td>" + m.getName() + "</td><td> " + 
                            (m.getPrice()) + 
                            "</td><td><input type='submit' value='Modify' action='adminController?action=modify&id='" + m.getId() + 
                            "'></td><td><input type='submit' value='delete' action='DataControlleraction=delete&id='" + m.getId() 
                            + "'></td>" );
                    out.println("</tr>");
                    i++;
                }
            %>
            
            </table>
            
            <br/>
            
            <input class="button" type="Submit" value="Add" action="DataController">
            
            <br/>
            <br/>
            <a id="a" href="index.html">Home</a>   
        
        
    </body>
</html>
