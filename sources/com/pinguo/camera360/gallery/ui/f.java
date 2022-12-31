package com.pinguo.camera360.gallery.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.core.view.ViewCompat;
import com.pinguo.album.a;
import com.pinguo.album.data.utils.PGAlbumBitmapPool;
import com.pinguo.camera360.gallery.ui.h;
import us.pinguo.foundation.utils.n0;
/* compiled from: AlbumSetListLabelMaker.java */
/* loaded from: classes3.dex */
public class f implements n {
    private final h.b a;
    private final TextPaint b;
    private final TextPaint c;

    /* renamed from: d  reason: collision with root package name */
    private final TextPaint f6530d;

    /* renamed from: e  reason: collision with root package name */
    private int f6531e;

    /* renamed from: f  reason: collision with root package name */
    private int f6532f;

    /* compiled from: AlbumSetListLabelMaker.java */
    /* loaded from: classes3.dex */
    private class a implements a.b<Bitmap> {
        private String a;
        private String b;

        public a(String str, String str2, String str3) {
            this.a = str;
            this.b = str3;
        }

        @Override // com.pinguo.album.a.b
        /* renamed from: b */
        public Bitmap a(a.c cVar) {
            Bitmap b;
            if (cVar.isCancelled()) {
                return null;
            }
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            this.b = TextUtils.ellipsize(this.b, f.this.c, ((n0.i() - f.this.f6531e) - f.this.a.n) - f.this.a.n, TextUtils.TruncateAt.END).toString();
            TextPaint textPaint = f.this.c;
            String str = this.b;
            textPaint.getTextBounds(str, 0, str.length(), rect);
            TextPaint textPaint2 = f.this.f6530d;
            String str2 = this.a;
            textPaint2.getTextBounds(str2, 0, str2.length(), rect2);
            int width = rect.width() > rect2.width() ? rect.width() : rect2.width();
            synchronized (this) {
                b = PGAlbumBitmapPool.getInstance().b(width, f.this.f6532f);
            }
            if (b == null) {
                b = Bitmap.createBitmap(width, f.this.f6532f, Bitmap.Config.ARGB_8888);
            } else {
                b.eraseColor(0);
            }
            Canvas canvas = new Canvas(b);
            canvas.drawRect(0.0f, 0.0f, width, f.this.f6532f, f.this.b);
            if (cVar.isCancelled()) {
                return null;
            }
            int height = (rect.height() + ((f.this.f6532f - rect.height()) - rect2.height())) >> 1;
            canvas.drawText(this.b, rect.width() / 2, height, f.this.c);
            if (cVar.isCancelled()) {
                return null;
            }
            canvas.drawText(this.a, rect2.width() / 2, height + rect2.height() + f.this.a.n, f.this.f6530d);
            return b;
        }
    }

    public f(Context context, h.b bVar) {
        this.a = bVar;
        TextPaint i2 = i(bVar.f6562e, ViewCompat.MEASURED_STATE_MASK, false);
        this.c = i2;
        i2.setTextAlign(Paint.Align.CENTER);
        this.b = i(bVar.f6562e, -1, false);
        TextPaint i3 = i(bVar.f6565h, -7829368, false);
        this.f6530d = i3;
        i3.setTextAlign(Paint.Align.CENTER);
    }

    private static TextPaint i(int i2, int i3, boolean z) {
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(i2);
        textPaint.setAntiAlias(true);
        textPaint.setColor(i3);
        if (z) {
            textPaint.setTypeface(Typeface.defaultFromStyle(1));
        }
        return textPaint;
    }

    @Override // com.pinguo.camera360.gallery.ui.n
    public a.b<Bitmap> a(String str, String str2, String str3) {
        return new a(str, str2, str3);
    }

    @Override // com.pinguo.camera360.gallery.ui.n
    public synchronized void b(int i2, int i3) {
        if (this.f6531e == i2 && i3 == this.f6532f) {
            return;
        }
        this.f6531e = i2;
        this.f6532f = i2;
        us.pinguo.common.log.a.k("setLabelWidth mLabelHeight = " + this.f6532f + " mmLabelWidth = " + this.f6531e, new Object[0]);
    }
}
