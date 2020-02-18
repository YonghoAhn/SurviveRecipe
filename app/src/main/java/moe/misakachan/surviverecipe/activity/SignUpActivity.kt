package moe.misakachan.surviverecipe.activity

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import kotlinx.android.synthetic.main.activity_sign_up.*
import moe.misakachan.surviverecipe.R

class SignUpActivity : AppCompatActivity() {

    private lateinit var firebaseAuth : FirebaseAuth
    val builder = AlertDialog.Builder(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        firebaseAuth = FirebaseAuth.getInstance()
        setContentView(R.layout.activity_sign_up)

        setSupportActionBar(toolbarSignUp)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        btnEmailSignUp.setOnClickListener {
            if(isAvailableToCreateUser())
            {
                firebaseAuth.createUserWithEmailAndPassword(txtEmailAddress.text.toString(), txtPassword.text.toString()).addOnCompleteListener {
                    if(it.isSuccessful)
                    {
                        val profile = UserProfileChangeRequest.Builder().setDisplayName(txtUserName.text.toString()).build()
                        firebaseAuth.currentUser?.updateProfile(profile)?.addOnCompleteListener { task ->
                            if(task.isSuccessful)
                                Toast.makeText(applicationContext,"반갑습니다! ${txtUserName.text.toString()}님!",Toast.LENGTH_SHORT).show()
                            else
                                Toast.makeText(applicationContext,"계정 생성 중에 문제가 생겼지만, 회원가입은 완료되었습니다.",Toast.LENGTH_SHORT).show()
                        }
                        finish()
                    }
                    else
                    {
                        Toast.makeText(applicationContext,"계정 생성 중에 문제가 생겼습니다.",Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    private fun clearError()
    {
        txtLayoutUserName.error = null
        txtLayoutEmailAddress.error = null
        txtLayoutPassword.error = null
        txtLayoutRePassword.error = null
    }

    private fun isAvailableToCreateUser() :Boolean
    {
        var isAvailable : Boolean = true
        clearError()
        if(txtUserName.text.toString().isEmpty())
        {
            txtLayoutUserName.error = "유저명이 비었습니다."
            isAvailable = false
        }
        val emailRegex = Regex("^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$",RegexOption.IGNORE_CASE)
        val emailMatchResult = emailRegex.matchEntire(txtEmailAddress.text.toString())
        if(emailMatchResult==null || emailMatchResult.value.isEmpty())
        {
            txtLayoutEmailAddress.error = "이메일 주소가 형식에 맞지 않습니다."
            isAvailable = false
        }
        if(txtPassword.text.toString() != txtRePassword.text.toString())
        {
            txtLayoutRePassword.error = "비밀번호가 일치하지 않습니다."
            isAvailable = false
        }
        val passwordRegex = Regex("^[A-Za-z0-9]{6,12}\$")
        val passwordMatchResult = passwordRegex.matchEntire(txtPassword.text.toString())
        if(passwordMatchResult==null || passwordMatchResult.value.isEmpty())
        {
            txtLayoutPassword.error = "비밀번호는 6-12자리 숫자/문자만 포함해야 합니다."
            isAvailable = false
        }
        return isAvailable
    }
}