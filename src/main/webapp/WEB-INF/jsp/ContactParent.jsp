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
 
    <title>Contact</title>
    
     <!-- Bootstrap Core CSS -->
    <link href="<c:url value="/resources/vendor/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<c:url value="/resources/css/my-style.css" />" rel="stylesheet">
   
    <!-- Custom Fonts -->
    <link href="<c:url value="/resources/vendor/font-awesome/css/font-awesome.min.css" />" rel="stylesheet" type="text/css">
 </head>
 <!-- Navbar begin -->
 <body class="school-bg">
  <div id="custom-bootstrap-menu" class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container-fluid">
       <div class="navbar-header"><a class="navbar-brand" href="<c:url value="/"/>"><img src="<c:url value="/resources/img/logo.png" />" alt="ESchool" height="30px" id="logo" /></a>
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-menubuilder"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>
            </button>
        </div>
        <div class="collapse navbar-collapse navbar-menubuilder">
            <ul class="nav navbar-nav navbar-left">
                <li class="dropdown">
                 <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                  Eleve <span class="caret"></span>
                 </a>
                  <ul class="dropdown-menu">
                   <li><a href="<c:url value="/parent/liste_remarque"/>">Liste des remarques (<c:out value="${requestScope.numRemarque }" />)</a></li>
                   <li><a href="<c:url value="/parent/liste_absence"/>">Liste des absences (<c:out value="${requestScope.numAbsence }" />)</a></li>
                   <li><a href="<c:url value="/parent/liste_notes"/>">Notes</a></li>
                   <li><a href="<c:url value="/parent/emploi"/>">Emploi</a></li>            
                  </ul>
                </li>
                <li><a href="<c:url value="/parent/contact"/>">Contact</a></li>
                <li><a href="<c:url value="/logout"/>">Deconnecter</a></li>
            </ul>
        </div>
    </div>
  </div>
  <!-- Navbar end -->
   
     <div class="container custom-section">
       <h1>Contactez Nous</h1>
       <hr>
       <div class="col-md-6">
         <c:if test="${requestScope.sent=='true' }">
            <div class="alert alert-success" role="alert">Message envoyé , vous aurez la reponse le plus tôt possible sur votre boite email.</div>
         </c:if>
         <c:if test="${requestScope.sent=='false' }">
            <div class="alert alert-danger" role="alert">Une erreur s'est produite !</div>
         </c:if>
          <form method="post" action="">
            <div class="form-group">
              <label>Sujet</label>
              <input type="text" name="sujet" value="${param.sujet}" class="form-control" placeHolder="Sujet" />
            </div>
            <div class="form-group">
              <label>Message</label>
              <textarea rows="6" cols="40" class="form-control" name="message"></textarea>
            </div>
            <input type="submit" value="Envoyer" class="btn btn-primary" />
          </form>
       </div>
      
     </div>
   
    <!-- jQuery -->
    <script src="<c:url value="/resources/vendor/jquery/jquery.js" />"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.min.js" />"></script>
 </body>
</html>