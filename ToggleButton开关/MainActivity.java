public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final LinearLayout layout=findViewById(R.id.layout);
        ToggleButton toggleButton=findViewById(R.id.toggle);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    layout.setOrientation(LinearLayout.HORIZONTAL);
                }else{
                    layout.setOrientation(LinearLayout.VERTICAL);
                }
            }
        });
    }
}
