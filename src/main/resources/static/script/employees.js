jQuery(function () {
    $.LoadingOverlay('show');
    let employeesTableBody = $("#tableBody")[0];
    getResource("/api/employees", employees => {
        console.log(employees);
        employees
            .map(Employee.fromRawObject)
            .map(getEmployeeTableRow)
            .forEach(employeeRow => insertEmployeeIntoTable(employeesTableBody, employeeRow))
        $.LoadingOverlay('hide');
    })
});

function insertEmployeeIntoTable(tbody, row) {
    tbody.insertAdjacentHTML('beforeend', row);
}

function getEmployeeTableRow(employee) {
    return `
        <tr>    
            <td>${employee.id}</td>
            <td>
                <img class="logo-small employee-photo" src="${employee.photo}" alt="Employee photo">
                <span>${employee.name}</span>
            </td>
            <td>${employee.phone}</td>
            <td>${employee.addedDate}</td>
            <td class="flex-row justify-content-between">
                <img src="${employee.company.photo}" alt="Company logo" class="logo-small">
                <span>${employee.company.name}</span>
            </td>
        </tr>
    `
}
