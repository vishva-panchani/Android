//package com.example.mycontactapp
////
//import android.annotation.SuppressLint
//import android.content.Intent
//import android.content.pm.PackageManager
//import android.net.Uri
//import android.os.Bundle
//import android.provider.CallLog
//import android.provider.ContactsContract
//import android.widget.ListView
//import android.widget.SearchView
//import android.widget.SimpleCursorAdapter
//import androidx.activity.enableEdgeToEdge
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.app.ActivityCompat
//import androidx.core.content.ContextCompat
//import androidx.core.view.ViewCompat
//import androidx.core.view.WindowInsetsCompat
//import com.google.android.material.floatingactionbutton.FloatingActionButton
//
//class MainActivity : AppCompatActivity() {
//    val filteredContactsList = mutableListOf<String>()
//    val phoneNumbers = mutableMapOf<String, String>()
//    private val REQUEST_CODE_CALL_PERMISSION = 117
//
//
//    var cols = arrayOf(
//        ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
//        ContactsContract.CommonDataKinds.Phone.NUMBER,
//        ContactsContract.CommonDataKinds.Phone._ID
//    )
//
//
//    @SuppressLint("MissingInflatedId")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)
//
//        if (ActivityCompat.checkSelfPermission(
//                this,
//                android.Manifest.permission.READ_CONTACTS
//            ) != PackageManager.PERMISSION_GRANTED
//        ) {
//            ActivityCompat.requestPermissions(
//                this,
//                arrayOf(android.Manifest.permission.READ_CONTACTS),
//                117
//            )
//        } else {
//            readCalllog()
//        }
//
//        //add contact
//        val addContact: FloatingActionButton = findViewById(R.id.floatingActionButton4)
//        addContact.setOnClickListener {
//            val intent = Intent(Intent.ACTION_INSERT).apply {
//                type = ContactsContract.Contacts.CONTENT_TYPE
//            }
//            startActivity(intent)
//        }
//
//    }
//
//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<out String>,
//        grantResults: IntArray
//    ) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        if (requestCode == 117 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//            readCalllog()
//        }
//    }
//
//    @SuppressLint("Range")
//    private fun readCalllog() {
//        var rs = contentResolver.query(
//            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
//            cols,
//            null,
//            null,
//            null
//        )
//        var adapter = SimpleCursorAdapter(
//            applicationContext, android.R.layout.simple_list_item_2, rs, cols,
//            intArrayOf(android.R.id.text1, android.R.id.text2)
//        )
//        var lv: ListView = findViewById(R.id.listview)
//        lv.adapter = adapter
//
//        //call
//        lv.setOnItemClickListener { parent, view, position, id ->
//            val cursor = parent.getItemAtPosition(position) as android.database.Cursor
//            val phoneNumber =
//                cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
//
//            val i = Intent(Intent.ACTION_CALL).apply {
//                data = Uri.parse("tel:$phoneNumber")
//            }
//            if (ActivityCompat.checkSelfPermission(
//                    this,
//                    android.Manifest.permission.CALL_PHONE
//                ) == PackageManager.PERMISSION_GRANTED
//            ) {
//                startActivity(i)
//            } else {
//                ActivityCompat.requestPermissions(
//                    this,
//                    arrayOf(android.Manifest.permission.CALL_PHONE),
//                    117
//                )
//            }
//
//
//            //search
//            lv.setOnItemClickListener { parent, _, position, _ ->
//                val cursor = parent.getItemAtPosition(position) as android.database.Cursor
//                val phoneNumber =
//                    cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
//
//                makeCall(phoneNumber)
//            }
//            val searchView: SearchView = findViewById(R.id.searchview)
//            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//                override fun onQueryTextSubmit(query: String?): Boolean {
//                    filterContacts(query)
//                    return false
//                }
//
//                override fun onQueryTextChange(newText: String?): Boolean {
//                    filterContacts(newText)
//                    return true
//                }
//            })
//        }
//
//
//    }
//
//    private fun makeCall(phoneNumber: String?) {
//        val intent = Intent(Intent.ACTION_CALL).apply {
//            data = Uri.parse("tel:$phoneNumber")
//        }
//        if (ContextCompat.checkSelfPermission(
//                this,
//                android.Manifest.permission.CALL_PHONE
//            ) == PackageManager.PERMISSION_GRANTED
//        ) {
//            startActivity(intent)
//        } else {
//            ActivityCompat.requestPermissions(
//                this,
//                arrayOf(android.Manifest.permission.CALL_PHONE),
//                REQUEST_CODE_CALL_PERMISSION
//            )
//        }
//    }
//
//    @SuppressLint("Range")
//    private fun filterContacts(query: String?) {
//        val filterCursor = contentResolver.query(
//            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
//            cols,
//            "${ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME} LIKE ?",
//            arrayOf("%$query%"),
//            null
//        )
//
//    }
//}
//
//
//

//
//package com.example.mycontactapp
////
//import android.annotation.SuppressLint
//import android.content.Intent
//import android.content.pm.PackageManager
//import android.net.Uri
//import android.os.Bundle
//import android.provider.ContactsContract
//import android.widget.ListView
//import android.widget.SearchView
//import android.widget.SimpleCursorAdapter
//import androidx.activity.enableEdgeToEdge
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.app.ActivityCompat
//import androidx.core.content.ContextCompat
//import com.example.mycontactapp.R
//import com.google.android.material.floatingactionbutton.FloatingActionButton
//
//class MainActivity : AppCompatActivity() {
//    private val REQUEST_CODE_CALL_PERMISSION = 117
//
//    private val cols = arrayOf(
//        ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
//        ContactsContract.CommonDataKinds.Phone.NUMBER,
//        ContactsContract.CommonDataKinds.Phone._ID
//    )
//
//    private lateinit var adapter: SimpleCursorAdapter
//
//    @SuppressLint("MissingInflatedId")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)
//
//        // Request permissions if not granted
//        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.READ_CONTACTS), REQUEST_CODE_CALL_PERMISSION)
//        } else {
//            setupListView()
//        }
//
//        //add contact
//        val addContact: FloatingActionButton = findViewById(R.id.floatingActionButton4)
//        addContact.setOnClickListener {
//            val intent = Intent(Intent.ACTION_INSERT).apply {
//                type = ContactsContract.Contacts.CONTENT_TYPE
//            }
//            startActivity(intent)
//        }
//    }
//
//    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        if (requestCode == REQUEST_CODE_CALL_PERMISSION && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//            setupListView()
//        }
//    }
//
//    @SuppressLint("Range")
//    private fun setupListView() {
////        val cursor = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, cols, null, null, null)
////        adapter = SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, cursor, cols, intArrayOf(android.R.id.text1, android.R.id.text2), 0)
//
////        val listView: ListView = findViewById(R.id.listview)
////        listView.adapter = adapter
//        val rs = contentResolver.query(
//            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
//            cols,
//            null,
//            null,
//            null
//        )
//        val adapter = SimpleCursorAdapter(
//            applicationContext, android.R.layout.simple_list_item_2, rs, cols,
//            intArrayOf(android.R.id.text1, android.R.id.text2)
//       )
//        val listView: ListView = findViewById(R.id.listview)
//        listView.adapter = adapter
//
//
//
//            listView.setOnItemClickListener { parent, _, position, _ ->
//            val cursor = parent.getItemAtPosition(position) as android.database.Cursor
//            val phoneNumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
//            makeCall(phoneNumber)
//        }
//
//        //search
//        val searchView: SearchView = findViewById(R.id.searchview)
//        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                filterContacts(query)
//                return false
//            }
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//                filterContacts(newText)
//                return true
//            }
//        })
//    }
//
//    private fun makeCall(phoneNumber: String) {
//        val intent = Intent(Intent.ACTION_CALL).apply {
//            data = Uri.parse("tel:$phoneNumber")
//        }
//        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
//            startActivity(intent)
//        } else {
//            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE), REQUEST_CODE_CALL_PERMISSION)
//        }
//    }
//
//    @SuppressLint("Range")
//    private fun filterContacts(query: String?) {
//        val filterCursor = contentResolver.query(
//            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
//            cols,
//            "${ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME} LIKE ?",
//            arrayOf("%$query%"),
//            null
//        )
//        adapter.changeCursor(filterCursor)
//    }
//}


package com.example.mycontactapp

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.SearchView
import android.widget.SimpleCursorAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.mycontactapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() {
    lateinit var listView:ListView
    private val REQUEST_CODE_READ_CONTACTS_PERMISSION = 117
    private val REQUEST_CODE_CALL_PHONE_PERMISSION = 118

    private val cols = arrayOf(
        ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
        ContactsContract.CommonDataKinds.Phone.NUMBER,
        ContactsContract.CommonDataKinds.Phone._ID
    )

    private lateinit var adapter: SimpleCursorAdapter

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Request permissions if not granted
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.READ_CONTACTS), REQUEST_CODE_READ_CONTACTS_PERMISSION)
        } else {
            setupListView()
        }

        // Add contact
        val addContact: FloatingActionButton = findViewById(R.id.floatingActionButton4)
        addContact.setOnClickListener {
            val intent = Intent(Intent.ACTION_INSERT).apply {
                type = ContactsContract.Contacts.CONTENT_TYPE
            }
            startActivity(intent)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 117 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            setupListView()
        }
    }

    @SuppressLint("Range")
    private fun setupListView() {

        val cursor = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, cols, null, null, null)
        cursor?.let {
            adapter = SimpleCursorAdapter(
                this, android.R.layout.simple_list_item_2, it, cols,
                intArrayOf(android.R.id.text1, android.R.id.text2), 0
            )
             listView = findViewById(R.id.listview)
            registerForContextMenu(listView)

            listView.adapter = adapter
            listView.setOnItemClickListener { parent, _, position, _ ->
                val cursor = parent.getItemAtPosition(position) as android.database.Cursor
                val phoneNumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
                makeCall(phoneNumber)
            }
            // Search
            val searchView: SearchView = findViewById(R.id.searchview)
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    filterContacts(query)
                    return false
                }
                override fun onQueryTextChange(newText: String?): Boolean {
                    filterContacts(newText)
                    return true
                }
            })
        }
    }
//context menu
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        menu?.add(101,1111,1,"Call")
        menu?.add(102,1112,2,"Messages")
        menu?.add(103,1113,3,"WhatsApp")
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    @SuppressLint("Range")
    override fun onContextItemSelected(item: MenuItem): Boolean {
        val info=item.menuInfo as AdapterView.AdapterContextMenuInfo
        val cursor=adapter.getItem(info.position) as Cursor
        val phoneNumber=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))

         return when(item.itemId){
            1111->{
                makeCall(phoneNumber)
                true
            }
            1112->{
                sendMessage(phoneNumber)
                true
            }
            1113->{
                openWhatsapp(phoneNumber)
                true
            }
            else->super.onContextItemSelected(item)
        }
        return super.onContextItemSelected(item)
    }

    private fun sendMessage(phoneNumber: String?) {
        val intent=Intent(Intent.ACTION_VIEW).apply {
            data=Uri.parse("smsto:$phoneNumber")
        }
        startActivity(intent)

    }


//    private fun openWhatsapp(phoneNumber: String?) {
//                val intent=Intent(Intent.ACTION_VIEW).apply {
//            data=Uri.parse("whatsapp://send?phone=$phoneNumber")
////            Toast.makeText(applicationContext, data.toString(), Toast.LENGTH_SHORT).show()
//
//        }
//        if (intent.resolveActivity(packageManager)!=null){
//            startActivity(intent)
//        }else{
//            Toast.makeText(applicationContext, "not installed", Toast.LENGTH_SHORT).show()
//        }
//    }
private fun openWhatsapp(phoneNumber: String?) {
    val intent = Intent(Intent.ACTION_VIEW).apply {
        data = Uri.parse("https://api.whatsapp.com/send?phone=$phoneNumber")
    }
    if (intent.resolveActivity(packageManager) != null) {
        startActivity(intent)
    } else {
        Toast.makeText(applicationContext, "WhatsApp not installed", Toast.LENGTH_SHORT).show()
    }
}


    private fun makeCall(phoneNumber: String) {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            val intent = Intent(Intent.ACTION_CALL).apply {
                data = Uri.parse("tel:$phoneNumber")
            }
            startActivity(intent)
        } else {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE), REQUEST_CODE_CALL_PHONE_PERMISSION)
        }
    }



    @SuppressLint("Range")
    private fun filterContacts(query: String?) {
        val filterCursor = contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            cols,
            "${ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME} LIKE ?",
            arrayOf("%${query ?: ""}%"),
            null
        )
        adapter.changeCursor(filterCursor)
    }
}







