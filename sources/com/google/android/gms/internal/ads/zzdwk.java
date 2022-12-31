package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdwk {
    private final int limit;
    private final zzdvu zzhvz;
    private final boolean zzhwa;
    private final zzdwr zzhwb;

    private zzdwk(zzdwr zzdwrVar) {
        this(zzdwrVar, false, zzdvy.zzhvt, Integer.MAX_VALUE);
    }

    public static zzdwk zza(zzdvu zzdvuVar) {
        zzdwl.checkNotNull(zzdvuVar);
        return new zzdwk(new zzdwn(zzdvuVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Iterator<String> zzb(CharSequence charSequence) {
        return this.zzhwb.zzb(this, charSequence);
    }

    public final List<String> zzc(CharSequence charSequence) {
        zzdwl.checkNotNull(charSequence);
        Iterator<String> zzb = zzb(charSequence);
        ArrayList arrayList = new ArrayList();
        while (zzb.hasNext()) {
            arrayList.add(zzb.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    private zzdwk(zzdwr zzdwrVar, boolean z, zzdvu zzdvuVar, int i2) {
        this.zzhwb = zzdwrVar;
        this.zzhwa = false;
        this.zzhvz = zzdvuVar;
        this.limit = Integer.MAX_VALUE;
    }

    public final Iterable<String> zza(CharSequence charSequence) {
        zzdwl.checkNotNull(charSequence);
        return new zzdwp(this, charSequence);
    }
}
