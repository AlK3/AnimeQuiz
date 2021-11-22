package aik3.game.animequiz

import android.content.DialogInterface
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.text.TextUtils
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import java.util.*

class QuizFragment : Fragment(), View.OnClickListener {

    private lateinit var player: MediaPlayer
    private lateinit var count: TextView
    private lateinit var data: QuizData
    private lateinit var timer: Timer
    @Volatile private var time = 0
    private var counter = 0
    private var answer = 0

    private lateinit var btnOp1: ImageView
    private lateinit var btnOp2: ImageView
    private lateinit var btnOp3: ImageView
    private lateinit var btnOp4: ImageView
    private lateinit var btnD1: LinearLayout
    private lateinit var btnD2: LinearLayout
    private lateinit var btnD3: LinearLayout
    private lateinit var btnD4: LinearLayout
    private lateinit var description: TextView
    private lateinit var tv1: TextView
    private lateinit var tv2: TextView
    private lateinit var tv3: TextView
    private lateinit var tv4: TextView
    private val random = Random()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =
            if (TextUtils.equals("Opening", requireArguments().getString("byType"))
                or TextUtils.equals("Ending", requireArguments().getString("byType")))
                inflater.inflate(R.layout.fragment_quiz_op_end, container, false)
            else
                inflater.inflate(R.layout.fragment_quiz_description, container, false)
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    Navigation.findNavController(activity!!, R.id.nav_host_fragment).navigate(R.id.mainFragment)
                }
            }
        )
        val text = view.findViewById<TextView>(R.id.textView)
        count = view.findViewById(R.id.textView3)
        count.text = "счет: $counter"

        data = QuizData()
        btnOp1 = view.findViewById(R.id.imageView)
        btnOp2 = view.findViewById(R.id.imageView2)
        btnOp3 = view.findViewById(R.id.imageView3)
        btnOp4 = view.findViewById(R.id.imageView4)

        if (TextUtils.equals("Opening", requireArguments().getString("byType"))
            or TextUtils.equals("Ending", requireArguments().getString("byType"))) {
            btnOp1.setOnClickListener(this::onClick)
            btnOp2.setOnClickListener(this::onClick)
            btnOp3.setOnClickListener(this::onClick)
            btnOp4.setOnClickListener(this::onClick)
        }

        if (TextUtils.equals("Description", requireArguments().getString("byType"))) {
            description = view.findViewById(R.id.textDescription)
            btnD1 = view.findViewById(R.id.linearView)
            btnD2 = view.findViewById(R.id.linearView2)
            btnD3 = view.findViewById(R.id.linearView3)
            btnD4 = view.findViewById(R.id.linearView4)
            tv1 = view.findViewById(R.id.textTitle)
            tv2 = view.findViewById(R.id.textTitle2)
            tv3 = view.findViewById(R.id.textTitle3)
            tv4 = view.findViewById(R.id.textTitle4)
            btnD1.setOnClickListener(this::onClick)
            btnD2.setOnClickListener(this::onClick)
            btnD3.setOnClickListener(this::onClick)
            btnD4.setOnClickListener(this::onClick)
        }

        updateImages(30)

        timer = Timer()
        timer.schedule(
            object : TimerTask() {
                override fun run() {
                    if (time > 0) {
                        time--
                        activity!!.runOnUiThread { text.text = "время: $time" }
                    } else {
                        activity!!.runOnUiThread {
                            text.text = "время: " + 0
                            if (TextUtils.equals("Opening", arguments!!.getString("byType"))
                                or TextUtils.equals("Ending", arguments!!.getString("byType"))
                            ) player.stop()
                            val builder =
                                AlertDialog.Builder(
                                    context!!
                                )
                                    .setMessage("Время вышло, ваш счет: $counter")
                                    .setTitle("Конец игры") //.setCanceledOnTouchOutside(false).
                                    .setNegativeButton(
                                        "выйти"
                                    ) { _: DialogInterface?, _: Int ->
                                        Navigation.findNavController(
                                            activity!!, R.id.nav_host_fragment
                                        ).navigate(R.id.mainFragment)
                                    }.setPositiveButton(
                                        "играть снова"
                                    ) { _: DialogInterface?, _: Int ->
                                        val bundle = Bundle()
                                        bundle.putString("byType", arguments!!.getString("byType"))
                                        Navigation.findNavController(
                                            activity!!,
                                            R.id.nav_host_fragment
                                        ).navigate(R.id.quizFragment, bundle)
                                    }
                            val dialog = builder.create()
                            dialog.setCanceledOnTouchOutside(false)
                            dialog.show()
                        }
                        cancel()
                    }
                }
            }, 0, 1000
        )

        return view
    }

    override fun onPause() {
        super.onPause()
        if (TextUtils.equals("Opening", requireArguments().getString("byType"))
            or TextUtils.equals("Ending", requireArguments().getString("byType"))
        ) {
            player.stop()
            player.release()
        }
        timer.cancel()
    }

    override fun onClick(v: View?) {
        val title = v!!.tag as QuizData.Title
        if (TextUtils.equals("Opening", requireArguments().getString("byType"))
            or TextUtils.equals("Ending", requireArguments().getString("byType"))
        ) player.stop()
        if (title.id != answer) time -= 5 else {
            time = 30
            counter++
            count.text = "счет: $counter"
        }
        updateImages(time)
    }

    private fun updateImages(time: Int) {
        this.time = time
        val all = Arrays.copyOf(data.getTitles(), data.getTitles().size)
        val titlesAll: List<*> = Arrays.asList(*all)
        Collections.shuffle(titlesAll)
        val titlesQuiz = titlesAll.subList(0, 4)
        btnOp1.tag = titlesQuiz[0]
        btnOp2.tag = titlesQuiz[1]
        btnOp3.tag = titlesQuiz[2]
        btnOp4.tag = titlesQuiz[3]
        if (TextUtils.equals("Description", requireArguments().getString("byType"))) {
            btnD1.tag = titlesQuiz[0]
            btnD2.tag = titlesQuiz[1]
            btnD3.tag = titlesQuiz[2]
            btnD4.tag = titlesQuiz[3]
            tv1.text = (btnD1.tag as QuizData.Title).title
            tv2.text = (btnD2.tag as QuizData.Title).title
            tv3.text = (btnD3.tag as QuizData.Title).title
            tv4.text = (btnD4.tag as QuizData.Title).title
        }
        btnOp1.setImageResource((btnOp1.tag as QuizData.Title).image)
        btnOp2.setImageResource((btnOp2.tag as QuizData.Title).image)
        btnOp3.setImageResource((btnOp3.tag as QuizData.Title).image)
        btnOp4.setImageResource((btnOp4.tag as QuizData.Title).image)
        val i = random.nextInt(4)
        if (0 == i) answer = (btnOp1.tag as QuizData.Title).id
        if (1 == i) answer = (btnOp2.tag as QuizData.Title).id
        if (2 == i) answer = (btnOp3.tag as QuizData.Title).id
        if (3 == i) answer = (btnOp4.tag as QuizData.Title).id
        if (TextUtils.equals("Opening", requireArguments().getString("byType"))) {
            player = MediaPlayer.create(context, Uri.parse(data.getByIndex(answer).opening))
            player.start()
        }
        if (TextUtils.equals("Ending", requireArguments().getString("byType"))) {
            player = MediaPlayer.create(context, Uri.parse(data.getByIndex(answer).ending))
            player.start()
        }
        if (TextUtils.equals("Description", requireArguments().getString("byType"))) {
            description.text = data.getByIndex(answer).description
            description.movementMethod = ScrollingMovementMethod()
        }
    }
}