<%@page contentType="text/html" import="java.util.Date"%>
<html>

  <head>

    <title>Aktualna data i czas</title>

  </head>

  <body>

<form action="MainServlet" method="POST">
<table>
<tr>
<td>Id : </td>
<td><input type="text" name="id"/> </td>
</tr><tr>
<td>Name : </td>
<td><input type="text" name="name"/></td>
</tr>
</table>
<input type="submit" value="Submit"/>
</form>
  </body>

</html>