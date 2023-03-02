package com.sunayanpradhan.photoeditor

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.databinding.DataBindingUtil
import com.dsphotoeditor.sdk.activity.DsPhotoEditorActivity
import com.dsphotoeditor.sdk.utils.DsPhotoEditorConstants
import com.sunayanpradhan.photoeditor.databinding.ActivityEditBinding


class EditActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_edit)

        val imageUri=intent.getStringExtra("imageUri").toString()


        val dsPhotoEditorIntent = Intent(this, DsPhotoEditorActivity::class.java)

        dsPhotoEditorIntent.data = imageUri.toUri()

        dsPhotoEditorIntent.putExtra(DsPhotoEditorConstants.DS_PHOTO_EDITOR_OUTPUT_DIRECTORY, "Edited Image")

        startActivityForResult(dsPhotoEditorIntent, 100)


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK) {

            if(requestCode==100) {

                    val outputUri: Uri? = data!!.data

                    binding.editedImage.setImageURI(outputUri)

            }
        }


    }


}