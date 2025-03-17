package com.criterionTech.vitalio.ui.main.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.criterionTech.vitalio.R
import com.criterionTech.vitalio.ui.main.adapter.MainAdapter.DataViewHolder
import com.criterionTech.vitalio.data.modal.User
import androidx.recyclerview.widget.RecyclerView
import com.criterionTech.vitalio.databinding.ActivityMainBinding
import com.criterionTech.vitalio.databinding.ItemLayoutBinding

class MainAdapter(private val users: ArrayList<User>) : RecyclerView.Adapter<DataViewHolder>() {

    private var _binding: ItemLayoutBinding? = null
    private val binding get() = _binding!!
    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        class UserHolder(val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
            fun bind(get: Data) {
                binding.textViewUserName.text = get.email
                binding.textViewUserEmail.text = get.name

            }
        }
        fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
            binding = ItemLayoutBinding
                .inflate(LayoutInflater.from(parent.context), parent, true)
            return UserHolder(binding)
        }

        fun bind(user: User) {
            itemView.apply {
                binding.textViewUserName = user.name
                textViewUserEmail.text = user.email
                Glide.with(imageViewAvatar.context)
                    .load(user.avatar)
                    .into(binding.imageViewAvatar)
            }
        }
    }

    fun onDestroyView() {
//        super.ononDestroyView()
        _binding = null
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false))

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(users[position])
    }

    fun addUsers(users: List<User>) {
        this.users.apply {
            clear()
            addAll(users)
        }

    }
}