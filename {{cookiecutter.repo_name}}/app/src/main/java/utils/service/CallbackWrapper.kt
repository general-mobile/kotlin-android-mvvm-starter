package {{ cookiecutter.package_name }}.utils.service

import android.app.Application
import io.reactivex.observers.DisposableObserver
import retrofit2.HttpException
import java.io.IOException
import java.lang.ref.WeakReference
import java.net.SocketTimeoutException
import java.net.UnknownHostException

abstract class CallbackWrapper<T : Any>(application: Application) : DisposableObserver<T>() {
    var weakReference: WeakReference<Application>? = WeakReference(application)
    protected abstract fun onSuccess(t: T)
    override fun onNext(t: T) {
        onSuccess(t)
    }

    override fun onError(e: Throwable) {
        if (e is HttpException) {
        } else if (e is SocketTimeoutException) {
        } else if (e is UnknownHostException) {
        } else if (e is IOException) {
        } else {
        }
    }

    override fun onComplete() {
    }
}