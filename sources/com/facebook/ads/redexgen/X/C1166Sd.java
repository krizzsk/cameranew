package com.facebook.ads.redexgen.X;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.facebook.proguard.annotations.DoNotStrip;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* renamed from: com.facebook.ads.redexgen.X.Sd  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1166Sd extends AbstractC1045Nk {
    public static byte[] A0F;
    public static String[] A0G = {"8gq0YClbFfezV7VWazRrkmUo5IqHlAe0", "DZEC2fF8R1zbFaxtc", "FhN1N87P5UC3PnJCVDWnxEC", "JmSzPmcyjiRof3lizahs2qZ", "A3Evrr3LcR4BJzz79LIh", "2a6NLKfKqYFtWGCWoigE8lnPrM", "Nz12Z6hGfXPsqa2uThDzH9TN", "eI6gTMB0yvKckA2LC3VZ0zYV"};
    public static final String A0H;
    public float A00;
    public C1009Lz A01;
    @DoNotStrip
    public QY A02;
    @Nullable
    public QZ A03;
    public boolean A04;
    public boolean A05;
    public boolean A06;
    public final Path A07;
    public final RectF A08;
    public final XT A09;
    public final WeakReference<InterfaceC1048Nn> A0A;
    public final AtomicBoolean A0B;
    public final AtomicBoolean A0C;
    public final AtomicInteger A0D;
    public final AtomicReference<String> A0E;

    public static String A04(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0F, i2, i2 + i3);
        int i5 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A0G;
            if (strArr[7].length() != strArr[6].length()) {
                throw new RuntimeException();
            }
            A0G[1] = "qkBM5EbEKD4bLDmS2";
            if (i5 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 94);
            i5++;
        }
    }

    public static void A06() {
        A0F = new byte[]{0, 35, 2, 46, 45, 51, 49, 46, 43};
    }

    static {
        A06();
        A0H = C1166Sd.class.getSimpleName();
    }

    public C1166Sd(XT xt, WeakReference<InterfaceC1048Nn> weakReference, int i2, String str) {
        this(xt, weakReference, i2, false);
        if (JD.A1D(xt)) {
            xt.A00().A09().AFD(this, str == null ? A04(0, 0, 74) : str, false, true);
            this.A06 = true;
        }
    }

    public C1166Sd(XT xt, WeakReference<InterfaceC1048Nn> weakReference, int i2, boolean z) {
        super(xt);
        this.A0B = new AtomicBoolean();
        this.A0C = new AtomicBoolean(true);
        this.A07 = new Path();
        this.A08 = new RectF();
        this.A0D = new AtomicInteger(5000);
        this.A0E = new AtomicReference<>();
        this.A01 = new C1009Lz();
        this.A05 = true;
        this.A06 = false;
        this.A09 = xt;
        this.A04 = z;
        this.A0A = weakReference;
        this.A02 = new C1170Sh(this);
        this.A03 = new QZ(this, i2, new WeakReference(this.A02), this.A09);
        setWebChromeClient(A0D());
        setWebViewClient(A0E());
        getSettings().setSupportZoom(false);
        getSettings().setCacheMode(1);
        if (Build.VERSION.SDK_INT > 16) {
            addJavascriptInterface(new C1047Nm(this, weakReference.get(), this.A03, this.A0B, this.A0C, this.A09), A04(0, 9, 97));
        }
    }

    @VisibleForTesting
    private final boolean A07() {
        return this.A0B.get();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1045Nk
    public final WebChromeClient A0D() {
        return new C1049No();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1045Nk
    public final WebViewClient A0E() {
        return new C1050Np(this.A09, this.A0A, new WeakReference(this.A03), new WeakReference(this.A01), new WeakReference(this.A0C), new WeakReference(this), this.A0D, this.A0E, this.A04);
    }

    @VisibleForTesting
    public final void A0F() {
        this.A09.A0D().AFF();
        this.A0B.set(true);
        new Handler(Looper.getMainLooper()).post(new C1168Sf(this.A03));
    }

    public final void A0G(int i2, int i3) {
        QZ qz = this.A03;
        if (qz != null) {
            qz.A0W(i2);
            this.A03.A0X(i3);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1045Nk, android.webkit.WebView
    public final void destroy() {
        if (this.A06) {
            this.A09.A00().A09().AF3(this);
        }
        QZ qz = this.A03;
        if (qz != null) {
            qz.A0V();
            this.A03 = null;
        }
        M5.A0J(this);
        this.A02 = null;
        this.A01 = null;
        C1051Nq.A03(this);
        super.destroy();
    }

    public C1009Lz getTouchDataRecorder() {
        return this.A01;
    }

    public QZ getViewabilityChecker() {
        return this.A03;
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onDraw(Canvas canvas) {
        if (this.A00 > 0.0f) {
            this.A08.set(0.0f, 0.0f, getWidth(), getHeight());
            this.A07.reset();
            Path path = this.A07;
            RectF rectF = this.A08;
            float f2 = this.A00;
            path.addRoundRect(rectF, f2, f2, Path.Direction.CW);
            canvas.clipPath(this.A07);
        }
        super.onDraw(canvas);
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        this.A01.A06(motionEvent, this, this);
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        if (this.A0A.get() != null) {
            this.A0A.get();
        }
        if (this.A03 == null) {
            return;
        }
        this.A09.A0D().AFT(i2);
        if (A0G[1].length() != 17) {
            throw new RuntimeException();
        }
        String[] strArr = A0G;
        strArr[7] = "DtJWCHxLbH6gtxJRxIB1oyEG";
        strArr[6] = "cIpyg99BbIZ2paT5Gicx86FT";
        if (i2 == 0 && A07()) {
            this.A03.A0U();
        } else if (i2 != 8) {
        } else {
            this.A03.A0V();
        }
    }

    public void setBlockLocalFileAccessOutsideCache(boolean z) {
        this.A04 = z;
    }

    public void setCheckAssetsByJavascriptBridge(boolean z) {
        this.A0C.set(z);
    }

    public void setCornerRadius(float f2) {
        this.A00 = f2;
        invalidate();
    }

    public void setLogMultipleImpressions(boolean z) {
        this.A05 = z;
    }

    public void setRequestId(String str) {
        this.A0E.set(str);
    }

    public void setWebViewTimeoutInMillis(int i2) {
        if (i2 >= 0) {
            this.A0D.set(i2);
        }
    }
}
