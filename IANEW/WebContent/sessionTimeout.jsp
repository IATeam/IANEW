<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Session Time Out</title>
    </head>
    <body>
        <h1>Session Time Out ${pageContext.request.userPrincipal.name}!!!</h1>
        <a href="login.jsp">Back</a>
    </body>
</html>