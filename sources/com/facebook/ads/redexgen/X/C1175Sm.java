package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.Build;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
@TargetApi(19)
/* renamed from: com.facebook.ads.redexgen.X.Sm  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1175Sm extends AbstractC1045Nk {
    @Nullable
    public static ValueCallback A08;
    public static boolean A09;
    public static boolean A0A;
    public static byte[] A0B;
    public static final String A0C;
    public static final Set<String> A0D;
    public long A00;
    public long A01;
    public long A02;
    public long A03;
    public C1036Nb A04;
    public InterfaceC1039Ne A05;
    public final XT A06;
    public final C1042Nh A07;

    public static String A05(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0B, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 93);
        }
        return new String(copyOfRange);
    }

    public static void A09() {
        A0B = new byte[]{83, 79, 79, 75, 49, 45, 45, 41, 42};
    }

    static {
        A09();
        A0C = C1175Sm.class.getSimpleName();
        A0D = new HashSet(2);
        A09 = false;
        A0A = false;
        A0D.add(A05(0, 4, 102));
        A0D.add(A05(4, 5, 4));
    }

    public C1175Sm(XT xt, Activity activity, InterfaceC1039Ne interfaceC1039Ne) {
        super(activity, xt);
        this.A02 = -1L;
        this.A00 = -1L;
        this.A03 = -1L;
        this.A01 = -1L;
        this.A05 = interfaceC1039Ne;
        this.A06 = xt;
        setWebChromeClient(A0D());
        this.A07 = A0E();
        setWebViewClient(this.A07);
        A08();
    }

    public C1175Sm(XT xt, InterfaceC1039Ne interfaceC1039Ne) {
        super(xt);
        this.A02 = -1L;
        this.A00 = -1L;
        this.A03 = -1L;
        this.A01 = -1L;
        this.A05 = interfaceC1039Ne;
        this.A06 = xt;
        setWebChromeClient(A0D());
        this.A07 = A0E();
        setWebViewClient(this.A07);
        A08();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.AbstractC1045Nk
    /* renamed from: A04 */
    public final C1042Nh A0E() {
        return new C1042Nh(new WeakReference(this.A05), new WeakReference(this.A06));
    }

    private void A07() {
        if (this.A00 > -1 && this.A03 > -1 && this.A01 > -1) {
            this.A04.A05(false);
        }
    }

    private void A08() {
        A09 = JE.A03(this.A06);
        A0A = JE.A04(this.A06);
        WebSettings settings = getSettings();
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setAllowContentAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setAllowFileAccess(false);
        this.A04 = new C1036Nb(this);
    }

    public static void A0A(int i2, int i3, Intent intent) {
        if (A08 != null && i2 == 1001) {
            if (Build.VERSION.SDK_INT >= 21) {
                A08.onReceiveValue(WebChromeClient.FileChooserParams.parseResult(i3, intent));
            } else {
                A08.onReceiveValue(intent.getData());
            }
            A08 = null;
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1045Nk
    public final WebChromeClient A0D() {
        return new C1041Ng(new WeakReference(this.A06), new WeakReference(this.A05), new WeakReference(this.A04));
    }

    public final void A0F(long j2) {
        if (this.A00 < 0) {
            this.A00 = j2;
        }
        A07();
    }

    public final void A0G(long j2) {
        if (this.A01 < 0) {
            this.A01 = j2;
        }
        A07();
    }

    public final void A0H(long j2) {
        if (this.A02 < 0) {
            this.A02 = j2;
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1045Nk, android.webkit.WebView
    public final void destroy() {
        this.A05 = null;
        C1051Nq.A03(this);
        super.destroy();
    }

    public long getDomContentLoadedMs() {
        return this.A00;
    }

    public String getFirstUrl() {
        WebBackForwardList copyBackForwardList = copyBackForwardList();
        if (copyBackForwardList.getSize() > 0) {
            return copyBackForwardList.getItemAtIndex(0).getUrl();
        }
        return getUrl();
    }

    public long getLoadFinishMs() {
        return this.A01;
    }

    public long getResponseEndMs() {
        return this.A02;
    }

    public long getScrollReadyMs() {
        return this.A03;
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.A03 < 0 && computeVerticalScrollRange() > getHeight()) {
            this.A03 = System.currentTimeMillis();
            A07();
        }
    }

    public void setBrowserNavigationListener(InterfaceC1040Nf interfaceC1040Nf) {
        this.A07.A03(new WeakReference<>(interfaceC1040Nf));
    }
}
