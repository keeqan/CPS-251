package com.ebookfrenzy.contactsproject

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts")
class Contacts {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "contactsId")
    var id: Int = 0

    @ColumnInfo(name = "contactsName")
    var contactsName: String? = null

    @ColumnInfo(name = "quantity")
    var quantity: Int = 0

    @ColumnInfo(name = "contactNumber")
    var contactNumber: String? = null

    constructor()

    constructor(contactsName: String, quantity: Int, contactNumber: String) {
        this.contactsName = contactsName
        this.quantity = quantity
        this.contactNumber = contactNumber
    }

    constructor(contactsName: String, contactNumber: String) {
        this.contactsName = contactsName
        this.contactNumber = contactNumber
        this.quantity = 0 // Default value
    }
}