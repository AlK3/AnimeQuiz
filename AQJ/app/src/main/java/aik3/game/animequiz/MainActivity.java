package aik3.game.animequiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private NavHostFragment host;
    private NavController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        host = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        controller = host.getNavController();
        controller.navigate(R.id.mainFragment);
    }

    @Override
    protected void onPause() {
        super.onPause();
        host = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        controller = host.getNavController();
        controller.navigate(R.id.mainFragment);
    }
}