
# 📸 Face Detection App using ML Kit  

## 🚀 Introduction  
This is an **Android Face Detection App** built using **ML Kit (Google’s Machine Learning API)** and **Kotlin**. The app captures an image using the camera, detects faces, and provides details like **smile probability, eye openness, and face count**.

## 🏗 Tech Stack  
- **Kotlin**  
- **ML Kit (Face Detection API)**  
- **Camera API**  
- **Jetpack Compose**  
- **AlertDialog** for displaying results  

## ✨ Features  
 **Real-time Face Detection** 📸  
 **Smile & Eye Probability Detection** 😊👀  
 **Camera Integration** 📷  
 **Lightweight & Fast ML Model** ⚡    

## 🏗 How It Works  
1. Open the app and **click the "Open Camera" button**.  
2. Capture an image **using the phone's camera**.  
3. The app detects faces and displays:  
   - **Smile Probability (%)**  
   - **Left Eye Open (%)**  
   - **Right Eye Open (%)**  
4. The results are shown in a **dialog box**.  

## 📦 Dependencies  
Add the following dependency in `build.gradle`:  
```gradle
dependencies {
    implementation 'com.google.mlkit:face-detection:16.1.7'
}
```

## 🔨 Installation  
Clone the repository and run the project in **Android Studio**:  
```sh
git clone https://github.com/yourusername/FaceDetectionApp.git
cd FaceDetectionApp
```
Open the project in **Android Studio**, build, and run on an **Android device**.


## 📜 License  
MIT License. Free to use & modify!  

---
