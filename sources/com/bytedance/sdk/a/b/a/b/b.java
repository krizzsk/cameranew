package com.bytedance.sdk.a.b.a.b;

import com.bytedance.sdk.a.b.k;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;
/* compiled from: ConnectionSpecSelector.java */
/* loaded from: classes.dex */
public final class b {
    private final List<k> a;
    private int b = 0;
    private boolean c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f886d;

    public b(List<k> list) {
        this.a = list;
    }

    private boolean b(SSLSocket sSLSocket) {
        for (int i2 = this.b; i2 < this.a.size(); i2++) {
            if (this.a.get(i2).a(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    public k a(SSLSocket sSLSocket) throws IOException {
        k kVar;
        int i2 = this.b;
        int size = this.a.size();
        while (true) {
            if (i2 >= size) {
                kVar = null;
                break;
            }
            kVar = this.a.get(i2);
            if (kVar.a(sSLSocket)) {
                this.b = i2 + 1;
                break;
            }
            i2++;
        }
        if (kVar != null) {
            this.c = b(sSLSocket);
            com.bytedance.sdk.a.b.a.a.a.a(kVar, sSLSocket, this.f886d);
            return kVar;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f886d + ", modes=" + this.a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    public boolean a(IOException iOException) {
        this.f886d = true;
        if (!this.c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z = iOException instanceof SSLHandshakeException;
        if ((z && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return z || (iOException instanceof SSLProtocolException);
    }
}
