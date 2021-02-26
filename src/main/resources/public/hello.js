$(document).ready(function () {
    $.ajax({
        url: "http://localhost:8080/hello"
    }).then(function (data) {
        if (data) {
            $('.addressbookId').append("Address Book ID: " + data.id);
            for (i = 0; i < data.buddies.length; i++) {
                $('.addressbookContents').append("Name: " + data.addressBook[i].name + ", ").append("Phone Number: " + data.addressBook[i].number).append("<br>");
            }
        }
    });
});