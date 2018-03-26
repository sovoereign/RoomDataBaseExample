package workholics.com.myroomdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.List;

import workholics.com.myroomdemo.DB.DataBaseIntilizer;
import workholics.com.myroomdemo.DB.appdata.AppDatabase;
import workholics.com.myroomdemo.DB.entity.Developer;
import workholics.com.myroomdemo.DB.entity.Salary;
import workholics.com.myroomdemo.DB.entity.SalaryWithName;


public class MainActivity extends AppCompatActivity {

    TextView tv_developer1, tv_developer2, tv_developer3, tv_developer_by_id, tv_developer_by_name;
    TextView tv_salary, tv_particular_salary,tv_particular_salary_developer_id,tv_particular_salary_developer_name;
    private AppDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDb = AppDatabase.getINSTANCE(getApplicationContext());
        tv_developer1 = (TextView) findViewById(R.id.tv_developer1);
        tv_developer2 = (TextView) findViewById(R.id.tv_developer2);
        tv_developer3 = (TextView) findViewById(R.id.tv_developer3);
        tv_developer_by_id = (TextView) findViewById(R.id.tv_developer_by_id);
        tv_developer_by_name = (TextView) findViewById(R.id.tv_developer_by_name);
        tv_salary = (TextView) findViewById(R.id.tv_salary);
        tv_particular_salary = (TextView) findViewById(R.id.tv_particular_salary);
        tv_particular_salary_developer_id=(TextView)findViewById(R.id.tv_particular_salary_developer_id);
        tv_particular_salary_developer_name=(TextView)findViewById(R.id.tv_particular_salary_developer_name);
        populateDb();
        fetchData();
        getDeveloperById();
        getDeveloperByName();
        fetchSalaryData();
        fetchSpecificSalary();
        fetchSpecificSalary_developer_id();
        fetchSpecificSalary_name();
    }

    private void populateDb() {
        DataBaseIntilizer.populateSync(mDb);
    }

    private void fetchData() {
        // Note: this kind of logic should not be in an activity.
        StringBuilder sb = new StringBuilder();
        List<Developer> developers = mDb.developer().getDeveloperList();

        tv_developer1.setText("Id: " + developers.get(0).id + "\nName: "
                + developers.get(0).name + "\nDesignation: " + developers.get(0).designation);
        tv_developer2.setText("Id: " + developers.get(1).id + "\nName: "
                + developers.get(1).name + "\nDesignation: " + developers.get(1).designation);
        tv_developer3.setText("Id: " + developers.get(2).id + "\nName: "
                + developers.get(2).name + "\nDesignation: " + developers.get(2).designation);
    }

    private void getDeveloperById() {
        // Note: this kind of logic should not be in an activity.
        StringBuilder sb = new StringBuilder();
        Developer developers = mDb.developer().getDeveloperRecord("1");

        tv_developer_by_id.setText("Developer By Id \n Id: " + developers.id + "\nName: "
                + developers.name + "\nDesignation: " + developers.designation);

    }

    private void getDeveloperByName() {
        // Note: this kind of logic should not be in an activity.
        Developer developers = mDb.developer().getDeveloperByName("Farhana Naaz Ansari");

        tv_developer_by_name.setText("Developer By Id \n Id: " + developers.id + "\nName: "
                + developers.name + "\nDesignation: " + developers.designation);

    }

    private void fetchSalaryData() {
        // Note: this kind of logic should not be in an activity.

        List<Salary> salaries = mDb.salary().getAllSalaryList();

        tv_salary.setText("Id: " + salaries.get(0).id + "\nSalary: "
                + salaries.get(0).salary + "\nDeveloper Id: " + salaries.get(0).developer_id +
                "\n\n" + "Id: " + salaries.get(1).id + "\nSalary: "
                + salaries.get(1).salary + "\nDeveloper Id: " + salaries.get(1).developer_id +
                "\n\n" + "Id: " + salaries.get(2).id + "\nSalary: "
                + salaries.get(2).salary + "\nDeveloper Id: " + salaries.get(2).developer_id);

    }

    private void fetchSpecificSalary() {
        // Note: this kind of logic should not be in an activity.

        Salary salaries = mDb.salary().recordBySalary("8000");

        tv_particular_salary.setText("Id: " + salaries.id + "\nSalary: "
                + salaries.salary + "\nDeveloper Id: " + salaries.developer_id
        );
    }

    private void fetchSpecificSalary_developer_id() {
        // Note: this kind of logic should not be in an activity.

        Salary salaries = mDb.salary().salaryrecordByDeveloperId("3");

        tv_particular_salary_developer_id.setText("Id: " + salaries.id + "\nSalary: "
                + salaries.salary + "\nDeveloper Id: " + salaries.developer_id
        );

    }

    private void fetchSpecificSalary_name() {
        // Note: this kind of logic should not be in an activity.

        SalaryWithName salaries = mDb.salary().getParticularDeveloper("3");

        tv_particular_salary_developer_name.setText("Id: " + salaries.id + "\nSalary: "
                + salaries.salary + "\nDeveloper Id: " + salaries.developer_name
        );

    }
}
