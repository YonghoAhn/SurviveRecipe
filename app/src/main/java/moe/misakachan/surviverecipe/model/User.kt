package moe.misakachan.surviverecipe.model

import com.google.firebase.firestore.ServerTimestamp
import java.sql.Timestamp
import java.util.*
import kotlin.collections.ArrayList

data class User(
    var full_name : String = "",
    var uid : Int = -1,
    var email_address : String = "",
    var introduce : String = "",
    var love_recipe : ArrayList<Int> = arrayListOf(),
    @ServerTimestamp var created_at : Date? = null,
    var country_code : Int = 0,
    var background_src : String = ""
)