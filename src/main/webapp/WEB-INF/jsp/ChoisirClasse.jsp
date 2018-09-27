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
 
    <title>Choisir classe</title>
    
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
   
     <div class="container custom-section custom-height">
       
       <div class="col-md-11">
         <form method="get" action="<c:url value="/prof/inserer_notes"/>">
         	<div class="form-group">
         	<label>Groupe</label>
         	<select name="classe" class="form-control">
         	  <c:forEach items="${requestScope.listGroups }" var="item">
         	    <option value="<c:out value="${item.id }" />" ><c:out value="${item.niveau }" /> Groupe <c:out value="${item.nom }" /></option>
         	  </c:forEach>
         	</select>
         	</div>
         	<div class="form-group">
         	<label>Matiere</label>
         	<select name="matiere" class="form-control">
         	  <c:forEach items="${requestScope.listMatieres}" var="item" varStatus="status">
         	    <option value="<c:out value="${item.id }" />" ><c:out value="${item.nom }" /></option>
         	  </c:forEach>
         	</select>
         	</div>
         	<div class="form-group">
         	<label>Note</label>
         	<select name="type" class="form-control">
         	 <option value="Devoir Surveillé">Devoir Surveillé</option>
         	 <option value="Orale">Orale</option>
         	 <option value="Examen">Examen</option>
         	</select>
         	</div>
            <input type="submit" value="Valider" class="btn btn-primary" />
         </form>
       </div>
      
     </div>
   
   
     




    <!-- jQuery -->
    <script src="<c:url value="/resources/vendor/jquery/jquery.js" />"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.min.js" />"></script>
 </body>
</html>