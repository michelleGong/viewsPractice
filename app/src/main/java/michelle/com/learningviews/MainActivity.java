package michelle.com.learningviews;

import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<PageMode> pageModeList = new ArrayList<PageMode>();


    {
        pageModeList.add(new PageMode(R.string.drawcolor,null,R.layout.practice_color));
        pageModeList.add(new PageMode(R.string.drawCircle,R.drawable.sample_circle,R.layout.practice_circle));
        pageModeList.add(new PageMode(R.string.drawRect,R.drawable.sample_rect,R.layout.practice_rect));
        pageModeList.add(new PageMode(R.string.drawpoint,R.drawable.sample_point,R.layout.practice_point));
        pageModeList.add(new PageMode(R.string.drawOval,R.drawable.sample_oval,R.layout.practice_oval));
        pageModeList.add(new PageMode(R.string.drawLine,R.drawable.sample_line,R.layout.practice_line));
        pageModeList.add(new PageMode(R.string.drawRoundRect,R.drawable.sample_round_rect,R.layout.practice_round_rect));
        pageModeList.add(new PageMode(R.string.drawArc,R.drawable.sample_arc,R.layout.practice_arc));
        pageModeList.add(new PageMode(R.string.drawPath,R.drawable.sample_path,R.layout.practice_path));
        pageModeList.add(new PageMode(R.string.drawPieChart,R.drawable.sample_pie_chart,R.layout.practice_pie));
        pageModeList.add(new PageMode(R.string.drawColumnDiagram,R.drawable.sample_histogram,R.layout.practice_column_diagram));
        pageModeList.add(new PageMode(R.string.drawBitmap,null,R.layout.practice_bitmap));
        pageModeList.add(new PageMode(R.string.drawOther,null,R.layout.practice_other));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = (TabLayout) this.findViewById(R.id.tablayout);
        viewPager = (ViewPager) this.findViewById(R.id.viewpager);
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                PageMode currentPageMode = pageModeList.get(position);
                return PageFragment.newInstance(currentPageMode.titleRes,currentPageMode.sampleRes,
                        currentPageMode.practiceRes);
            }

            @Override
            public int getCount() {
                return pageModeList.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return getString(pageModeList.get(position).titleRes);
            }
        });

        // setup the tab layout with viewPager
        tabLayout.setupWithViewPager(viewPager,true);
    }



    class PageMode{
        @StringRes int titleRes;
        @Nullable @DrawableRes Integer sampleRes;
        @LayoutRes int practiceRes;

        public PageMode(int titleRes, @Nullable Integer sampleRes, int practiceRes) {
            this.titleRes = titleRes;
            this.sampleRes = sampleRes;
            this.practiceRes = practiceRes;
        }
    }

}
