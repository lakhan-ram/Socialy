package com.example.socialy.model.repositories

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.socialy.model.entities.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase

class AuthRepository(private val context: Context) {
    private val auth = FirebaseAuth.getInstance()
    private val databaseReference = FirebaseDatabase.getInstance().getReference("users")
    private val authList = MutableLiveData<FirebaseUser>()

    fun signUp(name: String, email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { taskSignUp ->
                if (taskSignUp.isSuccessful) {
                    val id = auth.currentUser!!.uid
                    val username = name.split(" ").first() + System.currentTimeMillis().toString().substring(6)
                    val user = User(id, name, username, email)
                    databaseReference.child(auth.currentUser!!.uid).setValue(user)
                        .addOnCompleteListener {
                            if (it.isSuccessful) {
                                authList.postValue(auth.currentUser!!)
                            } else {
                                auth.currentUser!!.delete()
                                Toast.makeText(
                                    context,
                                    "Error: ${it.exception?.localizedMessage}",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                } else {
                    Toast.makeText(
                        context,
                        "Error: ${taskSignUp.exception?.localizedMessage}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }
}