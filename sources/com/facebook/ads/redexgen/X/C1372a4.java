package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.pm.Signature;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.a4  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1372a4 implements InterfaceC06426r<Integer> {
    public static byte[] A02;
    public final String A00;
    public final String A01;

    static {
        A03();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 37);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A02 = new byte[]{-38, -80, -73, -78, -69, -77, 113, 12, -53};
    }

    public C1372a4(Signature signature) throws CertificateException, NoSuchAlgorithmException {
        this.A00 = A01(signature, AnonymousClass77.A05);
        this.A01 = A01(signature, AnonymousClass77.A06);
    }

    public static String A01(Signature signature, AnonymousClass77 anonymousClass77) throws NoSuchAlgorithmException, CertificateException {
        InputStream input = new ByteArrayInputStream(signature.toByteArray());
        X509Certificate cert = (X509Certificate) CertificateFactory.getInstance(A00(0, 5, 93)).generateCertificate(input);
        return AnonymousClass78.A08(cert.getEncoded(), anonymousClass77);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.InterfaceC06426r
    /* renamed from: A02 */
    public final JSONObject AEz(Integer num, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(A00(5, 2, 27), this.A00);
        jSONObject2.put(A00(7, 2, 116), this.A01);
        jSONObject.put(Integer.toString(num.intValue()), jSONObject2);
        return jSONObject;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06426r
    public final boolean A8K(Object obj) {
        String str;
        C1372a4 c1372a4 = (C1372a4) obj;
        String str2 = this.A00;
        return str2 != null && str2.equals(c1372a4.A00) && (str = this.A01) != null && str.equals(c1372a4.A01);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06426r
    @SuppressLint({"BadMethodUse-java.lang.String.length"})
    public final int AEd() {
        String str = this.A01;
        int length = str != null ? str.length() : 0;
        String str2 = this.A00;
        return length + (str2 != null ? str2.length() : 0);
    }
}
