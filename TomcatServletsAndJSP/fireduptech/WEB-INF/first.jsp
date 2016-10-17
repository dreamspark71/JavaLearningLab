<html>
<head><titlr>My First JSP</title></head>
<body>
  <%
    double num = Math.random();
    if ( num > 0.95 ) {
  %>
    <h2>The number is greater than 0.95</h2><p>(<%= num %>)</p>
  <%
  } else {
  %>
    <h2>The number was less than 0.95</h2><p>(<%= num %>)</p>
  <%
  }
  %>
  <a href="<%= request.getRequestURI() %>"><h3>Try Again</h3></a> 
</body>
</html>
