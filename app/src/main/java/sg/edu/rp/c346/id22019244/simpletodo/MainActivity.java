package sg.edu.rp.c346.id22019244.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText input;
    Button btnAdd;
    Button btnClear;
    Button btnDelete;
    ListView taskList;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.Input);
        btnAdd = findViewById(R.id.btnAdd);
        btnClear = findViewById(R.id.btnClear);
        taskList = findViewById(R.id.taskList);
        spinner = findViewById(R.id.spinner);
        btnDelete = findViewById(R.id.btnDelete);

        ArrayList<String> alTasks;
        alTasks = new ArrayList<>();

        ArrayAdapter aaTasks = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alTasks);
        taskList.setAdapter(aaTasks);





        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position){
                    case 0 :
                        btnAdd.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                if (input.toString() != ""){
                                    alTasks.add(input.getText().toString());
                                    aaTasks.notifyDataSetChanged();

                                } else {
                                    Toast.makeText(MainActivity.this, "Please fill up all values to continue", Toast.LENGTH_SHORT).show();
                                }


                            }
                        });
                        btnClear.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                if (input.toString() != ""){
                                    alTasks.clear();
                                    aaTasks.notifyDataSetChanged();

                                } else {
                                    Toast.makeText(MainActivity.this, "Please fill up all values to continue", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });
                        break;
                    case 1 :
                        btnDelete.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                alTasks.remove(Integer.parseInt(input.getText().toString()));
                                aaTasks.notifyDataSetChanged();
                            }
                        });
                        btnClear.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                if (input.toString() != ""){
                                    alTasks.clear();
                                    aaTasks.notifyDataSetChanged();

                                } else {
                                    Toast.makeText(MainActivity.this, "Please fill up all values to continue", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });


                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}