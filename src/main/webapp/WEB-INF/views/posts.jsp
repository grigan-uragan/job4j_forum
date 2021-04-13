<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
    <title>Forum</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<div class="container mt-3">
    <div class="row">
    </div>
    <div class="row">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Тема</th>
                <th scope="col">Автор</th>
                <th scope="col">Дата</th>
                <th scope="col">Содержание</th>
                <th scope="col">Редактировать</th>
                <th scope="col">Удалить</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach var="post" items="${posts}">
                <c:url var="updateButton" value="/updatePost">
                    <c:param name="postId" value="${post.id}"/>
                </c:url>
                <c:url var="deleteButton" value="/deletePost">
                    <c:param name="postId" value="${post.id}"/>
                </c:url>
                <tr>
                    <td><c:out value="${post.topic}"/></td>
                    <td><c:out value="${post.user.username}"/></td>
                    <td><c:out value="${post.created.time}"/></td>
                    <td><c:out value="${post.text}"/></td>
                    <td><input type="button" value="update" onclick="window.location.href ='${updateButton}'"></td>
                    <td><input type="button" value="delete" onclick="window.location.href ='${deleteButton}'"></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div>
            <input type="button" value="add" onclick="window.location.href ='/addPost'">
        </div>
    </div>

</div>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>