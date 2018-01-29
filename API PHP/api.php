<?php

  $conn = mysqli_connect('localhost', 'root', 'bcd127', 'gerenciamento');

  $user = $_GET["user"];
  $senha = $_GET["senha"];

  $sql = "SELECT * FROM usuario WHERE usuario = '$user' AND senha = '$senha';";

  $select = mysqli_query($conn, $sql);

  if(mysqli_num_rows($select) > 0){

    echo json_encode(array(
        "sucesso" => true ,
        "mensagem"=> "Usuário Conectado"));
  } else {

    echo json_encode(array(
        "sucesso" => false ,
        "mensagem" => mysqli_error($conn)));
  }




 ?>
