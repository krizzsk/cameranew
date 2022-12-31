package com.bumptech.glide.load.model;

import android.os.ParcelFileDescriptor;
import java.io.InputStream;
import java.util.Objects;
/* compiled from: ImageVideoModelLoader.java */
/* loaded from: classes.dex */
public class e<A> implements k<A, f> {
    private final k<A, InputStream> a;
    private final k<A, ParcelFileDescriptor> b;

    /* compiled from: ImageVideoModelLoader.java */
    /* loaded from: classes.dex */
    static class a implements com.bumptech.glide.load.g.c<f> {
        private final com.bumptech.glide.load.g.c<InputStream> a;
        private final com.bumptech.glide.load.g.c<ParcelFileDescriptor> b;

        public a(com.bumptech.glide.load.g.c<InputStream> cVar, com.bumptech.glide.load.g.c<ParcelFileDescriptor> cVar2) {
            this.a = cVar;
            this.b = cVar2;
        }

        @Override // com.bumptech.glide.load.g.c
        public void a() {
            com.bumptech.glide.load.g.c<InputStream> cVar = this.a;
            if (cVar != null) {
                cVar.a();
            }
            com.bumptech.glide.load.g.c<ParcelFileDescriptor> cVar2 = this.b;
            if (cVar2 != null) {
                cVar2.a();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x0026 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // com.bumptech.glide.load.g.c
        /* renamed from: c */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public com.bumptech.glide.load.model.f b(com.bumptech.glide.Priority r6) throws java.lang.Exception {
            /*
                r5 = this;
                com.bumptech.glide.load.g.c<java.io.InputStream> r0 = r5.a
                r1 = 2
                r2 = 0
                java.lang.String r3 = "IVML"
                if (r0 == 0) goto L21
                java.lang.Object r0 = r0.b(r6)     // Catch: java.lang.Exception -> Lf
                java.io.InputStream r0 = (java.io.InputStream) r0     // Catch: java.lang.Exception -> Lf
                goto L22
            Lf:
                r0 = move-exception
                boolean r4 = android.util.Log.isLoggable(r3, r1)
                if (r4 == 0) goto L1b
                java.lang.String r4 = "Exception fetching input stream, trying ParcelFileDescriptor"
                android.util.Log.v(r3, r4, r0)
            L1b:
                com.bumptech.glide.load.g.c<android.os.ParcelFileDescriptor> r4 = r5.b
                if (r4 == 0) goto L20
                goto L21
            L20:
                throw r0
            L21:
                r0 = r2
            L22:
                com.bumptech.glide.load.g.c<android.os.ParcelFileDescriptor> r4 = r5.b
                if (r4 == 0) goto L3e
                java.lang.Object r6 = r4.b(r6)     // Catch: java.lang.Exception -> L2e
                android.os.ParcelFileDescriptor r6 = (android.os.ParcelFileDescriptor) r6     // Catch: java.lang.Exception -> L2e
                r2 = r6
                goto L3e
            L2e:
                r6 = move-exception
                boolean r1 = android.util.Log.isLoggable(r3, r1)
                if (r1 == 0) goto L3a
                java.lang.String r1 = "Exception fetching ParcelFileDescriptor"
                android.util.Log.v(r3, r1, r6)
            L3a:
                if (r0 == 0) goto L3d
                goto L3e
            L3d:
                throw r6
            L3e:
                com.bumptech.glide.load.model.f r6 = new com.bumptech.glide.load.model.f
                r6.<init>(r0, r2)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.model.e.a.b(com.bumptech.glide.Priority):com.bumptech.glide.load.model.f");
        }

        @Override // com.bumptech.glide.load.g.c
        public void cancel() {
            com.bumptech.glide.load.g.c<InputStream> cVar = this.a;
            if (cVar != null) {
                cVar.cancel();
            }
            com.bumptech.glide.load.g.c<ParcelFileDescriptor> cVar2 = this.b;
            if (cVar2 != null) {
                cVar2.cancel();
            }
        }

        @Override // com.bumptech.glide.load.g.c
        public String getId() {
            com.bumptech.glide.load.g.c<InputStream> cVar = this.a;
            if (cVar != null) {
                return cVar.getId();
            }
            return this.b.getId();
        }
    }

    public e(k<A, InputStream> kVar, k<A, ParcelFileDescriptor> kVar2) {
        if (kVar == null) {
            Objects.requireNonNull(kVar2, "At least one of streamLoader and fileDescriptorLoader must be non null");
        }
        this.a = kVar;
        this.b = kVar2;
    }

    @Override // com.bumptech.glide.load.model.k
    public com.bumptech.glide.load.g.c<f> a(A a2, int i2, int i3) {
        k<A, InputStream> kVar = this.a;
        com.bumptech.glide.load.g.c<InputStream> a3 = kVar != null ? kVar.a(a2, i2, i3) : null;
        k<A, ParcelFileDescriptor> kVar2 = this.b;
        com.bumptech.glide.load.g.c<ParcelFileDescriptor> a4 = kVar2 != null ? kVar2.a(a2, i2, i3) : null;
        if (a3 == null && a4 == null) {
            return null;
        }
        return new a(a3, a4);
    }
}
