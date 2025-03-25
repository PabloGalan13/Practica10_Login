package itson.com.edu.practica10_galanpablo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val email = intent.extras!!.getString("user")
        val user: TextView = findViewById(R.id.tvUser)
        val button: Button = findViewById(R.id.btnLogout)
        user.text= "Hola "+ email+"!!"
        button.setOnClickListener({
            Firebase.auth.signOut()
            val intent = Intent(this, LoginActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        })
    }
}