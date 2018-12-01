package id.riotfallen.firstprac

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
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

        productList.add(Product("Sepatu Kucing", 280_000, 3,
                "https://cdns.klimg.com/dream.co.id/resized/308x204/news/2016/05/27/33730/sepatu-adidas-dijual-rp217-juta-tapi-produksinya-rp407-ribu-1605270.jpg"))

        productList.add(Product("Sepatu Ayam", 160_300, 2,
                "https://s3.bukalapak.com/img/8911351643/large/New_Product_Sepatu_Nike_Airmax_270_Navy_Premium_Sneakers_Ket.jpg"))

        productList.add(Product("Sepatu Sapi", 210_000, 9,
                "https://ecs7.tokopedia.net/img/cache/700/product-1/2017/3/21/17278844/17278844_364723ef-8e56-4a9b-899f-83edcef7d9df_1000_563.jpg"))

        recyclerViewMain.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        recyclerViewMain.adapter = ProductAdapter(this, productList)

    }
}
