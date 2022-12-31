package com.facebook.internal;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: FacebookWebFallbackDialog.java */
/* loaded from: classes.dex */
public class j extends WebDialog {
    private static final String q = j.class.getName();
    private boolean p;

    /* compiled from: FacebookWebFallbackDialog.java */
    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                j.super.cancel();
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    private j(Context context, String str, String str2) {
        super(context, str);
        v(str2);
    }

    public static j A(Context context, String str, String str2) {
        WebDialog.n(context);
        return new j(context, str, str2);
    }

    @Override // com.facebook.internal.WebDialog, android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        WebView m = m();
        if (p() && !o() && m != null && m.isShown()) {
            if (this.p) {
                return;
            }
            this.p = true;
            String str = "javascript:(function() {  var event = document.createEvent('Event');  event.initEvent('fbPlatformDialogMustClose',true,true);  document.dispatchEvent(event);})();";
            m.loadUrl(str);
            VdsAgent.loadUrl(m, str);
            new Handler(Looper.getMainLooper()).postDelayed(new a(), 1500L);
            return;
        }
        super.cancel();
    }

    @Override // com.facebook.internal.WebDialog
    protected Bundle r(String str) {
        Bundle e0 = x.e0(Uri.parse(str).getQuery());
        String string = e0.getString("bridge_args");
        e0.remove("bridge_args");
        if (!x.S(string)) {
            try {
                e0.putBundle("com.facebook.platform.protocol.BRIDGE_ARGS", c.a(new JSONObject(string)));
            } catch (JSONException e2) {
                x.Z(q, "Unable to parse bridge_args JSON", e2);
            }
        }
        String string2 = e0.getString("method_results");
        e0.remove("method_results");
        if (!x.S(string2)) {
            if (x.S(string2)) {
                string2 = "{}";
            }
            try {
                e0.putBundle("com.facebook.platform.protocol.RESULT_ARGS", c.a(new JSONObject(string2)));
            } catch (JSONException e3) {
                x.Z(q, "Unable to parse bridge_args JSON", e3);
            }
        }
        e0.remove("version");
        e0.putInt("com.facebook.platform.protocol.PROTOCOL_VERSION", t.x());
        return e0;
    }
}
