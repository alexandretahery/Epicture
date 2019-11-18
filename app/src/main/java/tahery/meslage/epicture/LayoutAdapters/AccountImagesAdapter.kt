package tahery.meslage.epicture.LayoutAdapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_account_images.view.*
import tahery.meslage.epicture.R
import tahery.meslage.epicture.model.ImageModel


class AccountImagesAdapter(val context : Context, val images : Array<ImageModel>) : RecyclerView.Adapter<AccountImagesAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.activity_account_images, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return images.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val image = images[position]
        holder.setData(image, position)
    }

    inner class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun setData(image : ImageModel?, pos : Int) {
            itemView.textView2.text = image!!.title
            Picasso.get().load(image.link).into(itemView.imageView)
        }
    }
}