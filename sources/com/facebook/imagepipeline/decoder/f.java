package com.facebook.imagepipeline.decoder;

import com.facebook.imagepipeline.image.h;
import com.facebook.imagepipeline.image.i;
import java.util.Collections;
import java.util.List;
/* compiled from: SimpleProgressiveJpegConfig.java */
/* loaded from: classes.dex */
public class f implements d {
    private final c a;

    /* compiled from: SimpleProgressiveJpegConfig.java */
    /* loaded from: classes.dex */
    private static class b implements c {
        private b() {
        }

        @Override // com.facebook.imagepipeline.decoder.f.c
        public List<Integer> a() {
            return Collections.EMPTY_LIST;
        }

        @Override // com.facebook.imagepipeline.decoder.f.c
        public int b() {
            return 0;
        }
    }

    /* compiled from: SimpleProgressiveJpegConfig.java */
    /* loaded from: classes.dex */
    public interface c {
        List<Integer> a();

        int b();
    }

    public f() {
        this(new b());
    }

    @Override // com.facebook.imagepipeline.decoder.d
    public int a(int i2) {
        List<Integer> a2 = this.a.a();
        if (a2 == null || a2.isEmpty()) {
            return i2 + 1;
        }
        for (int i3 = 0; i3 < a2.size(); i3++) {
            if (a2.get(i3).intValue() > i2) {
                return a2.get(i3).intValue();
            }
        }
        return Integer.MAX_VALUE;
    }

    @Override // com.facebook.imagepipeline.decoder.d
    public i b(int i2) {
        return h.d(i2, i2 >= this.a.b(), false);
    }

    public f(c cVar) {
        com.facebook.common.internal.h.g(cVar);
        this.a = cVar;
    }
}
