package it.tiwiz.tintedimageview;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

import it.tiwiz.view.TintedImageView;


public class TestActivity extends ActionBarActivity implements View.OnClickListener{
    
    TintedImageView tintedImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        
        tintedImageView = (TintedImageView) findViewById(R.id.tintedImageView);
        
        findViewById(R.id.btnMakeItRed).setOnClickListener(this);
        findViewById(R.id.btnMakeItOrange).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnMakeItRed:
                changeTintToRed();
                break;
            case R.id.btnMakeItOrange:
                changeTintResToOrange();
                break;
        }
    }
    
    private void changeTintToRed() {
        int colorTint = getResources().getColor(android.R.color.holo_red_light);
        tintedImageView.setTint(colorTint);
    }
    
    private void changeTintResToOrange() {
        tintedImageView.setTintResource(android.R.color.holo_orange_light);
        
    }
}
