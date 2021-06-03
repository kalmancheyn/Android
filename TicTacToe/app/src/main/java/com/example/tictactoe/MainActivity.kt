package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewAnimationUtils
import com.example.tictactoe.model.TicTacToeModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnReset.setOnClickListener {
            ticView.resetGame()
            revealTicTacToe()
        }
    }
    public fun showText(text: String) {
        tvData.text = text
    }

    public fun showWinner(text: String) {
        tvWinner.text = text
    }

    fun revealTicTacToe() {
        val x = ticView.getRight()
        val y = ticView.getBottom()

        val startRadius = 0
        val endRadius = Math.hypot(ticView.getWidth().toDouble(),
            ticView.getHeight().toDouble()).toInt()

        val anim = ViewAnimationUtils.createCircularReveal(ticView, x, y, startRadius.toFloat(), endRadius.toFloat())

        ticView.setVisibility(View.VISIBLE)
        anim.start()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.game_restart) {
            ticView.resetGame()
            revealTicTacToe()
        }

        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_game, menu)
        return true
    }

}