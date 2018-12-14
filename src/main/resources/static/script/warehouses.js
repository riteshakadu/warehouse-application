jQuery(function () {
    getResource("/api/warehouses", warehouses => {
        console.log(warehouses);
    })
});