<%-- 
    Document   : dent-change-info
    Created on : Nov 12, 2022, 8:09:46 AM
    Author     : jasonwilsonrodriguez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>dent-change-info</title>
        <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600' rel='stylesheet' type='text/css'>
        <link href="//netdna.bootstrapcdn.com/font-awesome/3.1.1/css/font-awesome.css" rel="stylesheet">
        <style>
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
            .testbox {
                justify-content: center;
                margin-top: 120px;
                width: 343px; 
                height: 364px; 
                -webkit-border-radius: 8px/7px; 
                -moz-border-radius: 8px/7px; 
                border-radius: 8px/7px; 
                background-color: #ebebeb; 
                -webkit-box-shadow: 1px 2px 5px rgba(0,0,0,.31); 
                -moz-box-shadow: 1px 2px 5px rgba(0,0,0,.31); 
                box-shadow: 1px 2px 5px rgba(0,0,0,.31); 
                border: solid 1px #cbc9c9;
                box-shadow: 5px 5px gray;
            }
             .bottom-container{
                display: flex;
                flex-direction: column;
                min-height: 100vh;
                min-width: 100vw;
                align-items: center;
                background:rgba(0, 0, 0, 0.5);
            }
            body, div, dl, dt, dd, ul, ol, li, h1, h2, h3, h4, h5, h6, 
            pre, form, fieldset, input, textarea, p, blockquote, th, td { 
                padding:0;
                margin:0;
            }

            fieldset, img {
                border:0
            }

            ol, ul, li {
                list-style:none
            }

            :focus {
                outline:none
            }

            body,
            input,
            textarea,
            select {
                font-family: 'Open Sans', sans-serif;
                font-size: 16px;
                color: #4c4c4c;
            }

            p {
                font-size: 12px;
                width: 150px;
                display: inline-block;
                margin-left: 18px;
            }
            h1 {
                font-size: 32px;
                font-weight: 300;
                color: #4c4c4c;
                text-align: center;
                padding-top: 10px;
                margin-bottom: 10px;
            }

            html{
                background-color: #ffffff;
            } 
input[type=radio] {
                visibility: hidden;
            }

            form{
                margin: 0 30px;
            }

            label.radio {
                cursor: pointer;
                text-indent: 35px;
                overflow: visible;
                display: inline-block;
                position: relative;
                margin-bottom: 15px;
            }

            label.radio:before {
                background: #3a57af;
                content:'';
                position: absolute;
                top:2px;
                left: 0;
                width: 20px;
                height: 20px;
                border-radius: 100%;
            }

            label.radio:after {
                opacity: 0;
                content: '';
                position: absolute;
                width: 0.5em;
                height: 0.25em;
                background: transparent;
                top: 7.5px;
                left: 4.5px;
                border: 3px solid #ffffff;
                border-top: none;
                border-right: none;
                -webkit-transform: rotate(-45deg);
                -moz-transform: rotate(-45deg);
                -o-transform: rotate(-45deg);
                -ms-transform: rotate(-45deg);
                transform: rotate(-45deg);
            }

            input[type=radio]:checked + label:after {
                opacity: 1;
            }

            hr{
                color: #a9a9a9;
                opacity: 0.3;
            }

            input[type=text],input[type=password]{
                width: 200px; 
                height: 39px; 
                -webkit-border-radius: 0px 4px 4px 0px/5px 5px 4px 4px; 
                -moz-border-radius: 0px 4px 4px 0px/0px 0px 4px 4px; 
                border-radius: 0px 4px 4px 0px/5px 5px 4px 4px; 
                background-color: #fff; 
                -webkit-box-shadow: 1px 2px 5px rgba(0,0,0,.09); 
                -moz-box-shadow: 1px 2px 5px rgba(0,0,0,.09); 
                box-shadow: 1px 2px 5px rgba(0,0,0,.09); 
                border: solid 1px #cbc9c9;
                margin-left: -5px;
                margin-top: 13px; 
                padding-left: 10px;
            }

            input[type=password]{
                margin-bottom: 25px;
            }

            #icon {
                display: inline-block;
                width: 30px;
                background-color: #3a57af;
                padding: 8px 0px 8px 15px;
                margin-left: 15px;
                -webkit-border-radius: 4px 0px 0px 4px; 
                -moz-border-radius: 4px 0px 0px 4px; 
                border-radius: 4px 0px 0px 4px;
                color: white;
                -webkit-box-shadow: 1px 2px 5px rgba(0,0,0,.09);
                -moz-box-shadow: 1px 2px 5px rgba(0,0,0,.09); 
                box-shadow: 1px 2px 5px rgba(0,0,0,.09); 
                border: solid 0px #cbc9c9;
            }

            .gender {
                margin-left: 30px;
                margin-bottom: 30px;
            }

            .accounttype{
                margin-left: 8px;
                margin-top: 20px;
            }

            a.button {
                font-size: 14px;
                font-weight: 600;
                color: white;
                padding: 6px 25px 0px 20px;
                margin: 10px 8px 20px 0px;
                display: inline-block;
                float: right;
                text-decoration: none;
                width: 50px; height: 27px; 
                -webkit-border-radius: 5px; 
                -moz-border-radius: 5px; 
                border-radius: 5px; 
                background-color: #3a57af; 
                -webkit-box-shadow: 0 3px rgba(58,87,175,.75); 
                -moz-box-shadow: 0 3px rgba(58,87,175,.75); 
                box-shadow: 0 3px rgba(58,87,175,.75);
                transition: all 0.1s linear 0s; 
                top: 0px;
                position: relative;
            }

            a.button:hover {
                top: 3px;
                background-color:#2e458b;
                -webkit-box-shadow: none; 
                -moz-box-shadow: none; 
                box-shadow: none;
            }
            .sbmButton {
                margin-left: 115px;
                
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
            <div class="testbox">
                <h1>Change Info</h1>
            <form name="dataForm" action="dentInfoChangeServlet">
                <label id="icon" for="first-name"><i class="icon-user "></i></label>
                <input type="text" name="first-name" id="name" placeholder="First Name" required/>
                <label id="icon" for="last-name"><i class="icon-user"></i></label>
                <input type="text" name="last-name" id="name" placeholder="Last Name" required/>            
                <label id="icon" for="email"><i class="icon-envelope "></i></label>
                <input type="text" name="email" id="name" placeholder="Email" required/>
                <label id="icon" for="password"><i class="icon-shield"></i></label>
                <input type="password" name="password" id="name" placeholder="Password" required/>
                <button type="submit" class="sbmButton">Submit</button>
            </form>
            </div>
        </div>
    </body>
</html>
