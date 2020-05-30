<?php

$conn = mysqli_connect('localhost', 'root', '', 'oussama_db');
mysqli_set_charset($conn,"utf8");


if(!$conn) {
    die ("Connection Error !!!".mysqli_connect_error());
}

$sql = "SELECT * FROM formations";

$result = mysqli_query($conn, $sql);

$formations = array();

if(mysqli_num_rows($result) > 0) {
    while($row = mysqli_fetch_assoc($result)){
        array_push($formations, $row);
    }
}

echo json_encode($formations, JSON_UNESCAPED_UNICODE);