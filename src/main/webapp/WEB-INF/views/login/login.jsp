<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>

<div class="container">
    <form method="post">
        <h1>Community Site Something</h1>
        <input type="text" placeholder="E-mail" name="userId" value="${userId}"/>
        <input type="password" placeholder="Password" name="password"/>
        <button type="submit">Log In</button>
    </form>
    <div>${errorMsg}</div>
</div>

</body>
</html>