<%--
  Created by IntelliJ IDEA.
  User: yutao
  Date: 3/23/16
  Time: 9:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form method="post" modelAttribute="profile">
    <table>
        <tr>
            <td>ID</td>
            <td><form:input path="id" /></td>
        </tr>
        <tr>
            <td>First Name</td>
            <td><form:input path="firstname" /></td>
        </tr>
        <tr>
            <td>Last Name</td>
            <td><form:input path="lastname" /></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><form:input path="email" /></td>
        </tr>
        <tr>
            <td>Address</td>
            <td><form:input path="address" /></td>
        </tr>
        <tr>
            <td>Organization</td>
            <td><form:input path="organization" /></td>
        </tr>
        <tr>
            <td>About Myself</td>
            <td><form:input path="aboutMyself" /></td>
        </tr>
        <tr>
            <td colspan="3"><input type="submit" value="Update"/></td>
        </tr>
        <tr>
            <td colspan="3"><input type="submit" value="Delete"/></td>
        </tr>
    </table>
</form:form>

</body>
</html>
