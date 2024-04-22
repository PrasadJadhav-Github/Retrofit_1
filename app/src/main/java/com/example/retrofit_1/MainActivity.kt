package com.example.retrofit_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.retrofit_1.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inflate the layout using ViewBinding
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        // Get an instance of the UsersService class
        val usersService = UsersService.getInstance()
        // Log the class name of the UsersService instance
        Log.e("tag", "Class which implements UsersService: ${usersService::class.java.name}")

        // Set onClickListener for the button to fetch user data
        activityMainBinding.btnFetchUserData.setOnClickListener {
            // Use CoroutineScope to launch a coroutine in IO context
            CoroutineScope(Dispatchers.IO).launch {
                // Fetch user data using the fetchUsers method of UsersService
                val userModel = usersService.fetchUsers(activityMainBinding.edtUserId.text.toString().toInt())

                // Switch to Main thread to update UI elements
                withContext(Dispatchers.Main) {
                    // Set the email text view with user's email
                    activityMainBinding.txtEmail.text = userModel.data.email
                    // Set the username text view with user's first and last name
                    activityMainBinding.txtUsername.text = "${userModel.data.firstName} ${userModel.data.lastName}"
                    // Load the user's avatar image into the ImageView using Glide library
                    Glide.with(this@MainActivity)
                        .load(userModel.data.avatar)
                        .into(activityMainBinding.imgUser)
                }
            }
        }
    }
}
