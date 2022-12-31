package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcgw<T> implements zzaif<Object> {
    private final WeakReference<T> zzgjj;
    private final String zzgjk;
    private final zzaif<T> zzgjl;
    private final /* synthetic */ zzcgk zzgjm;

    private zzcgw(zzcgk zzcgkVar, WeakReference<T> weakReference, String str, zzaif<T> zzaifVar) {
        this.zzgjm = zzcgkVar;
        this.zzgjj = weakReference;
        this.zzgjk = str;
        this.zzgjl = zzaifVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaif
    public final void zza(Object obj, Map<String, String> map) {
        T t = this.zzgjj.get();
        if (t == null) {
            this.zzgjm.zzb(this.zzgjk, this);
        } else {
            this.zzgjl.zza(t, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzcgw(zzcgk zzcgkVar, WeakReference weakReference, String str, zzaif zzaifVar, zzcgl zzcglVar) {
        this(zzcgkVar, weakReference, str, zzaifVar);
    }
}
