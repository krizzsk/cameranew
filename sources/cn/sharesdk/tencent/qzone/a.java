package cn.sharesdk.tencent.qzone;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.g;
import cn.sharesdk.framework.utils.SSDKLog;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.mob.tools.utils.DeviceHelper;
import com.tencent.connect.common.Constants;
import java.net.URLDecoder;
import java.util.HashMap;
/* compiled from: QZoneAuthorizeWebviewClient.java */
/* loaded from: classes.dex */
public class a extends cn.sharesdk.framework.authorize.c {
    public a(g gVar) {
        super(gVar);
    }

    private void a(HashMap<String, String> hashMap) {
        String str = hashMap.get("access_token");
        String str2 = hashMap.get("expires_in");
        String str3 = hashMap.get("error");
        String str4 = hashMap.get("error_description");
        String str5 = hashMap.get(Constants.PARAM_PLATFORM_ID);
        String str6 = hashMap.get("pfkey");
        String str7 = hashMap.get("pay_token");
        if (!TextUtils.isEmpty(str)) {
            try {
                HashMap<String, Object> e2 = b.a(this.activity.a().getPlatform()).e(str);
                if (e2 != null && e2.size() > 0) {
                    if (!e2.containsKey("openid")) {
                        AuthorizeListener authorizeListener = this.listener;
                        if (authorizeListener != null) {
                            authorizeListener.onError(new Throwable());
                            return;
                        }
                        return;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("access_token", str);
                    bundle.putString("open_id", String.valueOf(e2.get("openid")));
                    bundle.putString("expires_in", str2);
                    bundle.putString(Constants.PARAM_PLATFORM_ID, str5);
                    bundle.putString("pfkey", str6);
                    bundle.putString("pay_token", str7);
                    AuthorizeListener authorizeListener2 = this.listener;
                    if (authorizeListener2 != null) {
                        authorizeListener2.onComplete(bundle);
                        return;
                    }
                    return;
                }
                AuthorizeListener authorizeListener3 = this.listener;
                if (authorizeListener3 != null) {
                    authorizeListener3.onError(new Throwable());
                }
            } catch (Throwable th) {
                AuthorizeListener authorizeListener4 = this.listener;
                if (authorizeListener4 != null) {
                    authorizeListener4.onError(th);
                }
            }
        } else if (!TextUtils.isEmpty(str3)) {
            String str8 = str4 + " (" + str3 + ")";
            AuthorizeListener authorizeListener5 = this.listener;
            if (authorizeListener5 != null) {
                authorizeListener5.onError(new Throwable(str8));
            }
        } else {
            this.listener.onError(new Throwable());
        }
    }

    @Override // cn.sharesdk.framework.authorize.c
    protected void onComplete(String str) {
        if (str.startsWith(this.redirectUri)) {
            str = str.substring(str.indexOf(35) + 1);
        }
        String[] split = str.split("&");
        HashMap<String, String> hashMap = new HashMap<>();
        for (String str2 : split) {
            String[] split2 = str2.split("=");
            if (split2.length < 2) {
                hashMap.put(URLDecoder.decode(split2[0]), "");
            } else {
                hashMap.put(URLDecoder.decode(split2[0]), URLDecoder.decode(split2[1] != null ? split2[1] : ""));
            }
        }
        a(hashMap);
    }

    @Override // cn.sharesdk.framework.g, android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, final SslErrorHandler sslErrorHandler, SslError sslError) {
        String[] strArr;
        String str;
        String str2;
        if (webView.getContext() instanceof Activity) {
            Activity activity = (Activity) webView.getContext();
            if ("zh".equals(DeviceHelper.getInstance(activity).getOSLanguage())) {
                strArr = new String[]{String.valueOf(new char[]{19981, 21463, 20449, 20219, 30340, 35777, 20070, 12290, 20320, 35201, 32487, 32493, 21527, 65311}), String.valueOf(new char[]{35777, 20070, 24050, 36807, 26399, 12290, 20320, 35201, 32487, 32493, 21527, 65311}), String.valueOf(new char[]{35777, 20070, 'I', 'D', 19981, 21305, 37197, 12290, 20320, 35201, 32487, 32493, 21527, 65311}), String.valueOf(new char[]{35777, 20070, 23578, 26410, 29983, 25928, 12290, 20320, 35201, 32487, 32493, 21527, 65311}), String.valueOf(new char[]{35777, 20070, 38169, 35823, 12290, 20320, 35201, 32487, 32493, 21527, 65311})};
                str = String.valueOf(new char[]{35777, 20070, 38169, 35823});
                String.valueOf(new char[]{32487, 32493});
                str2 = String.valueOf(new char[]{20572, 27490});
            } else {
                strArr = new String[]{"Certificate is untrusted. Do you want to continue anyway?", "Certificate has expired. Do you want to continue anyway?", "Certificate ID is mismatched. Do you want to continue anyway?", "Certificate is not yet valid. Do you want to continue anyway?", "Certificate error. Do you want to continue anyway?"};
                str = "SSL Certificate Error";
                str2 = "No";
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setTitle(str);
            int primaryError = sslError.getPrimaryError();
            if (primaryError == 0) {
                builder.setMessage(strArr[3]);
            } else if (primaryError == 1) {
                builder.setMessage(strArr[1]);
            } else if (primaryError == 2) {
                builder.setMessage(strArr[2]);
            } else if (primaryError != 3) {
                builder.setMessage(strArr[4]);
            } else {
                builder.setMessage(strArr[0]);
            }
            builder.setCancelable(false);
            builder.setNegativeButton(str2, new DialogInterface.OnClickListener() { // from class: cn.sharesdk.tencent.qzone.a.2
                @Override // android.content.DialogInterface.OnClickListener
                @Instrumented
                public void onClick(DialogInterface dialogInterface, int i2) {
                    VdsAgent.onClick(this, dialogInterface, i2);
                    dialogInterface.dismiss();
                    sslErrorHandler.cancel();
                }
            });
            try {
                AlertDialog create = builder.create();
                create.show();
                VdsAgent.showDialog(create);
                return;
            } catch (Throwable th) {
                SSDKLog.b().w(th);
                return;
            }
        }
        sslErrorHandler.cancel();
    }

    @Override // cn.sharesdk.framework.g, android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, final String str) {
        if (str.startsWith(this.redirectUri)) {
            webView.setVisibility(4);
            VdsAgent.onSetViewVisibility(webView, 4);
            webView.stopLoading();
            this.activity.finish();
            new Thread() { // from class: cn.sharesdk.tencent.qzone.a.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        a.this.onComplete(str);
                    } catch (Throwable th) {
                        SSDKLog.b().d(th);
                    }
                }
            }.start();
            return true;
        }
        webView.loadUrl(str);
        VdsAgent.loadUrl(webView, str);
        return true;
    }
}
