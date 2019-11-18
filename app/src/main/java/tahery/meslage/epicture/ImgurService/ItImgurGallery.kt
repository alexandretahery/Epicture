package tahery.meslage.epicture.ImgurService

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query
import tahery.meslage.epicture.model.GalleryModel

interface ItImgurGallery {
    @GET("/3/gallery/{section}/{sort}/{window}/{page}")
    fun Gallery(@Header("Authorization") header: String,
                @Path("section") section : String,
                @Path("sort") sort : String,
                @Path("window") window : String,
                @Path("page") page : Int,
                @Query("showViral") showViral : Boolean,
                @Query("showMature") showMature :Boolean,
                @Query("albumPreviews") albumPreviews : Boolean): Call<GalleryModel>
}