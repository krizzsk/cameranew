package com.facebook.ads.redexgen.X;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
/* renamed from: com.facebook.ads.redexgen.X.Qu  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public interface InterfaceC1131Qu {
    boolean AAY(C1129Qs c1129Qs);

    HttpURLConnection ACi(String str, Proxy proxy) throws IOException;

    InputStream ACj(HttpURLConnection httpURLConnection) throws IOException;

    OutputStream ACk(HttpURLConnection httpURLConnection) throws IOException;

    void AD0(HttpURLConnection httpURLConnection, EnumC1127Qq enumC1127Qq, String str) throws IOException;

    byte[] ADK(InputStream inputStream) throws IOException;

    void AFX(OutputStream outputStream, byte[] bArr) throws IOException;
}
