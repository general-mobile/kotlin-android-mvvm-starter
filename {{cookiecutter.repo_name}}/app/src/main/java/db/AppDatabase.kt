package {{ cookiecutter.package_name }}.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import {{ cookiecutter.package_name }}.db.dao.ExampleDao
import {{ cookiecutter.package_name }}.db.entities.Example

@Database(entities = arrayOf(Example::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun exampleDao(): ExampleDao
}