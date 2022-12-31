package com.google.android.play.core.splitcompat;

import android.util.Log;
import com.google.android.play.core.internal.j1;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class h implements j {
    final /* synthetic */ Set a;
    final /* synthetic */ r b;
    final /* synthetic */ ZipFile c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Set set, r rVar, ZipFile zipFile) {
        this.a = set;
        this.b = rVar;
        this.c = zipFile;
    }

    @Override // com.google.android.play.core.splitcompat.j
    public final void a(k kVar, File file, boolean z) throws IOException {
        this.a.add(file);
        if (z) {
            return;
        }
        Log.i("SplitCompat", String.format("NativeLibraryExtractor: split '%s' has native library '%s' that does not exist; extracting from '%s!%s' to '%s'", this.b.b(), kVar.a, this.b.a().getAbsolutePath(), kVar.b.getName(), file.getAbsolutePath()));
        ZipFile zipFile = this.c;
        ZipEntry zipEntry = kVar.b;
        int i2 = l.c;
        byte[] bArr = new byte[4096];
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            while (true) {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            fileOutputStream.close();
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable th2) {
                    j1.a(th, th2);
                }
            }
            throw th;
        }
    }
}
