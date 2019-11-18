package tahery.meslage.epicture.ImgurService

import retrofit2.Call
import retrofit2.http.*
import tahery.meslage.epicture.model.*

interface ItImgurAccount{
    @POST("/oauth2/token")
    fun generateAccessToken(@Body body: GenerateTokenModel) : Call<AccountModel>

    @GET("/3/account/me/images")
    fun AccountImages(@Header("Authorization") header: String) : Call<AccountImageModel>

    @GET("/3/account/{username}/gallery_favorites/{page}/{favoritesSort}")
    fun  AccountGalleryFavorites(@Header("Authorization") header: String,
                                 @Path("username") username : String,
                                 @Path("page") page : Int,
                                 @Path("favoritesSort") favoritesSort : String): Call <GalleryFavoritesModel>

}
