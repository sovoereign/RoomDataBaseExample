package workholics.com.myroomdemo.DB.entity;

import android.arch.persistence.room.ColumnInfo;

/**
 * Created by fdc10 on 2/21/2018.
 */

public class SalaryWithName {


    public String id;

    @ColumnInfo(name = "salary")
    public String salary;

    @ColumnInfo(name = "name")
    public String developer_name;

    @ColumnInfo(name = "designation")
    public String designation;

}
