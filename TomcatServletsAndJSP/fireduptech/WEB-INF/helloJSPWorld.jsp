<html>
<head><titlr>Hello JSP World!/title></head>
<%@ page import="java.util.Date" %>
<body>

  <h2>Hello JSP World!</h2>
  <strong>The current time is:</strong> <%= new Date() %>
  <a href="<%= request.getRequestURI() %>"><h3>Try Again</h3></a> 

  The Init Param value for this URL mapping ( <%= request.getRequestURI() %>) is: <%= config.getInitParameter("paramMessage") %>

  <%-- This is a JSP comment --%>

</body>
</html>
