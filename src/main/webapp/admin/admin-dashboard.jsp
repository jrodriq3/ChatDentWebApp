<%-- 
    Document   : admin-dashboard
    Created on : Nov 12, 2022, 5:34:50 PM
    Author     : jasonwilsonrodriguez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Dashboard</title>
    </head>
    <body>
        <h1>Admin Dashboard</h1>
        <form name="dataForm" action="adminPatAddServlet">
            <table style="border: 1px solid black;">
                <thead>
                    Patient Add
                </thead>
                <tr>
                    <td style="border: 1px solid black">First Name</td>
                    <td><input type="text" name="first-name"/></td>
                </tr>
                <tr>
                    <td style="border: 1px solid black">Last Name</td>
                    <td><input type="text" name="last-name"/></td>
                </tr>
                <tr>
                    <td style="border: 1px solid black">Address</td>
                    <td><input type="text" name="address"/></td>
                </tr>
                <tr>
                    <td style="border: 1px solid black">Insurance Company</td>
                    <td><input type="text" name="ins-co"/></td>
                </tr>
                <tr>
                    <td style="border: 1px solid black">Patient Id</td>
                    <td><input type="text" name="pat-id"/></td>
                </tr>
                <tr>
                    <td style="border: 1px solid black">Password</td>
                    <td><input type="text" name="password"/></td>
                </tr>
                <tr>
                    <td><button type="submit">ADD PATIENT</button></td>
                </tr>
                
            </table>
        </form>
        <br>
        <br>
        <br>
        <form name="dataForm" action="adminPatDeleteServlet">
            <table style="border: 1px solid black;">
                <thead>
                    Patient Delete
                </thead>
                <tr>
                    <td style="border: 1px solid black">Patient Id</td>
                    <td><input type="text" name="patient-id"/></td>
                </tr>
                <tr>
                    <td><button type="submit">DELETE PATIENT</button></td>
                </tr>
                
            </table>
        </form>
        <br>
        <br>
        <br>
        <form name="dataForm" action="adminDentAddServlet">
            <table style="border: 1px solid black;">
                <thead>
                    Dentist Add
                </thead>
                <tr>
                    <td style="border: 1px solid black">First Name</td>
                    <td><input type="text" name="dent-first-name"/></td>
                </tr>
                <tr>
                    <td style="border: 1px solid black">Last Name</td>
                    <td><input type="text" name="dent-last-name"/></td>
                </tr>
                <tr>
                    <td style="border: 1px solid black">Email</td>
                    <td><input type="text" name="dent-email"/></td>
                </tr>
                <tr>
                    <td style="border: 1px solid black">Id</td>
                    <td><input type="text" name="dent-id"/></td>
                </tr>
                <tr>
                    <td style="border: 1px solid black">Office</td>
                    <td><input type="text" name="dent-office"/></td>
                </tr>
                <tr>
                    <td style="border: 1px solid black">Password</td>
                    <td><input type="text" name="dent-password"/></td>
                </tr>
                <tr>
                    <td><button type="submit">ADD DENTIST</button></td>
                </tr>
                
            </table>
        </form>
        <br>
        <br>
        <br>
        <form name="dataForm" action="adminDentDeleteServlet">
            <table style="border: 1px solid black;">
                <thead>
                    Dentist Delete
                </thead>
                <tr>
                    <td style="border: 1px solid black">Dentist Id</td>
                    <td><input type="text" name="dentist-id"/></td>
                </tr>
                <tr>
                    <td><button type="submit">DELETE DENTIST</button></td>
                </tr>
                
            </table>
        </form>
    </body>
</html>
