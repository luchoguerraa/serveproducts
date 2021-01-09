# ![Spring boot + MongoDB Server Store]

[[SERVER PRODUCTS]]()

> ### Spring boot (java 11 jdk oracle) + MongoDB 3.6.8 codebase for Server Store proyect

### [Demo]()&nbsp;&nbsp;&nbsp;&nbsp;[Store Promotions](https://github.com/luchoguerraa/serveproducts.git)

Originally created for this [GH issue](https://github.com/luchoguerraa/serveproducts.git). The codebase is now feature complete; please submit bug fixes via pull requests & feedback via issues.

## Getting started

You can view a live demo over at https://serverproducts-backend.herokuapp.com/api/v1/private/store/products/

To get the frontend running locally:

- Clone this repo: you can use [Intellij](https://www.jetbrains.com/idea/download/?gclid=CjwKCAiAxeX_BRASEiwAc1Qdkd0DdIOwl9BqMqH7UnEhWh3s1ZOvDS_7vgsZ1fXdYHTzyV-JIPShyBoC1YwQAvD_BwE#section=mac) or [STS](https://spring.io/tools) IDE for deploy. 
##  Warning
Same version of jdk Java (jdk amazon, corretto, apt) do not works with MongoDB because they dont have all the certificate necessary for it.

## Functionality 

 endpoints:
- /api/v1/private/store/products/ : get full products of store
- /api/v1/private/store/products?filter=<code product or brand or description> : get products using filters. If the words used for it is a palindrome the user can get a discount of 50% by product.

