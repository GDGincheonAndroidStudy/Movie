package seunghyo.com.movie;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by SeungHyo on 2015-11-13.
 */
public class FragmentB extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView;
        rootView = inflater.inflate(R.layout.fragment_b, container, false);
        rootView.setBackgroundColor(Color.WHITE);
        TextView titles= (TextView) rootView.findViewById(R.id.title);
        ImageView images = (ImageView) rootView.findViewById(R.id.image);
        TextView ratings = (TextView) rootView.findViewById(R.id.rating);
        TextView contents = (TextView) rootView.findViewById(R.id.coment);
        TextView actors = (TextView) rootView.findViewById(R.id.actor);
        Button button = (Button) rootView.findViewById(R.id.back);
        Bundle bundle = getArguments();
        String title, rating, content, actor;
        int image;
        try {
            title = bundle.getString("title");
            image = bundle.getInt("image");
            rating = bundle.getString("rating");
            content = bundle.getString("content");
            actor = bundle.getString("actor");
        } catch(NullPointerException e){
            title = "인크레더블 헐크 (2008)";
            image =  R.drawable.helk;
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

        if(getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentManager manager = getFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    FragmentA fragmenta = new FragmentA();
                    {
                        transaction.replace(R.id.fragmentOne, fragmenta, "fragment");
                        transaction.commit();
                    }
                }
            });
        }
        return rootView;
    }
}
