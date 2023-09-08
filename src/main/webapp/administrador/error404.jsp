<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                text-align: center;
                background-color: #f0f0f0;
            }
            .error-message {
                margin-top: 100px;
                font-size: 24px;
            }
            .button-container {
                margin-top: 20px;
            }
            .back-button {
                display: inline-block;
                padding: 10px 20px;
                background-color: #007bff;
                color: #fff;
                text-decoration: none;
                border-radius: 5px;
                font-size: 16px;
            }
            .back-button:hover {
                background-color: #0056b3;
            }
        </style>
    </head>
    <body>
        <div class="error-message">
            <h1>Ocurrió un error, por favor vuelve al inicio :)</h1>
        </div>
        <div class="button-container">
            <a class="back-button" href="indexadmin.jsp">Volver al inicio</a>
        </div>
    </body>
</html>








