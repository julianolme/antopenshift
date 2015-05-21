app.config(['$routeProvider', function ($routeProvider) {
        
        $routeProvider.when('/tarjetacredito/new', {
            templateUrl: "tarjetacredito/tarjetacredito-detail.html",
            controller: "TarjetaCreditoController"
        });
        
    }]);
