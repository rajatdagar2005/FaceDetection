package com.example.facedetectionml

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.face.FaceDetection
import com.google.mlkit.vision.face.FaceDetectorOptions

class MainActivity : AppCompatActivity() {
    @SuppressLint("QueryPermissionsNeeded")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // implementation ("com.google.ml-kit:face-detection:16.1.7")  this is termed as group id , artefact id , version

        // this is finding view of type button from resource
        // is used in Android Studio to get a reference to a Button view from your XML layout file using its ID (btnCamera).
        val buttonCamera = findViewById<Button>(R.id.btnCamera)
        buttonCamera.setOnClickListener{
            // camera open karna
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            if(intent.resolveActivity(packageManager)  != null){
                // camera use karke kuch knowledge vapas lekar aane ke liye
                startActivityForResult(intent,123)
            }
            else{
                Toast.makeText(this,"Oops Something Went Wrong ", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // using start activity for result here
    // camera se basically sab kuch receive karna
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        // ye data image se aeega
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode==123 && resultCode == RESULT_OK){
            val extras = data?.extras // isme vo data recieve hua hai

            // image iss type mai leeni hai
            val bitmap = extras?.get("data") as? Bitmap

            if (bitmap != null) {
                detectFace(bitmap)
            }
        }
    }
    private fun detectFace(bitmap: Bitmap){
        // copied from https://developers.google.com/ml-kit/vision/face-detection/android
        val options = FaceDetectorOptions.Builder()
            .setPerformanceMode(FaceDetectorOptions.PERFORMANCE_MODE_ACCURATE)
            .setLandmarkMode(FaceDetectorOptions.LANDMARK_MODE_ALL)
            .setClassificationMode(FaceDetectorOptions.CLASSIFICATION_MODE_ALL)
            .build()

        val detector = FaceDetection.getClient(options)  // get instance of face detector jo option choose kare hai vo face ke pata chalne chaiye
        val image = InputImage.fromBitmap(bitmap, 0)

        val result = detector.process(image)  // this ml model detector process image
            .addOnSuccessListener { faces ->
                // Task completed successfully
                // our face is successfully detected
                var resultText = ""
                var i = 1
                for(face in faces ){
                    // face iterates one by one on faces
                    resultText = "Face Number :  $i\n" +
                            "Smile (in %) : ${face.smilingProbability?.times(100)}% \n" +
                            "Left Eye open : ${face.leftEyeOpenProbability?.times(100)}% \n" +
                            "Right Eye open : ${face.rightEyeOpenProbability?.times(100)}%";
                    i++
                }
                if(faces.isEmpty()){
                    Toast.makeText(this,"  No Face Detected ", Toast.LENGTH_SHORT).show()
                }
                else{
                    //Toast.makeText(this, resultText, Toast.LENGTH_LONG).show()
                    //Snackbar.make(findViewById(android.R.id.content), resultText, Snackbar.LENGTH_LONG).show()
                    AlertDialog.Builder(this)
                        .setTitle("Face Detection Result")
                        .setMessage(resultText)
                        .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
                        .show()
                }
            }
            .addOnFailureListener { e ->
                // Task failed with an exception
                // face not detected successfully
                Toast.makeText(this,"Something Wrong ", Toast.LENGTH_LONG).show()
            }
    }
} 