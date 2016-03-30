<%--
  Created by IntelliJ IDEA.
  User: yutao
  Date: 3/23/16
  Time: 9:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Group 9 View Profile</title>
</head>
<body>
<form:form id="profileForm" method="post" modelAttribute="profile">
    <table>
        <tr>
            <td>ID</td>
            <td><form:input path="id" readonly="${readonly}"/></td>
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
            <td colspan="3"><input type="button" onclick="updateProfile()" value="Update"/></td>
        </tr>
        <tr>
            <td colspan="3"><input type="button" onclick="deleteProfile()" value="Delete"/></td>
        </tr>
    </table>
</form:form>

<script>
    function updateProfile() {
        var profileForm = document.getElementById("profileForm");
        var action = "/profile/";
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

    function deleteProfile() {
        var profileForm = document.getElementById("profileForm");
        var id;
        for (var i = 0; i < profileForm.length; i++) {
            if (profileForm.elements[i].id == "id") {
                id = profileForm.elements[i].value;
                break;
            }
        }
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (xhttp.readyState == 4 && xhttp.status == 200) {
                window.location.href = "/profile";
            }
        }

        var url = "/profile/" + id;
        xhttp.open("DELETE", url, true);
        xhttp.send();
    }

</script>

</body>
</html>
