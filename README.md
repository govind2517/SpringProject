#### 11-May-24 - HelloProject - with basic functionality 
- GET API - {baseUrl}/welcome
```postman
Hello World
```
- GET API - {baseUrl}/users
```postman
[
    {
        "id": 1,
        "name": "Govind",
        "userType": "LEARNER"
    },
    {
        "id": 2,
        "name": "Satwik",
        "userType": "LEARNER"
    },
    {
        "id": 3,
        "name": "Dheeraj",
        "userType": "INSTRUCTOR"
    },
    {
        "id": 4,
        "name": "Utakarsh",
        "userType": "INSTRUCTOR"
    },
    {
        "id": 5,
        "name": "Kunal",
        "userType": "MENTOR"
    }
]
```
- GET API - {baseUrl}/users/{id}
```postman
{
    "id": 5,
    "name": "Kunal",
    "userType": "MENTOR"
}
```
--------------------------------------------------------------
