package aik3.game.animequiz;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class QuizFragment extends Fragment {

    private MediaPlayer player;
    private volatile int time;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);
        TextView text = view.findViewById(R.id.textView);
        time = 30;
        Timer timer = new Timer();
        timer.schedule(
                new TimerTask() {

                    @Override
                    public void run() {
                        if (time > 0) {
                            time--;
                            getActivity().runOnUiThread(() -> {
                                text.setText(String.valueOf(time));
                            });
                        } else {
                            getActivity().runOnUiThread(() -> {
                                player.stop();
                                Toast.makeText(getContext(), "", Toast.LENGTH_LONG).show();
                            });
                            cancel();
                        }
                    }
                }, 0, 1000);

        if (TextUtils.equals("Opening", getArguments().getString("byType"))) {
            player = MediaPlayer.create(getContext(), Uri.parse(new QuizData().getCurrent().getOpening()));
            player.start();
        }
        return view;
    }



    @Override
    public void onPause() {
        super.onPause();
        player.stop();
    }
}