package com.angsanley.mybrowser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button goBtn = findViewById(R.id.btnGo);
        final EditText urlEdit = findViewById(R.id.urlEdit);
        final WebView webView = findViewById(R.id.webview);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                setTitle(webView.getTitle());
                urlEdit.setText(webView.getUrl());
            }
        });

        webView.loadUrl("http://google.com");

        goBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (urlEdit.getText().toString().contains("http://")) {
                    webView.loadUrl(urlEdit.getText().toString());
                } else if (urlEdit.getText().toString().contains("https://")) {
                    webView.loadUrl(urlEdit.getText().toString());
                } else {
                    webView.loadUrl("http://" + urlEdit.getText().toString());
                }

            }
        });
    }
}
