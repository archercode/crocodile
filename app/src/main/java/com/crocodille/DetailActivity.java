package com.crocodille;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.crocodille.model.Violation;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {


    ListView lvMainDetails;

    String driverId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        driverId = this.getIntent().getStringExtra("drivers_id");

        lvMainDetails = (ListView) findViewById(R.id.lv_details);

        ArrayList<Violation> violations = new ArrayList<Violation>();
        violations.add(new Violation("051","DRIVING IN SLEEVELESS SHIRT","11/22/2014",""));
        violations.add(new Violation("050","DRIVING IN SLIPPERS","12/03/2014",""));
        violations.add(new Violation("066","DRIVING UNDER INFLUENCE OF DRUGS","12/03/2014",""));
        violations.add(new Violation("065","DRIVING UNDER INFLUENCE OF LIQUOR","12/03/2014",""));
        violations.add(new Violation("184","DRIVING WHILE USING CELLULAR PHONE / HANDSET RADIO","12/03/2014",""));
        violations.add(new Violation("056","DRIVING WITH REVOKED DRIVERS LICENSE","12/03/2014",""));
        violations.add(new Violation("050", "DRIVING IN SLIPPERS", "12/04/2014", ""));


        lvMainDetails.setAdapter(new ViolationsAdapter(violations));

        ImageButton btnAdd = (ImageButton) findViewById(R.id.btnAddViolation);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this,ListViolationsActivity.class);
                intent.putExtra("drivers_id",driverId);
                startActivity(intent);
                finish();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail, menu);
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


    public class ViolationsAdapter extends BaseAdapter{

        ArrayList<Violation> violations;

        public ViolationsAdapter(ArrayList<Violation> v){
            this.violations = v;
        }

        @Override
        public int getCount() {
            return violations.size();
        }

        @Override
        public Object getItem(int position) {
            return violations.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = DetailActivity.this.getLayoutInflater();
            View view = inflater.inflate(R.layout.list_item_detail, null);

            TextView tvCode = (TextView) view.findViewById(R.id.tv_code);
            TextView tvDate = (TextView) view.findViewById(R.id.tv_date);
            TextView tvStatus = (TextView) view.findViewById(R.id.tv_status);

            tvCode.setText(violations.get(position).getCode());
            tvDate.setText(violations.get(position).getDate());
            tvStatus.setText(violations.get(position).getStatus());

            return view;
        }
    }
}
