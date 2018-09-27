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
 
    <title>Postuler Absence</title>
    
     <!-- Bootstrap Core CSS -->
    <link href="<c:url value="/resources/vendor/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<c:url value="/resources/css/my-style.css" />" rel="stylesheet">
    
     <!-- DatePicker CSS -->
    <link href="<c:url value="/resources/css/datepicker.css" />" rel="stylesheet">
   
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
       <h1>Postuler Absence</h1>
       <hr>
       <c:if test="${requestScope.added=='true' }">
            <div class="alert alert-success" role="alert">Absence postulé avec success</div>
          </c:if>
          <c:if test="${requestScope.added=='false' }">
            <div class="alert alert-danger" role="alert">Une erreur s'est produite !</div>
          </c:if>
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
       </div>
       <br/><br/>
       <div class="row">
       <div class="col-md-8 ">
         <form  method="post" action="" name="add-absence-form" id="add-absence">
           <input type="text" name="idEleve" class="hidden" id="idEleve" value="${eleve.code }"/>
           <div class="form-group">
             <label>Date Absence</label>
             <input type="text" name="date" id="date" class="form-control" placeHolder="Date Absence" required="required"/>
           </div>
           <div class="form-group">
             <label>Matiere</label>
             <select name="matiere" class="form-control">
               <c:forEach items="${requestScope.matieres }" var="item">
                 <option value="${item.id }">${item.nom }</option>
               </c:forEach>
             </select>
           </div>
           <input type="submit" class="btn btn-primary" value="Postuler" /> 
           <br/><br/><br/>
         </form>
         </div>
       </div>
       
   
   
    
    <!-- jQuery -->
    <script src="<c:url value="/resources/vendor/jquery/jquery.js" />"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.min.js" />"></script>
    
    <script src="<c:url value="/resources/js/bootstrap-datepicker.js" />"></script>
    
    
    <script type="text/javascript">
            $(function () {
            	
                $('#date').datepicker({
                    format: 'yyyy-mm-dd'
                });
                
                $('#search-eleve').submit(function(event) {
                  $('#res').html(" ");
                  $('#res').css('display','none');
                  $('#add-absence').css('display','none');
              	  event.preventDefault();
              	  var code = $('#code-eleve').val();
              	  $.ajax({
                    url : 'chercher_etudiant?code='+code,
                    success : function(data) {
                    	if(data=='erreur'){
                    		$('#res').html("<br/><p class='text-danger'>Code invalide</p>");
                    		$('#res').css('display','block');
                    	}else{
                    		$('#res').html(data);
                            $('#res').css('display','block');
                            $('#add-absence').css('display','block');
                            var id = $('#id-e').html();                           
                            $('#idEleve').val(id);
                    	}
                        
                    }
                  });
                });
            });
    </script>
    
     
 </body>
</html>