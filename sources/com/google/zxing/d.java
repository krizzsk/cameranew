package com.google.zxing;

import com.growingio.android.sdk.collection.Constants;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
/* compiled from: LuminanceSource.java */
/* loaded from: classes2.dex */
public abstract class d {
    private final int a;
    private final int b;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(int i2, int i3) {
        this.a = i2;
        this.b = i3;
    }

    public final int a() {
        return this.b;
    }

    public abstract byte[] b();

    public abstract byte[] c(int i2, byte[] bArr);

    public final int d() {
        return this.a;
    }

    public final String toString() {
        int i2 = this.a;
        byte[] bArr = new byte[i2];
        StringBuilder sb = new StringBuilder(this.b * (i2 + 1));
        for (int i3 = 0; i3 < this.b; i3++) {
            bArr = c(i3, bArr);
            for (int i4 = 0; i4 < this.a; i4++) {
                int i5 = bArr[i4] & Draft_75.END_OF_FRAME;
                sb.append(i5 < 64 ? Constants.ID_PREFIX : i5 < 128 ? '+' : i5 < 192 ? '.' : ' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
