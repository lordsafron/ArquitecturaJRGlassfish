var app = angular.module("MyFirstApp",[]);

app.controller("FirstController",function($scope){
   $scope.nombre = "Hugo"; //Variable
   $scope.nuevoComentario = {}; //Objecto
   $scope.comentarios = [
       {
           comentario: "Buen tutorial",
           username: "codigoFacilito"
       },
       {
           comentario: "Malísimo el tutorial",
           username: "otro_usuario"
       }
   ];
   $scope.agregarComentario = function(){
       $scope.comentarios.push($scope.nuevoComentario);
       $scope.nuevoComentario = {};
   };
});
        


