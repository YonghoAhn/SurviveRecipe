package moe.misakachan.surviverecipe.model

data class RecipeList(
    var name : String = "",
    var recipe_id : ArrayList<String> = arrayListOf(),
    var theme : String = ""
)