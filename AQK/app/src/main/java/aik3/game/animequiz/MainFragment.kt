package aik3.game.animequiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    requireActivity().moveTaskToBack(true)
                    requireActivity().finish()
                }
            }
        )
        view.findViewById<Button>(R.id.btnByOpening)
            .setOnClickListener(Navigation.createNavigateOnClickListener(
                R.id.quizFragment,
                setBundle(1)))
        view.findViewById<Button>(R.id.btnByDescription)
            .setOnClickListener(Navigation.createNavigateOnClickListener(
                R.id.quizFragment,
                setBundle(2)))
        view.findViewById<Button>(R.id.btnByEnding)
            .setOnClickListener(Navigation.createNavigateOnClickListener(
                R.id.quizFragment,
                setBundle(3)))
        return view
    }

    private fun setBundle(type: Int): Bundle {
        val bundle = Bundle()
        if (1 == type) bundle.putString("byType", "Opening")
        if (2 == type) bundle.putString("byType", "Description")
        if (3 == type) bundle.putString("byType", "Ending")
        return bundle
    }
}