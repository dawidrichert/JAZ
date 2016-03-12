<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Kalkulator rat kredytu</title>
        <link rel="stylesheet" href="../css/bootstrap.min.css">
        <link rel="stylesheet" href="../css/app.css">
        <script src="../js/jquery-1.12.1.min.js"></script>
        <script src="../js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="vertical-center">
            <div class="container col-sm-4">
                <h2>Zadanie 1</h2>
                </br>
                <form action="harmonogram" method="post" role="form">
                    <div class="form-group">
                        <label for="requestedCreditAmount">Wnioskowana kwota kredytu</label>
                        <input class="form-control" type="number" step="any" min="0" id="requestedCreditAmount" name="requestedCreditAmount" required/>
                    </div>
                    <div class="form-group">
                        <label for="installmentsNumber">Ilość rat</label>
                        <input class="form-control" type="number" min="0" id="installmentsNumber" name="installmentsNumber" required/>
                    </div>
                    <div class="form-group">
                        <label for="rateOfInterest">Oprocentowanie</label>
                        <input class="form-control" type="number" step="any" min="0" id="rateOfInterest" name="rateOfInterest" required/>
                    </div>
                    <div class="form-group">
                        <label for="fixedFee">Opłata stała</label>
                        <input class="form-control" type="number" step="any" min="0" id="fixedFee" name="fixedFee" required/>
                    </div>
                    <div class="form-group">
                        <label for="installmentsType1">Rodzaj rat</label>
                        <div class="form-group">
                            <label class="radio-inline">
                              <input type="radio" name="installmentsType" id="installmentsType1" value="0" checked> malejąca
                            </label>
                            <label class="radio-inline">
                              <input type="radio" name="installmentsType" id="installmentsType2" value="1"> stała
                            </label>
                        </div>
                    </div>
                    <div class="form-group pull-right">
                        <input class="btn btn-primary" type="submit" value="Oblicz"/>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>