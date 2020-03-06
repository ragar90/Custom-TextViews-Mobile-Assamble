package com.example.customtextviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import androidx.core.text.HtmlCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.htmlParagraph.text = HtmlCompat.fromHtml(HTML_STRING, HtmlCompat.FROM_HTML_MODE_LEGACY)
        this.htmlParagraphRes.text = HtmlCompat.fromHtml(this.getString(R.string.html_content), HtmlCompat.FROM_HTML_MODE_LEGACY)
        this.htmlParagraphRes.movementMethod = LinkMovementMethod.getInstance()
    }
    companion object{
        const val HTML_STRING = "<h1>Hola</h1><p>Esto es <b>HTML</b></p>"
    }
}
