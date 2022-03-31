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
				<label class="radio"><input type="radio" name="categoryId" value="" ${ selectedCategory == null ? 'checked' : '' }/><span>All</span></label>
				<c:forEach var="category" items="${ categories }">
					<label class="radio">
						<input type="radio" name="categoryId" value="${ category.id }" ${ category.id == selectedCategory ? 'checked' : '' }/>
						<span>${ category.name }</span>
					</label>
				</c:forEach>
			</div>
			<div class="write-title">
				<label>Title</label>
				<input type="text" name="title"/>
			</div>
			<div>
				<textarea name="content"></textarea>
			</div>
		</form>
		<button class="btn">Post</button>
	</div>
</div>

<script>
	// 위 html에서 category 값이 제대로 전달되지 않아 자바스크립트로 전달
	function sendPost(url, params) {
		var form = document.createElement('form');
		form.setAttribute('method', 'post');
		form.setAttribute('target', '_self');
		form.setAttribute('action', url);
		document.charset = "UTF-8";
	
		for (var key in params) {
			var hiddenField = document.createElement('input');
			hiddenField.setAttribute('type', 'hidden');
			hiddenField.setAttribute('name', key);
			hiddenField.setAttribute('value', params[key]);
			form.appendChild(hiddenField);
		}
		document.body.appendChild(form);
		form.submit();
	}
	
	document.querySelector("button").addEventListener("click", () => {
		const categoryId = document.querySelector("input[name='categoryId']:checked").value;
		const title = document.querySelector("input[name='title']").value;
		const content = document.querySelector("textarea").value;
		
		if(title == "")
			alert("Enter the title");
		else if(content == "")
			alert("Enter the content");
		else {
			sendPost("posting", {
				categoryId,
				title,
				content
			});
		}
	});
</script>

</body>
</html>