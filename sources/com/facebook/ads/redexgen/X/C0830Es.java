package com.facebook.ads.redexgen.X;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;
/* renamed from: com.facebook.ads.redexgen.X.Es  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0830Es {
    public final HO A00;
    public final HQ A01;
    public final HQ A02;
    public final InterfaceC0902Hq A03;
    public final IZ A04;

    public C0830Es(InterfaceC0902Hq interfaceC0902Hq, HQ hq) {
        this(interfaceC0902Hq, hq, null, null, null);
    }

    public C0830Es(InterfaceC0902Hq interfaceC0902Hq, HQ hq, @Nullable HQ hq2, @Nullable HO ho, @Nullable IZ iz) {
        I6.A01(hq);
        this.A03 = interfaceC0902Hq;
        this.A02 = hq;
        this.A01 = hq2;
        this.A00 = ho;
        this.A04 = iz;
    }

    public final InterfaceC0902Hq A00() {
        return this.A03;
    }

    public final UN A01(boolean z) {
        HR cacheReadDataSource;
        HP uo;
        HQ hq = this.A01;
        if (hq != null) {
            cacheReadDataSource = hq.A4C();
        } else {
            cacheReadDataSource = new C1215Ua();
        }
        if (z) {
            return new UN(this.A03, C1216Ub.A02, cacheReadDataSource, null, 1, null);
        }
        HO ho = this.A00;
        if (ho != null) {
            uo = ho.createDataSink();
        } else {
            uo = new UO(this.A03, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE);
        }
        HR A4C = this.A02.A4C();
        IZ iz = this.A04;
        if (iz != null) {
            A4C = new US(A4C, iz, -1000);
        }
        return new UN(this.A03, A4C, cacheReadDataSource, uo, 1, null);
    }

    public final IZ A02() {
        IZ iz = this.A04;
        return iz != null ? iz : new IZ();
    }
}
