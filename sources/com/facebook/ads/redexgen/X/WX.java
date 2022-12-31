package com.facebook.ads.redexgen.X;

import com.facebook.ads.redexgen.X.WY;
import com.facebook.ads.redexgen.X.WZ;
import java.lang.Exception;
import java.util.ArrayDeque;
/* loaded from: assets/audience_network.dex */
public abstract class WX<I extends WZ, O extends WY, E extends Exception> implements InterfaceC0753Bi<I, O, E> {
    public static String[] A0D = {"Gkl", "qMMBfBKIWMYZs", "JMr5TMdVlQ7lAxQbe7gmsO3TMTXZHZrx", "k", "fplFQmQDWPfBEKatf3t9LdZAMaYE90Yr", "qk38PGrA", "BZh", "ypodQLxrY5Mqx0yNqiahJYpo"};
    public int A00;
    public int A01;
    public int A02;
    public I A03;
    public E A04;
    public boolean A05;
    public boolean A06;
    public final Thread A08;
    public final I[] A0B;
    public final O[] A0C;
    public final Object A07 = new Object();
    public final ArrayDeque<I> A09 = new ArrayDeque<>();
    public final ArrayDeque<O> A0A = new ArrayDeque<>();

    public abstract I A0T();

    public abstract O A0V();

    public abstract E A0W(I i2, O o, boolean z);

    public abstract E A0X(Throwable th);

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.WX != com.facebook.ads.internal.exoplayer2.decoder.SimpleDecoder<I extends com.facebook.ads.redexgen.X.WZ, O extends com.facebook.ads.redexgen.X.WY, E extends java.lang.Exception> */
    public WX(I[] iArr, O[] oArr) {
        this.A0B = iArr;
        this.A00 = iArr.length;
        for (int i2 = 0; i2 < this.A00; i2++) {
            this.A0B[i2] = A0T();
        }
        this.A0C = oArr;
        this.A01 = oArr.length;
        for (int i3 = 0; i3 < this.A01; i3++) {
            this.A0C[i3] = A0V();
        }
        this.A08 = new C0756Bl(this);
        this.A08.start();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.WX != com.facebook.ads.internal.exoplayer2.decoder.SimpleDecoder<I extends com.facebook.ads.redexgen.X.WZ, O extends com.facebook.ads.redexgen.X.WY, E extends java.lang.Exception> */
    private void A0K() {
        if (A0Q()) {
            this.A07.notify();
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.WX != com.facebook.ads.internal.exoplayer2.decoder.SimpleDecoder<I extends com.facebook.ads.redexgen.X.WZ, O extends com.facebook.ads.redexgen.X.WY, E extends java.lang.Exception> */
    private void A0L() throws Exception {
        E e2 = this.A04;
        if (e2 == null) {
            return;
        }
        throw e2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.WX != com.facebook.ads.internal.exoplayer2.decoder.SimpleDecoder<I extends com.facebook.ads.redexgen.X.WZ, O extends com.facebook.ads.redexgen.X.WY, E extends java.lang.Exception> */
    public void A0M() {
        while (A0R()) {
            try {
            } catch (InterruptedException e2) {
                throw new IllegalStateException(e2);
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.WX != com.facebook.ads.internal.exoplayer2.decoder.SimpleDecoder<I extends com.facebook.ads.redexgen.X.WZ, O extends com.facebook.ads.redexgen.X.WY, E extends java.lang.Exception> */
    private void A0N(I i2) {
        i2.A07();
        I[] iArr = this.A0B;
        int i3 = this.A00;
        this.A00 = i3 + 1;
        iArr[i3] = i2;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.WX != com.facebook.ads.internal.exoplayer2.decoder.SimpleDecoder<I extends com.facebook.ads.redexgen.X.WZ, O extends com.facebook.ads.redexgen.X.WY, E extends java.lang.Exception> */
    private void A0O(O o) {
        o.A07();
        O[] oArr = this.A0C;
        int i2 = this.A01;
        this.A01 = i2 + 1;
        oArr[i2] = o;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.WX != com.facebook.ads.internal.exoplayer2.decoder.SimpleDecoder<I extends com.facebook.ads.redexgen.X.WZ, O extends com.facebook.ads.redexgen.X.WY, E extends java.lang.Exception> */
    private boolean A0Q() {
        return !this.A09.isEmpty() && this.A01 > 0;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.WX != com.facebook.ads.internal.exoplayer2.decoder.SimpleDecoder<I extends com.facebook.ads.redexgen.X.WZ, O extends com.facebook.ads.redexgen.X.WY, E extends java.lang.Exception> */
    private boolean A0R() throws InterruptedException {
        synchronized (this.A07) {
            while (!this.A06 && !A0Q()) {
                this.A07.wait();
            }
            if (this.A06) {
                return false;
            }
            I removeFirst = this.A09.removeFirst();
            O[] oArr = this.A0C;
            int i2 = this.A01 - 1;
            this.A01 = i2;
            O o = oArr[i2];
            boolean z = this.A05;
            this.A05 = false;
            boolean resetDecoder = removeFirst.A04();
            if (resetDecoder) {
                o.A00(4);
            } else {
                boolean resetDecoder2 = removeFirst.A03();
                if (resetDecoder2) {
                    o.A00(Integer.MIN_VALUE);
                }
                try {
                    this.A04 = A0W(removeFirst, o, z);
                } catch (OutOfMemoryError e2) {
                    this.A04 = A0X(e2);
                } catch (RuntimeException e3) {
                    String[] strArr = A0D;
                    if (strArr[1].length() != strArr[7].length()) {
                        String[] strArr2 = A0D;
                        strArr2[1] = "JmdauonVcnINF";
                        strArr2[7] = "vppaV7cv17cCxaH2hgZaXUeE";
                        this.A04 = A0X(e3);
                    }
                }
                if (this.A04 != null) {
                    synchronized (this.A07) {
                    }
                    return false;
                }
            }
            Object obj = this.A07;
            String[] strArr3 = A0D;
            if (strArr3[0].length() == strArr3[6].length()) {
                String[] strArr4 = A0D;
                strArr4[1] = "q0ZgAWd6JYMJo";
                strArr4[7] = "B3H8IuJfVBRbzuvGv4HpnNYI";
                synchronized (obj) {
                    boolean resetDecoder3 = this.A05;
                    if (resetDecoder3) {
                        A0O(o);
                    } else {
                        boolean resetDecoder4 = o.A03();
                        if (resetDecoder4) {
                            this.A02++;
                            A0O(o);
                        } else {
                            o.A00 = this.A02;
                            this.A02 = 0;
                            this.A0A.addLast(o);
                        }
                    }
                    A0N(removeFirst);
                }
                return true;
            }
            throw new RuntimeException();
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.WX != com.facebook.ads.internal.exoplayer2.decoder.SimpleDecoder<I extends com.facebook.ads.redexgen.X.WZ, O extends com.facebook.ads.redexgen.X.WY, E extends java.lang.Exception> */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0753Bi
    /* renamed from: A0S */
    public final I A4i() throws Exception {
        I i2;
        I i3;
        synchronized (this.A07) {
            A0L();
            I6.A04(this.A03 == null);
            if (this.A00 == 0) {
                i2 = null;
            } else {
                I[] iArr = this.A0B;
                int i4 = this.A00 - 1;
                this.A00 = i4;
                i2 = iArr[i4];
            }
            this.A03 = i2;
            i3 = this.A03;
        }
        return i3;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.WX != com.facebook.ads.internal.exoplayer2.decoder.SimpleDecoder<I extends com.facebook.ads.redexgen.X.WZ, O extends com.facebook.ads.redexgen.X.WY, E extends java.lang.Exception> */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0753Bi
    /* renamed from: A0U */
    public final O A4j() throws Exception {
        synchronized (this.A07) {
            A0L();
            if (this.A0A.isEmpty()) {
                return null;
            }
            return this.A0A.removeFirst();
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.WX != com.facebook.ads.internal.exoplayer2.decoder.SimpleDecoder<I extends com.facebook.ads.redexgen.X.WZ, O extends com.facebook.ads.redexgen.X.WY, E extends java.lang.Exception> */
    public final void A0Y(int i2) {
        I[] iArr;
        I6.A04(this.A00 == this.A0B.length);
        for (I inputBuffer : this.A0B) {
            inputBuffer.A09(i2);
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.WX != com.facebook.ads.internal.exoplayer2.decoder.SimpleDecoder<I extends com.facebook.ads.redexgen.X.WZ, O extends com.facebook.ads.redexgen.X.WY, E extends java.lang.Exception> */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0753Bi
    /* renamed from: A0Z */
    public final void ADC(I i2) throws Exception {
        synchronized (this.A07) {
            A0L();
            I inputBuffer = this.A03;
            I6.A03(i2 == inputBuffer);
            this.A09.addLast(i2);
            A0K();
            this.A03 = null;
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.WX != com.facebook.ads.internal.exoplayer2.decoder.SimpleDecoder<I extends com.facebook.ads.redexgen.X.WZ, O extends com.facebook.ads.redexgen.X.WY, E extends java.lang.Exception> */
    public void A0a(O o) {
        synchronized (this.A07) {
            A0O(o);
            A0K();
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.WX != com.facebook.ads.internal.exoplayer2.decoder.SimpleDecoder<I extends com.facebook.ads.redexgen.X.WZ, O extends com.facebook.ads.redexgen.X.WY, E extends java.lang.Exception> */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0753Bi
    public final void ADS() {
        synchronized (this.A07) {
            this.A06 = true;
            this.A07.notify();
        }
        try {
            this.A08.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.WX != com.facebook.ads.internal.exoplayer2.decoder.SimpleDecoder<I extends com.facebook.ads.redexgen.X.WZ, O extends com.facebook.ads.redexgen.X.WY, E extends java.lang.Exception> */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0753Bi
    public final void flush() {
        synchronized (this.A07) {
            this.A05 = true;
            this.A02 = 0;
            if (this.A03 != null) {
                A0N(this.A03);
                this.A03 = null;
            }
            while (!this.A09.isEmpty()) {
                A0N(this.A09.removeFirst());
            }
            while (!this.A0A.isEmpty()) {
                A0O(this.A0A.removeFirst());
            }
        }
    }
}
