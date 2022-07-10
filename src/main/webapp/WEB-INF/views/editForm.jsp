<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%
    String notice_seq = (String)request.getAttribute("Notice_seq");
%>
<html>
<head>
    <meta charset="utf-8">
    <title>웹페이지 제목</title>
</head>
<body>
    <h2>글 수정 페이지</h2>
    <form action="DoNoticeUpdate" method="get">
        <div>게시판 제목</div>
        <div><input name="title" type="text" class="form-control"/></div>
        <div>게시판 내용</div>
        <div><textarea name="contents"></textarea></div>
        <div><input name="Notice_seq" hidden="hidden" value="<%=notice_seq%>"></div>
        <div><button type="submit" class="btn btn-primary">전송</button></div>
    </form>
</body>
</html>