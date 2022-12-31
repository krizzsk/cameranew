package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import androidx.annotation.Nullable;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdea implements zzdfi<zzdfj<Bundle>>, zzdfj<Bundle> {
    private final ApplicationInfo applicationInfo;
    private final PackageInfo zzdue;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdea(ApplicationInfo applicationInfo, @Nullable PackageInfo packageInfo) {
        this.applicationInfo = applicationInfo;
        this.zzdue = packageInfo;
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdzw<zzdfj<Bundle>> zzasy() {
        return zzdzk.zzag(this);
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ void zzr(Bundle bundle) {
        Bundle bundle2 = bundle;
        String str = this.applicationInfo.packageName;
        PackageInfo packageInfo = this.zzdue;
        Integer valueOf = packageInfo == null ? null : Integer.valueOf(packageInfo.versionCode);
        bundle2.putString("pn", str);
        if (valueOf != null) {
            bundle2.putInt("vc", valueOf.intValue());
        }
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcxh)).booleanValue()) {
            PackageInfo packageInfo2 = this.zzdue;
            String str2 = packageInfo2 != null ? packageInfo2.versionName : null;
            if (str2 != null) {
                bundle2.putString("vnm", str2);
            }
        }
    }
}
