<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Login</title>
    </head>
    <body>
        <h1>Admin Login</h1>
        <form name="dataForm" action="adminLoginServlet">
            <input type="text" name="adminId" />
            <input type="text" name="adminPassword" />
            <button type="submit">LOGIN</button>
            
        </form>
    </body>
</html>
