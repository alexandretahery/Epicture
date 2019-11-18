package tahery.meslage.epicture.OauthReleated

import android.content.Context
import android.content.SharedPreferences

object clientInfo {
        var access_token : String? = null
        var expires_in : Int = -1
        var token_type : String? = null
        var scope : String? = null
        var refresh_token : String? = null
        var account_id : Int = -1
        var account_username : String? =null
}
