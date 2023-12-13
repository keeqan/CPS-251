package com.ebookfrenzy.contactsproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactsListAdapter(
    private val contactsItemLayout: Int,
    private val viewModel: MainViewModel
) : RecyclerView.Adapter<ContactsListAdapter.ViewHolder>() {

    private var contactsList: List<Contacts>? = null // Hold contacts data

    // ViewHolder hold UI components
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var contactName: TextView = itemView.findViewById(R.id.contactName)
        var contactNumber: TextView = itemView.findViewById(R.id.contactNumber)
        var trashCan: ImageView = itemView.findViewById(R.id.trashCan)
    }

    // Binds data to views
    override fun onBindViewHolder(holder: ViewHolder, listPosition: Int) {
        val contact = contactsList?.get(listPosition) // Get contact
        holder.contactName.text = contact?.contactsName // Set contact name
        holder.contactNumber.text = contact?.contactNumber // Set contact number

        // Set trash can icon and its click listener
        holder.trashCan.setImageResource(R.drawable.trashcan)
        holder.trashCan.setOnClickListener {
            contact?.let { it1 ->
                viewModel.deleteContacts(it1.id) // Delete contact
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(contactsItemLayout, parent, false)
        return ViewHolder(view)
    }

    // Updates list and notifies refresh
    fun setContactsList(contacts: List<Contacts>) {
        contactsList = contacts
        notifyDataSetChanged()
    }

    // Size of the contacts list
    override fun getItemCount(): Int {
        return contactsList?.size ?: 0
    }
}