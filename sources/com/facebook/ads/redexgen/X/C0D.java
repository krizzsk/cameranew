package com.facebook.ads.redexgen.X;

import java.io.File;
import java.util.Comparator;
/* renamed from: com.facebook.ads.redexgen.X.0D  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C0D implements Comparator<File> {
    public C0D() {
    }

    private int A00(long j2, long j3) {
        if (j2 < j3) {
            return -1;
        }
        return j2 == j3 ? 0 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.Comparator
    /* renamed from: A01 */
    public final int compare(File file, File file2) {
        return A00(file.lastModified(), file2.lastModified());
    }
}
