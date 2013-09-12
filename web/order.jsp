<%-- 
    Document   : order
    Created on : Sep 11, 2013, 8:24:41 PM
    Author     : dsmith110
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order</title>
    </head>
    <body>
        <form id="orderForm" name="orderForm" action="MenuController" method="GET">
            <%
                
                <tr><td><input type='checkbox' name='item<%= i %>'/><%=menuItem[i]</td></tr>
                
            %>

        <input class="button" type="Submit" value="Order">
        </form>
    </body>
</html>
