public class MainActivity extends Activity {
    int[] images={
            R.drawable.demo01, R.drawable.demo02, R.drawable.demo03, R.drawable.demo04,
            R.drawable.demo05, R.drawable.demo06, R.drawable.demo07, R.drawable.demo08,
            R.drawable.demo09, R.drawable.demo10, R.drawable.demo11, R.drawable.demo12
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //创建基础适配器
        BaseAdapter baseAdapter=new BaseAdapter() {
            @Override
            public int getCount() {
                //返回内容大小
                return images.length;
            }

            @Override
            public Object getItem(int i) {
                return 0;
            }

            @Override
            public long getItemId(int i) {
                return 0;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                //返回第i个视图内容
                ImageView imageView=new ImageView(MainActivity.this);
                imageView.setImageResource(images[i%images.length]);
                //设置视图宽高大小
                imageView.setLayoutParams(new Gallery.LayoutParams(-2,-2));
                return imageView;
            }
        };
        Gallery gallery=findViewById(R.id.gallery);
        gallery.setAdapter(baseAdapter);
    }
}