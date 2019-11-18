package tahery.meslage.epicture

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        accountImagesBtn.setOnClickListener()
        {
            val toAccountImagesActivity = Intent(this, AccountImagesActivity::class.java)
            startActivity(toAccountImagesActivity)
        }
    }
}