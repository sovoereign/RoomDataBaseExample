package workholics.com.myroomdemo.DB.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.Date;

/**
 * Created by fdc10 on 2/21/2018.
 */

@Entity(foreignKeys = {@ForeignKey(entity = Developer.class, parentColumns = "id", childColumns = "developer_id")})
public class Salary {

    @PrimaryKey
    @NonNull
    public String id;

    public String salary;

    //public Date date;

    @ColumnInfo(name = "developer_id")
    public String developer_id;


}
