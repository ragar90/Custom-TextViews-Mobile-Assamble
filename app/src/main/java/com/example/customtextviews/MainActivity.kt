package com.example.customtextviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.method.LinkMovementMethod
import android.text.style.BackgroundColorSpan
import android.text.style.ForegroundColorSpan
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.core.text.HtmlCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    lateinit var colorSpannableString: SpannableStringBuilder
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.htmlParagraph.text = HtmlCompat.fromHtml(HTML_STRING, HtmlCompat.FROM_HTML_MODE_LEGACY)
        this.htmlParagraphRes.text = HtmlCompat.fromHtml(this.getString(R.string.html_content), HtmlCompat.FROM_HTML_MODE_LEGACY)
        this.htmlParagraphRes.movementMethod = LinkMovementMethod.getInstance()
        colorSpannableString = getSpannableForColorTexts()
        this.foregroundSpannable.text = colorSpannableString
        this.backgroundSpannable.text = getSpannableForBackground()
        this.addTextToSpan.setOnClickListener {
            try{

                colorSpannableString.insert(0, "A")
                val insertGreenIndex = colorSpannableString.indexOf("Lo siento") + "Lo siento".length
                colorSpannableString.insert(insertGreenIndex, "A")
                val insertStartBlueIndex = colorSpannableString.indexOf("no soy")
                colorSpannableString.insert(insertStartBlueIndex, "B")
                val insertEndBlueIndex = colorSpannableString.indexOf("no soy") + "no soy".length
                colorSpannableString.insert(insertEndBlueIndex, "B")
                val insertStartYellowIndex = colorSpannableString.indexOf("diseñador")
                colorSpannableString.insert(insertStartYellowIndex, "C")
                val insertEndtYellowIndex = colorSpannableString.indexOf("diseñador") + "diseñador".length
                colorSpannableString.insert(insertEndtYellowIndex, "C")
                this.foregroundSpannable.text = colorSpannableString
            } catch (error: Exception){
                Log.e("ERROR_SPANNED", "Error al insertar", error)
            }
        }
    }


    private fun getSpannableForColorTexts(): SpannableStringBuilder {
        val text = this.getString(R.string.color_texts)
        val spannableString = SpannableStringBuilder(text)
        val startGreenIndex = 0
        val endGreenIndex = startGreenIndex + 9 // largo de la cadena "Lo siento"
        val startBlueIndex = text.indexOf("no")
        val endBlueIndex = startBlueIndex + 6 // largo de la cadena "no soy"
        val startYellowIndex = text.indexOf("diseñador")
        val endYellowIndex = startYellowIndex + "diseñador".length
        spannableString.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, R.color.blue)),
            startBlueIndex,
            endBlueIndex,
            Spannable.SPAN_INCLUSIVE_EXCLUSIVE)
        spannableString.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, R.color.green)),
            startGreenIndex,
            endGreenIndex,
            Spannable.SPAN_INCLUSIVE_INCLUSIVE)
        spannableString.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, R.color.brown)),
            startYellowIndex,
            endYellowIndex,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        return spannableString
    }

    private fun getSpannableForBackground(): SpannableString {
        val text = this.getString(R.string.color_texts)
        val spannableString = SpannableString(text)
        val startGreenIndex = 0
        val endGreenIndex = startGreenIndex + 9 // largo de la cadena "Lo siento"
        val startRedIndex = text.indexOf("no")
        val endRedIndex = startRedIndex + 6 // largo de la cadena "no soy"
        val startYellowIndex = text.indexOf("diseñador")
        val endYellowIndex = startYellowIndex + "diseñador".length
        spannableString.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, R.color.red)),
            startRedIndex,
            endRedIndex,
            Spannable.SPAN_INCLUSIVE_EXCLUSIVE)
        spannableString.setSpan(
            BackgroundColorSpan(ContextCompat.getColor(this, R.color.black)),
            startRedIndex,
            endRedIndex,
            Spannable.SPAN_INCLUSIVE_EXCLUSIVE)
        spannableString.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, R.color.green)),
            startGreenIndex,
            endGreenIndex,
            Spannable.SPAN_INCLUSIVE_INCLUSIVE)
        spannableString.setSpan(
            BackgroundColorSpan(ContextCompat.getColor(this, R.color.black)),
            startGreenIndex,
            endGreenIndex,
            Spannable.SPAN_INCLUSIVE_EXCLUSIVE)
        spannableString.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, R.color.brown)),
            startYellowIndex,
            endYellowIndex,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableString.setSpan(
            BackgroundColorSpan(ContextCompat.getColor(this, R.color.black)),
            startYellowIndex,
            endYellowIndex,
            Spannable.SPAN_INCLUSIVE_EXCLUSIVE)
        return spannableString
    }

    companion object{
        const val HTML_STRING = "<h1>Hola</h1><p>Esto es <b>HTML</b></p>"
    }
}
