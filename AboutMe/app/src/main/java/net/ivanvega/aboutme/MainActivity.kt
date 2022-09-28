package net.ivanvega.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import net.ivanvega.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Aleks Haecky")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName

//        findViewById<Button>(R.id.done_button).setOnClickListener {
//            addNickname(it)
//        }
        binding.doneButton.setOnClickListener {
            addNickname(it)
        }

//        findViewById<TextView>(R.id.nickname_text).setOnClickListener {
//            updateNickname(it)
//        }
        binding.nicknameText.setOnClickListener {
            updateNickname(it)
        }


    }

    private fun clickHandlerFunction(viewThatIsClicked: View) {
        // Add code to perform the button click event
    }

    fun addNickname(view: View){
////        val editText = findViewById<EditText>(R.id.nickname_edit)
//        val editText = binding.nicknameEdit
//
////        val nicknameTextView = findViewById<TextView>(R.id.nickname_text)
//        val nicknameTextView = binding.nicknameText
//
//        nicknameTextView.text = editText.text
//        editText.visibility = View.GONE
//
//        nicknameTextView.visibility = View.VISIBLE
//        view.visibility = View.GONE



        binding.apply {
            //nicknameText.text = nicknameEdit.text.toString()
            myName?.nickname = nicknameEdit.text.toString()
            invalidateAll()
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }


        // Hide the keyboard.
        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)

    }

    private fun updateNickname (view: View) {
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val doneButton = findViewById<Button>(R.id.done_button)

        editText.visibility = View.VISIBLE
        doneButton.visibility = View.VISIBLE
        view.visibility = View.GONE

        editText.requestFocus()

        // Show the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText, 0)


    }


}