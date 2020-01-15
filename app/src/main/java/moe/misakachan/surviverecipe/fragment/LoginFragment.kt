package moe.misakachan.surviverecipe.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_login.*
import moe.misakachan.surviverecipe.R
import moe.misakachan.surviverecipe.activity.MainPageActivity


/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : Fragment() {

    private lateinit var firebaseAuth : FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        firebaseAuth = FirebaseAuth.getInstance()

        btnLogin.setOnClickListener {
            firebaseAuth.signInWithEmailAndPassword(txtLoginEmail.text.toString(), txtLoginPassword.text.toString()).addOnCompleteListener {
                if(it.isSuccessful)
                {
                    activity!!.startActivity(Intent(context,
                        MainPageActivity::class.java))
                    activity!!.finish()
                }
                else
                {
                    Toast.makeText(context, "로그인에 실패하였습니다.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}