package tahery.meslage.epicture


import android.app.Dialog
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import tahery.meslage.epicture.OauthReleated.clientInfo
import tahery.meslage.epicture.OauthReleated.infoOauth2
import kotlin.math.log

/*
class WebViewActivity(context : Context, listener: AuthenticationListener) : AppCompatActivity(){

*/
/*
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("MY_DEBUG", "WebViewActivity")
        setContentView(R.layout.webviewc_connection_activity)
        var webViewAuth : WebView = findViewById(R.id.webViewOauth)
        webViewAuth.settings.javaScriptEnabled = true
        webViewAuth.loadUrl("https://api.imgur.com/oauth2/authorize?client_id=${infoOauth2.devToken}&response_type=token")

//        var intent : Intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://api.imgur.com/oauth2/authorize?client_id=${infoOauth2.token}&response_type=token"))
//        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()

//        var uri : Uri? = intent.data
//
//        if (uri != null && uri.toString().startsWith(callbackString)) {
//            clientAccessToken = uri.getQueryParameter("access_token")
//
//            Log.i("MY_DEBUG", uri.toString())
//        }
    }*//*


}
*/


class WebViewActivity(context: Context, var listener: AuthListener) :  Dialog(context){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.webviewc_connection_activity)

        var webViewAuth : WebView = findViewById(R.id.webViewOauth)
        webViewAuth.settings.javaScriptEnabled = true
        webViewAuth.loadUrl("https://api.imgur.com/oauth2/authorize?client_id=${infoOauth2.devClientId}&response_type=token")
        webViewAuth.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                if (request!!.url.toString().startsWith(infoOauth2.callbackString)) {
                    this@WebViewActivity.dismiss()
                    return true
                }
                return false
            }
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                if (url!!.contains("access_token=")) {
                    var uri : Uri = Uri.parse(url)
                    var rowString = uri.encodedFragment.split("&")
                    listener.onTokenReceived(rowString)
                }
            }
        }
    }
}