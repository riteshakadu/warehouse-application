class Warehouse {
    constructor(id, name, address, company, products, addedDate) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.company = company;
        this.products = products;
        this.addedDate = addedDate;
    }
}

class Employee {
    constructor(id, name, phone, company, addedDate) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.company = company;
        this.addedDate = addedDate;
    }

    static fromRawObject(raw) {
        let employee = new Employee();
        Object.assign(employee, raw);
        employee.addedDate = new Date(Date.parse(raw.addedDate)).toDateString();
        return employee;
    }
}

class Company {
    constructor(id, name, address, registrationDate, photo, addedDate, employees, warehouses) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.registrationDate = registrationDate;
        this.photo = photo;
        this.employees = employees;
        this.warehouses = warehouses;
        this.addedDate = addedDate;
    }
}

class Product {
    constructor(id, name, price, photo, description, warehouse, unit, addedDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.photo = photo;
        this.description = description;
        this.warehouse = warehouse;
        this.unit = unit;
        this.addedDate = addedDate;
    }

    static fromRawObject(raw) {
        let product = new Product();
        Object.assign(product, raw);
        product.addedDate = new Date(Date.parse(raw.addedDate)).toDateString();
        return product;
    }
}

class Address {
    constructor(country, city, street, house) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.house = house;
    }
}