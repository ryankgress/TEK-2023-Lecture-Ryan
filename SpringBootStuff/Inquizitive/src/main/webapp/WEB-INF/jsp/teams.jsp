<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <jsp:include page="include/header.jsp" />

    <section>
        <div class="teams-main container">
            <h1>Teams List</h1>
            <p class="text-white text-center">Check out the teams below! Feel free to join one here, or see where yours
                stacks up!</p>

            <c:set var="counter" scope="page" value="${1}" />

            <c:forEach items="${memberList}" var="team">
                <c:if test="${counter % 2 eq 0}">
                    <div class="card text-center bg-light mb-3" id="${team.team_name}">
                        <div class="card-header">
                            ${team.team_name} EVEN
                        </div>
                        <div class="card-body text-right"> <!-- Not working yet.-->
                            <h5 class="card-title">${team.team_name}</h5>
                            <p class="card-text">${team.team_desc}</p>
                            <p class="card-text">Members: ${team.team_members}</p>
                            <input type="hidden" id="code" value="${team.join_code}">
                            <!-- <c:set var="code" value="${team.join_code}" scope="page" /> -->
                            <!-- <button class="btn btn-dark" onclick="showCode('${team.join_code}')">View Join Code</button> -->
                            <a href="/teams/${team.id}" class="btn btn-dark">Join Team</a>
                        </div>
                        <div class="card-footer text-muted">
                            Total Points: ${team.total_score}
                        </div>
                    </div>
                </c:if>
                <c:if test="${counter % 2 eq 1}">
                    <div class="card text-center bg-light mb-3" id="${team.team_name}">
                        <div class="card-header">
                            ${team.team_name} ODD
                        </div>
                        <div class="card-body text-left">
                            <h5 class="card-title">${team.team_name}</h5>
                            <p class="card-text">${team.team_desc}</p>
                            <p class="card-text">Members: ${team.team_members}</p>
                            <input type="hidden" id="code" value="${team.join_code}">
                            <!-- <c:set var="code" value="${team.join_code}" scope="page" /> -->
                            <!-- <button class="btn btn-dark" onclick="showCode('${team.join_code}')">View Join Code</button> -->
                            <a href="/teams/${team.id}" class="btn btn-dark">Join Team</a>
                        </div>
                        <div class="card-footer text-muted">
                            Total Points: ${team.total_score}
                        </div>
                    </div>
                </c:if>
                <c:set var="counter" value="${counter + 1}" scope="page" />
            </c:forEach>

        </div>

    </section>

    <script>
        function showCode(codeVal) {
            // let codeVal = document.getElementById("code").value;
            console.log(codeVal);
        }
    </script>

    <jsp:include page="include/footer.jsp" />