package com.example.omaro.browser

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buNext(view: View){

        try {
            var url=etUrl.text.toString()
            if (url.contains("https://")){
                url=url
            }
            else if (!url.contains("http://")){
                url="http://$url"
            }
            var mywebView=findViewById<WebView>(R.id.webview)

            mywebView.webViewClient= WebViewClient()
            mywebView.settings.javaScriptEnabled=true

            mywebView.loadUrl(url)


            mywebView.webChromeClient=object :WebChromeClient(){

                override fun onProgressChanged(view: WebView?, newProgress: Int) {
                    progressBar.visibility=View.VISIBLE
                    progressBar.progress=newProgress
                    if (newProgress==100){
                        progressBar.visibility=View.INVISIBLE
                    }else{
                        progressBar.visibility=View.VISIBLE
                    }
                }

            }



        }catch (ex:Exception){
            Toast.makeText(this,ex.toString(),Toast.LENGTH_LONG).show()
        }

    }
}
