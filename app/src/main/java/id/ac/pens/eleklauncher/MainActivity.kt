package id.ac.pens.eleklauncher

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnApp : Button = findViewById(R.id.btn_app);
        btnApp.setOnClickListener(View.OnClickListener {
            val intent = Intent(applicationContext, AppListActivity::class.java)
            startActivity(intent)
        })
    }
}