<?php

  function conn(){
    $conn = mysqli_connect("localhost","root","bcd127", "gerenciamento");

    return $conn;
  }


 ?>
