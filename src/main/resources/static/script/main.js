$(document).ready(function () {
    $("#navbarSupportedContent .nav-link").each(function (index, element) {
        let href = $(element).attr("href");
        let result = window.location.href.search(href);
        if (result !== -1) {
            debugger;
            $(element).addClass("nav-item_selected");
        }
    })
});