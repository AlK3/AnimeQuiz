package aik3.game.animequiz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class MainFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ((Button) view.findViewById(R.id.btnByOpening))
                .setOnClickListener(Navigation.createNavigateOnClickListener(
                        R.id.quizFragment, setBundle(1)));
        ((Button) view.findViewById(R.id.btnByDescription))
                .setOnClickListener(Navigation.createNavigateOnClickListener(
                        R.id.quizFragment, setBundle(2)));
        ((Button) view.findViewById(R.id.btnByEnding))
                .setOnClickListener(Navigation.createNavigateOnClickListener(
                        R.id.quizFragment, setBundle(3)));
        return view;
    }


    private @NonNull Bundle setBundle(int type) {
        Bundle bundle = new Bundle();
        if (1 == type)
            bundle.putString("byType", "Opening");
        if (2 == type)
            bundle.putString("byType", "Description");
        if (3 == type)
            bundle.putString("byType", "Ending");
        return bundle;
    }
}