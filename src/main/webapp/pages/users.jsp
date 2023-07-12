<%@ page import="com.solbeg.model.Student" %><%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="university" type="com.solbeg.model.University" scope="request"/>

<%--<html>--%>
<%--<head>--%>
<%--    <title>${universities.name}</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1>Students</h1>--%>
<%--<c: List--%>
<%--</c>--%>
<%--</body>--%>
<%--</html>--%>
<html>
<head>
    <title><%=university.getName()%></title>
</head>
<body>
<h1><%= university.getName() %></h1>
<ul>
    <% for (Student student : university.getStudents()) { %>
    <li><%= student.getName() %> <%= student.getLastName() %>
        - <button onclick="deleteStudent(<%= student.getId() %>)">Delete</button></li>
    <% } %>
</ul>
<form action="/users" method="post">
    <input type="hidden" name="id" value="<%= university.getId() %>">
    <button>Add Student</button>
</form>
<script>
    function deleteStudent(id) {
        if (confirm('Are you sure you want to delete this student?')) {
            fetch('delete-student?id=' + id, { method: 'DELETE' })
                .then(() => window.location.reload())
                .catch((error) => console.error(error));
        }
    }
</script>
</body>
</html>