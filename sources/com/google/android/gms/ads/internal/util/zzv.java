package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import android.os.Environment;
import android.os.StatFs;
import android.view.View;
import com.google.android.gms.internal.ads.zzabp;
import com.google.android.gms.internal.ads.zzwr;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@TargetApi(18)
/* loaded from: classes2.dex */
public class zzv extends zzw {
    @Override // com.google.android.gms.ads.internal.util.zzr
    public boolean isAttachedToWindow(View view) {
        return super.isAttachedToWindow(view) || view.getWindowId() != null;
    }

    @Override // com.google.android.gms.ads.internal.util.zzr
    public final int zzzc() {
        return 14;
    }

    @Override // com.google.android.gms.ads.internal.util.zzr
    public final long zzzg() {
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcss)).booleanValue()) {
            return new StatFs(Environment.getDataDirectory().getAbsolutePath()).getAvailableBytes() / 1024;
        }
        return -1L;
    }
}
