package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzabp;
import com.google.android.gms.internal.ads.zzazk;
import com.google.android.gms.internal.ads.zzdzw;
import com.google.android.gms.internal.ads.zzwr;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.common.network.HttpRequest;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzam {
    private final Object a = new Object();
    @GuardedBy("lock")
    private String b = "";
    @GuardedBy("lock")
    private String c = "";
    @GuardedBy("lock")

    /* renamed from: d  reason: collision with root package name */
    private boolean f3476d = false;

    /* renamed from: e  reason: collision with root package name */
    private String f3477e = "";

    private final void a(Context context, String str, boolean z, boolean z2) {
        if (!(context instanceof Activity)) {
            zzazk.zzew("Can not create dialog without Activity Context");
        } else {
            zzj.zzeen.post(new h(this, context, str, z, z2));
        }
    }

    private final String b(Context context) {
        String str;
        synchronized (this.a) {
            if (TextUtils.isEmpty(this.b)) {
                com.google.android.gms.ads.internal.zzr.zzkr();
                String zzr = zzj.zzr(context, "debug_signals_id.txt");
                this.b = zzr;
                if (TextUtils.isEmpty(zzr)) {
                    com.google.android.gms.ads.internal.zzr.zzkr();
                    this.b = zzj.zzyy();
                    com.google.android.gms.ads.internal.zzr.zzkr();
                    zzj.zzc(context, "debug_signals_id.txt", this.b);
                }
            }
            str = this.b;
        }
        return str;
    }

    private final void c(Context context, String str, String str2, String str3) {
        Uri.Builder buildUpon = d(context, (String) zzwr.zzqr().zzd(zzabp.zzcuz), str3, str).buildUpon();
        buildUpon.appendQueryParameter("debugData", str2);
        com.google.android.gms.ads.internal.zzr.zzkr();
        zzj.zzb(context, str, buildUpon.build().toString());
    }

    private final Uri d(Context context, String str, String str2, String str3) {
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        buildUpon.appendQueryParameter("linkedDeviceId", b(context));
        buildUpon.appendQueryParameter("adSlotPath", str2);
        buildUpon.appendQueryParameter("afmaVersion", str3);
        return buildUpon.build();
    }

    private final boolean e(Context context, String str, String str2) {
        String g2 = g(context, d(context, (String) zzwr.zzqr().zzd(zzabp.zzcux), str, str2).toString(), str2);
        if (TextUtils.isEmpty(g2)) {
            zzazk.zzdy("Not linked for in app preview.");
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(g2.trim());
            String optString = jSONObject.optString("gct");
            this.f3477e = jSONObject.optString("status");
            synchronized (this.a) {
                this.c = optString;
            }
            return true;
        } catch (JSONException e2) {
            zzazk.zzd("Fail to get in app preview response json.", e2);
            return false;
        }
    }

    private final boolean f(Context context, String str, String str2) {
        String g2 = g(context, d(context, (String) zzwr.zzqr().zzd(zzabp.zzcuy), str, str2).toString(), str2);
        if (TextUtils.isEmpty(g2)) {
            zzazk.zzdy("Not linked for debug signals.");
            return false;
        }
        try {
            boolean equals = "1".equals(new JSONObject(g2.trim()).optString("debug_mode"));
            synchronized (this.a) {
                this.f3476d = equals;
            }
            return equals;
        } catch (JSONException e2) {
            zzazk.zzd("Fail to get debug mode response json.", e2);
            return false;
        }
    }

    private static String g(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(HttpRequest.HEADER_USER_AGENT, com.google.android.gms.ads.internal.zzr.zzkr().zzq(context, str2));
        zzdzw<String> zzb = new zzay(context).zzb(str, hashMap);
        try {
            return zzb.get(((Integer) zzwr.zzqr().zzd(zzabp.zzcva)).intValue(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e2) {
            String valueOf = String.valueOf(str);
            zzazk.zzc(valueOf.length() != 0 ? "Interrupted while retriving a response from: ".concat(valueOf) : new String("Interrupted while retriving a response from: "), e2);
            zzb.cancel(true);
            return null;
        } catch (TimeoutException e3) {
            String valueOf2 = String.valueOf(str);
            zzazk.zzc(valueOf2.length() != 0 ? "Timeout while retriving a response from: ".concat(valueOf2) : new String("Timeout while retriving a response from: "), e3);
            zzb.cancel(true);
            return null;
        } catch (Exception e4) {
            String valueOf3 = String.valueOf(str);
            zzazk.zzc(valueOf3.length() != 0 ? "Error retriving a response from: ".concat(valueOf3) : new String("Error retriving a response from: "), e4);
            return null;
        }
    }

    private final void h(Context context, String str, String str2) {
        com.google.android.gms.ads.internal.zzr.zzkr();
        zzj.zzb(context, d(context, (String) zzwr.zzqr().zzd(zzabp.zzcuw), str, str2));
    }

    public final void zza(Context context, String str, String str2, @Nullable String str3) {
        boolean zzzm = zzzm();
        if (f(context, str, str2)) {
            if (!zzzm && !TextUtils.isEmpty(str3)) {
                c(context, str2, str3, str);
            }
            zzazk.zzdy("Device is linked for debug signals.");
            a(context, "The device is successfully linked for troubleshooting.", false, true);
            return;
        }
        h(context, str, str2);
    }

    public final boolean zzb(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) || !com.google.android.gms.ads.internal.zzr.zzlb().zzzm()) {
            return false;
        }
        zzazk.zzdy("Sending troubleshooting signals to the server.");
        c(context, str, str2, str3);
        return true;
    }

    public final void zze(Context context, String str, String str2) {
        if (!e(context, str, str2)) {
            a(context, "In-app preview failed to load because of a system error. Please try again later.", true, true);
        } else if ("2".equals(this.f3477e)) {
            zzazk.zzdy("Creative is not pushed for this device.");
            a(context, "There was no creative pushed from DFP to the device.", false, false);
        } else if ("1".equals(this.f3477e)) {
            zzazk.zzdy("The app is not linked for creative preview.");
            h(context, str, str2);
        } else if ("0".equals(this.f3477e)) {
            zzazk.zzdy("Device is linked for in app preview.");
            a(context, "The device is successfully linked for creative preview.", false, true);
        }
    }

    public final String zzzl() {
        String str;
        synchronized (this.a) {
            str = this.c;
        }
        return str;
    }

    public final boolean zzzm() {
        boolean z;
        synchronized (this.a) {
            z = this.f3476d;
        }
        return z;
    }
}
