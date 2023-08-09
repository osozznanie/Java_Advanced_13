<%@ page import="ExampleWithDB.shop.Magazine" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>My Store</title>
    <link rel="stylesheet" href="css/cabinet.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<main class="main">
    <div class="card" style="width: 18rem;">
        <div class="card-body">
            <h5 class="card-title">${magazine.nameOfMagazine}</h5>
            <h6 class="card-subtitle mb-2 text-muted">${magazine.price} $</h6>
            <p class="card-text">${magazine.description}</p>

            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#buyMagazineModal">Buy</button>
        </div>
    </div>
</main>

<div class="modal fade buyMagazineModal" id="buyMagazineModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document" id="bmm">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Buying a magazine "${magazine.getNameOfMagazine()}"</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Do you really want to add "${magazine.getNameOfMagazine()}" magazine to your cart?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                <button type="button" idMagazine="${magazine.id}" class="btn btn-primary buy-magazine">Buy</button>
            </div>
        </div>
    </div>
</div>
</main>
</div>
<jsp:include page="footer.jsp"></jsp:include>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="js/serverCalls.js"></script>
</body>
</html>