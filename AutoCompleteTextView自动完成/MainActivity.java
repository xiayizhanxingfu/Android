public class MainActivity extends Activity {

    String[] str={
            "124321",
            "423122",
            "123234",
            "562343"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //新建适配器
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,str);
        //为控件设置适配器
        ((AutoCompleteTextView)findViewById(R.id.auto)).setAdapter(adapter);
    }
}