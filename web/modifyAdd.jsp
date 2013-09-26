<%-- 
    Document   : modifyAdd
    Created on : Sep 25, 2013, 12:24:41 PM
    Author     : bit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <table>
            <tr>
                <td>ID</td><td>${id}</td>
            </tr>
            <tr>
                <td>Name</td><td><input type="text" value='${name}' size="35"></td>
            </tr>
            <tr>
                <td>Price</td><td><input type="text" value='${price}'></td>
            </tr>
            <tr>
                <td><input type="submit" value="Modify"></td>
            </tr>
            
        </table>
    </body>
</html>
