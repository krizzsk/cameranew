package com.google.android.gms.internal.ads;

import android.util.Base64OutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzrw {
    private ByteArrayOutputStream zzbuh = new ByteArrayOutputStream(4096);
    private Base64OutputStream zzbui = new Base64OutputStream(this.zzbuh, 10);

    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.ByteArrayOutputStream, android.util.Base64OutputStream] */
    public final String toString() {
        try {
            this.zzbui.close();
        } catch (IOException e2) {
            zzazk.zzc("HashManager: Unable to convert to Base64.", e2);
        }
        try {
            this.zzbuh.close();
            return this.zzbuh.toString();
        } catch (IOException e3) {
            zzazk.zzc("HashManager: Unable to convert to Base64.", e3);
            return "";
        } finally {
            this.zzbuh = null;
            this.zzbui = null;
        }
    }

    public final void write(byte[] bArr) throws IOException {
        this.zzbui.write(bArr);
    }
}
