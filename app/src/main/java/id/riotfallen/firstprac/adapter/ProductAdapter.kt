package id.riotfallen.firstprac.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import id.riotfallen.firstprac.R
import id.riotfallen.firstprac.model.Product

class ProductAdapter(private val context: Context,
                     private val product: MutableList<Product>) :
        RecyclerView.Adapter<ProductAdapter.ProductListViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductListViewHolder {
        return ProductListViewHolder(LayoutInflater.from(context).inflate(R.layout.row_item, parent, false))
    }

    override fun getItemCount(): Int = product.size

    override fun onBindViewHolder(holder: ProductListViewHolder, position: Int) {
        holder.bindItem(product[position])
    }


    class ProductListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val imageViewProduct: ImageView = view.findViewById(R.id.imageViewProduct)
        private val textViewNamaPruduk: TextView = view.findViewById(R.id.textViewNamaProduk)
        private val textViewHarga: TextView = view.findViewById(R.id.textViewPrice)
        private val textViewQuantity: TextView = view.findViewById(R.id.textViewQuantity)

        @SuppressLint("SetTextI18n")
        fun bindItem(product: Product){
            textViewHarga.text = "Harga: " + product.price.toString()
            textViewNamaPruduk.text = product.name
            textViewQuantity.text = "Stock: " + product.quantity.toString()

            Picasso.get().load(product.imgUrl).fit().centerCrop().into(imageViewProduct)
        }
    }

}