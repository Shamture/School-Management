<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib	prefix="c"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Admin - Modification Eleve</title>

    <!-- Bootstrap Core CSS -->
    <link href="<c:url value="/resources/vendor/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<c:url value="/resources/css/sb-admin.css" />" rel="stylesheet">
     <!-- DatePicker CSS -->
    <link href="<c:url value="/resources/css/datepicker.css" />" rel="stylesheet">
    

    <!-- Custom Fonts -->
    <link href="<c:url value="/resources/vendor/font-awesome/css/font-awesome.min.css" />" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="<c:url value="/" />"> <img src="<c:url value="/resources/img/logo.png"/>" width=100 /> </a>
            </div>
            <!-- Top Menu Items -->
            <ul class="nav navbar-right top-nav">
                 
                 
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> <c:out value="${sessionScope.nom }"/> <c:out value="${sessionScope.prenom }"/><b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="#"><i class="fa fa-fw fa-user"></i> Profile</a>
                        </li>
                        
                        <li>
                            <a href="#"><i class="fa fa-fw fa-gear"></i> Parametres</a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="<c:url value="/logout" />"><i class="fa fa-fw fa-power-off"></i> Deconnecter</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#demo-eleve"><i class="fa  fa-fw fa-users"></i> Eleves <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="demo-eleve" class="collapse">
                            <li>
                                <a href="<c:url value="/admin/ajouter_eleve" />">Ajouter Eleve</a>
                            </li>
                            <li>
                                <a href="<c:url value="/admin/liste_eleve" />">Liste Eleve</a>
                            </li>
                        </ul>
                    </li>
                    
                    <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#demo-prof"><i class="fa fa-fw fa-briefcase"></i> Professeurs <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="demo-prof" class="collapse">
                            <li>
                                <a href="<c:url value="/admin/creer_prof" />">Ajouter Professeur</a>
                            </li>
                            <li>
                                <a href="<c:url value="/admin/liste_professeurs" />">Liste Professeurs</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                      <a href="<c:url value="/admin/creer_emploi" />"><i class="fa fa-fw fa-calendar"></i> Emploi De Temps</a>
                    </li>
                     
                    
                    <li>
                        <a href="<c:url value="/admin/liste_contact"/>"><i class="fa fa-fw fa-envelope"></i> Contacts</a>
                    </li>
                     <li>
                        <a href="<c:url value="/admin/list_remarques"/>"><i class="fa fa-fw fa-tags"></i> Remarques</a>
                    </li>
                     
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </nav>

        <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                     <h2>Modification Eleve</h2>
                     <hr>
                </div>
                <!-- /.row -->

                <div class="row">
                  <div class="col-md-8">
                    <form:form method="post" action=""  modelAttribute="OldEleve" name="add-eleve-form">
                     <fieldset>
                       <legend>Eleve</legend>
                     
                       <div class="form-group">
			             
			              
			             <form:input id="code" path="code_eleve" type="text"  class="hidden" required="required"/>
			            
			             
			           </div>
                       <div class="form-group">
			             <label for="nom">Nom</label>
			              
			             <form:input id="nom" path="nom_eleve" type="text"  class="form-control" placeHolder="Nom" required="required"/>
			             <form:errors path="nom_eleve" cssClass="text-danger" />
			             
			           </div>
			           <div class="form-group">
			             <label>Prenom</label>
			             <form:input id="prenom" path="prenom_eleve" type="text" class="form-control" placeHolder="Prenom" required="required"/>
			             <form:errors path="prenom_eleve" cssClass="text-danger" />
			           </div>
			           <div class="form-group">
			             <label>Adresse</label>
			             <form:input id="adresse" path="adresse_eleve" type="text" class="form-control" placeHolder="Adresse" required="required"/>
			             <form:errors path="adresse_eleve" cssClass="text-danger" />
			           </div>
			           <div class="form-group">
			             <label>Email</label>
			             <form:input path="email_eleve" type="email" class="form-control" placeHolder="E-Mail" required="required"/>
			             <form:errors path="email_eleve" cssClass="text-danger" />
			           </div>
			           <div class="form-group">
			             
			             <label>Date Naissance</label>
			             <form:input id="dateNaissance" path="dateNaissance_eleve" type="text" class="form-control" placeHolder="Date Naissance" required="required"/>
			              
			             
			            <form:errors path="dateNaissance_eleve" cssClass="text-danger" />
			           </div>
			           <div class="form-group">
			             
			             <label>Lieu Naissance</label>
			             <form:input id="lieu_naissance" path="lieu_naissance_eleve" type="text" class="form-control" placeHolder="Lieu Naissance" required="required"/>
			              
			             
			            <form:errors path="lieu_naissance_eleve" cssClass="text-danger" />
			           </div>
			           <div class="form-group">
			             <label>N° Assurance</label>
			             <form:input  path="num_assurance_eleve" type="text"  class="form-control" placeHolder="N° Assurance" required="required"/>
			             <form:errors path="num_assurance_eleve" cssClass="text-danger" />
			             
			           </div>
			           <div class="form-groupe">
			             <label>Groupe</label>
			             <form:select class="form-control" path="groupe_eleve" items="${groups }" />
			                      
			           </div><br/>
			         </fieldset>
			         <fieldset>
			           <legend>Parent</legend>
			           <div class="form-group">
			             
			             <form:input  path="cin_parent" type="text"  class="hidden" required="required"/>
			             
			             
			           </div>
			           <div class="form-group">
			             <label>Nom</label>
			             <form:input  path="nom_parent" type="text"  class="form-control" placeHolder="Nom" required="required"/>
			             <form:errors path="nom_parent" cssClass="text-danger" />
			             
			           </div>
			           <div class="form-group">
			             <label>Prenom</label>
			             <form:input path="prenom_parent" type="text" class="form-control" placeHolder="Prenom" required="required"/>
			             <form:errors path="prenom_parent" cssClass="text-danger" />
			           </div>
			           <div class="form-group">
			             <label>Adresse</label>
			             <form:input path="adresse_parent" type="text" class="form-control" placeHolder="Adresse" />
			             <form:errors path="adresse_parent" cssClass="text-danger" />
			           </div>
			           <div class="form-group">
			             <label>Email</label>
			             <form:input path="email_parent" type="email" class="form-control" placeHolder="E-Mail" required="required"/>
			             <form:errors path="email_parent" cssClass="text-danger" />
			           </div>
			           <div class="form-group">
			             <label>Telephone</label>
			             <form:input path="tel_parent" type="text" class="form-control" placeHolder="Telephone" required="required"/>
			             <form:errors path="tel_parent" cssClass="text-danger" />
			           </div>
			           
			         </fieldset>
			           
			           <input type="submit" value="Modifier" class="btn btn-warning" />
                    </form:form>
				  </div>
                </div>
                <!-- /.row -->

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

     <!-- jQuery -->
    <script src="<c:url value="/resources/vendor/jquery/jquery.js" />"></script>
	<script src="<c:url value="/resources/vendor/jquery/jquery.validate.min.js" />"></script>
	<script src="<c:url value="/resources/vendor/jquery/custom.js" />"></script>
	<script src="<c:url value="/resources/js/bootstrap-datepicker.js" />"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.min.js" />"></script>
    <script type="text/javascript">
            $(function () {
                $('#dateNaissance').datepicker({
                    format: 'yyyy-mm-dd'
                });
            });
    </script>
    
</body>

</html>
