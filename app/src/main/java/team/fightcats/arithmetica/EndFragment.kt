package team.fightcats.arithmetica

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation

class EndFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_end, container, false)
        val btnLayout = rootView.findViewById<View>(R.id.end_btn_layout)
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
        view.findViewById<View>(R.id.restart_btn).setOnClickListener {
            Navigation.findNavController(view).popBackStack()
        }
    }
}
