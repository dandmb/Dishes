package com.example.dishes.view.activities

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.dishes.R
import com.example.dishes.databinding.ActivityAddUpdateDishBinding
import com.example.dishes.databinding.DialogCustomImageSelectionBinding
import com.example.dishes.databinding.FragmentAllDishesBinding

class AddUpdateDishActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mBinding: ActivityAddUpdateDishBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding=ActivityAddUpdateDishBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        setupActionBar()
        mBinding.ivAddDishImage.setOnClickListener(this)

    }
    private  fun setupActionBar(){
        setSupportActionBar(mBinding.toolbarAddDishActivity)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        mBinding.toolbarAddDishActivity.setNavigationOnClickListener{
            onBackPressed()
        }
    }

    override fun onClick(v: View?) {


       if (v != null){
            when(v.id){
                R.id.iv_add_dish_image ->{
                    customimageSelectionDialog()
                    //Toast.makeText(this,"You have clicked the ImageView",Toast.LENGTH_SHORT).show()
                    return
                }
            }
        }
    }

    private fun customimageSelectionDialog(){
        val dialog=Dialog(this)
        val binding:DialogCustomImageSelectionBinding= DialogCustomImageSelectionBinding.inflate(layoutInflater)
        dialog.setContentView(binding.root)

        binding.tvCamera.setOnClickListener{
            Toast.makeText(this,"You have clicked the camera",Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        binding.tvGallery.setOnClickListener{
            Toast.makeText(this,"You have clicked the gallery",Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }

        dialog.show()

    }
}