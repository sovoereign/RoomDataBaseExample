package workholics.com.myroomdemo.DB.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import workholics.com.myroomdemo.DB.entity.Developer;

import static android.arch.persistence.room.OnConflictStrategy.IGNORE;

/**
 * Created by fdc10 on 2/21/2018.
 */

@Dao
public interface DeveloperDOA {

    @Insert(onConflict = IGNORE)
    void insertDeveloper(Developer developer);

    @Query("SELECT * FROM Developer")
    List<Developer> getDeveloperList();

    @Query("DELETE FROM Developer")
    void deleteAllDeveloper();

    @Query("SELECT * FROM Developer where id=:id")
    Developer getDeveloperRecord(String id);

    @Query("SELECT * FROM Developer where name=:name")
    Developer getDeveloperByName(String name);


}
