package com.facebook.ads.redexgen.X;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public abstract class HT implements InterfaceC1131Qu {
    public static byte[] A01;
    public static String[] A02 = {"rzjVC70O4bd9DzHjbWZgWXgUSmVLYSU4", "d5zo8W4K", "Hv98ROwnq0amXTKQof8zpMynpU6nXYzw", "m02wtPmJvn7xvEVIhgILVdsvYaekd1y1", "NwXA6aDXoJPzKJxJycW", "lujFiBBwg3lGF", "5iNla1hEs57TMoL8Mlh58N0Q757SBHKY", "iek06qmxI9TIJY"};
    public final InterfaceC1132Qv A00;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 14);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{89, 123, 123, 125, -120, -116, 69, 91, Byte.MIN_VALUE, 121, -118, -117, 125, -116, -98, -67, -49, -59, -65, -82, -63, -51, -47, -63, -49, -48, -92, -67, -54, -64, -56, -63, -50, -118, -53, -54, -95, -50, -50, -53, -50, 124, -61, -53, -48, -102, -58, -59, -53, -68, -59, -53, -124, -85, -48, -57, -68, -71, -72, -86, -111, -100};
    }

    static {
        A01();
    }

    public HT() {
        this(new C0876Gq());
    }

    public HT(InterfaceC1132Qv interfaceC1132Qv) {
        this.A00 = interfaceC1132Qv;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1131Qu
    public final boolean AAY(C1129Qs c1129Qs) {
        InterfaceC1115Qe A00 = c1129Qs.A00();
        if (this.A00.A8R()) {
            this.A00.A8h(A00(14, 31, 78));
            c1129Qs.printStackTrace();
        }
        if (A00 != null && A00.A7U() > 0) {
            return true;
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1131Qu
    public final HttpURLConnection ACi(String str, Proxy proxy) throws IOException {
        return (HttpURLConnection) new URL(str).openConnection(proxy);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1131Qu
    public final InputStream ACj(HttpURLConnection httpURLConnection) throws IOException {
        return httpURLConnection.getInputStream();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1131Qu
    public final OutputStream ACk(HttpURLConnection httpURLConnection) throws IOException {
        return httpURLConnection.getOutputStream();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1131Qu
    public final void AD0(HttpURLConnection httpURLConnection, EnumC1127Qq enumC1127Qq, String str) throws IOException {
        httpURLConnection.setRequestMethod(enumC1127Qq.A02());
        httpURLConnection.setDoOutput(enumC1127Qq.A04());
        httpURLConnection.setDoInput(enumC1127Qq.A03());
        if (str != null) {
            httpURLConnection.setRequestProperty(A00(45, 12, 73), str);
        }
        httpURLConnection.setRequestProperty(A00(0, 14, 10), A00(57, 5, 86));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1131Qu
    public final byte[] ADK(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[16384];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            } else if (A02[4].length() != 19) {
                throw new RuntimeException();
            } else {
                String[] strArr = A02;
                strArr[2] = "eO7qbggyddGiOQuVn8N8jDULGwym82oB";
                strArr[6] = "iN6CFd4LV6hdOWp44ZZbGtT2nODAuDvC";
                byteArrayOutputStream.write(bArr, 0, read);
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1131Qu
    public final void AFX(OutputStream outputStream, byte[] bArr) throws IOException {
        outputStream.write(bArr);
    }
}
