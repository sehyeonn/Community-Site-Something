<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>

<div class="container">
    <table>
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
                <tr>
                    <td>${post.id}</td>
                    <td>${post.title} <span>[${numberOfComments}]</span></td>
                    <td>${post.username}</td>
                    <td>${post.postedDateTime}</td>
                    <td>${post.hits}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>