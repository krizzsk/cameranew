package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.internal.ads.zzabp;
import com.google.android.gms.internal.ads.zzaza;
import com.google.android.gms.internal.ads.zzwr;
import com.tapjoy.TapjoyConstants;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@TargetApi(24)
/* loaded from: classes2.dex */
public class zzaa extends zzx {
    @VisibleForTesting
    private static boolean a(int i2, int i3, int i4) {
        return Math.abs(i2 - i3) <= i4;
    }

    @Override // com.google.android.gms.ads.internal.util.zzr
    public final boolean zza(Activity activity, Configuration configuration) {
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcvc)).booleanValue()) {
            if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcve)).booleanValue()) {
                return activity.isInMultiWindowMode();
            }
            zzwr.zzqn();
            int zze = zzaza.zze(activity, configuration.screenHeightDp);
            int zze2 = zzaza.zze(activity, configuration.screenWidthDp);
            com.google.android.gms.ads.internal.zzr.zzkr();
            DisplayMetrics zza = zzj.zza((WindowManager) activity.getApplicationContext().getSystemService("window"));
            int i2 = zza.heightPixels;
            int i3 = zza.widthPixels;
            int identifier = activity.getResources().getIdentifier("status_bar_height", "dimen", TapjoyConstants.TJC_DEVICE_PLATFORM_TYPE);
            int dimensionPixelSize = identifier > 0 ? activity.getResources().getDimensionPixelSize(identifier) : 0;
            int round = ((int) Math.round(activity.getResources().getDisplayMetrics().density + 0.5d)) * ((Integer) zzwr.zzqr().zzd(zzabp.zzcvb)).intValue();
            return !(a(i2, zze + dimensionPixelSize, round) && a(i3, zze2, round));
        }
        return false;
    }
}
