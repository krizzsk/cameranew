package com.facebook.drawee.view;

import android.content.Context;
import android.util.AttributeSet;
import javax.annotation.Nullable;
/* loaded from: classes.dex */
public class GenericDraweeView extends DraweeView<com.facebook.drawee.generic.a> {
    public GenericDraweeView(Context context) {
        super(context);
        k(context, null);
    }

    protected void k(Context context, @Nullable AttributeSet attributeSet) {
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.a("GenericDraweeView#inflateHierarchy");
        }
        com.facebook.drawee.generic.b d2 = com.facebook.drawee.generic.c.d(context, attributeSet);
        setAspectRatio(d2.f());
        setHierarchy(d2.a());
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.b();
        }
    }

    public GenericDraweeView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        k(context, attributeSet);
    }

    public GenericDraweeView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        k(context, attributeSet);
    }
}
