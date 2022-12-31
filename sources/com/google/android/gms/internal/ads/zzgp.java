package com.google.android.gms.internal.ads;

import androidx.room.RoomDatabase;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public enum zzgp implements zzelg {
    UNSUPPORTED(0),
    ARM7(2),
    X86(4),
    ARM64(5),
    X86_64(6),
    UNKNOWN(RoomDatabase.MAX_BIND_PARAMETER_CNT);
    
    private static final zzelf<zzgp> zzes = new zzelf<zzgp>() { // from class: com.google.android.gms.internal.ads.zzgs
    };
    private final int value;

    zzgp(int i2) {
        this.value = i2;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + zzgp.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
    }

    @Override // com.google.android.gms.internal.ads.zzelg
    public final int zzv() {
        return this.value;
    }
}
