<?php

$usuario=$_REQUEST['user'];
$password=$_REQUEST['pas'];
$conexion= pg_connect("host=localhost dbname=aplicacion user=odoo password=admin options='--client_encoding=UTF8'");
$query= "SELECT * FROM registros WHERE usuario='$usuario' AND contraseña='$password'";
$consulta = pg_query($conexion, $query);

/*Devuelve las coincidencias como un objeto JSON*/
$datos=pg_fetch_object($consulta);

/*Codificamos datos en JSON y especificamos también que queremos la salida en caracteres unicode
para no tener problemas con acentos o caracteres especiales*/
echo json_encode($datos, JSON_UNESCAPED_UNICODE);

?>
