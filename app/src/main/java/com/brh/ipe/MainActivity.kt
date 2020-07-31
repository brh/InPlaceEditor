package com.brh.ipe

import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.brh.ipe.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    lateinit var binding: ActivityMainBinding

    override fun setContentView(view: View?) {
        binding = ActivityMainBinding.bind(view!!)
        super.setContentView(view)
    }

    override fun onPostCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onPostCreate(savedInstanceState, persistentState)
        setSupportActionBar(findViewById(R.id.toolbar))

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setupGreetMsgEdit() {
        binding.tilMsg.addOnEditTextAttachedListener {
            it.editText!!.setOnFocusChangeListener {v, hasFocus ->
                if (hasFocus && v.id == R.id.ed_msg) {
                    focusOnGreetMsgEdit()
                } else {
                    endGreetMsgEditing()
                }
            }
            false
        }
    }

    private fun focusOnGreetMsgEdit() {
        if (binding.tilMsg.endIconDrawable == null) {
            with(binding.tilMsg) {
                startIconDrawable = resources.getDrawable(R.drawable.ic_baseline_check_24, null)
                endIconDrawable = resources.getDrawable(R.drawable.ic_baseline_delete_24, null)
                endIconMode = TextInputLayout.END_ICON_CUSTOM
                /*setEndIconTintList(ColorStateList.valueOf(resources.getColor(R.color.colorPrimary, null)))
                setStartIconTintList(ColorStateList.valueOf(resources.getColor(R.color.colorPrimary, null)))*/

                setEndIconOnClickListener {
                    endGreetMsgEditing()
                }

                /*setStartIconOnClickListener {
                    val newGreetMsg = binding.edMsg.text.toString()
                    if (!newGreetMsg.isNullOrBlank()) {
                        binding.progressBar.root.visibility = View.VISIBLE
                        with(viewModel) {
                            updateOptions(GreetMsg(newGreetMsg, greetMsg.default_projectid))
                        }
                    }
                }*/
            }

        }
    }

    private fun endGreetMsgEditing(revertText: Boolean = true) {
        /*binding.progressBar.root.visibility = View.GONE
        with(binding.tilMsg) {
            error = null
            endIconMode = TextInputLayout.END_ICON_NONE
            if (revertText)
                binding.edMsg.setText(viewModel.greetMsg.message, TextView.BufferType.NORMAL)
            binding.edMsg.focusSearch(View.FOCUS_DOWN)?.requestFocus()
            SoftKeyboardUtils.HideSoftKeyboard(requireActivity())
            startIconDrawable = null
        }*/
    }



}