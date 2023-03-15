<%@ page isELIgnored="false" import="com.lms.Bean.Member" %>
<%@ page import="com.lms.Bean.Book" %>
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
                                        <td valign="bottom"><h3 style="letter-spacing:1px;">Common Functions > Borrow Books </h3></td>
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
                                    <legend>Query the membership</legend>
                                    <table width="100%" border="1" class="cont"  >
                                        <form action="/lms/borrowBook" method="get">
                                            <%
                                                Member member =(Member) request.getAttribute("member");

                                            %>
                                        <tr>
                                            <td width="8%" class="run-right"> Member ID</td>
                                            <td colspan="7"><input class="text" type="text" id="memberId" name="memberId"/> 
                                                 <input type="submit" id="btnQuery" value="Confirm" style="width: 80px;"/></td>
                           
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
                            <td height="40" colspan="3">
                            </td>
                        </tr>
                        
                        <!--图书搜索条-->
                            <form action="/lms/doBorrowBook" method="post">
                        <tr>
                            <td width="2%">&nbsp;</td>
                            <td width="96%">

                                <fieldset>
                                    <table width="100%" border="1" class="cont"  >

                                    <legend>Query the book</legend>
                                        <tr>
                                            <td colspan="8">
                                                <input class="text" type="text" name="memberId" hidden value="<%=member.getId() %>" />
                                                Please Input:&nbsp;&nbsp;<input class="text" type="text" id="bookContent" name="bookContent" placeholder="Bar Code/Book Name"/>
                                                <input type="button" id="btnQueryBook" onclick="OnSearchBook()"  value="Confirm" style="width: 80px;"/>
                                                <input type="submit" id="btnSubmit" value="Borrow" style="width: 80px;"/>
                                            </td>
                                         
                                        </tr>

                                    </table>
                                </fieldset>
                            </td>
                            <td width="2%">&nbsp;</td>
                        </tr>
                            </form>
                        <tr><td height="20" colspan="3"></td></tr>
                        <tr>
                            <td width="2%">&nbsp;</td>
                            <td width="96%">
                                <table width="100%">
                                    <%
                                        List<Book> books =(ArrayList) request.getAttribute("books");

                                    %>
                                    <tr>
                                        <td colspan="2">
                                            <form action="/lms/borrowBook" method="post">
                                                <table id="bookTable" width="100%"  class="cont tr_color">
                                                    <tr>
                                                        <th><input id="ckAll" type="checkbox" value=""/>Select All/Select None</th>
                                                        <th>Book Name</th>
                                                        <th>Stock</th>
                                                        <th>Publisher</th>
                                                        <th>Book Rack</th>
                                                        <th>Price(Euro)</th>
                                                    </tr>
<%--                                                    <%for (int i=0;i<books.size();i++){%>--%>
<%--                                                    <tr align="center" class="d">--%>
<%--                                                        <td><input class="ck" type="checkbox" name="" value="" /></td>--%>
<%--                                                        <td><%=books.get(i).getName()%></td>--%>
<%--                                                        <td><%=books.get(i).getStock()%></td>--%>
<%--                                                        <td><%=books.get(i).getPublish()%></td>--%>
<%--                                                        <td><%=books.get(i).getAddress()%></td>--%>
<%--                                                        <td><%=books.get(i).getPrice()%></td>--%>
<%--                                                    </tr>--%>
<%--                                                    <%}%>--%>

                                                   
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
        <script src="./Js/jquery-3.3.1.min.js"></script>
    <script>
        function OnChecked(e) {
                $.get("<%=request.getContextPath()%>/doBorrowBook?id="+e.dataset.bid+"&checked="+e.checked,
                    function(data, status){
                });
        }
function OnSearchBook() {
  var name=  $("#bookContent").val();
    $.post("<%=request.getContextPath()%>/borrowBook?bookContent="+name, function(data, status){
        $("#bookTable").find("tr:not(:first)").remove();
        var trHTML = '';
         var obj =data;// $.parseJSON(data);

        for (var i = 0; i < obj.length; i++) {
            trHTML += ' <tr align="center" class="d">'+
                '<td><input class="ck" type="checkbox" data-bid="'+obj[i].id+'" name="" onclick="OnChecked(this)" value="" /></td>'+
                '<td>'+obj[i].name+'</td>'+
                '<td>'+obj[i].stock+'</td>'+
                '<td>'+obj[i].publish+'</td>'+
                '<td>'+obj[i].address+'</td>'+
                '<td>'+obj[i].price+'</td>'+
                '</tr>';
        }
        $("#bookTable tbody").append(trHTML);
    });
}
    </script>
    </body>
</html>