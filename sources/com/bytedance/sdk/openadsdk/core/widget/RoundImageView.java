package com.bytedance.sdk.openadsdk.core.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes.dex */
public class RoundImageView extends ImageView {
    private int a;
    private int b;

    public RoundImageView(Context context) {
        super(context);
        this.a = 0;
        this.b = 0;
    }

    private Bitmap a(Bitmap bitmap, int i2) {
        Bitmap createBitmap;
        int i3 = i2 * 2;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (height > width) {
            createBitmap = Bitmap.createBitmap(bitmap, 0, (height - width) / 2, width, width);
        } else {
            createBitmap = height < width ? Bitmap.createBitmap(bitmap, (width - height) / 2, 0, height, height) : null;
        }
        if (createBitmap != null) {
            bitmap = createBitmap;
        }
        if (bitmap.getWidth() != i3 || bitmap.getHeight() != i3) {
            bitmap = Bitmap.createScaledBitmap(bitmap, i3, i3, true);
        }
        Bitmap createBitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap2);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawCircle(bitmap.getWidth() / 2, bitmap.getHeight() / 2, bitmap.getWidth() / 2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return createBitmap2;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Bitmap bitmap2;
        int i2;
        Bitmap bitmap3;
        Drawable drawable = getDrawable();
        if (drawable == null || getWidth() == 0 || getHeight() == 0) {
            return;
        }
        measure(0, 0);
        if (drawable.getClass() == NinePatchDrawable.class || (bitmap = ((BitmapDrawable) drawable).getBitmap()) == null) {
            return;
        }
        try {
            bitmap2 = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        } catch (Throwable unused) {
            bitmap2 = null;
        }
        if (bitmap2 == null) {
            super.onDraw(canvas);
            return;
        }
        if (this.a == 0) {
            this.a = getWidth();
        }
        if (this.b == 0) {
            this.b = getHeight();
        }
        int i3 = this.a;
        int i4 = this.b;
        if (i3 >= i4) {
            i3 = i4;
        }
        try {
            bitmap3 = a(bitmap2, i3 / 2);
        } catch (Throwable unused2) {
            bitmap3 = null;
        }
        if (bitmap3 == null) {
            super.onDraw(canvas);
        } else {
            canvas.drawBitmap(bitmap3, (this.a / 2) - i2, (this.b / 2) - i2, (Paint) null);
        }
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0;
        this.b = 0;
    }

    public RoundImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = 0;
        this.b = 0;
    }
}
