$(document).ready(function () {
    $(".search").keyup(function () {
        var searchTerm = $(".search").val().toLowerCase();
        var listItem = $('.results tr').not(':first'); // Exclude the first row (table header)
        var searchSplit = searchTerm.replace(/ /g, "'):containsi('")

        $.extend($.expr[':'], {
            'containsi': function (elem, i, match, array) {
                return (elem.textContent || elem.innerText || '').toLowerCase().indexOf((match[3] || "").toLowerCase()) >= 0;
            }
        });

        listItem.each(function (e) {
            var content = $(this).text().toLowerCase();
            $(this).attr('visible', content.indexOf(searchTerm) !== -1);
        });

        var jobCount = $('.results tr[visible="true"]').length;
        $('.counter').text(jobCount + ' item');

        if (jobCount == 0) {
            $('.no-result').show();
        } else {
            $('.no-result').hide();
        }
    });
});

function addDaysToCurrentDate(days) {
    var currentDate = new Date();
    currentDate.setDate(currentDate.getDate() + days);

    var daysOfWeek = ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'];
    var months = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];

    var dayOfWeek = daysOfWeek[currentDate.getDay()];
    var month = months[currentDate.getMonth()];

    var formattedDate = dayOfWeek + ' ' + month + ' ' + currentDate.getDate() + ' ' + currentDate.getFullYear() + ' ' + currentDate.toLocaleTimeString();

    return formattedDate;
}

// Пример использования
var futureDate = addDaysToCurrentDate(7);
$(document).ready(function() {
    var buckets = []; // Initialize the buckets array

    $.get('subscribes', function (data) {
        console.log(data);
        if (data !== '') {
            buckets = data;
        }
    }).done(function () {
        var tableContent = "<tr class='header'>"
            + "<th style='width: 20%;'>Title</th>"
            + "<th style='width: 20%;'>Description</th>"
            + "<th style='width: 10%;'>Price</th>"
            + "<th style='width: 13%;'>Date</th>"
            + "<th style='width: 10%;'>Subscription status</th>"
            + "<th style='width: 7%;'>Options</th>"
            + "</tr>";

        jQuery.each(buckets, function (i, value) {
            tableContent += "<tr>"
                + "<td>" + value.nameOfMagazine + "</td>"
                + "<td>" + value.description + "</td>"
                + "<td>" + value.price + "</td>"
                + "<td>" + futureDate + "</td>"
                + "<td>" + 'Subscribed' + "</td>"
                + "<td><button class='button-55' onclick='deleteOrderFromBucket(" + value.subscribeId + ") '>delete</td>"
                + "</tr>";
        });

        $('#table').html(tableContent);
    });
});

function deleteOrderFromBucket(id) {
    var customUrl = '';
    var urlContent = window.location.href.split('/');

    for (var i = 0; i < urlContent.length - 1; i++) {
        customUrl += urlContent[i] + '/'
    }

    customUrl += 'subscribe?id=' + id;

    $.ajax({
        url: customUrl,
        type: 'DELETE',
        success: function(data) {
            if (data == 'Success') {
                location.reload();
                alert('The record has been deleted!');
            }
        }
    });
}