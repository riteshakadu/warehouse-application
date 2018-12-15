jQuery(function () {
    $.LoadingOverlay('show');
    let tableBody = $('#tableBody').get(0);
    getResource("/api/companies", companies => {
        companies
            .map(Company.fromRawObject)
            .map(createCompanyRow)
            .forEach(companyRow => insertCompanyIntoTable(tableBody, companyRow));
        $.LoadingOverlay('hide');
    })
});

function insertCompanyIntoTable(tbody, company) {
    tbody.insertAdjacentHTML('beforeend', company);
}

function createCompanyRow(company) {
    return `
        <tr>    
            <td>${company.id}</td>
            <td><img class="logo-small employee-photo" src="${company.photo}" alt="Company photo"></td>
            <td>${company.name}</td>
            <td>${company.registrationDate}</td>
            <td>${company.address.getAddressString()}</td>
            <td>${company.addedDate}</td>
        </tr>
    `
}