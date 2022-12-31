package com.facebook.imagepipeline.a;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* compiled from: BaseBitmapDataSubscriber.java */
/* loaded from: classes.dex */
public abstract class b extends com.facebook.datasource.a<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> {
    @Override // com.facebook.datasource.a
    public void f(com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> bVar) {
        if (bVar.b()) {
            com.facebook.common.references.a<com.facebook.imagepipeline.image.c> result = bVar.getResult();
            Bitmap bitmap = null;
            if (result != null && (result.A() instanceof com.facebook.imagepipeline.image.b)) {
                bitmap = ((com.facebook.imagepipeline.image.b) result.A()).y();
            }
            try {
                g(bitmap);
            } finally {
                com.facebook.common.references.a.y(result);
            }
        }
    }

    protected abstract void g(@Nullable Bitmap bitmap);
}
