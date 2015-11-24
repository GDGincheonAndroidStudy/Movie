package seunghyo.com.movie;

import android.app.Activity;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by SeungHyo on 2015-11-13.
 */
public class FragmentA extends Fragment {

    OnClickActionCallBackA onClickAction;

    String[] titles = {
            "인크레더블 헐크 (2008)",
            "아이언맨 (2008)",
            "토르: 천둥의신 (2011)",
            "퍼스트 어벤져 (2011)",
            "어벤져스:에이지 오브 울트론 (2015)",
    };

    Integer[] images = {
            R.drawable.helk,
            R.drawable.ironman,
            R.drawable.thor,
            R.drawable.captin,
            R.drawable.avengers2,
    };

    String[] actors = {
            "주연 : 에드워드 노튼",
            "주연 : 로버트 다우니 주니어",
            "주연 : 크리스 헴스워스",
            "주연 : 크리스 에반스",
            "주연 : 크리스 헴스워스 등"
    };

    String[] ratings = {
            "평점 : 8.32",
            "평점 : 8.87",
            "평점 : 7.28",
            "평점 : 7.24",
            "평점 : 8.29"
    };

    String[] contents = {
            "영화 어벤져스 스토리를 위한 헐크 리메이킹 영화",
            "로버트 다우니 주니어 신화의 시작",
            "북유럽 신화의 색다른 해석",
            "마블의 대표영웅 캡틴 아메리카, 첫 번째 여정",
            "화제의 영화 어벤져스의 후속편"
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView;


        try {
            onClickAction = (OnClickActionCallBackA) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString()
                    + " must implement OnHeadlineSelectedListener");
        }

        rootView = inflater.inflate(R.layout.main, container, false);
        rootView.setBackgroundColor(Color.WHITE);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.linear1);
        CustomList customList = new CustomList(getActivity());
        listView.setAdapter(customList);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                FragmentB fragmentB = new FragmentB();
                Bundle bundle = new Bundle();

                if(Util.getInstance().isPortrait(getActivity())) {

                    onClickAction.onclicklistview();
                    transaction.replace(R.id.fragmentTwo, fragmentB, "fragment"+position);
                    bundle.putString("title", titles[position]);
                    bundle.putString("rating", ratings[position]);
                    bundle.putString("content", contents[position]);
                    bundle.putString("actor", actors[position]);
                    bundle.putInt("image", images[position]);
                    fragmentB.setArguments(bundle);
                    transaction.commit();
                }
                else {
                    transaction.replace(R.id.fragmentTwo, fragmentB, "fragment"+position);
                    bundle.putString("title", titles[position]);
                    bundle.putString("rating", ratings[position]);
                    bundle.putString("content", contents[position]);
                    bundle.putString("actor", actors[position]);
                    bundle.putInt("image", images[position]);
                    fragmentB.setArguments(bundle);
                    transaction.commit();
                }
            }
        });
        return rootView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public class CustomList extends ArrayAdapter<String> {

        private final Activity context;
        public CustomList(Activity context ) {
            super(context, R.layout.listmain1, titles);
            this.context = context;
        }
        @Override
        public View getView(int position, View view, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View rowView= inflater.inflate(R.layout.listmain1, null, true);
            ImageView imageView = (ImageView) rowView.findViewById(R.id.image);
            TextView title = (TextView) rowView.findViewById(R.id.title);
            TextView actor = (TextView) rowView.findViewById(R.id.actor);
            TextView rating = (TextView) rowView.findViewById(R.id.rating);
            title.setText(titles[position]);
            imageView.setImageResource(images[position]);
            actor.setText(actors[position]);
            rating.setText(ratings[position]);
            return rowView;
        }
    }


    public interface OnClickActionCallBackA {
        public void onclicklistview();
    }

}
