package it.lamaantiruggine.dofm_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class Webviewer extends AppCompatActivity {

    // Da non modificare, serve per aprire il browser predefinito al link della ListView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_layout);

        Intent intent = getIntent();
        String url = intent.getExtras().getString("LINK");
        WebView wv=(WebView)findViewById(R.id.item_webview);
        wv.loadUrl(url);
    }
}
