package com.pinguo.camera360.gallery.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.text.TextPaint;
import com.pinguo.album.a;
import com.pinguo.album.data.utils.PGAlbumBitmapPool;
import com.pinguo.camera360.gallery.g0;
import com.pinguo.camera360.gallery.ui.j;
import us.pinguo.foundation.utils.n0;
/* compiled from: AlbumSortTagMaker.java */
/* loaded from: classes3.dex */
public class k {
    private Context a;
    private TextPaint b;
    private TextPaint c;

    /* renamed from: d  reason: collision with root package name */
    private TextPaint f6596d;

    /* renamed from: e  reason: collision with root package name */
    private int f6597e;

    /* renamed from: f  reason: collision with root package name */
    private int f6598f;

    /* renamed from: g  reason: collision with root package name */
    private int f6599g;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AlbumSortTagMaker.java */
    /* loaded from: classes3.dex */
    public class a implements a.b<Bitmap> {
        private String a;
        private boolean b;
        private String c;

        public a(String str, boolean z) {
            this.b = false;
            this.c = str;
            this.b = z;
            if (z) {
                this.a = str.substring(0, 4);
            }
        }

        @Override // com.pinguo.album.a.b
        /* renamed from: b */
        public Bitmap a(a.c cVar) {
            int i2;
            int i3;
            int i4;
            int i5;
            Bitmap b;
            int i6;
            synchronized (this) {
                i2 = k.this.f6597e;
                i3 = k.this.f6598f;
                i4 = i2 + 4;
                i5 = i3 + 4;
                b = PGAlbumBitmapPool.getInstance().b(i4, i5);
            }
            if (b == null) {
                b = Bitmap.createBitmap(i4, i5, Bitmap.Config.ARGB_8888);
            }
            Canvas canvas = new Canvas(b);
            canvas.clipRect(2, 2, b.getWidth() - 2, b.getHeight() - 2);
            canvas.translate(2.0f, 2.0f);
            canvas.drawColor(0, PorterDuff.Mode.SRC);
            if (!this.b) {
                if (cVar.isCancelled()) {
                    return null;
                }
                new Paint();
                Paint.FontMetricsInt fontMetricsInt = k.this.c.getFontMetricsInt();
                int i7 = fontMetricsInt.descent;
                int i8 = fontMetricsInt.ascent;
                canvas.drawText(this.c, 0, (((i3 - (i7 - i8)) / 2) + fontMetricsInt.leading) - i8, k.this.c);
                if (cVar.isCancelled()) {
                    return null;
                }
            } else {
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setDither(true);
                paint.setColor(-13877680);
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeJoin(Paint.Join.ROUND);
                paint.setStrokeCap(Paint.Cap.ROUND);
                paint.setStrokeWidth(k.this.f6599g);
                Path path = new Path();
                float measureText = (int) ((i2 / 2) - (k.this.f6596d.measureText(this.a) / 2.0f));
                float f2 = i3 / 2;
                path.moveTo(measureText, f2);
                path.lineTo(k.this.f6596d.measureText(this.a) + measureText, f2);
                canvas.drawPath(path, paint);
                if (cVar.isCancelled()) {
                    return null;
                }
                Paint.FontMetricsInt fontMetricsInt2 = k.this.b.getFontMetricsInt();
                canvas.drawText(this.a, measureText, i6 + (((fontMetricsInt2.leading - fontMetricsInt2.ascent) / 2) - n0.c(1)), k.this.f6596d);
            }
            return b;
        }
    }

    public k(Context context, j.d dVar, int i2, int i3) {
        this.f6599g = 0;
        this.a = context;
        TextPaint h2 = com.pinguo.album.j.c.h(dVar.a, -13877680, false);
        this.b = h2;
        h2.setTextAlign(Paint.Align.LEFT);
        com.pinguo.album.j.c.h(dVar.b, -13877680, false);
        TextPaint h3 = com.pinguo.album.j.c.h(dVar.c, -13877680, false);
        this.f6596d = h3;
        h3.setTextAlign(Paint.Align.LEFT);
        this.c = com.pinguo.album.j.c.h(dVar.c, -13877680, false);
        synchronized (this) {
            this.f6597e = i2;
            this.f6598f = i3;
        }
        this.f6599g = g0.a(context).b.f6564g;
    }

    public a.b<Bitmap> g(String str, boolean z) {
        return new a(str, z);
    }
}
