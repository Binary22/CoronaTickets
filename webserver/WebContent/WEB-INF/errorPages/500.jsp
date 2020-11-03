<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page isErrorPage="true" %>
<!doctype html>
<html>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="error-template">
                <h1>Se rompio algo :/</h1>
                <h2>500 Not Found</h2>
                <div class="error-details">
                    <pre><%= exception.getClass().getName() %>: <%= exception.getMessage() %>
						<% for(StackTraceElement ste: exception.getStackTrace()){ %><%= ste.toString() %>
						<%}%>
					</pre>
                </div>
                <div class="error-actions">
                    <a href="home" class="btn btn-primary btn-lg">
                    	<span class="glyphicon glyphicon-home"></span>Inicio</a>
                </div>
            </div>
        </div>
    </div>
</div>
</html>

