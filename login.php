<?php
	session_start();
?>
<?php
	$_SESSION['name'] = $_POST['name'];
	$start_time = time(); 
	$_SESSION['start_time'] = $start_time;
	echo "hello ".$_SESSION['name']."<br>";
	echo date("i:s",$start_time);
?>
<html>
<body>
	<form action="C:/Users/harisathwik/Desktop/WT/logout.php" method="post">
		<input type="submit" value="logout">
		
	</form>
</body>
</html>
