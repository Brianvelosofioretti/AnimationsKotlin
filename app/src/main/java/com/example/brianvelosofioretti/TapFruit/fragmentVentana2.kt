package com.example.brianvelosofioretti.TapFruit

import android.animation.Animator
import android.animation.ObjectAnimator
import android.media.MediaPlayer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_ventana2.*
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch

import kotlin.coroutines.experimental.CoroutineContext

class fragmentVentana2 : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_ventana2, container, false)


    }


    private val uiContext: CoroutineContext = UI

    var j: Int = 1

    var time: Long = 0
    var invisible: Long = 0

    var Job: Job? = null
    var puntuacion = 0

    val random = LongArray(5)
    val start = LongArray(4)
    lateinit var mp:MediaPlayer
    lateinit var mp2:MediaPlayer

    var objectAnimator = ObjectAnimator.ofFloat()
    var objectAnimator2 = ObjectAnimator.ofFloat()
    var objectAnimator3 = ObjectAnimator.ofFloat()
    var objectAnimator4 = ObjectAnimator.ofFloat()
    var objectAnimator5 = ObjectAnimator.ofFloat()


    override fun onStart() {
        super.onStart()
        //sounds
        mp = MediaPlayer.create(this.activity, R.raw.sonido)
        mp2 = MediaPlayer.create(this.activity, R.raw.error)
        //Invisible images
        circulo.visibility = View.INVISIBLE
        circulo2.visibility = View.INVISIBLE
        circulo3.visibility = View.INVISIBLE
        circulo4.visibility = View.INVISIBLE
        circulo5.visibility = View.INVISIBLE

//start game
        launchGame()
        click()


    }


    //iniciamos anicaciones
    private fun launchGame() {

        val task = launch(uiContext) {
            for (i in 0..3) {
                time = (Math.random() * 1000 + 200).toLong()
                start[i] = time
            }

            primero()
            delay(start[0])
            segundo()
            delay(start[1])
            tercero()
            delay(start[2])
            cuarto()
            delay(start[3])
            quinto()

        }

        task.start()

    }
    //sample score
    private fun setPoints() { puntos.setText(player + " tienes : " + puntuacion + " puntos") }


    private fun click() {


        val task = launch(uiContext) {

//time to show objects
            for (i in 0..4) {
                invisible = (Math.random() * 3000 + 500).toLong()
                random[i] = invisible
            }


            circulo.setOnClickListener() {
                mp.start()

                //eliminamos animacion
                objectAnimator.end()
                //establecemos delay para reaparicion
                objectAnimator.startDelay = random[0]
                //lanzamos de nuevo la animacion
                objectAnimator.start()
                //modificamos velocidad
                objectAnimator.duration-=150


            }

            circulo2.setOnClickListener() {
                mp.start()
                objectAnimator2.end()
                objectAnimator2.startDelay = random[1]
                objectAnimator2.start()
                objectAnimator2.duration-=150

            }
            circulo3.setOnClickListener() {
                mp.start()
                objectAnimator3.end()
                objectAnimator3.startDelay = random[2]
                objectAnimator3.start()
                objectAnimator3.duration-=150

            }
            circulo4.setOnClickListener() {
                mp.start()
                objectAnimator4.end()
                objectAnimator4.startDelay = random[3]
                objectAnimator4.start()
                objectAnimator4.duration-=150

            }

            circulo5.setOnClickListener() {
                mp.start()
                objectAnimator5.end()
                objectAnimator5.startDelay = random[4]
                objectAnimator5.start()
                objectAnimator5.duration-=150

            }
        }
        Job = task
        task.start()
    }


    private fun primero() {

        circulo.visibility = View.VISIBLE

        val task = launch(uiContext) {
            // iniciamos  hilo padre

            objectAnimator = ObjectAnimator.ofFloat(
                    circulo,
                    "translationY",
                    2260f * j)//distancia a recorrer de x a 1 o -1
            //duracion de animacion
            objectAnimator.duration = 5000L //duracion de desplazamiento
            objectAnimator.interpolator //suavidad de la imagen
            objectAnimator.start()
            objectAnimator.setRepeatCount(ObjectAnimator.INFINITE);//reinciamos la animacion al llegar al final

            objectAnimator.addListener(object : Animator.AnimatorListener {
                override fun onAnimationCancel(animation: Animator?) {}

                override fun onAnimationStart(animation: Animator?) {}

                override fun onAnimationRepeat(animation: Animator?) {
                    mp2.start()
                    puntuacion--
                    setPoints()
                    Toast.makeText(this@fragmentVentana2.context, "ups!", Toast.LENGTH_SHORT)
                            .show()

                }

                override fun onAnimationEnd(animation: Animator) {
                    puntuacion++
                    setPoints()
                }
            })
        }
        Job = task
        task.start()
    }


    private fun segundo() {
        circulo2.visibility = View.VISIBLE

        val task = launch(uiContext) {

            objectAnimator2 = ObjectAnimator.ofFloat(
                    circulo2,
                    "translationY",
                    2260f * j)
            objectAnimator2.duration = 5000L
            objectAnimator2.interpolator
            objectAnimator2.start()
            objectAnimator2.setRepeatCount(ObjectAnimator.INFINITE);

            objectAnimator2.addListener(object : Animator.AnimatorListener {
                override fun onAnimationCancel(animation: Animator?) {}

                override fun onAnimationStart(animation: Animator?) {}

                override fun onAnimationRepeat(animation: Animator?) {
                    mp2.start()
                    puntuacion--
                    setPoints()
                    Toast.makeText(this@fragmentVentana2.context, "ups!", Toast.LENGTH_SHORT)
                            .show()
                }

                override fun onAnimationEnd(animation: Animator) {
                    puntuacion++
                    setPoints()
                }
            })
        }
        Job = task
        task.start()
    }


    private fun tercero() {

        circulo3.visibility = View.VISIBLE
        val task = launch(uiContext) {

            objectAnimator3 = ObjectAnimator.ofFloat(
                    circulo3,
                    "translationY",
                    2260f * j)
            objectAnimator3.duration = 5000L
            objectAnimator3.interpolator
            objectAnimator3.start()
            objectAnimator3.setRepeatCount(ObjectAnimator.INFINITE);

            objectAnimator3.addListener(object : Animator.AnimatorListener {
                override fun onAnimationCancel(animation: Animator?) {}

                override fun onAnimationStart(animation: Animator?) {}

                override fun onAnimationRepeat(animation: Animator?) {
                    mp2.start()
                    puntuacion--
                    setPoints()
                    Toast.makeText(this@fragmentVentana2.context, "vamos vamos!!", Toast.LENGTH_SHORT)
                            .show()

                }

                override fun onAnimationEnd(animation: Animator) {
                    puntuacion++
                    setPoints()
                }
            })
        }
        Job = task//stop thread
        task.start()
    }


    private fun cuarto() {
        circulo4.visibility = View.VISIBLE

        val task = launch(uiContext) {

            objectAnimator4 = ObjectAnimator.ofFloat(
                    circulo4,
                    "translationY",
                    2260f * j)
            objectAnimator4.duration = 5000L
            objectAnimator4.interpolator
            objectAnimator4.start()
            objectAnimator4.setRepeatCount(ObjectAnimator.INFINITE);

            objectAnimator4.addListener(object : Animator.AnimatorListener {
                override fun onAnimationCancel(animation: Animator?) {}

                override fun onAnimationStart(animation: Animator?) {}

                override fun onAnimationRepeat(animation: Animator?) {
                    mp2.start()
                    puntuacion--
                    setPoints()
                    Toast.makeText(this@fragmentVentana2.context, "No estas preparado!", Toast.LENGTH_SHORT)
                            .show()


                }

                override fun onAnimationEnd(animation: Animator) {
                    puntuacion++
                    setPoints()
                }
            })

        }
        Job = task
        task.start()
    }


    private fun quinto() {
        circulo5.visibility = View.VISIBLE

        val task = launch(uiContext) {

            objectAnimator5 = ObjectAnimator.ofFloat(
                    circulo5,
                    "translationY",
                    2260f * j)//movimiento y
            objectAnimator5.duration = 5000L
            objectAnimator5.interpolator
            objectAnimator5.start()
            objectAnimator5.setRepeatCount(ObjectAnimator.INFINITE);

            objectAnimator5.addListener(object : Animator.AnimatorListener {
                override fun onAnimationCancel(animation: Animator?) {}

                override fun onAnimationStart(animation: Animator?) {}

                override fun onAnimationRepeat(animation: Animator?) {
                    mp2.start()
                    puntuacion--
                    setPoints()
                    Toast.makeText(this@fragmentVentana2.context, "Mejor dejalo por hoy!", Toast.LENGTH_SHORT)
                            .show()



                }

                override fun onAnimationEnd(animation: Animator) {
                    puntuacion++
                    setPoints()
                }
            })

        }
        Job = task
        task.start()
    }


    //create static variable and methods
    companion object recibe {
        //recive name from fragment1
        var player = "jugador"

    }


}










