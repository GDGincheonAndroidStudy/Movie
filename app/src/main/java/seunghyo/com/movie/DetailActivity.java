package seunghyo.com.movie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by SeungHyo on 2015-11-27.
 */
public class DetailActivity extends AppCompatActivity {

    String title, rating, content, actor;
    int image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        TextView titles = (TextView) findViewById(R.id.title);
        ImageView images = (ImageView) findViewById(R.id.image);
        TextView ratings = (TextView) findViewById(R.id.rating);
        TextView contents = (TextView) findViewById(R.id.coment);
        TextView actors = (TextView) findViewById(R.id.actor);
        Button button = (Button) findViewById(R.id.back);

        Intent intent = getIntent();

        try {
            title = intent.getStringExtra("title");
            image = intent.getIntExtra("image", 0);
            rating = intent.getStringExtra("rating");
            content = intent.getStringExtra("content");
            actor = intent.getStringExtra("actor");
        } catch (NullPointerException e) {
            title = "인크레더블 헐크 (2008)";
            image = R.drawable.helk;
            rating = "평점 : 8.32";
            actor = "주연 : 에드워드 노튼";
            content = "영화 어벤져스 스토리를 위한 헐크 리메이킹 영화";
        }

        titles.setText(title);
        titles.setTextSize(20);
        images.setImageResource(image);
        actors.setText(actor);
        ratings.setText(rating);
        contents.setText(content);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
