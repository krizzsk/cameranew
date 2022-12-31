package com.facebook.ads.redexgen.X;

import android.view.Surface;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.checkerframework.checker.nullness.qual.MonotonicNonNull;
import com.facebook.ads.internal.exoplayer2.Format;
import com.facebook.ads.internal.exoplayer2.metadata.Metadata;
import com.facebook.ads.internal.exoplayer2.source.TrackGroupArray;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
/* renamed from: com.facebook.ads.redexgen.X.Wk  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1274Wk implements AX, E6, BG, J9, InterfaceC0837Fb, HL, InterfaceC0767Bx {
    public static String[] A05 = {"oWxliEG", "84CCzfJSWHAMzlT", "dVPYU5AFfnLld9", "202VfNqPV04zLFr42xUQnFXcv", "6C2OHs0d6U2aNpx0mThNdUqCMJf7H", "j36hHuSQknS9Y2BeP2DWP06EygcBzL55", "WN9koNHhTr4SbLKtJDKTY2JTPC", "f2Eog"};
    @MonotonicNonNull
    public InterfaceC0722Ac A00;
    public final I9 A03;
    public final CopyOnWriteArraySet<InterfaceC0738At> A04 = new CopyOnWriteArraySet<>();
    public final C0735Aq A02 = new C0735Aq();
    public final C0732An A01 = new C0732An();

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.facebook.ads.redexgen.X.HL
    public final void A9z(int i2, long j2, long j3) {
        A01();
        Iterator<InterfaceC0738At> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    public C1274Wk(@Nullable InterfaceC0722Ac interfaceC0722Ac, I9 i9) {
        this.A00 = interfaceC0722Ac;
        this.A03 = (I9) I6.A01(i9);
    }

    private C0737As A00() {
        return A05(this.A02.A03());
    }

    private C0737As A01() {
        return A05(this.A02.A04());
    }

    private C0737As A02() {
        return A05(this.A02.A05());
    }

    private C0737As A03() {
        return A05(this.A02.A06());
    }

    private final C0737As A04(int i2, @Nullable FL fl) {
        long j2;
        I6.A01(this.A00);
        long A55 = this.A03.A55();
        AbstractC0733Ao timeline = this.A00.A6D();
        if (i2 == this.A00.A6E()) {
            if (fl != null && fl.A01()) {
                if (this.A00.A68() == fl.A00 && this.A00.A69() == fl.A01) {
                    j2 = this.A00.A6B();
                } else {
                    j2 = 0;
                }
            } else {
                j2 = this.A00.A66();
            }
        } else if (i2 >= timeline.A01() || (fl != null && fl.A01())) {
            j2 = 0;
        } else {
            j2 = timeline.A0B(i2, this.A01).A00();
        }
        return new C0737As(A55, timeline, i2, fl, j2, this.A00.A6B(), this.A00.A5p() - this.A00.A66());
    }

    private C0737As A05(@Nullable C0736Ar c0736Ar) {
        if (c0736Ar == null) {
            int A6E = ((InterfaceC0722Ac) I6.A01(this.A00)).A6E();
            return A04(A6E, this.A02.A07(A6E));
        }
        return A04(c0736Ar.A00, c0736Ar.A01);
    }

    public final void A06() {
        if (!this.A02.A0F()) {
            C0737As A02 = A02();
            this.A02.A09();
            Iterator<InterfaceC0738At> it = this.A04.iterator();
            while (it.hasNext()) {
                InterfaceC0738At next = it.next();
                String[] strArr = A05;
                if (strArr[1].length() == strArr[4].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A05;
                strArr2[1] = "PBkwxeOlbvYzAOz";
                strArr2[4] = "zMCnce58Qhbdr93RoMzV7EOLVlkYq";
                next.onSeekStarted(A02);
            }
        }
    }

    public final void A07() {
        ArrayList arrayList;
        arrayList = this.A02.A05;
        Iterator it = new ArrayList(arrayList).iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            String[] strArr = A05;
            if (strArr[1].length() == strArr[4].length()) {
                throw new RuntimeException();
            }
            A05[0] = "gG2PlvUwOW39eC8R";
            if (hasNext) {
                C0736Ar c0736Ar = (C0736Ar) it.next();
                ABG(c0736Ar.A00, c0736Ar.A01);
            } else {
                return;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.BG
    public final void A9s(String str, long j2, long j3) {
        C0737As eventTime = A03();
        Iterator<InterfaceC0738At> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onDecoderInitialized(eventTime, 1, str, j3);
        }
    }

    @Override // com.facebook.ads.redexgen.X.BG
    public final void A9t(C0754Bj c0754Bj) {
        C0737As A00 = A00();
        Iterator<InterfaceC0738At> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onDecoderDisabled(A00, 1, c0754Bj);
        }
    }

    @Override // com.facebook.ads.redexgen.X.BG
    public final void A9u(C0754Bj c0754Bj) {
        C0737As A02 = A02();
        Iterator<InterfaceC0738At> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onDecoderEnabled(A02, 1, c0754Bj);
        }
    }

    @Override // com.facebook.ads.redexgen.X.BG
    public final void A9v(Format format) {
        C0737As A03 = A03();
        Iterator<InterfaceC0738At> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onDecoderInputFormatChanged(A03, 1, format);
        }
    }

    @Override // com.facebook.ads.redexgen.X.BG
    public final void A9w(int i2) {
        C0737As A03 = A03();
        Iterator<InterfaceC0738At> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onAudioSessionId(A03, i2);
        }
    }

    @Override // com.facebook.ads.redexgen.X.BG
    public final void A9x(int i2, long j2, long j3) {
        C0737As A03 = A03();
        Iterator<InterfaceC0738At> it = this.A04.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            if (A05[2].length() == 13) {
                throw new RuntimeException();
            }
            String[] strArr = A05;
            strArr[1] = "uqo4gq1KBxiMktN";
            strArr[4] = "Ndm2ibG2UK8Su1apjnSt0jhcojAUZ";
            if (hasNext) {
                it.next().onAudioUnderrun(A03, i2, j2, j3);
            } else {
                return;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0837Fb
    public final void AAN(int i2, @Nullable FL fl, C0836Fa c0836Fa) {
        C0737As A04 = A04(i2, fl);
        Iterator<InterfaceC0738At> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onDownstreamFormatChanged(A04, c0836Fa);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0767Bx
    public final void AAO() {
        C0737As A03 = A03();
        Iterator<InterfaceC0738At> it = this.A04.iterator();
        while (it.hasNext()) {
            InterfaceC0738At listener = it.next();
            listener.onDrmKeysLoaded(A03);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0767Bx
    public final void AAP() {
        C0737As A03 = A03();
        Iterator<InterfaceC0738At> it = this.A04.iterator();
        while (it.hasNext()) {
            InterfaceC0738At listener = it.next();
            listener.onDrmKeysRemoved(A03);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0767Bx
    public final void AAQ() {
        C0737As A03 = A03();
        Iterator<InterfaceC0738At> it = this.A04.iterator();
        while (it.hasNext()) {
            InterfaceC0738At listener = it.next();
            listener.onDrmKeysRestored(A03);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0767Bx
    public final void AAR(Exception exc) {
        C0737As A03 = A03();
        Iterator<InterfaceC0738At> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onDrmSessionManagerError(A03, exc);
        }
    }

    @Override // com.facebook.ads.redexgen.X.J9
    public final void AAS(int i2, long j2) {
        C0737As A00 = A00();
        Iterator<InterfaceC0738At> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onDroppedVideoFrames(A00, i2, j2);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0837Fb
    public final void AAz(int i2, @Nullable FL fl, FZ fz, C0836Fa c0836Fa) {
        A04(i2, fl);
        Iterator<InterfaceC0738At> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0837Fb
    public final void AB1(int i2, @Nullable FL fl, FZ fz, C0836Fa c0836Fa) {
        A04(i2, fl);
        Iterator<InterfaceC0738At> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0837Fb
    public final void AB4(int i2, @Nullable FL fl, FZ fz, C0836Fa c0836Fa, IOException iOException, boolean z) {
        C0737As A04 = A04(i2, fl);
        Iterator<InterfaceC0738At> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onLoadError(A04, fz, c0836Fa, iOException, z);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0837Fb
    public final void AB6(int i2, @Nullable FL fl, FZ fz, C0836Fa c0836Fa) {
        A04(i2, fl);
        Iterator<InterfaceC0738At> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    @Override // com.facebook.ads.redexgen.X.AX
    public final void AB8(boolean z) {
        C0737As A02 = A02();
        Iterator<InterfaceC0738At> it = this.A04.iterator();
        while (it.hasNext()) {
            InterfaceC0738At next = it.next();
            if (A05[2].length() == 13) {
                throw new RuntimeException();
            }
            A05[5] = "61iKEbH7Elk598B8IvoVeyiFcghmzjBq";
            next.onLoadingChanged(A02, z);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0837Fb
    public final void ABF(int i2, FL fl) {
        this.A02.A0B(i2, fl);
        C0737As A04 = A04(i2, fl);
        Iterator<InterfaceC0738At> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onMediaPeriodCreated(A04);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0837Fb
    public final void ABG(int i2, FL fl) {
        this.A02.A0C(i2, fl);
        C0737As A04 = A04(i2, fl);
        Iterator<InterfaceC0738At> it = this.A04.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            String[] strArr = A05;
            if (strArr[7].length() == strArr[6].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A05;
            strArr2[1] = "xQuAJnMHmsnkUtn";
            strArr2[4] = "I7nuhInD03G6TyFgZN1tEp7XA66Po";
            if (hasNext) {
                it.next().onMediaPeriodReleased(A04);
            } else {
                return;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.E6
    public final void ABJ(Metadata metadata) {
        C0737As A02 = A02();
        Iterator<InterfaceC0738At> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onMetadata(A02, metadata);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AX
    public final void ABZ(AU au) {
        C0737As A02 = A02();
        Iterator<InterfaceC0738At> it = this.A04.iterator();
        while (it.hasNext()) {
            InterfaceC0738At next = it.next();
            if (A05[5].charAt(25) != 'g') {
                throw new RuntimeException();
            }
            A05[5] = "6kCd761y4Sm0JC2HIy7vlDu4Zge9adCZ";
            next.onPlaybackParametersChanged(A02, au);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AX
    public final void ABb(A9 a9) {
        C0737As A02 = A02();
        Iterator<InterfaceC0738At> it = this.A04.iterator();
        while (it.hasNext()) {
            InterfaceC0738At next = it.next();
            String[] strArr = A05;
            if (strArr[7].length() == strArr[6].length()) {
                throw new RuntimeException();
            }
            A05[3] = "4uLQlqFUz3TKu9PUP8Ua0";
            next.onPlayerError(A02, a9);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AX
    public final void ABd(boolean z, int i2) {
        C0737As A02 = A02();
        Iterator<InterfaceC0738At> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onPlayerStateChanged(A02, z, i2);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AX
    public final void ABf(int i2) {
        this.A02.A0A(i2);
        C0737As A02 = A02();
        Iterator<InterfaceC0738At> it = this.A04.iterator();
        while (it.hasNext()) {
            InterfaceC0738At listener = it.next();
            listener.onPositionDiscontinuity(A02, i2);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0837Fb
    public final void ABo(int i2, FL fl) {
        this.A02.A0D(i2, fl);
        C0737As A04 = A04(i2, fl);
        Iterator<InterfaceC0738At> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onReadingStarted(A04);
        }
    }

    @Override // com.facebook.ads.redexgen.X.J9
    public final void ABs(Surface surface) {
        C0737As A03 = A03();
        Iterator<InterfaceC0738At> it = this.A04.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            String[] strArr = A05;
            if (strArr[1].length() == strArr[4].length()) {
                throw new RuntimeException();
            }
            A05[0] = "zEYrHw08cBp169ZitgaAlaUGutwvX";
            if (hasNext) {
                it.next().onRenderedFirstFrame(A03, surface);
            } else {
                return;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.AX
    public final void AC2() {
        if (this.A02.A0F()) {
            this.A02.A08();
            C0737As A02 = A02();
            Iterator<InterfaceC0738At> it = this.A04.iterator();
            while (it.hasNext()) {
                InterfaceC0738At listener = it.next();
                listener.onSeekProcessed(A02);
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.AX
    public final void ACG(AbstractC0733Ao abstractC0733Ao, @Nullable Object obj, int i2) {
        this.A02.A0E(abstractC0733Ao);
        C0737As A02 = A02();
        Iterator<InterfaceC0738At> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onTimelineChanged(A02, i2);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AX
    public final void ACH(TrackGroupArray trackGroupArray, HE he) {
        C0737As A02 = A02();
        Iterator<InterfaceC0738At> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onTracksChanged(A02, trackGroupArray, he);
        }
    }

    @Override // com.facebook.ads.redexgen.X.J9
    public final void ACP(String str, long j2, long j3) {
        C0737As eventTime = A03();
        Iterator<InterfaceC0738At> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onDecoderInitialized(eventTime, 2, str, j3);
        }
    }

    @Override // com.facebook.ads.redexgen.X.J9
    public final void ACQ(C0754Bj c0754Bj) {
        C0737As A00 = A00();
        Iterator<InterfaceC0738At> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onDecoderDisabled(A00, 2, c0754Bj);
        }
    }

    @Override // com.facebook.ads.redexgen.X.J9
    public final void ACR(C0754Bj c0754Bj) {
        C0737As A02 = A02();
        Iterator<InterfaceC0738At> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onDecoderEnabled(A02, 2, c0754Bj);
        }
    }

    @Override // com.facebook.ads.redexgen.X.J9
    public final void ACU(Format format) {
        C0737As A03 = A03();
        Iterator<InterfaceC0738At> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onDecoderInputFormatChanged(A03, 2, format);
        }
    }

    @Override // com.facebook.ads.redexgen.X.J9
    public final void ACZ(int i2, int i3, int i4, float f2) {
        C0737As A03 = A03();
        Iterator<InterfaceC0738At> it = this.A04.iterator();
        while (it.hasNext()) {
            it.next().onVideoSizeChanged(A03, i2, i3, i4, f2);
        }
    }
}
