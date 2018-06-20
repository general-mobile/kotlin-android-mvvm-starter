package {{ cookiecutter.package_name }}.di.component

import android.content.Context
import android.content.SharedPreferences
import {{ cookiecutter.package_name }}.App
import {{ cookiecutter.package_name }}.di.module.ApplicationModule
import {{ cookiecutter.package_name }}.di.module.DatabaseModule
import {{ cookiecutter.package_name }}.ui.main.MainActivityViewModel
{% if cookiecutter.retrofit == "y" %}
import {{ cookiecutter.package_name }}.di.module.NetModule
{% endif %}
import dagger.Component
import javax.inject.Singleton


@Singleton
{% if cookiecutter.retrofit == "y" %}
@Component(modules = arrayOf(ApplicationModule::class,NetModule::class,DatabaseModule::class))
{% endif %}
{% if cookiecutter.retrofit == "n" %}
@Component(modules = arrayOf(ApplicationModule::class,DatabaseModule::class))
{% endif %}
interface ApplicationComponent {
    fun app(): App


    fun context(): Context

    fun preferences(): SharedPreferences

    fun inject(mainActivityViewModel: MainActivityViewModel)
}
