package com.facebook.ads.redexgen.X;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;
import com.facebook.ads.internal.exoplayer2.Format;
import com.facebook.ads.internal.exoplayer2.metadata.Metadata;
import java.util.Iterator;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.Wm  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class SurfaceHolder$CallbackC1276Wm implements J9, BG, GO, E6, SurfaceHolder.Callback, TextureView.SurfaceTextureListener {
    public static String[] A01 = {"tENgV7sVRmCggStQb7ahqyncu3McMlqx", "EBCLDe86SI67l2WgLGk", "Xc2z6PWfFp", "ZjGJvfPpi7mMWyj8ThC73X2hXIQsvVeY", "O", "wm4K2NOZzdg8zteNHm", "uxR1U8t68FFaIgGW", "ZP1sAESULwb937k6ya35I8qp57tsUFN9"};
    public final /* synthetic */ DA A00;

    public SurfaceHolder$CallbackC1276Wm(DA da) {
        this.A00 = da;
    }

    @Override // com.facebook.ads.redexgen.X.BG
    public final void A9s(String str, long j2, long j3) {
        Iterator it = DA.A0D(this.A00).iterator();
        while (it.hasNext()) {
            ((BG) it.next()).A9s(str, j2, j3);
        }
    }

    @Override // com.facebook.ads.redexgen.X.BG
    public final void A9t(C0754Bj c0754Bj) {
        Iterator it = DA.A0D(this.A00).iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            String[] strArr = A01;
            if (strArr[0].charAt(30) == strArr[7].charAt(30)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[4] = "r";
            strArr2[1] = "Pw7sEp82k0vieihjeRw";
            if (!hasNext) {
                DA da = this.A00;
                String[] strArr3 = A01;
                if (strArr3[0].charAt(30) == strArr3[7].charAt(30)) {
                    throw new RuntimeException();
                }
                A01[5] = "AJXnTxM8Cjr";
                DA.A04(da, null);
                DA.A06(this.A00, null);
                DA.A00(this.A00, 0);
                return;
            }
            BG bg = (BG) it.next();
            if (A01[3].charAt(20) != '3') {
                throw new RuntimeException();
            }
            A01[5] = "rZ";
            bg.A9t(c0754Bj);
        }
    }

    @Override // com.facebook.ads.redexgen.X.BG
    public final void A9u(C0754Bj c0754Bj) {
        DA.A06(this.A00, c0754Bj);
        Iterator it = DA.A0D(this.A00).iterator();
        while (it.hasNext()) {
            ((BG) it.next()).A9u(c0754Bj);
        }
    }

    @Override // com.facebook.ads.redexgen.X.BG
    public final void A9v(Format format) {
        DA.A04(this.A00, format);
        Iterator it = DA.A0D(this.A00).iterator();
        while (it.hasNext()) {
            ((BG) it.next()).A9v(format);
        }
    }

    @Override // com.facebook.ads.redexgen.X.BG
    public final void A9w(int i2) {
        DA.A00(this.A00, i2);
        Iterator it = DA.A0D(this.A00).iterator();
        while (it.hasNext()) {
            BG bg = (BG) it.next();
            if (A01[2].length() == 11) {
                throw new RuntimeException();
            }
            A01[2] = "0C";
            bg.A9w(i2);
        }
    }

    @Override // com.facebook.ads.redexgen.X.BG
    public final void A9x(int i2, long j2, long j3) {
        Iterator it = DA.A0D(this.A00).iterator();
        while (it.hasNext()) {
            ((BG) it.next()).A9x(i2, j2, j3);
        }
    }

    @Override // com.facebook.ads.redexgen.X.GO
    public final void AAG(List<GK> list) {
        DA.A08(this.A00, list);
        Iterator it = DA.A09(this.A00).iterator();
        while (it.hasNext()) {
            ((GO) it.next()).AAG(list);
        }
    }

    @Override // com.facebook.ads.redexgen.X.J9
    public final void AAS(int i2, long j2) {
        Iterator it = DA.A0B(this.A00).iterator();
        while (it.hasNext()) {
            ((J9) it.next()).AAS(i2, j2);
        }
    }

    @Override // com.facebook.ads.redexgen.X.E6
    public final void ABJ(Metadata metadata) {
        Iterator it = DA.A0A(this.A00).iterator();
        while (it.hasNext()) {
            ((E6) it.next()).ABJ(metadata);
        }
    }

    @Override // com.facebook.ads.redexgen.X.J9
    public final void ABs(Surface surface) {
        if (DA.A01(this.A00) == surface) {
            Iterator it = DA.A0C(this.A00).iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        Iterator it2 = DA.A0B(this.A00).iterator();
        while (it2.hasNext()) {
            ((J9) it2.next()).ABs(surface);
        }
    }

    @Override // com.facebook.ads.redexgen.X.J9
    public final void ACP(String str, long j2, long j3) {
        Iterator it = DA.A0B(this.A00).iterator();
        while (it.hasNext()) {
            ((J9) it.next()).ACP(str, j2, j3);
        }
    }

    @Override // com.facebook.ads.redexgen.X.J9
    public final void ACQ(C0754Bj c0754Bj) {
        Iterator it = DA.A0B(this.A00).iterator();
        while (it.hasNext()) {
            ((J9) it.next()).ACQ(c0754Bj);
        }
        DA.A03(this.A00, null);
        DA.A05(this.A00, null);
    }

    @Override // com.facebook.ads.redexgen.X.J9
    public final void ACR(C0754Bj c0754Bj) {
        DA.A05(this.A00, c0754Bj);
        Iterator it = DA.A0B(this.A00).iterator();
        while (it.hasNext()) {
            J9 j9 = (J9) it.next();
            if (A01[3].charAt(20) != '3') {
                throw new RuntimeException();
            }
            A01[5] = "6iGRC7";
            j9.ACR(c0754Bj);
        }
    }

    @Override // com.facebook.ads.redexgen.X.J9
    public final void ACU(Format format) {
        DA.A03(this.A00, format);
        Iterator it = DA.A0B(this.A00).iterator();
        while (it.hasNext()) {
            J9 j9 = (J9) it.next();
            String[] strArr = A01;
            if (strArr[0].charAt(30) == strArr[7].charAt(30)) {
                throw new RuntimeException();
            }
            A01[5] = "M1lNqMtLlEQhDRLPZV8vitTN6y5pnm";
            j9.ACU(format);
        }
    }

    @Override // com.facebook.ads.redexgen.X.J9
    public final void ACZ(int i2, int i3, int i4, float f2) {
        Iterator it = DA.A0C(this.A00).iterator();
        while (it.hasNext()) {
            ((J0) it.next()).ACZ(i2, i3, i4, f2);
        }
        Iterator it2 = DA.A0B(this.A00).iterator();
        while (it2.hasNext()) {
            ((J9) it2.next()).ACZ(i2, i3, i4, f2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        DA.A0H(this.A00, new Surface(surfaceTexture), true);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        DA.A0H(this.A00, null, true);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        DA.A0H(this.A00, surfaceHolder.getSurface(), false);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        DA.A0H(this.A00, null, false);
    }
}
