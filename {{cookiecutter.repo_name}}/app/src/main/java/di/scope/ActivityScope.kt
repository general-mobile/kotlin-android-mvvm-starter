package {{ cookiecutter.package_name }}.di.scope

import javax.inject.Scope
import kotlin.annotation.Retention;


@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScope