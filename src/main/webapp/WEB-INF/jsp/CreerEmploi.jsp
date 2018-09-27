<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib	prefix="c"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Admin - Créer Emploi</title>

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
                      <a href="tables.html"><i class="fa fa-fw fa-calendar"></i> Emploi De Temps</a>
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
                     <h1 class="red">Creation d'emploi</h1>
                     <hr/>
                </div>
                <!-- /.row -->

                <div class="row">
                 <c:if test="${requestScope.sucess=='true' }">
                   <div class="alert alert-success">
                     Emploi créé avec succes !
                   </div>
                 </c:if>
                 <form:form method="post" action="" modelAttribute="newEmploi">
                    <div class="col-md-6">
                     <label>Groupe </label>
                    <form:select id="idGroupe" path="idGroupe" class="form-control">
                      <c:forEach items="${requestScope.listGroups }" var="item">
                       <option value="${item.id }">${item.niveau } Groupe ${item.nom } </option>
                      </c:forEach>
                    </form:select>
                    
                    <br/><br/>
                   </div>
                   
                   
                   
                   <div class="col-md-12">
                    <table class="table table-bordered">
                      <tr> 
                        <th class="col-md-2"></th>
                        <th>Lundi</th>
                        <th>Mardi</th>
                        <th>Mercredi</th>
                        <th>Jeudi</th>
                        <th>Vendredi</th>
                      </tr>
                     
                         <tr>
                        <td> <strong>8:00 - 9:30</strong> </td>
                        <td>
                        <!-- Lundi --> 
                          <form:select path="m_lundi_8" class="form-control">
                            <option value="0">--Aucun--</option>
                            <c:forEach items="${listMatieres }" var="item">
                              <option value="${item.id }">${item.nom }</option>
                              
                            </c:forEach>
                          </form:select>
                          
                          <form:select path="p_lundi_8" class="form-control">
                            <option value="0">--Aucun--</option>
                            <c:forEach items="${listProf }" var="item">
                              <option value="${item.id }">${item.nom } ${item.prenom }</option>
                              
                            </c:forEach>
                          </form:select>
                        </td>
                        <td> 
                        <!-- Mardi -->
                          <form:select path="m_mardi_8" class="form-control">
                            <option value="0">--Aucun--</option>
                            <c:forEach items="${listMatieres }" var="item">
                              <option value="${item.id }">${item.nom }</option>
                              
                            </c:forEach>
                          </form:select>
                          <form:select path="p_mardi_8" class="form-control">
                            <option value="0">--Aucun--</option>
                            <c:forEach items="${listProf }" var="item">
                              <option value="${item.id }">${item.nom } ${item.prenom }</option>
                              
                            </c:forEach>
                          </form:select>
                        </td>
                        <td> 
                        <!-- Mercredi -->
                          <form:select path="m_mardi_8" class="form-control">
                            <option value="0">--Aucun--</option>
                            <c:forEach items="${listMatieres }" var="item">
                              <option value="${item.id }">${item.nom }</option>
                              
                            </c:forEach>
                          </form:select>
                          <form:select path="p_mardi_8" class="form-control">
                            <option value="0">--Aucun--</option>
                            <c:forEach items="${listProf }" var="item">
                              <option value="${item.id }">${item.nom } ${item.prenom }</option>
                              
                            </c:forEach>
                          </form:select>
                        </td>
                        <td> 
                        <!-- Jeudi -->
                          <form:select path="m_jeudi_8" class="form-control">
                            <option value="0">--Aucun--</option>
                            <c:forEach items="${listMatieres }" var="item">
                              <option value="${item.id }">${item.nom }</option>
                              
                            </c:forEach>
                          </form:select>
                          <form:select path="p_jeudi_8" class="form-control">
                            <option value="0">--Aucun--</option>
                            <c:forEach items="${listProf }" var="item">
                              <option value="${item.id }">${item.nom } ${item.prenom }</option>
                              
                            </c:forEach>
                          </form:select>
                        </td>
                        <td> 
                        <!-- Vendredi -->
                          <form:select path="m_vendredi_8" class="form-control">
                            <option value="0">--Aucun--</option>
                            <c:forEach items="${listMatieres }" var="item">
                              <option value="${item.id }">${item.nom }</option>
                              
                            </c:forEach>
                          </form:select>
                          <form:select path="p_vendredi_8" class="form-control">
                            <option value="0">--Aucun--</option>
                            <c:forEach items="${listProf }" var="item">
                              <option value="${item.id }">${item.nom } ${item.prenom }</option>
                              
                            </c:forEach>
                          </form:select>
                        </td>
                      </tr>
                      <!-- SEANCE NUM 2 -->
                      <tr>
                        <td> <strong>9:45 - 11:15</strong> </td>
                        <td>
                        <!-- Lundi --> 
                          <form:select path="m_lundi_10" class="form-control">
                            <option value="0">--Aucun--</option>
                            <c:forEach items="${listMatieres }" var="item">
                              <option value="${item.id }">${item.nom }</option>                          
                            </c:forEach>
                          </form:select>
                          <form:select path="p_lundi_10" class="form-control">
                            <option value="0">--Aucun--</option>
                            <c:forEach items="${listProf }" var="item">
                              <option value="${item.id }">${item.nom } ${item.prenom }</option>                             
                            </c:forEach>
                          </form:select>
                        </td>
                        <td> 
                        <!-- Mardi -->
                          <form:select path="m_mardi_10" class="form-control">
                            <option value="0">--Aucun--</option>
                            <c:forEach items="${listMatieres }" var="item">
                              <option value="${item.id }">${item.nom }</option>                       
                            </c:forEach>
                          </form:select>
                          <form:select path="p_mardi_10" class="form-control">
                            <option value="0">--Aucun--</option>
                            <c:forEach items="${listProf }" var="item">
                              <option value="${item.id }">${item.nom } ${item.prenom }</option>                        
                            </c:forEach>
                          </form:select>
                        </td>
                        <td> 
                        <!-- Mercredi -->
                          <form:select path="m_mercredi_10" class="form-control">
                            <option value="0">--Aucun--</option>
                            <c:forEach items="${listMatieres }" var="item">
                              <option value="${item.id }">${item.nom }</option>
                              
                            </c:forEach>
                          </form:select>
                          <form:select path="p_mercredi_10" class="form-control">
                            <option value="0">--Aucun--</option>
                            <c:forEach items="${listProf }" var="item">
                              <option value="${item.id }">${item.nom } ${item.prenom }</option>
                              
                            </c:forEach>
                          </form:select>
                        </td>
                        <td> 
                        <!-- Jeudi -->
                          <form:select path="m_jeudi_10" class="form-control">
                            <option value="0">--Aucun--</option>
                            <c:forEach items="${listMatieres }" var="item">
                              <option value="${item.id }">${item.nom }</option>
                              
                            </c:forEach>
                          </form:select>
                          <form:select path="p_jeudi_10" class="form-control">
                            <option value="0">--Aucun--</option>
                            <c:forEach items="${listProf }" var="item">
                              <option value="${item.id }">${item.nom } ${item.prenom }</option>
                              
                            </c:forEach>
                          </form:select>
                        </td>
                        <td> 
                        <!-- Vendredi -->
                          <form:select path="m_vendredi_10" class="form-control">
                            <option value="0">--Aucun--</option>
                            <c:forEach items="${listMatieres }" var="item">
                              <option value="${item.id }">${item.nom }</option>
                              
                            </c:forEach>
                          </form:select>
                          <form:select path="p_vendredi_10" class="form-control">
                            <option value="0">--Aucun--</option>
                            <c:forEach items="${listProf }" var="item">
                              <option value="${item.id }">${item.nom } ${item.prenom }</option>
                              
                            </c:forEach>
                          </form:select>
                        </td>
                      </tr>
                      
                      <!-- SEANCE NUM 3 -->
                      <tr>
                        <td> <strong>11:30 - 1:00</strong> </td>
                        <td>
                        <!-- Lundi --> 
                          <form:select path="m_lundi_12" class="form-control">
                            <option value="0">--Aucun--</option>
                            <c:forEach items="${listMatieres }" var="item">
                              <option value="${item.id }">${item.nom }</option>
                              
                            </c:forEach>
                          </form:select>
                          <form:select path="p_lundi_12" class="form-control">
                            <option value="0">--Aucun--</option>
                            <c:forEach items="${listProf }" var="item">
                              <option value="${item.id }">${item.nom } ${item.prenom }</option>
                              
                            </c:forEach>
                          </form:select>
                        </td>
                        <td> 
                        <!-- Mardi -->
                          <form:select path="m_mardi_12" class="form-control">
                            <option value="0">--Aucun--</option>
                            <c:forEach items="${listMatieres }" var="item">
                              <option value="${item.id }">${item.nom }</option>
                              
                            </c:forEach>
                          </form:select>
                          <form:select path="p_mardi_12" class="form-control">
                            <option value="0">--Aucun--</option>
                            <c:forEach items="${listProf }" var="item">
                              <option value="${item.id }">${item.nom } ${item.prenom }</option>
                              
                            </c:forEach>
                          </form:select>
                        </td>
                        <td> 
                        <!-- Mercredi -->
                          <form:select path="m_mercredi_12" class="form-control">
                            <option value="0">--Aucun--</option>
                            <c:forEach items="${listMatieres }" var="item">
                              <option value="${item.id }">${item.nom }</option>
                              
                            </c:forEach>
                          </form:select>
                          <form:select path="p_mercredi_12" class="form-control">
                            <option value="0">--Aucun--</option>
                            <c:forEach items="${listProf }" var="item">
                              <option value="${item.id }">${item.nom } ${item.prenom }</option>
                              
                            </c:forEach>
                          </form:select>
                        </td>
                        <td> 
                        <!-- Jeudi -->
                          <form:select path="m_jeudi_12" class="form-control">
                            <option value="0">--Aucun--</option>
                            <c:forEach items="${listMatieres }" var="item">
                              <option value="${item.id }">${item.nom }</option>
                              
                            </c:forEach>
                          </form:select>
                          <form:select path="p_jeudi_12" class="form-control">
                            <option value="0">--Aucun--</option>
                            <c:forEach items="${listProf }" var="item">
                              <option value="${item.id }">${item.nom } ${item.prenom }</option>
                              
                            </c:forEach>
                          </form:select>
                        </td>
                        <td> 
                        <!-- Vendredi -->
                          <form:select path="m_vendredi_12" class="form-control">
                            <option value="0">--Aucun--</option>
                            <c:forEach items="${listMatieres }" var="item">
                              <option value="${item.id }">${item.nom }</option>
                              
                            </c:forEach>
                          </form:select>
                          <form:select path="p_vendredi_12" class="form-control">
                            <option value="0">--Aucun--</option>
                            <c:forEach items="${listProf }" var="item">
                              <option value="${item.id }">${item.nom } ${item.prenom }</option>
                              
                            </c:forEach>
                          </form:select>
                        </td>
                      </tr>
                      
                      <!-- SEANCE NUM 4 -->
                      <tr>
                        <td> <strong>2:00 - 3:30</strong> </td>
                        <td>
                        <!-- Lundi --> 
                          <form:select path="m_lundi_2" class="form-control">
                            <option value="0">--Aucun--</option>
                            <c:forEach items="${listMatieres }" var="item">
                              <option value="${item.id }">${item.nom }</option>
                              
                            </c:forEach>
                          </form:select>
                          <form:select path="p_vendredi_2" class="form-control">
                            <option value="0">--Aucun--</option>
                            <c:forEach items="${listProf }" var="item">
                              <option value="${item.id }">${item.nom } ${item.prenom }</option>
                              
                            </c:forEach>
                          </form:select>
                        </td>
                        <td> 
                        <!-- Mardi -->
                          <form:select path="m_mardi_2" class="form-control">
                            <option value="0">--Aucun--</option>
                            <c:forEach items="${listMatieres }" var="item">
                              <option value="${item.id }">${item.nom }</option>
                              
                            </c:forEach>
                          </form:select>
                          <form:select path="p_mardi_2" class="form-control">
                            <option value="0">--Aucun--</option>
                            <c:forEach items="${listProf }" var="item">
                              <option value="${item.id }">${item.nom } ${item.prenom }</option>
                              
                            </c:forEach>
                          </form:select>
                        </td>
                        <td> 
                        <!-- Mercredi -->
                          <form:select path="m_mercredi_2" class="form-control">
                            <option value="0">--Aucun--</option>
                            <c:forEach items="${listMatieres }" var="item">
                              <option value="${item.id }">${item.nom }</option>
                              
                            </c:forEach>
                          </form:select>
                          <form:select path="p_mercredi_2" class="form-control">
                            <option value="0">--Aucun--</option>
                            <c:forEach items="${listProf }" var="item">
                              <option value="${item.id }">${item.nom } ${item.prenom }</option>
                              
                            </c:forEach>
                          </form:select>
                        </td>
                        <td> 
                        <!-- Jeudi -->
                          <form:select path="m_jeudi_2" class="form-control">
                            <option value="0">--Aucun--</option>
                            <c:forEach items="${listMatieres }" var="item">
                              <option value="${item.id }">${item.nom }</option>
                              
                            </c:forEach>
                          </form:select>
                          <form:select path="p_jeudi_2" class="form-control">
                            <option value="0">--Aucun--</option>
                            <c:forEach items="${listProf }" var="item">
                              <option value="${item.id }">${item.nom } ${item.prenom }</option>
                              
                            </c:forEach>
                          </form:select>
                        </td>
                        <td> 
                        <!-- Vendredi -->
                          <form:select path="m_vendredi_2" class="form-control">
                            <option value="0">--Aucun--</option>
                            <c:forEach items="${listMatieres }" var="item">
                              <option value="${item.id }">${item.nom }</option>
                              
                            </c:forEach>
                          </form:select>
                          <form:select path="p_vendredi_2" class="form-control">
                            <option value="0">--Aucun--</option>
                            <c:forEach items="${listProf }" var="item">
                              <option value="${item.id }">${item.nom } ${item.prenom }</option>
                              
                            </c:forEach>
                          </form:select>
                        </td>
                      </tr>
                      
                    </table>
                 </div>
                   <div class="col-md-12">
                      <input type="submit" class="btn btn-primary" value="Créer" />
                      <br/><br/>
                   </div>
                   
                 </form:form>
                
                 
                    
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
