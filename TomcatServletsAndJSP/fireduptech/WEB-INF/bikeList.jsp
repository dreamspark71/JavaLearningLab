<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


HAD TO ADD THE mysql-connector-java-5.1.39-bin.jar TO THE WEB-INF/LIB DIRECTORY ALSO AND THEN IT ALL WORKED!




NEXT ITEM IS TO CODE UP A SERVLET VERSION OF THIS AS SHOWN IN:
http://www.codejava.net/servers/tomcat/configuring-jndi-datasource-for-database-connection-pooling-in-tomcat





<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     
<sql:query var="listBikes" dataSource="jdbc/JavaTomcatClassroomDB">
    select name, price from bike;
</sql:query>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Users List</title>
</head>
<body>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of bikes</h2></caption>
            <tr>
                <th>Name</th>
                <th>Price</th>
            </tr>
            <c:forEach var="bike" items="${listBikes.rows}">
                <tr>
                    <td><c:out value="${bike.name}" /></td>
                    <td><c:out value="${bike.price}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
