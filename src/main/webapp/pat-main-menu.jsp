<%-- 
    Document   : pat-main-menu
    Created on : Nov 9, 2022, 6:41:36 PM
    Author     : jasonwilsonrodriguez
--%>

<%@page import="Business.Patient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>pat-main-menu</title>
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
                height: fit-content;
                justify-content: center;
                margin-top: 75px;
                
                box-shadow: 5px 5px gray;
                padding: 20px;
                
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
                
                align-items: center;
                background:rgba(0, 0, 0, 0.5);
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
                background: white;
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
            Patient patient = (Patient) session.getAttribute("patient");
        %>
        <div class="bottom-container">
        <div class="container-1">
            <table style="border: 1px solid black; display: flex;" >
                <thead>
                    <th style="align-self: center">Patient Information</th>
                </thead>
                <tr>
                    <td style="border: 1px solid black;">First Name</td>
                    <td style="border: 1px solid black;"><%= patient.getFirstName()%></td>
                </tr>
                <tr>
                    <td style="border: 1px solid black;">Last Name</td>
                    <td style="border: 1px solid black;"><%= patient.getLastName()%></td>
                </tr>
                <tr>
                    <td style="border: 1px solid black;">Email</td>
                    <td style="border: 1px solid black;"><%= patient.getEmail() %></td>
                </tr>
                <tr>
                    <td style="border: 1px solid black;">Insurance</td>
                    <td style="border: 1px solid black;"><%= patient.getInsCo() %></td>
                </tr>
                <tr>
                    <td style="border: 1px solid black;">Patient ID</td>
                    <td style="border: 1px solid black;"><%= patient.getPatId() %></td>
                </tr>
                <tr>
                    <td style="border: 1px solid black;">Password</td>
                    <td style="border: 1px solid black;"><%= patient.getPasswd() %></td>
                </tr>
                <tr>
                    <td style="border: 1px solid black;">Next Appointment</td>
                    <td style="border: 1px solid black;"><%= patient.getAppointment().getApptDateTime() %></td>
                </tr>
                <tr>
                    <td style="border: 1px solid black;">Dentist</td>
                    <td style="border: 1px solid black;"><%= patient.getAppointment().getDentist().getFirstName() %>
                                                     <%= patient.getAppointment().getDentist().getLastName() %>
                    </td>
                </tr>
                <tr>
                    <td style="border: 1px solid black;">Procedure</td>
                    <td style="border: 1px solid black;">
                    <%= patient.getAppointment().getProcedure().getProcName()%>
                    <%= patient.getAppointment().getProcedure().getProcDesc()%>
                    
                    </td>
                </tr>
            </table>
        </div>
                    <div class="container-2"> 
                        <a href="pat-change-info.jsp" >Change Info</a>
                        <% 
                        if (patient.getAppointment().getApptDateTime().equals("")) {
                            out.println("<a href='pat-enter-new-appointment.jsp' >Add Appointment</a>");
                        } else {
                            out.println("<a href='pat-delete-appointment.jsp' >Drop Appointment</a><br>");
                            out.println("<a href='pat-change-appointment.jsp' >Change Appointment</a>");
                        }
                        %>
                    </div>
                    </div>
    </body>
</html>
