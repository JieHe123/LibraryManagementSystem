<!DOCTYPE html >
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html >
<head>
    <title>Library Management System</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="description" content="Library Management System" />
    <meta name="keywords" content="Backend,Library Management System,Enterprise System" />
    <meta name="Author" content="phenix" />
    <meta name="CopyRight" content="Library Management System" />
</head>
<frameset rows="64,*"  frameborder="no" border="0" framespacing="0">
    <!--头部-->
    <frame src="top.jsp" name="top" noresize="noresize" frameborder="0" scrolling="no" marginwidth="0" marginheight="0" />
    <!--主体部分-->
    <frameset cols="185,*">
        <!--主体左部分-->
        <frame src="left.jsp" name="left" noresize="noresize" frameborder="0" scrolling="no" marginwidth="0" marginheight="0" />
        <!--主体右部分-->
        <frame src="<%=request.getContextPath()%>/getAllBooks" name="main" frameborder="0" scrolling="auto" marginwidth="0" marginheight="0" />
</frameset>
</html>