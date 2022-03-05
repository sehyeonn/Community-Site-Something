<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>

<div class="container">
    <div class="category">
        <ul>
            <c:forEach var="category" items="${ categories }">
                    <li data-url="postList?categoryId=${ category.id }">
                        <span>${ category.name }</span>
                    </li>
            </c:forEach>
        </ul>
    </div>
    <button class="posting">Posting</button>
    <form class="search-post">
        <input type="text" name="searchText" value="${ searchText }"/>
        <button>search</button>
    </form>
    <table class="post-list-table">
        <thead>
            <tr>
                <th>postID</th>
                <th>title</th>
                <th>author</th>
                <th>date</th>
                <th>hits</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="post" items="${ posts }">
                <tr data-url="postDetail?postId=${ post.id }">
                    <td>${ post.id }</td>
                    <td>${ post.title }</td>
                    <td>${ post.username }</td>
                    <td>${ post.postedDatetime }</td>
                    <td>${ post.hits }</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
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