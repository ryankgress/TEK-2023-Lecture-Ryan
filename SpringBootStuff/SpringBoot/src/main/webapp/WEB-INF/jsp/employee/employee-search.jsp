<jsp:include page="../include/header.jsp" />

<section class="pt-3 pb-3 bg-light-grey">
    <div class="container text-center">
        <h1>Employee Search</h1>
    </div>
</section>

<section class="bg-bisque">
    <div class="container d-flex flex-column col-6">
        <form class="m-3 d-flex flex-column justify-content-center">
            <div class="input-group mb-3">
                <input type="text" class="form-control" name="search" placeholder="Employee Name"
                    aria-label="Employee Name" aria-describedby="searchBtn">
                <button class="btn btn-outline-secondary" id="searchBtn">Search</button>
            </div>
        </form>
    </div>
</section>

<section>
    <div class="container mt-3 text-center">
        <table class="table table-striped table-bordered">
            <thead>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Job Title</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Test1</td>
                    <td>Test2</td>
                    <td>Test3</td>
                    <td>Test4</td>
                </tr>
            </tbody>
        </table>
    </div>
</section>


<jsp:include page="../include/footer.jsp" />