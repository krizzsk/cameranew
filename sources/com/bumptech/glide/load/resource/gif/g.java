package com.bumptech.glide.load.resource.gif;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.model.k;
/* compiled from: GifFrameModelLoader.java */
/* loaded from: classes.dex */
class g implements k<com.bumptech.glide.h.a, com.bumptech.glide.h.a> {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GifFrameModelLoader.java */
    /* loaded from: classes.dex */
    public static class a implements com.bumptech.glide.load.g.c<com.bumptech.glide.h.a> {
        private final com.bumptech.glide.h.a a;

        public a(com.bumptech.glide.h.a aVar) {
            this.a = aVar;
        }

        @Override // com.bumptech.glide.load.g.c
        public void a() {
        }

        @Override // com.bumptech.glide.load.g.c
        /* renamed from: c */
        public com.bumptech.glide.h.a b(Priority priority) {
            return this.a;
        }

        @Override // com.bumptech.glide.load.g.c
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.g.c
        public String getId() {
            return String.valueOf(this.a.d());
        }
    }

    @Override // com.bumptech.glide.load.model.k
    /* renamed from: b */
    public com.bumptech.glide.load.g.c<com.bumptech.glide.h.a> a(com.bumptech.glide.h.a aVar, int i2, int i3) {
        return new a(aVar);
    }
}
