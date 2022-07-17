<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>회원가입</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
</head>
<body class="container">
    <div class="jumbotron">
        <h1>회원가입</h1>
    </div>
    <form action="InsertUserInfo">
        <div class="form-group">
            <label>
                이름
                    <input name="user_name" type="text" class="form-control"/>
            </label>
        </div>
        <div class="form-group">
            <label>
                아이디
                    <input name="user_id" type="text" class="form-control"/>
            </label>
        </div>
        <div class="form-group">
            <label>
                비밀번호
                    <input name="user_pwd" type="password" class="form-control"/>
            </label>
        </div>
        <div class="form-group">
            <label>
                e-mail
                    <input name="user_email" type="email" class="form-control"/>
            </label>
        </div>
        <button type="submit" class="btn btn-primary">
            확인
        </button>
        <button type="reset" class="btn btn-primary">
            취소
        </button>
</form>
</body>
</html>