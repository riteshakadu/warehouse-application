jQuery(function () {
    $.LoadingOverlay("show");
    let id = $('#entityId').attr('value');
    getResource(`/api/product/${id}`, data => {
        let product = Product.fromRawObject(data);
        console.log(product);
        fillProductPage(product);
        $.LoadingOverlay("hide");
    });
});

function fillProductPage(product) {
    $('#productName').text(product.name);
    $('#headerProductName').text(product.name);
    $('#companyName').text(product.warehouse.company.name);
    $('#warehouseName').text(product.warehouse.name);
    $('#addedDate').text(product.addedDate);
    $('#companyLogo').attr('src', product.warehouse.company.photo);
    $('#productPhoto').attr('src', product.photo);
}