package com.bumptech.glide.load.h.e;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.i;
import java.util.Objects;
/* compiled from: DrawableResource.java */
/* loaded from: classes.dex */
public abstract class a<T extends Drawable> implements i<T> {
    protected final T a;

    public a(T t) {
        Objects.requireNonNull(t, "Drawable must not be null!");
        this.a = t;
    }

    @Override // com.bumptech.glide.load.engine.i
    /* renamed from: a */
    public final T get() {
        return (T) this.a.getConstantState().newDrawable();
    }
}
