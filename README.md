# Microservices Product

### Endpoints

### save Product
....
POST /api/products/ HTTP/1.1
Host: localhost:3333
Authorization: Basic base62(usermane:password)
Content-Type: application/json
Content-Length: 45

{
"name": "test-1",
"price": 1.2
}
### get all products
GET /api/products HTTP/1.1
Host: localhost:3333
Authorization: Basic base64(username:password)
Content-Type: application/json
Content-Length: 45

{
"name": "test-1",
"price": 1.2
}

### delete product
DELETE /api/products/2 HTTP/1.1
Host: localhost:3333
Authorization: Basic base64(username:password)
Content-Type: application/json
Content-Length: 45

{
"name": "test-1",
"price": 1.2
}