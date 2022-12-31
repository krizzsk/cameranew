package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Process;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import com.google.android.gms.internal.ads.zzazk;
import com.google.android.gms.internal.ads.zzbeb;
import com.google.android.gms.internal.ads.zzbee;
import com.google.android.gms.internal.ads.zzbfg;
import com.google.android.gms.internal.ads.zztu;
import com.google.android.gms.internal.ads.zzuq;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.Callable;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@TargetApi(16)
/* loaded from: classes2.dex */
public class zzr {
    private zzr() {
    }

    public static zzr zzdg(int i2) {
        if (i2 >= 28) {
            return new zzac();
        }
        if (i2 >= 26) {
            return new zzz();
        }
        if (i2 >= 24) {
            return new zzaa();
        }
        if (i2 >= 21) {
            return new zzx();
        }
        if (i2 >= 19) {
            return new zzy();
        }
        if (i2 >= 18) {
            return new zzv();
        }
        if (i2 >= 17) {
            return new zzw();
        }
        return new zzr();
    }

    public static boolean zzze() {
        int myUid = Process.myUid();
        return myUid == 0 || myUid == 1000;
    }

    public String getDefaultUserAgent(Context context) {
        return "";
    }

    public boolean isAttachedToWindow(View view) {
        return (view.getWindowToken() == null && view.getWindowVisibility() == 8) ? false : true;
    }

    public boolean zza(Activity activity, Configuration configuration) {
        return false;
    }

    public boolean zza(final Context context, final WebSettings webSettings) {
        zzbr.zza(context, new Callable(context, webSettings) { // from class: com.google.android.gms.ads.internal.util.e0
            private final Context a;
            private final WebSettings b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = context;
                this.b = webSettings;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                Context context2 = this.a;
                WebSettings webSettings2 = this.b;
                if (context2.getCacheDir() != null) {
                    webSettings2.setAppCachePath(context2.getCacheDir().getAbsolutePath());
                    webSettings2.setAppCacheMaxSize(0L);
                    webSettings2.setAppCacheEnabled(true);
                }
                webSettings2.setDatabasePath(context2.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
                webSettings2.setDatabaseEnabled(true);
                webSettings2.setDomStorageEnabled(true);
                webSettings2.setDisplayZoomControls(false);
                webSettings2.setBuiltInZoomControls(true);
                webSettings2.setSupportZoom(true);
                webSettings2.setAllowContentAccess(false);
                return Boolean.TRUE;
            }
        });
        webSettings.setAllowFileAccessFromFileURLs(false);
        webSettings.setAllowUniversalAccessFromFileURLs(false);
        return true;
    }

    public int zzb(ContentResolver contentResolver) {
        return Settings.System.getInt(contentResolver, "airplane_mode_on", 0);
    }

    public void zzbe(Context context) {
    }

    public CookieManager zzbf(Context context) {
        if (zzze()) {
            return null;
        }
        try {
            CookieSyncManager.createInstance(context);
            return CookieManager.getInstance();
        } catch (Throwable th) {
            zzazk.zzc("Failed to obtain CookieManager.", th);
            com.google.android.gms.ads.internal.zzr.zzkv().zza(th, "ApiLevelUtil.getCookieManager");
            return null;
        }
    }

    public void zzi(Activity activity) {
    }

    public int zzzc() {
        return 5;
    }

    public ViewGroup.LayoutParams zzzd() {
        return new ViewGroup.LayoutParams(-2, -2);
    }

    public int zzzf() {
        return 1;
    }

    public long zzzg() {
        return -1L;
    }

    public zzbee zza(zzbeb zzbebVar, zztu zztuVar, boolean z) {
        return new zzbfg(zzbebVar, zztuVar, z);
    }

    public Drawable zza(Context context, Bitmap bitmap, boolean z, float f2) {
        return new BitmapDrawable(context.getResources(), bitmap);
    }

    public zzuq zza(Context context, TelephonyManager telephonyManager) {
        return zzuq.ENUM_UNKNOWN;
    }

    public int zza(ContentResolver contentResolver) {
        return Settings.System.getInt(contentResolver, "wifi_on", 0);
    }

    public WebResourceResponse zza(String str, String str2, int i2, String str3, Map<String, String> map, InputStream inputStream) {
        return new WebResourceResponse(str, str2, inputStream);
    }
}
