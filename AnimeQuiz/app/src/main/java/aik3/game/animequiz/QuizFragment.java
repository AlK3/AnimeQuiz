package aik3.game.animequiz;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class QuizFragment extends Fragment implements View.OnClickListener {

    private MediaPlayer player;
    private volatile int time;
    private TextView count;
    private QuizData data;
    private Timer timer;
    private int counter;
    private int answer;

    private ImageView btnOp1, btnOp2, btnOp3, btnOp4;
    private LinearLayout btnD1, btnD2, btnD3, btnD4;
    private final Random random = new Random();
    private TextView description, tv1, tv2, tv3, tv4;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view;

        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(R.id.mainFragment);
            }
        });

        if (TextUtils.equals("Opening", getArguments().getString("byType")))
            view = inflater.inflate(R.layout.fragment_quiz_opening, container, false);
        else view = inflater.inflate(R.layout.fragment_quiz_description, container, false);
        TextView text = view.findViewById(R.id.textView);
        count = view.findViewById(R.id.textView3);
        counter = 0;
        count.setText("счет: " + counter);

        data = new QuizData();
        btnOp1 = view.findViewById(R.id.imageView);
        btnOp2 = view.findViewById(R.id.imageView2);
        btnOp3 = view.findViewById(R.id.imageView3);
        btnOp4 = view.findViewById(R.id.imageView4);

        if (TextUtils.equals("Opening", getArguments().getString("byType"))) {
            btnOp1.setOnClickListener(this::onClick);
            btnOp2.setOnClickListener(this::onClick);
            btnOp3.setOnClickListener(this::onClick);
            btnOp4.setOnClickListener(this::onClick);
        }

        if (TextUtils.equals("Description", getArguments().getString("byType"))) {
            description = view.findViewById(R.id.textDescription);
            btnD1 = view.findViewById(R.id.linearView);
            btnD2 = view.findViewById(R.id.linearView2);
            btnD3 = view.findViewById(R.id.linearView3);
            btnD4 = view.findViewById(R.id.linearView4);
            tv1 = view.findViewById(R.id.textTitle);
            tv2 = view.findViewById(R.id.textTitle2);
            tv3 = view.findViewById(R.id.textTitle3);
            tv4 = view.findViewById(R.id.textTitle4);
            btnD1.setOnClickListener(this::onClick);
            btnD2.setOnClickListener(this::onClick);
            btnD3.setOnClickListener(this::onClick);
            btnD4.setOnClickListener(this::onClick);
        }

        updateImages(30);

        timer = new Timer();
        timer.schedule(
                new TimerTask() {

                    @Override
                    public void run() {
                        if (time > 0) {
                            time--;
                            getActivity().runOnUiThread(() -> {
                                text.setText("время: " + time);
                            });
                        } else {
                            getActivity().runOnUiThread(() -> {
                                if (TextUtils.equals("Opening", getArguments().getString("byType")))
                                    player.stop();
                                AlertDialog.Builder builder = new AlertDialog.Builder(getContext())
                                        .setMessage("Время вышло, ваш счет: " + counter)
                                        .setTitle("Конец игры")
                                        //.setCanceledOnTouchOutside(false).
                                        .setNegativeButton("выйти", (dialog, which) -> {
                                            Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(R.id.mainFragment);
                                }).setPositiveButton("играть снова", (dialog, which) -> {
                                    Bundle bundle = new Bundle();
                                    bundle.putString("byType", getArguments().getString("byType"));
                                    Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(R.id.quizFragment, bundle);
                                });
                                AlertDialog dialog = builder.create();
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.show();
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
            count.setText("счет: " + counter);
        }
        updateImages(time);
    }

    private void updateImages(int time) {

        this.time = time;

        QuizData.Title[] all = Arrays.copyOf(data.getTitles(), data.getTitles().length);
        List titlesAll = Arrays.asList(all);
        Collections.shuffle(titlesAll);
        List titlesQuiz = titlesAll.subList(0, 4);

        btnOp1.setTag(titlesQuiz.get(0));
        btnOp2.setTag(titlesQuiz.get(1));
        btnOp3.setTag(titlesQuiz.get(2));
        btnOp4.setTag(titlesQuiz.get(3));

        if (TextUtils.equals("Description", getArguments().getString("byType"))) {
            btnD1.setTag(titlesQuiz.get(0));
            btnD2.setTag(titlesQuiz.get(1));
            btnD3.setTag(titlesQuiz.get(2));
            btnD4.setTag(titlesQuiz.get(3));

            tv1.setText(((QuizData.Title)btnD1.getTag()).getTitle());
            tv2.setText(((QuizData.Title)btnD2.getTag()).getTitle());
            tv3.setText(((QuizData.Title)btnD3.getTag()).getTitle());
            tv4.setText(((QuizData.Title)btnD4.getTag()).getTitle());
        }

        btnOp1.setImageResource(((QuizData.Title)btnOp1.getTag()).getImage());
        btnOp2.setImageResource(((QuizData.Title)btnOp2.getTag()).getImage());
        btnOp3.setImageResource(((QuizData.Title)btnOp3.getTag()).getImage());
        btnOp4.setImageResource(((QuizData.Title)btnOp4.getTag()).getImage());

        int i = random.nextInt(4);
        if (0 == i)
            answer = ((QuizData.Title)btnOp1.getTag()).getId();
        if (1 == i)
            answer = ((QuizData.Title)btnOp2.getTag()).getId();
        if (2 == i)
            answer = ((QuizData.Title)btnOp3.getTag()).getId();
        if (3 == i)
            answer = ((QuizData.Title)btnOp4.getTag()).getId();

        if (TextUtils.equals("Opening", getArguments().getString("byType"))) {
            player = MediaPlayer.create(getContext(), Uri.parse(data.getByIndex(answer).getOpening()));
            player.start();
        }
        if (TextUtils.equals("Description", getArguments().getString("byType"))) {
            description.setText(data.getByIndex(answer).getDescription());
        }
    }
}