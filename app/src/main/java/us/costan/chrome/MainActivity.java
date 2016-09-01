package us.costan.chrome;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private ChromeView weiview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weiview = (ChromeView) findViewById(R.id.weiview);
        weiview.setChromeWebClient(new ChromeWebClient(){

            @Override
            public void onProgressChanged(ChromeView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
            }
        });
        weiview.setChromeViewClient(new ChromeViewClient(){

            @Override
            public void onPageStarted(ChromeView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                Log.v("demo","onPageStarted");
            }

            @Override
            public void onPageFinished(ChromeView view, String url) {
                super.onPageFinished(view, url);
                Log.v("demo","onPageFinished");
            }
        });
        weiview.getSettings().setJavaScriptEnabled(true);
        ChromeCookieManager.getInstance().setAcceptCookie(true);
        ChromeCookieManager.getInstance().setAcceptFileSchemeCookies(true);
        weiview.loadUrl("https://play.google.com/store/");
    }
}
