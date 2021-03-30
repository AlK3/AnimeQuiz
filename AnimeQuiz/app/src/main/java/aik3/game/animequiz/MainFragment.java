package aik3.game.animequiz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
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
                        R.id.quizFragment,setBundle(true)));
        ((Button) view.findViewById(R.id.btnByDescription))
                .setOnClickListener(Navigation.createNavigateOnClickListener(
                        R.id.quizFragment, setBundle(false)));

        ((Switch) view.findViewById(R.id.switchSetMusic)).setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {

            }
        });
        return view;
    }


    private @NonNull Bundle setBundle(boolean byOpening) {
        Bundle bundle = new Bundle();
        if (true == byOpening)
            bundle.putString("byType", "Opening");
        else bundle.putString("byType", "Description");
        return bundle;
    }
}