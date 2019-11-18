package tahery.meslage.epicture

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import tahery.meslage.epicture.LayoutAdapters.AccountImagesAdapter
import kotlinx.android.synthetic.main.activity_account_images.*
import tahery.meslage.epicture.ImgurService.RunnerItImgurAccount
import tahery.meslage.epicture.OauthReleated.clientInfo

class AccountImagesActivity  : AppCompatActivity(){

    private var accountImagesWrap = AccountImagesWrapper()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_images)

        //sounds good doesn't work
        RunnerItImgurAccount.runAccountImages(clientInfo.access_token,
            this,
            accountImages)

    }
}