package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.webkit.JavascriptInterface;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
/* renamed from: com.facebook.ads.redexgen.X.Nm  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1047Nm {
    public static String[] A07 = {"FOFLIt4izaDLaQDOMIXk8qYNT283z5pM", "oiToeohcscvINDKXEsytRf9HFldaqPXB", "4ipPd9h88IiL3d99rWL92oIsRR1k6HBA", "hPx", "0GhefH5NzI2ypbPnqUG75Cq8VmhNX1", "2b6", "snO0JYp8WiAdMwbOevXppfTs6iFhTSIS", "awSLBYFe7Md8cHgboMT9P3Pgh1wlsZGE"};
    public final String A00 = C1047Nm.class.getSimpleName();
    public final WeakReference<AtomicBoolean> A01;
    public final WeakReference<AtomicBoolean> A02;
    public final WeakReference<C0R> A03;
    public final WeakReference<InterfaceC1048Nn> A04;
    public final WeakReference<QZ> A05;
    public final WeakReference<C1166Sd> A06;

    public C1047Nm(C1166Sd c1166Sd, InterfaceC1048Nn interfaceC1048Nn, QZ qz, AtomicBoolean atomicBoolean, AtomicBoolean atomicBoolean2, XT xt) {
        this.A06 = new WeakReference<>(c1166Sd);
        this.A04 = new WeakReference<>(interfaceC1048Nn);
        this.A05 = new WeakReference<>(qz);
        this.A01 = new WeakReference<>(atomicBoolean);
        this.A02 = new WeakReference<>(atomicBoolean2);
        this.A03 = new WeakReference<>(xt.A0D());
    }

    private C0R A00() {
        C0R c0r = this.A03.get();
        if (c0r == null) {
            return new C1555dA();
        }
        return c0r;
    }

    @JavascriptInterface
    public void alert(String str) {
        Log.e(this.A00, str);
    }

    @JavascriptInterface
    public String getAnalogInfo() {
        return C0988Le.A01(C06898v.A02());
    }

    @JavascriptInterface
    public void logFunnel(int i2, String str) {
        A00().AFG(i2, str);
    }

    @JavascriptInterface
    public void onMainAssetLoaded() {
        A00().AFH();
        if (this.A06.get() == null || this.A01.get() == null || this.A02.get() == null) {
            return;
        }
        boolean z = this.A02.get().get();
        String[] strArr = A07;
        if (strArr[4].length() == strArr[5].length()) {
            throw new RuntimeException();
        }
        A07[1] = "xXjDpbk5Vvc7CvrBd08NYXaJ46SIZN7q";
        if (z) {
            this.A01.get().set(true);
            A00().AFI();
            if (this.A06.get().isShown()) {
                A00().AFJ();
                new Handler(Looper.getMainLooper()).post(new C1168Sf(this.A05));
            }
            InterfaceC1048Nn interfaceC1048Nn = this.A04.get();
            if (interfaceC1048Nn != null) {
                new Handler(Looper.getMainLooper()).post(new RunnableC1046Nl(this, interfaceC1048Nn));
            }
        }
    }

    @JavascriptInterface
    public void onPageInitialized() {
        C1166Sd c1166Sd = this.A06.get();
        if (c1166Sd == null || c1166Sd.A06()) {
            A00().AFK(true);
            return;
        }
        InterfaceC1048Nn interfaceC1048Nn = this.A04.get();
        if (interfaceC1048Nn == null) {
            A00().AFK(true);
            return;
        }
        A00().AFK(false);
        interfaceC1048Nn.ABS();
    }
}
