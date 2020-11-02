package com.developersbreach.firestoreandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val sports: Sports? = intent.getParcelableExtra("SPORTS_DETAIL_DATA")
        findViewById<TextView>(R.id.sports_title_text).text = sports?.title
        findViewById<TextView>(R.id.sports_originated_text).text = sports?.originated
    }
}