package com.raywenderlich.shopapiloginscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toDrawable
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import com.raywenderlich.shopapiloginscreen.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    private val viewModel:AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.signUpTxt.putDifferentColorStrings(
            arrayOf("New user? ", " Sign up ", "here"),
            arrayOf(R.color.black,R.color.purple_500,R.color.black))
            signIn()
            editTextCatcher()

        




    }

    private fun isEmailValid(email:String):Boolean{
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun editTextCatcher(){
        binding.apply {
            emailAdreess.isEndIconVisible = false
            textInputLayout.isEndIconVisible = false
        }

        binding.emailAdreesTxt.doOnTextChanged { text, start, before, count ->


                binding.emailAdreess.isEndIconVisible = isEmailValid(text.toString())

        }

        binding.paswordTxt.doOnTextChanged { text, start, before, count ->

                binding.textInputLayout.isEndIconVisible = text.let { it.toString().length >= 6 }

        }

    }

    private fun signIn(){
        binding.signInbtn.setOnClickListener {
            if (checkText()){
                viewModel.login(binding.emailAdreesTxt.text.toString(),binding.paswordTxt.text.toString())
            }else{
                Toast.makeText(this, "fill all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun checkText():Boolean{
        return !binding.emailAdreesTxt.text.isNullOrBlank() && !binding.paswordTxt.text.isNullOrBlank()
    }














    private fun TextView.putDifferentColorStrings(stringArr: Array<String>, colorArr: Array<Int>){
        val spannable = SpannableString(stringArr.joinToString(""))

        var startIndex = 0
        for (i in stringArr.indices) {
            spannable.setSpan(
                ForegroundColorSpan(ContextCompat.getColor(context, colorArr[i])),
                startIndex, startIndex + stringArr[i].length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            startIndex += stringArr[i].length
        }
        text = spannable

    }


}