package com.ebookfrenzy.contactsproject

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ContactsDao {
    @Insert
    fun insertContact(contact: Contacts)

    @Query("SELECT * FROM contacts WHERE contactsName LIKE '%' || :name || '%'")
    fun findContacts(name: String): LiveData<List<Contacts>>

    @Query("DELETE FROM contacts WHERE contactsId = :id")
    fun deleteContacts(id: Int)

    @Query("SELECT * FROM contacts")
    fun getAllContacts(): LiveData<List<Contacts>>

    // Ascending sort
    @Query("SELECT * FROM contacts ORDER BY contactsName ASC")
    fun getAllContactsAsc(): LiveData<List<Contacts>>

    // Descending sort
    @Query("SELECT * FROM contacts ORDER BY contactsName DESC")
    fun getAllContactsDesc(): LiveData<List<Contacts>>
}