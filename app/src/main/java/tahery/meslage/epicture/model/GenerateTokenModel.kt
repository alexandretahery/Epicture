package tahery.meslage.epicture.model

import retrofit2.http.Field

data class GenerateTokenModel (
    var refresh_token : String? = null,
    var client_id : String? = null,
    var  client_secret: String? = null,
    var grant_type : String = "refresh_token"
)