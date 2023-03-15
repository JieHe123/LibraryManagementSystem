<%@ page isELIgnored="false" import="com.lms.Bean.Type" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html >
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
                                        <td valign="bottom"><h3 style="letter-spacing:1px;"> Book Type Management > Manage the types</h3></td>
                                    </tr>
                                    <span style="color: red" id="error">${error}</span>
                                    <span style="color: green" id="success">${success}</span>
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
                        <!-- 添加栏目开始 -->
                        <tr>
                            <td width="2%">&nbsp;</td>
                            <td width="96%">

                                <table width="100%">
                                    <tr>
                                        <td colspan="2">
                                            <form action="/lms/allBookTypes" method="get">
                                                <table width="60%"  class="cont tr_color">

                                                    <tr>
                                                       
                                                        <th>Book Type ID</th>
                                                        <th>Book Type Name</th>
                                                        <th>The Parent Type</th>
                                                        <th>Operations</th>
                                                    </tr>

                                                    <%
                                                    List<Type> allBookTypes =(ArrayList)request.getAttribute("allBookTypes");
                                                    for (int i=0; i<allBookTypes.size();i++){
                                                %>
                                                    <tr align="center" class="d">
                                                        <td><%=i+1%></td>
                                                        <td><%=allBookTypes.get(i).getName()%></td>
                                                        <td><%=allBookTypes.get(i).getParentId()%></td>
                                                        <td>
                                                            <a href="/lms/bookTypeModify?id=<%=allBookTypes.get(i).getId()%>">Revise</a>
                                                            <a href="/lms/delBookType?id=<%=allBookTypes.get(i).getId()%>">Delete</a>
                                                        </td>
                                                    </tr>
                                                    <%}%>

                                                   
                                                </table>
                                            </form>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                            <td width="2%">&nbsp;</td>
                        </tr>
                        <!-- 添加栏目结束 -->
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