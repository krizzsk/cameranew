package com.bytedance.sdk.a.b.a.g;

import com.bytedance.sdk.a.b.w;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Jdk9Platform.java */
/* loaded from: classes.dex */
public final class b extends e {
    final Method a;
    final Method b;

    b(Method method, Method method2) {
        this.a = method;
        this.b = method2;
    }

    @Override // com.bytedance.sdk.a.b.a.g.e
    public void a(SSLSocket sSLSocket, String str, List<w> list) {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List<String> a = e.a(list);
            this.a.invoke(sSLParameters, a.toArray(new String[a.size()]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw com.bytedance.sdk.a.b.a.c.a("unable to set ssl parameters", (Exception) e2);
        }
    }

    @Override // com.bytedance.sdk.a.b.a.g.e
    public String a(SSLSocket sSLSocket) {
        try {
            String str = (String) this.b.invoke(sSLSocket, new Object[0]);
            if (str != null) {
                if (str.equals("")) {
                    return null;
                }
                return str;
            }
            return null;
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw com.bytedance.sdk.a.b.a.c.a("unable to get selected protocols", (Exception) e2);
        }
    }

    public static b a() {
        try {
            return new b(SSLParameters.class.getMethod("setApplicationProtocols", String[].class), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }
}
