package com.pinguo.camera360.gallery.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import com.pinguo.album.a;
import com.pinguo.album.data.utils.PGAlbumBitmapPool;
import com.pinguo.camera360.gallery.ui.h;
import us.pinguo.foundation.utils.n0;
import vStudio.Android.Camera360.R;
/* compiled from: AlbumLabelMaker.java */
/* loaded from: classes3.dex */
public class e implements n {

    /* renamed from: i  reason: collision with root package name */
    private static String f6523i;
    private final h.b a;
    private final TextPaint b;
    private final TextPaint c;

    /* renamed from: d  reason: collision with root package name */
    private final TextPaint f6524d;

    /* renamed from: e  reason: collision with root package name */
    private int f6525e;

    /* renamed from: f  reason: collision with root package name */
    private int f6526f;

    /* renamed from: g  reason: collision with root package name */
    private Bitmap f6527g;

    /* renamed from: h  reason: collision with root package name */
    private LinearGradient f6528h;

    /* compiled from: AlbumLabelMaker.java */
    /* loaded from: classes3.dex */
    private class a implements a.b<Bitmap> {
        private String a;
        private String b;
        private String c;

        public a(String str, String str2, String str3) {
            this.a = str + e.f6523i;
            this.b = str2;
            this.c = str3;
        }

        @Override // com.pinguo.album.a.b
        /* renamed from: b */
        public Bitmap a(a.c cVar) {
            int i2;
            Bitmap b;
            if (cVar.isCancelled()) {
                return null;
            }
            synchronized (this) {
                i2 = e.this.f6525e;
                b = PGAlbumBitmapPool.getInstance().b(e.this.f6525e, e.this.f6526f);
            }
            if (b == null) {
                b = Bitmap.createBitmap(i2, e.this.f6526f, Bitmap.Config.ARGB_8888);
            } else {
                b.eraseColor(0);
            }
            Canvas canvas = new Canvas(b);
            canvas.drawRect(0.0f, 0.0f, e.this.f6525e, e.this.f6526f, e.this.b);
            if (cVar.isCancelled()) {
                return null;
            }
            Rect rect = new Rect();
            TextPaint textPaint = e.this.c;
            String str = this.c;
            textPaint.getTextBounds(str, 0, str.length(), rect);
            canvas.drawText(this.c, e.this.a.f6568k + (rect.width() / 2), rect.height() + e.this.a.f6567j, e.this.c);
            this.b = TextUtils.ellipsize(this.b, e.this.f6524d, e.this.f6525e, TextUtils.TruncateAt.END).toString();
            TextPaint textPaint2 = e.this.f6524d;
            String str2 = this.b;
            textPaint2.getTextBounds(str2, 0, str2.length(), rect);
            int width = e.this.a.f6568k + (rect.width() / 2);
            float f2 = e.this.f6526f - e.this.a.m;
            canvas.drawText(this.b, width, f2, e.this.f6524d);
            if (cVar.isCancelled()) {
                return null;
            }
            this.a = TextUtils.ellipsize(this.a, e.this.f6524d, e.this.f6525e, TextUtils.TruncateAt.END).toString();
            TextPaint textPaint3 = e.this.f6524d;
            String str3 = this.a;
            textPaint3.getTextBounds(str3, 0, str3.length(), rect);
            canvas.drawText(this.a, (e.this.f6525e - (rect.width() / 2)) - e.this.a.f6568k, f2, e.this.f6524d);
            canvas.drawBitmap(e.this.f6527g, ((e.this.f6525e - rect.width()) - n0.c(32)) - e.this.f6527g.getWidth(), ((e.this.f6526f - e.this.f6527g.getHeight()) - e.this.a.m) + ((e.this.f6527g.getHeight() - rect.height()) / 2) + rect.bottom, e.this.f6524d);
            return b;
        }
    }

    public e(Context context, h.b bVar) {
        this.a = bVar;
        TextPaint k2 = k(bVar.f6562e, -1, false);
        this.c = k2;
        k2.setTextAlign(Paint.Align.CENTER);
        this.b = k(bVar.f6562e, -1, false);
        TextPaint k3 = k(bVar.f6565h, -1, false);
        this.f6524d = k3;
        k3.setTextAlign(Paint.Align.CENTER);
        this.f6527g = BitmapFactory.decodeResource(context.getResources(), R.drawable.photo);
        f6523i = context.getResources().getString(R.string.album_label_suffix);
    }

    private static TextPaint k(int i2, int i3, boolean z) {
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
        if (this.f6525e == i2 && i3 == this.f6526f) {
            return;
        }
        this.f6525e = i2;
        this.f6526f = this.a.b;
        us.pinguo.common.log.a.k("setLabelWidth mLabelHeight = " + this.f6526f + " mmLabelWidth = " + this.f6525e, new Object[0]);
        LinearGradient linearGradient = new LinearGradient(0.0f, (float) this.f6526f, 0.0f, 0.0f, new int[]{-1308622848, 0}, (float[]) null, Shader.TileMode.REPEAT);
        this.f6528h = linearGradient;
        this.b.setShader(linearGradient);
    }
}
