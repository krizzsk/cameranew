package com.facebook.ads.redexgen.X;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: assets/audience_network.dex */
public final class AG implements Comparable<AG> {
    public int A00;
    public long A01;
    @Nullable
    public Object A02;
    public final C0725Af A03;

    public AG(C0725Af c0725Af) {
        this.A03 = c0725Af;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: A00 */
    public final int compareTo(@NonNull AG ag) {
        if ((this.A02 == null) != (ag.A02 == null)) {
            return this.A02 != null ? -1 : 1;
        } else if (this.A02 == null) {
            return 0;
        } else {
            int i2 = this.A00 - ag.A00;
            if (i2 != 0) {
                return i2;
            }
            return C0923Il.A07(this.A01, ag.A01);
        }
    }

    public final void A01(int i2, long j2, Object obj) {
        this.A00 = i2;
        this.A01 = j2;
        this.A02 = obj;
    }
}
