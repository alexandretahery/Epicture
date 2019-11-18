package tahery.meslage.epicture

import android.accounts.Account
import android.accounts.AccountManager
import android.accounts.AccountManagerCallback
import android.accounts.AccountManagerFuture
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat.startActivityForResult
import kotlinx.android.synthetic.main.sign_in_activity.*
import kotlinx.android.synthetic.main.webviewc_connection_activity.*
import tahery.meslage.epicture.OauthReleated.AppPreference
import tahery.meslage.epicture.OauthReleated.clientInfo
import java.net.HttpURLConnection
import java.net.URL

class SignInActivity  : AppCompatActivity (), AuthListener {
    lateinit var DialogActivity: WebViewActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_in_activity)

        btnSignIn.setOnClickListener {
            DialogActivity = WebViewActivity(this, this)
            DialogActivity.setCancelable(true)
            DialogActivity.show()
        }
    }

    override fun onTokenReceived(rowString: List<String>) {
        var appPref = AppPreference(this)
        appPref.putString(
            AppPreference.TOKEN,
            rowString[0].substring(rowString[0].lastIndexOf("=") + 1)
        )
        appPref.putInt(
            AppPreference.EXPIREIN,
            rowString[1].substring(rowString[1].lastIndexOf("=") + 1).toInt()
        )
        appPref.putString(
            AppPreference.TOKENTYPE,
            rowString[2].substring(rowString[2].lastIndexOf("=") + 1)
        )
        appPref.putString(
            AppPreference.REFRESHTOKEN,
            rowString[3].substring(rowString[3].lastIndexOf("=") + 1)
        )
        appPref.putString(
            AppPreference.ACCUSERNAME,
            rowString[4].substring(rowString[4].lastIndexOf("=") + 1)
        )
        appPref.putInt(
            AppPreference.ACCID,
            rowString[5].substring(rowString[5].lastIndexOf("=") + 1).toInt()
        )

        appPref.initPreference()
        val toAccountImagesActivity = Intent(this, AccountImagesActivity::class.java)
        startActivity(toAccountImagesActivity)
    }
}




