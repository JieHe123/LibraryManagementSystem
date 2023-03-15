<%@ page isELIgnored="false" import="com.lms.Bean.Book" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.lms.Bean.Type" %>
<!DOCTYPE html >
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html >
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="keywords"  content = "图书 java jsp"/>
    <meta http-equiv="author" content="phenix"/>
    <link rel="stylesheet" type="text/css" href="./Style/skin.css" />
    <script src="Js/jquery-3.3.1.min.js"></script>
    <script>
        //图片预览
        function getFullPath(obj){
            if (obj){
                //ie
                if (window.navigator.userAgent.indexOf("MSIE") >= 1){
                    obj.select();
                    return document.selection.createRange().text;
                }else if (window.navigator.userAgent.indexOf("Firefox") >= 1){
                    //firefox　
                    return window.URL.createObjectURL(obj.files.item(0));
                }else if(navigator.userAgent.indexOf("Chrome")>0){
                    //chrome
                    return window.URL.createObjectURL(obj.files.item(0));
                }
                return obj.value;
            }
        }
        $(function(){
            $("#filePic").change(function(){
                var path = getFullPath($(this)[0]);
                console.log(path);
                $("#imgPic").prop("src",path);
            });
        });
    </script>
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
                                        <td valign="bottom"><h3 style="letter-spacing:1px;">Book Management > Revise book</h3></td>
                                        <td valign="bottom"><h3 style="letter-spacing:1px;">Book Management > Revise book</h3></td>
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
                        <!-- 添加产品开始 -->
                        <tr>
                            <td width="2%">&nbsp</td>
                            <td width="96%">
                                <table width="100%">
                                    <%
                                        Book book =(Book)request.getAttribute("book");

                                    %>
                                    <tr>
                                        <td colspan="2">
                                            <form action="/lms/bookModify" method="post">
                                                <table width="100%" class="cont">
                                                    <tr>
                                                        <td width="2%">&nbsp;</td>
                                                        <td>Book ID：</td>
                                                        <td width="20%"><input class="text" type="text" name="id" value="<%=book.getId()%>" readonly/></td>
                                                        <td rowspan="8" valign="top" >
                                                            <fieldset style="width: 210px; height: 370px;">
                                                             <legend>Picture Preview</legend>
                                                             <img id="imgPic" src="<%=book.getPic()%>" width="200px" height="350px"/>
                                                            </fieldset>
                                                        </td>
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td width="2%">&nbsp;</td>
                                                        <td width="15%">Book Name：</td>
                                                        <td width="25%"><input class="text" type="text" name="name" value="<%=book.getName()%>" /></td>
                                                       
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td width="2%">&nbsp;</td>
                                                        <td>Book Type：</td>
                                                        <td width="20%">
                                                            <select id="book_type"  name="typeId">
                                                                <%
                                                                    List<Type> bookTypes =(ArrayList)request.getAttribute("bookTypes");
                                                                    for (int i=0; i<bookTypes.size();i++){
                                                                %>
                                                               <option value="<%=bookTypes.get(i).getId()%>" <% if(bookTypes.get(i).getId()==book.getTypeId()){%> selected<%}%>><%=bookTypes.get(i).getName()%></option>
                                                                <%} %>
                                                            </select>
                                                        </td>
                                                       
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td width="2%">&nbsp;</td>
                                                        <td>Picture：</td>
                                                        <td width="20%"><input type="file" id="filePic" name="filePic"  value="<%=book.getPic()%>"/>
                                                          <input type="hidden" name="pic"  value="">
                                                        </td>
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td width="2%">&nbsp;</td>
                                                        <td>Stock：</td>
                                                        <td width="20%"><input class="text" style="width:50px;" type="number" name="stock" value="<%=book.getStock()%>" /></td>
                                                        
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td width="2%">&nbsp;</td>
                                                        <td>Price：</td>
                                                        <td width="20%"><input class="text" style="width:100px;" type="text" name="price" value="<%=book.getPrice()%>" /></td>
                                                        
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td width="2%">&nbsp;</td>
                                                        <td>Publisher：</td>
                                                        <td width="20%"><input class="text"  type="text" name="publish" value="<%=book.getPublish()%>"/></td>
                                                        <td></td>
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td width="2%">&nbsp;</td>
                                                        <td>Author:</td>
                                                        <td width="20%"><input class="text"  type="text" name="author" value="<%=book.getAuthor()%>"/></td>
                                                        <td></td>
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td width="2%">&nbsp;</td>
                                                        <td>Storage Address:</td>
                                                        <td width="20%"><input class="text"  type="text" name="address"  value="<%=book.getAddress()%>"/></td>
                                                        <td></td>
                                                        <td width="2%">&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td>&nbsp;</td>
                                                        <td>Brief Introduction：</td>
                                                        <td colspan="2"><textarea cols="150" rows="20" name="desc" value="<%=book.getDesc()%>"></textarea></td>
                                                        <td></td>
                                                    </tr>
                                                    <tr>
                                                        <td>&nbsp;</td>
                                                        <td></td>
                                                        <td colspan="3"><input class="btn" type="submit" value="Submit" /></td>
                                                    </tr>
                                                    <span style="color: red" id="error">${error}</span>
                                                    <span style="color: green" id="success">${success}</span>
                                                </table>
                                            </form>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                            <td width="2%">&nbsp;</td>
                        </tr>
                        <!-- 添加产品结束 -->
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