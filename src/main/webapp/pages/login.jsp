<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head><title>Login</title></head>
<body>
  <form:form action="userCheck" method="post">
   Enter User Name:<input id="name" type="text" name="name"> <br/>
   Enter Password :<input id="pwd" type="password" name="pwd"/><br/>
   <input type="submit" id="submit">
   
  </form:form>
</body>
</html>