<%--
  Created by IntelliJ IDEA.
  Date: 3/28/16
  Time: 5:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Group 9 Create Profile</title>
</head>
<body>

<form:form id="profileForm" method="post" modelAttribute="profile">
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
            <td colspan="3"><input type="button" onclick="submitForm()" value="Create"/></td>
        </tr>
    </table>
</form:form>

<p id="demo"></p>

<script>
    function submitForm() {
        var profileForm = document.getElementById("profileForm");
        var action = profileForm.action + "/";
        for (var i = 0; i < profileForm.length; i++) {
            var e = profileForm.elements[i];
            if (e.id == "id") {
                action += e.value + "?";
            } else if (e.type == "text") {
                action += e.name + "=" + e.value + "&";
            }
        }
        var newForm = document.createElement("form");
        newForm.method = "post";
        newForm.action = action;
        document.body.appendChild(newForm);
        newForm.submit();
    }
</script>
</body>
</html>
