# Lecture Demo - CI/CD Friendly Spring Boot Example

This project is a simple Spring Boot app designed for CI/CD demos.

[![Quality Gate Status](http://pw0350kz:9000/api/project_badges/measure?project=com.example%3Alecture-demo&metric=alert_status&token=sqb_5b944686b118b86914d2e5b8239152bb6e5aba40)](http://pw0350kz:9000/dashboard?id=com.example%3Alecture-demo)
[![Coverage](http://pw0350kz:9000/api/project_badges/measure?project=com.example%3Alecture-demo&metric=coverage&token=sqb_5b944686b118b86914d2e5b8239152bb6e5aba40)](http://pw0350kz:9000/dashboard?id=com.example%3Alecture-demo)
## What the example does

It exposes one easy endpoint for a student score:

- `GET /api/grades/{score}`
- Input: score between `0` and `100`
- Output: letter grade and short description

Example response for `GET /api/grades/88`:

```json
{
  "score": 88,
  "grade": "B",
  "description": "Good"
}
```

For invalid values (like `120`), the API returns HTTP `400` with a problem detail payload.

## Why this is good for CI/CD demos

- Very small and easy-to-understand business rule
- Fast unit tests for pure logic
- Web layer test for endpoint behavior
- Database integration test using embedded H2 (read/write)
- Clear success and failure scenarios to show pipeline feedback

## Run tests

```powershell
./mvnw.cmd test
```

The integration test `GradeAuditRepositoryIntegrationTest` verifies data is persisted,
read back, and updated in an embedded H2 database.

## Run the app

```powershell
./mvnw.cmd spring-boot:run
```
