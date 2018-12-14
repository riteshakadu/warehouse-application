jQuery(function () {
    $.LoadingOverlay("show");
    getResource("/api/products", products => {
        let cardsBlock = $('#productCards')[0];
        products.map(toProduct).map(createProductCardHTML).forEach(productHTML => {
            cardsBlock.insertAdjacentHTML('beforeend', productHTML)
        });
        cardsBlock.insertAdjacentHTML('beforeend', createAddNewProductCardHTML());
        $('#addNewCard').hover(function () {
            $(this).addClass('card-hovered');
        }, function () {
            $(this).removeClass('card-hovered');
        });
        $.LoadingOverlay("hide");
    });
});

function toProduct(productObject) {
    return Product.fromRawObject(productObject)
}

function createProductCardHTML(product) {
    return `
        <div class="card">
            <div class="card-header">
                <span class="price">Price: ${product.price} ${product.unit}</span>
                <span class="date">${product.addedDate}</span>
            </div>
            <img class="card-img-top" src="${product.photo}" alt="Product image">
            <div class="card-body">
                <h4 class="card-title">${product.name}</h4>
                <p class="card-text">${product.description}</p>
                <a href="/warehouse/products/${product.id}" class="btn btn-primary">Details</a>
            </div>
        </div>
    `;
}

function createAddNewProductCardHTML() {
    return `
        <div id="addNewCard" class="card add-new-card">  
            <div class="card-body">     
                <h3 class="card-title">Add new product</h3>
                    <a class="add-new-card-link"> 
                        <i class="fa fa-plus-circle icon-plus-add" aria-hidden="true"></i>
                    </a>
            </div>
        </div>
    `;
}