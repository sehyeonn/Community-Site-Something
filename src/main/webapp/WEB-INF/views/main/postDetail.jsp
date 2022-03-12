<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="/resources/css/frame.css" type="text/css">
    <link rel="stylesheet" href="/resources/css/postDetail.css" type="text/css">
</head>
<body>

<header>
    <div>
        <a href="postList" class="main-link">COMMUNITY SITE SOMETHING</a>
        <span>myPage</span>
    </div>
</header>    

<div class="container">
    <div>
        <h2>${post.title}</h2>
        <div class="post-info">
            <span>${post.username}</span>
            <span>
                ${post.postedDatetime} |
                comments ${numberOfComments} |
                hits ${post.hits}
            </span>
        </div>
        <div class="post-content">
            ${post.content}
        </div>

        <div class="comments">
            <div>Comments</div>
            <ul>
                <c:forEach var="comment" items="${comments}">
                    <li>
                        <div class="comment-info">
                            <span>${comment.username}</span>
                            <span>${comment.postedDatetime}</span>
                        </div>
                        <div class="comment-content">${comment.content}</div>
                    </li>
                </c:forEach>
            </ul>
        </div>
        
        <form:form method="POST" modelAttribute="newComment">
        	<div>
                <span>Post a comment</span>
                <button type="submit">Post</button>
            </div>
        	<form:textarea path="content"/>
        </form:form>
    </div>
</div>

</body>
</html>