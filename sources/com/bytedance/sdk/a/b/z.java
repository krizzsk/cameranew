package com.bytedance.sdk.a.b;

import java.io.IOException;
import java.util.Objects;
/* compiled from: RequestBody.java */
/* loaded from: classes.dex */
public abstract class z {
    public static z a(u uVar, byte[] bArr) {
        return a(uVar, bArr, 0, bArr.length);
    }

    public abstract u a();

    public abstract void a(com.bytedance.sdk.a.a.d dVar) throws IOException;

    public long b() throws IOException {
        return -1L;
    }

    public static z a(final u uVar, final byte[] bArr, final int i2, final int i3) {
        Objects.requireNonNull(bArr, "content == null");
        com.bytedance.sdk.a.b.a.c.a(bArr.length, i2, i3);
        return new z() { // from class: com.bytedance.sdk.a.b.z.1
            @Override // com.bytedance.sdk.a.b.z
            public u a() {
                return u.this;
            }

            @Override // com.bytedance.sdk.a.b.z
            public long b() {
                return i3;
            }

            @Override // com.bytedance.sdk.a.b.z
            public void a(com.bytedance.sdk.a.a.d dVar) throws IOException {
                dVar.c(bArr, i2, i3);
            }
        };
    }
}
