<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.User" %>
    <%
    // セッションスコープからユーザー情報を取得
    String userId =(String)session.getAttribute("loginUser");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
</head>
<body>
<h1>どこつぶログイン</h1>
<% if(userId != null){ %>
<p>ログインに成功しました</p>
<p>ようこそ<%=userId %>さん</p>
<a href="/takoyaki/Main">つぶやき投稿・閲覧へ</a>
<% }else{ %>
<p>ログインに失敗しました</p>
<a href="/takoyaki/">TOPへ</a>
<%} %>
</body>
</html>