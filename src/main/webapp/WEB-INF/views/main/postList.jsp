<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="/resources/css/frame.css" type="text/css">
</head>
<body>

<header>
    <div>
        <a href="postList" class="main-link">COMMUNITY SITE SOMETHING</a>
        <span>myPage</span>
    </div>
</header>

<div class="container">
    <a href="posting?categoryId=${ categoryId }" class="posting">
        <button class="posting-btn">Posting</button>
    </a>
    <div class="category">
        <ul>
            <c:forEach var="category" items="${ categories }">
                    <li data-url="postList?categoryId=${ category.id }">
                        <span>${ category.name }</span>
                    </li>
            </c:forEach>
        </ul>
    </div>
    <table class="post-list-table">
        <thead>
            <tr>
                <th class="post-id">postID</th>
                <th class="post-title">title</th>
                <th class="author">author</th>
                <th class="date">date</th>
                <th class="hits">hits</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="post" items="${ posts }">
                <tr data-url="postDetail?postId=${ post.id }">
                    <td class="post-id">${ post.id }</td>
                    <td class="post-title">${ post.title }</td>
                    <td class="author">${ post.username }</td>
                    <td class="date">${ post.postedDatetime }</td>
                    <td class="hits">${ post.hits }</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <form class="search-post">
        <input type="text" name="searchText" value="${ searchText }"/>
        <button>search</button>
    </form>
</div>

<script>
    const posts = document.querySelectorAll(".post-list-table [data-url]");
    const categories = document.querySelectorAll(".category [data-url]");

    function hrefHandler(event) {
        const url = event.currentTarget.dataset.url;
        location.href = url;
    }

    posts.forEach(post => post.addEventListener("click", hrefHandler));
    categories.forEach(category => category.addEventListener("click", hrefHandler));
</script>
</body>
</html>