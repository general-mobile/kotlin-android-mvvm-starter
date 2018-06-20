package {{ cookiecutter.package_name }}.core

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.content.Context

open class BaseViewModel(app: Application) : AndroidViewModel(app) {



    fun onDestroy(context: Context?) {

    }

    fun onStop(context: Context?) {

    }
}
