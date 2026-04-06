# Lecture Demo - CI/CD Friendly Spring Boot Example

This project is a simple Spring Boot app designed for CI/CD demos.

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
- Clear success and failure scenarios to show pipeline feedback

## Run tests

```powershell
./mvnw.cmd test
```

## Run the app

```powershell
./mvnw.cmd spring-boot:run
```
