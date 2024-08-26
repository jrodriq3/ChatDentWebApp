<%-- 
    Document   : dent-main-menu
    Created on : Nov 10, 2022, 5:41:46 PM
    Author     : jasonwilsonrodriguez
--%>

<%@page import="Business.Appointment"%>
<%@page import="Business.AppointmentsList"%>
<%@page import="Business.Dentist"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dentist Main Menu</title>
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
                min-width: 100vw;
                min-height: 100vh;
               
                
                
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
                height: fit-content;
                justify-content: center;
                box-shadow: 5px 5px gray;
                
                
                padding: 10px;
                
                align-content: center;
                border-radius: 25px;
                background: rgb(255, 255, 255, 1);
            }
            .container-2 {
                display: flex;
                align-items: center;
                width:  100%;
                height: fit-conten;
                justify-content: center;
                align-content: center;
                border-radius: 25px;
                margin-top: 25px;
            }
            .bottom-container{
                display: flex;
                flex-direction: column;
                min-height: 100vh;
                min-width: 100vw;
                justify-content: center;
                margin-top: -25px;
                align-items: center;
                background:rgba(0, 0, 0, 0.5);
                
            }
            .bottom-table-container {
                background: rgb(255, 255, 255, 1);
                display: flex;
                justify-content: center;
                align-items: center;
                flex-direction: column;
                margin-top: 40px;
                margin-bottom: 40px;
                border-radius: 25px;
                padding: 12px;
                box-shadow: 5px 5px gray;
            }
            td{
                color:  darkblue;
            }
            th {
                color: darkblue;
            }
            a {
                padding: 15px;
                text-decoration: none;
                color: black;
                width: 150px;
                height: fit-content;
                font-size:medium;
                background: rgb(12, 154, 42, 1);
                margin: 10px;
                justify-content: center;
                display: flex;
                border-style: groove;
                border-width: 2px;
                border-color: black;
                box-shadow: 5px 5px gray;
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
        <% 
          Dentist dentist = (Dentist) session.getAttribute("dentist");
          
        %>
        
        <div class="bottom-container">
            <div class="container-1">
                <table style="border: 1px solid black;">
            <thead>
            <th style="align-self: center">Dentist Information</th>
            </thead>
            <tr>
                <td style="border: 1px solid black;">First Name</td>
                <td style="border: 1px solid black;"><%= dentist.getFirstName()%></td>
            </tr>
            <tr>
                <td style="border: 1px solid black;">Last Name</td>
                <td style="border: 1px solid black;"><%= dentist.getLastName()%></td>
            </tr>
            <tr>
                <td style="border: 1px solid black;">Email</td>
                <td style="border: 1px solid black;"><%= dentist.getEmail() %></td>
            </tr>
            <tr>
                <td style="border: 1px solid black;">Dentist ID</td>
                <td style="border: 1px solid black;"><%= dentist.getId() %></td>
            </tr>
            <tr>
                <td style="border: 1px solid black;">Office</td>
                <td style="border: 1px solid black;"><%= dentist.getOffice() %></td>
            </tr>
            <tr>
                <td style="border: 1px solid black;">Password</td>
                <td style="border: 1px solid black;"><%= dentist.getPasswd() %></td>
            </tr>
                </table>
            </div>
            
            <div class="bottom-table-container">
            <table style="border: 1px solid black;" >
            <thead>
            <h3 style="color: darkblue">Upcoming Appointments</h3>
                <th>Procedure code</th>
                <th>Date</th>
                <th>Patient ID</th>
                <th>Dentist ID</th>
                </thead>
                <%
                    int numOfApts = dentist.getAppointmentsList().getAptCount();
                    for (int i = 0; i < numOfApts; i++) {
                        Appointment currentAppointment = dentist.getAppointmentsList().getAppointmentIndex(i);
                        out.println("<tr>");
                        out.println("<td>" + currentAppointment.getProcCode() + "</td>");
                        out.println("<td>" + currentAppointment.getApptDateTime() + "</td>");
                        out.println("<td>" + currentAppointment.getPatId() + "</td>");
                        out.println("<td>" + currentAppointment.getDentId() + "</td>");
                        out.println("</tr>");
                    }
                        
                        
                %>
        </table>
        
        </div>
        <a href="dent-change-info.jsp" style="padding-left: 10px;">Change Personal Info</a>
        </div>
    </body>
</html>
