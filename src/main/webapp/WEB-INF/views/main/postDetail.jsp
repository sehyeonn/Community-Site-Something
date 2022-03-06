<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>

<div class="container">
    <div>
        <h2>${post.title}</h2>
        <div>
            <span>${post.username}</span>
            <span>${post.postedDatetime}</span>
            <span>comments ${numberOfComments}</span>
            <span>hits ${post.hits}</span>
        </div>
        <div>
            ${post.content}
        </div>

        <div>
            <ul>
                <c:forEach var="comment" items="${comments}">
                    <li>
                        <span>${comment.username}</span>
                        <span>${comment.postedDatetime}</span>
                        <div>${comment.content}</div>
                    </li>
                </c:forEach>
            </ul>
        </div>
        
        <form:form method="POST" modelAttribute="newComment">
        	<h2>Post a comment</h2>
        	<form:textarea path="content"/>
        	<button type="submit">Post</button>
        </form:form>
    </div>
</div>

</body>
</html>