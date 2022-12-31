package com.facebook.ads.redexgen.X;

import android.net.TrafficStats;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import com.tencent.matrix.trace.constants.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.Executor;
/* renamed from: com.facebook.ads.redexgen.X.Gr  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0877Gr implements InterfaceC1116Qf {
    public static byte[] A07;
    public static String[] A08 = {"Z3ZBH3trhaxMswGoeO0i3WMhBsCqcWgs", "P814sFImmOC", "INcscN3Z5kcfIuBeknVxelrdNm8ANoXs", "RvJjsajerkLdUat3TDI8NPR3DDSWtO", "ZLSXhw", "wxtWSqUF9a7Aw2d1StIocmcoa4QX", "58xAXbC3p", "Zj1UZNXOzFX"};
    public static final String A09;
    public InterfaceC06798l A00;
    public Executor A01;
    public boolean A02;
    public C1121Qk A03;
    public final InterfaceC1131Qu A06;
    public final InterfaceC1126Qp A05 = new HU();
    public InterfaceC1132Qv A04 = new C0876Gq();

    public static String A07(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 93);
        }
        return new String(copyOfRange);
    }

    public static void A0A() {
        A07 = new byte[]{16, 18, 55, 58, 95, 55, 53, 74, 71, 14, 74, 72, 15, 76, 90, 93, 67, 15, 14, 71, 93, 14, 64, 65, 90, 14, 79, 14, 88, 79, 66, 71, 74, 14, 123, 124, 98, 14, 65, 72, 14, 94, 102, 106, 9, 30, 106, 119, 106, 28, 16, 98, 100, 16, Draft_75.CR, 16, 55, 59, 111, 105, 98, 114, 117, 124, 59, 81, 17, 59, 50, 63, 46, 45, 59, 58, 94, 42, 55, 51, 59, 94, 67, 94, 1, 35, 50, 50, 47, 40, 33, 102, 50, 46, 35, 102, 46, 50, 50, 54, 102, 52, 35, 53, 54, 41, 40, 53, 35, 102, 50, 47, 43, 35, 34, 102, 41, 51, 50, 61, 60, 46, 69, 80, 22, 7, 7, 27, 30, 20, 22, 3, 30, 24, 25, 88, 15, 90, 0, 0, 0, 90, 17, 24, 5, 26, 90, 2, 5, 27, 18, 25, 20, 24, 19, 18, 19, 76, 20, 31, 22, 5, 4, 18, 3, 74, 34, 35, 49, 90, 79, 120, 110, 105, 119, 59, 54, 112, 59, 54, 114, 36, 56, 56, 60, 98, 60, 62, 35, 52, 53, 4, 35, 63, 56, 24, 4, 4, 0, 94, 0, 2, 31, 8, 9, 32, 31, 2, 4, 121, 114, 99, 96, 120, 101, 124};
    }

    static {
        A0A();
        A09 = InterfaceC1116Qf.class.getSimpleName();
    }

    public C0877Gr(C1121Qk c1121Qk, InterfaceC06798l interfaceC06798l, Executor executor) {
        A0B();
        this.A03 = c1121Qk;
        this.A06 = new HT() { // from class: com.facebook.ads.redexgen.X.4F
        };
        this.A01 = executor;
        this.A00 = interfaceC06798l;
    }

    private final int A00(HttpURLConnection httpURLConnection, byte[] bArr) throws Exception {
        OutputStream outputStream = null;
        try {
            outputStream = this.A06.ACk(httpURLConnection);
            if (outputStream != null) {
                this.A06.AFX(outputStream, bArr);
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception unused) {
                }
            }
            return responseCode;
        } catch (Throwable th) {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005a A[Catch: Exception -> 0x00c1, all -> 0x012d, TryCatch #5 {Exception -> 0x00c1, blocks: (B:3:0x000c, B:5:0x0014, B:6:0x0018, B:8:0x002e, B:9:0x0037, B:11:0x004b, B:18:0x005a, B:21:0x0061, B:30:0x0080, B:29:0x0073, B:31:0x008c, B:33:0x0092, B:35:0x0098, B:36:0x009f, B:38:0x00a5, B:39:0x00aa, B:14:0x0052), top: B:86:0x000c, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a5 A[Catch: Exception -> 0x00c1, all -> 0x012d, TryCatch #5 {Exception -> 0x00c1, blocks: (B:3:0x000c, B:5:0x0014, B:6:0x0018, B:8:0x002e, B:9:0x0037, B:11:0x004b, B:18:0x005a, B:21:0x0061, B:30:0x0080, B:29:0x0073, B:31:0x008c, B:33:0x0092, B:35:0x0098, B:36:0x009f, B:38:0x00a5, B:39:0x00aa, B:14:0x0052), top: B:86:0x000c, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00aa A[Catch: Exception -> 0x00c1, all -> 0x012d, TRY_LEAVE, TryCatch #5 {Exception -> 0x00c1, blocks: (B:3:0x000c, B:5:0x0014, B:6:0x0018, B:8:0x002e, B:9:0x0037, B:11:0x004b, B:18:0x005a, B:21:0x0061, B:30:0x0080, B:29:0x0073, B:31:0x008c, B:33:0x0092, B:35:0x0098, B:36:0x009f, B:38:0x00a5, B:39:0x00aa, B:14:0x0052), top: B:86:0x000c, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.facebook.ads.redexgen.X.InterfaceC1115Qe A01(com.facebook.ads.redexgen.X.AbstractC1128Qr r9) throws com.facebook.ads.redexgen.X.C1129Qs {
        /*
            Method dump skipped, instructions count: 321
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0877Gr.A01(com.facebook.ads.redexgen.X.Qr):com.facebook.ads.redexgen.X.Qe");
    }

    @Nullable
    private final InterfaceC1115Qe A02(AbstractC1128Qr abstractC1128Qr) {
        if (this.A03.A04()) {
            A0C(abstractC1128Qr);
        }
        InterfaceC1115Qe interfaceC1115Qe = null;
        try {
            interfaceC1115Qe = A01(abstractC1128Qr);
            return interfaceC1115Qe;
        } catch (C1129Qs e2) {
            this.A06.AAY(e2);
            return interfaceC1115Qe;
        } catch (Exception e3) {
            this.A06.AAY(new C1129Qs(e3, interfaceC1115Qe));
            return interfaceC1115Qe;
        }
    }

    @Nullable
    private final InterfaceC1115Qe A03(String str, C1130Qt c1130Qt, C1124Qn c1124Qn) {
        return A02(new H7(str, c1130Qt, c1124Qn));
    }

    @Nullable
    private final InterfaceC1115Qe A04(String str, String str2, byte[] bArr, C1124Qn c1124Qn) {
        return A02(new H2(str, null, str2, bArr, c1124Qn));
    }

    private final InterfaceC1115Qe A05(HttpURLConnection httpURLConnection) throws Exception {
        InputStream inputStream = null;
        byte[] bArr = null;
        try {
            inputStream = httpURLConnection.getErrorStream();
            if (inputStream != null) {
                bArr = this.A06.ADK(inputStream);
            }
            C0878Gs c0878Gs = new C0878Gs(httpURLConnection, bArr);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception unused) {
                }
            }
            return c0878Gs;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }

    private final InterfaceC1115Qe A06(HttpURLConnection httpURLConnection) throws Exception {
        InputStream inputStream = null;
        byte[] bArr = null;
        try {
            inputStream = this.A06.ACj(httpURLConnection);
            if (inputStream != null) {
                bArr = this.A06.ADK(inputStream);
            }
            C0878Gs c0878Gs = new C0878Gs(httpURLConnection, bArr);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception unused) {
                }
            }
            return c0878Gs;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }

    private final HttpURLConnection A08(String str, Proxy proxy) throws IOException {
        try {
            new URL(str);
            TrafficStats.setThreadStatsTag(61453);
            return this.A06.ACi(str, proxy);
        } catch (MalformedURLException e2) {
            throw new IllegalArgumentException(str + A07(18, 19, 115), e2);
        }
    }

    public static Proxy A09() {
        Proxy proxy = Proxy.NO_PROXY;
        String property = System.getProperty(A07(179, 14, 17));
        String property2 = System.getProperty(A07(193, 14, 45));
        int i2 = -1;
        if (property2 != null) {
            try {
                i2 = Integer.parseInt(property2);
            } catch (NumberFormatException unused) {
                return proxy;
            }
        }
        boolean isEmpty = TextUtils.isEmpty(property);
        String[] strArr = A08;
        String portStr = strArr[0];
        String proxyAddress = strArr[2];
        if (portStr.charAt(28) != proxyAddress.charAt(28)) {
            String[] strArr2 = A08;
            strArr2[3] = "UW2PAxLqNCWQ7bdKo0A7Pw4nSyNkIv";
            strArr2[6] = "26yRDH09B";
            if (!isEmpty && i2 > 0 && i2 <= 65535) {
                return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(property, i2));
            }
            return proxy;
        }
        throw new RuntimeException();
    }

    public static synchronized void A0B() {
        synchronized (C0877Gr.class) {
            if (CookieHandler.getDefault() == null) {
                CookieHandler.setDefault(new CookieManager());
            }
        }
    }

    private void A0C(AbstractC1128Qr abstractC1128Qr) {
        StringBuilder sb = new StringBuilder(A07(169, 10, 70));
        boolean equals = abstractC1128Qr.A03().equals(EnumC1127Qq.A06);
        String A072 = A07(41, 1, 33);
        if (equals && abstractC1128Qr.A06() != null) {
            sb.append(A07(7, 5, 55));
            sb.append(new String(abstractC1128Qr.A06(), Charset.forName(A07(117, 5, 53))));
            sb.append(A072);
        }
        Map<String, String> A06 = abstractC1128Qr.A02().A06();
        String[] strArr = A08;
        if (strArr[1].length() != strArr[7].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A08;
        strArr2[3] = "s0c02ga9sXqOOqZgqzjFkG4II3gfLx";
        strArr2[6] = "iECV1gT3x";
        for (Map.Entry<String, String> entry : A06.entrySet()) {
            sb.append(A07(2, 5, 74));
            sb.append(entry.getKey());
            sb.append(A07(66, 1, 118));
            sb.append(entry.getValue());
            sb.append(A072);
        }
        sb.append(A07(0, 2, 109));
        sb.append(abstractC1128Qr.A05());
        sb.append(A072);
        String sb2 = sb.toString();
        A0E(sb2, 1, (sb2.length() / Constants.DEFAULT_STARTUP_THRESHOLD_MS_WARM) + 1);
    }

    private void A0D(AbstractC1128Qr abstractC1128Qr, InterfaceC1117Qg interfaceC1117Qg) {
        this.A05.A5h(this, interfaceC1117Qg, this.A01).A5E(abstractC1128Qr);
        if (this.A03.A04()) {
            A0C(abstractC1128Qr);
        }
    }

    private void A0E(String str, int i2, int i3) {
        String str2 = A09 + A07(12, 6, 114) + i2 + A07(65, 1, 35) + i3;
        if (str.length() > 4000) {
            str.substring(0, Constants.DEFAULT_STARTUP_THRESHOLD_MS_WARM);
            A0E(str.substring(Constants.DEFAULT_STARTUP_THRESHOLD_MS_WARM), i2 + 1, i3);
        }
    }

    private void A0F(String str, String str2, byte[] bArr, InterfaceC1117Qg interfaceC1117Qg, C1124Qn c1124Qn) {
        A0D(new H2(str, null, str2, bArr, c1124Qn), interfaceC1117Qg);
    }

    private void A0G(HttpURLConnection httpURLConnection, AbstractC1128Qr abstractC1128Qr) {
        Map<String, String> A06 = abstractC1128Qr.A02().A06();
        InterfaceC1114Qd A05 = abstractC1128Qr.A02().A05();
        for (String str : A06.keySet()) {
            String name = A06.get(str);
            httpURLConnection.setRequestProperty(str, name);
        }
        if (A05 != null) {
            Map<String, String> A5T = A05.A5T(this.A03.A03());
            for (String str2 : A5T.keySet()) {
                String value = A5T.get(str2);
                httpURLConnection.setRequestProperty(str2, value);
            }
        }
    }

    private final void A0H(HttpURLConnection httpURLConnection, AbstractC1128Qr abstractC1128Qr) throws IOException {
        C1124Qn A02 = abstractC1128Qr.A02();
        httpURLConnection.setConnectTimeout(A02.A00());
        httpURLConnection.setReadTimeout(A02.A02());
        this.A06.AD0(httpURLConnection, abstractC1128Qr.A03(), abstractC1128Qr.A04());
    }

    private final boolean A0I(Throwable th, long j2, AbstractC1128Qr abstractC1128Qr) {
        C1124Qn A02 = abstractC1128Qr.A02();
        long currentTimeMillis = (System.currentTimeMillis() - j2) + 10;
        if (this.A04.A8R()) {
            this.A04.A8h(A07(67, 15, 35) + currentTimeMillis + A07(42, 7, 23) + A02.A00() + A07(49, 7, 109) + A02.A02());
        }
        if (this.A02) {
            return currentTimeMillis >= ((long) A02.A02());
        }
        long A00 = A02.A00();
        if (A08[5].length() != 28) {
            throw new RuntimeException();
        }
        String[] strArr = A08;
        strArr[3] = "UT6xnSlzbr9JaeC9T1uoRQiwoDXC3Y";
        strArr[6] = "g5URFCrsk";
        return currentTimeMillis >= A00;
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.facebook.ads.redexgen.X.InterfaceC1115Qe A0J(com.facebook.ads.redexgen.X.AbstractC1128Qr r31) throws com.facebook.ads.redexgen.X.C1129Qs {
        /*
            Method dump skipped, instructions count: 509
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0877Gr.A0J(com.facebook.ads.redexgen.X.Qr):com.facebook.ads.redexgen.X.Qe");
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1116Qf
    @Nullable
    @Deprecated
    public final InterfaceC1115Qe ACs(String str, Map<String, String> map) {
        return A03(str, new C1130Qt(map), this.A03.A00());
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1116Qf
    @Nullable
    @Deprecated
    public final InterfaceC1115Qe ACt(String str, byte[] bArr) {
        return A04(str, A07(122, 47, 42), bArr, this.A03.A00());
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1116Qf
    public final void ACu(String str, byte[] bArr, InterfaceC1117Qg interfaceC1117Qg) {
        A0F(str, A07(122, 47, 42), bArr, interfaceC1117Qg, this.A03.A00());
    }
}
