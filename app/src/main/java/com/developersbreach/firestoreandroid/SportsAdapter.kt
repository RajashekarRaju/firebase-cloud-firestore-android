package com.developersbreach.firestoreandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.Query


class SportsAdapter(
    query: Query,
    private val listener: SportsAdapterListener
) : FirestoreAdapter<SportsAdapter.SportsViewHolder>(query) {

    class SportsViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        private val cardView: MaterialCardView = itemView.findViewById(R.id.item_sport_card)
        private val title: TextView = itemView.findViewById(R.id.item_sport_title_text_view)
        private val originated: TextView = itemView.findViewById(R.id.item_sport_originated_text_view)

        fun bind(snapshot: DocumentSnapshot, listener: SportsAdapterListener) {
            val sports: Sports? = snapshot.toObject(Sports::class.java)
            title.text = sports?.title
            originated.text = sports?.originated

            cardView.setOnClickListener {
                listener.onSportSelected(sports)
            }
        }
    }

    interface SportsAdapterListener {
        fun onSportSelected(sports: Sports?)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportsViewHolder {
        return SportsViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_sport, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: SportsViewHolder, position: Int) {
        getSnapshot(position)?.let { snapshot ->
            holder.bind(snapshot, listener)
        }
    }
}