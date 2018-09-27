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
 
    <title>Consulter Remarque</title>
    
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
   
     <div class="container custom-section custom-height">
       <h1><c:out value="${remarque.sujet }" /></h1>
       <hr>
       <div class="col-md-11">
         <p>
           <c:out value="${remarque.remarque }"/>
         </p>
         <br/><br/>
         <p><strong>Professeur : </strong> <c:out value="${remarque.professeur }"/></p>
         <p><strong>Eleve : </strong> <c:out value="${remarque.eleve }"/></p>
         <p><strong>Date : </strong> <c:out value="${remarque.date }"/></p>
       </div>
      
     </div>
   
   
     




    <!-- jQuery -->
    <script src="<c:url value="/resources/vendor/jquery/jquery.js" />"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.min.js" />"></script>
 </body>
</html>