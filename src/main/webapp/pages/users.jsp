<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="university" type="com.solbeg.model.University" scope="request"/>
<jsp:useBean id="student" class="com.solbeg.model.Student"/>

<html>
<head>
    <title>${university.name}</title>
</head>
<body>
<h1>${university.name}</h1>

    <c:forEach items="${university.students}" var="student">
        <li>
                ${student.name}  ${student.lastName}<button onclick="deleteStudent(${student.id})">Delete</button>
        </li>
    </c:forEach>
<form action="users" method="post">
    <button>Add Student</button>
</form>

<ul>
</ul>

<script>
    function deleteStudent(id) {
        if (confirm('Are you sure you want to delete this student?')) {
            fetch('users?id=' + id, {method: 'DELETE'})
                .then(() => window.location.reload())
                .catch((error) => console.error(error));
        }
    }
</script>
</body>
</html>