jQuery(function () {
    $.LoadingOverlay("show");
    let id = $('#entityId').attr('value');
    getResource(`/api/product/${id}`, data => {
        let product = Product.fromRawObject(data);
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
    $('#productDescription').text(product.description);

    let cardsContainerRaw = $('#descriptionCards').get(0);
    if (product.warehouse) {
        cardsContainerRaw.insertAdjacentHTML('beforeend', createWarehouseCard(product.warehouse));
        cardsContainerRaw.insertAdjacentHTML('beforeend', createCompanyCard(product.warehouse.company));
    }
}

function createWarehouseCard(warehouse) {
    if (!warehouse) return '';
    let address = warehouse.address;
    return `
        <div class="card">
            <h5 class="card-header">
                ${warehouse.name}
            </h5>
            <div class="card-body">
                <div class="card-row" style="display: ${address ? 'flex' : 'none'};"> 
                    <div class="icon-container">
                        <i class="fa fa-map-marker" aria-hidden="true"></i>
                    </div>
                    <div class="attribute"> 
                        <div class="attribute-key"> 
                            Address
                        </div>
                        <div class="attribute-value">  
                             ${address.getAddressString()}
                        </div>
                    </div>
                </div>
            </div>
        </div>
    `;
}

function createCompanyCard(company) {
    if (!company) return '';
    let address = company.address;
    return `
        <div class="card">
            <div class="card-header">
                <img class="logo-small" src="${company.photo}" alt="Company photo">
                <span>${company.name}</span>
            </div>
            <div class="card-body">
                <div class="card-row" style="display: ${address ? 'flex' : 'none'};"> 
                    <div class="icon-container">
                        <i class="fa fa-map-marker" aria-hidden="true"></i>
                    </div>
                    <div class="attribute"> 
                        <div class="attribute-key"> 
                            Address
                        </div>
                        <div class="attribute-value">  
                             ${address.house} ${address.street}, ${address.city}, ${address.country}
                        </div>
                    </div>
                </div>
                    <div class="card-row" 
                         style="display: ${company.registrationDate ? 'flex' : 'none'};">
                        <div class="icon-container">   
                             <i class="fa fa-calendar" aria-hidden="true"></i>
                        </div>
                        <div class="attribute"> 
                            <div class="attribute-key"> 
                                Registration date
                            </div>
                            <div class="attribute-value">  
                                ${company.registrationDate} 
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    `;
}