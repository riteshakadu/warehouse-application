jQuery(function () {
    $.LoadingOverlay("show");
    let id = $('#entityId').attr('value');
    getResource(`/api/product/${id}`, product => {
        $.LoadingOverlay("hide");
    });
});
