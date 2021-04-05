<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Reference to an object property will actually call a getter (e.g. person.getName()) -->
Hello, ${person.name} ${person.surname} from ${person.country}, talking in ${person.language}!<br>
Your other languages are:
<ul>
    <c:forEach var="language" items="${person.languages}">
        <li>${language}</li>
    </c:forEach>
</ul>