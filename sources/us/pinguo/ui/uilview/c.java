package us.pinguo.ui.uilview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import us.pinguo.foundation.e;
/* compiled from: UilDrawable.java */
/* loaded from: classes6.dex */
public abstract class c extends Drawable {
    protected int mHeight;
    protected String mUri;
    protected int mWidth;

    /* compiled from: UilDrawable.java */
    /* loaded from: classes6.dex */
    class a extends com.facebook.imagepipeline.a.b {
        final /* synthetic */ com.facebook.datasource.b a;

        a(com.facebook.datasource.b bVar) {
            this.a = bVar;
        }

        @Override // com.facebook.datasource.a
        protected void e(com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> bVar) {
            bVar.close();
        }

        @Override // com.facebook.imagepipeline.a.b
        protected void g(Bitmap bitmap) {
            c.this.setBitmap(bitmap);
            this.a.close();
        }
    }

    public c() {
        init();
    }

    public abstract Bitmap getBitmap();

    public String getUri() {
        return this.mUri;
    }

    protected void init() {
    }

    public abstract boolean setBitmap(Bitmap bitmap);

    public void setImageResource(Context context, int i2) {
        Bitmap bitmap = null;
        if (i2 != 0) {
            try {
                bitmap = BitmapFactory.decodeResource(context.getResources(), i2);
            } catch (OutOfMemoryError e2) {
                us.pinguo.common.log.a.f(e2);
            }
        }
        setBitmap(bitmap);
    }

    public void setImageUri(String str) {
        this.mUri = str;
        com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> b = com.facebook.drawee.backends.pipeline.c.a().b(ImageRequestBuilder.s(Uri.parse(str)).a(), e.b());
        b.d(new a(b), UiThreadImmediateExecutorService.getInstance());
    }

    public void setSize(int i2, int i3) {
        this.mWidth = i2;
        this.mHeight = i3;
    }
}
