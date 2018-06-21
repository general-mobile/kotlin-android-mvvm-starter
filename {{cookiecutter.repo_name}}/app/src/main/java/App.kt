package {{ cookiecutter.package_name }}

import {{ cookiecutter.package_name }}.di.component.DaggerApplicationComponent
import {{ cookiecutter.package_name }}.di.module.ApplicationModule

class App : android.app.Application() {

    val component by lazy {
        DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }
}

