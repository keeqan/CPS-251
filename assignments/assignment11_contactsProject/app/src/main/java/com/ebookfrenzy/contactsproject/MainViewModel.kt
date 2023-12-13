package com.ebookfrenzy.contactsproject

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: ContactRepository = ContactRepository(application)

    val allContacts: LiveData<List<Contacts>> = repository.getAllContacts()

    //function to add contact
    fun insertContacts(contact: Contacts) {
        repository.insertContact(contact)
    }
    //function to delete contact
    fun deleteContacts(id: Int) {
        repository.deleteContact(id)
    }
    //function to find contact
    fun findContacts(name: String): LiveData<List<Contacts>> {
        return repository.findContacts(name)
    }
    //function to ascend contact
    fun getAllContactsAsc(): LiveData<List<Contacts>> {
        return repository.getAllContactsAsc()
    }
    //function to descend contact
    fun getAllContactsDesc(): LiveData<List<Contacts>> {
        return repository.getAllContactsDesc()
    }
}