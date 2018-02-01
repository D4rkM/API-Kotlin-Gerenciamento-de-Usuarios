<?php

if ($_SERVER['REQUEST_METHOD']=='POST'){

  require_once("conn.php");
  $conn = conn();

  $nome = $_POST['usuario'];
  $senha = $_POST['senha'];
  $sexo = $_POST['sexo'];

  $insert = "INSERT INTO usuario SET usuario = '$nome', senha = '$senha', sexo = '$sexo';";

  if(mysqli_query($conn, $insert)){

    echo json_encode(array(
        "sucesso" => true ,
        "mensagem"=> "Inserido com sucesso"));
  } else {

    echo json_encode(array(
        "sucesso" => false ,
        "mensagem" => mysqli_error($conn)));
  }

}else{

  echo json_encode(array(
  "sucesso" => false ,
  "mensagem"=> "Método não suportado"));
}

 ?>
