package mps.com
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent
import android.view.View
import android.content.Context
import android.app.Activity


class MainActivity : AppCompatActivity(){


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            val home = findViewById<Button>(R.id.home)
            home.setOnClickListener {
                val intent = Intent(
                    applicationContext,
                    Main2Activity::class.java
                )
                startActivity(intent)
            }
            //val intent =  Intent(this, Main2Activity::class.java).apply{ println()}
            //startActivity(intent)

        }
    }

