package moe.misakachan.surviverecipe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.facebook.*
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_intro.*
import java.util.*

class IntroActivity : AppCompatActivity() {

    private val callbackManager = CallbackManager.Factory.create()
    private lateinit var firebaseAuth : FirebaseAuth

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        callbackManager.onActivityResult(requestCode, resultCode, data)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        firebaseAuth = FirebaseAuth.getInstance()
        LoginManager.getInstance().registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
            override fun onSuccess(result: LoginResult?) {
            }

            override fun onCancel() {
            }

            override fun onError(error: FacebookException?) {
            }

        })
        setContentView(R.layout.activity_intro)
        button2.setOnClickListener { LoginManager.getInstance().logInWithReadPermissions(this, listOf("public_profile","email")) }
        layout_intro.transitionToEnd()

    }

    override fun onStart() {
        super.onStart()
        if(firebaseAuth.currentUser!=null) {
            //Handle it
        }
    }

    private fun handleFacebookAccessToken(token: AccessToken) {
        Log.d("MisakaMOE", "handleFacebookAccessToken:$token")

        val credential = FacebookAuthProvider.getCredential(token.token)
        firebaseAuth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("MisakaMOE", "signInWithCredential:success")
                    val user = firebaseAuth.currentUser
                    startActivity(Intent(applicationContext, MainPageActivity::class.java))
                    finish()
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("MisakaMOE", "signInWithCredential:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }
}
