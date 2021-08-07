package com.danielalaye.uservip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.danielalaye.uservip.UserVipApplication.Companion.prefs

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        initUI()
    }

    fun initUI(){
        var btnCerrar: Button = findViewById(R.id.btnCerrar)
        var tvName: TextView = findViewById(R.id.tvName)

        btnCerrar.setOnClickListener {
            prefs.wipe()
            onBackPressed()
        }

        val userName = prefs.getName()

        tvName.text = "Bienvenido $userName"

        if (prefs.getVIP()){
            var lyContainer: LinearLayout = findViewById(R.id.lyContainer)
            lyContainer.setBackgroundColor(ContextCompat.getColor(this,R.color.vip_yellow))

        }
    }
}