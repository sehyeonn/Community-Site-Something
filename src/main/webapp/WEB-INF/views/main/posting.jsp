<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>

<div class="container">
    <form method="post">
	    <h1>Posting</h1>
	    <select name="categoryId">
	    	<option>All</option>
	    	<c:forEach var="category" items="${ categories }">
	    		<option value="${ category.id }" ${ category.id == selectedCategory ? "selected" : "" }>${ category.name }</option>
	    	</c:forEach>
	    </select>
    	<div>
    		<label>Title</label>
    		<input type="text" name="title">
    	</div>
    	<div>    	
    		<input type="text" name="content">
    	</div>
    	<button type="submit" class="btn">Post</button>
    </form>
</div>

</body>
</html>