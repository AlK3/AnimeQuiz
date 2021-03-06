package aik3.game.animequiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

class MainActivity : AppCompatActivity() {

    private lateinit var host: NavHostFragment;
    private lateinit var controller: NavController;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        host = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        controller = host.navController
        controller.navigate(R.id.mainFragment)
    }

    override fun onPause() {
        super.onPause()
        controller.navigate(R.id.mainFragment)
    }
}