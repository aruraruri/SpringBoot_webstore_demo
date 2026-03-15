# Spring Boot Demo REST API

This is a simple Spring Boot application that demonstrates how to create a RESTful API. It includes basic CRUD operations that simulate some aspects of webstore functionality. For demo purposes this API includes endpoints for both customer- and store manager perspectives.

### Customer (/api/customer)

Customer endpoints allow you to retrieve customer information, view their orders, and create new customers.

| Method | Endpoint                    | Description                   |
| ------ | --------------------------- | ----------------------------- |
| GET    | /api/customer/{id}        | Get customer by ID            |
| GET    | /api/customer/{id}/orders | Get all orders for a customer |
| POST   | /api/customer             | Create a new customer         |

### Orders (/api/order)

Order endpoints allow you to retrieve order information and create new orders.

| Method | Endpoint          | Description                           |
| ------ | ----------------- | ------------------------------------- |
| GET    | /api/order/{id} | Get order by ID                       |
| POST   | /api/order      | Create a new order (with order items) |

### View Orders (/api/vieworders)

This endpoint provides a read-only view of orders, allowing customers and store managers to query orders based on various criteria such as status, customer last name, and date range.

| Method | Endpoint                               | Description                                                     |
| ------ | -------------------------------------- | --------------------------------------------------------------- |
| GET    | /api/vieworders                      | Get all order views                                             |
| GET    | /api/vieworders/status/{status}      | Get orders by status                                            |
| GET    | /api/vieworders/customer/{last_name} | Get orders by customer last name                                |
| GET    | /api/vieworders/date-range           | Get orders between dates (query params: startDate, endDate) |

### Product Category (/api/productcategory)

Product category endpoints allow you to retrieve product category information and the products associated with a specific category.

| Method | Endpoint                             | Description                 |
| ------ | ------------------------------------ | --------------------------- |
| GET    | /api/productcategory/all           | Get all product categories  |
| GET    | /api/productcategory/{id}          | Get category by ID          |
| GET    | /api/productcategory/{id}/products | Get products by category ID |

### Product (/api/product)

The product endpoints allow you to retrieve product information, create new products, update existing products, and place orders for products (which reduces stock).

| Method | Endpoint                  | Description                                  |
| ------ | ------------------------- | -------------------------------------------- |
| GET    | /api/product/{id}       | Get product by ID                            |
| GET    | /api/product/all        | Get all products                             |
| POST   | /api/product/newproduct | Create a new product                         |
| PATCH  | /api/product/{id}       | Partially update a product                   |
| POST   | /api/product/{id}/order | Place an order for a product (reduces stock) |

## Summary
Total Endpoints: 15

    GET: 10 endpoints
    POST: 4 endpoints
    PATCH: 1 endpoint

The API covers:

    Customer management (create, read, view orders)
    Order management (create, read)
    Order views/queries (filtered views by status, customer, date range)
    Product catalog (categories, products, stock management)
    Product management (CRUD operations with optimistic locking for stock)