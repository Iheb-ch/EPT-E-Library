<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Design by foolishdeveloper.com -->
    <title>Glassmorphism login Form Tutorial in html css</title>

    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;600&display=swap" rel="stylesheet">
    <!--Stylesheet-->
    <style media="screen">
        *,
        *:before,
        *:after{
            padding: 0;
            margin: 0;
            box-sizing: border-box;
        }
        body{
            background : url("../resources/images/ept.jpg");
            -webkit-background-size : cover;
            -moz-background-size : cover;
            -o-background-size : cover;
            background-size : cover;
            /*background-color: #080710;*/
        }
        .background{
            width: 430px;
            height: 520px;
            position: absolute;
            transform: translate(-50%,-50%);
            left: 50%;
            top: 50%;
        }
        .background .shape{
            height: 200px;
            width: 200px;
            position: absolute;
            border-radius: 50%;
        }
        .shape:first-child{
            background: linear-gradient(
                    #1845ad,
                    #23a2f6
            );
            left: -80px;
            top: -80px;
        }
        .shape:last-child{
            background: linear-gradient(
                    to right,
                    #ff512f,
                    #f09819
            );
            right: -30px;
            bottom: -80px;
        }
        form{
            height: 520px;
            width: 400px;
            background-color: rgba(255,255,255,0.13);
            position: absolute;
            transform: translate(-50%,-50%);
            top: 40%;
            left: 80%;
            border-radius: 10px;
            backdrop-filter: blur(10px);
            border: 2px solid rgba(255,255,255,0.1);
            box-shadow: 0 0 40px rgba(8,7,16,0.6);
            padding: 50px 35px;
        }
        form input{
            color: grey;
        }
        form *{
            font-family: 'Poppins',sans-serif;
            color: #ffffff;
            letter-spacing: 0.5px;
            outline: none;
            border: none;
        }
        form h3{
            font-size: 32px;
            font-weight: 500;
            line-height: 42px;
            text-align: center;
        }

        label{
            display: block;
            margin-top: 30px;
            font-size: 16px;
            font-weight: 500;
        }
        input[data-error] {
            display: block;
            border-color : #c92432;
            color: white;
            background-color: rgba(255,230,230,0.3);
        }

        input[data-error]::placeholder{
            color: rgb(255,100,100);
        }

        input{
            display: block;
            height: 50px;
            width: 100%;
            /*background-color: rgba(255,255,255,0.07);*/
            background-color: rgba(255,255,255,0.3);
            border-radius: 3px;
            padding: 0 10px;
            margin-top: 8px;
            font-size: 14px;
            font-weight: 300;
        }
        ::placeholder{
            color: white;
        }
        button {
            margin-top: 50px;
            width: 100%;
            background-color: #ffffff;
            color: #080710;
            padding: 15px 0;
            font-size: 18px;
            font-weight: 600;
            border-radius: 5px;
            cursor: pointer;
        }

        .option{
            color: white;
            font-size: 15px;
            font-weight: 600;
            position: relative ;
            left : 0%;
            bottom: 20%;
        }
        .social{
            margin-top: 30px;
            margin-left: 30px;
            display: flex;
        }
        .social div{
            background: red;
            width: 150px;
            border-radius: 3px;
            padding: 5px 10px 10px 5px;
            background-color: rgba(219,68,55,0.67);
            color: #eaf0fb;
            /*color : #DB4437;*/
            text-align: center;
            position: absolute;
            left: 45%;
        }

        .social div:hover{
            /*background-color: rgba(255,255,255,0.47);*/
            background-color: rgba(219,68,55,0.87);
        }
        /*.social .fb{*/
        /*    margin-left: 25px;*/
        /*}*/
        /*.social i{*/
        /*    margin-right: 4px;*/
        /*}*/

    </style>
</head>
<body>
<%--<div class="background">--%>
<%--    <div class="shape"></div>--%>
<%--    <div class="shape"></div>--%>
<%--</div>--%>
<form class="login" method = "post" >
    <h3>Login Here</h3>


    <c:choose>
        <c:when test="${error}">
            <label for="username">School Email</label>
            <input type="text" id="username" placeholder="wrong id or password !" name = "username" data-error="wrong credentials !">

            <label for="password">Password</label>
            <input type="password" id="password" placeholder= "wrong id or password !" name = "password" data-error="wrong credentials !">
        </c:when>
        <c:otherwise>
            <label for="username">Username</label>
            <input type="text" placeholder="Email" id="username" name = "username" >

            <label for="password">Password</label>
            <input type="password" placeholder="Password" id="password" name = "password" >
        </c:otherwise>
    </c:choose>
    <button>Log In</button>

    <div class="social">
        <p class="option">or login via</p>
        <div class="go"><i class="fab fa-google"></i> Google</div>
        <%--        <div class="fb"><i class="fab fa-facebook"></i>  Facebook</div>--%>
    </div>
</form>
</body>
</html>
