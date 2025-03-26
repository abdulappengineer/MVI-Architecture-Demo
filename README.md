# MVI Demo

A **Jetpack Compose + MVI (Model-View-Intent) + Hilt + Retrofit** based Android application demonstrating modern Android architecture.

---

## 🔥 Tech Stack
- **Kotlin** - Modern language for Android development  
- **Jetpack Compose** - Declarative UI  
- **MVI (Model-View-Intent)** - Unidirectional data flow architecture  
- **Hilt** - Dependency Injection  
- **Retrofit** - Networking  
- **Coroutines & Flow** - Asynchronous programming

  ---

## 🚀 Getting Started
### 1️⃣ Clone the repository
git clone https://github.com/your-username/mvi-demo.git

---

## 📂 Folder Breakdown
| Folder | Description |
|--------|------------|
| **di/** | Contains Hilt dependency injection setup for managing dependencies across the app. |
| **data/** | Manages API calls, data sources, and repositories for handling business logic. |
| **model/** | Defines data models used for API responses and local data representation. |
| **intent/** | Represents user actions (intents) that trigger state changes in the MVI architecture. |
| **ui/** | Contains UI-related components, including Composables and ViewModels for state management. |
| **MainActivity.kt** | The entry point of the app where the UI is initialized. |

---

## 🚀 Project Setup Guide

Follow these steps to set up the MVI-based Jetpack Compose project.

### 1️⃣ Add Dependencies  
- Open `build.gradle.kts` (Module-level) and add the required dependencies for **Hilt, Retrofit, Coroutines, and Jetpack Compose**.
  
### 2️⃣ Create Data Model  
- Define a **Post** data model in `Post.kt` to represent API response data.

### 3️⃣ Create API Service  
- Set up `ApiService.kt` using **Retrofit** to fetch posts from the API.

### 4️⃣ Setup Hilt Dependency Injection  
- Create `AppModule.kt` and provide necessary **network and repository dependencies** using Hilt.

### 5️⃣ Create Repository  
- Implement `PostRepository.kt` to handle **data fetching and business logic**.

### 6️⃣ Define MVI Intent  
- Create `PostIntent.kt` to define **user actions (e.g., LoadPosts)** in the MVI pattern.

### 7️⃣ Define State  
- Create `PostState.kt` to represent **different UI states (Loading, Success, Error)**.

### 8️⃣ Create ViewModel  
- Implement `PostViewModel.kt` to **handle intents and manage state** using Kotlin **Coroutines & Flow**.

### 9️⃣ Create UI Screen  
- Design `PostScreen.kt` using **Jetpack Compose**, consuming state from `PostViewModel`.

### 🔟 Setup Main Activity  
- Modify `MainActivity.kt` to **set up the UI and initialize ViewModel**.

---

📌 **That's it!** Run the project and see MVI in action. 🚀  
💡 **Need improvements?** Feel free to contribute!  

---

### **✅ Why This Format?**
- **Clear project structure** in a code block.
- **Tech stack** for easy reference.
- **Step-by-step setup instructions**.
- **Table format** for folder descriptions.
- **Future improvements section** to track enhancements.

Let me know if you need modifications! 🚀

