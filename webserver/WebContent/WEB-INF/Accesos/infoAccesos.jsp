<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="logica.DataInfo"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro de accesos:</title>
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
  <tbody>
    <tr>
   
   <%ArrayList<DataInfo> informacion = (ArrayList<DataInfo>)session.getAttribute("dataInformacion");%>
   <%int i; %>
   <%for(i=0; i < informacion.size(); i++){%>
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