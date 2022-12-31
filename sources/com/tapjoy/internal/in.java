package com.tapjoy.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
/* loaded from: classes3.dex */
public final class in extends View {
    public boolean a;
    private Bitmap b;
    private Rect c;

    /* renamed from: d  reason: collision with root package name */
    private Rect f7713d;

    /* renamed from: e  reason: collision with root package name */
    private Rect f7714e;

    /* renamed from: f  reason: collision with root package name */
    private Rect f7715f;

    public in(Context context) {
        super(context);
        this.a = false;
        this.b = null;
        this.c = null;
        this.f7713d = null;
        this.f7714e = null;
        this.f7715f = new Rect();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        if (this.a) {
            this.f7714e = this.c;
        } else {
            this.f7714e = this.f7713d;
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        if (this.f7714e == null || this.b == null) {
            return;
        }
        getDrawingRect(this.f7715f);
        canvas.drawBitmap(this.b, this.f7714e, this.f7715f, (Paint) null);
    }

    public final void setImageBitmap(Bitmap bitmap) {
        this.b = bitmap;
        int width = bitmap.getWidth();
        int height = this.b.getHeight();
        int i2 = width / 2;
        this.f7713d = new Rect(0, 0, i2, height);
        this.c = new Rect(i2, 0, width, height);
        a();
    }
}
