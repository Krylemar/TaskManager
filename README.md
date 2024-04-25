# Task Manager
## TU-Varna 3rd year project for the course "Internet Technologies"
### RESTful web API for managing tasks with title, description, and due date

---
## Specifications
| Endpoint       | Operation | Input          | Output              | Description                                 |
|----------------|-----------|----------------|---------------------|---------------------------------------------|
| /api/tasks     | POST      | TaskDto(JSON)  | TaskDto(JSON)       | Adds a new task and returns the added value |
| /api/tasks/all | GET       | -              | List<TaskDto>(JSON) | Retrieves all tasks                         |
| /api/tasks     | GET       | Task ID (JSON) | TaskDto(JSON)       | Retrieves a task by it's Id                 |
| /api/tasks     | PUT       | TaskDto(JSON)  | TaskDto(JSON)       | Updates a task                              |
| /api/tasks     | DELETE    | Task ID (JSON) | -                   | Deletes a task by id|
### Phase 1
- [x] Ability to do CRUD operations on tasks
- [x] Ability to be docker deployable
- [x] Implement Model, Controller, Repository, and Service layers
- [x] Use in-memory storage for tasks

### Phase 2
- [x] Implement validation for task fields
- [x] Use DTOs for data transfer between layers
- [x] Implement exception handling
- [x] Use PostgreSQL with JPA(Hibernate) task storage
- [x] Implement report entity with fields: id, description, hours logged, date created, task id
  - Queries:
    - [x] Add report to a task
    - [x] Get all reports of a task
    - [x] Get specific report of a task
    - [x] Update report of a task
    - [x] Delete report of a task
    - [x] Get all reports of a task with hours logged within a specific date range
    - [x] Get the report of a task with the most hours logged
    - [x] Get total hours logged for a task by id

### Phase 3
- [ ] Implement user registration and authentication
- [ ] Implement user roles
- [ ] Implement user-specific tasks
- [ ] Implement JWT for user authentication