package tahery.meslage.epicture

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import tahery.meslage.epicture.OauthReleated.AppPreference
import tahery.meslage.epicture.OauthReleated.AppPreference.Companion.TOKEN
import tahery.meslage.epicture.ImgurService.RunnerItImgurAccount
import tahery.meslage.epicture.ImgurService.RunnerItImgurGallery
import tahery.meslage.epicture.OauthReleated.clientInfo
import tahery.meslage.epicture.OauthReleated.infoOauth2
import tahery.meslage.epicture.model.AccountModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //TODO
        //
        // future feature:
        //
        // Do Resquest if access token is ok
        // toHomeActivity
        //else
        // toSignInActivity

        val appPref = AppPreference(this)
        if (appPref.getString(TOKEN) == "") {
            val toSignInActivity = Intent(this, SignInActivity::class.java)
            startActivity(toSignInActivity)
        }
        else {
            appPref.initPreference()
            RunnerItImgurAccount.runGenerateAccessToken(this)
            RunnerItImgurGallery.runGallery(infoOauth2.devClientId,
                "hot",
                "viral",
                "day",
                0,
                true,
                true,
                true
                )
            val toDashboardActivity = Intent(this, DashboardActivity::class.java)
            startActivity(toDashboardActivity)
        }
        finish()
    }
}
