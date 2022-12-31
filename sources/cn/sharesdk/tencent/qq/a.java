package cn.sharesdk.tencent.qq;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import cn.sharesdk.framework.authorize.SSOListener;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.framework.utils.m;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.mob.tools.FakeActivity;
import com.tencent.connect.common.Constants;
import java.lang.reflect.Method;
/* compiled from: DownLoadWebPage.java */
/* loaded from: classes.dex */
public class a extends FakeActivity {
    private LinearLayout a;
    private WebView b;
    private String c = "http://qzs.qq.com/open/mobile/login/qzsjump.html?sdkv=3.3.0.lite&display=mobile";

    /* renamed from: d  reason: collision with root package name */
    private String f256d = "http://app.qq.com/detail/com.tencent.mobileqq?autodownload=1&norecommend=1&rootvia=opensdk";

    /* renamed from: e  reason: collision with root package name */
    private SSOListener f257e;

    private void c() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 > 10 && i2 < 17) {
            try {
                Method method = this.b.getClass().getMethod("removeJavascriptInterface", String.class);
                method.setAccessible(true);
                method.invoke(this.b, "searchBoxJavaBridge_");
                method.invoke(this.b, "accessibility");
                method.invoke(this.b, "accessibilityTraversal");
            } catch (Throwable th) {
                SSDKLog.b().d(th);
            }
        }
        WebSettings settings = this.b.getSettings();
        settings.setCacheMode(2);
        settings.setUseWideViewPort(true);
        settings.setJavaScriptEnabled(true);
        this.b.setVerticalScrollBarEnabled(false);
        this.b.setHorizontalScrollBarEnabled(false);
        m.a(this.b, false);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
    }

    @Override // com.mob.tools.FakeActivity
    public void onCreate() {
        this.activity.getWindow().setBackgroundDrawable(new ColorDrawable(-1));
        a(this.activity);
        this.activity.setContentView(this.a);
    }

    @Override // com.mob.tools.FakeActivity
    public boolean onKeyEvent(int i2, KeyEvent keyEvent) {
        if (i2 == 4 && keyEvent.getAction() == 1) {
            WebView webView = this.b;
            if (webView != null && webView.canGoBack()) {
                this.b.goBack();
            } else {
                this.f257e.onCancel();
                this.f257e = null;
                a();
            }
            return true;
        }
        return super.onKeyEvent(i2, keyEvent);
    }

    private void b() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.a = linearLayout;
        linearLayout.setOrientation(1);
        new LinearLayout.LayoutParams(-1, -1);
        this.b = new WebView(getContext());
        this.a.addView(this.b, new LinearLayout.LayoutParams(-1, 0, 11.0f));
        c();
    }

    public void a(SSOListener sSOListener) {
        this.f257e = sSOListener;
    }

    private void a(Activity activity) {
        b();
        this.b.setWebViewClient(new WebViewClient() { // from class: cn.sharesdk.tencent.qq.a.1
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (str != null) {
                    try {
                        if (str.startsWith(Constants.DOWNLOAD_URI)) {
                            a.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(a.this.f256d)));
                            return true;
                        }
                    } catch (Throwable th) {
                        SSDKLog.b().d(th);
                        a.this.f257e.onFailed(th);
                        a.this.f257e = null;
                        a.this.a();
                    }
                }
                return false;
            }
        });
        WebView webView = this.b;
        String str = this.c;
        webView.loadUrl(str);
        VdsAgent.loadUrl(webView, str);
    }

    public void a() {
        finish();
    }
}
