package com.bytedance.sdk.a.b;

import java.io.IOException;
/* compiled from: Protocol.java */
/* loaded from: classes.dex */
public enum w {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2");
    

    /* renamed from: e  reason: collision with root package name */
    private final String f1149e;

    w(String str) {
        this.f1149e = str;
    }

    public static w a(String str) throws IOException {
        w wVar = HTTP_1_0;
        if (str.equals(wVar.f1149e)) {
            return wVar;
        }
        w wVar2 = HTTP_1_1;
        if (str.equals(wVar2.f1149e)) {
            return wVar2;
        }
        w wVar3 = HTTP_2;
        if (str.equals(wVar3.f1149e)) {
            return wVar3;
        }
        w wVar4 = SPDY_3;
        if (str.equals(wVar4.f1149e)) {
            return wVar4;
        }
        throw new IOException("Unexpected protocol: " + str);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f1149e;
    }
}
