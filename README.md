# 🚀 Getting Started 

This guide walks you through setting up, building, and running the project.

---

## ✅ Prerequisites

Make sure you have the following installed:

- **Java 17+**
- **Gradle 8+**
- **Docker**
- **Docker Compose**

To verify versions:

```bash
java -version
gradle -v
docker -v

```

## Build and run application

```bash
git clone https://github.com/myspace20/task_manager.git
cd task_manager

```

```bash
./gradlew build

```

```bash
docker compose up --build

```

---

## Swagger OpeApi Specification Endpoint

- http://localhost:8080/swagger-ui/index.html

## 📚 Endpoints

### 🔐 Authentication

- **POST** `/api/auth/register`  
  Register a new user.  
  **Request Body:** `CreateUserDto`  
  **Response:** `UserResponseDto`

- **POST** `/api/auth/login`  
  Log in a user.  
  **Request Body:** `LoginRequestDto`  
  **Response:** `LoginResponseDto`

---

### 👤 Users

- **GET** `/api/users`  
  Retrieve all users.  
  **Response:** List of `User`

- **GET** `/api/users/{id}`  
  Retrieve a user by ID.  
  **Response:** `UserResponseDto`

- **POST** `/api/users`  
  Create a new user.  
  **Request Body:** `CreateUserDto`  
  **Response:** `UserResponseDto`

---

### ✅ Tasks

- **GET** `/api/tasks`  
  Retrieve all tasks.  
  **Response:** List of `TaskResponseDto`

- **POST** `/api/tasks`  
  Create a new task.  
  **Request Body:** `CreateTaskDto`  
  **Response:** `TaskResponseDto`

- **PUT** `/api/tasks/{id}`  
  Update a task by ID.  
  **Request Body:** `TaskUpdateDto`  
  **Response:** `TaskResponseDto`

- **DELETE** `/api/tasks/{id}`  
  Delete a task by ID.  
  **Response:** 200 OK

---




## Componet diagram

[![](https://mermaid.ink/img/pako:eNqlVk1v2zgQ_SuEit6kxHL8qUOBJA6wu0iB1E63QKUeaGlkE5VJgaSauEH--w4pWpFiN46xOhimNDOc9-YNh09eKjLwIi8vxEO6plKT-6uEJ_zjR3LzqEFyWhCaaiFVwlW1XElarkmlQMZf8edHwgk-GZOQaiY4uZ3Xb6owDu5AKsGDH1EU6W0JzjSMb3hmIxDGcQMMzviKPDC9JnoNRG2Vhg1J0PwXo-QbLImQ5LNYsgLIZVmacBmoVLLS7Jhw4FnCTTz8UNotXf6Xd38bh4Kl1OZGFbkWXFPGQbbA0JK1rOJXXg4hhjO-UhQFGCrMu5cIlV6_fI0vcdmydhEO82SedRhfi00pEImOyPxmcd_27rDnGPyL8qwARQqxYtwnElZMaWnz9S1z-J1o8RM4YUpVlKewR5sJZakzf7oI0NSWBmvfJJbwV6A1VT9boO9xeRLo_mmg-_FnyukKQV_Pv86IwEpbvMrizVEiJiH1Nsxuzu-CaYTVgmlEfxLMi9NgXjS1tR1SSpEb3VdlRjWourilhBwkYFHxham0Am166Aj4LpK3wKPYFyB_MdzggNLdp1rmbnGch0GbB-dFbun2IAuD-F9aMAuZpBIydGK0cPA3TgcKlLICMBT88-1eHZe42_fd-t5BteJ-N9ThKVCH8VWl8ERSdTenjZRbEo_qnka4K77BqD7JKiBOEaVkQjK99Qno9Oy4_k_hwEhmx4FV_rs5GJ3Cwagj-kCVkLIcqbCE1OBRtOAqXzPgOkO9B3YLxhHZz6imrzhAmumSKohn7s9x8OO4mTMRuRNKryQsvtyScxxjfCVmVwc4GMcLHLKOAkRlTzO_EXktfXukm6avMqYNPUc0v8u9g7qZgA3qORS10NasVDiVFcuApC-G-xMiCFAOKgg-tbpqr82CYA40U-cPKE9rvEtnt3X3OG5itlS6J9ujMbunXBOzJYE9TbwR0zJpLxNdjrQg4G5HePcIg-DWTOLzuR3EZttPXb5qo3qC1aV1OP9g4tTtEm8b2WQWeluYszkt8FCYQU7qew9BnyL60JsM-uNl6-te7Z1hGI4my-ygoWsNZzhYTpdAW4Y78Iv6slZbTe1jUmzsjMgJXk1Qt8EDy_Q66pWPPmqrEDL6kOe5X_vi5YWrkkrb2jmmGSj2G6KwXz62orWE_n-CXpignu-tJMs8tKrA9zYgN9QsvSejj8TDq-gGEg9PHy-DnFaFTryEP6NbSfl3ITY7Tymq1dqLcpxPuKoH9YxRPDxeTFBGpooV114U9sY2hhc9eY9edDHtn_Wnw9GwF07HYW84HPje1ovGw7PpaDKYhuFkPJwMw-mz7_22u_bOxmg6CkN8PemH6Pf8H1WQCfs?type=png)](https://mermaid.live/edit#pako:eNqlVk1v2zgQ_SuEit6kxHL8qUOBJA6wu0iB1E63QKUeaGlkE5VJgaSauEH--w4pWpFiN46xOhimNDOc9-YNh09eKjLwIi8vxEO6plKT-6uEJ_zjR3LzqEFyWhCaaiFVwlW1XElarkmlQMZf8edHwgk-GZOQaiY4uZ3Xb6owDu5AKsGDH1EU6W0JzjSMb3hmIxDGcQMMzviKPDC9JnoNRG2Vhg1J0PwXo-QbLImQ5LNYsgLIZVmacBmoVLLS7Jhw4FnCTTz8UNotXf6Xd38bh4Kl1OZGFbkWXFPGQbbA0JK1rOJXXg4hhjO-UhQFGCrMu5cIlV6_fI0vcdmydhEO82SedRhfi00pEImOyPxmcd_27rDnGPyL8qwARQqxYtwnElZMaWnz9S1z-J1o8RM4YUpVlKewR5sJZakzf7oI0NSWBmvfJJbwV6A1VT9boO9xeRLo_mmg-_FnyukKQV_Pv86IwEpbvMrizVEiJiH1Nsxuzu-CaYTVgmlEfxLMi9NgXjS1tR1SSpEb3VdlRjWourilhBwkYFHxham0Am166Aj4LpK3wKPYFyB_MdzggNLdp1rmbnGch0GbB-dFbun2IAuD-F9aMAuZpBIydGK0cPA3TgcKlLICMBT88-1eHZe42_fd-t5BteJ-N9ThKVCH8VWl8ERSdTenjZRbEo_qnka4K77BqD7JKiBOEaVkQjK99Qno9Oy4_k_hwEhmx4FV_rs5GJ3Cwagj-kCVkLIcqbCE1OBRtOAqXzPgOkO9B3YLxhHZz6imrzhAmumSKohn7s9x8OO4mTMRuRNKryQsvtyScxxjfCVmVwc4GMcLHLKOAkRlTzO_EXktfXukm6avMqYNPUc0v8u9g7qZgA3qORS10NasVDiVFcuApC-G-xMiCFAOKgg-tbpqr82CYA40U-cPKE9rvEtnt3X3OG5itlS6J9ujMbunXBOzJYE9TbwR0zJpLxNdjrQg4G5HePcIg-DWTOLzuR3EZttPXb5qo3qC1aV1OP9g4tTtEm8b2WQWeluYszkt8FCYQU7qew9BnyL60JsM-uNl6-te7Z1hGI4my-ygoWsNZzhYTpdAW4Y78Iv6slZbTe1jUmzsjMgJXk1Qt8EDy_Q66pWPPmqrEDL6kOe5X_vi5YWrkkrb2jmmGSj2G6KwXz62orWE_n-CXpignu-tJMs8tKrA9zYgN9QsvSejj8TDq-gGEg9PHy-DnFaFTryEP6NbSfl3ITY7Tymq1dqLcpxPuKoH9YxRPDxeTFBGpooV114U9sY2hhc9eY9edDHtn_Wnw9GwF07HYW84HPje1ovGw7PpaDKYhuFkPJwMw-mz7_22u_bOxmg6CkN8PemH6Pf8H1WQCfs)


