<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head> 
    <meta charset="utf-8">
    <title></title>
    <META name="viewport" content="width=device-width, height=device-height, initial-scale=1.0, user-scalable=no"> 
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.css" />
    <link rel="stylesheet" href="/css/reset.css"/>
    <link rel="stylesheet" href="/css/style.css"/>
    <link rel="stylesheet" href="/css/contents.css"/>
    <script src="/js/script.js"></script>
</head> 
<body>
    <div class="wrap">
        <%@ include file="/WEB-INF/views/include/header.jsp" %>
        <%@ include file="/WEB-INF/views/include/footer.jsp" %>
        <div id="quickMenu">
            <div><img src="/img/quick_01.jpg"></div>
            <div><img src="/img/quick_02.jpg"></div>
            <div><img src="/img/quick_03.jpg"></div>
            <div><img src="/img/quick_04.jpg"></div>
            <div><img id="goTop" src="/img/quick_05.jpg"></div>
        </div>
    </div>
</body> 
</html>