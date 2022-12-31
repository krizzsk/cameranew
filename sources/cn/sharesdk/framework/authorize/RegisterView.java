package cn.sharesdk.framework.authorize;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.sharesdk.framework.TitleLayout;
import cn.sharesdk.framework.utils.SSDKLog;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.mob.tools.utils.ResHelper;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class RegisterView extends ResizeLayout {
    private TitleLayout a;
    private RelativeLayout b;
    private WebView c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f74d;

    public RegisterView(Context context) {
        super(context);
        a(context);
    }

    private int b(Context context) {
        WindowManager windowManager;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if ((context instanceof Activity) && (windowManager = ((Activity) context).getWindowManager()) != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.widthPixels;
        }
        return 0;
    }

    public TitleLayout c() {
        return this.a;
    }

    public RelativeLayout d() {
        return this.b;
    }

    private void a(Context context) {
        setBackgroundColor(-1);
        setOrientation(1);
        final int b = b(context);
        this.a = new TitleLayout(context);
        try {
            int bitmapRes = ResHelper.getBitmapRes(context, "ssdk_auth_title_back");
            if (bitmapRes > 0) {
                this.a.setBackgroundResource(bitmapRes);
            }
        } catch (Throwable th) {
            SSDKLog.b().d(th);
        }
        TextView btnRight = this.a.getBtnRight();
        btnRight.setVisibility(8);
        VdsAgent.onSetViewVisibility(btnRight, 8);
        int stringRes = ResHelper.getStringRes(getContext(), "ssdk_weibo_oauth_regiseter");
        if (stringRes > 0) {
            this.a.getTvTitle().setText(stringRes);
        }
        addView(this.a);
        ImageView imageView = new ImageView(context);
        int bitmapRes2 = ResHelper.getBitmapRes(context, "ssdk_logo");
        if (bitmapRes2 > 0) {
            imageView.setImageResource(bitmapRes2);
        }
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setPadding(0, 0, ResHelper.dipToPx(context, 10), 0);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: cn.sharesdk.framework.authorize.RegisterView.1
            @Override // android.view.View.OnClickListener
            @Instrumented
            public void onClick(View view) {
                VdsAgent.onClick(this, view);
                try {
                    int stringRes2 = ResHelper.getStringRes(view.getContext(), "ssdk_website");
                    String string = stringRes2 > 0 ? view.getResources().getString(stringRes2) : null;
                    if (TextUtils.isEmpty(string)) {
                        return;
                    }
                    view.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(string)));
                } catch (Throwable th2) {
                    SSDKLog.b().d(th2);
                }
            }
        });
        this.a.addView(imageView);
        this.b = new RelativeLayout(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 1.0f;
        this.b.setLayoutParams(layoutParams);
        addView(this.b);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.b.addView(linearLayout);
        TextView textView = new TextView(context);
        this.f74d = textView;
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, 5));
        this.f74d.setBackgroundColor(-12929302);
        linearLayout.addView(this.f74d);
        TextView textView2 = this.f74d;
        textView2.setVisibility(8);
        VdsAgent.onSetViewVisibility(textView2, 8);
        WebView webView = new WebView(context);
        this.c = webView;
        webView.getSettings().setAllowFileAccess(false);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 16) {
            this.c.getSettings().setAllowFileAccessFromFileURLs(false);
            this.c.getSettings().setAllowUniversalAccessFromFileURLs(false);
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams2.weight = 1.0f;
        this.c.setLayoutParams(layoutParams2);
        WebChromeClient webChromeClient = new WebChromeClient() { // from class: cn.sharesdk.framework.authorize.RegisterView.2
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView2, int i3) {
                VdsAgent.onProgressChangedStart(webView2, i3);
                super.onProgressChanged(webView2, i3);
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) RegisterView.this.f74d.getLayoutParams();
                layoutParams3.width = (b * i3) / 100;
                RegisterView.this.f74d.setLayoutParams(layoutParams3);
                if (i3 <= 0 || i3 >= 100) {
                    TextView textView3 = RegisterView.this.f74d;
                    textView3.setVisibility(8);
                    VdsAgent.onSetViewVisibility(textView3, 8);
                } else {
                    TextView textView4 = RegisterView.this.f74d;
                    textView4.setVisibility(0);
                    VdsAgent.onSetViewVisibility(textView4, 0);
                }
                VdsAgent.onProgressChangedEnd(webView2, i3);
            }
        };
        if (i2 > 10 && i2 < 17) {
            try {
                Method method = this.c.getClass().getMethod("removeJavascriptInterface", String.class);
                method.setAccessible(true);
                method.invoke(this.c, "searchBoxJavaBridge_");
            } catch (Throwable th2) {
                SSDKLog.b().d(th2);
            }
        }
        WebView webView2 = this.c;
        webView2.setWebChromeClient(webChromeClient);
        VdsAgent.setWebChromeClient(webView2, webChromeClient);
        linearLayout.addView(this.c);
        this.c.requestFocus();
    }

    public RegisterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public WebView b() {
        return this.c;
    }

    public View a() {
        return this.a.getBtnBack();
    }

    public void a(boolean z) {
        TitleLayout titleLayout = this.a;
        int i2 = z ? 8 : 0;
        titleLayout.setVisibility(i2);
        VdsAgent.onSetViewVisibility(titleLayout, i2);
    }
}
