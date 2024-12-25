<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<%@ page import="java.util.*,com.model.Request" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Data</title>
<style>
table {
    border-collapse: collapse;
    width: 100%;
}
th, td {
    border: 1px solid #d2d0d0;
    padding: 8px;
    text-align: center;
}

th {
    background-color:#d2d0d0;
}
input[type="submit"] {
    background-color: #a8ada9; 
    padding: 10px 20px;
    border: none;
    margin-left:40%;
    border-radius: 3px;
}
#hi{
 position:absolute;
 right:1;
 }
</style>
</head>
<body>
<% 
    if(session.getAttribute("name")==null){
    	response.sendRedirect("login");
    }
     ArrayList<Request> data=(ArrayList<Request>) session.getAttribute("requests");
%>
<form action="logout" id="hi" >
<input type=submit value="Logout">
</form>
<br><br>
<h2>Active Data</h2>
    <table border="1">
    <tr>
    <th>ID</th>
    <th>NAME</th>
    <th>EMAIL</th>
    <th>MESSAGE</th>
    <th>TIME STAMP</th>
    <th>Is Active</th>
    </tr>
    <tbody>
      <% for (Request requestData : data) { %>
       <%
       if(requestData.isActive()) {
       %>
            <tr>
                <td><%=requestData.getId()%>
                <td><%=requestData.getName()%></td>
                <td><%=requestData.getEmail()%></td>
                <td><%=requestData.getMessage()%></td>
                <td><%=requestData.getTimestamp()%></td>
                <td>
                <form action="dashboard" method="post">
                <input type="hidden" name="requestId" value="<%=requestData.getId()%>">
                <input type="hidden" name="status" value="<%=requestData.isActive()%>">
                <input type="submit" value="Archive">
                </form>
               </td>
            </tr>
        <%
        } }
        %>
    </tbody>
    </table>
   <h2>Archive Data</h2>
     <table border="1">
    <tr>
    <th>ID</th>
    <th>NAME</th>
    <th>EMAIL</th>
    <th>MESSAGE</th>
    <th>TIME STAMP</th>
    <th>Is Active</th>
    </tr>
    <tbody>
      <%
      for (Request requestData : data) {
      %>
      <%
      if(requestData.isActive()!= true){
      %>
            <tr>
                <td><%=requestData.getId()%>
                <td><%=requestData.getName()%></td>
                <td><%=requestData.getEmail()%></td>
                <td><%=requestData.getMessage()%></td>
                <td><%=requestData.getTimestamp()%></td>
                <td><form action="dashboard" method="post">
                <input type="hidden" name="requestId" value="<%=requestData.getId()%>">
                <input type="hidden" name="status" value="<%=requestData.isActive()%>">
                <input type="submit" value="Active">
                </form></td>
            </tr>
        <%} } %>
    </tbody>
    </table>
</body>
</html>