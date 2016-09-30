package innoday.echostar.com.echopath;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Sheshank.Kodam on 7/4/2016.
 */

public class ShowLayoutImageActivity extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Define relative layout
        RelativeLayout layout = new RelativeLayout(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        layout.setLayoutParams(layoutParams);

        // get meeting room directions from main activity
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.floor1);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setLayoutParams(new
                LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT));
        layout.addView(imageView);

        setContentView(layout);
    }
}

