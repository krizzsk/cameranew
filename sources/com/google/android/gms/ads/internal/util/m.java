package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzaj;
import com.google.android.gms.internal.ads.zzazk;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class m implements zzaj {
    private final /* synthetic */ String a;
    private final /* synthetic */ n b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(zzay zzayVar, String str, n nVar) {
        this.a = str;
        this.b = nVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaj
    public final void zzd(com.google.android.gms.internal.ads.zzap zzapVar) {
        String str = this.a;
        String exc = zzapVar.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(exc).length());
        sb.append("Failed to load URL: ");
        sb.append(str);
        sb.append("\n");
        sb.append(exc);
        zzazk.zzex(sb.toString());
        this.b.zzb(null);
    }
}
