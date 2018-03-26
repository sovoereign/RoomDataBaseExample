package workholics.com.myroomdemo.DB.appdata;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import workholics.com.myroomdemo.DB.dao.DeveloperDOA;
import workholics.com.myroomdemo.DB.dao.SalaryDAO;
import workholics.com.myroomdemo.DB.entity.Developer;
import workholics.com.myroomdemo.DB.entity.Salary;

/**
 * Created by fdc10 on 2/21/2018.
 */
@Database(entities = {Developer.class, Salary.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public static AppDatabase getINSTANCE(Context context) {

        if (INSTANCE == null) {

            INSTANCE = Room.inMemoryDatabaseBuilder(context.getApplicationContext(), AppDatabase.class)
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }

    public static void destroyAppData() {
        INSTANCE = null;
    }

    public abstract DeveloperDOA developer();

    public abstract SalaryDAO salary();

}
