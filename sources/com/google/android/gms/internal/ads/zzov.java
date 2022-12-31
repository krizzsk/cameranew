package com.google.android.gms.internal.ads;

import java.io.IOException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public class zzov extends IOException {
    private final int type;
    private final zzos zzbiy;

    public zzov(String str, zzos zzosVar, int i2) {
        super(str);
        this.zzbiy = zzosVar;
        this.type = 1;
    }

    public zzov(IOException iOException, zzos zzosVar, int i2) {
        super(iOException);
        this.zzbiy = zzosVar;
        this.type = i2;
    }

    public zzov(String str, IOException iOException, zzos zzosVar, int i2) {
        super(str, iOException);
        this.zzbiy = zzosVar;
        this.type = 1;
    }
}
