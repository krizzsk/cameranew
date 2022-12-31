package vStudio.Android.Camera360.guide;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pinguo.camera360.camera.controller.VipHalfScreenController;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.base.BaseFragment;
import us.pinguo.ui.widget.FixedJsWebView;
import us.pinguo.webview.PGBaseWebSettings;
import us.pinguo.webview.PGJsWebView;
import vStudio.Android.Camera360.R;
import vStudio.Android.Camera360.activity.CameraActivity;
import vStudio.Android.Camera360.guide.PrivacyFragment;
/* compiled from: PrivacyFragment.kt */
/* loaded from: classes7.dex */
public final class PrivacyFragment extends BaseFragment {
    public Map<Integer, View> a = new LinkedHashMap();
    private PGJsWebView b;
    private View c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f12610d;

    /* compiled from: PrivacyFragment.kt */
    /* loaded from: classes7.dex */
    public static final class a extends WebViewClient {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(WebView view, String str) {
            s.h(view, "$view");
            try {
                view.loadUrl(str);
                VdsAgent.loadUrl(view, str);
            } catch (Exception unused) {
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(final WebView view, final String str) {
            s.h(view, "view");
            if (str == null) {
                return false;
            }
            FragmentActivity activity = PrivacyFragment.this.getActivity();
            if (activity == null) {
                return true;
            }
            activity.runOnUiThread(new Runnable() { // from class: vStudio.Android.Camera360.guide.e
                @Override // java.lang.Runnable
                public final void run() {
                    PrivacyFragment.a.b(view, str);
                }
            });
            return true;
        }
    }

    private final String b0(String str) {
        return s.c(VipHalfScreenController.URL_PRIVACY, str) ? "https://www.camera360.com/privacy_zh_cn_adr.html" : "https://www.camera360.com/disclaimer.html";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(PrivacyFragment this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        s.h(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null && (activity instanceof CameraActivity)) {
            ((CameraActivity) activity).x0(null);
        }
    }

    public void _$_clearFindViewByIdCache() {
        this.a.clear();
    }

    public final void e0(String url) {
        s.h(url, "url");
        PGJsWebView pGJsWebView = this.b;
        if (pGJsWebView != null) {
            pGJsWebView.setWebChromeClient(new WebChromeClient() { // from class: vStudio.Android.Camera360.guide.PrivacyFragment$setUrl$1
                @Override // android.webkit.WebChromeClient
                public void onProgressChanged(WebView webView, int i2) {
                    VdsAgent.onProgressChangedStart(webView, i2);
                    super.onProgressChanged(webView, i2);
                    VdsAgent.onProgressChangedEnd(webView, i2);
                }

                @Override // android.webkit.WebChromeClient
                public void onReceivedTitle(WebView view, String title) {
                    TextView textView;
                    s.h(view, "view");
                    s.h(title, "title");
                    super.onReceivedTitle(view, title);
                    textView = PrivacyFragment.this.f12610d;
                    if (textView != null) {
                        textView.setText(title);
                    } else {
                        s.z("titleView");
                        throw null;
                    }
                }
            });
            PGJsWebView pGJsWebView2 = this.b;
            if (pGJsWebView2 != null) {
                pGJsWebView2.loadUrl(b0(url));
                return;
            } else {
                s.z("webview");
                throw null;
            }
        }
        s.z("webview");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        s.h(inflater, "inflater");
        return inflater.inflate(R.layout.layout_privacy, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        String string;
        s.h(view, "view");
        super.onViewCreated(view, bundle);
        FixedJsWebView fixedJsWebView = (FixedJsWebView) view.findViewById(R.id.js_webview);
        s.g(fixedJsWebView, "view.js_webview");
        this.b = fixedJsWebView;
        if (fixedJsWebView != null) {
            fixedJsWebView.h(null, new PGBaseWebSettings(getContext()), null);
            PGJsWebView pGJsWebView = this.b;
            if (pGJsWebView != null) {
                WebSettings settings = pGJsWebView.getSettings();
                s.g(settings, "webview.settings");
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 16) {
                    settings.setAllowFileAccessFromFileURLs(false);
                    settings.setAllowUniversalAccessFromFileURLs(false);
                }
                if (i2 >= 21) {
                    settings.setMixedContentMode(2);
                }
                PGJsWebView pGJsWebView2 = this.b;
                if (pGJsWebView2 != null) {
                    pGJsWebView2.setWebViewClient(new a());
                    ImageView imageView = (ImageView) view.findViewById(R.id.title_back_btn);
                    s.g(imageView, "view.title_back_btn");
                    this.c = imageView;
                    TextView textView = (TextView) view.findViewById(R.id.title_text_title);
                    s.g(textView, "view.title_text_title");
                    this.f12610d = textView;
                    View view2 = this.c;
                    if (view2 != null) {
                        view2.setOnClickListener(new View.OnClickListener() { // from class: vStudio.Android.Camera360.guide.d
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view3) {
                                PrivacyFragment.d0(PrivacyFragment.this, view3);
                            }
                        });
                        Bundle arguments = getArguments();
                        String str = VipHalfScreenController.URL_PRIVACY;
                        if (arguments != null && (string = arguments.getString("url")) != null) {
                            str = string;
                        }
                        e0(str);
                        return;
                    }
                    s.z("backView");
                    throw null;
                }
                s.z("webview");
                throw null;
            }
            s.z("webview");
            throw null;
        }
        s.z("webview");
        throw null;
    }
}
