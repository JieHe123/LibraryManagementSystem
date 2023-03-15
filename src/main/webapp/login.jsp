<!DOCTYPE html>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Library Management System</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="description" content="Library Management System" />
    <meta name="keywords" content="Backend,Library Management System,Enterprise System" />
    <meta name="Author" content="Jie" />
    <meta name="CopyRight" content="Library Management System" />
    <link rel="stylesheet" type="text/css" href="./Style/skin.css" />
</head>
    <body>
        <table width="100%" >
            <!-- 顶部部分 -->
            <tr height="41"><td colspan="2" background="./Images/login_top_bg.gif">&nbsp;</td></tr>
            <!-- 主体部分 -->
            <tr style="background:url(Images/login_bg.jpg) repeat-x;" height="532"    >
                <!-- 主体左部分 -->
                <td id="left_cont" valign="top"  width="100%" height="100%">
                    <table  >
                        <tr>
                            <td width="20%" rowspan="2">
                                <ul>
                                    <li><img src="./Images/book.jpg" />&nbsp;<a href="javascript:void(0)"></a></li>
                                </ul>
                             </td>
                        </tr>
                    </table>
                </td>
                <!-- 主体右部分 -->
                <td id="right_cont">
                    <table height="100%">
                        <tr height="30%"><td colspan="3">&nbsp;</td></tr>
                        <tr>
                            <td width="30%" rowspan="5">&nbsp;</td>
                            <td valign="top" id="form">
                                <form id="fmLogin" method="get" action="/lms/login">
                                    <table valign="top" width="50%">
                                        <tr><td colspan="2"><h4 style="letter-spacing:1px;font-size:16px;">Library Management System</h4></td></tr>
                                        <tr><td>Admin ID：</td><td><input type="text" name="name" required /></td></tr>
                                        <tr><td>Password：</td><td><input type="password" name="pwd" required/></td></tr>
<%--                                        <tr><td>Verification Code：</td><td><input type="text" name="valcode" value="" style="width:80px;" required/>&nbsp;<img src="#"/></td></tr>--%>
                                        <tr class="bt"><td>&nbsp;</td><td><input type="submit" value="Login" />&nbsp;<input type="reset" value="Reset" /></td></tr>
                                    </table>
                                    <span style="color: red" id="error">${error}</span>
                                </form>
                            </td>
                            <td rowspan="5">&nbsp;</td>
                        </tr>
                        <tr><td colspan="3">&nbsp;</td></tr>
                    </table>
                </td>
            </tr>
            <!-- 底部部分 -->
            <tr id="login_bot"><td colspan="2"><p>Customer Service Email Address：xxxx@gmail.com</p></td></tr>
        </table>
        <script src="./Js/jquery-3.3.1.min.js"></script>
    <script>
       // $("#error").text("");
    </script>
    </body>
</html>