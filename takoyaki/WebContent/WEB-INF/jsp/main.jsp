<%-- リスト10-17の状態 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.User,model.Mutter,java.util.List" %>
<%
// セッションスコープに保存されたユーザー情報を取得
String userId = (String) session.getAttribute("loginUser");
// アプリケーションスコープに保存されたつぶやきリストを取得
List<Mutter> mutterList =
(List<Mutter>) request.getAttribute("mutterList");
// リクエストスコープに保存されたエラーメッセージを取得
String errorMsg = (String) request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
</head>
<body>
<h1>どこつぶメイン</h1>
<p>
<%= userId %>さん、ログイン中
<a href="/takoyaki/Logout">ログアウト</a>
</p>
<p><a href="/takoyaki/Main">更新</a></p>
<form action="/takoyaki/Main" method="post">
<input type="text" name="text">
<input type="submit" value="つぶやく">
</form>
<% if(errorMsg != null){ %>
<p><%= errorMsg %></p>
<% } %>
<% for(Mutter mutter : mutterList){%>
<p><%=mutter.getUserId()%>：<%=mutter.getText()%></p>
<% } %>
</body>
</html>