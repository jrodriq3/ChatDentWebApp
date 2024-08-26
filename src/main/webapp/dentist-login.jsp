<%-- 
    Document   : dentist-login
    Created on : Nov 9, 2022, 3:03:18 PM
    Author     : jasonwilsonrodriguez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href='https://fonts.googleapis.com/css?family=Nunito:400,300' rel='stylesheet' type='text/css'>
        <style>
                        *, *:before, *:after {
  -moz-box-sizing: border-box;
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
}

            body {
                margin: 0%;
                background-image: url('img/dent-tools.jpeg');
                background-position: center center;
                background-repeat: no-repeat;
                background-attachment: fixed;
                background-size: cover;
                backdrop-filter: blur(2px);
                height: 100vh;
                display: flex;
                justify-content: center;
            }
            .banner-container{
                background-color: rgba(0, 0, 0, 0.5);
                display: flex;
                align-items: center;
                justify-content: center;
                min-width: 100vw;
                max-height: 60px;
                min-height: 50px;
                position: fixed;
            }
            .bottom-container {
                display: flex;
                flex-direction: column;
                min-height: 100vh;
                min-width: 100vw;
                justify-content: center;
                margin-top: -25px;
                align-items: center;
                background:rgba(0, 0, 0, 0.5);
            }
form {
  max-width: 300px;
  margin-top: -150px;
  padding: 10px 20px;
  background: #f4f7f8;
  border-radius: 8px;
  box-shadow: 5px 5px gray;
  
}

h1 {
  margin: 0 0 30px 0;
  text-align: center;
}

input[type="text"],
input[type="password"],
input[type="date"],
input[type="datetime"],
input[type="email"],
input[type="number"],
input[type="search"],
input[type="tel"],
input[type="time"],
input[type="url"],
textarea,
select {
  background: rgba(255,255,255,0.1);
  border: none;
  font-size: 16px;
  height: auto;
  margin: 0;
  outline: 0;
  padding: 15px;
  width: 100%;
  background-color: #e8eeef;
  color: #8a97a0;
  box-shadow: 0 1px 0 rgba(0,0,0,0.03) inset;
  margin-bottom: 30px;
}

input[type="radio"],
input[type="checkbox"] {
  margin: 0 4px 8px 0;
}

select {
  padding: 6px;
  height: 32px;
  border-radius: 2px;
}

button {
  padding: 19px 39px 18px 39px;
  color: #FFF;
  background-color: #4bc970;
  font-size: 18px;
  text-align: center;
  font-style: normal;
  border-radius: 5px;
  width: 100%;
  border: 1px solid #3ac162;
  border-width: 1px 1px 3px;
  box-shadow: 0 -1px 0 rgba(255,255,255,0.1) inset;
  margin-bottom: 10px;
}

fieldset {
  margin-bottom: 30px;
  border: none;
}

legend {
  font-size: 1.4em;
  margin-bottom: 10px;
}

label {
  display: block;
  margin-bottom: 8px;
}

label.light {
  font-weight: 300;
  display: inline;
}

.number {
  background-color: #5fcf80;
  color: #fff;
  height: 30px;
  width: 30px;
  display: inline-block;
  font-size: 0.8em;
  margin-right: 4px;
  line-height: 30px;
  text-align: center;
  text-shadow: 0 1px 0 rgba(255,255,255,0.2);
  border-radius: 100%;
}

@media screen and (min-width: 480px) {

  form {
    max-width: 480px;
  }

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
        
        <div class="bottom-container">
            
            <form name="dataForm" action="dentLogServlet">
                <h1>Dentist Login</h1>
                <input type="text" name="dentistId" placeholder="ID" />
                <input type="text" name="dentistPassword" placeholder="password" />
                <button type="submit">LOGIN</button>
            </form>
        </div>
    </body>
</html>
