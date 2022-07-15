<%@ page import="kopo.poly.dto.NoticeDTO" %>
<%@ page import="kopo.poly.util.CmmUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    NoticeDTO rDTO = (NoticeDTO)request.getAttribute("rDTO");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>웹페이지 제목</title>
</head>
<body>
    <div style="">
        <h4><%=CmmUtil.nvl(rDTO.getTitle())%></h4>
        <hr>
        <div style="">작성자 : <%=CmmUtil.nvl(rDTO.getReg_id())%></div>
        <div>
            <p>
                <%=CmmUtil.nvl(rDTO.getContents())%>
            </p>
        </div>
        <hr>
        <div style="float: left">
            <button onclick="location.href='getNoticeList'">뒤로</button>
        </div>
        <div style="float: right">
            <button onclick="location.href='NoticeUpdate?no=<%=rDTO.getNotice_seq()%>'">수정</button>
            <button onclick="location.href='NoticeDelete?no=<%=rDTO.getNotice_seq()%>'">삭제</button>
        </div>
    </div>
</body>
</html>