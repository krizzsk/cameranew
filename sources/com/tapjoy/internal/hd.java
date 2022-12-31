package com.tapjoy.internal;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public final class hd {
    private final File a;

    public hd(File file) {
        this.a = file;
    }

    public final synchronized boolean a() {
        if (b() != null) {
            return false;
        }
        try {
            File file = this.a;
            String uuid = UUID.randomUUID().toString();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                bg.a(fileOutputStream, uuid);
                return b() != null;
            } finally {
                jz.a(fileOutputStream);
            }
        } catch (IOException e2) {
            try {
                this.a.delete();
                throw e2;
            } catch (IOException unused) {
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final String b() {
        if (this.a.exists()) {
            try {
                String a = bg.a(this.a, ak.c);
                if (a.length() > 0) {
                    return a;
                }
                return null;
            } catch (IOException unused) {
                return null;
            }
        }
        return null;
    }
}
