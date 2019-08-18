public class MainActivity extends Activity {
    //图片资源
    int[] images={
            R.drawable.demo01, R.drawable.demo02, R.drawable.demo03, R.drawable.demo04,
            R.drawable.demo05, R.drawable.demo06, R.drawable.demo07, R.drawable.demo08,
            R.drawable.demo09, R.drawable.demo10, R.drawable.demo11, R.drawable.demo12
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageAdapter imageAdapter=new ImageAdapter(this);
        final Gallery gallery=findViewById(R.id.gallery);
        //设置适配器
        gallery.setAdapter(imageAdapter);
        final ImageSwitcher imageSwitcher=findViewById(R.id.imageSwitcher);
        //设置进入动画
        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_in));
        //设置移除动画
        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_out));
        //设置视图工厂,显示视图
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView=new ImageView(MainActivity.this);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                return imageView;
            }
        });
        //设置item选中事件
        gallery.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //设置显示图片
                imageSwitcher.setImageResource(images[i%images.length]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }
    //图片适配器类
    class ImageAdapter extends BaseAdapter{
        private Context context=null;
        public ImageAdapter(Context context){
            this.context=context;
        }
        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int i) {
            return images[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }
        //返回每个item视图
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ImageView imageView=new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageResource(images[i]);
            imageView.setLayoutParams(new Gallery.LayoutParams(400,300));
            return imageView;
        }
    }
}
