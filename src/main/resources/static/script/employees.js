jQuery(function () {
    let employeesTable = $("#employeesTable")[0];
    getResource("/api/employees", employees => {

    })
});

function toEmployeeRow(employee) {

}