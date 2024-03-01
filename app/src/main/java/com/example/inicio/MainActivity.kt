package com.example.inicio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class MainActivity : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var authStateListener: FirebaseAuth.AuthStateListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btniniciar: Button = findViewById(R.id.btniniciar)
        val txtemail: TextView = findViewById(R.id.edtEmail)
        val txtpassword: TextView = findViewById(R.id.edtPassword)
        val btncrearcuenta: TextView= findViewById(R.id.btncrearcuenta)

        firebaseAuth= Firebase.auth
        btniniciar.setOnClickListener()
    {
       signIn(txtemail.text.toString(),txtpassword.text.toString())
        }
     btncrearcuenta.setOnClickListener()
     {
         val i = Intent(this,CrearCuentaActivity::class.java)
         startActivity(i)
     }
    }
    private fun signIn(email:String, password: String)
    {
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this){task ->
            if (task.isSuccessful){
                val user = firebaseAuth.currentUser
                Toast.makeText(baseContext,"operacion exitosa", Toast.LENGTH_SHORT).show()
                //Aqui iremos a la segunda activity
                val i = Intent(this, MainActivity2::class.java)
                startActivity(i)
            }

            else
            {
                Toast.makeText(baseContext,"Error de Email y/o Contraseña",Toast.LENGTH_SHORT).show()
            }
        }
    }
}