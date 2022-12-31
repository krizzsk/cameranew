package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.wrappers.b;
import com.tapjoy.TapjoyAuctionFlags;
import com.tapjoy.TapjoyConstants;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import javax.annotation.ParametersAreNonnullByDefault;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzass implements zzasw {
    private static final Object lock = new Object();
    private static zzasw zzdtt;
    private static zzasw zzdtu;
    private final Context zzcmf;
    private final Object zzdtv;
    private final WeakHashMap<Thread, Boolean> zzdtw;
    private final zzazn zzdtx;
    private final ExecutorService zzyy;

    private zzass(Context context) {
        this(context, zzazn.zzaab());
    }

    public static zzasw zzc(Context context, zzazn zzaznVar) {
        synchronized (lock) {
            if (zzdtu == null) {
                if (zzadr.zzdeu.get().booleanValue()) {
                    if (!((Boolean) zzwr.zzqr().zzd(zzabp.zzczf)).booleanValue()) {
                        zzass zzassVar = new zzass(context, zzaznVar);
                        Thread thread = Looper.getMainLooper().getThread();
                        if (thread != null) {
                            synchronized (zzassVar.zzdtv) {
                                zzassVar.zzdtw.put(thread, Boolean.TRUE);
                            }
                            thread.setUncaughtExceptionHandler(new zzasx(zzassVar, thread.getUncaughtExceptionHandler()));
                        }
                        Thread.setDefaultUncaughtExceptionHandler(new zzasu(zzassVar, Thread.getDefaultUncaughtExceptionHandler()));
                        zzdtu = zzassVar;
                    }
                }
                zzdtu = new zzasz();
            }
        }
        return zzdtu;
    }

    public static zzasw zzq(Context context) {
        synchronized (lock) {
            if (zzdtt == null) {
                if (zzadr.zzdeu.get().booleanValue()) {
                    if (!((Boolean) zzwr.zzqr().zzd(zzabp.zzczf)).booleanValue()) {
                        zzdtt = new zzass(context);
                    }
                }
                zzdtt = new zzasz();
            }
        }
        return zzdtt;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0039, code lost:
        if (r3 == false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(java.lang.Thread r10, java.lang.Throwable r11) {
        /*
            r9 = this;
            r10 = 1
            r0 = 0
            if (r11 == 0) goto L3c
            r1 = r11
            r2 = 0
            r3 = 0
        L7:
            if (r1 == 0) goto L37
            java.lang.StackTraceElement[] r4 = r1.getStackTrace()
            int r5 = r4.length
            r6 = 0
        Lf:
            if (r6 >= r5) goto L32
            r7 = r4[r6]
            java.lang.String r8 = r7.getClassName()
            boolean r8 = com.google.android.gms.internal.ads.zzaza.zzer(r8)
            if (r8 == 0) goto L1e
            r2 = 1
        L1e:
            java.lang.Class<com.google.android.gms.internal.ads.zzass> r8 = com.google.android.gms.internal.ads.zzass.class
            java.lang.String r8 = r8.getName()
            java.lang.String r7 = r7.getClassName()
            boolean r7 = r8.equals(r7)
            if (r7 == 0) goto L2f
            r3 = 1
        L2f:
            int r6 = r6 + 1
            goto Lf
        L32:
            java.lang.Throwable r1 = r1.getCause()
            goto L7
        L37:
            if (r2 == 0) goto L3c
            if (r3 != 0) goto L3c
            goto L3d
        L3c:
            r10 = 0
        L3d:
            if (r10 == 0) goto L46
            r10 = 1065353216(0x3f800000, float:1.0)
            java.lang.String r0 = ""
            r9.zza(r11, r0, r10)
        L46:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzass.zza(java.lang.Thread, java.lang.Throwable):void");
    }

    private zzass(Context context, zzazn zzaznVar) {
        this.zzdtv = new Object();
        this.zzdtw = new WeakHashMap<>();
        this.zzyy = zzdvd.zzayx().zzel(zzdvm.zzhvh);
        this.zzcmf = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzdtx = zzaznVar;
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void zza(Throwable th, String str) {
        zza(th, str, 1.0f);
    }

    @Override // com.google.android.gms.internal.ads.zzasw
    public final void zza(Throwable th, String str, float f2) {
        if (zzaza.zzd(th) == null) {
            return;
        }
        String name = th.getClass().getName();
        StringWriter stringWriter = new StringWriter();
        zzeja.zza(th, new PrintWriter(stringWriter));
        String stringWriter2 = stringWriter.toString();
        int i2 = 0;
        boolean z = Math.random() < ((double) f2);
        int i3 = f2 > 0.0f ? (int) (1.0f / f2) : 1;
        if (z) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(zza(name, stringWriter2, str, i3).toString());
            int size = arrayList.size();
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                final String str2 = (String) obj;
                final zzazo zzazoVar = new zzazo();
                this.zzyy.execute(new Runnable(zzazoVar, str2) { // from class: com.google.android.gms.internal.ads.zzasv
                    private final String zzdjf;
                    private final zzazo zzdua;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzdua = zzazoVar;
                        this.zzdjf = str2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zzdua.zzel(this.zzdjf);
                    }
                });
            }
        }
    }

    private final Uri.Builder zza(String str, String str2, String str3, int i2) {
        boolean z;
        String str4;
        try {
            z = b.a(this.zzcmf).f();
        } catch (Throwable th) {
            zzazk.zzc("Error fetching instant app info", th);
            z = false;
        }
        try {
            str4 = this.zzcmf.getPackageName();
        } catch (Throwable unused) {
            zzazk.zzex("Cannot obtain package name, proceeding.");
            str4 = "unknown";
        }
        Uri.Builder appendQueryParameter = new Uri.Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("is_aia", Boolean.toString(z)).appendQueryParameter(TapjoyAuctionFlags.AUCTION_ID, "gmob-apps-report-exception").appendQueryParameter("os", Build.VERSION.RELEASE).appendQueryParameter("api", String.valueOf(Build.VERSION.SDK_INT));
        String str5 = Build.MANUFACTURER;
        String str6 = Build.MODEL;
        if (!str6.startsWith(str5)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str5).length() + 1 + String.valueOf(str6).length());
            sb.append(str5);
            sb.append(" ");
            sb.append(str6);
            str6 = sb.toString();
        }
        Uri.Builder appendQueryParameter2 = appendQueryParameter.appendQueryParameter(TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX, str6).appendQueryParameter("js", this.zzdtx.zzbrp).appendQueryParameter("appid", str4).appendQueryParameter("exceptiontype", str).appendQueryParameter("stacktrace", str2).appendQueryParameter("eids", TextUtils.join(",", zzabp.zzsc())).appendQueryParameter("exceptionkey", str3).appendQueryParameter("cl", "350251165").appendQueryParameter("rc", "dev").appendQueryParameter("sampling_rate", Integer.toString(i2)).appendQueryParameter("pb_tm", String.valueOf(zzadr.zzdes.get()));
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcqw)).booleanValue()) {
            appendQueryParameter2.appendQueryParameter("gmscv", String.valueOf(GoogleApiAvailabilityLight.getInstance().a(this.zzcmf))).appendQueryParameter("lite", this.zzdtx.zzeib ? "1" : "0");
        }
        return appendQueryParameter2;
    }
}
