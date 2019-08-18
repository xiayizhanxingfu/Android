public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TabHost tabHost=getTabHost();
        //设置使用tabHost布局
        LayoutInflater.from(this).inflate(R.layout.activity_main,tabHost.getTabContentView(),true);
        tabHost.addTab(tabHost.newTabSpec("tab01")
        .setIndicator("已接电话").setContent(R.id.tab01));
        tabHost.addTab(tabHost.newTabSpec("tab02")
        .setIndicator("未接电话")
        .setContent(R.id.tab02));
        tabHost.addTab(tabHost.newTabSpec("tab03")
        .setIndicator("呼出电话")
        .setContent(R.id.tab03));
    }
}
