package id.riotfallen.firstprac.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import id.riotfallen.firstprac.R
import id.riotfallen.firstprac.adapter.ProductAdapter
import id.riotfallen.firstprac.model.Product
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val productList: MutableList<Product> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(actionBarMain)
        supportActionBar?.title = "List Produk"

        val descriptionText = resources.getString(R.string.dummy_text_long)

        productList.add(Product("Nike Mercurial Vapor XI FG Men's", descriptionText, 2800000.00, 2,
                "https://img.auctiva.com/imgdata/1/2/7/9/4/0/1/webimg/971362538_o.jpg"))

        productList.add(Product("Adidas X 17.3 FG 2017", descriptionText,2603000.00, 0,
                "https://shop.r10s.jp/sportsjapan/cabinet/kkk30025/adj-by2206-.jpg"))

        productList.add(Product("Adidas Men's X 16.2 FG", descriptionText,1800000.00, 9,
                "https://cdn3.volusion.com/goz35.avhz4/v/vspfiles/photos/SM-ADS77054-2.jpg"))

        productList.add(Product("Goalkeeper Gloves", descriptionText,210000.00, 5,
                "https://images-na.ssl-images-amazon.com/images/I/81OIZxHwTwL._SL1500_.jpg"))

        productList.add(Product("Adidas Men's X 16.2 FG", descriptionText,239500.00, 0,
                "https://pixel.nymag.com/imgs/daily/strategist/2018/06/15/soccer-cleats/Copa-blackout.w710.h473.2x.jpg"))

        recyclerViewMain.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        recyclerViewMain.adapter = ProductAdapter(this, productList)

    }
}
