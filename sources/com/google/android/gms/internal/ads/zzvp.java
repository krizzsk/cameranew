package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.RequestConfiguration;
import java.util.Comparator;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final /* synthetic */ class zzvp implements Comparator {
    static final Comparator zzcie = new zzvp();

    private zzvp() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        String str = (String) obj;
        String str2 = (String) obj2;
        return RequestConfiguration.zzads;
    }
}
