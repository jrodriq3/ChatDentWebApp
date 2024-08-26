<%-- 
    Document   : pat-delete-appointment
    Created on : Nov 14, 2022, 6:15:15 PM
    Author     : jasonwilsonrodriguez
--%>

<%@page import="Business.Patient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Patient Drop Appointment</title>
        <link href='https://fonts.googleapis.com/css?family=Nunito:400,300' rel='stylesheet' type='text/css'>
        <style>
            @import url('https://fonts.googleapis.com/css?family=Amatic+SC');
            h2 {
                color: white;
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
            
            
            
            
.button_container {
	position: absolute;
  left: 0;
  right: 0;
  top: 30%;
}

.description, .link {
  font-family: 'Amatic SC', cursive;
  text-align: center;
}

.description {
	font-size: 35px;
}

.btn {
  border: none;
  display: block;
  text-align: center;
  cursor: pointer;
  text-transform: uppercase;
  outline: none;
  overflow: hidden;
  position: relative;
  color: #fff;
  font-weight: 700;
  font-size: 15px;
  background-color: #222;
  padding: 17px 60px;
  margin: 0 auto;
  box-shadow: 0 5px 15px rgba(0,0,0,0.20);
}

.btn span {
  position: relative; 
  z-index: 1;
}

.btn:after {
  content: "";
  position: absolute;
  left: 0;
  top: 0;
  height: 490%;
  width: 140%;
  background: #78c7d2;
  -webkit-transition: all .5s ease-in-out;
  transition: all .5s ease-in-out;
  -webkit-transform: translateX(-98%) translateY(-25%) rotate(45deg);
  transform: translateX(-98%) translateY(-25%) rotate(45deg);
}

.btn:hover:after {
  -webkit-transform: translateX(-9%) translateY(-25%) rotate(45deg);
  transform: translateX(-9%) translateY(-25%) rotate(45deg);
}

.link {
  font-size: 20px;
  margin-top: 30px;
}

.link a {
  color: #000;
  font-size: 25px; 
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
    <center>
        <% 
        Patient patient = (Patient) session.getAttribute("patient");
        out.println("<h2>Next Appointment: " + patient.getAppointment().getApptDateTime() + "</h2>");
        %>
        </center>
        <form name="dataForm" action="PatAptDeleteServlet">
            
            <div class="button_container">
            <button class="btn" type="submit"><span>Drop Appointment</span></button>            
            </div>
        </form>
        </div>
    </body>
</html>
