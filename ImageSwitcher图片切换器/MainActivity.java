public class MainActivity extends Activity {
    //要显示图片的位置
    int index=0;
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
        final ImageSwitcher imageSwitcher=findViewById(R.id.imageSwitcher);
        //获取其他布局文件
        View view=LayoutInflater.from(this).inflate(R.layout.layout1,null);
        //给图片切换器添加视图,最多只能添加1个视图,一共2个视图
        imageSwitcher.addView(view.findViewById(R.id.layout1));
        View view1=LayoutInflater.from(this).inflate(R.layout.layout2,null);
        imageSwitcher.addView(view1.findViewById(R.id.layout2));
        //定义点击事件,
        imageSwitcher.findViewById(R.id.front).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index--;
                if(index<=-1){
                    index=images.length-1;
                }
                update(imageSwitcher,R.id.imageView,images[index]);
            }
        });
        imageSwitcher.findViewById(R.id.next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index++;
                if(index>=images.length){
                    index=0;
                }
                update(imageSwitcher,R.id.imageView,images[index]);
            }
        });
        imageSwitcher.findViewById(R.id.switchover).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //切换另一个布局视图
                imageSwitcher.showNext();
            }
        });
        imageSwitcher.findViewById(R.id.front1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index--;
                if(index<=-1){
                    index=images.length-1;
                }
                update(imageSwitcher,R.id.imageView1,images[index]);
            }
        });
        imageSwitcher.findViewById(R.id.next1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index++;
                if(index>=images.length){
                    index=0;
                }
                update(imageSwitcher,R.id.imageView1,images[index]);
            }
        });
        imageSwitcher.findViewById(R.id.switchover1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageSwitcher.showNext();
            }
        });
    }
    public static void update(ImageSwitcher imageSwitcher,int imageView,int index){
        //切换图片
        ImageView imageView1=imageSwitcher.findViewById(imageView);
        imageView1.setImageResource(index);
    }
}
