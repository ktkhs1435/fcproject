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

class UserInfo(
    val id : Int, val username : String, val profile: OwnerProfile
)

class ToDo(
    val id : Int,
    val content : String,
    val is_complete: Boolean,
    val created: String

)

interface RetrofitService {

    @PUT("to-do/complete/{todoId}")
    fun changeToDoComplete(
        @HeaderMap headers: Map<String,String>,
        @Path("todoId") todoId: Int
    ): Call<Any>

    @GET("to-do/")
    fun getToDoList(
        @HeaderMap headers: Map<String,String>,
    ): Call<ArrayList<ToDo>>

    @POST("to-do/")
    @FormUrlEncoded
    fun makeToDo(
        @HeaderMap headers: Map<String, String>,
        @FieldMap params: HashMap<String, Any>
    ):Call<Any>

    @Multipart
    @PUT("user/profile/{user_id}/")
    fun changeProfile(
        @Path("user_id") userId : Int,
        @HeaderMap headers: Map<String, String>,
        @Part image : MultipartBody.Part,
        @Part("user") user: RequestBody
    ):Call<Any>

    @GET("user/userInfo/")
    fun getUserInfo(
        @HeaderMap headers: Map<String, String>,
    ):Call<UserInfo>

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