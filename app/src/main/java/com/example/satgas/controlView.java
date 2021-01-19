package com.example.satgas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class controlView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_view);

        WebView web = (WebView) findViewById(R.id.web_view);
        web.loadUrl("http://satgas.ideastart.id/");
        web.setWebViewClient(new WebViewClient());
    }
}
