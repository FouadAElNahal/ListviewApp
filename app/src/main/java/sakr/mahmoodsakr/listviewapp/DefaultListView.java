package sakr.mahmoodsakr.listviewapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class DefaultListView extends AppCompatActivity {
    String[] stringArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.default_listview);
        ListView lsview = (ListView) findViewById(R.id.listviewid);
        stringArray = new String[]{"A-0", "B-1", "C-2", "D-3", "E-4", "F-5", "G-6", "H-7"};
        ArrayAdapter listviewAdapter = new ArrayAdapter(this, R.layout.custom_text_view, stringArray);
//        ArrayAdapter listviewAdapter = new ArrayAdapter(this, R.layout.custom_text_view, stringArray);
//        ArrayAdapter listviewAdapter = new ArrayAdapter(this, R.layout.custom_layout_for_view, R.id.textviewid2, stringArray);
        lsview.setAdapter(listviewAdapter);
        lsview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(), "This is the default ListView", Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), stringArray[position], Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), "view :" + view.toString(), Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(), "parent :" + parent.toString(), Toast.LENGTH_LONG).show();
            }
        });
        Button button = (Button) findViewById(R.id.movetocustomlistviewbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DefaultListView.this, CustomListView.class);
                startActivity(intent);
            }
        });
    }


}
