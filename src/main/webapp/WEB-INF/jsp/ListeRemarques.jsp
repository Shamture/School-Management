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
 
    <title>Liste des Remarques</title>
    
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
       <h1>Liste des Remarque</h1>
       <hr>
       <div class="col-md-11">
         <div class="panel panel-primary">
          <div class="panel-heading">(<c:out value="${requestScope.numRemarque }" />) Nouvelles Remarques</div>
          <div class="panel-body">
           <table class="table">
             <tr>
               <th>Professeur</th>
               <th>Eleve</th>
               <th>Date</th>
               <th>Sujet</th>
               <th></th>
             </tr>
             <c:forEach items="${requestScope.remarques }" var="item">
              <c:choose>
                <c:when test="${item.vue==0 }">
                  <tr class="active">
                  <td><c:out value="${item.professeur }"/></td>
                  <td><c:out value="${item.eleve }"/></td>
                  <td><c:out value="${item.date }"/></td>
                  <td><c:out value="${item.sujet }"/></td>
                  <td> <a href="<c:url value="/parent/consulterRemarque/${item.id }" />" class="btn btn-link" target="_blank">Consulter</a> </td>
                  </tr>
                </c:when>
                <c:otherwise>
                  <tr>
                  <td><c:out value="${item.professeur }"/></td>
                  <td><c:out value="${item.eleve }"/></td>
                  <td><c:out value="${item.date }"/></td>
                  <td><c:out value="${item.sujet }"/></td>
                  <td> <a href="<c:url value="/parent/consulterRemarque/${item.id }" />" class="btn btn-link" target="_blank">Consulter</a> </td>
                  </tr>
                </c:otherwise>
              </c:choose>
               
             </c:forEach>
           </table>
          </div>
         </div>
          
       </div>
      
     </div>
   
   
     




    <!-- jQuery -->
    <script src="<c:url value="/resources/vendor/jquery/jquery.js" />"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.min.js" />"></script>
 </body>
</html>