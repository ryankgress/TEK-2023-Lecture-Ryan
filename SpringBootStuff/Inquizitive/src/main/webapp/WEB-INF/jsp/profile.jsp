<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <jsp:include page="include/header.jsp" />

    <!-- User Info -->
    <section>
        <div class="profile-main container mt-3 mb-5 d-flex flex-column border border-danger border-2 rounded-3">
            <h1>Profile</h1>
            <div class="row mx-5 align-items-center">
                <div class="col">
                    <p>
                        Welcome to <b>${profileInfo.name}</b>'s profile.
                    </p>

                </div>
                <div class="col text-center">
                    <p>
                        <img src="${profileInfo.profile_pic}" alt="pfp" width="200px">
                    </p>
                </div>
            </div>
            <div class="row d-flex mx-5">
                <div class="col profile-userinfo">
                    <h2>User Information</h2>

                    <p>
                    <table>
                        <tr>
                            <td><b>Username:</b></td>
                            <td>${profileInfo.username}</td>
                        </tr>
                        <tr>
                            <td><b>Email:</b></td>
                            <td>${profileInfo.email}</td>
                        </tr>
                        <tr>
                            <td><b>Home Field:</b></td>
                            <td>Yellow Bridges, New Ken</td>
                        </tr>
                        <tr>
                            <td><b>Total Points:</b></td>
                            <td>${profileInfo.user_total}</td>
                        </tr>
                    </table>
                    </p>
                    <br>
                    <p style="font-size: 12pt;">
                        See something wrong? Click <a href="editProfile/${profileInfo.id}">here</a> to edit your profile
                    </p>

                </div>
                <div class="col profile-recent">
                    <h2 class="text-center">Recent Quizzes</h2>
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th scope="col">Name</th>
                                <th scope="col" style="text-align: center;">Placement</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><a href="index">Buzzworthy Thursday 3/9</a></td>
                                <td class="placement">6th</td>
                            </tr>
                            <tr>
                                <td><a href="index">Buzzworthy Thursday 3/16</a></td>
                                <td class="placement">2nd</td>
                            </tr>
                            <tr>
                                <td><a href="index">HO1KB #63</a></td>
                                <td class="placement">5th</td>
                            </tr>
                            <tr>
                                <td><a href="index">Trivia Time Virtual 132</a></td>
                                <td class="placement">2nd</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <!-- Team Info -->
        <section>
            <h1>Your Teams</h1>
            <div class="profile-teams container d-flex mt-4 justify-content-evenly flex-wrap">
                <div class="card text-center mb-3" style="width: 18rem;">
                    <img src="/pub/images/team-logo.jpg" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">Quiz Tigers</h5>
                        <p class="card-text">Ferocious in the jungle and the quiz field. They're grrrreat!</p>
                        <a href="#" class="btn btn-dark">Team Page</a>
                    </div>
                </div>
                <div class="card text-center mb-3" style="width: 18rem;">
                    <img src="/pub/images/team-logo2.jpg" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">Outside Spotlights.</h5>
                        <p class="card-text">A disconnected family that unites solely to take the quizzing crown! ...
                            Just
                            leave motown out of it.</p>
                        <a href="#" class="btn btn-dark">Team Page</a>
                    </div>
                </div>

                <!-- Able to add more teams easily below -->
                <!-- <div class="card text-center mb-3" style="width: 18rem;">
                <img src="/pub/images/team-logo2.jpg" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">Outside Spotlights.</h5>
                    <p class="card-text">A disconnected family that unites solely to take the quizzing crown! ... Just leave motown out of it.</p>
                    <a href="#" class="btn btn-dark">Team Page</a>
                </div>
            </div>
            <div class="card text-center mb-3" style="width: 18rem;">
                <img src="/pub/images/team-logo2.jpg" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">Outside Spotlights.</h5>
                    <p class="card-text">A disconnected family that unites solely to take the quizzing crown! ... Just leave motown out of it.</p>
                    <a href="#" class="btn btn-dark">Team Page</a>
                </div>
            </div>
            <div class="card text-center mb-3" style="width: 18rem;">
                <img src="/pub/images/team-logo2.jpg" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">Outside Spotlights.</h5>
                    <p class="card-text">A disconnected family that unites solely to take the quizzing crown! ... Just leave motown out of it.</p>
                    <a href="#" class="btn btn-dark">Team Page</a>
                </div>
            </div> -->
            </div>
        </section>

        <jsp:include page="include/footer.jsp" />