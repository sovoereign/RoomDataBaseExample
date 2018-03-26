package workholics.com.myroomdemo.DB;

import android.os.AsyncTask;
import android.support.annotation.NonNull;

import java.util.Calendar;
import java.util.Date;

import workholics.com.myroomdemo.DB.appdata.AppDatabase;
import workholics.com.myroomdemo.DB.entity.Developer;
import workholics.com.myroomdemo.DB.entity.Salary;

/**
 * Created by fdc10 on 2/21/2018.
 */

public class DataBaseIntilizer {

    private static final int DELAY_MILLIS = 500;

    public static void populateAsync(final AppDatabase db) {

        PopulateDbAsync task = new PopulateDbAsync(db);
        task.execute();
    }
    public static void populateSync(@NonNull final AppDatabase db) {
        populateWithTestData(db);
    }

    private static Date getTodayPlusDays(int daysAgo) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, daysAgo);
        return calendar.getTime();
    }


    private static Developer addDeveloper(final AppDatabase db, final String id, final String name, final String designation) {

        Developer developer = new Developer();
        developer.id = id;
        developer.name = name;
        developer.designation = designation;
        db.developer().insertDeveloper(developer);

        return developer;
    }

    private static Salary addSalary(final AppDatabase db, final String id, final String salary, final String developer_id, final Date date) {

        Salary salary1 = new Salary();
        salary1.id = id;
        salary1.salary = salary;
        //salary1.date = date;
        salary1.developer_id = developer_id;
        db.salary().insertSalary(salary1);

        return salary1;
    }


    private static void populateWithTestData(AppDatabase db) {
        db.developer().deleteAllDeveloper();
        db.salary().deletAllSalaryRecord();

        addDeveloper(db, "1", "Prabhat Yadav", "Senior Android Developer");
        addDeveloper(db, "2", "Sourabh Sharma", "Junior Android Developer");
        addDeveloper(db, "3", "Farhana Naaz Ansari", "Junior Android Developer");


        addSalary(db, "1", "30000", "1", getTodayPlusDays(0));
        addSalary(db, "2", "8000", "2", getTodayPlusDays(1));
        addSalary(db, "3", "10000", "3", getTodayPlusDays(2));


    }





    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {


        private final AppDatabase db;

        PopulateDbAsync(AppDatabase db) {
            this.db = db;

        }

        @Override
        protected Void doInBackground(Void... voids) {

            populateWithTestData(db);
            return null;
        }


    }
}
