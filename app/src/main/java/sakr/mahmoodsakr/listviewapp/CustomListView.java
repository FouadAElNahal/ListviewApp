package sakr.mahmoodsakr.listviewapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class CustomListView extends AppCompatActivity {
    String[] textString = {"one", "two", "three", "four", "five"};
    int[] img = {R.drawable.img0, R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_list_view);
        MyCustomAdapter adapter = new MyCustomAdapter(textString, img);
        ListView listView = (ListView) findViewById(R.id.customlistviewid);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(CustomListView.this, "This is the Custom ListView", Toast.LENGTH_SHORT).show();
                Toast.makeText(CustomListView.this, textString[position], Toast.LENGTH_SHORT).show();
                Toast.makeText(CustomListView.this, "view :" + view.toString(), Toast.LENGTH_LONG).show();
                Toast.makeText(CustomListView.this, "parent " + parent.toString(), Toast.LENGTH_LONG).show();
            }
        });
        Button button = (Button) findViewById(R.id.movetoDefautlistviewbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CustomListView.this, DefaultListView.class);
                startActivity(intent);
            }
        });
    }


    public class MyCustomAdapter extends BaseAdapter {

        String[] stringsText;
        int[] imges;

        public MyCustomAdapter(String[] stringsText, int[] imges) {
//            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            this.stringsText = stringsText;
            this.imges = imges;
        }

        @Override
        public int getCount() {
            return stringsText.length;
        }

        @Override
        public Object getItem(int position) {
            return stringsText[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            // the row will be null only at the first time , so you initialize these object one time only all time getView is executing
            if (row == null) {
                LayoutInflater inflater = getLayoutInflater();
                row = inflater.inflate(R.layout.custom_layout_for_view, null);
            }
            TextView txtiew1 = (TextView) row.findViewById(R.id.textviewid1);
            TextView txtiew2 = (TextView) row.findViewById(R.id.textviewid2);
            ImageView imageView = (ImageView) row.findViewById(R.id.imgviewid);
            txtiew1.setText("" + position);
            txtiew2.setText(stringsText[position]);
            imageView.setImageResource(imges[position]);
            final int i = position;
            txtiew1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(CustomListView.this, "Textview at :" + i, Toast.LENGTH_SHORT).show();
                }
            });
            txtiew2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(CustomListView.this, "Textview at :" + stringsText[i], Toast.LENGTH_SHORT).show();
                }
            });
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(CustomListView.this, "ImageView at Position :" + i, Toast.LENGTH_SHORT).show();
                }
            });

            return row;
        }
    }

}
