package moe.misakachan.surviverecipe.model

import com.google.firebase.firestore.ServerTimestamp
import java.sql.Timestamp
import java.util.*
import kotlin.collections.ArrayList

data class Recipe(
    var author_uid : String = "",
    var author_name : String = "",
    var created_at : Date? = null,
    var id : Int = -1,
    var lovers : Int = 0,
    var region_code : Int = 0,
    var theme : ArrayList<String> = arrayListOf(),
    var introduce: String = "",
    var recipe_name : String = "",
    var thumbnail_url : String = ""
) {

}
