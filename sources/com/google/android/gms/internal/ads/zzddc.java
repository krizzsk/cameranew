package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.Nullable;
import com.tapjoy.TapjoyConstants;
import java.util.Set;
import java.util.concurrent.Callable;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzddc implements zzdfi<zzddd> {
    private final Context context;
    private final zzdzv zzhah;
    private final Set<String> zzhav;
    @Nullable
    private final ViewGroup zzhcb;

    public zzddc(zzdzv zzdzvVar, @Nullable ViewGroup viewGroup, Context context, Set<String> set) {
        this.zzhah = zzdzvVar;
        this.zzhav = set;
        this.zzhcb = viewGroup;
        this.context = context;
    }

    private static Boolean zzl(Activity activity) {
        Window window = activity.getWindow();
        if (window == null || (window.getAttributes().flags & 16777216) == 0) {
            try {
                return Boolean.valueOf((activity.getPackageManager().getActivityInfo(activity.getComponentName(), 0).flags & 512) != 0);
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }
        return Boolean.TRUE;
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdzw<zzddd> zzasy() {
        return this.zzhah.zze(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzddf
            private final zzddc zzhce;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhce = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzhce.zzatg();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzddd zzatg() throws Exception {
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcxi)).booleanValue() && this.zzhcb != null && this.zzhav.contains("banner")) {
            return new zzddd(Boolean.valueOf(this.zzhcb.isHardwareAccelerated()));
        }
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcxj)).booleanValue() && this.zzhav.contains(TapjoyConstants.TJC_PLUGIN_NATIVE)) {
            Context context = this.context;
            if (context instanceof Activity) {
                return new zzddd(zzl((Activity) context));
            }
        }
        return new zzddd(null);
    }
}
