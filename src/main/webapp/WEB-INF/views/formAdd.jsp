<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Form Page</title>
        <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet" type="text/css" />
        <link href="<c:url value="/resources/css/bootstrap-theme.css" />" rel="stylesheet" type="text/css" />
        <link href="<c:url value="/resources/css/theme.css" />" rel="stylesheet" type="text/css" />


    </head>
    <body role="document">
        <div role="navigation" class="navbar navbar-inverse navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <a href="#" class="navbar-brand">Doctor - SKP Form</a>
                </div>
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="#">Home</a></li>
                    </ul>
                </div>
            </div>
        </div>

        <div class="container theme-showcase" role="main">
            <f:form id="form-validate" method="post" modelAttribute="doctorSkpForm" action="add" onsubmit="return validate();" >
                <div class="row jumbotron">
                    <c:if test="${ not empty message }">
                        <div class="alert-info">
                            <button type="button" class="close" data-dismiss="alert">&times;</button>
                            <strong>${message}</strong>
                        </div>
                    </c:if>
                    <div class="col-sm-13">
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <h3 class="panel-title">Doctor</h3>
                            </div>
                            <div class="panel-body">
                                <div class="form-horizontal" role="form">
                                    <div class="form-group">
                                        <label for="name" class="col-sm-2 control-label">Name : </label>
                                        <div class="col-sm-5">
                                            <f:input path="doctorName" cssClass="form-control" />
                                            <f:errors path="doctorName"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="npaidi" class="col-sm-2 control-label">NPA IDI : </label>
                                        <div class="col-sm-5">
                                            <f:input path="NpaId" cssClass="form-control" />
                                            <f:errors path="NpaId"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="spesialis" class="col-sm-2 control-label">Spesialis : </label>
                                        <div class="col-sm-5">
                                            <f:input path="specialist" cssClass="form-control" />
                                            <f:errors path="specialist" />
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="panel panel-primary">
                            <div class="panel-body">
                                <div class="form-inline" role="form">
                                    <div class="col-sm-4 form-group">
                                        <div class="col-sm-4">
                                            <label for="spesialis" class="form-control-label">Kegiatan :</label>
                                        </div>
                                        <div class="col-sm-3">
                                            <f:input path="activityName" cssClass="form-control" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-5">
                                            <label for="jmlSKP" class="form-control-label">Jumlah SKP :</label>
                                        </div>
                                        <div class="col-sm-5">
                                            <f:input path="totalSkp" cssClass="form-control" />
                                        </div>
                                    </div>
                                    <button type="submit" value="add" class="btn btn-info">Add</button>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </f:form>
        </div>
        <div class="container theme-showcase" role="main">
            <div id="jmb" class="jumbotron ">
                <div id="result"></div>
                <table id='listData' class='table table-striped panel panel-primary'>
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>Nama Kegiatan</th>
                            <th>Jumlah SKP </th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:if test="${ not empty list }">
                            <c:forEach items="${list}" var="skpList">
                                <tr>
                                    <td>${skpList.id}</td>
                                    <td>${skpList.namaKegiatan}</td>
                                    <td>${skpList.jumlahSkp}</td>
                                </tr>
                            </c:forEach>
                        </c:if>
                    </tbody>
                </table>
            </div>

        </div>

        <script src="<c:url value="/resources/js/jquery-1.11.1.js" />"></script>
        <script src="<c:url value="/resources/js/bootstrap.js" />"></script>

        <script type="text/javascript">

            //onload only for data list
            function validate() {
                //validate
                var regex = /^[0-9]*(?:\.\d{1,2})?$/;
                if (!regex.test($("#NpaId").val()) || !regex.test($("#totalSkp").val())) {
                    alert("NPA IDI and Jumlah SKP must be Number only");
                    return false;
                } else {
                    return true;
                }
            }


        </script>

    </body>
</html>
