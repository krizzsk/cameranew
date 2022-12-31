package com.facebook.drawee.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.facebook.common.internal.g;
import com.facebook.drawee.b.b;
import com.facebook.drawee.view.a;
import javax.annotation.Nullable;
/* loaded from: classes.dex */
public class DraweeView<DH extends com.facebook.drawee.b.b> extends ImageView {

    /* renamed from: f  reason: collision with root package name */
    private static boolean f2604f = false;
    private final a.C0095a a;
    private float b;
    private b<DH> c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f2605d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f2606e;

    public DraweeView(Context context) {
        super(context);
        this.a = new a.C0095a();
        this.b = 0.0f;
        this.f2605d = false;
        this.f2606e = false;
        g(context);
    }

    private void g(Context context) {
        boolean d2;
        try {
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.a("DraweeView#init");
            }
            if (this.f2605d) {
                if (d2) {
                    return;
                }
                return;
            }
            boolean z = true;
            this.f2605d = true;
            this.c = b.d(null, context);
            if (Build.VERSION.SDK_INT >= 21) {
                ColorStateList imageTintList = getImageTintList();
                if (imageTintList == null) {
                    if (com.facebook.imagepipeline.f.b.d()) {
                        com.facebook.imagepipeline.f.b.b();
                        return;
                    }
                    return;
                }
                setColorFilter(imageTintList.getDefaultColor());
            }
            if (!f2604f || context.getApplicationInfo().targetSdkVersion < 24) {
                z = false;
            }
            this.f2606e = z;
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.b();
            }
        } finally {
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.b();
            }
        }
    }

    private void h() {
        Drawable drawable;
        if (!this.f2606e || (drawable = getDrawable()) == null) {
            return;
        }
        drawable.setVisible(getVisibility() == 0, false);
    }

    public static void setGlobalLegacyVisibilityHandlingEnabled(boolean z) {
        f2604f = z;
    }

    protected void b() {
        this.c.j();
    }

    protected void c() {
        this.c.k();
    }

    @Nullable
    public com.facebook.drawee.b.a d() {
        return this.c.f();
    }

    public DH e() {
        return this.c.g();
    }

    @Nullable
    public Drawable f() {
        return this.c.h();
    }

    protected void i() {
        b();
    }

    protected void j() {
        c();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h();
        i();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h();
        j();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        h();
        i();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i3) {
        a.C0095a c0095a = this.a;
        c0095a.a = i2;
        c0095a.b = i3;
        a.b(c0095a, this.b, getLayoutParams(), getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom());
        a.C0095a c0095a2 = this.a;
        super.onMeasure(c0095a2.a, c0095a2.b);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        h();
        j();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.c.l(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i2) {
        super.onVisibilityChanged(view, i2);
        h();
    }

    public void setAspectRatio(float f2) {
        if (f2 == this.b) {
            return;
        }
        this.b = f2;
        requestLayout();
    }

    public void setController(@Nullable com.facebook.drawee.b.a aVar) {
        this.c.n(aVar);
        super.setImageDrawable(this.c.h());
    }

    public void setHierarchy(DH dh) {
        this.c.o(dh);
        super.setImageDrawable(this.c.h());
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageBitmap(Bitmap bitmap) {
        g(getContext());
        this.c.n(null);
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageDrawable(@Nullable Drawable drawable) {
        g(getContext());
        this.c.n(null);
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageResource(int i2) {
        g(getContext());
        this.c.n(null);
        super.setImageResource(i2);
    }

    @Override // android.widget.ImageView
    @Deprecated
    public void setImageURI(Uri uri) {
        g(getContext());
        this.c.n(null);
        super.setImageURI(uri);
    }

    public void setLegacyVisibilityHandlingEnabled(boolean z) {
        this.f2606e = z;
    }

    @Override // android.view.View
    public String toString() {
        g.b c = g.c(this);
        b<DH> bVar = this.c;
        c.b("holder", bVar != null ? bVar.toString() : "<no holder set>");
        return c.toString();
    }

    public DraweeView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new a.C0095a();
        this.b = 0.0f;
        this.f2605d = false;
        this.f2606e = false;
        g(context);
    }

    public DraweeView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = new a.C0095a();
        this.b = 0.0f;
        this.f2605d = false;
        this.f2606e = false;
        g(context);
    }
}
