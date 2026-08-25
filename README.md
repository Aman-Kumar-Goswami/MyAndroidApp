# 🧮 Calcify

**Calcify** is a simple, modern, and user-friendly Android calculator application built with **Kotlin** and **Jetpack Compose**. It provides essential arithmetic operations through a clean and responsive interface.

## ✨ Features

* ➕ Addition
* ➖ Subtraction
* ✖️ Multiplication
* ➗ Division
* 🔢 Decimal number support
* 🔗 Parentheses support
* 🧹 Clear (`C`) functionality
* 🔄 All Clear (`AC`) functionality
* 🟰 Calculate results instantly
* 📱 Clean and responsive UI
* ⚡ Reactive UI with LiveData
* 🏗️ ViewModel-based state management

## 🛠️ Tech Stack

* **Language:** Kotlin
* **UI:** Jetpack Compose
* **Design:** Material 3
* **Architecture:** MVVM
* **State Management:** ViewModel + LiveData
* **IDE:** Android Studio
* **Build System:** Gradle

## 🏗️ Architecture

Calcify follows the **MVVM (Model–View–ViewModel)** architecture.

```text
┌─────────────────────────┐
│    Jetpack Compose UI   │
└────────────┬────────────┘
             │
             ▼
┌─────────────────────────┐
│  CalculatorViewModel    │
└────────────┬────────────┘
             │
             ▼
┌─────────────────────────┐
│   Calculator Logic      │
└─────────────────────────┘
```

The `CalculatorViewModel` manages the equation and result states, while the Compose UI observes these states and updates automatically.

## 📱 Calculator Operations

Calcify provides the following operations:

```text
 C    (    )    /
 7    8    9    *
 4    5    6    +
 1    2    3    -
 AC   0    .    =
```

## 📂 Project Structure

```text
Calcify/
│
├── app/
│   └── src/
│       └── main/
│           ├── java/
│           │   └── com/example/calculatorlatest/
│           │       ├── Calculator.kt
│           │       ├── CalculatorViewModel.kt
│           │       └── MainActivity.kt
│           │
│           └── res/
│
├── build.gradle.kts
├── settings.gradle.kts
└── README.md
```

> Update the package name and file structure if they differ in your actual project.

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone YOUR_GITHUB_REPOSITORY_URL
```

### 2. Open in Android Studio

Open the cloned project in **Android Studio** and allow Gradle to sync.

### 3. Run the App

Connect an Android device or start an Android Emulator and click:

**Run ▶**

## 🎯 Learning Objectives

This project demonstrates practical implementation of:

* Kotlin Android development
* Jetpack Compose
* Material 3 UI
* MVVM architecture
* ViewModel
* LiveData
* Reactive UI state
* LazyVerticalGrid
* Event handling in Compose
* Building a functional calculator

## 🔮 Future Improvements

* 🌙 Dark/Light theme
* 📜 Calculation history
* 🧮 Scientific calculator mode
* 📋 Copy result functionality
* 🎨 More customizable themes
* 🔊 Haptic feedback

This project is created for **learning and educational purposes**.
