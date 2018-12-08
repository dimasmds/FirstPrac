package id.riotfallen.firstprac.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.View.VISIBLE
import com.squareup.picasso.Picasso
import id.riotfallen.core.Utils
import id.riotfallen.firstprac.R
import id.riotfallen.firstprac.model.Product
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    private lateinit var product: Product

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        product = intent.getParcelableExtra("DATA_PRODUCT")

        val stockString = getString(R.string.available_stock) + product.quantity

        setSupportActionBar(detailActivityToolbar)

        supportActionBar?.title = product.name
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        detailActivityTextViewName.text = product.name
        detailActivityTextViewDesc.text = product.description
        detailActivityTextViewHarga.text = Utils.Currency().doubleToCurrencyFormat(product.price)
        detailActivityTextViewStock.text = stockString
        Picasso.get().load(product.imgUrl).into(detailActivityImageProduk)
        if(product.quantity == 0) {
            detailActivityImageViewSold.visibility = VISIBLE
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}
