package {{ cookiecutter.package_name }}.core

import android.app.Application
import androidx.lifecycle.AndroidViewModel

open class BaseViewModel(app: Application) : AndroidViewModel(app)
