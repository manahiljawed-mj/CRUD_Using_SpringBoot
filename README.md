
# 🌟 Spring Boot CRUD Operations with RESTful API

This Spring Boot application implements CRUD (Create, Read, Update, Delete) operations for managing laptops via a RESTful API.

## 🚀 Technologies Used
- Java
- Spring Boot
- PostgreSQL
- JDBC

## 🛠️ Usage
To use this application, follow these steps:

## Clone the repository
 https://github.com/manahiljawed-mj/CRUD_Using_SpringBoot.git
## Configure PostgreSQL
 - Ensure PostgreSQL is installed and running.
 - Create a database named 'databaseDemo'.
 - Set up the 'Laptop' table
## Update Database Connection
 - Modify the database connection settings in 'application.properties':

## Run the Application
 - Compile and run the Spring Boot application:


## 📊 API Endpoints
- GET /laptop: Retrieve all laptops.
- POST /addLaptop: Add a new laptop.
  - Request Body:
  \`\`\`json
  {
    "id": 1,
    "name": "LaptopName"
  }
  \`\`\`
- PUT /updateLaptop/{id}: Update an existing laptop.
  - Request Body:
  \`\`\`json
  {
    "id": 1,
    "name": "UpdatedLaptopName"
  }
  \`\`\`
- PATCH /patchLaptop/{id}: Partially update an existing laptop.
  - Request Body (example to update only name):
  \`\`\`json
  {
    "name": "UpdatedLaptopName"
  }
  \`\`\`
- DELETE /deleteLaptop/{id}: Delete a laptop by ID.

## 🎉 Contribution
Contributions are welcome! Here are a few ways you can contribute:
- Implement additional CRUD operations.
- Improve error handling and validation.
- Enhance API documentation.

Feel free to fork this repository and customize it according to your needs!
EOF

echo "README.md file generated successfully!"
