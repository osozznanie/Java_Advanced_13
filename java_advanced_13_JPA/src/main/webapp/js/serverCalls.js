$("button.createMagazine").click(function () {
    let name = $("form.createMagazine input.nameOfMagazine").val();
    let description = $("form.createMagazine input.magazineDescription").val();
    let price = $("form.createMagazine input.magazinePrice").val();

    // Add validation to check if required fields are not empty
    if (!name || !description || !price) {
        alert("Please fill in all required fields.");
        return;
    }

    let magazine = {
        name: name,
        description: description,
        price: price
    };

    // Make the AJAX POST request to create the magazine
    $.post("magazine", magazine, function (data) {
        if (data === 'Success') {
            alert('Success');
        } else {
            alert('Failed to create the magazine.');
        }
    })
});

$("button.buy-magazine").click(function () {
    let mId = jQuery(this).attr("idMagazine");

    $.post("subscribe", {"idMagazine": mId}, function (data) {
        if (data === "Success") {
            $('#buyMagazineModal').hide();
            $('.modal-backdrop').remove();
            alert('The magazine has been successfully added to your cart!');
        }
    });
});


