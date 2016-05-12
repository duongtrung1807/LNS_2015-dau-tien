package com.example.duongtrunghs.luatngansach_2015v2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FullscreenActivity2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_fullscreen2);

        int positionstr=0;
        String tieudestr="";
        String noidungstr="";
        Bundle extras=getIntent().getExtras();
        if (extras!=null){
            positionstr=extras.getInt("position");
            tieudestr=extras.getString("tieude");
            noidungstr=extras.getString("noidung");
        }

        TextView tieude=(TextView) findViewById(R.id.textViewTieude);
        TextView noidung=(TextView) findViewById(R.id.textViewNoidung);

        tieude.setText(Html.fromHtml(tieudestr));
        noidung.setText(Html.fromHtml(noidungstr));

    }

}
