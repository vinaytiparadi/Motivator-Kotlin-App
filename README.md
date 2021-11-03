# Motivator-Kotlin-App
A simple app written in Kotlin to explore linear layout and lifecycle methods.


Add these methods in main activity to understand how lifecyle method works.

    override fun onStart() {
        super.onStart()
        Log.i("test","onStart() initiated, moving to onResume().")
    }

    override fun onResume() {
        super.onResume()
        Log.i("test","onResume(), waiting for onPause()")
    }

    override fun onPause() {
        super.onPause()
        Log.i("test","onPause() initiated, waiting for onStop() or onResume().")
    }

    override fun onStop() {
        super.onStop()
        Log.i("test","onStop() initiated, waiting for onDestroy() or onRestart().")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("test","onRestart() initiated, moving to onStart().")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("test","onDestroy() initiated, the app is killed! :/")
    }
