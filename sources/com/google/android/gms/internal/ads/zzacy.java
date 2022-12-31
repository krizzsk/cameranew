package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzacy<T> extends zzacx<T> {
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Incorrect types in method signature: (Ljava/lang/String;TT;Ljava/lang/Integer;)V */
    public zzacy(String str, Object obj, int i2) {
        super(str, obj, i2);
    }

    public static zzacx<Boolean> zzg(String str, boolean z) {
        return new zzacy(str, Boolean.TRUE, zzacz.zzdci);
    }

    @Override // com.google.android.gms.internal.ads.zzacx
    public final T get() {
        if (zzadw.zzdfe.get()) {
            return (T) super.get();
        }
        throw new IllegalStateException("Striped code is accessed: 54c42518-856a-44fb-aae0-cd6676d514e5");
    }
}
