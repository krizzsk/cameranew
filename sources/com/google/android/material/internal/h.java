package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.lang.ref.WeakReference;
/* compiled from: TextDrawableHelper.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class h {
    private float c;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private com.google.android.material.f.d f4381f;
    private final TextPaint a = new TextPaint(1);
    private final com.google.android.material.f.f b = new a();

    /* renamed from: d  reason: collision with root package name */
    private boolean f4379d = true;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private WeakReference<b> f4380e = new WeakReference<>(null);

    /* compiled from: TextDrawableHelper.java */
    /* loaded from: classes2.dex */
    class a extends com.google.android.material.f.f {
        a() {
        }

        @Override // com.google.android.material.f.f
        public void a(int i2) {
            h.this.f4379d = true;
            b bVar = (b) h.this.f4380e.get();
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // com.google.android.material.f.f
        public void b(@NonNull Typeface typeface, boolean z) {
            if (z) {
                return;
            }
            h.this.f4379d = true;
            b bVar = (b) h.this.f4380e.get();
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    /* compiled from: TextDrawableHelper.java */
    /* loaded from: classes2.dex */
    public interface b {
        void a();

        @NonNull
        int[] getState();

        boolean onStateChange(int[] iArr);
    }

    public h(@Nullable b bVar) {
        g(bVar);
    }

    private float c(@Nullable CharSequence charSequence) {
        if (charSequence == null) {
            return 0.0f;
        }
        return this.a.measureText(charSequence, 0, charSequence.length());
    }

    @Nullable
    public com.google.android.material.f.d d() {
        return this.f4381f;
    }

    @NonNull
    public TextPaint e() {
        return this.a;
    }

    public float f(String str) {
        if (!this.f4379d) {
            return this.c;
        }
        float c = c(str);
        this.c = c;
        this.f4379d = false;
        return c;
    }

    public void g(@Nullable b bVar) {
        this.f4380e = new WeakReference<>(bVar);
    }

    public void h(@Nullable com.google.android.material.f.d dVar, Context context) {
        if (this.f4381f != dVar) {
            this.f4381f = dVar;
            if (dVar != null) {
                dVar.k(context, this.a, this.b);
                b bVar = this.f4380e.get();
                if (bVar != null) {
                    this.a.drawableState = bVar.getState();
                }
                dVar.j(context, this.a, this.b);
                this.f4379d = true;
            }
            b bVar2 = this.f4380e.get();
            if (bVar2 != null) {
                bVar2.a();
                bVar2.onStateChange(bVar2.getState());
            }
        }
    }

    public void i(boolean z) {
        this.f4379d = z;
    }

    public void j(Context context) {
        this.f4381f.j(context, this.a, this.b);
    }
}
