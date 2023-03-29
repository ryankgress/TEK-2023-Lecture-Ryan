<jsp:include page="include/header.jsp" />

<script src="../pub/js/register.js"></script>

    <section>
            <div class="register-main container mt-3 mb-5 d-flex flex-column border border-danger border-2 rounded-3 w-50">
                <h1 class="mt-3">Create New Account</h1>
                <form class="m-3 d-flex flex-column justify-content-center">
                    <div class="mb-3 col-sm-9 mx-auto">
                        <label for="nameInput" class="form-label">Name</label>
                        <input type="text" class="form-control" id="nameInput" required>
                    </div>
                    <div class="mb-3 col-sm-9 mx-auto">
                        <label for="usernameInput" class="form-label">Username</label>
                        <input type="text" class="form-control" id="usernameInput">
                    </div>
                    <div class="mb-3 col-sm-9 mx-auto">
                        <label for="emailInput" class="form-label">Email</label>
                        <input type="email" class="form-control" id="emailInput">
                    </div>
                    <div class="mb-3 col-sm-9 mx-auto" id="passField">
                        <label for="passwordInput" class="form-label">Password</label>
                        <input type="password" class="form-control" id="passwordInput">
                    </div>
                    <div class="mb-3 col-sm-9 mx-auto" id="confirmField">
                        <label for="confirmPasswordInput" class="form-label">Confirm Password</label>
                        <input type="password" class="form-control" id="confirmPasswordInput">
                    </div>

                    <div class="mb-3 col-sm-9 mx-auto">
                        <label for="formFile" class="form-label">Profile Picture <span
                                id="lightText">(optional)</span></label>
                        <input class="form-control" type="file" id="formFile">
                    </div>

                    <div class="form-check mb-4 col-sm-9 mx-auto">
                        <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                        <label class="form-check-label" for="flexCheckDefault">
                            I will be hosting quizzes.
                        </label>
                    </div>

                    <button type="button" class="btn btn-dark mx-5" onclick="validatePass()">Register</button>
                </form>
            </div>
        </section>

    <jsp:include page="include/footer.jsp" />