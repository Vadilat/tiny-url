# Tiny URL Shortener with Analytics

Built using Spring Boot with Spring Web for RESTful API exposure, Redis for fast URL lookups, and MongoDB for analytics.

---

## ⚙Tech Stack

- **Java**
- **Spring Boot**
- **Spring Web (REST)**
- **Redis** – for storing short URL mappings
- **MongoDB** – for persistent user and click analytics
- **Jackson** – for JSON serialization
- **Joda-Time** – for time-based stats
- **Maven**

---

## Features

- 🔗 Shorten any valid long URL
- 🧠 Automatically creates a new user if not found
- 🔁 Redirects users from short link to original long URL
- 📊 Tracks per-user click analytics by month
- 🧵 Saves each click with a timestamp and long URL
- ⚡ Fast lookup with Redis and persistent tracking with MongoDB

---

## Project Structure

```text
src/
├── config/         → Redis and Mongo config (if needed)
├── controller/     → Main REST controller
├── model/          → User, URL, and click models
├── repository/     → Mongo repositories
├── service/        → Redis wrapper and business logic
├── util/           → Helpers like date/time formatting
└── resources/
    └── application.properties
```


## API Endpoints

| Method | Endpoint                   | Description                                       |
|--------|----------------------------|---------------------------------------------------|
| POST   | `/tiny`                    | Create a new short URL (`NewTinyRequest` in body) |
| GET    | `/{tiny}/`                 | Redirects to long URL, updates click analytics    |
| GET    | `/reverseTiny?tiny=abc123` | Returns long URL from short code                  |
| POST   | `/user?name=alice`         | Create new user with the given name               |
| GET    | `/user/{name}`             | Fetch a user by name                              |
| GET    | `/user/{name}/clicks`      | Get all click records for a specific user         |

---

## Example Request

```http
POST /tiny
Content-Type: application/json

{
  "longUrl": "https://example.com/some/long/path",
  "userName": "alice"
}
```
## Running the App
### Prerequisites
- Java 
- Maven
- Redis running
- MongoDB running

### Build & Run
```bash
mvn clean install
mvn spring-boot:run
```
Ensure Redis and MongoDB are running and accessible.

### Configuration
Edit application.properties as needed:
```yaml
spring.data.mongodb.uri=mongodb://localhost:27017/tinydb
base.url=http://localhost:8080/
```
