<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib	prefix="c"	uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Accueil Admin</title>

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
                     <h1 class="red"><c:out value="${remarque.sujet }" /></h1>
                     <hr/>
                </div>
                <!-- /.row -->

				<div class="row">
					<div class="col-md-9">
						<p>
							<c:out value="${remarque.remarque }" />
						</p>
						<br />
						<br />
						<p>
							<strong>Professeur : </strong>
							<c:out value="${remarque.professeur }" />
						</p>
						<p>
							<strong>Eleve : </strong>
							<c:out value="${remarque.eleve }" />
						</p>
						<p>
							<strong>Date : </strong>
							<c:out value="${remarque.date }" />
						</p>
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

    <!-- Bootstrap Core JavaScript -->
    <script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.min.js" />"></script>

    
</body>

</html>
