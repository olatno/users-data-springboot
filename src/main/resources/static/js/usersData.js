/**
 * Created by olatu on 16/11/2020.
 */

var app  = angular.module('usersDataApp',[]);


    app.controller('usersDataCtrl', ['$scope','$http',  function ($scope,  $http) {
        let vm = this;
        $scope.data = {};
        $scope.message = '';
        $scope.usersData = {};


        // vm.csrfHeader = document.querySelector('meta[name="_csrf_header"]').content;
        // vm.csrfToken = document.querySelector('meta[name="_csrf"]').content;

        $scope.saveUsersData = function (){
            if($scope.data.firstname !== '' && $scope.data.email !== ''){
                $scope.usersData['firstName'] = $scope.data.firstname;
                $scope.usersData['lastName'] = $scope.data.lastname;
                $scope.usersData['email'] = $scope.data.email;
                $http({
                    method: 'POST',
                    url: '/users/data ',
                    headers: {
                        'X-CSRF-TOKEN': vm.csrfToken,
                        'Content-Type':'application/json'
                    },
                    data: JSON.stringify($scope.usersData),
                }).then(function (response){
                    $scope.message =  'Users details has been saved successfully';
                },function (error){
                    $scope.message =  'Users details has not been saved successfully';
                });
            }
            $scope.data.firstname = '';
            $scope.data.lastname = '';
            $scope.data.email = '';
        }
}]);

