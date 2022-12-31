package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.gms.ads.AdActivity;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyConstants;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzayv {
    private final String zzedf;
    private final com.google.android.gms.ads.internal.util.zzf zzedg;
    private long zzeda = -1;
    private long zzedb = -1;
    @GuardedBy("lock")
    private int zzedc = -1;
    int zzedd = -1;
    private long zzede = 0;
    private final Object lock = new Object();
    @GuardedBy("lock")
    private int zzedh = 0;
    @GuardedBy("lock")
    private int zzedi = 0;

    public zzayv(String str, com.google.android.gms.ads.internal.util.zzf zzfVar) {
        this.zzedf = str;
        this.zzedg = zzfVar;
    }

    private static boolean zzai(Context context) {
        Context zzx = zzaul.zzx(context);
        int identifier = zzx.getResources().getIdentifier("Theme.Translucent", TJAdUnitConstants.String.STYLE, TapjoyConstants.TJC_DEVICE_PLATFORM_TYPE);
        if (identifier == 0) {
            zzazk.zzew("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
        try {
            if (identifier == zzx.getPackageManager().getActivityInfo(new ComponentName(zzx.getPackageName(), AdActivity.CLASS_NAME), 0).theme) {
                return true;
            }
            zzazk.zzew("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            zzazk.zzex("Fail to fetch AdActivity theme");
            zzazk.zzew("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
    }

    public final void zza(zzvl zzvlVar, long j2) {
        Bundle bundle;
        synchronized (this.lock) {
            long zzyo = this.zzedg.zzyo();
            long currentTimeMillis = com.google.android.gms.ads.internal.zzr.zzky().currentTimeMillis();
            if (this.zzedb == -1) {
                if (currentTimeMillis - zzyo > ((Long) zzwr.zzqr().zzd(zzabp.zzcpm)).longValue()) {
                    this.zzedd = -1;
                } else {
                    this.zzedd = this.zzedg.zzyp();
                }
                this.zzedb = j2;
                this.zzeda = j2;
            } else {
                this.zzeda = j2;
            }
            if (zzvlVar == null || (bundle = zzvlVar.extras) == null || bundle.getInt("gw", 2) != 1) {
                this.zzedc++;
                int i2 = this.zzedd + 1;
                this.zzedd = i2;
                if (i2 == 0) {
                    this.zzede = 0L;
                    this.zzedg.zzfa(currentTimeMillis);
                } else {
                    this.zzede = currentTimeMillis - this.zzedg.zzyq();
                }
            }
        }
    }

    public final Bundle zzn(Context context, String str) {
        Bundle bundle;
        synchronized (this.lock) {
            bundle = new Bundle();
            bundle.putString(TapjoyConstants.TJC_SESSION_ID, this.zzedg.zzyu() ? "" : this.zzedf);
            bundle.putLong("basets", this.zzedb);
            bundle.putLong("currts", this.zzeda);
            bundle.putString("seq_num", str);
            bundle.putInt("preqs", this.zzedc);
            bundle.putInt("preqs_in_session", this.zzedd);
            bundle.putLong("time_in_session", this.zzede);
            bundle.putInt("pclick", this.zzedh);
            bundle.putInt("pimp", this.zzedi);
            bundle.putBoolean("support_transparent_background", zzai(context));
        }
        return bundle;
    }

    public final void zzxi() {
        synchronized (this.lock) {
            this.zzedi++;
        }
    }

    public final void zzxj() {
        synchronized (this.lock) {
            this.zzedh++;
        }
    }
}
