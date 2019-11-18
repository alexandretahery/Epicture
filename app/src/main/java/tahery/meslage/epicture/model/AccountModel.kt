package tahery.meslage.epicture.model

import retrofit2.http.Field
import java.lang.StringBuilder

data class AccountModel (
     var access_token : String? = null,
     var expires_in : Int = -1,
     var token_type : String? = null,
     var scope : String? = null,
     var refresh_token : String? = null,
     var account_id : Int = -1,
     var account_username : String? =null
)
