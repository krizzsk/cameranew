package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzayx {
    @GuardedBy("this")
    private BigInteger zzedj = BigInteger.ONE;
    @GuardedBy("this")
    private String zzdug = "0";

    public final synchronized String zzyc() {
        String bigInteger;
        bigInteger = this.zzedj.toString();
        this.zzedj = this.zzedj.add(BigInteger.ONE);
        this.zzdug = bigInteger;
        return bigInteger;
    }

    public final synchronized String zzyd() {
        return this.zzdug;
    }
}
