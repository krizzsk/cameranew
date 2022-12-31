package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzab;
import com.google.android.gms.internal.ads.zzag;
import com.google.android.gms.internal.ads.zzaze;
import com.google.android.gms.internal.ads.zzbaa;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbe extends zzab<com.google.android.gms.internal.ads.zzz> {
    private final zzbaa<com.google.android.gms.internal.ads.zzz> a;
    private final zzaze b;

    public zzbe(String str, zzbaa<com.google.android.gms.internal.ads.zzz> zzbaaVar) {
        this(str, null, zzbaaVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.gms.internal.ads.zzab
    public final zzag<com.google.android.gms.internal.ads.zzz> zza(com.google.android.gms.internal.ads.zzz zzzVar) {
        return zzag.zza(zzzVar, com.google.android.gms.internal.ads.zzbc.zzb(zzzVar));
    }

    private zzbe(String str, Map<String, String> map, zzbaa<com.google.android.gms.internal.ads.zzz> zzbaaVar) {
        super(0, str, new o(zzbaaVar));
        this.a = zzbaaVar;
        zzaze zzazeVar = new zzaze();
        this.b = zzazeVar;
        zzazeVar.zza(str, "GET", null, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzab
    public final /* synthetic */ void zza(com.google.android.gms.internal.ads.zzz zzzVar) {
        com.google.android.gms.internal.ads.zzz zzzVar2 = zzzVar;
        this.b.zza(zzzVar2.zzaj, zzzVar2.statusCode);
        zzaze zzazeVar = this.b;
        byte[] bArr = zzzVar2.data;
        if (zzaze.isEnabled() && bArr != null) {
            zzazeVar.zzi(bArr);
        }
        this.a.set(zzzVar2);
    }
}
