package com.google.android.material.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class ViewOverlayApi14 implements o {
    protected OverlayViewGroup a;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"ViewConstructor", "PrivateApi"})
    /* loaded from: classes2.dex */
    public static class OverlayViewGroup extends ViewGroup {
        ViewGroup a;
        View b;
        ArrayList<Drawable> c;

        /* renamed from: d  reason: collision with root package name */
        ViewOverlayApi14 f4357d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f4358e;

        static {
            try {
                Class cls = Integer.TYPE;
                ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", cls, cls, Rect.class);
            } catch (NoSuchMethodException unused) {
            }
        }

        OverlayViewGroup(Context context, ViewGroup viewGroup, View view, ViewOverlayApi14 viewOverlayApi14) {
            super(context);
            this.c = null;
            this.a = viewGroup;
            this.b = view;
            setRight(viewGroup.getWidth());
            setBottom(viewGroup.getHeight());
            viewGroup.addView(this);
            this.f4357d = viewOverlayApi14;
        }

        private void b() {
            if (this.f4358e) {
                throw new IllegalStateException("This overlay was disposed already. Please use a new one via ViewGroupUtils.getOverlay()");
            }
        }

        private void c() {
            if (getChildCount() == 0) {
                ArrayList<Drawable> arrayList = this.c;
                if (arrayList == null || arrayList.size() == 0) {
                    this.f4358e = true;
                    this.a.removeView(this);
                }
            }
        }

        private void d(int[] iArr) {
            int[] iArr2 = new int[2];
            int[] iArr3 = new int[2];
            this.a.getLocationOnScreen(iArr2);
            this.b.getLocationOnScreen(iArr3);
            iArr[0] = iArr3[0] - iArr2[0];
            iArr[1] = iArr3[1] - iArr2[1];
        }

        public void a(Drawable drawable) {
            b();
            if (this.c == null) {
                this.c = new ArrayList<>();
            }
            if (this.c.contains(drawable)) {
                return;
            }
            this.c.add(drawable);
            invalidate(drawable.getBounds());
            drawable.setCallback(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            this.a.getLocationOnScreen(iArr);
            this.b.getLocationOnScreen(iArr2);
            canvas.translate(iArr2[0] - iArr[0], iArr2[1] - iArr[1]);
            canvas.clipRect(new Rect(0, 0, this.b.getWidth(), this.b.getHeight()));
            super.dispatchDraw(canvas);
            ArrayList<Drawable> arrayList = this.c;
            int size = arrayList == null ? 0 : arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.c.get(i2).draw(canvas);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        public void e(Drawable drawable) {
            ArrayList<Drawable> arrayList = this.c;
            if (arrayList != null) {
                arrayList.remove(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback(null);
                c();
            }
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
            if (this.a != null) {
                rect.offset(iArr[0], iArr[1]);
                if (this.a != null) {
                    iArr[0] = 0;
                    iArr[1] = 0;
                    int[] iArr2 = new int[2];
                    d(iArr2);
                    rect.offset(iArr2[0], iArr2[1]);
                    return super.invalidateChildInParent(iArr, rect);
                }
                invalidate(rect);
                return null;
            }
            return null;
        }

        @Override // android.view.View, android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(@NonNull Drawable drawable) {
            invalidate(drawable.getBounds());
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        }

        @Override // android.view.View
        protected boolean verifyDrawable(@NonNull Drawable drawable) {
            ArrayList<Drawable> arrayList;
            return super.verifyDrawable(drawable) || ((arrayList = this.c) != null && arrayList.contains(drawable));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOverlayApi14(Context context, ViewGroup viewGroup, View view) {
        this.a = new OverlayViewGroup(context, viewGroup, view, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ViewOverlayApi14 a(View view) {
        ViewGroup d2 = p.d(view);
        if (d2 != null) {
            int childCount = d2.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = d2.getChildAt(i2);
                if (childAt instanceof OverlayViewGroup) {
                    return ((OverlayViewGroup) childAt).f4357d;
                }
            }
            return new m(d2.getContext(), d2, view);
        }
        return null;
    }

    @Override // com.google.android.material.internal.o
    public void add(@NonNull Drawable drawable) {
        this.a.a(drawable);
    }

    @Override // com.google.android.material.internal.o
    public void remove(@NonNull Drawable drawable) {
        this.a.e(drawable);
    }
}
