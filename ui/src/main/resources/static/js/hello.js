angular.module('hello', [ 'ngRoute' ]).config(function($routeProvider) {

	$routeProvider.when('/', {
		templateUrl : 'home.html',
		controller : 'home'
	}).otherwise('/');

}).controller('sso',

function($rootScope, $scope, $http, $location, $route) {

	$scope.init = function() {
		//if it's popup reload parent and close it self
		if (window.opener) {
			window.opener.location.reload(true);
			window.close();
		}
	}

	$scope.tab = function(route) {
		return $route.current && route === $route.current.controller;
	};

	$http.get('user').success(function(data) {
		if (data.name) {
			$rootScope.authenticated = true;
			$scope.name = data.name;
		} else {
			$rootScope.authenticated = false;
			$scope.name = '';
		}
	}).error(function() {
		$rootScope.authenticated = false;
	});

	$scope.credentials = {};

	$scope.openPopup = function(url, title, w, h) {
		var left = (screen.width/2)-(w/2);
		var top = (screen.height/2)-(h/2);
		return window.open(url, title, 'toolbar=no, location=no, directories=no, ' +
			'status=no, menubar=no, scrollbars=no, resizable=no, copyhistory=no, ' +
			'width='+w+', height='+h+', top='+top+', left='+left);
	}

	$scope.logout = function() {
		$http.post('logout', {}).success(function() {
			$rootScope.authenticated = false;
			$location.path("/");
		}).error(function(data) {
			console.log("Logout failed")
			$rootScope.authenticated = false;
		});
	}

	$scope.init();

}).controller('home', function($scope, $http) {
	$http.get('resource/').success(function(data) {
		$scope.greeting = data;
	})
}).controller('mint',function($scope){

});
