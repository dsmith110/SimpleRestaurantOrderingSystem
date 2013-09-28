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
        
        <form action="DataController">
        <table>
            ${item}
            <tr>
                <td>ID</td><td><input type="text" id="itemId" name="id" value="${id}" readonly></td>
            </tr>
            <tr>
                <td>Name</td><td><input type="text" id="itemName" name="name" value="${name}"></td>
            </tr>
            <tr>
                <td>Price</td><td><input type="text" id="itemPrice" name="price" value="${price}"></td>
                
            </tr>
            <tr>
                <td><input type="Submit" value="Save"></td>
            </tr> 
        </table>
        </form>
    </body>
</html>
