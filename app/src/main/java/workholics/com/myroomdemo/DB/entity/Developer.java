package workholics.com.myroomdemo.DB.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by fdc10 on 2/21/2018.
 */

@Entity
public class Developer {

    @PrimaryKey
    @NonNull
    public String id;

    public String name;

    public String designation;


}
