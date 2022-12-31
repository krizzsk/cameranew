package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Message;
import android.support.v4.media.session.PlaybackStateCompat;
import android.view.View;
import android.view.WindowManager;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@TargetApi(11)
/* loaded from: classes2.dex */
public final class zzbdt extends WebChromeClient {
    private final zzbeb zzdjd;

    public zzbdt(zzbeb zzbebVar) {
        this.zzdjd = zzbebVar;
    }

    private final boolean zza(Context context, String str, String str2, String str3, String str4, JsResult jsResult, JsPromptResult jsPromptResult, boolean z) {
        zzbeb zzbebVar;
        com.google.android.gms.ads.internal.zza zzado;
        try {
            zzbebVar = this.zzdjd;
        } catch (WindowManager.BadTokenException e2) {
            zzazk.zzd("Fail to display Dialog.", e2);
        }
        if (zzbebVar != null && zzbebVar.zzacx() != null && this.zzdjd.zzacx().zzado() != null && (zzado = this.zzdjd.zzacx().zzado()) != null && !zzado.zzjy()) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 11 + String.valueOf(str3).length());
            sb.append("window.");
            sb.append(str);
            sb.append("('");
            sb.append(str3);
            sb.append("')");
            zzado.zzbk(sb.toString());
            return false;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(str2);
        if (z) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            TextView textView = new TextView(context);
            textView.setText(str3);
            EditText editText = new EditText(context);
            editText.setText(str4);
            linearLayout.addView(textView);
            linearLayout.addView(editText);
            AlertDialog create = builder.setView(linearLayout).setPositiveButton(17039370, new zzbdz(jsPromptResult, editText)).setNegativeButton(17039360, new zzbea(jsPromptResult)).setOnCancelListener(new zzbdx(jsPromptResult)).create();
            create.show();
            VdsAgent.showDialog(create);
        } else {
            AlertDialog create2 = builder.setMessage(str3).setPositiveButton(17039370, new zzbdy(jsResult)).setNegativeButton(17039360, new zzbdv(jsResult)).setOnCancelListener(new zzbdw(jsResult)).create();
            create2.show();
            VdsAgent.showDialog(create2);
        }
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final void onCloseWindow(WebView webView) {
        if (!(webView instanceof zzbeb)) {
            zzazk.zzex("Tried to close a WebView that wasn't an AdWebView.");
            return;
        }
        com.google.android.gms.ads.internal.overlay.zzc zzact = ((zzbeb) webView).zzact();
        if (zzact == null) {
            zzazk.zzex("Tried to close an AdWebView not associated with an overlay.");
        } else {
            zzact.close();
        }
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String message = consoleMessage.message();
        String sourceId = consoleMessage.sourceId();
        int lineNumber = consoleMessage.lineNumber();
        StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 19 + String.valueOf(sourceId).length());
        sb.append("JS: ");
        sb.append(message);
        sb.append(" (");
        sb.append(sourceId);
        sb.append(":");
        sb.append(lineNumber);
        sb.append(")");
        String sb2 = sb.toString();
        if (sb2.contains("Application Cache")) {
            return super.onConsoleMessage(consoleMessage);
        }
        int i2 = zzbec.zzeqs[consoleMessage.messageLevel().ordinal()];
        if (i2 == 1) {
            zzazk.zzev(sb2);
        } else if (i2 == 2) {
            zzazk.zzex(sb2);
        } else if (i2 == 3 || i2 == 4) {
            zzazk.zzew(sb2);
        } else if (i2 != 5) {
            zzazk.zzew(sb2);
        } else {
            zzazk.zzdy(sb2);
        }
        return super.onConsoleMessage(consoleMessage);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        WebView.WebViewTransport webViewTransport = (WebView.WebViewTransport) message.obj;
        WebView webView2 = new WebView(webView.getContext());
        if (this.zzdjd.zzacy() != null) {
            webView2.setWebViewClient(this.zzdjd.zzacy());
        }
        webViewTransport.setWebView(webView2);
        message.sendToTarget();
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final void onExceededDatabaseQuota(String str, String str2, long j2, long j3, long j4, WebStorage.QuotaUpdater quotaUpdater) {
        long j5 = 5242880 - j4;
        if (j5 <= 0) {
            quotaUpdater.updateQuota(j2);
            return;
        }
        if (j2 != 0) {
            if (j3 == 0) {
                j2 = Math.min(j2 + Math.min(131072L, j5), (long) PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
            } else if (j3 <= Math.min(PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED - j2, j5)) {
                j2 += j3;
            }
            j3 = j2;
        } else if (j3 > j5 || j3 > PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
            j3 = 0;
        }
        quotaUpdater.updateQuota(j3);
    }

    @Override // android.webkit.WebChromeClient
    public final void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        boolean z;
        if (callback != null) {
            com.google.android.gms.ads.internal.zzr.zzkr();
            if (!com.google.android.gms.ads.internal.util.zzj.zzp(this.zzdjd.getContext(), "android.permission.ACCESS_FINE_LOCATION")) {
                com.google.android.gms.ads.internal.zzr.zzkr();
                if (!com.google.android.gms.ads.internal.util.zzj.zzp(this.zzdjd.getContext(), "android.permission.ACCESS_COARSE_LOCATION")) {
                    z = false;
                    callback.invoke(str, z, true);
                }
            }
            z = true;
            callback.invoke(str, z, true);
        }
    }

    @Override // android.webkit.WebChromeClient
    public final void onHideCustomView() {
        com.google.android.gms.ads.internal.overlay.zzc zzact = this.zzdjd.zzact();
        if (zzact == null) {
            zzazk.zzex("Could not get ad overlay when hiding custom view.");
        } else {
            zzact.zzvu();
        }
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zza(webView), "alert", str, str2, null, jsResult, null, false);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zza(webView), "onBeforeUnload", str, str2, null, jsResult, null, false);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zza(webView), "confirm", str, str2, null, jsResult, null, false);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return zza(zza(webView), "prompt", str, str2, str3, null, jsPromptResult, true);
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i2) {
        VdsAgent.onProgressChangedStart(webView, i2);
        super.onProgressChanged(webView, i2);
        VdsAgent.onProgressChangedEnd(webView, i2);
    }

    @Override // android.webkit.WebChromeClient
    public final void onReachedMaxAppCacheSize(long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        long j4 = j2 + 131072;
        if (5242880 - j3 < j4) {
            quotaUpdater.updateQuota(0L);
        } else {
            quotaUpdater.updateQuota(j4);
        }
    }

    @Override // android.webkit.WebChromeClient
    public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        onShowCustomView(view, -1, customViewCallback);
    }

    @Override // android.webkit.WebChromeClient
    @Deprecated
    public final void onShowCustomView(View view, int i2, WebChromeClient.CustomViewCallback customViewCallback) {
        com.google.android.gms.ads.internal.overlay.zzc zzact = this.zzdjd.zzact();
        if (zzact == null) {
            zzazk.zzex("Could not get ad overlay when showing custom view.");
            customViewCallback.onCustomViewHidden();
            return;
        }
        zzact.zza(view, customViewCallback);
        zzact.setRequestedOrientation(i2);
    }

    private static Context zza(WebView webView) {
        if (!(webView instanceof zzbeb)) {
            return webView.getContext();
        }
        zzbeb zzbebVar = (zzbeb) webView;
        Activity zzabe = zzbebVar.zzabe();
        return zzabe != null ? zzabe : zzbebVar.getContext();
    }
}
