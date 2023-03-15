<%@ page isELIgnored="false" import="com.lms.Bean.Book" %>
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
                                        <td valign="bottom"><h3 style="letter-spacing:1px;">Book management > Book list </h3></td>
                                        <span style="color: red" id="error">${error}</span>
                                        <span style="color: green" id="success">${success}</span>
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
                        <!-- 产品列表开始 -->
                        <tr>
                            <td width="2%">&nbsp;</td>
                            <td width="96%">


                                <table width="100%">
                                    <tr>
                                        <td colspan="2">
                                            <form action="/lms/getAllBooks" method="get">
                                                <table width="100%"  class="cont tr_color">
                                                    <tr>
                                                        <th>Book ID</th>
                                                        <th>Book Name</th>
                                                        <th>Book Type</th>
                                                        <th>Author</th>
                                                        <th>Publisher</th>
                                                        <th>Stock</th>
                                                        <th>Cover</th>
                                                        <th>Operation</th>
                                                    </tr>

                                                    <%
                                                        List<Book> allBooks =(ArrayList)request.getAttribute("allBooks");
                                                        for (int i=0; i<allBooks.size();i++){
                                                    %>

                                                    <tr align="center" class="d">
                                                      <td><a href="book_details.jsp"><%=i+1%></a></td>
                                                        <td><%=allBooks.get(i).getName()%></td>
                                                        <td><%=allBooks.get(i).getType().getName()%></td>
                                                        <td><%=allBooks.get(i).getAuthor()%></td>
                                                        <td><%=allBooks.get(i).getPublish()%></td>
                                                        <td><%=allBooks.get(i).getStock()%></td>
                                                        <td><img src="<%=allBooks.get(i).getPic()%>" class="cover"/></td>
                                                        <td>
                                                            <a href="/lms/bookModify?id=<%=allBooks.get(i).getId()%>">Revise</a>&nbsp;
                                                            <a href="/lms/delBook?id=<%=allBooks.get(i).getId()%>">Delete</a>
                                                        </td>
                                                    </tr>
                                                    <%}%>

                                                   <tr><td colspan="8" align="center">
                                                    <div class="pager">
                                                        <ul class="clearfix">
                                                            <li><a href="#">Last page</a></li>
                                                            <li class="current">1</li>
                                                            <li><a href="#">2</a></li>
                                                            <li><a href="#">3</a></li>
                                                            <li><a href="#">4</a></li>
                                                            <li><a href="#">5</a></li>
                                                            <li><a href="#">Next page</a></li>
                                                        </ul>
                                                    </div>
                                                   </td></tr>
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