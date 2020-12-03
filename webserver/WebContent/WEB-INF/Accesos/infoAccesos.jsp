<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="logica.DataInfo"%>
<!DOCTYPE html>
<html>
<head>

	<jsp:include page="/WEB-INF/template/head.jsp"/>
	
</head>
<body>

<div class="custom-control custom-switch" style="margin-left:1em; display:none;">
  <input type="checkbox" class="custom-control-input" id="darkSwitch" />
  <label class="custom-control-label" for="darkSwitch"></label>
</div>
<script src="resources/js/dark-mode-switch.js"></script>



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