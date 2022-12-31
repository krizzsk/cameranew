package us.pinguo.advstrategy;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import us.pinguo.advsdk.a.g;
import us.pinguo.advsdk.bean.AdsItem;
import us.pinguo.advsdk.manager.PgAdvManager;
import us.pinguo.advsdk.utils.a;
import us.pinguo.advsdk.utils.b;
/* loaded from: classes3.dex */
class MyWebView extends WebView {
    private String GP_HOST;
    private String GP_PRIX;
    private final String JS_GETCONTENT;
    private final String JS_NAME;
    public final String LOCAL_UPLOADFILE_PATH;
    private g mCallback;
    private AdsItem mCurItem;
    private List<String> mSetUrls;

    /* loaded from: classes3.dex */
    public final class InJavaScriptLocalObj {
        public InJavaScriptLocalObj() {
        }

        @JavascriptInterface
        public void showDescription(String str) {
            b.a("Detect Html desc:" + str);
        }

        @JavascriptInterface
        public void showSource(String str) {
            b.a("Detect Html content:" + str);
            if (str == null || TextUtils.isEmpty(str)) {
                return;
            }
            String saveAdvData = MyWebView.this.saveAdvData(str.getBytes());
            if (MyWebView.this.mCallback == null || MyWebView.this.mSetUrls.size() <= 0) {
                return;
            }
            MyWebView.this.mCallback.a(MyWebView.this.mCurItem, (String) MyWebView.this.mSetUrls.get(MyWebView.this.mSetUrls.size() - 1), 3, saveAdvData);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class MyWebViewClient extends WebViewClient {
        MyWebViewClient() {
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView webView, String str) {
            super.onLoadResource(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            b.a("Detect onPageFinished:" + str);
            webView.loadUrl("javascript:window.java_obj.showSource(document.getElementsByTagName('html')[0].innerHTML);");
            VdsAgent.loadUrl(webView, "javascript:window.java_obj.showSource(document.getElementsByTagName('html')[0].innerHTML);");
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (!MyWebView.this.mSetUrls.contains(str)) {
                MyWebView.this.mSetUrls.add(str);
            }
            if (MyWebView.this.checkUrlisGp(str)) {
                MyWebView.this.stopLoading();
                if (MyWebView.this.mCallback != null) {
                    MyWebView.this.mCallback.a(MyWebView.this.mCurItem, str, 1, null);
                }
            }
            b.a("Detect onPageStarted:" + str);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            MyWebView.this.stopLoading();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            super.shouldOverrideUrlLoading(webView, webResourceRequest);
            if (Build.VERSION.SDK_INT >= 4) {
                String uri = webResourceRequest.getUrl().toString();
                b.a("Detect shouldOverrideUrlLoading:" + uri);
                return true;
            }
            return true;
        }
    }

    public MyWebView(Context context) {
        super(context);
        this.JS_NAME = "java_obj";
        this.GP_PRIX = "market://";
        this.GP_HOST = "https://play.google.com";
        this.JS_GETCONTENT = "javascript:window.java_obj.showSource(document.getElementsByTagName('html')[0].innerHTML);";
        this.LOCAL_UPLOADFILE_PATH = "/upload_file/interim.txt";
        initData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkUrlisGp(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(this.GP_PRIX) || str.startsWith(this.GP_HOST);
    }

    private synchronized void clearAdvData() {
        String advDir = getAdvDir(getContext());
        if (TextUtils.isEmpty(advDir)) {
            return;
        }
        try {
            new File(advDir + "/upload_file/interim.txt").delete();
        } catch (Exception unused) {
        }
    }

    private String getAdvDir(Context context) {
        File filesDir;
        if (context == null || (filesDir = context.getFilesDir()) == null) {
            return null;
        }
        return filesDir.getAbsolutePath();
    }

    private void initData() {
        String userAgent = PgAdvManager.getInstance().i().getUserAgent();
        WebSettings settings = getSettings();
        if (!TextUtils.isEmpty(userAgent)) {
            settings.setUserAgentString(userAgent);
        }
        settings.setJavaScriptEnabled(true);
        setWebViewClient(new MyWebViewClient());
        addJavascriptInterface(new InJavaScriptLocalObj(), "java_obj");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized String saveAdvData(byte[] bArr) {
        clearAdvData();
        String advDir = getAdvDir(getContext());
        if (TextUtils.isEmpty(advDir)) {
            b.a("dirpath is null");
            return null;
        }
        String str = advDir + "/upload_file/interim.txt";
        try {
            b.a("save path:" + str);
            a.g(bArr, str);
            return str;
        } catch (IOException unused) {
            return null;
        }
    }

    public void startLoadItem(AdsItem adsItem, g gVar) {
        if (adsItem == null) {
            return;
        }
        this.mCurItem = adsItem;
        this.mCallback = gVar;
        this.mSetUrls = new ArrayList();
        stopLoading();
        if (TextUtils.isEmpty(this.mCurItem.clickUrl)) {
            return;
        }
        String str = this.mCurItem.clickUrl;
        loadUrl(str);
        VdsAgent.loadUrl(this, str);
        b.a("Detect src Url:" + this.mCurItem.clickUrl);
    }

    public MyWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.JS_NAME = "java_obj";
        this.GP_PRIX = "market://";
        this.GP_HOST = "https://play.google.com";
        this.JS_GETCONTENT = "javascript:window.java_obj.showSource(document.getElementsByTagName('html')[0].innerHTML);";
        this.LOCAL_UPLOADFILE_PATH = "/upload_file/interim.txt";
        initData();
    }

    public MyWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.JS_NAME = "java_obj";
        this.GP_PRIX = "market://";
        this.GP_HOST = "https://play.google.com";
        this.JS_GETCONTENT = "javascript:window.java_obj.showSource(document.getElementsByTagName('html')[0].innerHTML);";
        this.LOCAL_UPLOADFILE_PATH = "/upload_file/interim.txt";
        initData();
    }
}
