<?php
date_default_timezone_set('Europe/Madrid');
?>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Mini App Docker PHP</title>
    <link rel="stylesheet" href="css/estilos.css">
</head>
<body>
    <h1>Aplicación desplegada con Docker</h1>

    <p><strong>Fecha y hora actual:</strong> <?php echo date("d/m/Y H:i:s"); ?></p>

    <p><strong>Servidor:</strong> <?php echo $_SERVER['SERVER_NAME']; ?></p>

    <a href="saludo.php">Ir a página de saludo</a>
</body>
</html>