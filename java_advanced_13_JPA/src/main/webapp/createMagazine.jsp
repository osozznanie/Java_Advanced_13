<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>My Store</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="css/createMagazine.css">
    <style>
        footer{
            position: absolute;
            bottom: 0;
        }
    </style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<form class="createMagazine">
    <div class="mb-3">
        <%--@declare id="nameofmagazine"--%>
        <input type="text" class="form-control nameOfMagazine" name="nameOfMagazine" placeholder="Please, enter an existing name">
    </div>
    <div class="mb-3">
        <%--@declare id="description"--%>
        <input type="text" class="form-control magazineDescription" name="magazineDescription" placeholder="Description here...">
    </div>
    <div class="mb-3">
        <%--@declare id="price"--%>
        <input type="number" class="form-control magazinePrice" name="magazinePrice" placeholder="Price here...">
    </div>
    <button type="button" class="btn btn-primary createMagazine">Submit</button>
</form>

<jsp:include page="footer.jsp"></jsp:include>

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
<script src="js/serverCalls.js"></script>
</body>
</html>