package com.ubaya.adv160419108week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_game.*

class GameFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(arguments != null){
            val playerName = GameFragmentArgs.fromBundle(requireArguments()).playerName
            txtTurn.text = "$playerName's Turn"
        }
        var score = 0
        var num1 =(0..100).random()
        var num2 =(0..100).random()
        var res = 0

        res = num1 + num2
        txtNum1.setText(num1.toString())
        txtNum2.setText(num2.toString())
        btnSubmit.setOnClickListener {
            var answer = txtAnswer.text.toString()
            if (answer == res.toString()) {
                var A = (0..100).random()
                var B = (0..100).random()
                res = A + B
                txtNum1.setText(A.toString())
                txtNum2.setText(B.toString())
                score += 1
                txtAnswer.setText("")
            } else {
                val totalscore = score.toString()
                val action = GameFragmentDirections.actionResultFragment(totalscore)
                Navigation.findNavController(it).navigate(action)
            }
        }
    }
}