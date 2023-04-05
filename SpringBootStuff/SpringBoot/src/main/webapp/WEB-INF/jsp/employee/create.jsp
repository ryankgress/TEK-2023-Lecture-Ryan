<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <jsp:include page="../include/header.jsp" />
    <style>
        body {
            background-color: #d3d3d3;
        }
    </style>
    <div class="container mt-3 col-5" style="margin-bottom: 20%;">
        <c:if test="${empty form.id}">
            <h1 class="text-center">Create Employee</h1>
        </c:if>
        <c:if test="${not empty form.id}">
            <h1 class="text-center">Edit Employee</h1>
        </c:if>
        <!-- <h1 class="text-center">New Employee Form</h1> -->
        <form action="/employee/createSubmit">
            <input type="hidden" name="id" value="${form.id}">
            <div class="mb-3">
                <label for="firstName" class="form-label">First Name</label>
                <input type="text" class="form-control" id="firstName" name="firstName" value="${form.firstName}">
            </div>
            <div class="mb-3">
                <label for="lastName" class="form-label">Last Name</label>
                <input type="text" class="form-control" id="lastName" name="lastName" value="${form.lastName}">
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email address</label>
                <input type="email" class="form-control" id="email" aria-describedby="emailHelp" name="email"
                    value="${form.email}">
                <div id="emailHelp" class="form-text">We'll never share your email with anyone.</div>
            </div>
            <div class="mb-3">
                <label for="extension" class="form-label">Extension</label>
                <input type="text" class="form-control" id="extension" name="extension" value="${form.extension}">
            </div>
            <div class="mb-3">
                <label for="jobTitle" class="form-label">Job Title</label>
                <input type="text" class="form-control" id="jobTitle" name="jobTitle" value="${form.jobTitle}">
            </div>
            <div class="mb-3">
                <label for="profileImage" class="form-label">Profile Image</label>
                <input type="text" class="form-control" id="profileImage" name="profileImage" value="${form.profileImage}">
            </div>
            <div class="mb-3">
                <label for="vacationHours" class="form-label">Vacation Hours</label>
                <input type="number" class="form-control" id="vacationHours" name="vacationHours"
                    value="${form.vacationHours}">
            </div>
            <!-- <h6>Office</h6> -->
            <div class="mb-3">
                <label for="officeId" class="form-label">Office</label>
                <select name="officeId" id="officeId" class="form-select">
                    <c:forEach items="${offices}" var="off">
                        <option value="${off.id}" 
                            <c:if test="${off.id eq form.officeId}">
                                selected
                            </c:if>
                        >${off.city}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="d-flex flexcolumn justify-content-center">
                <button class="btn btn-primary">Create Employee</button>
            </div>
        </form>
    </div>
    </section>

    <jsp:include page="../include/footer.jsp" />