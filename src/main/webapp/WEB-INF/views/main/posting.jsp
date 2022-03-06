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
    <form:form method="POST" modelAttribute="newPost">
	    <h1>Posting</h1>
	    <form:select path="categoryId">
	    	<option>All</option>
	    	<c:forEach var="category" items="${ categories }">
	    		<option value="${ category.id }" ${ category.id == selectedCategory ? "selected" : "" }>${ category.name }</option>
	    	</c:forEach>
	    </form:select>
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

</body>
</html>