package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import androidx.core.location.LocationRequestCompat;
import com.facebook.ads.internal.exoplayer2.Format;
import com.facebook.ads.internal.exoplayer2.drm.DrmInitData;
import java.io.IOException;
/* renamed from: com.facebook.ads.redexgen.X.Df  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC0791Df implements InterfaceC1277Wn, InterfaceC0727Ah {
    public int A00;
    public int A01;
    public long A02;
    public C0728Ai A03;
    public InterfaceC0844Fi A04;
    public boolean A05 = true;
    public boolean A06;
    public Format[] A07;
    public final int A08;

    public AbstractC0791Df(int i2) {
        this.A08 = i2;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.C9 != com.facebook.ads.internal.exoplayer2.drm.DrmSessionManager<?> */
    public static boolean A0x(@Nullable C9<?> c9, @Nullable DrmInitData drmInitData) {
        if (drmInitData == null) {
            return true;
        }
        if (c9 == null) {
            return false;
        }
        return c9.A3v(drmInitData);
    }

    public final int A0y() {
        return this.A00;
    }

    public final int A0z(long j2) {
        return this.A04.AEg(j2 - this.A02);
    }

    public final int A10(AM am, WZ wz, boolean z) {
        int ADG = this.A04.ADG(am, wz, z);
        if (ADG == -4) {
            if (wz.A04()) {
                this.A05 = true;
                return this.A06 ? -4 : -3;
            }
            wz.A00 += this.A02;
        } else if (ADG == -5) {
            Format format = am.A00;
            if (format.A0G != LocationRequestCompat.PASSIVE_INTERVAL) {
                am.A00 = format.A0H(format.A0G + this.A02);
            }
        }
        return ADG;
    }

    public final C0728Ai A11() {
        return this.A03;
    }

    public void A12() {
    }

    public void A13() throws A9 {
    }

    public void A14() throws A9 {
    }

    public void A15(long j2, boolean z) throws A9 {
    }

    public void A16(boolean z) throws A9 {
    }

    public void A17(Format[] formatArr, long j2) throws A9 {
    }

    public final boolean A18() {
        return this.A05 ? this.A06 : this.A04.A8U();
    }

    public final Format[] A19() {
        return this.A07;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1277Wn
    public final void A4l() {
        I6.A04(this.A01 == 1);
        this.A01 = 0;
        this.A04 = null;
        this.A07 = null;
        this.A06 = false;
        A12();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1277Wn
    public final void A57(C0728Ai c0728Ai, Format[] formatArr, InterfaceC0844Fi interfaceC0844Fi, long j2, boolean z, long j3) throws A9 {
        I6.A04(this.A01 == 0);
        this.A03 = c0728Ai;
        this.A01 = 1;
        A16(z);
        ADh(formatArr, interfaceC0844Fi, j3);
        A15(j2, z);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1277Wn
    public final InterfaceC0727Ah A5u() {
        return this;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1277Wn
    public IM A6r() {
        return null;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1277Wn
    public final int A7Q() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1277Wn
    public final InterfaceC0844Fi A7V() {
        return this.A04;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1277Wn, com.facebook.ads.redexgen.X.InterfaceC0727Ah
    public final int A7b() {
        return this.A08;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0724Ae
    public void A7q(int i2, Object obj) throws A9 {
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1277Wn
    public final boolean A7w() {
        return this.A05;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1277Wn
    public final boolean A8G() {
        return this.A06;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1277Wn
    public final void A9Q() throws IOException {
        this.A04.A9N();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1277Wn
    public final void ADh(Format[] formatArr, InterfaceC0844Fi interfaceC0844Fi, long j2) throws A9 {
        I6.A04(!this.A06);
        this.A04 = interfaceC0844Fi;
        this.A05 = false;
        this.A07 = formatArr;
        this.A02 = j2;
        A17(formatArr, j2);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1277Wn
    public final void ADs(long j2) throws A9 {
        this.A06 = false;
        this.A05 = false;
        A15(j2, false);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1277Wn
    public final void AEL() {
        this.A06 = true;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1277Wn
    public final void AEN(int i2) {
        this.A00 = i2;
    }

    public int AEx() throws A9 {
        return 0;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1277Wn
    public final void start() throws A9 {
        I6.A04(this.A01 == 1);
        this.A01 = 2;
        A13();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1277Wn
    public final void stop() throws A9 {
        I6.A04(this.A01 == 2);
        this.A01 = 1;
        A14();
    }
}
