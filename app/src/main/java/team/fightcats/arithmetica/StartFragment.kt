package team.fightcats.arithmetica

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation

class StartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_start, container, false)
        val btnLayout = rootView.findViewById<View>(R.id.start_btn_layout)
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
        val navController = Navigation.findNavController(view)

        view.findViewById<View>(R.id.start_btn).setOnClickListener {
            navController.navigate(R.id.action_startFragment_to_gameFragment)
        }
    }
}
