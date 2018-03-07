<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%

//運勢のリスト
String[] luckList = {"大吉","中吉","小吉","凶"};

//0以上4未満の整数を乱数生成
int index = (int) (Math.random()*4);
String luck = luckList[index];

%>

<!DOCTYPE html>
<html>
<head>
<meta charset=”UTF-8">
<title>おみくじプログラム</title>
</head>
<body>
<p>あなたの運勢は<%=luck %>です。</p>
</body>
</html>
