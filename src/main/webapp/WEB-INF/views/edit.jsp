<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Post</title>
</head>
<body>

<form:form action="savePost" modelAttribute="post" method="post">
    <form:hidden path="id"/>
    Name <form:input path="name"/>
    <br>
    Description <form:textarea path="description"/>
    <br>
    <input type="submit" value="ok">
</form:form>

</body>
</html>