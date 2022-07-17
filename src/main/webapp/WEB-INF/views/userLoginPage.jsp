<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>log in</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
</head>
<body class="container">
    <div class="jumbotron">
        <h1>
            Log in
        </h1>
    </div>
        <form action="UserLogin" style="margin: 0 auto" method="post">
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
            <button type="submit" class="btn btn-primary">
                로그인
            </button>
            <button type="submit" class="btn btn-primary">
                회원가입 <!-- 연결 제대로 해주기-->
            </button>
        </form>
</body>
</html>