package com.google.android.gms.ads.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzatf;
import com.google.android.gms.internal.ads.zzawz;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zza {
    private final Context a;
    private boolean b;
    private zzawz c;

    /* renamed from: d  reason: collision with root package name */
    private zzatf f3500d;

    public zza(Context context, zzawz zzawzVar, zzatf zzatfVar) {
        this.a = context;
        this.c = zzawzVar;
        this.f3500d = null;
        if (0 == 0) {
            this.f3500d = new zzatf();
        }
    }

    private final boolean a() {
        zzawz zzawzVar = this.c;
        return (zzawzVar != null && zzawzVar.zzwv().zzear) || this.f3500d.zzdxb;
    }

    public final void recordClick() {
        this.b = true;
    }

    public final void zzbk(@Nullable String str) {
        List<String> list;
        if (a()) {
            if (str == null) {
                str = "";
            }
            zzawz zzawzVar = this.c;
            if (zzawzVar != null) {
                zzawzVar.zza(str, null, 3);
                return;
            }
            zzatf zzatfVar = this.f3500d;
            if (!zzatfVar.zzdxb || (list = zzatfVar.zzdxc) == null) {
                return;
            }
            for (String str2 : list) {
                if (!TextUtils.isEmpty(str2)) {
                    String replace = str2.replace("{NAVIGATION_URL}", Uri.encode(str));
                    zzr.zzkr();
                    com.google.android.gms.ads.internal.util.zzj.zzb(this.a, "", replace);
                }
            }
        }
    }

    public final boolean zzjy() {
        return !a() || this.b;
    }
}
