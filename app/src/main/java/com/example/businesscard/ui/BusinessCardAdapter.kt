package com.example.businesscard.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.businesscard.data.BusinessCardEntity
import com.example.businesscard.databinding.ItemBusinessCardBinding

class BusinessCardAdapter(
    private val businessCards: List<BusinessCardEntity>,
    private val onUpdatedCard: OnUpdatedCard
) : RecyclerView.Adapter<BusinessCardAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemBusinessCardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        , onUpdatedCard)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val businessCards = businessCards[position]
        holder.bind(businessCards)
    }

    override fun getItemCount(): Int {
        return businessCards.size
    }

    inner class ViewHolder(private val binding: ItemBusinessCardBinding, private val onUpdatedCard: OnUpdatedCard) : RecyclerView.ViewHolder(binding.root) {
        fun bind(cards: BusinessCardEntity) {
            binding.tvName.text = cards.name
            binding.tvPhone.text = cards.phone
            binding.tvEmail.text = cards.email
            binding.tvCompanyName.text = cards.company
            try {
                binding.cardview.setBackgroundColor(Color.parseColor(cards.color))
            } catch (e: Exception) {
                Toast.makeText(
                    itemView.context,
                    "Error Ao Adicionar a cor ao fundo, Certifique de digitar corretamente",
                    Toast.LENGTH_LONG
                ).show()
                cards.color = "#FFFFFFFF"
                binding.cardview.setBackgroundColor(Color.parseColor(cards.color))
                onUpdatedCard.saveCard(cards)
            }
        }
    }

   interface OnUpdatedCard{
        fun saveCard(businessCardEntity: BusinessCardEntity)
    }
}