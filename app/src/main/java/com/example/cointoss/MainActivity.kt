@file:Suppress("Annotator", "Annotator", "Annotator", "Annotator")

package com.example.cointoss

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.cointoss.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val button1:Button=findViewById(R.id.button)
        button1.setOnClickListener { flipCoin() }
        flipCoin()
    }
    @SuppressLint("SetTextI18n")
    private fun flipCoin(){
      val coin=Coin()
      val coinroll = coin.roll()
        val result=binding.editTextTextPersonName.text.toString().toIntOrNull()
        if(result==null)
        {
            binding.textView3.text = "Invalid"
            return
        }
       if(result==coinroll)
       {
           binding.textView3.text = "WON"
       }
        else{
           binding.textView3.text = "LOSE"
       }
     val coinimage:ImageView=findViewById(R.id.imageView6)
        val drawablResource= when(coinroll)
        {
            1 -> R.drawable.head
            2 -> R.drawable.tail
            else->R.drawable.draw
        }
        coinimage.setImageResource(drawablResource)
        coinimage.contentDescription=coinroll.toString()
    }
}
class Coin(private val faces:Int = 3){
    fun roll():Int
    {
        return (1..faces).random()
    }
}