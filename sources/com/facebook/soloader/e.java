package com.facebook.soloader;

import android.content.Context;
import com.facebook.soloader.m;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
/* compiled from: ExoSoSource.java */
/* loaded from: classes.dex */
public final class e extends m {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ExoSoSource.java */
    /* loaded from: classes.dex */
    public final class b extends m.f {
        private final c[] a;

        /* compiled from: ExoSoSource.java */
        /* loaded from: classes.dex */
        private final class a extends m.e {
            private int a;

            private a() {
            }

            @Override // com.facebook.soloader.m.e
            public boolean d() {
                return this.a < b.this.a.length;
            }

            @Override // com.facebook.soloader.m.e
            public m.d t() throws IOException {
                c[] cVarArr = b.this.a;
                int i2 = this.a;
                this.a = i2 + 1;
                c cVar = cVarArr[i2];
                FileInputStream fileInputStream = new FileInputStream(cVar.c);
                try {
                    return new m.d(cVar, fileInputStream);
                } catch (Throwable th) {
                    fileInputStream.close();
                    throw th;
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x00dc, code lost:
            throw new java.lang.RuntimeException("illegal line in exopackage metadata: [" + r10 + "]");
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        b(com.facebook.soloader.e r17, com.facebook.soloader.m r18) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 295
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.e.b.<init>(com.facebook.soloader.e, com.facebook.soloader.m):void");
        }

        @Override // com.facebook.soloader.m.f
        protected m.c d() throws IOException {
            return new m.c(this.a);
        }

        @Override // com.facebook.soloader.m.f
        protected m.e t() throws IOException {
            return new a();
        }
    }

    /* compiled from: ExoSoSource.java */
    /* loaded from: classes.dex */
    private static final class c extends m.b {
        final File c;

        c(String str, String str2, File file) {
            super(str, str2);
            this.c = file;
        }
    }

    public e(Context context, String str) {
        super(context, str);
    }

    @Override // com.facebook.soloader.m
    protected m.f m() throws IOException {
        return new b(this, this);
    }
}
