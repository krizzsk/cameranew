package com.bytedance.sdk.a.b.a.e;

import java.io.IOException;
/* compiled from: StreamResetException.java */
/* loaded from: classes.dex */
public final class o extends IOException {
    public final b a;

    public o(b bVar) {
        super("stream was reset: " + bVar);
        this.a = bVar;
    }
}
