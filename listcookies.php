<?php
	setcookie("name","vamshi");
	setcookie("password","Susheela@123");
	foreach ($_COOKIE as $key => $value) 
	{
		echo "cookie name:".$key."&nbsp&nbsp&nbsp&nbsp";
		echo "cookie value:".$value."<br>";
	}
?>