package id.riotfallen.firstprac.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import id.riotfallen.core.Utils
import id.riotfallen.firstprac.R
import id.riotfallen.firstprac.model.Product
import org.jetbrains.anko.textColor

class ProductAdapter(private val context: Context,
                     private val product: MutableList<Product>) :
        RecyclerView.Adapter<ProductAdapter.ProductListViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductListViewHolder {
        return ProductListViewHolder(LayoutInflater.from(context).inflate(R.layout.row_item, parent, false))
    }

    override fun getItemCount(): Int = product.size

    override fun onBindViewHolder(holder: ProductListViewHolder, position: Int) {
        holder.bindItem(product[position])
    }


    class ProductListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val imageViewProduct: ImageView = view.findViewById(R.id.imageViewProduct)
        private val imageViewSold: ImageView = view.findViewById(R.id.imageViewSold)
        private val textViewNamaPruduk: TextView = view.findViewById(R.id.textViewNamaProduk)
        private val textViewHarga: TextView = view.findViewById(R.id.textViewPrice)
        private val textViewQuantity: TextView = view.findViewById(R.id.textViewQuantity)
        private val textViewDesc: TextView = view.findViewById(R.id.textDescription)

        @SuppressLint("SetTextI18n")
        fun bindItem(product: Product) {
            textViewHarga.text = Utils.Currency().doubleToCurrencyFormat(product.price)
            textViewNamaPruduk.text = product.name
            textViewDesc.text = product.description
            Picasso.get().load(product.imgUrl).fit().centerCrop().into(imageViewProduct)

            if(product.quantity != 0){
                if(product.quantity > 5){
                    textViewQuantity.text = product.quantity.toString() + " Stock Available"
                    textViewQuantity.textColor = ContextCompat.getColor(itemView.context, R.color.colorOnStock)
                    textViewQuantity.background = ContextCompat.getDrawable(itemView.context, R.drawable.bg_on_stock_list)
                } else {
                    textViewQuantity.text = product.quantity.toString() + " LIMITED Stock"
                    textViewQuantity.textColor = ContextCompat.getColor(itemView.context, R.color.colorLimitStock)
                    textViewQuantity.background = ContextCompat.getDrawable(itemView.context, R.drawable.bg_limit_stock_list)
                }
            } else {
                textViewQuantity.text = "Out Of Stock"
                textViewQuantity.textColor = ContextCompat.getColor(itemView.context, R.color.colorOutOfStock)
                textViewQuantity.background = ContextCompat.getDrawable(itemView.context, R.drawable.bg_out_stock_list)
                imageViewSold.visibility = VISIBLE
            }
        }
    }

}