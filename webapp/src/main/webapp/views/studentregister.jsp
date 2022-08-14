<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div align="center">
  <h1>Employee Register Form</h1>
  <form action="<%= request.getContextPath() %>/register" method="post">
   <table style="with: 80%">
    <tr>
     <td>enter id</td>
     <td><input type="text" name="id" /></td>
    </tr>
    <tr>
     <td>enter name</td>
     <td><input type="text" name="name" /></td>
    </tr>
    <tr>
     <td>subject</td>
     <td><input type="text" name="subject" /></td>
    </tr>
    <tr>
     <td>assignment category</td>
     <td><input type="text" name="asscat" /></td>
    </tr>
    <tr>
     <td>Date in y-m-d</td>
     <td><input type="text" name="date" /></td>
    </tr>
    <tr>
     <td>points</td>
     <td><input type="text" name="points" /></td>
    </tr>
   </table>
   <input type="submit" value="Submit" />
  </form>
 </div>

</body>
</html>