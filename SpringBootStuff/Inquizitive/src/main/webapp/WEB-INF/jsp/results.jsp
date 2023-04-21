<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <jsp:include page="include/header.jsp" />

    <section>
        <div class="register-main container mt-3 mb-5 d-flex flex-column border border-danger border-2 rounded-3 w-50">
            <h1 class="mt-3">Report Results</h1>
            <form class="m-3 d-flex flex-column justify-content-center" action="/resultsSubmit" method="post">
                <div class="mb-3 col-sm-9 mx-auto">
                    <label for="triviaName" class="form-label">Trivia Name</label>
                    <input type="text" class="form-control" id="triviaName" name="name"
                        value="${trivia.triviaName}" readonly>
                </div>


                <c:set var="counter" scope="page" value="${1}" />
                <c:forEach items="${teams}" var="team">
                    <div class="mb-3 col-sm-9 mx-auto">
                        <label for="${team.team_name}Standing" class="form-label">${team.team_name}</label>
                        <input type="number" class="form-control" id="${team.team_name}Standing" name="${team.team_name}Standing">
                    </div>
                </c:forEach>
                

                <button class="btn btn-dark mx-5">Submit Results</button>
            </form>
        </div>
    </section>

    <jsp:include page="include/footer.jsp" />