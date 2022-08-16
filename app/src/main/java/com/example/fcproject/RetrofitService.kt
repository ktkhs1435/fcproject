package com.example.fcproject

import retrofit2.Call
import retrofit2.http.*
import java.io.Serializable

class MelonItem(
    val id:Int, val title: String, val song: String, val thumbnail: String
):Serializable

class User(
    val id: Int,
    val userName : String,
    val token : String
)

class InstaPost(
    val content: String, val image: String, val owner_profile:OwnerProfile
)

class OwnerProfile(
    val username: String, val image: String?
)

interface RetrofitService {

    @GET("instagram/post/list/all/")
    fun getInstagramPosts(

    ): Call<ArrayList<InstaPost>>

    @POST("user/signup/")
    @FormUrlEncoded
    fun instaJoin(
        @FieldMap params: HashMap<String, Any>
    ):Call<User>


    @POST("user/login/")
    @FormUrlEncoded
    fun instaLogin(
        @FieldMap params: HashMap<String, Any>
    ):Call<User>

    @GET("melon/list/")
    fun getMelonItemList():Call<ArrayList<MelonItem>>
}