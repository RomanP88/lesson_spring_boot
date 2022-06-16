angular.module('frontapp', []).controller('appController', function($scope, $http) {
    const contextPath = 'http://localhost:8080/app';


    $scope.loadProducts = function (){
        $http.get(contextPath + '/productsAll')
            .then(function(response) {
            $scope.ProductList = response.data;
        });
    }

    $scope.changeScore = function (productId, delta) {
        $http({
            url:contextPath + '/productsAll/change_score',
            method: 'GET',
            params: {
                productId: productId,
                delta: delta
            }
        }).then(function (response) {
            $scope.loadProducts();
        });
    }


    $scope.loadProducts();



});