package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzazx<T> extends zzbaa<T> {
    private final T zzeim;

    private zzazx(T t) {
        this.zzeim = t;
    }

    public static <T> zzazx<T> zzk(T t) {
        return new zzazx<>(t);
    }

    public final void zzaac() {
        set(this.zzeim);
    }
}
