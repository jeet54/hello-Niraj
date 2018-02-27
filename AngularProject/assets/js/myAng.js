var app = angular.module("myApp",[]);
app.controller("myCtr1", function($scope)
{

	var employees= [{  }];
	$scope.employees;
	employees;
	

	



		$scope.save = function()
		{
     		employees.push({"id":$scope.employeeid,"Firstname":$scope.employeeFirstname,"Lastname":$scope.employeeLastname,"Age": $scope.employeeAge,"City":$scope.employeeCity,"Country":$scope.employeeCountry});
			$scope.employees=employees;
		
		}
		
		
		$scope.edit = function(emp,index)
		{
				alert(" edit "+ index + "  "+ emp.id + "   " + emp.Firstname);
     		// employees.push({"id":$scope.employeeid,"Firstname":$scope.employeeFirstname,"Lastname":$scope.employeeLastname,"Age": $scope.employeeAge,"City":$scope.employeeCity,"Country":$scope.employeeCountry});
			// $scope.employees=employees;
		
		}
		$scope.delete = function(emp,index)
		{
			
			alert(" Delete "+index + "   "+ emp.id + "  " + emp.Firstname);
     		// employees.push({"id":$scope.employeeid,"Firstname":$scope.employeeFirstname,"Lastname":$scope.employeeLastname,"Age": $scope.employeeAge,"City":$scope.employeeCity,"Country":$scope.employeeCountry});
			// $scope.employees=employees;
		
		}
		
	
		
});		