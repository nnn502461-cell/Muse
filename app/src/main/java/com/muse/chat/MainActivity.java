package com.muse.chat;
import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
  WebView w;
  @Override protected void onCreate(Bundle b) {
    super.onCreate(b);
    boolean night = (getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES;
    getWindow().setStatusBarColor(Color.parseColor(night ? "#1F1C19" : "#F4EFE6"));
    getWindow().setNavigationBarColor(Color.parseColor(night ? "#1F1C19" : "#F4EFE6"));
    if (!night) getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
    w = new WebView(this);
    w.setBackgroundColor(Color.parseColor(night ? "#1F1C19" : "#F4EFE6"));
    setContentView(w);
    WebSettings s = w.getSettings();
    s.setJavaScriptEnabled(true);
    s.setDomStorageEnabled(true);
    s.setAllowFileAccess(true);
    s.setAllowUniversalAccessFromFileURLs(true);
    w.setWebViewClient(new WebViewClient());
    w.loadUrl("file:///android_asset/index.html");
  }
  @Override public void onBackPressed() {
    w.evaluateJavascript("back()", v -> { if (!"true".equals(v)) finish(); });
  }
}
