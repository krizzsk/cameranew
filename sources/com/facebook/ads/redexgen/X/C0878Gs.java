package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
/* renamed from: com.facebook.ads.redexgen.X.Gs  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0878Gs implements InterfaceC1115Qe {
    public int A00;
    @Nullable
    public String A01;
    @Nullable
    public Map<String, List<String>> A02;
    @Nullable
    public byte[] A03;

    public C0878Gs(HttpURLConnection httpURLConnection, @Nullable byte[] bArr) {
        try {
            this.A00 = httpURLConnection.getResponseCode();
            this.A01 = httpURLConnection.getURL().toString();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        this.A02 = httpURLConnection.getHeaderFields();
        this.A03 = bArr;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1115Qe
    @Nullable
    public final byte[] A5l() {
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1115Qe
    @Nullable
    public final String A5m() {
        byte[] bArr = this.A03;
        if (bArr != null) {
            return new String(bArr);
        }
        return null;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1115Qe
    @Nullable
    public final Map<String, List<String>> A6g() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1115Qe
    public final int A7U() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1115Qe
    @Nullable
    public final String getUrl() {
        return this.A01;
    }
}
