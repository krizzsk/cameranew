package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.util.DisplayMetrics;
import com.google.android.gms.common.util.i;
import com.google.android.gms.common.util.o;
import com.google.android.gms.common.wrappers.b;
import java.util.Locale;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaty {
    private float zzbsd;
    private int zzdqi;
    private int zzdqj;
    private int zzdxv;
    private boolean zzdxw;
    private boolean zzdxx;
    private int zzdxy;
    private int zzdxz;
    private int zzdya;
    private String zzdyb;
    private int zzdyc;
    private int zzdyd;
    private int zzdye;
    private boolean zzdyf;
    private int zzdyg;
    private double zzdyh;
    private boolean zzdyi;
    private String zzdyj;
    private String zzdyk;
    private boolean zzdyl;
    private boolean zzdym;
    private String zzdyn;
    private boolean zzdyo;
    private final boolean zzdyp;
    private boolean zzdyq;
    private String zzdyr;
    private String zzdys;
    private String zzdyt;
    private boolean zzdyu;

    public zzaty(Context context) {
        DisplayMetrics displayMetrics;
        PackageManager packageManager = context.getPackageManager();
        zzr(context);
        zzs(context);
        zzt(context);
        Locale locale = Locale.getDefault();
        this.zzdyl = zza(packageManager, "geo:0,0?q=donuts") != null;
        this.zzdym = zza(packageManager, "http://www.google.com") != null;
        this.zzdyn = locale.getCountry();
        zzwr.zzqn();
        this.zzdyo = zzaza.zzzw();
        this.zzdyp = i.a(context);
        this.zzdyq = i.b(context);
        this.zzdyr = locale.getLanguage();
        this.zzdys = zza(context, packageManager);
        this.zzdyt = zzu(context);
        Resources resources = context.getResources();
        if (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null) {
            return;
        }
        this.zzbsd = displayMetrics.density;
        this.zzdqi = displayMetrics.widthPixels;
        this.zzdqj = displayMetrics.heightPixels;
    }

    private static String zza(Context context, PackageManager packageManager) {
        ActivityInfo activityInfo;
        ResolveInfo zza = zza(packageManager, "market://details?id=com.google.android.gms.ads");
        if (zza == null || (activityInfo = zza.activityInfo) == null) {
            return null;
        }
        try {
            PackageInfo e2 = b.a(context).e(activityInfo.packageName, 0);
            if (e2 != null) {
                int i2 = e2.versionCode;
                String str = activityInfo.packageName;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
                sb.append(i2);
                sb.append(".");
                sb.append(str);
                return sb.toString();
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return null;
    }

    private final void zzr(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager != null) {
            try {
                this.zzdxv = audioManager.getMode();
                this.zzdxw = audioManager.isMusicActive();
                this.zzdxx = audioManager.isSpeakerphoneOn();
                this.zzdxy = audioManager.getStreamVolume(3);
                this.zzdxz = audioManager.getRingerMode();
                this.zzdya = audioManager.getStreamVolume(2);
                return;
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.zzr.zzkv().zza(th, "DeviceInfo.gatherAudioInfo");
            }
        }
        this.zzdxv = -2;
        this.zzdxw = false;
        this.zzdxx = false;
        this.zzdxy = 0;
        this.zzdxz = 2;
        this.zzdya = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    @android.annotation.TargetApi(16)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void zzs(android.content.Context r6) {
        /*
            r5 = this;
            java.lang.String r0 = "phone"
            java.lang.Object r0 = r6.getSystemService(r0)
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0
            java.lang.String r1 = "connectivity"
            java.lang.Object r1 = r6.getSystemService(r1)
            android.net.ConnectivityManager r1 = (android.net.ConnectivityManager) r1
            java.lang.String r2 = r0.getNetworkOperator()
            r5.zzdyb = r2
            boolean r2 = com.google.android.gms.common.util.o.n()
            r3 = 0
            if (r2 == 0) goto L31
            com.google.android.gms.internal.ads.zzaba<java.lang.Boolean> r2 = com.google.android.gms.internal.ads.zzabp.zzdag
            com.google.android.gms.internal.ads.zzabl r4 = com.google.android.gms.internal.ads.zzwr.zzqr()
            java.lang.Object r2 = r4.zzd(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L31
            r2 = 0
            goto L35
        L31:
            int r2 = r0.getNetworkType()
        L35:
            r5.zzdyd = r2
            int r0 = r0.getPhoneType()
            r5.zzdye = r0
            r0 = -2
            r5.zzdyc = r0
            r5.zzdyf = r3
            r0 = -1
            r5.zzdyg = r0
            com.google.android.gms.ads.internal.zzr.zzkr()
            java.lang.String r2 = "android.permission.ACCESS_NETWORK_STATE"
            boolean r6 = com.google.android.gms.ads.internal.util.zzj.zzp(r6, r2)
            if (r6 == 0) goto L6f
            android.net.NetworkInfo r6 = r1.getActiveNetworkInfo()
            if (r6 == 0) goto L67
            int r0 = r6.getType()
            r5.zzdyc = r0
            android.net.NetworkInfo$DetailedState r6 = r6.getDetailedState()
            int r6 = r6.ordinal()
            r5.zzdyg = r6
            goto L69
        L67:
            r5.zzdyc = r0
        L69:
            boolean r6 = r1.isActiveNetworkMetered()
            r5.zzdyf = r6
        L6f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaty.zzs(android.content.Context):void");
    }

    private final void zzt(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        boolean z = false;
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            this.zzdyh = registerReceiver.getIntExtra("level", -1) / registerReceiver.getIntExtra("scale", -1);
            this.zzdyi = (intExtra == 2 || intExtra == 5) ? true : true;
            return;
        }
        this.zzdyh = -1.0d;
        this.zzdyi = false;
    }

    private static String zzu(Context context) {
        try {
            PackageInfo e2 = b.a(context).e("com.android.vending", 128);
            if (e2 != null) {
                int i2 = e2.versionCode;
                String str = e2.packageName;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
                sb.append(i2);
                sb.append(".");
                sb.append(str);
                return sb.toString();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public final zzatz zzws() {
        return new zzatz(this.zzdxv, this.zzdyl, this.zzdym, this.zzdyb, this.zzdyn, this.zzdyo, this.zzdyp, this.zzdyq, this.zzdxw, this.zzdxx, this.zzdyr, this.zzdys, this.zzdyt, this.zzdxy, this.zzdyc, this.zzdyd, this.zzdye, this.zzdxz, this.zzdya, this.zzbsd, this.zzdqi, this.zzdqj, this.zzdyh, this.zzdyi, this.zzdyf, this.zzdyg, this.zzdyj, this.zzdyu, this.zzdyk);
    }

    private static ResolveInfo zza(PackageManager packageManager, String str) {
        try {
            return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzr.zzkv().zza(th, "DeviceInfo.getResolveInfo");
            return null;
        }
    }

    public zzaty(Context context, zzatz zzatzVar) {
        zzr(context);
        zzs(context);
        zzt(context);
        this.zzdyj = Build.FINGERPRINT;
        this.zzdyk = Build.DEVICE;
        this.zzdyu = o.b() && zzacp.zzj(context);
        this.zzdyl = zzatzVar.zzdyl;
        this.zzdym = zzatzVar.zzdym;
        this.zzdyn = zzatzVar.zzdyn;
        this.zzdyo = zzatzVar.zzdyo;
        this.zzdyp = zzatzVar.zzdyp;
        this.zzdyq = zzatzVar.zzdyq;
        this.zzdyr = zzatzVar.zzdyr;
        this.zzdys = zzatzVar.zzdys;
        this.zzdyt = zzatzVar.zzdyt;
        this.zzbsd = zzatzVar.zzbsd;
        this.zzdqi = zzatzVar.zzdqi;
        this.zzdqj = zzatzVar.zzdqj;
    }
}
