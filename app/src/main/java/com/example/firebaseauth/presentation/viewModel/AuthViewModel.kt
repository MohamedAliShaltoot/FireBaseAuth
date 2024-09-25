package com.example.firebaseauth.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import java.lang.Exception

class AuthViewModel:ViewModel() {
    val firebaseAuth=FirebaseAuth.getInstance()

    fun login(email:String,password:String,onSucess:()-> Unit,onFailure:(String)-> Unit){
        try {
            firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener {
                if(it.isSuccessful){
onSucess()
                }else{
                    onFailure(it.exception?.message?:"unKnown Person")
                   //println(it.exception?.message)
                }
            }.addOnFailureListener {
                onFailure(it.message?:"unKnown Person")


            }


        }catch (e:Exception){
            onFailure(e.message?:"unKnown Person")


        }
    }
    fun register(email:String,password:String,onSucess:()-> Unit,onFailure:(String)-> Unit){
        try {
            firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener {
                if(it.isSuccessful){

                    onSucess()
                }else{
                    onFailure(it.exception?.message?:"unKnown Person")
                    //println(it.exception?.message)
                }
            }.addOnFailureListener {
                onFailure(it.message?:"unKnown Person")
            }


        }catch (e:Exception){
            onFailure(e.message?:"unKnown Person")
        }
    }
}