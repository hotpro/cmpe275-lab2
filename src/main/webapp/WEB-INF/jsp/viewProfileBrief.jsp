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
    <title>Group 9 Profile Brief</title>
</head>
<body>

<pre>
UserID: ${profile.id}
First Name: ${profile.firstname}
Last Name: ${profile.lastname}
Email: ${profile.email}
Address: ${profile.address}
Organization: ${profile.organization}
About Myself: ${profile.aboutMyself}
</pre>

</body>
</html>
