<%@tag pageEncoding="UTF-8"%>
<%@attribute name="pageTitle" required="true"%>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>${pageTitle}</title>
    <link rel="icon" type="image/png" href="../../img/favicon.png"/>
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
    <link rel="stylesheet" href="../../css/app.css">
    <script src="../../js/jquery-1.12.1.min.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="center-element col-sm-4">
        <h2>${pageTitle}</h2>
        </br>
        <jsp:doBody/>
    </div>
</div>
</body>
</html>