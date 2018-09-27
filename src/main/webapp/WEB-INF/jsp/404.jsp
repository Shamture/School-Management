<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib	prefix="c"	uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
<title>Page non trouvé</title>
     <!-- Bootstrap Core CSS -->
    <link href="<c:url value="/resources/vendor/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<c:url value="/resources/css/my-style.css" />" rel="stylesheet">
    
</head>
<body id="body-404">
 
 <div class="container">
 
   <h1>404 <small> Page non trouvé</small></h1>
   <p><img src="<c:url value="/resources/img/404.png" />" alt="404" width=400/></p>
   <p>La page que vous rechercher n'existe pas ou vous n'êtes pas autorisé à l'accéder.
   <a href="<c:url value="/" />">Retourner a l'accueil</a></p>
 </div>
 
 
 
 
  <!-- jQuery -->
    <script src="<c:url value="/resources/vendor/jquery/jquery.js" />"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.min.js" />"></script>
 
</body>
</html>