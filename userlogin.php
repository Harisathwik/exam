<?php
	$servername = "localhost";
	$username = "root";
	$password = "";
	$database = "mydb";

	$conn = new mysqli($servername, $username,$password,$database);
	$name = $_POST['username'];
	$password = $_POST['password'];

	$sql = "
			SELECT name,password
			FROM users";
	$res = $conn -> query($sql);
	$c=0;
	$flag=0;
	if($res->num_rows>0)
	{
		while($row = $res->fetch_assoc())
		{
			if($row['name'] == $name && $row['password']==$password)
			{
				echo "Welcome !!";
				break;
			}
			else if($row['name'] == $name)
			{
				echo "password mismatch!";
				$flag = 1;
				break;
			}
			$c+=1;
		}	
	}
	if($c == $res->num_rows)
	{
		include "lab14reg.html";
	}
	if($flag == 1)
	{
		include "lab14login.html";
	}

?>