package workholics.com.myroomdemo.DB.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;

import java.util.Date;
import java.util.List;

import workholics.com.myroomdemo.DB.dbutil.DateConverter;
import workholics.com.myroomdemo.DB.entity.Developer;
import workholics.com.myroomdemo.DB.entity.Salary;
import workholics.com.myroomdemo.DB.entity.SalaryWithName;

import static android.arch.persistence.room.OnConflictStrategy.IGNORE;

/**
 * Created by fdc10 on 2/21/2018.
 */

@Dao
@TypeConverters(DateConverter.class)
public interface SalaryDAO {

    @Query("SELECT * FROM Salary")
    List<Salary> getAllSalaryList();

    @Query("DELETE FROM Salary")
    void deletAllSalaryRecord();

    @Query("SELECT * FROM Salary Where salary=:salary")
    Salary recordBySalary(String salary);

    @Query("SELECT * FROM Salary Where developer_id=:developer_id")
    Salary salaryrecordByDeveloperId(String developer_id);

    @Insert(onConflict = IGNORE)
    void insertSalary(Salary salary);



    @Query("SELECT Developer.id, Salary.salary, Developer.name, Developer.designation From Salary "+
            "INNER JOIN Developer ON Salary.developer_id = Developer.id "+
    "WHERE Salary.id=:id")
    SalaryWithName getParticularDeveloper(String id );


}
