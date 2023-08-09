<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>My Store</title>
    <link rel="stylesheet" href="css/shoppingBasket.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<main class="main">
    <div class="form-group pull-right">
        <input type="text" class="search form-control" placeholder="What you looking for?">
    </div>
    <span class="counter pull-right"></span>
    <table class="table table-hover table-bordered results" id="table">

    </table>
</main>


<jsp:include page="footer.jsp"></jsp:include>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<script src="js/shoppingBasket.js"></script>
</body>
</html>