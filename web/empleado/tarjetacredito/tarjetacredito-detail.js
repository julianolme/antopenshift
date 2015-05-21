app.controller("TarjetaCreditoController", ['$scope', '$rootScope', "$location", "$http", function ($scope, $rootScope, $location, $http) {

        $scope.validacionServidor = false;

        $scope.tipoTarjetaList = [{
                "nombre": "GOLD"},
            {
                "nombre": "CLASSIC"},
            {
                "nombre": "ELECTRON"
            }];

        $scope.consultarCuentas = function () {
            $http({
                method: 'GET',
                url: 'http://localhost:8084/banco/api/CuentaBancaria'
            }).success(function (data, status, headers, config) {
                $scope.cuentaBancariaList = data;
            }).error(function (data, status, headers, config) {
                alert("Ha fallado la petición. Estado HTTP:" + status);
            });
        }

        $scope.insertarTarjeta = function () {

            $http({
                method: 'POST',
                url: 'http://localhost:8084/banco/api/tarjetacredito',
                data: $scope.tarjetaCredito
            }).success(function (data, status, headers, config) {
                alert("Insercion de datos Correcta");
            }).error(function (data, status, headers, config) {
                if (status == 400) {
                    $scope.errorServidorList = data;
                    $scope.validacionServidor = true;
                }
            });

        };

        $scope.comprobarSaldo = function () {

            $scope.valGOLD = false;
            $scope.valCLASSIC = false;

            $http({
                method: 'GET',
                url: 'http://localhost:8084/banco/api/CuentaBancaria/' + $scope.tarjetaCredito.idCuentaBancaria
            }).success(function (data, status, headers, config) {
                var cuentaBancaria = data;
                var permitido = true;

                if ($scope.tarjetaCredito.tipoTarjeta == "GOLD" && cuentaBancaria.saldoCuentaBancaria < 100000) {
                    permitido = false;
                    $scope.valGOLD = true;
                }
                if ($scope.tarjetaCredito.tipoTarjeta == "CLASSIC" && cuentaBancaria.saldoCuentaBancaria <= 0) {
                    permitido = false;
                    $scope.valCLASSIC = true;
                }

                if (permitido == true && $scope.formularioCliente.$valid) {
                    $scope.insertarTarjeta();
                }

            }).error(function (data, status, headers, config) {
                alert("Ha fallado la petición. Estado HTTP:" + status);
            });

        }

        $scope.consultarCuentas();

    }]);


