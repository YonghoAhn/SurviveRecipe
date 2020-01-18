package moe.misakachan.surviverecipe.model

import java.sql.Timestamp

data class Recipe(
    var author_uid : Int,
    var created_at : Timestamp,
    var id : Int,
    var lovers : Int,
    var region_code : Int,
    var theme : Array<String>,
    var introduce: String,
    var recipe_name : String
)
