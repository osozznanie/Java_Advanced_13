<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.2.1/dist/css/bootstrap.min.css"
          integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

    <title>My Store</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link rel="stylesheet" href="css/login.css">

</head>
<body>
<%--@declare id="level"--%>
<div class="login-page">
    <div class="form">
        <form class="login-form">
            <input type="text" placeholder="email address" name="login" class="email"/>
            <input type="password" placeholder="password" name="password" class="password"/>
            <button class="login">login</button>
            <p class="message">Not registered? <a href="#">Create an account</a></p>
        </form>
        <form class="register-form">
            <input type="text" placeholder="name" name="firstName" class="firstName"/>
            <input type="text" placeholder="surname" name="lastName" class="lastName"/>
            <input type="text" placeholder="email address" name="email" class="email">
            <input type="password" placeholder="password" name="password" class="password"/>
            <button class="register">create</button>
            <p>Select your level</p>
            <label for="level">
                <%--@declare id="usertype"--%>
                <select name="userType" class="userType">
                    <option value="admin">Admin</option>
                    <option value="user">User</option>
                </select>
            </label>
            <p class="message">Already registered? <a href="#">Sign In</a></p>
        </form>
    </div>
    <div class="alert alert-success  alert-dismissible fade show"
         role="alert">
        <b>Success!</b> You are registered.
        <button type="button" class="close" data-dismiss="alert"
                aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>

</div>
<jsp:include page="footer.jsp"></jsp:include>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
        integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
        crossorigin="anonymous"></script>
<script
        src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"
        integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
        crossorigin="anonymous"></script>
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

<script src="js/login.js"></script>

</body>
</html>

