package com.bumptech.glide.load.model;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* compiled from: StreamEncoder.java */
/* loaded from: classes.dex */
public class n implements com.bumptech.glide.load.a<InputStream> {
    @Override // com.bumptech.glide.load.a
    /* renamed from: b */
    public boolean a(InputStream inputStream, OutputStream outputStream) {
        byte[] b = com.bumptech.glide.l.a.a().b();
        while (true) {
            try {
                int read = inputStream.read(b);
                if (read != -1) {
                    outputStream.write(b, 0, read);
                } else {
                    return true;
                }
            } catch (IOException e2) {
                if (Log.isLoggable("StreamEncoder", 3)) {
                    Log.d("StreamEncoder", "Failed to encode data onto the OutputStream", e2);
                }
                return false;
            } finally {
                com.bumptech.glide.l.a.a().c(b);
            }
        }
    }

    @Override // com.bumptech.glide.load.a
    public String getId() {
        return "";
    }
}
