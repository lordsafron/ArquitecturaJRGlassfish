var app = angular.module("MyFirstApp", []);

app.controller("FirstController", function ($scope, $http) {
    $scope.posts = []; //arreglo
    $scope.idEstado = 1;
    $scope.newPost = {}; //objecto
    $http.get("http://localhost:8180/capaWebService/rest/estado/findById/"+$scope.idEstado)
            .success(function (data) {
                console.log(data);
                $scope.posts = data;
            })
            .error(function (error,data) {
                console.log("Error" + error);
                console.log("data" + data);
            });
    /*
    $scope.addPost = function () {
        $http.post("http://jsonplaceholder.typicode.com/posts",{
            title: $scope.newPost.title,
            body: $scope.newPost.body,
            userId: 1
        })
                .success(function (data, status, headers, config) {
                    $scope.posts.push($scope.newPost);
                    $scope.addPost = {};
                    
                })
                .error(function (error, status, headers, config) {
                    console.log(error);
                });
    };
    */
});



