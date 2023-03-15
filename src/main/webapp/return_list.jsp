<%@ page isELIgnored="false" import="com.lms.Bean.Member" %>
<%@ page import="com.lms.Bean.RecordCombine" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
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
                                        <td valign="bottom"><h3 style="letter-spacing:1px;">Common Function > Return Book </h3></td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                        <!-- 一条线 -->
                        <tr>
                            <td height="20" colspan="4">
                                <table width="100%" height="1" border="0" cellpadding="0" cellspacing="0" bgcolor="#CCCCCC">
                                    <tr><td></td></tr>
                                </table>
                            </td>
                        </tr>
                        <!-- 会员信息开始 -->
                        <tr>
                            <td width="2%">&nbsp;</td>
                            <td width="96%">
                                <fieldset>
                                    <legend>Quary Membership</legend>
                                    <table width="100%" border="1" class="cont"  >
                                        <form action="/lms/returnBook" method="get">
                                                <%
                                                Member member =(Member) request.getAttribute("member");

                                            %>
                                        <tr>
                                            <td width="8%" class="run-right"> Member ID</td>
                                            <td colspan="7"><input class="text" type="text" id="memberId" name="memberId"/>
                                                <input type="submit" id="btnQuery" value="Confirm" style="width: 80px;"/></td>
                                                </td>
                                            </td>
                                         
                                        </tr>
                                        <tr>
                                            <td width="8%" class="run-right">Member Name</td>
                                            <td width="17%"><input class="text" type="text" id="memberName" name="memberName" value="<%=member.getName()%>" readonly/></td>
                                            <td width="8%" class="run-right">Member Type:</td>
                                            <td width="17%"><input class="text" type="text" id="memberType" name="memberType" value="<%=member.getTypeId()%>" readonly/></td>
                                            <td width="8%" class="run-right">Account Balance</td>
                                            <td width="17%"><input class="text" type="text" id="balance" name="balance" value="<%=member.getBalance()%>" readonly/></td>
                                        </tr>
                                        </form>
                                    </table>
                                </fieldset>
                            </td>
                            <td width="2%">&nbsp;</td>
                        </tr>
                      
                        <!--空行-->
                        <tr>
                            <td height="20" colspan="3">
                            </td>
                        </tr>
                        
                       <!--详细信息-->
                        <tr>
                            <td width="2%">&nbsp;</td>
                            <td width="96%">
                                <table width="100%">
                                    <tr>
                                        <td colspan="2">
                                            <form action="" method="">
                                                <table width="100%"  class="cont tr_color">
                                                    <span style="color: red" id="error">${error}</span>
                                                    <span style="color: green" id="success">${success}</span>
                                                    <tr>
                                                        <th><input id="ckAll" type="checkbox" value=""/>Select All/Select None</th>
                                                        <th>Book ID</th>
                                                        <th>Book Name</th>
                                                        <th>isbn</th>
                                                        <th>Borrowing Time</th>
                                                        <th>Due Time</th>
                                                        <th>Publisher</th>
                                                        <th>Book Rack</th>
                                                        <th>Price(Euro)</th>
                                                        <th>Operations</th>
                                                    </tr>

                                                    <%
                                                        List<RecordCombine> recordCombines =(ArrayList)request.getAttribute("recordCombines");
                                                        for (int i=0; i<recordCombines.size();i++){
                                                            if("Late Return".equals(recordCombines.get(i).getStatus())) continue;;
                                                    %>
                                                    <tr align="center" class="d">
                                                        <td><input class="ck" type="checkbox" value="" /></td>
                                                        <td><%=recordCombines.get(i).getId()%></td>
                                                        <td><%=recordCombines.get(i).getBookName()%></td>
                                                        <td><%=recordCombines.get(i).getIsbn()%></td>
                                                        <td><%=recordCombines.get(i).getRentDate()%></td>
                                                        <td><%=recordCombines.get(i).getBackDate()%>></td>
                                                        <td><%=recordCombines.get(i).getPublish()%></td>
                                                        <td><%=recordCombines.get(i).getAddress()%></td>
                                                        <td><%=recordCombines.get(i).getPrice()%></td>
                                                        <td><a href="<%=request.getContextPath()%>/returnBook2?bookId=
<%=recordCombines.get(i).getBookId()%>&memberId=<%=recordCombines.get(i).getMemberId()%>&recordId=<%=recordCombines.get(i).getId()%>">Return</a>&nbsp;&nbsp;<a href="#">renewal of borrowing</a></td>
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