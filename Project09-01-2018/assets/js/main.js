function validate()
{
	
	
	var login = document.forms["myform"]["uname"].value;
	var pass = document.forms["myform"]["psw"].value;
	
	if(login == null || login == "" || pass == null || pass == "")
	{
		alert(" Both Field must contain the value ");
		return false;
	}
	else
	{
		if(login == "admin")
		{
			
			if(pass == "123")
			{
				
				return true;
			}
			else
			{
				alert(" Password is not valid ");
				return false;
			}
			
			
			
		}
		else
		{
				alert(" Login is not valid ");
				return false;
			
		}
		
		
	}
	
	
	

	
	
}



