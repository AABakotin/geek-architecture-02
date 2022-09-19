angular.module('crud', []).controller('indexController', function ($scope, $http) {
    $scope.fillTable = function () {
        $http.get('http://localhost:8182/mvc/api/v1/product')
            .then(function (response) {
                $scope.products = response.data;

            });
    };

    $scope.deleteProduct = function (id) {
        $http.delete('http://localhost:8182/mvc/api/v1/product/' + id)
            .then(function (response) {
                $scope.fillTable();
            });
    }

    $scope.createNewProduct = function () {
        // console.log($scope.newProduct);
        $http.post('http://localhost:8182/mvc/api/v1/product', $scope.newProduct)
            .then(function (response) {
                $scope.newProduct = null;
                $scope.fillTable();
            });
    }

    $scope.updateSomeProduct = function (){
        $http.put('http://localhost:8182/mvc/api/v1/product/update', $scope.updateProduct)
            .then(function (response) {
                $scope.updateProduct = null;
                $scope.fillTable();
            })
    }

    $scope.fillTable();
});