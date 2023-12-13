package com.example.planandgo.ui.customplan.customtour

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import com.example.planandgo.MainActivity
import com.example.planandgo.R
import com.example.planandgo.databinding.ActivityCustomTourBinding
import com.example.planandgo.ui.customplan.customhotel.CustomHotelActivity
import com.example.planandgo.ui.responseplan.PlanSuggestionActivity

class CustomTourActivity : AppCompatActivity() {

    private lateinit var binding : ActivityCustomTourBinding

    private lateinit var builder : AlertDialog.Builder
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomTourBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Pilih Destinasi Wisata"

        binding.fbCustomTour.setOnClickListener{
            val intent = Intent(this, CustomHotelActivity::class.java)
            startActivity(intent)
            finish()
        }

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                builder = AlertDialog.Builder(this@CustomTourActivity)
                builder.setTitle("Seluruh Hasil Custome Akan Dihapus!")
                    .setMessage("Apakah anda ingin membatalkan custom?")
                    .setCancelable(true)
                    .setPositiveButton("Iya"){ dialogInterface, it ->
                        val intent = Intent(this@CustomTourActivity, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                    .setNegativeButton("Tidak"){ dialogInterface, it ->
                        dialogInterface.cancel()
                    }
                builder.show()
            }

        })

    }

}