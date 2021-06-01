package sg.edu.rp.c346.id20037987.democontextmenutranslation2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvTranslatedText;
    TextView tvTranslatedText2;

    String wordClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTranslatedText = findViewById(R.id.textViewTranslated1);
        tvTranslatedText2 = findViewById(R.id.textViewTranslated2);

        registerForContextMenu(tvTranslatedText);
        registerForContextMenu(tvTranslatedText2);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if (v == tvTranslatedText) {
            wordClicked = "1st";
        } else if (v == tvTranslatedText2) {
            wordClicked = "2nd";
        }
        menu.setHeaderTitle(wordClicked + " row is clicked");

        // Inflate the menu; the menu is in menu_main where we have added the menu items rather than adding menu one by one like in demoContentMenuTranslation
        getMenuInflater().inflate(R.menu.menu_main, menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(wordClicked.equalsIgnoreCase("1st")) {
            if (item.getItemId() == R.id.EnglishSelection) { //check whether the selected menu item ID is EnglishSelection
                //code for action
                //Toast.makeText(MainActivity.this, "English is chosen", Toast.LENGTH_SHORT).show();
                tvTranslatedText.setText("Hello");

                return true; //menu item successfully handled
            } else if (item.getItemId() == R.id.italianSelection) { //check if the selected menu item ID is italianSelection
                //code for action
                //Toast.makeText(MainActivity.this, "Italian is chosen", Toast.LENGTH_SHORT).show();
                tvTranslatedText.setText("Ciao");

                return true;  //menu item successfully handled
            }
        }

        if(wordClicked.equalsIgnoreCase("2nd")) {
            if (item.getItemId() == R.id.EnglishSelection) { //check whether the selected menu item ID is EnglishSelection
                //code for action
                //Toast.makeText(MainActivity.this, "English is chosen", Toast.LENGTH_SHORT).show();
                tvTranslatedText2.setText("Bye");

                return true; //menu item successfully handled
            } else if (item.getItemId() == R.id.italianSelection) { //check if the selected menu item ID is italianSelection
                //code for action
                //Toast.makeText(MainActivity.this, "Italian is chosen", Toast.LENGTH_SHORT).show();
                tvTranslatedText2.setText("Addio");

                return true;  //menu item successfully handled
            }
        }
        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }


}