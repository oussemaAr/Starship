package io.studio.demoapp.data.model.starship


import com.google.gson.annotations.SerializedName

data class StarShipApiModel(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("previous")
    val previous: Any,
    @SerializedName("results")
    val results: List<StartShipDetailsApiModel>
)