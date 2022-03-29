<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="/resources/css/frame.css" type="text/css">
    <link rel="stylesheet" href="/resources/css/posting.css" type="text/css">
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
		<h2>Posting</h2>
		<form method="POST">
			<div class="radios">
				<label class="radio"><input type="radio" name="categoryId" ${ selectedCategory == null ? 'checked' : '' }><span>All</span></label>
				<c:forEach var="category" items="${ categories }">
					<label class="radio">
						<input type="radio" name="categoryId" value="${ category.id }" ${ category.id == selectedCategory ? 'checked' : '' }>
						<span>${ category.name }</span>
					</label>
				</c:forEach>
			</div>
			<div class="write-title">
				<label>Title</label>
				<input type="text" name="title">
			</div>
			<div>
				<textarea name="content"></textarea>
			</div>
			<button type="submit" class="btn">Post</button>
		</form>
	</div>
</div>

<script>
	const radios = document.querySelectorAll(input[type="radio"]);
	radios.forEach(radio => radio.addEventListener("click", ))
</script>

</body>
</html>