<?php
if (isset($_POST['anio']) && $_POST['anio']>0){
    $anio=$_POST['anio'];
    if($anio>2004){
        echo "Es menor de edad";
    }
    else{
        echo "Es mayor de edad";
    }
}else{
    echo 'No hay dato';
    }

?>