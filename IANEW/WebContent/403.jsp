<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Access Denied</title>
    </head>
    <body>
    	<h1>You do not have privilege to do this!</h1>
        <h2>Access Denied for ${pageContext.request.userPrincipal.name}!!!</h2>
        <!-- <a href="login.jsp">Back</a> -->
    </body>
</html>