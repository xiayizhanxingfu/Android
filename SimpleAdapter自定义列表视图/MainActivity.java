/*  使用SimpleAdapter 的最大难点在于创建SimpleAdapter对象，它需要5个参数，其中后面4个参数十分关键。
第二个参数：该参数应该是一个List<? extends Map<Stnng ， ？ > > 类型的集合对象，该集合中每个Map<String, ？ >
对象生成一个列表项。 
第三个参数： 该参数指定一个界面布局的ID.例如此处指定了R.layout.activity_main ，
这意味着使用/res/layout/activity_main.xml文件作为界面布局。也就是第五个参数中的界面组件就来自该界面布局。 
第四个参数： 该参数应该是一个String[] 类型的参数， 该参数决定提取Map<String, ？ > 对象中那些key 对应的value 来生成列表项。
 第五个参数：该参数应该是一个int[] 类型的参数， 该参数决定使用哪些View 组件来组合成一个列表项。
*/
public class MainActivity extends Activity {

    String[] str={
            "1",
            "2",
            "3",
            "4",
    };
    int[] images={
            R.drawable.demo,
            R.drawable.demo,
            R.drawable.demo,
            R.drawable.demo
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //添加图像和文本内容到list中
        List<Map<String,Object>> list=new ArrayList<>();
        for(int i=0;i<str.length;i++){
            Map<String ,Object> map=new HashMap<>();
            map.put("image",images[i]);
            map.put("message",str[i]);
            list.add(map);
        }
        //新建适配器
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,list,R.layout.activity_main,
                new String[]{"image","message"},new int[]{R.id.image,R.id.message});
        //设置适配器
        ((ListView)findViewById(R.id.listView)).setAdapter(simpleAdapter);
    }
}
