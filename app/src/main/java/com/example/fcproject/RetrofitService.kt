package com.example.fcproject

import okhttp3.MultipartBody
import okhttp3.RequestBody
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
    val id: Int, val content: String, val image: String, val owner_profile:OwnerProfile
)

class OwnerProfile(
    val username: String, val image: String?
)

interface RetrofitService {

    @Multipart
    @POST("instagram/post/")
    fun uploadPost(
        @HeaderMap headers: Map<String, String>,
        @Part image: MultipartBody.Part,
        @Part("content") content : RequestBody
    ): Call<Any>

    @POST("instagram/post/like/{post_id}")
    fun postLike(
        @Path("post_id") post_id: Int
    ): Call<Any>

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