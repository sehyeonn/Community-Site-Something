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
        <input type="password" placeholder="Confirm Password" name="confirmPassword"/>
        <button type="submit">Sign Up</button>
	    <div class="error-message">${errorMsg}</div>
    </form>
</div>

</body>
</html>