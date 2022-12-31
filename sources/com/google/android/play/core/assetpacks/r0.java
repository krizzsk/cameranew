package com.google.android.play.core.assetpacks;

import android.os.ParcelFileDescriptor;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class r0 {
    private final com.google.android.play.core.internal.k1<x3> a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r0(com.google.android.play.core.internal.k1<x3> k1Var) {
        this.a = k1Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final InputStream a(int i2, String str, String str2, int i3) {
        try {
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) com.google.android.play.core.tasks.f.e(this.a.a().b(i2, str, str2, i3));
            if (parcelFileDescriptor == null || parcelFileDescriptor.getFileDescriptor() == null) {
                throw new bv(String.format("Corrupted ParcelFileDescriptor, session %s packName %s sliceId %s, chunkNumber %s", Integer.valueOf(i2), str, str2, Integer.valueOf(i3)), i2);
            }
            return new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor);
        } catch (InterruptedException e2) {
            throw new bv("Extractor was interrupted while waiting for chunk file.", e2, i2);
        } catch (ExecutionException e3) {
            throw new bv(String.format("Error opening chunk file, session %s packName %s sliceId %s, chunkNumber %s", Integer.valueOf(i2), str, str2, Integer.valueOf(i3)), e3, i2);
        }
    }
}
