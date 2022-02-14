package uz.pdp.contactapp.dp

import uz.pdp.contactapp.model.Contact

interface DatabaseServise {

    fun addContact(contact: Contact)

    fun getAllContacts():ArrayList<Contact>
}