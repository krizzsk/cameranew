package us.pinguo.ui;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
/* loaded from: classes6.dex */
public class PrivacyPolicyActivity extends Activity {
    private WebView a;
    private boolean b = true;
    private ImageView c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f12089d;

    /* renamed from: e  reason: collision with root package name */
    private FrameLayout f12090e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f12091f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        private b(PrivacyPolicyActivity privacyPolicyActivity) {
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        private c() {
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            PrivacyPolicyActivity privacyPolicyActivity = PrivacyPolicyActivity.this;
            privacyPolicyActivity.b = !privacyPolicyActivity.b;
            if (PrivacyPolicyActivity.this.b) {
                PrivacyPolicyActivity.this.c.setVisibility(0);
                PrivacyPolicyActivity.this.f12089d.setVisibility(4);
                return;
            }
            PrivacyPolicyActivity.this.c.setVisibility(4);
            PrivacyPolicyActivity.this.f12089d.setVisibility(0);
        }
    }

    private void e() {
        this.a = (WebView) findViewById(us.pinguo.advsdk.R.id.webview);
        this.c = (ImageView) findViewById(us.pinguo.advsdk.R.id.iv_agree);
        this.f12089d = (ImageView) findViewById(us.pinguo.advsdk.R.id.iv_disagree);
        this.f12090e = (FrameLayout) findViewById(us.pinguo.advsdk.R.id.icon_layout);
        this.f12091f = (TextView) findViewById(us.pinguo.advsdk.R.id.button);
        this.f12090e.setOnClickListener(new c());
        this.f12091f.setOnClickListener(new b());
    }

    private void f() {
        WebSettings settings = this.a.getSettings();
        if (Build.VERSION.SDK_INT >= 16) {
            settings.setAllowFileAccessFromFileURLs(false);
            settings.setAllowUniversalAccessFromFileURLs(false);
        }
        WebView webView = this.a;
        webView.loadUrl("file:///android_asset/ad_privacy.html");
        VdsAgent.loadUrl(webView, "file:///android_asset/ad_privacy.html");
        this.a.setVerticalScrollBarEnabled(false);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(us.pinguo.advsdk.R.layout.activity_privacy);
        e();
        f();
    }
}
