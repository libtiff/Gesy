package libtiff.gesy;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;

import android.view.View;
import android.view.Window;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends Activity
{
    private AdView mAdView;
    private WebView webview1;
    String link = "";// global variable
    Resources res;// global variable
    @Override


    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton btnlogingr = (ImageButton)findViewById(R.id.logingr);
        ImageButton btnloginen = (ImageButton)findViewById(R.id.loginen);
        ImageButton btnprologingr = (ImageButton)findViewById(R.id.prologingr);
        ImageButton btnprologinen = (ImageButton)findViewById(R.id.prologinen);
        mAdView = findViewById(R.id.AdView);
        webview1  = (WebView) findViewById(R.id.webview1);

        CookieSyncManager.createInstance(this);
        CookieManager.getInstance().setAcceptCookie(true);
        MobileAds.initialize(this, "ca-app-pub-9082725429338291~9699329161");
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        final Activity activity = this;

        btnlogingr.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String url = "https://portal.gesy.org.cy/dashboard";
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(browserIntent);
            }
        });

        webview1.setWebViewClient(new WebViewClient()
        {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(activity, description, Toast.LENGTH_SHORT).show();
            }

        });

        webview1.getSettings().setSupportZoom(true);
        webview1.getSettings().setBuiltInZoomControls(true);
        webview1.getSettings().setDisplayZoomControls(false);
        webview1.getSettings().setJavaScriptEnabled(true);
        webview1.getSettings().setUseWideViewPort(true);
        webview1.getSettings().setLoadWithOverviewMode(true);
        webview1.getSettings().setDefaultTextEncodingName("utf-8");
        webview1 .loadUrl("https://www.gesy.org.cy/launchpad.html");

    }

    public void checkpermissions()
    {

    }
}