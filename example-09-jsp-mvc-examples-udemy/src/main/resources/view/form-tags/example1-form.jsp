<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <body>
        <form:form action="example1" method="POST" modelAttribute="person">
            Name: <form:input path="name"></form:input><br>
            Surname: <form:input path="surname"></form:input><br>

            Country:
            <form:select path="country">
                <form:option value="LV" label="Latvia" />
                <form:option value="EE" label="Estonia" />
                <form:option value="LT" label="Lithuania" />
            </form:select><br>

            Language:
            <form:select path="language">
                <form:options items="${languages}"/>
            </form:select><br>

            Languages:
            <form:checkbox path="languages" value="LAT" label="Latvian" />
            <form:checkbox path="languages" value="LIT" label="Lithuanian" />
            <form:checkbox path="languages" value="EST" label="Estonian" />
            <br>

            Gender:
            <form:select path="gender">
                <form:options items="${genders}"/>
            </form:select><br>

            <input type="submit" value="Submit">
        </form:form>
    </body>
</html>