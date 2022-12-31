package us.pinguo.inspire.module.photomovie;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import com.hw.photomovie.b.b;
import com.hw.photomovie.util.AppResources;
import com.hw.photomovie.util.d;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.c;
/* loaded from: classes9.dex */
public class UilPhotoData extends com.hw.photomovie.b.b implements com.nostra13.universalimageloader.core.k.a, com.nostra13.universalimageloader.core.k.b {
    private static final String TAG = "UilPhotoData";
    protected NoCancelAware mAware;
    protected b.a mOnDataLoadListener;
    protected com.nostra13.universalimageloader.core.c mOptions;

    /* loaded from: classes9.dex */
    private class NoCancelAware implements com.nostra13.universalimageloader.core.j.a {
        protected final com.nostra13.universalimageloader.core.assist.c imageSize;
        protected final ViewScaleType scaleType;

        public NoCancelAware() {
            DisplayMetrics displayMetrics = AppResources.getInstance().a().getDisplayMetrics();
            com.nostra13.universalimageloader.core.assist.c cVar = new com.nostra13.universalimageloader.core.assist.c(displayMetrics.widthPixels, displayMetrics.heightPixels);
            this.imageSize = cVar;
            ViewScaleType viewScaleType = ViewScaleType.CROP;
            this.scaleType = viewScaleType;
            if (cVar == null) {
                throw new IllegalArgumentException("imageSize must not be null");
            }
            if (viewScaleType == null) {
                throw new IllegalArgumentException("scaleType must not be null");
            }
        }

        @Override // com.nostra13.universalimageloader.core.j.a
        public int getHeight() {
            return this.imageSize.a();
        }

        @Override // com.nostra13.universalimageloader.core.j.a
        public int getId() {
            return super.hashCode();
        }

        @Override // com.nostra13.universalimageloader.core.j.a
        public ViewScaleType getScaleType() {
            return this.scaleType;
        }

        @Override // com.nostra13.universalimageloader.core.j.a
        public int getWidth() {
            return this.imageSize.b();
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
            return true;
        }

        @Override // com.nostra13.universalimageloader.core.j.a
        public boolean setImageDrawable(Drawable drawable) {
            return true;
        }
    }

    public UilPhotoData(String str, int i2) {
        super(str, i2);
        c.b bVar = new c.b();
        bVar.u(true);
        bVar.v(true);
        bVar.x(true);
        this.mOptions = bVar.t();
    }

    @Override // com.nostra13.universalimageloader.core.k.a
    public void onLoadingCancelled(String str, View view) {
        com.hw.photomovie.util.b.d(TAG, "loading cancelled:" + str);
        onLoadingFailed(str, view, null);
    }

    @Override // com.nostra13.universalimageloader.core.k.a
    public void onLoadingComplete(String str, View view, Bitmap bitmap) {
        if (!d.a(bitmap)) {
            onLoadingFailed(str, view, null);
            return;
        }
        int i2 = this.mTargetState;
        if (i2 == 2) {
            this.mState = 2;
        } else if (i2 == 4) {
            this.mState = 4;
            this.mBitmap = bitmap;
        }
        b.a aVar = this.mOnDataLoadListener;
        if (aVar != null) {
            if (this.mTargetState >= 2) {
                aVar.a(this);
            }
            if (this.mTargetState == 4) {
                this.mOnDataLoadListener.b(this, bitmap);
            }
        }
        com.hw.photomovie.util.b.c(TAG, "loading complete:" + str);
    }

    @Override // com.nostra13.universalimageloader.core.k.a
    public void onLoadingFailed(String str, View view, FailReason failReason) {
        if (this.mState == 3) {
            this.mState = 2;
        } else {
            this.mState = -1;
        }
        if (this.mOnDataLoadListener != null) {
            this.mOnDataLoadListener.c(this, failReason != null ? new com.hw.photomovie.b.a(failReason.a(), failReason.b().name()) : null);
        }
        String name = (failReason == null || failReason.b() == null) ? "null" : failReason.b().name();
        com.hw.photomovie.util.b.a(TAG, "loading Faild:" + str + " reason:" + name);
    }

    @Override // com.nostra13.universalimageloader.core.k.a
    public void onLoadingStarted(String str, View view) {
        if (this.mState < 2) {
            this.mState = 1;
        } else {
            this.mState = 3;
        }
    }

    @Override // com.nostra13.universalimageloader.core.k.b
    public void onProgressUpdate(String str, View view, int i2, int i3) {
        b.a aVar = this.mOnDataLoadListener;
        if (aVar != null) {
            aVar.d(this, i2, i3);
        }
    }

    @Override // com.hw.photomovie.b.b
    public void prepareData(int i2, b.a aVar) {
        this.mOnDataLoadListener = aVar;
        this.mTargetState = i2;
        NoCancelAware noCancelAware = this.mAware;
        if (noCancelAware == null) {
            noCancelAware = new NoCancelAware();
        }
        this.mAware = noCancelAware;
        int i3 = this.mState;
        if (i3 == -1 || i3 == 0) {
            ImageLoader.getInstance().l(getUri(), this.mAware, this.mOptions, this, this);
        } else if (i3 == 2) {
            if (i2 == 4) {
                ImageLoader.getInstance().l(getUri(), this.mAware, this.mOptions, this, this);
            } else if (i2 != 2 || aVar == null) {
            } else {
                aVar.a(this);
            }
        } else if (i3 != 4) {
        } else {
            if (i2 == 4 && aVar != null) {
                aVar.b(this, getBitmap());
            } else if (i2 != 2 || aVar == null) {
            } else {
                aVar.a(this);
            }
        }
    }
}
