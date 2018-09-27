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

    <title>Admin - Creer Profil Professeur</title>

    <!-- Bootstrap Core CSS -->
    <link href="<c:url value="/resources/vendor/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<c:url value="/resources/css/sb-admin.css" />" rel="stylesheet">
     

    

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
                     <h2 class="red"><strong>Créer Profil Professeurs</strong></h2>
                     <hr>
                </div>
                <!-- /.row -->

                <div class="row">
                  <div class="col-md-8">
                    <form:form method="post" action="" modelAttribute="newProf" name="prof-form" enctype="multipart/form-data">
                       <div class="form-group">
			             <label for="cin">C.I.N</label>
			             <form:input id="cin" path="cin" type="text"  class="form-control" placeHolder="C.I.N" required="required"/>
			             <form:errors path="cin" cssClass="text-danger" />
			             
			           </div>
			           <div class="form-group">
			             <label for="identifiant_uniq">Identifiant Unique</label>
			             <form:input id="identifiant_uniq" path="identifiant_uniq" type="text"  class="form-control" placeHolder="Identifiant Unique" required="required"/>
			             <form:errors path="identifiant_uniq" cssClass="text-danger" />
			             
			           </div>
                       <div class="form-group">
			             <label for="nom">Nom</label>
			             <form:input id="nom" path="nom" type="text"  class="form-control" placeHolder="Nom" required="required"/>
			             <form:errors path="nom" cssClass="text-danger" />
			             
			           </div>
			           
			           <div class="form-group">
			             <label>Prenom</label>
			             <form:input id="prenom" path="prenom" type="text" class="form-control" placeHolder="Prenom" required="required"/>
			             <form:errors path="prenom" cssClass="text-danger" />
			           </div>
			           <div class="form-group">
			             <label>Adresse</label>
			             <form:input id="adresse" path="adresse" type="text" class="form-control" placeHolder="Adresse"/>
			             <form:errors path="adresse" cssClass="text-danger" />
			           </div>
			           <div class="form-group">
			             <label>Email</label>
			             <form:input id="prenom" path="email" type="email" class="form-control" placeHolder="E-Mail" required="required"/>
			             <form:errors path="email" cssClass="text-danger" />
			           </div>
			           <div class="form-group">
			             <label>Num Telephone</label>
			             <form:input id="tel" path="tel" type="text" class="form-control" placeHolder="Num Telephone"/>
			             <form:errors path="tel" cssClass="text-danger" />
			           </div>
			           <div class="form-group">
			             <label>Login</label>
			             <form:input id="login" path="login" type="text" class="form-control" placeHolder="Login" required="required"/>
			             <form:errors path="login" cssClass="text-danger" />
			           </div>
			           <div class="form-group">
			             <label>Mot de Passe</label>
			             <form:input id="pass" path="password" type="password" class="form-control" placeHolder="Mot de Passe" required="required"/>
			             <form:errors path="password" cssClass="text-danger" />
			           </div>
			           <div class="form-group">
			             <label>Confirmer mot de passe</label>
			             <input id="pass_conf" name="pass_conf" type="password" class="form-control" placeHolder="Confirmer mot de passe" required="required"/>
			             
			           </div>
			           <div class="form-group">
			             <label>Image Profile</label>
			             <form:input id="image" path="image" type="file" class="form-control" placeHolder="Image Profile" required="required" />
			           </div>
			           <input type="submit" value="Créer Profil" class="btn btn-warning" />
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
    <!-- Bootstrap Core JavaScript -->
    <script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.min.js" />"></script>

    
</body>

</html>
