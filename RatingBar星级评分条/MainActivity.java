public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView=findViewById(R.id.tv);
        RatingBar ratingBar=findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                String s="";
                switch ((int) v){
                    case 1:
                        s="差评";
                        break;
                    case 2:
                        s="一般";
                        break;
                    case 3:
                        s="较好";
                        break;
                    case 4:
                        s="棒";
                        break;
                    case 5:
                        s="很棒";
                        break;
                }
                textView.setText(s);
            }
        });
    }
}
