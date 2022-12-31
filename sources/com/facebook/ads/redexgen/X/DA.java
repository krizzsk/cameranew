package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.Format;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
@TargetApi(16)
/* loaded from: assets/audience_network.dex */
public final class DA implements InterfaceC1278Wo, InterfaceC0721Ab, AZ {
    public static byte[] A0O;
    public static String[] A0P = {"p1p2g9mbI7jG28uS1AIjZaN2DuNLisT4", "5M6TC2sONh3rGys5YKd78dMRKX2wOUqH", "h92WNkWPJTM", "jYXxaa6xf7axcTjhEWPmUH7zZsfwsjgI", "vYDSW5DyAu5jQwnIRgw24Ezub5gSEfu7", "VyMVayVAQGyPc0QthTR0tkMwCD52dsyF", "LU4FXKZXpKPxotYf", "puFnwNxTYtdaaLd9gUGAlTVzIEShK4ZY"};
    public float A00;
    public int A01;
    public int A02;
    @Nullable
    public Surface A03;
    @Nullable
    public SurfaceHolder A04;
    @Nullable
    public TextureView A05;
    public Format A06;
    public Format A07;
    public B0 A08;
    public C0754Bj A09;
    public C0754Bj A0A;
    public FN A0B;
    public List<GK> A0C;
    public boolean A0D;
    public final Handler A0E;
    public final InterfaceC1278Wo A0F;
    public final SurfaceHolder$CallbackC1276Wm A0G;
    public final C1274Wk A0H;
    public final CopyOnWriteArraySet<BG> A0I;
    public final CopyOnWriteArraySet<E6> A0J;
    public final CopyOnWriteArraySet<GO> A0K;
    public final CopyOnWriteArraySet<J9> A0L;
    public final CopyOnWriteArraySet<J0> A0M;
    public final InterfaceC1277Wn[] A0N;

    public static String A07(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0O, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 58);
        }
        return new String(copyOfRange);
    }

    public static void A0F() {
        A0O = new byte[]{45, 23, 19, 14, 18, 27, 59, 6, 17, 46, 18, 31, 7, 27, 12, 9, 47, 40, 60, 59, 57, 63, 14, 63, 34, 46, 47, 40, 63, 22, 51, 41, 46, 63, 52, 63, 40, 122, 59, 54, 40, 63, 59, 62, 35, 122, 47, 52, 41, 63, 46, 122, 53, 40, 122, 40, 63, 42, 54, 59, 57, 63, 62, 116};
    }

    static {
        A0F();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.C9 != com.facebook.ads.internal.exoplayer2.drm.DrmSessionManager<com.facebook.ads.internal.exoplayer2.drm.FrameworkMediaCrypto> */
    public DA(InterfaceC0729Aj interfaceC0729Aj, HG hg, AO ao, @Nullable C9<WT> c9) {
        this(interfaceC0729Aj, hg, ao, c9, new C0734Ap());
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.C9 != com.facebook.ads.internal.exoplayer2.drm.DrmSessionManager<com.facebook.ads.internal.exoplayer2.drm.FrameworkMediaCrypto> */
    public DA(InterfaceC0729Aj interfaceC0729Aj, HG hg, AO ao, @Nullable C9<WT> c9, C0734Ap c0734Ap) {
        this(interfaceC0729Aj, hg, ao, c9, c0734Ap, I9.A00);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.C9 != com.facebook.ads.internal.exoplayer2.drm.DrmSessionManager<com.facebook.ads.internal.exoplayer2.drm.FrameworkMediaCrypto> */
    public DA(InterfaceC0729Aj interfaceC0729Aj, HG hg, AO ao, @Nullable C9<WT> c9, C0734Ap c0734Ap, I9 i9) {
        this.A0G = new SurfaceHolder$CallbackC1276Wm(this);
        this.A0M = new CopyOnWriteArraySet<>();
        this.A0K = new CopyOnWriteArraySet<>();
        this.A0J = new CopyOnWriteArraySet<>();
        this.A0L = new CopyOnWriteArraySet<>();
        this.A0I = new CopyOnWriteArraySet<>();
        this.A0E = new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper());
        Handler handler = this.A0E;
        SurfaceHolder$CallbackC1276Wm surfaceHolder$CallbackC1276Wm = this.A0G;
        this.A0N = interfaceC0729Aj.A4P(handler, surfaceHolder$CallbackC1276Wm, surfaceHolder$CallbackC1276Wm, surfaceHolder$CallbackC1276Wm, surfaceHolder$CallbackC1276Wm, c9);
        this.A00 = 1.0f;
        this.A01 = 0;
        this.A08 = B0.A04;
        this.A02 = 1;
        this.A0C = Collections.emptyList();
        this.A0F = A02(this.A0N, hg, ao, i9);
        this.A0H = c0734Ap.A00(this.A0F, i9);
        A3D(this.A0H);
        this.A0L.add(this.A0H);
        this.A0I.add(this.A0H);
        A0I(this.A0H);
        if (c9 instanceof WV) {
            ((WV) c9).A04(this.A0E, this.A0H);
        }
    }

    private final InterfaceC1278Wo A02(InterfaceC1277Wn[] interfaceC1277WnArr, HG hg, AO ao, I9 i9) {
        return new DU(interfaceC1277WnArr, hg, ao, i9);
    }

    private void A0E() {
        TextureView textureView = this.A05;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != this.A0G) {
                Log.w(A07(0, 15, 68), A07(15, 49, 96));
            } else {
                this.A05.setSurfaceTextureListener(null);
            }
            this.A05 = null;
        }
        SurfaceHolder surfaceHolder = this.A04;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.A0G);
            this.A04 = null;
        }
    }

    public void A0G(@Nullable Surface surface, boolean z) {
        InterfaceC1277Wn[] interfaceC1277WnArr;
        ArrayList<C0725Af> arrayList = new ArrayList();
        for (InterfaceC1277Wn interfaceC1277Wn : this.A0N) {
            int A7b = interfaceC1277Wn.A7b();
            String[] strArr = A0P;
            if (strArr[5].charAt(24) == strArr[4].charAt(24)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0P;
            strArr2[6] = "VrJ3McZcw7cn2zeT";
            strArr2[0] = "MNepmlV8OvsHi61EfIBswCx5NcPOIPrl";
            if (A7b == 2) {
                arrayList.add(this.A0F.A4J(interfaceC1277Wn).A06(1).A07(surface).A05());
            }
        }
        Surface surface2 = this.A03;
        if (surface2 != null && surface2 != surface) {
            try {
                for (C0725Af c0725Af : arrayList) {
                    c0725Af.A0C();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
            if (this.A0D) {
                this.A03.release();
            }
        }
        this.A03 = surface;
        if (A0P[7].charAt(22) != 'V') {
            throw new RuntimeException();
        }
        String[] strArr3 = A0P;
        strArr3[5] = "BcNzrhvciYYCifYD3J0kGNpt4Q56t2ws";
        strArr3[4] = "LBzJc3KMaCoazXjGhEegCXyOf3paMmXp";
        this.A0D = z;
    }

    private final void A0I(E6 e6) {
        this.A0J.add(e6);
    }

    public final int A0J() {
        return this.A01;
    }

    public final Format A0K() {
        return this.A06;
    }

    @Nullable
    public final Format A0L() {
        return this.A07;
    }

    public final void A0M() {
        AEs(false);
    }

    public final void A0N(float f2) {
        InterfaceC1277Wn[] interfaceC1277WnArr;
        this.A00 = f2;
        for (InterfaceC1277Wn interfaceC1277Wn : this.A0N) {
            String[] strArr = A0P;
            if (strArr[5].charAt(24) == strArr[4].charAt(24)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0P;
            strArr2[6] = "TZ1OBcEbhXggSiRE";
            strArr2[0] = "o47SCfAcsD46THYYRPii4HELThPbmwG8";
            if (interfaceC1277Wn.A7b() == 1) {
                this.A0F.A4J(interfaceC1277Wn).A06(2).A07(Float.valueOf(f2)).A05();
            }
        }
    }

    public final void A0O(@Nullable Surface surface) {
        A0E();
        A0G(surface, false);
    }

    public final void A0P(FN fn) {
        ACz(fn, true, true);
    }

    public final void A0Q(J0 j0) {
        this.A0M.add(j0);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0722Ac
    public final void A3D(AX ax) {
        this.A0F.A3D(ax);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1278Wo
    public final C0725Af A4J(InterfaceC0724Ae interfaceC0724Ae) {
        return this.A0F.A4J(interfaceC0724Ae);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0722Ac
    public final int A5o() {
        return this.A0F.A5o();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0722Ac
    public final long A5p() {
        return this.A0F.A5p();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0722Ac
    public final long A66() {
        return this.A0F.A66();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0722Ac
    public final int A68() {
        return this.A0F.A68();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0722Ac
    public final int A69() {
        return this.A0F.A69();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0722Ac
    public final long A6B() {
        return this.A0F.A6B();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0722Ac
    public final AbstractC0733Ao A6D() {
        return this.A0F.A6D();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0722Ac
    public final int A6E() {
        return this.A0F.A6E();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0722Ac
    public final long A6N() {
        return this.A0F.A6N();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0722Ac
    public final boolean A77() {
        return this.A0F.A77();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1278Wo
    public final void ACz(FN fn, boolean z, boolean z2) {
        FN fn2 = this.A0B;
        if (fn2 != fn) {
            if (fn2 != null) {
                fn2.ADb(this.A0H);
                this.A0H.A07();
            }
            fn.A3B(this.A0E, this.A0H);
            this.A0B = fn;
        }
        this.A0F.ACz(fn, z, z2);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0722Ac
    public final void ADS() {
        this.A0F.ADS();
        A0E();
        Surface surface = this.A03;
        if (surface != null) {
            if (this.A0D) {
                surface.release();
            }
            this.A03 = null;
        }
        FN fn = this.A0B;
        if (fn != null) {
            fn.ADb(this.A0H);
        }
        this.A0C = Collections.emptyList();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0722Ac
    public final void AEB(long j2) {
        this.A0H.A06();
        this.A0F.AEB(j2);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0722Ac
    public final void AEC() {
        this.A0H.A06();
        this.A0F.AEC();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0722Ac
    public final void AES(boolean z) {
        this.A0F.AES(z);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0722Ac
    public final void AEs(boolean z) {
        this.A0F.AEs(z);
        FN fn = this.A0B;
        if (fn != null) {
            fn.ADb(this.A0H);
            this.A0B = null;
            this.A0H.A07();
        }
        this.A0C = Collections.emptyList();
        String[] strArr = A0P;
        if (strArr[6].length() == strArr[0].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0P;
        strArr2[5] = "8NqoZsSfBCZ1v43okD4Pix8d8oY1Moxp";
        strArr2[4] = "VfYOa1CKuZhM9jsFhHY6jw4UB0OoLmrV";
    }
}
