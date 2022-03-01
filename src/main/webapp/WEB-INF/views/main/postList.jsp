<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>

<div class="container">
    <form class="search-post">
        <input type="text" name="searchText" value="${searchText}"/>
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
            <c:forEach var="post" items="${posts}">
                <tr data-url="postDetail?postId=${post.id}">
                    <td>${post.id}</td>
                    <td>${post.title}</td>
                    <td>${post.username}</td>
                    <td>${post.postedDatetime}</td>
                    <td>${post.hits}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<script>
    const posts = document.querySelectorAll("[data-url]");
    posts.forEach(post => post.addEventListener("click", () => {
        const url = post.dataset.url;
        location.href = url;
    }));
</script>
</body>
</html>