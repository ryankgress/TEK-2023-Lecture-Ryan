<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <jsp:include page="include/header.jsp" />

        <section>
            <div class="container">
                <h1>Inquizitive Trivia Hub</h1>
            </div>
        </section>


        <section>
            <div class="container mt-3 mb-5 d-flex flex-column justify-content-center text-center">
                <div>
                    <h2 class="text-white">Upcoming Trivia</h2>
                    <p>
                        For owners of bars, pubs, fire halls, and more! If you've got space and wanna host some nerds,
                        you're more than welcome. Fill out the details here and get your event posted!
                    </p>
                </div>
                <div class="text-center">
                    <button class="btn btn-warning btn-lg" type="button" data-bs-toggle="offcanvas"
                        data-bs-target="#offcanvasScrolling" aria-controls="offcanvasScrolling"><b>Host An
                            Event</b></button>
                </div>
            </div>
        </section>

        <section>
            <div
                class="trivia-host container mt-3 mb-5 d-flex flex-column border border-danger border-2 rounded-3 justify-content-center text-center p-3">
                <div>
                    <h2>Host Your Own!</h2>
                    <p>
                        For owners of bars, pubs, fire halls, and more! If you've got space and wanna host some nerds,
                        you're more than welcome. Fill out the details here and get your event posted!
                    </p>
                </div>
                <div class="text-center">
                    <button class="btn btn-warning btn-lg" type="button" data-bs-toggle="offcanvas"
                        data-bs-target="#offcanvasScrolling" aria-controls="offcanvasScrolling"><b>Host An
                            Event</b></button>
                </div>
            </div>
        </section>







        <!--Create Trivia Listing Sidebar-->
        <div class="offcanvas offcanvas-end" data-bs-scroll="true" data-bs-backdrop="false" tabindex="-1"
            id="offcanvasScrolling" aria-labelledby="offcanvasScrollingLabel">
            <c:if test="${bindingResult.hasFieldErrors()}">
                <script>
                    var newTeamForm = document.getElementById('offcanvasScrolling');
                    newTeamForm.classList.add('show');
                </script>
            </c:if>
            <div class="offcanvas-header">
                <h4 class="offcanvas-title text-center" id="offcanvasScrollingLabel">Trivia Details</h4>
                <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas"
                    aria-label="Close"></button>
            </div>
            <div class="offcanvas-body">
                <form class="m-3 d-flex flex-column justify-content-center" action="/newTrivia" method="post"
                    enctype="multipart/form-data">
                    <div class="mb-3 col-sm-9 mx-auto">
                        <label for="triviaNameInput" class="form-label">Trivia Name</label>
                        <input type="text" class="form-control" placeholder="i.e. Star Wars Trivia Night"
                            id="triviaNameInput" name="triviaName" value="${form.triviaName}" required>
                        <c:if test="${bindingResult.hasFieldErrors('triviaName')}">
                            <c:forEach items="${bindingResult.getFieldErrors('triviaName')}" var="error">
                                <div style="color:red">${error.getDefaultMessage()}</div>
                            </c:forEach>
                        </c:if>
                    </div>
                    <div class="mb-3 col-sm-9 mx-auto">
                        <label for="locNameInput" class="form-label">Location Name</label>
                        <input type="text" class="form-control" id="locNameInput" name="locationName"
                            value="${form.locationName}" required>
                        <c:if test="${bindingResult.hasFieldErrors('locationName')}">
                            <c:forEach items="${bindingResult.getFieldErrors('locationName')}" var="error">
                                <div style="color:red">${error.getDefaultMessage()}</div>
                            </c:forEach>
                        </c:if>
                    </div>
                    <div class="mb-3 col-sm-9 mx-auto">
                        <label for="add1Input" class="form-label">Address Line 1</label>
                        <input type="text" class="form-control" id="add1Input" name="address1" value="${form.address1}"
                            required>
                        <c:if test="${bindingResult.hasFieldErrors('address1')}">
                            <c:forEach items="${bindingResult.getFieldErrors('address1')}" var="error">
                                <div style="color:red">${error.getDefaultMessage()}</div>
                            </c:forEach>
                        </c:if>
                    </div>
                    <div class="mb-3 col-sm-9 mx-auto" id="add2Field">
                        <label for="add2Input" class="form-label">Address Line 2</label>
                        <input type="text" class="form-control" id="add2Input" name="address2">
                        <c:if test="${bindingResult.hasFieldErrors('address2')}">
                            <c:forEach items="${bindingResult.getFieldErrors('address2')}" var="error">
                                <div style="color:red">${error.getDefaultMessage()}</div>
                            </c:forEach>
                        </c:if>
                    </div>
                    <div class="mb-3 col-sm-9 mx-auto" id="add2Field">
                        <label for="cityInput" class="form-label">City</label>
                        <input type="text" class="form-control" id="cityInput" name="city">
                        <c:if test="${bindingResult.hasFieldErrors('city')}">
                            <c:forEach items="${bindingResult.getFieldErrors('city')}" var="error">
                                <div style="color:red">${error.getDefaultMessage()}</div>
                            </c:forEach>
                        </c:if>
                    </div>
                    <div class="mb-3 row mx-auto justify-content-center" id="StateZipField">

                        <div class="state col-4">
                            <label for="stateInput" class="form-label">State</label>
                            <input type="text" class="form-control" id="stateInput" name="state" placeholder="i.e. PA">
                            <c:if test="${bindingResult.hasFieldErrors('state')}">
                                <c:forEach items="${bindingResult.getFieldErrors('state')}" var="error">
                                    <div style="color:red">${error.getDefaultMessage()}</div>
                                </c:forEach>
                            </c:if>
                        </div>

                        <div class="col-6">
                            <label for="zipInput" class="form-label">Zip Code</label>
                            <input type="text" class="form-control" id="zipInput" name="zip">
                            <c:if test="${bindingResult.hasFieldErrors('zip')}">
                                <c:forEach items="${bindingResult.getFieldErrors('zip')}" var="error">
                                    <div style="color:red">${error.getDefaultMessage()}</div>
                                </c:forEach>
                            </c:if>
                        </div>


                    </div>

                    <div class="mb-3 col-sm-9 mx-auto" id="startTimeField">
                        <label for="dateInput" class="form-label">Date</label>
                        <input type="date" class="form-control" id="dateInput" name="date">
                        <c:if test="${bindingResult.hasFieldErrors('date')}">
                            <c:forEach items="${bindingResult.getFieldErrors('date')}" var="error">
                                <div style="color:red">${error.getDefaultMessage()}</div>
                            </c:forEach>
                        </c:if>
                    </div>
                    <div class="mb-3 col-sm-9 mx-auto" id="startTimeField">
                        <label for="timeInput" class="form-label">Start Time</label>
                        <input type="time" class="form-control" id="timeInput" name="time">
                        <c:if test="${bindingResult.hasFieldErrors('time')}">
                            <c:forEach items="${bindingResult.getFieldErrors('time')}" var="error">
                                <div style="color:red">${error.getDefaultMessage()}</div>
                            </c:forEach>
                        </c:if>
                    </div>

                    <button class="btn btn-dark mx-5">Create Trivia</button>
                </form>
            </div>
        </div>


        <jsp:include page="include/footer.jsp" />