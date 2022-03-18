<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="/resources/css/frame.css" type="text/css">
    <link rel="stylesheet" href="/resources/css/login.css" type="text/css">
</head>
<body>

<div class="container">
    <form method="post">
        <h1>Community Site Something</h1>
        <input type="text" placeholder="E-mail" name="userId" value="${userId}"/>
        <input type="password" placeholder="Password" name="password"/>
        <button type="submit">Log In</button>
	    <div class="error-message">${errorMsg}</div>
	    <div class=signup>Don't you have an account? <a href="signup">Sign Up</a></div>
    </form>
</div>

</body>
</html>