let magazine = null;

$.get("magazines", function (data) {
    if (data !== '') {
        magazine = data;
    }
}).done(function () {

    var cardsContent = "";
    jQuery.each(magazine, function (i, value) {

        cardsContent +=
            "<div class='card' id='test'>" +
            "<div class='card-body'>" +
            "<h5 class='card-title'>" + value.nameOfMagazine + "</h5>" +
            "<h6 class='card-subtitle mb-2 text-muted'>" + value.price + ' $' + "</h6>" +
            "<p class='card-text'>" + value.description + "</p>" +
            "<a href='magazine?id=" + value.id + "' class='card-link'>" + 'read more...' + "</a>" +
            "</div>" +
            "</div>";


    });

    $('#magazineCards').html(cardsContent);
});