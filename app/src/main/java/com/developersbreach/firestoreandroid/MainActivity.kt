package com.developersbreach.firestoreandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter.StateRestorationPolicy
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query

class MainActivity : AppCompatActivity(), SportsAdapter.SportsAdapterListener {

    private lateinit var adapter: SportsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val query: Query = FirebaseFirestore.getInstance().collection("sports")

        val recyclerView: RecyclerView = findViewById(R.id.sports_list)
        adapter = SportsAdapter(query, this)
        recyclerView.adapter = adapter
        adapter.stateRestorationPolicy = StateRestorationPolicy.PREVENT_WHEN_EMPTY
    }

    override fun onStart() {
        super.onStart()
        adapter.startListening()
    }

    override fun onStop() {
        super.onStop()
        adapter.startListening()
    }

    override fun onSportSelected(sports: Sports?) {
        val intent = Intent(applicationContext, DetailActivity::class.java)
        intent.putExtra("SPORTS_DETAIL_DATA", sports)
        startActivity(intent)
    }
}