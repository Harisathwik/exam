<?php
	session_start();
?>
<?php
	echo "Thank you ".$_SESSION["name"]."<br>";
	echo date("i:s",time())."<br>";
	$duration = time() - ($_SESSION['start_time']);
	echo "You have spent ".date("i:s",$duration)." time";
	session_unset();
	session_destroy();
?>