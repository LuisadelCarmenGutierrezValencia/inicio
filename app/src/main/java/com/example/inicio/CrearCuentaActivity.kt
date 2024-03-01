package com.example.inicio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class CrearCuentaActivity : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_cuenta)
        val txtnombre_nuevo: TextView = findViewById(R.id.edtNombre)
        val textemail_nuevo: TextView = findViewById(R.id.edtEmailNuevo)
        val textpassword1: TextView = findViewById(R.id.edtPassword1)
        val textpassword2: TextView = findViewById(R.id.edtpassword2)
        val btnCrear : Button = findViewById(R.id.btnCreaarCuenta)
        btnCrear.setOnClickListener()
        {
         val pass1 = textpassword1.text.toString()
            val pass2= textpassword2.text.toString()
            if (pass1.equals(pass2))
            {
             createAccount(textemail_nuevo.text.toString(),textpassword1.text.toString())
        }
            else
            {
             Toast.makeText(baseContext, "Error: las contraseñas no coinciden",Toast.LENGTH_SHORT).show()
             textpassword1.requestFocus()
            }

            }
        firebaseAuth= Firebase.auth
    }
        private fun  createAccount(email: String, password:String)
        {
            firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this){task ->
                if (task.isSuccessful)
                {
                    Toast.makeText(baseContext,"Cuenta creada",Toast.LENGTH_SHORT).show()

                    }
                else
                {
                 Toast.makeText(baseContext, "Algo salio mal, Error:" + task.exception, Toast.LENGTH_SHORT).show()
                }
            }
        }
}
