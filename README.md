# Sonarqube Demo - Java Spring Boot

This project is a simple Spring Boot app designed for CI/CD demos.

## What the example does

It exposes an endpoint for a student score:

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


