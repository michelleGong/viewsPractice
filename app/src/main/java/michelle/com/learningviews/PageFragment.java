package michelle.com.learningviews;


import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PageFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_TITLE_RES = "titleRes";
    private static final String ARG_SAMPLE_RES = "sampleRes";
    private static final String ARG_PRACTIC_RES = "practiceRes";

    // TODO: Rename and change types of parameters
    private @StringRes int titleRes;
    private @DrawableRes Integer sampleRes;
    private @LayoutRes int practiceRes;


    public PageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment PageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PageFragment newInstance(@StringRes int titleRes, @Nullable @DrawableRes Integer sampleRes, @LayoutRes int practicRes) {
        PageFragment fragment = new PageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_TITLE_RES,titleRes);
        if(sampleRes != null){
            args.putInt(ARG_SAMPLE_RES,sampleRes);
        }

        args.putInt(ARG_PRACTIC_RES,practicRes);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            titleRes = getArguments().getInt(ARG_TITLE_RES);
            sampleRes = getArguments().getInt(ARG_SAMPLE_RES);
            practiceRes = getArguments().getInt(ARG_PRACTIC_RES);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_page, container, false);

        if(sampleRes != null && sampleRes != 0){
            ViewStub sampleStub = (ViewStub) view.findViewById(R.id.sampleStub);
            if(sampleStub != null){

                //set up sample views
                RelativeLayout sampleLayout = (RelativeLayout) sampleStub.inflate();

                // prepare the layoutParam: center in parent
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams
                        (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);

                // set the sample imageview
                Drawable sampleD = ((AppCompatActivity)getActivity()).getDrawable(sampleRes);
                ImageView imageView = new ImageView(getActivity());
                imageView.setImageDrawable(sampleD);

                // set image view center in relativeLayout
                sampleLayout.addView(imageView,layoutParams);

                ViewGroup.LayoutParams imagep =  imageView.getLayoutParams();
                imagep.width = ViewGroup.LayoutParams.MATCH_PARENT;
                imagep.height = ViewGroup.LayoutParams.MATCH_PARENT;
                imageView.setLayoutParams(imagep);
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);




            }

        }

        ViewStub practiceStub = (ViewStub) view.findViewById(R.id.practiceStub);
        if(practiceStub != null){
            practiceStub.setLayoutResource(practiceRes);
            practiceStub.inflate();

        }

        return view;
    }

}
