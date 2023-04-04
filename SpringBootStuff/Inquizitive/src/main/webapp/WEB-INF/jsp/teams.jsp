<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <jsp:include page="include/header.jsp" />

    <section>
        <div class="teams-main container">
            <h1>Teams List</h1>
            <p class="text-white text-center">Check out the teams below! Feel free to join one below, or see where yours stacks up!</p>

            <c:forEach items="${memberList}" var="team">
                <div class="card text-center bg-light mb-3" id="${team.get('team_name')}">
                    <div class="card-header">
                        ${team.get("team_name")}
                    </div>
                    <div class="card-body">
                        <h5 class="card-title">${team.get("team_name")}</h5>
                        <p class="card-text">${team.get("team_desc")}</p>
                        <p class="card-text">Members: ${team.get("team_members")}</p>
                        <a href="#" class="btn btn-dark">View Join Code</a>
                    </div>
                    <div class="card-footer text-muted">
                        Total Points: ${team.get("total_score")}
                    </div>
                </div>
            </c:forEach>

        </div>

    </section>

    <jsp:include page="include/footer.jsp" />