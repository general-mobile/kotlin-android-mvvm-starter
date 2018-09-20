package {{ cookiecutter.package_name }}.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import {{ cookiecutter.package_name }}.db.entities.Example

@Dao
interface ExampleDao {

    @Query("SELECT * FROM Example")
    fun getExamples(): LiveData<List<Example>>

    @Query("SELECT * FROM Example where id = :exampleId")
    fun getExample(exampleId: Long): Example

    @Insert(onConflict = REPLACE)
    fun insertExample(example: Example)

    @Update
    fun updateExample(example: Example)

    @Delete
    fun deleteExample(example: Example)

    @Query("Select count(*) from Example")
    fun getCount(): Int

}