/**
 * Created by olatu on 06/01/2021.
 */

var app  = angular.module('usersDataApp',[]);


    app.controller('usersDataCtrl', ['$scope','$http',  function ($scope,  $http) {
        $scope.data = {};
        $scope.message = '';
        $scope.usersData = {};

        $scope.saveUsersData = function (){
            if($scope.data.firstname !== '' && $scope.data.email !== ''){
                $scope.usersData['firstName'] = $scope.data.firstname;
                $scope.usersData['lastName'] = $scope.data.lastname;
                $scope.usersData['email'] = $scope.data.email;
                $http({
                    method: 'POST',
                    url: '/users/data ',
                    headers: {
                        'Content-Type':'application/json'
                    },
                    data: JSON.stringify($scope.usersData),
                }).then(function (response){
                    let userData = response.data
                    $scope.message =  userData.firstName +' details has been saved successfully';
                },function (error){
                    $scope.message =  'Users details has not been saved successfully';
                });
            }
            $scope.data.firstname = '';
            $scope.data.lastname = '';
            $scope.data.email = '';
        }
}]);

