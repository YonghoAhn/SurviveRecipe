package moe.misakachan.surviverecipe.model

data class RecipeContent(
    var content : String = "",
    var id : Int = -1,
    var photo_src : String = "",
    var video_link : String = "",
    var recipe_id : Int = -1
)
