package com.danielalaye.uservip

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import com.danielalaye.uservip.UserVipApplication.Companion.prefs
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUI()
        checkUserValues()
    }

    fun checkUserValues(){
        if (prefs.getName().isNotEmpty()){
            goToDetail()
        }
    }

    fun initUI(){
        var btnContinuar: Button = findViewById(R.id.btnContinuar)
        btnContinuar.setOnClickListener { accessToDetail() }

    }

    fun accessToDetail(){

        var etNombre: EditText = findViewById(R.id.etName)
        var cbVip: CheckBox = findViewById(R.id.cbVip)

        //Comprobamos si se escribio un nombre
        if (etNombre.text.toString().isNotEmpty()){
            prefs.saveName(etNombre.text.toString())
            prefs.saveVIP(cbVip.isChecked)
            goToDetail()
        }
    }

    fun goToDetail(){
        startActivity(Intent(this, ResultActivity::class.java))
    }
}