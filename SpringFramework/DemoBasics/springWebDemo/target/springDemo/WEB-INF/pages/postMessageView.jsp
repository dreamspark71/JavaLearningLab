<%-- 
    Document   : postMessageView
    Created on : Nov 24, 2016, 9:12:58 PM
    Author     : richardmccarthy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Post message page</h1>
        <form:form method="POST" modelAttribute="formMessageValue" action="/springDemo/">
            <label>Message: </label>
            <form:input path="messageValue" />
            <input type="submit" value="Submit" />
        </form:form>
        
    </body>
</html>
