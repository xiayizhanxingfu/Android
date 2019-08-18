public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final DatePicker datePicker=findViewById(R.id.datePicker);
        findViewById(R.id.getDate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int year=datePicker.getYear();
                int month=datePicker.getMonth();
                int day=datePicker.getDayOfMonth();
                String date="year:"+year+"\r\n"+
                        "month:"+month+"\r\n"+
                        "day:"+day;
                Toast.makeText(MainActivity.this, date, Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.setDate).setOnClickListener(new View.OnClickListener() {
            EditText et_year=findViewById(R.id.year);
            EditText et_month=findViewById(R.id.month);
            EditText et_day=findViewById(R.id.day);
            @Override
            public void onClick(View view) {
                int year=Integer.parseInt(et_year.getText().toString());
                int month=Integer.parseInt(et_month.getText().toString());
                int day=Integer.parseInt(et_day.getText().toString());
                datePicker.updateDate(year,month,day);
            }
        });
    }
}
