<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="/resources/css/frame.css" type="text/css">
    <link rel="stylesheet" href="/resources/css/postList.css" type="text/css">
</head>
<body>

<header>
    <div>
        <a href="postList" class="main-link">COMMUNITY SITE SOMETHING</a>
        <span>myPage</span>
    </div>
</header>

<div class="container">
    <div class="buttons">
        <a href="posting?categoryId=${ categoryId }" class="posting">
            <button class="posting-btn">Posting</button>
        </a>
    </div>
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
                <tr class="post" data-url="postDetail?postId=${ post.id }">
                    <td class="post-id">${ post.id }</td>
                    <td class="post-title">${ post.title }</td>
                    <td class="author">${ post.username }</td>
                    <td class="date"><fmt:formatDate value="${ post.postedDatetime }" pattern="yyyy-MM-dd hh:mm"/></td>
                    <td class="hits">${ post.hits }</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <div class="search-post-div">
        <form class="search-post">
            <input type="text" name="searchText" value="${ searchText }"/>
            <button>search</button>
        </form>
    </div>
</div>

<ul class="page-numbers">
	<c:if test="${ pageNumber > 0 }">
		<li><a href="postList?pageNumber=${ pageNumber-1 }&categoryId=${ categoryId }">Previous</a></li>
	</c:if>
	<c:forEach var="i" begin="${ pageNumber/10 }" end="${ pageNumber/10 + countPost/5 }">
		<li><a href="postList?pageNumber=${ i }&categoryId=${ categoryId }" class="${ pageNumber == i ? 'active' : '' }">${ i+1 }</a></li>
	</c:forEach>
	<c:if test="${ pageNumber <= countPost/5-1 }">
		<li><a href="postList?pageNumber=${ pageNumber+1 }&categoryId=${ categoryId }">Next</a></li>
	</c:if>
</ul>

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