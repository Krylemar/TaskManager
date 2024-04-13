# Task Manager
## TU-Varna 3rd year project for the course "Internet Technologies"
### RESTful web API for managing tasks with title, description, and due date

---
## Specifications

### Phase 1
- ~~Ability to do CRUD operations on tasks~~
- ~~Ability to be docker deployable~~
- ~~Implement Model, Controller, Repository, and Service layers~~
- ~~Use in-memory storage for tasks~~

### Phase 2
- ~~Implement validation for task fields~~
- ~~Use DTOs for data transfer between layers~~
- ~~Implement exception handling~~
- Use PostgreSQL with JPA(Hibernate) task storage
  - Queries:
   - Add report to a task
   - Get all reports of a task
   - Get specific report of a task
   - Update report of a task
   - Delete report of a task
   - Get all reports of a task with hours logged within a specific date range
   - Get the report of a task with the most hours logged
   - Get total hours logged for a task by id

### Phase 3
- Implement user registration and authentication
- Implement user roles
- Implement user-specific tasks
- Implement JWT for user authentication