<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html >
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="keywords"  content = "图书 java jsp"/>
    <meta http-equiv="author" content="phenix"/>
    <link rel="stylesheet" type="text/css" href="./Style/skin.css" />
</head>
    <body>
        <table width="100%" border="0" cellpadding="0" cellspacing="0">
            <!-- 头部开始 -->
            <tr>
                <td width="17" valign="top" background="./Images/mail_left_bg.gif">
                    <img src="./Images/left_top_right.gif" width="17" height="29" />
                </td>
                <td valign="top" background="./Images/content_bg.gif">
                    
                </td>
                <td width="16" valign="top" background="./Images/mail_right_bg.gif"><img src="./Images/nav_right_bg.gif" width="16" height="29" /></td>
            </tr>
            <!-- 中间部分开始 -->
            <tr>
                <!--第一行左边框-->
                <td valign="middle" background="./Images/mail_left_bg.gif">&nbsp;</td>
                <!--第一行中间内容-->
                <td valign="top" bgcolor="#F7F8F9">
                    <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <!-- 空白行-->
                        <tr><td colspan="2" valign="top">&nbsp;</td><td>&nbsp;</td><td valign="top">&nbsp;</td></tr>
                        <tr>
                            <td colspan="4">
                                <table>
                                    <tr>
                                        <td width="100" align="center"><img src="./Images/mime.gif" /></td>
                                        <td valign="bottom"><h3 style="letter-spacing:1px;">Common Functions > Book Checkout history </h3></td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                        <!-- 一条线 -->
                        <tr>
                            <td height="40" colspan="4">
                                <table width="100%" height="1" border="0" cellpadding="0" cellspacing="0" bgcolor="#CCCCCC">
                                    <tr><td></td></tr>
                                </table>
                            </td>
                        </tr>
                        <tr>
                            <td width="2%">&nbsp;</td>
                            <td width="96%">
                                <fieldset>
                                    <legend>query condition</legend>
                                    <table width="100%" border="1" class="cont"  >
                                        <tr>
                                            <td colspan="8" align="center">
                                                <input type="radio" name="query" value="0"/>All &nbsp;&nbsp;
                                                <input type="radio" name="query" value="1"/>Returned &nbsp;&nbsp;
                                                <input type="radio" name="query" value="2"/>Not returned &nbsp;&nbsp;
                                                <input type="radio" name="query" value="3"/>Need to return within a week &nbsp;&nbsp;
                                                Please input the keyword:&nbsp;&nbsp;<input class="text" type="text" id="keyword" name="keyword"/>
                                                <input type="button" id="btnQuery" value="Search" style="width: 80px;"/></td>
                                            </td>
                                        </tr>
                                    </table>
                                </fieldset>
                            </td>
                            <td width="2%">&nbsp;</td>
                        </tr>
                      
                        <!--空行-->
                        <tr>
                            <td height="40" colspan="3">
                            </td>
                        </tr>
                        <!-- 产品列表开始 -->
                        <tr>
                            <td width="2%">&nbsp;</td>
                            <td width="96%">
                                <table width="100%">
                                    <tr>
                                        <td colspan="2">
                                            <form action="" method="">
                                                <table width="100%"  class="cont tr_color">
                                                    <tr>
                                                        <th><input id="ckAll" type="checkbox" value=""/>Select All/Select None</th>
                                                        <th>Book Name</th>
                                                        <th>Borrowing Time</th>
                                                        <th>Due date</th>
                                                        <th>Publisher</th>
                                                        <th>Book Rack</th>
                                                        <th>Price(Euro)</th>
                                                        <th>Actual Return Time</th>
                                                        <th>Status</th>
                                                    </tr>
                                                    <tr align="center" class="d">
                                                        <td><input class="ck" type="checkbox" value="" /></td>
                                                        <td>罗小黑战记</td>
                                                        <td>2010-10-01</td>
                                                        <td>2010-10-31</td>
                                                        <td>北京联合出版社</td>
                                                        <td>东区-01-02</td>
                                                        <td>39.9</td>
                                                        <td>2023-02-11</td>
                                                        <td>归还状态</td>
                                                    </tr>
                                                </table>
                                            </form>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                            <td width="2%">&nbsp;</td>
                        </tr>
                        <!-- 产品列表结束 -->
                        <tr>
                            <td height="40" colspan="4">
                                <table width="100%" height="1" border="0" cellpadding="0" cellspacing="0" bgcolor="#CCCCCC">
                                    <tr><td></td></tr>
                                </table>
                            </td>
                        </tr>
                        <tr>
                            <td width="2%">&nbsp;</td>
                            <td width="51%" class="left_txt">
                                <img src="./Images/icon_mail.gif" width="16" height="11"> Customer Service Email Address：xxxx@gmail.com<br />
                            </td>
                            <td>&nbsp;</td><td>&nbsp;</td>
                        </tr>
                    </table>
                </td>
                <td background="./Images/mail_right_bg.gif">&nbsp;</td>
            </tr>
            <!-- 底部部分 -->
            <tr>
                <td valign="bottom" background="./Images/mail_left_bg.gif">
                    <img src="./Images/buttom_left.gif" width="17" height="17" />
                </td>
                <td background="./Images/buttom_bgs.gif">
                    <img src="./Images/buttom_bgs.gif" width="17" height="17">
                </td>
                <td valign="bottom" background="./Images/mail_right_bg.gif">
                    <img src="./Images/buttom_right.gif" width="16" height="17" />
                </td>           
            </tr>
        </table>
    </body>
</html>