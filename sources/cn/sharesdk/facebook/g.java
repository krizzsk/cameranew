package cn.sharesdk.facebook;

import android.os.Bundle;
import android.webkit.WebView;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.tools.utils.ResHelper;
import us.pinguo.inspire.module.MissionDetail.TaskDetailBasePresenter;
/* compiled from: FacebookWebViewClient.java */
/* loaded from: classes.dex */
public class g extends cn.sharesdk.framework.authorize.c {
    public g(cn.sharesdk.framework.authorize.g gVar) {
        super(gVar);
    }

    @Override // cn.sharesdk.framework.authorize.c
    protected void onComplete(String str) {
        int i2;
        Bundle urlToBundle = ResHelper.urlToBundle(str);
        String string = urlToBundle.getString("error_message");
        if (string != null && this.listener != null) {
            string = "error_message ==>>" + string + "\nerror_code ==>>" + urlToBundle.getString("error_code");
            this.listener.onError(new Throwable(str));
        }
        if (string == null) {
            String string2 = urlToBundle.getString("access_token");
            String string3 = urlToBundle.containsKey("expires_in") ? urlToBundle.getString("expires_in") : TaskDetailBasePresenter.SCENE_LIST;
            if (this.listener != null) {
                Bundle bundle = new Bundle();
                bundle.putString("oauth_token", string2);
                bundle.putString("oauth_token_secret", "");
                try {
                    i2 = ResHelper.parseInt(string3);
                } catch (Throwable th) {
                    SSDKLog.b().d(th);
                    i2 = -1;
                }
                bundle.putInt("oauth_token_expires", i2);
                this.listener.onComplete(bundle);
            }
        }
    }

    @Override // cn.sharesdk.framework.g, android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        try {
            String str2 = this.redirectUri;
            if (str2 != null && str.startsWith(str2)) {
                webView.stopLoading();
                webView.postDelayed(new Runnable() { // from class: cn.sharesdk.facebook.g.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ((cn.sharesdk.framework.authorize.c) g.this).activity.finish();
                    }
                }, 500L);
                onComplete(str);
                return true;
            }
        } catch (Exception e2) {
            SSDKLog.b().e(e2.getMessage(), new Object[0]);
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }
}
