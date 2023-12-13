package com.ebookfrenzy.contactsproject

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*

class ContactRepository(application: Application) {
    private var contactsDao: ContactsDao?
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    init {
        // Get the ContactRoomDatabase instance and the ContactsDao
        val db: ContactRoomDatabase? = ContactRoomDatabase.getDatabase(application)
        contactsDao = db?.contactDao()
    }

    // Inserts new contact
    fun insertContact(newContact: Contacts) {
        coroutineScope.launch {
            contactsDao?.insertContact(newContact)
        }
    }

    // Deletes contact from database
    fun deleteContact(id: Int) {
        coroutineScope.launch {
            contactsDao?.deleteContacts(id)
        }
    }

    // Finds contacts
    fun findContacts(name: String): LiveData<List<Contacts>> {
        return contactsDao?.findContacts(name) ?: MutableLiveData(emptyList())
    }

    // Retrieves all contacts from database
    fun getAllContacts(): LiveData<List<Contacts>> {
        return contactsDao?.getAllContacts() ?: MutableLiveData(emptyList())
    }

    // Retrieves all contacts from database in ascending order
    fun getAllContactsAsc(): LiveData<List<Contacts>> {
        return contactsDao?.getAllContactsAsc() ?: MutableLiveData(emptyList())
    }

    // Retrieves all contacts from database in descending order
    fun getAllContactsDesc(): LiveData<List<Contacts>> {
        return contactsDao?.getAllContactsDesc() ?: MutableLiveData(emptyList())
    }
}