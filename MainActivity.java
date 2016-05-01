package tara.example.com.rankinglist;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private int [] colorButtons = {R.id.buttonRed, R.id.buttonYellow, R.id.buttonGreen};
    private ArrayList<String> list = new ArrayList<>();
    String item ;
    String date;
    TextView listView;
    private void updateScreenTextView()
    {
//        listView.equals(list);
//        for(String things: list)
//        {
//            System.out.println(things);
//        }
        /// [ hello, world]
        // "hello\nworld\n"
        String txt = "\t";
        for (String ele: list) {
            txt += ele;
            txt += "\n\t";
        }

        listView.setText(txt);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        item = ((EditText)findViewById(R.id.editText)).getText().toString();
        date = ((EditText)findViewById(R.id.editText2)).getText().toString();
        listView = (TextView) findViewById(R.id.textView);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

       ColorButtonListener colorButtonListener = new ColorButtonListener();
        for (int id : colorButtons)
        {
            findViewById(id).setOnClickListener(colorButtonListener);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ranking_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class ColorButtonListener implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
           // update what is in text fields
            item = ((EditText)findViewById(R.id.editText)).getText().toString();
            date = ((EditText)findViewById(R.id.editText2)).getText().toString();

            if(v.getId() == R.id.buttonRed && item != "") {
                list.add(item + "\t " + date + "\t\tSuper Important!");
                updateScreenTextView();

            }

            else if(v.getId() == R.id.buttonYellow && item != "") {
                list.add(item + "\t " + date + "\t\tDo it soon.");

                updateScreenTextView();
            }

            else if(v.getId() == R.id.buttonGreen && item != "") {
                list.add(item + "\t " + date + "\t\tTake your time.");

                updateScreenTextView();
            }

        }

    }


}

