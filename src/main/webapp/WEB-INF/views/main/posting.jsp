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
		<form:form method="POST" modelAttribute="newPost">
			<div class="radios">
				<label class="radio"><form:radiobutton path="categoryId"/><span>All</span></label>
				<c:forEach var="category" items="${ categories }">
					<label class="radio">
						<form:radiobutton path="categoryId" value="${ category.id }" checked="${ category.id == selectedCategory ? 'checked' : '' }"/>
						<span>${ category.name }</span>
					</label>
				</c:forEach>
			</div>
			<div>
				<label>Title</label>
				<form:input path="title"/>
			</div>
			<div>
				<form:textarea path="content"/>
			</div>
			<button type="submit" class="btn">Post</button>
		</form:form>
	</div>
</div>

</body>
</html>