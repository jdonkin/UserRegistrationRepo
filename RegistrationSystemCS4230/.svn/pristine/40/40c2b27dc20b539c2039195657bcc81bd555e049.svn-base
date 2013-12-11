
var myApp = angular.module('myApp', []);

function Controller($scope) {
    $scope.master = {};
     
    $scope.update = function(user) {
    $scope.master = angular.copy(user);
    };
     
    
     
    $scope.isUnchanged = function(user) {
    return angular.equals(user, $scope.master);
    };
    
     
    $scope.reset();
    /*
   myApp.directive('sameAs', function() {
  	  return {
  	    require: 'ngModel',
  	    link: function(scope, elm, attrs, ctrl) {
  	      ctrl.$parsers.unshift(function(viewValue) {
  	        if (viewValue === scope[attrs.sameAs]) {
  	          ctrl.$setValidity('sameAs', true);
  	          return viewValue;
  	        } else {
  	          ctrl.$setValidity('sameAs', false);
  	          return undefined;
  	        }
  	      });
  	    }
  	  };
  	});
   */
    
    
}
myApp.directive('match',['$parse', function ($parse) {
    return {
        require: 'ngModel',
        restrict: 'A',
        link: function(scope, elem, attrs, ctrl) {
            scope.$watch(function() {
                return (ctrl.$pristine && angular.isUndefined(ctrl.$modelValue)) || $parse(attrs.match)(scope) === ctrl.$modelValue;
            }, function(currentValue) {
                ctrl.$setValidity('match', currentValue);
            });
        }
    };
}]);



