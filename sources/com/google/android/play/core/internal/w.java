package com.google.android.play.core.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;
import androidx.annotation.Nullable;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes2.dex */
public final class w {
    private final com.google.android.play.core.splitcompat.c a;
    private final Context b;

    public w(Context context, com.google.android.play.core.splitcompat.c cVar, y yVar, byte[] bArr) {
        this.a = cVar;
        this.b = context;
    }

    @Nullable
    private static X509Certificate a(Signature signature) {
        try {
            return (X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(signature.toByteArray()));
        } catch (CertificateException e2) {
            Log.e("SplitCompat", "Cannot decode certificate.", e2);
            return null;
        }
    }

    public final boolean b() {
        Signature[] signatureArr;
        String sb;
        int i2;
        try {
            File i3 = this.a.i();
            ArrayList<X509Certificate> arrayList = null;
            try {
                signatureArr = this.b.getPackageManager().getPackageInfo(this.b.getPackageName(), 64).signatures;
            } catch (PackageManager.NameNotFoundException unused) {
                signatureArr = null;
            }
            if (signatureArr != null) {
                arrayList = new ArrayList();
                for (Signature signature : signatureArr) {
                    X509Certificate a = a(signature);
                    if (a != null) {
                        arrayList.add(a);
                    }
                }
            }
            if (arrayList == null || arrayList.isEmpty()) {
                Log.e("SplitCompat", "No app certificates found.");
                return false;
            }
            File[] listFiles = i3.listFiles();
            Arrays.sort(listFiles);
            int length = listFiles.length;
            loop1: while (true) {
                length--;
                if (length < 0) {
                    return true;
                }
                File file = listFiles[length];
                try {
                    String absolutePath = file.getAbsolutePath();
                    try {
                        X509Certificate[][] m = p1.m(absolutePath);
                        if (m == null || m.length == 0 || m[0].length == 0) {
                            break;
                        } else if (arrayList.isEmpty()) {
                            sb = "No certificates found for app.";
                            break;
                        } else {
                            for (X509Certificate x509Certificate : arrayList) {
                                int length2 = m.length;
                                while (i2 < length2) {
                                    i2 = m[i2][0].equals(x509Certificate) ? 0 : i2 + 1;
                                }
                                Log.i("SplitCompat", "There's an app certificate that doesn't sign the split.");
                            }
                            try {
                                file.renameTo(this.a.a(file));
                            } catch (IOException e2) {
                                Log.e("SplitCompat", "Cannot write verified split.", e2);
                                return false;
                            }
                        }
                    } catch (Exception e3) {
                        StringBuilder sb2 = new StringBuilder(String.valueOf(absolutePath).length() + 32);
                        sb2.append("Downloaded split ");
                        sb2.append(absolutePath);
                        sb2.append(" is not signed.");
                        Log.e("SplitCompat", sb2.toString(), e3);
                    }
                } catch (Exception e4) {
                    Log.e("SplitCompat", "Split verification error.", e4);
                    return false;
                }
            }
            Log.e("SplitCompat", sb);
            Log.e("SplitCompat", "Split verification failure.");
            return false;
        } catch (IOException e5) {
            Log.e("SplitCompat", "Cannot access directory for unverified splits.", e5);
            return false;
        }
    }

    public final boolean c(List<Intent> list) throws IOException {
        for (Intent intent : list) {
            if (!this.a.g(intent.getStringExtra("split_id")).exists()) {
                return false;
            }
        }
        return true;
    }
}
