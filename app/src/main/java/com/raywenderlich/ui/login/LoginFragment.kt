package com.raywenderlich.ui.login

import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import com.raywenderlich.base.BaseFragment
import com.raywenderlich.extensions.putDifferentColorStrings
import com.raywenderlich.shopapiloginscreen.R
import com.raywenderlich.shopapiloginscreen.databinding.LoginFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<LoginFragmentBinding>(LoginFragmentBinding::inflate) {




    private val viewModel:LoginViewModel by viewModels()


    override fun start(inflater: LayoutInflater, viewGroup: ViewGroup?) {


        binding?.signUpTxt?.putDifferentColorStrings(
            arrayOf("New user? ", " Sign up ", "here"),
            arrayOf(R.color.black,R.color.purple_500,R.color.black))
        signIn()
        editTextCatcher()

    }



    private fun isEmailValid(email:String):Boolean{
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }


    private fun editTextCatcher(){
        binding?.apply {
            emailAdreess.isEndIconVisible = false
            textInputLayout.isEndIconVisible = false
        }

        binding?.emailAdreesTxt?.doOnTextChanged { text, start, before, count ->


            binding?.emailAdreess?.isEndIconVisible = isEmailValid(text.toString())

        }

        binding?.paswordTxt?.doOnTextChanged { text, start, before, count ->

            binding?.textInputLayout?.isEndIconVisible = text.let { it.toString().length >= 6 }

        }

    }


    private fun signIn(){
        binding?.signInbtn?.setOnClickListener {
            if (checkText()){
                viewModel.login(binding?.emailAdreesTxt?.text.toString(),binding?.paswordTxt?.text.toString())
            }else{
                TODO()
            }
        }
    }


    private fun checkText():Boolean{
        return !binding?.emailAdreesTxt?.text.isNullOrBlank() && !binding?.paswordTxt?.text.isNullOrBlank()
    }






}