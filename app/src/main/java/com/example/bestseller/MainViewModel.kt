package com.example.bestseller

import android.app.Application
import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bestseller.data.Repository
import com.example.bestseller.data.model.PagerArticle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class MainViewModel(application: Application): AndroidViewModel(application) {

    private val list = Repository()

    private val _pagerArticle = MutableLiveData<List<PagerArticle>>()
    val pagerArticle: LiveData<List<PagerArticle>>
        get() = _pagerArticle

    init {
        _pagerArticle.value = list.loadArticle()
    }
    //connect with FirebaseAuth
    private val firebaseAuth = FirebaseAuth.getInstance()

    private val _currentUser = MutableLiveData<FirebaseUser?>(firebaseAuth.currentUser)
    val currentUser: LiveData<FirebaseUser?>
        get() = _currentUser

    private val _toast = MutableLiveData<String?>()
    val toast: LiveData<String?>
        get() = _toast

    fun signUp(email: String, password: String) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    login(email, password)
                } else {
                    Log.e(TAG, "SignUp failed: ${it.exception?.message}")
                    _toast.value = it.exception?.message
                    _toast.value = null
                }
            }
    }

    fun login(email: String, password: String) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    _currentUser.value = firebaseAuth.currentUser
                } else {
                    Log.e(TAG,"Login failed: ${it.exception?.message}")
                    _toast.value = it.exception?.message
                    _toast.value = null
                }
            }
    }

    fun logOut() {
        firebaseAuth.signOut()
        _currentUser.value = firebaseAuth.currentUser
    }

}