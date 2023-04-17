<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <jsp:include page="include/header.jsp" />

    <section>
        <div class="teams-main container d-flex flex-column ">
            <h1>Teams List</h1>
            <p class="text-white text-center">Check out the teams below! Feel free to join one here, or see where yours
                stacks up!</p>

            <c:set var="counter" scope="page" value="${1}" />

            <c:forEach items="${memberList}" var="team">
                <c:if test="${counter % 2 eq 0}">
                    <div class="card text-end bg-light mb-3 d-flex mx-auto col-8" id="${team.team_name}">
                        <div class="card-header text-center">
                            ${team.team_name} <!--EVEN-->
                        </div>
                        <div class="card-body d-flex d-flex-row" id="${team.id}">
                            <div class="col-4">
                                <img src="${team.team_pic}" alt="team pic" width="100%">
                            </div>
                            <div class="col-8">
                                <h5 class="card-title text-end">${team.team_name}</h5>
                                <p class="card-text">${team.team_desc}</p>
                                <p class="card-text"><b>Members:</b> ${team.team_members}</p>
                                <input type="hidden" id="code" value="${team.join_code}">
                                <a href="/teams/${team.id}#${team.id}" class="btn btn-dark">Join Team</a>
                            </div>

                        </div>
                        <div class="card-footer text-muted text-center">
                            Total Points: ${team.total_score}
                        </div>
                    </div>
                </c:if>
                <c:if test="${counter % 2 eq 1}">
                    <div class="card bg-light mb-3 mx-auto col-8" id="${team.team_name}">
                        <div class="card-header text-center">
                            ${team.team_name} <!--ODD-->
                        </div>
                        <div class="card-body d-flex d-flex-row" id="${team.id}">
                            <div class="col-8">
                                <h5 class="card-title text-start">${team.team_name}</h5>
                                <p class="card-text">${team.team_desc}</p>
                                <p class="card-text"><b>Members:</b> ${team.team_members}</p>
                                <input type="hidden" id="code" value="${team.join_code}">
                                <a href="/teams/${team.id}" class="btn btn-dark">Join Team</a>
                            </div>
                            <div class="col-4">
                                <img src="${team.team_pic}" alt="team pic" width="100%">
                            </div>
                        </div>
                        <div class="card-footer text-muted text-center">
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