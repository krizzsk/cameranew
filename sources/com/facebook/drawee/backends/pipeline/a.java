package com.facebook.drawee.backends.pipeline;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.i;
import javax.annotation.Nullable;
/* compiled from: DefaultDrawableFactory.java */
/* loaded from: classes.dex */
public class a implements com.facebook.imagepipeline.c.a {
    private final Resources a;
    @Nullable
    private final com.facebook.imagepipeline.c.a b;

    public a(Resources resources, @Nullable com.facebook.imagepipeline.c.a aVar) {
        this.a = resources;
        this.b = aVar;
    }

    private static boolean c(com.facebook.imagepipeline.image.d dVar) {
        return (dVar.Q() == 1 || dVar.Q() == 0) ? false : true;
    }

    private static boolean d(com.facebook.imagepipeline.image.d dVar) {
        return (dVar.R() == 0 || dVar.R() == -1) ? false : true;
    }

    @Override // com.facebook.imagepipeline.c.a
    public boolean a(com.facebook.imagepipeline.image.c cVar) {
        return true;
    }

    @Override // com.facebook.imagepipeline.c.a
    @Nullable
    public Drawable b(com.facebook.imagepipeline.image.c cVar) {
        try {
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.a("DefaultDrawableFactory#createDrawable");
            }
            if (cVar instanceof com.facebook.imagepipeline.image.d) {
                com.facebook.imagepipeline.image.d dVar = (com.facebook.imagepipeline.image.d) cVar;
                BitmapDrawable bitmapDrawable = new BitmapDrawable(this.a, dVar.y());
                if (d(dVar) || c(dVar)) {
                    i iVar = new i(bitmapDrawable, dVar.R(), dVar.Q());
                    if (com.facebook.imagepipeline.f.b.d()) {
                        com.facebook.imagepipeline.f.b.b();
                    }
                    return iVar;
                }
                return bitmapDrawable;
            }
            com.facebook.imagepipeline.c.a aVar = this.b;
            if (aVar != null && aVar.a(cVar)) {
                Drawable b = this.b.b(cVar);
                if (com.facebook.imagepipeline.f.b.d()) {
                    com.facebook.imagepipeline.f.b.b();
                }
                return b;
            }
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.b();
            }
            return null;
        } finally {
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.b();
            }
        }
    }
}
