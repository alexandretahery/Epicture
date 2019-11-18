package tahery.meslage.epicture.OauthReleated

import android.content.Context
import android.content.SharedPreferences
import tahery.meslage.epicture.model.AccountModel

class AppPreference(var context : Context, private var preference : SharedPreferences = context.getSharedPreferences("user_data", Context.MODE_PRIVATE) ) {
    companion object{
        val TOKEN = "token"
        val EXPIREIN = "expiresIn"
        val TOKENTYPE = "tokenType"
        val REFRESHTOKEN = "refreshToken"
        val ACCUSERNAME = "accountUsername"
        val ACCID = "accountId"
    }


    fun getString(key : String) : String {
        return preference.getString(key, "")
    }


    fun getInt(key: String) : Int {
        return preference.getInt(key, -1)
    }

    fun putString(key: String, value : String) {
        var editor : SharedPreferences.Editor = preference.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun putInt(key: String, value : Int) {
        var editor : SharedPreferences.Editor = preference.edit()
        editor.putInt(key, value)
        editor.apply()
    }

    fun clear() {
        var editor = preference.edit()
        editor.clear()
        editor.apply()
    }

    fun initPreference (){
        var appPref = AppPreference(context)
        clientInfo.access_token = appPref.getString(TOKEN)
        clientInfo.expires_in = appPref.getInt(EXPIREIN)
        clientInfo.token_type = appPref.getString(TOKENTYPE)
        clientInfo.refresh_token = appPref.getString(REFRESHTOKEN)
        clientInfo.account_username = appPref.getString(ACCUSERNAME)
        clientInfo.account_id = appPref.getInt(ACCID)
    }

    fun updatePreference (newAccount : AccountModel) {
        var appPref = AppPreference(context)
        appPref.putString(TOKEN, newAccount.access_token!!)
        appPref.putInt(EXPIREIN, newAccount.expires_in)
        appPref.putString(TOKENTYPE, newAccount.token_type!!)
        appPref.putString(REFRESHTOKEN, newAccount.refresh_token!!)
        appPref.putString(ACCUSERNAME, newAccount.account_username!!)
        appPref.putInt(ACCID, newAccount.account_id)
        initPreference()
    }
}