<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html><head><title>Books</title></head><body>
<h1>Available Books</h1>
<c:forEach var="b" items="${books}">
  <div>
    <h2><a href="book?id=${b.id}">${b.title}</a></h2>
    <p>Author: ${b.author}, Price: ₹${b.price}</p>
  </div>
</c:forEach>
</body></html>
