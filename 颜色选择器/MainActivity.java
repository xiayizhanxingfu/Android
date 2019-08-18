public class MainActivity extends Activity {
    ImageView imageView;
    SeekBar RED;
    SeekBar GREEN;
    SeekBar BLUE;
    EditText et_red;
    EditText et_green;
    EditText et_blue;
    int red=0,green=0,blue=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=findViewById(R.id.iv);
        RED=findViewById(R.id.red);
        GREEN=findViewById(R.id.green);
        BLUE=findViewById(R.id.blue);
        et_red=findViewById(R.id.et_red);
        et_green=findViewById(R.id.et_green);
        et_blue=findViewById(R.id.et_blue);
        //添加文本变化事件,动态根据编辑值改变颜色
        et_red.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                update(et_red,1);
            }
        });
        et_green.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                update(et_green,2);
            }
        });
        et_blue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                update(et_blue,3);
            }
        });
        //添加拖动条拖动事件
        RED.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                update(et_red,seekBar,1);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                update(et_red,seekBar,1);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                update(et_red,seekBar,1);
            }
        });
        GREEN.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                update(et_green,seekBar,2);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                update(et_green,seekBar,2);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                update(et_green,seekBar,2);
            }
        });
        BLUE.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                update(et_blue,seekBar,3);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                update(et_blue,seekBar,3);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                update(et_blue,seekBar,3);
            }
        });
    }
    //改变颜色
    private void update(EditText et,int index){
        if(et.getText().toString().equals("")){
            return;
        }else{
            if (Integer.parseInt(et.getText().toString())>255){
                et.setText("255");
                //光标定位到255后边
                et.setSelection("255".length());
            }
        }
        switch (index){
            case 1:
                red=Integer.parseInt(et.getText().toString());
                break;
            case 2:
                green=Integer.parseInt(et.getText().toString());
                break;
            case 3:
                blue=Integer.parseInt(et.getText().toString());
                break;
        }
        int color=((0xFF << 24)|(red << 16)|(green << 8)|blue);
        imageView.setBackgroundColor(color);
    }
    //改变颜色
    private void update(EditText tv,SeekBar seekBar,int index){
        switch (index){
            case 1:
                //获取拖动的值
                red=seekBar.getProgress();
                break;
            case 2:
                green=seekBar.getProgress();
                break;
            case 3:
                blue=seekBar.getProgress();
                break;
        }
        tv.setText(String.valueOf(seekBar.getProgress()));
        //rgb值转换int
        int color=((0xFF << 24)|(red << 16)|(green << 8)|blue);
        //设置背景颜色
        imageView.setBackgroundColor(color);
    }

}
