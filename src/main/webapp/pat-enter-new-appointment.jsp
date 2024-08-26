<%-- 
    Document   : pat-enter-new-appointment
    Created on : Nov 10, 2022, 2:39:25 PM
    Author     : jasonwilsonrodriguez
--%>

<%@page import="Business.Patient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Patient Add Appointment</title>
        <link href='https://fonts.googleapis.com/css?family=Nunito:400,300' rel='stylesheet' type='text/css'>
        <style>
                        *, *:before, *:after {
  -moz-box-sizing: border-box;
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
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
                    margin-top: -15px;
                    align-items: center;
                    background:rgba(0, 0, 0, 0.5);
                }
                body {
                    font-family: 'Nunito', sans-serif;
                    font-family: 'Nunito', sans-serif;
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

form {
  max-width: 300px;
  margin: 10px auto;
  margin-top: 50px;
  padding: 10px 20px;
  background: #f4f7f8;
  border-radius: 8px;
  box-shadow: 5px 5px gray;
}

h1 {
  margin: 0;
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
  font-size: 12px;
  height: auto;
  margin: 0;
  outline: 0;
  padding: 5px;
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
  padding: 0px;
  height: 22px;
  border-radius: 2px;
}

button {
  padding: 9px 29px 8px 29px;
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
        <form name="dataForm" action="PatAptAddServlet">
        <h1>Add Appointment</h1>
        <label for="months">Choose a month:</label>

        <select name="months" id="months">
            <option value="January">January</option>
            <option value="February">February</option>
            <option value="March">March</option>
            <option value="April">April</option>
            <option value="May">May</option><!-- <option value="April">April</option> -->
            <option value="June">June</option>
            <option value="July">July</option>
            <option value="August">August</option>
            <option value="September">September</option>
            <option value="October">October</option>
            <option value="November">November</option>
            <option value="December">December</option>
        </select>
        <label for="days">Choose a day:</label>
        <select name="days" id="days">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">6</option>
            <option value="7">7</option>
            <option value="8">8</option>
            <option value="9">9</option>
            <option value="10">10</option>
            <option value="11">11</option>
            <option value="12">12</option>
            <option value="13">13</option>
            <option value="14">14</option>
            <option value="15">15</option>
            <option value="16">16</option>
            <option value="17">17</option>
            <option value="18">18</option>
            <option value="19">19</option>
            <option value="20">20</option>
            <option value="21">21</option>
            <option value="22">22</option>
            <option value="23">23</option>
            <option value="24">24</option>
            <option value="25">25</option>
            <option value="26">26</option>
            <option value="27">27</option>
            <option value="28">28</option>
            <option value="29">29</option>
            <option value="30">30</option>
            <option value="31">31</option>
        </select>
        <label for="years">Choose a year:</label>

        <select name="years" id="years">
            <option value="2018">2018</option>
            <option value="2019">2019</option>
            <option value="2020">2020</option>
            <option value="2021">2021</option>
            <option value="2022">2022</option><!-- <option value="April">April</option> -->
            <option value="2023">2023</option>
            <option value="2024">2024</option>
            <option value="2025">2025</option>
            <option value="2026">2026</option>
            <option value="2027">2027</option>

        </select>
        <label for="time">Choose a time:</label>

        <select name="time" id="time">
            <option value="8am">8am</option>
            <option value="9am">9am</option>
            <option value="10am">10am</option>
            <option value="11am">11am</option>
            <option value="12pm">12pm</option>
            <option value="1pm">1pm</option>
            <option value="2pm">2pm</option>
            <option value="3pm">3pm</option>
            <option value="4pm">4pm</option>

        </select>
        <label for="proc-code">Choose a Procedurew:</label>
        <select name="proc-code" id="proc-code">
            <option value="P114">P114-Cleaning/Exam</option>
            <option value="P119">P119-Xrays</option>
            <option value="P122">P122-Whitening</option>
            <option value="P321">P321-Cavity</option>
            <option value="P650">P650-Top Dentures</option>
            <option value="P660">P660-Bottom Dentures</option>
            <option value="P780">P780-Crown</option>
            <option value="P790">P790-Root Canal</option>
        </select>
        <label for="dent-id">Choose a Dentist:</label>
        <select name="dent-id" id="dent-id">
            <option value="D201">D201-Frank Martin</option>
            <option value="D202">D202-Susan Cassidy</option>
            <option value="D203">D203-Jerry York</option>
            <option value="D204">D204-Wayne Pattersen</option>
            
        </select>
        <button type="submit">SUBMIT</button>
        </form>
            </div>
        
        
    </body>
</html>
