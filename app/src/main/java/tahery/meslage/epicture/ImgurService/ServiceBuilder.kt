package tahery.meslage.epicture.ImgurService

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object ServiceBuilder{
    private const val defaultUrl = "https://api.imgur.com"
    private val okHttp : OkHttpClient.Builder = OkHttpClient.Builder()
    private val builder = Retrofit.Builder().baseUrl(defaultUrl)
                                            .addConverterFactory(GsonConverterFactory.create())
                                            .addConverterFactory(ScalarsConverterFactory.create())
                                            .client(okHttp.build())
    private val retrofit = builder.build()
    fun <T> buildService(serviceType: Class<T>) : T{
        return retrofit.create(serviceType)
    }
}