package com.example.brianvelosofioretti.TapFruit

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_ventana1.*


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [fragmentventana1.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [fragmentventana1.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragmentventana1 : Fragment() {





//primero inflamos la vista


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_ventana1, container, false)


    }
// ahora una vez inflada la vista llamamos al intent
    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    //catch player name
        button.setOnClickListener {

            /**
             * datos entre activitys con companion object
             */
            fragmentVentana2.player=name.text.toString()
            val intent = Intent(context, Main2Activity::class.java)
            startActivity(intent);






        }
}




}

