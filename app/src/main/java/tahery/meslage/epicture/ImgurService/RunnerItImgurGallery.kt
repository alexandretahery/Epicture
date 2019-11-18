package tahery.meslage.epicture.ImgurService

import android.util.Log
import retrofit2.Call
import retrofit2.Response
import tahery.meslage.epicture.model.GalleryModel

class RunnerItImgurGallery {
    companion object {
        fun runGallery(
            header: String?,
            section: String?,
            sort: String?,
            window: String?,
            page: Int,
            showViral: Boolean,
            showMature: Boolean,
            albumPreviews: Boolean
        ) {
            val serviceGallery = ServiceBuilder.buildService(ItImgurGallery::class.java)
            val resquestCall = serviceGallery.Gallery(
                "Client-ID ${header}",
                section!!,
                sort!!,
                window!!,
                page,
                showViral,
                showMature,
                albumPreviews
            )
            resquestCall.enqueue(object : retrofit2.Callback<GalleryModel> {
                override fun onFailure(call: Call<GalleryModel>, t: Throwable) {
                    Log.i("MY_DEBUG", "GALLERY: " + t.message)
                }

                override fun onResponse(
                    call: Call<GalleryModel>,
                    response: Response<GalleryModel>
                ) {
                    Log.i("MY_DEBUG", "GALLERY: " + response.body().toString())
                }
            })
        }
    }
}