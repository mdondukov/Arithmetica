package team.fightcats.arithmetica

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI

class MainActivity : AppCompatActivity() {
    private lateinit var mToolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        initNavigation()
    }

    private fun initViews() {
        mToolbar = findViewById(R.id.toolbar)
        setSupportActionBar(mToolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        setInsets()
    }

    private fun initNavigation() {
        val title: TextView = mToolbar.findViewById(R.id.toolbar_title)
        val layout = findViewById<View>(R.id.main_layout)
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.startFragment -> {
                    title.text = ""
                    layout.setBackgroundResource(R.drawable.start_bg)
                }
                R.id.gameFragment -> {
                    title.text = resources.getString(R.string.training)
                    layout.setBackgroundResource(R.drawable.end_bg)
                }
                R.id.endFragment -> {
                    title.text = resources.getString(R.string.result)
                    layout.setBackgroundResource(R.drawable.end_bg)
                }
            }
        }
        val appBarConfiguration: AppBarConfiguration =
            AppBarConfiguration.Builder(navController.graph).build()
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
    }

    private fun setInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(mToolbar) { v: View, insets: WindowInsetsCompat ->
            val params = v.layoutParams as ViewGroup.MarginLayoutParams
            params.topMargin = insets.systemWindowInsetTop
            insets
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}