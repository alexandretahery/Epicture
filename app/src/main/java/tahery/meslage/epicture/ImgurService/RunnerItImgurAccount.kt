package tahery.meslage.epicture.ImgurService

import android.content.Context
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_account_images.*
import retrofit2.Call
import retrofit2.Response
import tahery.meslage.epicture.OauthReleated.clientInfo
import tahery.meslage.epicture.OauthReleated.AppPreference
import tahery.meslage.epicture.OauthReleated.infoOauth2
import tahery.meslage.epicture.model.*
import tahery.meslage.epicture.AccountImagesWrapper
import tahery.meslage.epicture.LayoutAdapters.AccountImagesAdapter

class RunnerItImgurAccount {
    companion object {
        fun runGenerateAccessToken(context: Context) {
            val newAccessToken = ServiceBuilder.buildService(ItImgurAccount::class.java)
            val dataGenerateTokenModel = GenerateTokenModel()
            dataGenerateTokenModel.refresh_token = clientInfo.refresh_token
            dataGenerateTokenModel.client_id = infoOauth2.devClientId
            dataGenerateTokenModel.client_secret = infoOauth2.devClientSecret

            val requestCall = newAccessToken.generateAccessToken(dataGenerateTokenModel)
            var appPref = AppPreference(context)

            requestCall.enqueue(object : retrofit2.Callback<AccountModel> {
                override fun onFailure(call: Call<AccountModel>, t: Throwable) {
                    Log.i("MY_DEBUG", "NEW ACCESS TOKEN " + t.message)
                }

                override fun onResponse(
                    call: Call<AccountModel>,
                    response: Response<AccountModel>
                ) {
                    if (response.isSuccessful) {
                        appPref.updatePreference(response.body()!!)
                    }
                }
            })

        }

        fun runAccountImages(header : String?,
                             context: Context,
                             accountImages : RecyclerView) {
            val serviceImagesAccount = ServiceBuilder.buildService(ItImgurAccount::class.java)
            val requestCall = serviceImagesAccount.AccountImages("Bearer ${header}")

            var accountImagesWrap = AccountImagesWrapper()
            requestCall.enqueue(object : retrofit2.Callback<AccountImageModel> {
                override fun onFailure(call: Call<AccountImageModel>, t: Throwable) {
                    Log.i("MY_DEBUG", "ACCOUNT IMAGES " + t.message)

                }
                override fun onResponse(
                    call: Call<AccountImageModel>,
                    response: Response<AccountImageModel>
                ) {
                    if (response.isSuccessful) {
                        //Result of Request AccountImagesModel
                        accountImagesWrap!!.accountImages =  response.body()
                        //Log.i("MY_DEBUG", response.body().toString())
                        if (accountImagesWrap.accountImages != null) {
                            //Log.i("MY_DEBUG", response.body().toString())
                            val images = accountImagesWrap.accountImages
                            val layoutManager = LinearLayoutManager(context)
                            layoutManager.orientation = LinearLayoutManager.VERTICAL
                            accountImages.layoutManager = layoutManager

                            val adapter = AccountImagesAdapter(context, images!!.data)
                            accountImages.adapter = adapter
                        }
                    }
                }
            })
        }

        fun runAccountGalleryFavorites(
            header: String?,
            username: String?,
            page: Int,
            favoritesSort: String?
        ) {
            val serviceAccountGalleryFavorites = ServiceBuilder.buildService(ItImgurAccount::class.java)
            val resquestCall = serviceAccountGalleryFavorites.AccountGalleryFavorites("Client-ID ${header}",
                username!!,
                page,
                favoritesSort!!
            )
            resquestCall.enqueue(object : retrofit2.Callback<GalleryFavoritesModel> {
                override fun onFailure(call: Call<GalleryFavoritesModel>, t: Throwable) {
                    Log.i("MY_DEBUG", "GALLERY FAVORITES: " + t.message)
                }

                override fun onResponse(
                    call: Call<GalleryFavoritesModel>,
                    response: Response<GalleryFavoritesModel>
                ) {
                    if (response.isSuccessful) {
                        //Result of Request AccountGalleryFavorites
                        Log.i("MY_DEBUG", "GALLERY FAVORITES: " + response.body().toString())
                    }
                }
            })

        }
    }
}