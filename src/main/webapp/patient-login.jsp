<%-- 
    Document   : patient-login
    Created on : Nov 9, 2022, 2:58:07 PM
    Author     : jasonwilsonrodriguez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Patient Login</title>
        <style>
            body {
                margin: 0%;
                background-image: url('img/dent-tools.jpeg');
                background-position: center center;
                background-repeat: no-repeat;
                background-attachment: fixed;
                background-size: cover;
                backdrop-filter: blur(2px);
                display: flex;
                justify-content: center;
            }
            .banner-container {
                background-color: rgba(0, 0, 0, 0.5);
                display: flex;
                align-items: center;
                justify-content: center;
                min-width: 100vw;
                max-height: 60px;
                min-height: 50px;
                position: fixed;
            }
            .container-1 {
                display: flex;
                align-items: center;
                width: fit-content;
                height: 100px;
                justify-content: space-around;
                flex-direction:  column;
                margin-top: -40vh;
                font-size: 25px;
                padding-left: 50px;
                padding-right: 50px;
                padding-top: 60px;
                padding-bottom: 65px;
                
                
                align-content: center;
                border-radius: 25px;
                background: rgb(0, 0, 0, 0.8);
            }
            .background-container {
                display: flex;
                min-height: 100vh;
                min-width: 100vw;
                justify-content: center;
                align-items: center;
                background:rgba(0, 0, 0, 0.5);
            }
            
            
            
            
        </style>
    </head>
    <body>
        <div class="banner-container">
            <img src="img/ctclogo.png" style="
                 width: 50px;
                 height: 50px;
                 "></img>
            <div style="font-size: 50px; color: white;">Chattahoochee Dental Company</div>
        </div>
            
        <div class="background-container">
                <form name="dataForm" action="PatLogServlet" class="container-1">
                    
                    <label for="pat-id" style=" color: white;">Patient ID</label>
                    <input type="text" id="pat-id" name="patientId" size="30"/>
                    <br>
                    <label for="pat-pass" style=" color: white;">Password</label>
                    <input type="password" id="pat-pass" name="patientPassword" size="30"/>
                    <br>
                    <button type="submit" style="display: flex">LOGIN</button>    
                </form>
            </div>
            
    </body>
</html>
