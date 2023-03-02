package com.sunayanpradhan.photoeditor

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.github.dhaval2404.imagepicker.ImagePicker
import com.sunayanpradhan.photoeditor.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var imageUri: Uri? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.selectImageCard.setOnClickListener {

            ImagePicker.with(this)
                .crop()
                .start()

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        try {

            if (data != null) {

                imageUri = data.data

                val intent = Intent(this, EditActivity::class.java)
                intent.putExtra("imageUri", imageUri.toString())
                startActivity(intent)

            } else {


            }


        } catch (e: Exception) {


        }
    }

}