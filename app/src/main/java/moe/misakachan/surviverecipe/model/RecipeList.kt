package moe.misakachan.surviverecipe.model

data class RecipeList(
    var name : String = "",
    var recipe_id : ArrayList<Int> = arrayListOf(),
    var theme : String = ""
)