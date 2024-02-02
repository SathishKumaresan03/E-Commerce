I have finished this project using Spring Boot because I am not familiar with Laravel or Node.js.
I attempted to generate Swagger API documentation, but encountered a bug or issue on my laptop, preventing me from providing it.
I have tested my code using Postman API.


Follow these steps using Postman to interact with the Spring Boot API.
 
1.Create a Product:

POST: http://localhost:8080/product/add
Body (JSON):
json
Copy code
{
  "name": "Laptop",
  "description": "High-performance laptop",
  "price": 1200.00
}
2.Update a Product:

PUT: http://localhost:8080/product/{productId}/update
Replace {productId} with the ID of the product to update.
Body (JSON):
json
Copy code
{
  "name": "Updated Laptop",
  "description": "Updated description",
  "price": 1500.00
}
3.Delete a Product:

DELETE: http://localhost:8080/product/{productId}/delete
Replace {productId} with the ID of the product to delete.

4.Get All Products:
GET: http://localhost:8080/products/gettAll

5.Get a Product by ID:
GET: http://localhost:8080/products/{productId}/get
Replace {productId} with the ID of the product to retrieve.

6.Add Variant to a Product:
POST: http://localhost:8080/product-Variant/{productId}/variants
Replace {productId} with the ID of the product.
Body (JSON):
json
Copy code
{
  "name": "Standard Edition",
  "sku": "ST123",
  "additionalCost": 100.00,
  "stockCount": 50
}

7.Create a Product Variant:
POST: http://localhost:8080/product-variants/add
Body (JSON):
json

8.Update a Product Variant:
PUT: http://localhost:8080/product-variant/{variantId}/update
Replace {variantId} with the ID of the variant to update.
Body (JSON):
json
Copy code
{
  "name": "Updated Premium Edition",
  "sku": "UPR123",
  "additionalCost": 250.00,
  "stockCount": 120
}
9.Delete a Product Variant:
DELETE: http://localhost:8080/api/product-variant/{variantId}/delete
Replace {variantId} with the ID of the variant to delete.

10.Get All Product Variants:
GET: http://localhost:8080/api/product-variant/getAll
