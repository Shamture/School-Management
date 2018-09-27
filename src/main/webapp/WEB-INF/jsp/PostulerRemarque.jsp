<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@	taglib	prefix="c"	uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
 <head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
 
    <title>Postuler Remarque</title>
    
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
                   <li><a href="<c:url value="/prof/selectionner_classe"/>">Liste eleves</a></li>
                  
                   <li><a href="<c:url value="/prof/choisir_groupe"/>">Inserer Notes</a></li>            
                  </ul>
                </li>
                <li><a href="<c:url value="/"/>">Cahier de texte</a> </li>
                <li><a href="<c:url value="/prof/contact"/>">Contact</a></li>
                <li><a href="<c:url value="/logout"/>">Deconnecter</a></li>
            </ul>
        </div>
    </div>
  </div>
  <!-- Navbar end -->
   
     <div class="container custom-section">
       <h1>Postuler Remarque</h1>
       <hr>
       <div class="row">
         <div class="col-md-6">
          <c:if test="${requestScope.added=='true' }">
            <div class="alert alert-success" role="alert">Remarque postulé avec success</div>
          </c:if>
          <c:if test="${requestScope.added=='false' }">
            <div class="alert alert-danger" role="alert">Une erreur s'est produite !</div>
          </c:if>
         
         </div>
         </div>
         <div class="row">
         <br/>
         <div class="col-md-6" id="res">
            <p>
              <span class="sous-titre">Code Eleve :</span> <small> <c:out value="${eleve.code }" /> </small> <br/>
              <span class="sous-titre">Nom :</span> <small> <c:out value="${eleve.nom }" /> </small> <br/>
              <span class="sous-titre">Prenom :</span> <small> <c:out value="${eleve.prenom }" /> </small> <br/>
              <span class="sous-titre">Date Naissance :</span> <small> <c:out value="${eleve.dateNaissance }" /> </small> <br/>           
            </p>
         </div>
       </div>
       <br/><br/>
       <div class="row">
         <form  method="post" action="" name="add-absence-form" id="add-absence">
           <input type="text" name="idEleve" class="hidden" id="idEleve" value="${eleve.idEleve }"/>
           
           
           <div class="form-group">
             <label>Sujet</label>
             <input type="text" name="sujet" class="form-control" placeHolder="Sujet" value="${param.sujet }"/>
           </div>
           <div class="form-group">
             <label>Remarque</label>
             <textarea rows="5" class="form-control" name="texte" required>${param.texte }</textarea>
           </div>
           
           <input type="submit" class="btn btn-primary" value="Postuler" /> 
         </form>
       </div>
       
     </div>
   
    
    <!-- jQuery -->
    <script src="<c:url value="/resources/vendor/jquery/jquery.js" />"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.min.js" />"></script>
    
    
    
    
   
    
     
 </body>
</html>