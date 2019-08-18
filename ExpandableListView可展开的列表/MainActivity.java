public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //新建适配器
        ExpandableListAdapter adapter= new ExpandableListAdapter() {
            String[] strType={
                "动漫",
                "电视剧",
                "电影"
            };
            String[][] str={
                    {"one","two","three"},
                    {"four","five","six","33"},
                    {"seven","eight","nine","44","445"}
            };
            private TextView getTextView(){
                AbsListView.LayoutParams lp=new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                TextView textView=new TextView(MainActivity.this);
                //设置控件大小
                textView.setLayoutParams(lp);
                textView.setPadding(100,10,0,0);
                textView.setTextSize(10);
                return textView;
            }
            @Override
            public void registerDataSetObserver(DataSetObserver dataSetObserver) {

            }

            @Override
            public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

            }
            //返回组数
            @Override
            public int getGroupCount() {
                return strType.length;
            }
            //返回每组的子项个数
            @Override
            public int getChildrenCount(int i) {
                return str[i].length;
            }
            //返回每组对象
            @Override
            public Object getGroup(int i) {
                return strType[i];
            }
            //返回对象id
            @Override
            public Object getChild(int i, int i1) {
                return str[i][i1];
            }
            //返回每组的id
            @Override
            public long getGroupId(int i) {
                return i;
            }
            //返回子项的id
            @Override
            public long getChildId(int i, int i1) {
                return i1;
            }

            @Override
            public boolean hasStableIds() {
                return true;
            }
            //决定每组的布局外观
            @Override
            public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
                LinearLayout linearLayout=new LinearLayout(MainActivity.this);
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);
                ImageView imageView=new ImageView(MainActivity.this);
                imageView.setImageResource(R.drawable.demo);
                linearLayout.addView(imageView);
                TextView textView=getTextView();
                textView.setTextSize(15);
                textView.setText(getGroup(i).toString());
                linearLayout.addView(textView);
                return linearLayout;
            }
            //该方法决定每个子项的外观
            @Override
            public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
                TextView textView=getTextView();
                textView.setText(getChild(i,i1).toString());
                return textView;
            }

            @Override
            public boolean isChildSelectable(int i, int i1) {
                return true;
            }

            @Override
            public boolean areAllItemsEnabled() {
                return false;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public void onGroupExpanded(int i) {

            }

            @Override
            public void onGroupCollapsed(int i) {

            }

            @Override
            public long getCombinedChildId(long l, long l1) {
                return 0;
            }

            @Override
            public long getCombinedGroupId(long l) {
                return 0;
            }
        };
        ExpandableListView expandableListView=findViewById(R.id.expanded);
        //设置适配器
        expandableListView.setAdapter(adapter);
    }
}
