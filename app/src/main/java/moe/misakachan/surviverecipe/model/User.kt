package moe.misakachan.surviverecipe.model

import java.sql.Timestamp

data class User(
    var full_name : String = "",
    var uid : Int,
    var email_address : String = "",
    var introduce : String = "",
    var love_recipe : IntArray,
    var created_at : Timestamp,
    var country_code : Int,
    var backgorundsrc : String
)