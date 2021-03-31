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
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class QuizFragment extends Fragment implements View.OnClickListener {

    private MediaPlayer player;
    private volatile int time;
    private TextView count;
    private QuizData data;
    private Timer timer;
    private int counter;
    private int answer;

    private ImageButton button1, button2, button3, button4;
    private final Random random = new Random();
    private TextView description;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);
        TextView text = view.findViewById(R.id.textView);
        description = view.findViewById(R.id.textDescription);
        count = view.findViewById(R.id.textView3);
        counter = 0;
        count.setText(String.valueOf(counter));

        data = new QuizData();
        button1 = view.findViewById(R.id.imageButton);
        button1.setOnClickListener(this::onClick);
        button2 = view.findViewById(R.id.imageButton2);
        button2.setOnClickListener(this::onClick);
        button3 = view.findViewById(R.id.imageButton3);
        button3.setOnClickListener(this::onClick);
        button4 = view.findViewById(R.id.imageButton4);
        button4.setOnClickListener(this::onClick);
        updateImages(30);

        timer = new Timer();
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
                                if (TextUtils.equals("Opening", getArguments().getString("byType")))
                                    player.stop();
                                new AlertDialog.Builder(getContext()).setMessage("Время вышло, ваш счет: " + counter).create().show();
                            });
                            cancel();
                        }
                    }
                }, 0, 1000);

        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        if (TextUtils.equals("Opening", getArguments().getString("byType"))) {
            player.stop();
            player.release();
        }
        timer.cancel();
    }

    @Override
    public void onClick(View v) {
        QuizData.Title title = (QuizData.Title) v.getTag();
        if (TextUtils.equals("Opening", getArguments().getString("byType")))
            player.stop();
        if (title.getId() != answer)
            time -= 5;
        else {
            time = 30;
            counter++;
            count.setText(String.valueOf(counter));
        }
        updateImages(time);
    }

    private void updateImages(int time) {
        this.time = time;
        button1.setTag(data.getByIndex(random.nextInt(data.getSize())));
        button1.setImageResource(((QuizData.Title)button1.getTag()).getImage());
        button2.setTag(data.getByIndex(random.nextInt(data.getSize())));
        button2.setImageResource(((QuizData.Title)button2.getTag()).getImage());
        button3.setTag(data.getByIndex(random.nextInt(data.getSize())));
        button3.setImageResource(((QuizData.Title)button3.getTag()).getImage());
        button4.setTag(data.getByIndex(random.nextInt(data.getSize())));
        button4.setImageResource(((QuizData.Title)button4.getTag()).getImage());
        int i = random.nextInt(4) + 1;
        if (1 == i)
            answer = ((QuizData.Title)button1.getTag()).getId();
        if (2 == i)
            answer = ((QuizData.Title)button2.getTag()).getId();
        if (3 == i)
            answer = ((QuizData.Title)button3.getTag()).getId();
        if (4 == i)
            answer = ((QuizData.Title)button4.getTag()).getId();

        if (TextUtils.equals("Opening", getArguments().getString("byType"))) {
            player = MediaPlayer.create(getContext(), Uri.parse(data.getByIndex(answer).getOpening()));
            player.start();
        }
        if (TextUtils.equals("Description", getArguments().getString("byType"))) {
            description.setText(data.getByIndex(answer).getDescription());
        }
    }
}