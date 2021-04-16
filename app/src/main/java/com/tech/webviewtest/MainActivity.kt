package com.tech.webviewtest

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    var google = "https://www.google.com/"
    var facebook = "https://www.facebook.com/"
    var instagram = "https://www.instagram.com/"
    var crikcet = "https://www.cricbuzz.com/"
    var youtube = "https://www.youtube.com/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        webview.loadUrl("https://github.com/dnyaneshrt")
//step 3
        webview.settings.builtInZoomControls=true
        webview.settings.javaScriptEnabled=true


//step 2
        webview.webViewClient= object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                progressBar.visibility=View.VISIBLE
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                progressBar.visibility=View.GONE
            }

            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                return super.shouldOverrideUrlLoading(view, request)
            }

        }





    }

    fun load(view: View) {
       //step 1
        //webview.loadUrl("url") is used to load the url
        when(view.id)
        {

            R.id.btn_youtube->webview.loadUrl(youtube)
            R.id.btn_google->webview.loadUrl(google)
            R.id.btn_instagram->webview.loadUrl(instagram)
            R.id.btn_facebook->webview.loadUrl(facebook)
            R.id.btn_cricket->webview.loadUrl(crikcet)
        }

    }
}