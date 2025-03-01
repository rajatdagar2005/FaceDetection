📸 Face Detection App using ML Kit

🚀 Introduction
This is an Android Face Detection App built using ML Kit (Google’s Machine Learning API), Jetpack Compose, and Kotlin. The app captures an image using the camera, detects faces, and provides details like smile probability, eye openness, and face count.

🏗 Tech Stack
Kotlin (Jetpack Components)
ML Kit (Face Detection API)
Camera API (Capture Images)
AlertDialog (Display results)
Jetpack Compose UI
✨ Features
✅ Real-time Face Detection 📸
✅ Smile & Eye Probability Detection 😊👀
✅ Camera Integration 📷
✅ Modern UI with Jetpack Compose 🎨
✅ Lightweight & Fast ML Model ⚡

🎬 Demo Video
📺 Watch the App in Action!

🏗 How It Works
Open the app and click the "Open Camera" button.
Capture an image using the phone's camera.
The app detects faces and displays:
Smile Probability (%)
Left Eye Open (%)
Right Eye Open (%)
The results are shown in a dialog box.
📦 Dependencies
Add the following dependencies to build.gradle:

gradle
Copy
Edit
dependencies {
    implementation 'com.google.mlkit:face-detection:16.1.7'
}
🔨 Installation
Clone the repository and run the project in Android Studio:

sh
Copy
Edit
git clone https://github.com/yourusername/FaceDetectionApp.git
cd FaceDetectionApp
Open the project in Android Studio, build, and run on an Android device.

🛠 Future Improvements
✅ Implement Activity Result API for better handling.
✅ Detect multiple faces and display details for all.
✅ Overlay detected faces with rectangles.
✅ Use Jetpack Compose UI instead of XML layouts.
📜 License
MIT License. Free to use & modify!

