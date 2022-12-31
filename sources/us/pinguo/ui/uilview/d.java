package us.pinguo.ui.uilview;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import us.pinguo.foundation.utils.l0;
/* compiled from: UilImgDrawable.java */
/* loaded from: classes6.dex */
public class d extends us.pinguo.foundation.t.a.b implements com.nostra13.universalimageloader.core.k.a, com.nostra13.universalimageloader.core.k.b {
    protected com.nostra13.universalimageloader.core.c mDisplayImageOptions;
    protected int mHeight;
    protected a mImageAware;
    private com.nostra13.universalimageloader.core.k.b mImageLoadingProgressListener;
    private com.nostra13.universalimageloader.core.k.c mSimpleImageLoadingListener;
    protected int mWidth;

    /* compiled from: UilImgDrawable.java */
    /* loaded from: classes6.dex */
    class a implements com.nostra13.universalimageloader.core.j.a {
        public a() {
        }

        @Override // com.nostra13.universalimageloader.core.j.a
        public int getHeight() {
            return d.this.mHeight;
        }

        @Override // com.nostra13.universalimageloader.core.j.a
        public int getId() {
            return d.this.hashCode();
        }

        @Override // com.nostra13.universalimageloader.core.j.a
        public ViewScaleType getScaleType() {
            return ViewScaleType.CROP;
        }

        @Override // com.nostra13.universalimageloader.core.j.a
        public int getWidth() {
            return d.this.mWidth;
        }

        @Override // com.nostra13.universalimageloader.core.j.a
        public View getWrappedView() {
            return null;
        }

        @Override // com.nostra13.universalimageloader.core.j.a
        public boolean isCollected() {
            return false;
        }

        @Override // com.nostra13.universalimageloader.core.j.a
        public boolean setImageBitmap(Bitmap bitmap) {
            boolean z = ((us.pinguo.foundation.t.a.b) d.this).mBitmap == null;
            if (((us.pinguo.foundation.t.a.b) d.this).mBitmap != bitmap) {
                d.this.setBitmap(bitmap);
            }
            return z;
        }

        @Override // com.nostra13.universalimageloader.core.j.a
        public boolean setImageDrawable(Drawable drawable) {
            return false;
        }
    }

    public d() {
        this(null, 0, 0);
    }

    public void cancelTask() {
        ImageLoader.getInstance().b(this.mImageAware);
    }

    protected void init() {
        throw null;
    }

    @Override // com.nostra13.universalimageloader.core.k.a
    public void onLoadingCancelled(String str, View view) {
        us.pinguo.common.log.a.k("onLoadingCancelled:" + str, new Object[0]);
    }

    @Override // com.nostra13.universalimageloader.core.k.a
    public void onLoadingComplete(String str, View view, Bitmap bitmap) {
        us.pinguo.common.log.a.k("onLoadingComplete:" + str, new Object[0]);
    }

    public void onLoadingFailed(String str, View view, FailReason failReason) {
        if (failReason != null) {
            us.pinguo.common.log.a.k("onLoadingFailed:" + str + " type:" + failReason.b() + " ex:" + failReason.a(), new Object[0]);
            return;
        }
        us.pinguo.common.log.a.k("onLoadingFailed:" + str, new Object[0]);
    }

    public void onLoadingStarted(String str, View view) {
    }

    @Override // com.nostra13.universalimageloader.core.k.b
    public void onProgressUpdate(String str, View view, int i2, int i3) {
    }

    public void setDisplayImageOptions(com.nostra13.universalimageloader.core.c cVar) {
        this.mDisplayImageOptions = cVar;
    }

    public void setImageUri(String str) {
        us.pinguo.common.log.a.k("display uri:" + str, new Object[0]);
        ImageLoader.getInstance().l(str, this.mImageAware, this.mDisplayImageOptions, this, this);
        l0.a(this.mImageAware);
    }

    public void setSize(int i2, int i3) {
        this.mWidth = i2;
        this.mHeight = i3;
    }

    public d(Bitmap bitmap, int i2, int i3) {
        super(bitmap, i2, i3);
        init();
    }
}
