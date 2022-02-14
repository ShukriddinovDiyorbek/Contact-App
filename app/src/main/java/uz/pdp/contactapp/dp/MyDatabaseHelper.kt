package uz.pdp.contactapp.dp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import uz.pdp.contactapp.ChangeFragment
import uz.pdp.contactapp.model.Contact
import uz.pdp.contactapp.utils.Constant

class MyDatabaseHelper(context: Context) : SQLiteOpenHelper(context,Constant.DB_NAME,null,Constant.DB_VERSION),DatabaseServise {
    override fun onCreate(db: SQLiteDatabase?) {
        val query =
            "create table ${Constant.TABLE_NAME} (${Constant.ID} integer not null primary key autoincrement unique, ${Constant.NAME} text not null, ${Constant.PHONE_NUMBER} text not null);"
        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("drop table if exists ${Constant.TABLE_NAME}")
        onCreate(db)
    }

    override fun addContact(contact: Contact) {
        val database = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(Constant.NAME, contact.name)
        contentValues.put(Constant.PHONE_NUMBER, contact.number)
        database.insert(Constant.TABLE_NAME, null,contentValues)
        database.close()
    }

    override fun getAllContacts(): ArrayList<Contact> {
        val contacts = ArrayList<Contact>()
        val query = "select * from ${Constant.TABLE_NAME}"
        val database = this.readableDatabase
        val cursor = database.rawQuery(query,null)
        if(cursor.moveToFirst()){
            do {
                val id = cursor.getInt(0)
                val name = cursor.getString(1)
                val number = cursor.getString(2)

                val contact = Contact(id,name,number)

                contacts.add(contact)
            }while (cursor.moveToNext())
        }
        return contacts
    }
}