package com.ebookfrenzy.contactsproject

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ebookfrenzy.contactsproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var adapter: ContactsListAdapter? = null
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup methods for the activity
        listenerSetup()
        observerSetup()
        recyclerSetup()
    }

    // Clears the contact name and number
    private fun clearFields() {
        binding.enterContactName.setText("")
        binding.enterContactNumber.setText("")
    }

    // Sets up listeners buttons
    private fun listenerSetup() {
        binding.addButton.setOnClickListener {
            val name = binding.enterContactName.text.toString()
            val number = binding.enterContactNumber.text.toString()
            // Check if empty
            if (name != "" && number != "") {
                val contact = Contacts(name, number) // Create new contact
                viewModel.insertContacts(contact) // Insert contact
                clearFields() // Call Clear Method
            }
        }

        // Find button
        binding.findButton.setOnClickListener {
            val searchQuery = binding.enterContactName.text.toString()
            if (searchQuery.isNotEmpty()) {
                viewModel.findContacts(searchQuery).observe(this) { contacts ->
                    adapter?.setContactsList(contacts) // Update adapter data
                }
            }
        }

        // Sorting in ascending order
        binding.ascButton.setOnClickListener {
            viewModel.getAllContactsAsc().observe(this) { contacts ->
                adapter?.setContactsList(contacts) // Update adapter data
            }
        }

        // Sorting in descending order
        binding.descButton.setOnClickListener {
            viewModel.getAllContactsDesc().observe(this) { contacts ->
                adapter?.setContactsList(contacts) // Update adapter data
            }
        }
    }

    // Observes LiveData and updates
    private fun observerSetup() {
        viewModel.allContacts.observe(this) { contacts ->
            contacts?.let { adapter?.setContactsList(it) } // Update adapter data list
        }
    }

    // Sets up the RecyclerView
    private fun recyclerSetup() {
        adapter = ContactsListAdapter(R.layout.card_layout, viewModel) // Initialize
        binding.contactRecycler.layoutManager = LinearLayoutManager(this) // Set layout manager
        binding.contactRecycler.adapter = adapter // Set adapter
    }
}