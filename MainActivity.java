package mikemeat.admin.moodtracker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;



public class MainActivity extends AppCompatActivity {

    EditText scoreInput;
    EditText categoryInput;
    EditText causeInput;
    TextView buckysText;
    MyDBHandler dbHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        scoreInput = (EditText) findViewById(R.id.scoreInput);
        categoryInput = (EditText) findViewById(R.id.categoryInput);
        causeInput = (EditText) findViewById(R.id.causeInput);
        buckysText = (TextView) findViewById(R.id.outputText);
        dbHandler = new MyDBHandler(this, null, null, 1);

        printDatabase();


    }

    //Add a product to the database
    public void addButtonClicked(View view) {
        scores score = new scores(scoreInput.getText().toString() , causeInput.getText().toString(),  categoryInput.getText().toString()); //creating a new scores object called score.
                                                                    // I'm getting the score input and putting it to string, and adding score to the database
        dbHandler.addScores(score);
        printDatabase();
    }


    //delete items
    public void deleteButtonClicked(View view){
        String inputText = scoreInput.getText().toString();
        dbHandler.deleteScores(inputText);
        printDatabase();
    }


    public void printDatabase(){
        String dbString = dbHandler.databaseToString(); // create a string from the database method
        buckysText.setText(dbString); //
        scoreInput.setText(""); //removes the input text
        causeInput.setText("");
        categoryInput.setText("");

    }

//    public void sendMessage(View view) {
//        Intent intent = new Intent(this, DisplayMessageActivity.class);
//
//        intent.setType("application/octet-stream");
//        intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(scores));
//
//        Intent i = new Intent(Intent.ACTION_SEND);
//        i.putExtra(Intent.EXTRA_EMAIL, new String[]{"recipient@domain.com"});
//        i.putExtra(Intent.EXTRA_SUBJECT, "Subject");
//        i.putExtra(Intent.EXTRA_TEXT, "Some message text");
//        i.setType("application/octet-stream");
//        i.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(scores));
//        startActivity(Intent.createChooser(i, "Send e-mail"));
//    }

}

