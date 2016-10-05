package innoday.echostar.com.echopath;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Sheshank.Kodam on 7/4/2016.
 */

public class ShowLayoutImageActivity extends Activity{

    LayoutImage layoutImageView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        layoutImageView = new LayoutImage(this);
        setContentView(layoutImageView);
    }

    public class LayoutImage extends View {
        public LayoutImage(Context context){
            super(context);
            setBackgroundResource(R.drawable.floor1);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint pBackground = new Paint();
            pBackground.setColor(Color.GREEN);
            pBackground.setStrokeWidth(10);
            canvas.drawLine(100, 400, 100, 800, pBackground);
        }
    }
}

