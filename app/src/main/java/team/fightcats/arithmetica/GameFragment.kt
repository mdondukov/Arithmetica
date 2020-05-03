package team.fightcats.arithmetica

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation

class GameFragment : Fragment() {
    private lateinit var mNavController: NavController
    private lateinit var mAnswer0Btn: Button
    private lateinit var mAnswer1Btn: Button
    private lateinit var mAnswer2Btn: Button
    private lateinit var mAnswer3Btn: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_game, container, false)
        val btnLayout = rootView.findViewById<View>(R.id.game_btn_layout)
        ViewCompat.setOnApplyWindowInsetsListener(
            btnLayout
        ) { _: View?, insets: WindowInsetsCompat ->
            btnLayout.setPadding(0, 0, 0, insets.systemWindowInsetBottom)
            insets
        }
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mNavController = Navigation.findNavController(view)
        initViews(view)

        mAnswer0Btn.setOnClickListener {
            startEndFragment()
        }

        mAnswer1Btn.setOnClickListener {
            startEndFragment()
        }

        mAnswer2Btn.setOnClickListener {
            startEndFragment()
        }

        mAnswer3Btn.setOnClickListener {
            startEndFragment()
        }
    }

    private fun initViews(view: View) {
        mAnswer0Btn = view.findViewById(R.id.answer_0_btn)
        mAnswer1Btn = view.findViewById(R.id.answer_1_btn)
        mAnswer2Btn = view.findViewById(R.id.answer_2_btn)
        mAnswer3Btn = view.findViewById(R.id.answer_3_btn)
    }

    private fun startEndFragment() {
        mNavController.navigate(R.id.action_gameFragment_to_endFragment)
    }
}
