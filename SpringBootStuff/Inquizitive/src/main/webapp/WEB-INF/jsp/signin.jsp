<jsp:include page="include/header.jsp" />

<section>
    <div class="signin-main container mt-3 mb-5 d-flex flex-column border border-danger border-2 rounded-3 w-50">
        <h1 class="mt-3">Sign In</h1>
        <form class="m-3 d-flex flex-column justify-content-center">
            <div class="mb-3 col-sm-9 mx-auto">
                <label for="usernameInput" class="form-label">Username</label>
                <input type="text" class="form-control" id="usernameInput" aria-describedby="usernameHelp">
            </div>
            <div class="mb-3 col-sm-9 mx-auto">
                <label for="passwordInput" class="form-label">Password</label>
                <input type="password" class="form-control" id="passwordInput">
                <div id="passwordHelp" class="form-text" style="text-align: right;">New to Inquizitive? Create an
                    account <a href="register">here</a></div>
            </div>
            <div class="mb-3 form-check col-sm-9 mx-auto">
                <input type="checkbox" class="form-check-input" id="exampleCheck1">
                <label class="form-check-label" for="exampleCheck1">Remember Me</label>
            </div>
            <button type="submit" class="btn btn-dark mx-5">Log In</button>
        </form>
    </div>
</section>

<style>
    .Footer {
        position:fixed;
        left: 0;
        bottom: 0;
        width: 100%;
    }
</style>

<jsp:include page="include/footer.jsp" />