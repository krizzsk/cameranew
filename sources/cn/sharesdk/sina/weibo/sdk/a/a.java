package cn.sharesdk.sina.weibo.sdk.a;

import android.content.Context;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.framework.utils.m;
import cn.sharesdk.sina.weibo.sdk.LoadingBar;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.mob.tools.utils.ResHelper;
import java.lang.reflect.Method;
import us.pinguo.common.network.common.header.PGTransHeader;
/* compiled from: WeiboWebPageLayout.java */
/* loaded from: classes.dex */
public class a {
    private TextView a;
    private TextView b;
    private WebView c;

    /* renamed from: d  reason: collision with root package name */
    private LoadingBar f251d;

    /* renamed from: e  reason: collision with root package name */
    private LinearLayout f252e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f253f;

    /* renamed from: g  reason: collision with root package name */
    private Button f254g;

    /* renamed from: h  reason: collision with root package name */
    private Context f255h;

    public a(Context context) {
        this.f255h = context;
    }

    private void e() {
        this.c.getSettings().setJavaScriptEnabled(true);
        m.a(this.c, false);
        this.c.getSettings().setSavePassword(false);
        this.c.getSettings().setUserAgentString(Build.MANUFACTURER + PGTransHeader.CONNECTOR + Build.MODEL + "_" + Build.VERSION.RELEASE + "_weibosdk_0031405000_android");
        this.c.requestFocus();
        this.c.setScrollBarStyle(0);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 > 10 && i2 < 17) {
            try {
                Method method = this.c.getClass().getMethod("removeJavascriptInterface", String.class);
                method.setAccessible(true);
                method.invoke(this.c, "searchBoxJavaBridge_");
            } catch (Throwable th) {
                SSDKLog.b().d(th);
            }
        }
        WebView webView = this.c;
        WebChromeClient webChromeClient = new WebChromeClient() { // from class: cn.sharesdk.sina.weibo.sdk.a.a.2
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView2, int i3) {
                VdsAgent.onProgressChangedStart(webView2, i3);
                super.onProgressChanged(webView2, i3);
                a.this.f251d.a(i3);
                if (i3 == 100) {
                    LoadingBar loadingBar = a.this.f251d;
                    loadingBar.setVisibility(4);
                    VdsAgent.onSetViewVisibility(loadingBar, 4);
                } else {
                    LoadingBar loadingBar2 = a.this.f251d;
                    loadingBar2.setVisibility(0);
                    VdsAgent.onSetViewVisibility(loadingBar2, 0);
                }
                VdsAgent.onProgressChangedEnd(webView2, i3);
            }
        };
        webView.setWebChromeClient(webChromeClient);
        VdsAgent.setWebChromeClient(webView, webChromeClient);
    }

    public TextView b() {
        return this.a;
    }

    public WebView c() {
        return this.c;
    }

    public LinearLayout d() {
        return this.f252e;
    }

    public RelativeLayout a(int i2) {
        RelativeLayout relativeLayout = new RelativeLayout(this.f255h);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.setBackgroundColor(-1);
        RelativeLayout relativeLayout2 = new RelativeLayout(this.f255h);
        relativeLayout2.setId(ResHelper.getIdRes(this.f255h, "ssdk_sina_web_title_id"));
        relativeLayout2.setBackgroundColor(-131587);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, ResHelper.dipToPx(this.f255h, 55));
        layoutParams.addRule(10);
        relativeLayout.addView(relativeLayout2, layoutParams);
        TextView textView = new TextView(this.f255h);
        this.a = textView;
        textView.setTextSize(1, 17.0f);
        this.a.setTextColor(cn.sharesdk.sina.weibo.sdk.a.a(-32256, 1728020992));
        int stringRes = ResHelper.getStringRes(this.f255h, "ssdk_sina_web_close");
        if (stringRes > 0) {
            this.a.setText(stringRes);
        }
        int dipToPx = ResHelper.dipToPx(this.f255h, 10);
        this.a.setPadding(dipToPx, 0, dipToPx, 0);
        this.a.setOnTouchListener(new View.OnTouchListener() { // from class: cn.sharesdk.sina.weibo.sdk.a.a.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    view.setBackgroundColor(-1);
                    return false;
                } else if (motionEvent.getAction() == 1) {
                    view.setBackgroundColor(-131587);
                    return false;
                } else {
                    return false;
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(15);
        relativeLayout2.addView(this.a, layoutParams2);
        TextView textView2 = new TextView(this.f255h);
        this.b = textView2;
        textView2.setTextColor(-11382190);
        this.b.setTextSize(1, 18.0f);
        if (i2 > 0) {
            this.b.setText(i2);
        }
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(13);
        relativeLayout2.addView(this.b, layoutParams3);
        this.c = new WebView(this.f255h);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams4.addRule(3, relativeLayout2.getId());
        relativeLayout.addView(this.c, layoutParams4);
        this.f251d = new LoadingBar(this.f255h);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, ResHelper.dipToPx(this.f255h, 3));
        layoutParams5.addRule(3, relativeLayout2.getId());
        relativeLayout.addView(this.f251d, layoutParams5);
        View view = new View(this.f255h);
        int bitmapRes = ResHelper.getBitmapRes(this.f255h, "ssdk_weibo_common_shadow_top");
        if (bitmapRes > 0) {
            view.setBackgroundResource(bitmapRes);
        }
        relativeLayout.addView(view, layoutParams5);
        LinearLayout linearLayout = new LinearLayout(this.f255h);
        this.f252e = linearLayout;
        linearLayout.setVisibility(8);
        VdsAgent.onSetViewVisibility(linearLayout, 8);
        this.f252e.setGravity(17);
        this.f252e.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams6.addRule(13);
        relativeLayout.addView(this.f252e, layoutParams6);
        ImageView imageView = new ImageView(this.f255h);
        int bitmapRes2 = ResHelper.getBitmapRes(this.f255h, "ssdk_weibo_empty_failed");
        if (bitmapRes2 > 0) {
            imageView.setImageResource(bitmapRes2);
        }
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams7.bottomMargin = ResHelper.dipToPx(this.f255h, 8);
        this.f252e.addView(imageView, layoutParams7);
        this.f253f = new TextView(this.f255h);
        int stringRes2 = ResHelper.getStringRes(this.f255h, "ssdk_sina_web_net_error");
        if (stringRes2 > 0) {
            this.f253f.setText(stringRes2);
        }
        this.f253f.setTextColor(-4342339);
        this.f253f.setTextSize(1, 14.0f);
        this.f252e.addView(this.f253f, new LinearLayout.LayoutParams(-2, -2));
        Button button = new Button(this.f255h);
        this.f254g = button;
        button.setTextColor(-8882056);
        this.f254g.setGravity(17);
        this.f254g.setTextSize(1, 16.0f);
        int stringRes3 = ResHelper.getStringRes(this.f255h, "ssdk_sina_web_refresh");
        if (stringRes3 > 0) {
            this.f254g.setText(stringRes3);
        }
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(ResHelper.dipToPx(this.f255h, 142), ResHelper.dipToPx(this.f255h, 46));
        layoutParams8.topMargin = dipToPx;
        this.f252e.addView(this.f254g, layoutParams8);
        e();
        return relativeLayout;
    }

    public Button a() {
        return this.f254g;
    }
}
