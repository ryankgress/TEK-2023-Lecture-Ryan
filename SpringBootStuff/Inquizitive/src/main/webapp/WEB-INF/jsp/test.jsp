<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <jsp:include page="include/header.jsp" />

    <script src="../pub/js/teams.js"></script>

    <section>
        <div class="container teams-main d-flex flex-column align-items-center">
            <h1>Check out the teams below!</h1>
            <button type="button" class="btn-lg mb-3" onclick="showTeams()">Show the Teams</button>
        </div>
        <div class="container" style="background-color: white;">
            <table id="teamTable" class="table-striped table">

            </table>
        </div>
    </section>

    <section> <!-- Add team desc and join code and points? -->
        <div class="container text-white">
            <h2>Members of Team Breakout1: </h2>
            <p>

            <ul>
                <c:forEach items="${t1List}" var="user">
                    <li>${user.name}... AKA ${user.username}</li>
                </c:forEach>
            </ul>
            </p>
            <table class="table text-white">
                <tr>
                    <td>Description</td>
                    <td>${team.teamDesc}</td>
                </tr>
                <tr>
                    <td>Join Code</td>
                    <td>${team.joinCode}</td>
                </tr>
            </table>
        </div>
    </section>

    <jsp:include page="include/footer.jsp" />