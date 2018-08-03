package wai.govgymappnew;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.URLUtil;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // AdMob banner ad test id: ca-app-pub-3940256099942544/6300978111
        // my banner ad id: ca-app-pub-2878374163061282/6615438108
        // change to your own ad id
        // Change in MainActivity.java and activity_main.xml
        MobileAds.initialize(this, "ca-app-pub-2878374163061282/6615438108");
        mAdView = (AdView)findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        WebView webview = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
//        setContentView(webview);

        webview.setWebViewClient(new WebViewClient() {
             @Override
             public boolean shouldOverrideUrlLoading(WebView view, String url) {
                 if (url.endsWith(".pdf")) {
//                         String pdfUrl = "https://docs.google.com/viewer?url=" + url;
//                         try {
//                             String urlEncoded = URLEncoder.encode(pdfUrl, "UTF-8");
//                             view.loadUrl(urlEncoded);
//                         } catch (UnsupportedEncodingException e){
//                             e.printStackTrace();
//                         }
                     return false;
                 } else {
                         // Otherwise allow the OS to handle it
                         Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                         startActivity(intent);
                         return true;
                 }
             }
         });

        // replace this with your own link/web app address
        if (savedInstanceState == null) {
            webview.loadUrl("http://ec2-18-179-186-35.ap-northeast-1.compute.amazonaws.com/");
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        WebView webview = (WebView) findViewById(R.id.webview);

        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (webview.canGoBack()) {
                        webview.goBack();
                    } else {
                        finish();
                    }
                    return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState )
    {
        WebView webview = (WebView) findViewById(R.id.webview);

        super.onSaveInstanceState(outState);
        webview.saveState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        WebView webview = (WebView) findViewById(R.id.webview);

        super.onRestoreInstanceState(savedInstanceState);
        webview.restoreState(savedInstanceState);
    }


}
