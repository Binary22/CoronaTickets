<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="logica.DataInfo"%>
<!DOCTYPE html>
<html>
<head>

	<title>Registro de accesos:</title>

	<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
	<link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="resources/css/colorFlecha.css">


</head>
<body>
<table class="table table-bordered">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">IP</th>
      <th scope="col">URL</th>
      <th scope="col">Browser</th>
      <th scope="col">SO</th>
    </tr>
  </thead>
 
  
   
   <%ArrayList<DataInfo> informacion = (ArrayList<DataInfo>)session.getAttribute("dataInformacion");%>
   <%int i; %>
   <%for(i=0; i < informacion.size(); i++){%>
   <tbody>
    <tr>
      <th scope="row"><%=i%></th>
      <td><%=informacion.get(i).getIp()%></td>
      <td><%=informacion.get(i).getURL()%></td>
      <td><%=informacion.get(i).getNavegador()%></td>
      <td><%=informacion.get(i).getSO()%></td>
    </tr>
    <%}%>
  </tbody>
</table>
</body>
</html>