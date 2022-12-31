package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.HashMap;
/* renamed from: com.facebook.ads.redexgen.X.aG  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1384aG implements InterfaceC06356k {
    public final /* synthetic */ C1371a3 A00;

    public C1384aG(C1371a3 c1371a3) {
        this.A00 = c1371a3;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() throws CertificateException, PackageManager.NameNotFoundException, NoSuchAlgorithmException {
        Context context;
        Context context2;
        AbstractC06506z A05;
        context = this.A00.A00;
        PackageManager packageManager = context.getPackageManager();
        context2 = this.A00.A00;
        Signature[] signatureArr = packageManager.getPackageInfo(context2.getPackageName(), 64).signatures;
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < signatureArr.length; i2++) {
            hashMap.put(Integer.valueOf(i2), new C1372a4(signatureArr[i2]));
        }
        A05 = this.A00.A05(hashMap);
        return A05;
    }
}
