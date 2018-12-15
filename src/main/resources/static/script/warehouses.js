jQuery(function () {
    $.LoadingOverlay('show');
    let cardContainer = $('#warehouseCards').get(0);
    getResource("/api/warehouses", warehouses => {
        warehouses
            .map(Warehouse.fromRawObject)
            .map(createWarehouseContainerCard)
            .forEach(warehouseCard =>
                insertWarehouseIntoContainer(cardContainer, warehouseCard));
        $.LoadingOverlay('hide');
    })
});

function insertWarehouseIntoContainer(container, warehouse) {
    container.insertAdjacentHTML('beforeend', warehouse);
}

function createWarehouseContainerCard(warehouse) {
    return `
        <div class="card">
            <div class="card-header">
                <img class="logo-small" src="${warehouse.company.photo}" alt="Company photo">
                <span>${warehouse.company.name}</span>
                <span class="date">${warehouse.addedDate}</span>
            </div>
            <img class="card-img-top card-background" 
                    src="${getRandomBackgroundURL()}" alt="Background">
            <div class="card-body">     
                <h4 class="card-title">${warehouse.name}</h4>
                <p class="card-text">${warehouse.address.getAddressString()}</p>
                <a href="/warehouse/warehouses/${warehouse.id}" class="btn btn-primary">Details</a>
            </div>
        </div>
    `;
}

let backgrounds = [
    "/assets/img/warehouse-card-bg-1.jpeg",
    "/assets/img/warehouse-card-bg-2.jpeg",
    "/assets/img/warehouse-card-bg-3.jpeg",
    "/assets/img/warehouse-card-bg-4.jpeg",
    "/assets/img/warehouse-card-bg-5.jpeg"
];

function getRandomBackgroundURL() {
    return backgrounds[Math.floor(Math.random() * backgrounds.length)]
}