package us.pinguo.ui.uilview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.c;
import us.pinguo.foundation.t.a.f;
import us.pinguo.foundation.t.a.h;
import us.pinguo.ui.a;
/* loaded from: classes6.dex */
public class PhotoImageView extends UilImageView {
    public static final int ANIM_DURATION = 400;
    private static final int DEFAULT_LOADING_COLOR = -2236963;
    private Paint mBgPaint;
    private RectF mBgRect;
    protected int mHeight;
    private boolean mIsVideoUri;
    private int mLoadingColor;
    private LoadingStatus mLoadingStatus;
    private com.nostra13.universalimageloader.core.c mVideoOptions;
    protected int mWidth;

    /* loaded from: classes6.dex */
    public enum LoadingStatus {
        STARTED,
        COMPLETE,
        FAILED,
        CANCELLED
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes6.dex */
    public static class a extends com.nostra13.universalimageloader.core.j.b {
        private int c;

        /* renamed from: d  reason: collision with root package name */
        private int f12103d;

        public a(ImageView imageView) {
            super(imageView);
        }

        public void e(int i2, int i3) {
            this.c = i2;
            this.f12103d = i3;
        }

        @Override // com.nostra13.universalimageloader.core.j.b, com.nostra13.universalimageloader.core.j.d, com.nostra13.universalimageloader.core.j.a
        public int getHeight() {
            ImageView wrappedView = getWrappedView();
            int i2 = this.f12103d;
            if (i2 != 0) {
                return i2;
            }
            if (wrappedView == null) {
                return 0;
            }
            if (wrappedView.getMeasuredHeight() > 0) {
                return wrappedView.getMeasuredHeight();
            }
            int height = super.getHeight();
            return height > 0 ? height : us.pinguo.foundation.t.b.a.j(wrappedView.getContext());
        }

        @Override // com.nostra13.universalimageloader.core.j.b, com.nostra13.universalimageloader.core.j.d, com.nostra13.universalimageloader.core.j.a
        public int getWidth() {
            ImageView wrappedView = getWrappedView();
            int i2 = this.c;
            if (i2 != 0) {
                return i2;
            }
            if (wrappedView == null) {
                return 0;
            }
            if (wrappedView.getMeasuredWidth() > 0) {
                return wrappedView.getMeasuredWidth();
            }
            int width = super.getWidth();
            return width > 0 ? width : us.pinguo.foundation.t.b.a.j(wrappedView.getContext());
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public int a;
        public int b;
    }

    public PhotoImageView(Context context) {
        super(context);
        this.mLoadingColor = DEFAULT_LOADING_COLOR;
        this.mBgRect = new RectF();
    }

    public static String addQiNiuSuffix(String str, int i2, int i3, boolean z) {
        if (str == null || !str.startsWith("http")) {
            return str;
        }
        if (!z) {
            if (str.contains("?imageMogr2")) {
                return str;
            }
            if (i2 > 0 && i3 > 0) {
                return str + "?imageMogr2/auto-orient/format/webp/quality/75/thumbnail/!" + i2 + "x" + i3 + "r";
            }
            return str + "?imageMogr2/auto-orient/format/webp/quality/75";
        } else if (str.contains("?vframe")) {
            return str;
        } else {
            if (i2 > 1 && i3 > 1) {
                return str + "?vframe/jpg/offset/0/rotate/auto/w/" + i2 + "/h/" + i3;
            }
            return str + "?vframe/jpg/offset/0/rotate/auto/";
        }
    }

    public static b generateSize(int i2, int i3, int i4, int i5) {
        double d2;
        double d3;
        if (i3 == 0 || i5 == 0) {
            d2 = 0.0d;
            d3 = 0.0d;
        } else {
            d3 = (i2 * 1.0d) / i3;
            d2 = (i4 * 1.0d) / i5;
        }
        if (d3 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || d2 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            i4 = 0;
            i5 = 0;
        } else if (d3 > d2) {
            i4 = (int) (d3 * i5);
        } else {
            i5 = (int) (i4 / d3);
        }
        b bVar = new b();
        bVar.a = i4;
        bVar.b = i5;
        return bVar;
    }

    private void initBgPaint() {
        Paint paint = new Paint();
        this.mBgPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mBgPaint.setColor(this.mLoadingColor);
    }

    private f initDisplayer() {
        return new f(0, 0, 400, true, true, false);
    }

    private void showLoadingColor() {
        ViewCompat.postInvalidateOnAnimation(this);
    }

    public void cancelTask() {
        if (this.mImageViewAware != null) {
            String str = UilImageView.TAG;
            us.pinguo.common.log.a.k(str, "cancelTask:" + toString());
            ImageLoader.getInstance().b(this.mImageViewAware);
        }
    }

    public Bitmap createVideoThumbnail(String str, int i2, int i3) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
                try {
                    mediaMetadataRetriever.release();
                    return frameAtTime;
                } catch (RuntimeException unused) {
                    return frameAtTime;
                }
            } catch (RuntimeException unused2) {
                return null;
            }
        } catch (IllegalArgumentException | RuntimeException unused3) {
            mediaMetadataRetriever.release();
            return null;
        } catch (Throwable th) {
            try {
                mediaMetadataRetriever.release();
            } catch (RuntimeException unused4) {
            }
            throw th;
        }
    }

    public LoadingStatus getLoadingStatus() {
        return this.mLoadingStatus;
    }

    @Override // us.pinguo.ui.uilview.UilImageView
    protected String getProcessedUri(String str) {
        return addQiNiuSuffix(str, this.mImageViewAware.getWidth(), this.mImageViewAware.getHeight(), this.mIsVideoUri);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.ui.uilview.UilImageView
    public void init(AttributeSet attributeSet) {
        f initDisplayer = initDisplayer();
        c.b bVar = new c.b();
        bVar.u(true);
        bVar.v(true);
        ImageScaleType imageScaleType = ImageScaleType.EXACTLY;
        bVar.A(imageScaleType);
        a.C0453a c0453a = new a.C0453a();
        c0453a.b(true);
        c0453a.d(false);
        c0453a.e(true);
        bVar.z(c0453a);
        bVar.y(initDisplayer);
        bVar.D(true);
        this.mDisplayImageOptions = bVar.t();
        c.b bVar2 = new c.b();
        bVar2.u(true);
        bVar2.v(false);
        bVar2.A(imageScaleType);
        bVar2.J(new ColorDrawable(this.mLoadingColor));
        a.C0453a c0453a2 = new a.C0453a();
        c0453a2.b(true);
        c0453a2.d(false);
        c0453a2.e(true);
        c0453a2.c(true);
        bVar2.z(c0453a2);
        bVar2.y(initDisplayer);
        bVar2.D(true);
        this.mVideoOptions = bVar2.t();
        setImageViewAware(new a(this));
        setScaleType(ImageView.ScaleType.FIT_XY);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable == null || ((drawable instanceof h) && ((h) drawable).getAlpha() < 250)) {
            if (this.mBgPaint == null) {
                initBgPaint();
            }
            setBgRect(this.mBgRect);
            canvas.drawRoundRect(this.mBgRect, 0.0f, 0.0f, this.mBgPaint);
        }
        super.onDraw(canvas);
    }

    @Override // us.pinguo.ui.uilview.UilImageView, com.nostra13.universalimageloader.core.k.a
    public void onLoadingCancelled(String str, View view) {
        super.onLoadingCancelled(str, view);
        this.mLoadingStatus = LoadingStatus.CANCELLED;
    }

    @Override // us.pinguo.ui.uilview.UilImageView, com.nostra13.universalimageloader.core.k.a
    public void onLoadingComplete(String str, View view, Bitmap bitmap) {
        super.onLoadingComplete(str, view, bitmap);
        this.mLoadingStatus = LoadingStatus.COMPLETE;
    }

    @Override // us.pinguo.ui.uilview.UilImageView, com.nostra13.universalimageloader.core.k.a
    public void onLoadingFailed(String str, View view, FailReason failReason) {
        super.onLoadingFailed(str, view, failReason);
        this.mLoadingStatus = LoadingStatus.FAILED;
    }

    @Override // us.pinguo.ui.uilview.UilImageView, com.nostra13.universalimageloader.core.k.a
    public void onLoadingStarted(String str, View view) {
        super.onLoadingStarted(str, view);
        showLoadingColor();
        this.mLoadingStatus = LoadingStatus.STARTED;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        super.onMeasure(i2, i3);
        int i5 = this.mWidth;
        if (i5 <= 0 || (i4 = this.mHeight) <= 0) {
            return;
        }
        setMeasuredDimension(i5, i4);
    }

    public void resetViewBeforeLoading(boolean z) {
        if (this.mDisplayImageOptions.I() != z) {
            c.b bVar = new c.b();
            bVar.w(this.mDisplayImageOptions);
            bVar.D(z);
            this.mDisplayImageOptions = bVar.t();
        }
    }

    public void restoreDisplayer() {
        setDisplayer(initDisplayer());
    }

    protected void setBgRect(RectF rectF) {
        this.mBgRect.set(0.0f, 0.0f, getWidth(), getHeight());
    }

    @Override // us.pinguo.ui.uilview.UilImageView
    public void setDisplayer(com.nostra13.universalimageloader.core.i.a aVar) {
        super.setDisplayer(aVar);
        if (aVar == null || this.mVideoOptions.w() == aVar) {
            return;
        }
        c.b bVar = new c.b();
        bVar.w(this.mVideoOptions);
        bVar.y(aVar);
        this.mVideoOptions = bVar.t();
    }

    public void setImageSize(int i2, int i3) {
        ((a) this.mImageViewAware).e(i2, i3);
    }

    @Override // us.pinguo.ui.uilview.UilImageView
    protected void setImageUri(String str, com.nostra13.universalimageloader.core.c cVar) {
        super.setImageUri(addQiNiuSuffix(str, this.mImageViewAware.getWidth(), this.mImageViewAware.getHeight(), this.mIsVideoUri), cVar);
    }

    public void setImgCenterCrop(boolean z) {
        c.b bVar = new c.b();
        bVar.w(this.mDisplayImageOptions);
        a.C0453a c0453a = new a.C0453a();
        c0453a.b(z);
        c0453a.d(false);
        c0453a.e(true);
        bVar.z(c0453a);
        this.mDisplayImageOptions = bVar.t();
    }

    public void setLoadingColor(int i2) {
        this.mLoadingColor = i2;
    }

    public void setLocalVideoUri(String str) {
        setImageUri(str, this.mVideoOptions);
    }

    public void setSize(int i2, int i3) {
        this.mWidth = i2;
        this.mHeight = i3;
        ((a) this.mImageViewAware).e(i2, i3);
    }

    @Deprecated
    public void setVideoImageUrl(String str, int i2, int i3) {
        setImageSize(i2, i3);
        if ((str != null && str.startsWith("file")) || str.startsWith("FILE")) {
            setImageBitmap(createVideoThumbnail(Uri.parse(str).getPath(), i2, i3));
        } else {
            setVideoThumbnailUri(str);
        }
    }

    public void setVideoThumbnailUri(String str) {
        this.mIsVideoUri = true;
        setImageUri(str);
        this.mIsVideoUri = false;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i2) {
        us.pinguo.common.log.a.k("PhotoImageView visiiliblity" + i2, new Object[0]);
        super.setVisibility(i2);
    }

    public PhotoImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLoadingColor = DEFAULT_LOADING_COLOR;
        this.mBgRect = new RectF();
    }

    public PhotoImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mLoadingColor = DEFAULT_LOADING_COLOR;
        this.mBgRect = new RectF();
    }

    @Deprecated
    public void setVideoImageUrl(String str, int i2, int i3, int i4, int i5) {
        double d2;
        double d3;
        if (i3 == 0 || i5 == 0) {
            d2 = 0.0d;
            d3 = 0.0d;
        } else {
            d2 = (i2 * 1.0d) / i3;
            d3 = (i4 * 1.0d) / i5;
        }
        if (d2 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || d3 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            i4 = 0;
            i5 = 0;
        } else if (d2 > d3) {
            i4 = (int) (d2 * i5);
        } else {
            i5 = (int) (i4 / d2);
        }
        if (i4 <= 1 || i5 <= 1 || i2 <= 1 || i3 <= 1) {
            str = addQiNiuSuffix(str, 0, 0, true);
        }
        setVideoImageUrl(str, i4, i5);
    }

    public static String addQiNiuSuffix(String str, int i2, boolean z) {
        if (str != null && str.startsWith("http")) {
            if (!z) {
                if (!str.contains("?imageMogr2")) {
                    if (i2 > 0) {
                        str = str + "?imageMogr2/auto-orient/format/webp/quality/75/thumbnail/" + i2 + "x";
                    } else {
                        str = str + "?imageMogr2/auto-orient/format/webp/quality/75";
                    }
                }
            } else if (!str.contains("?vframe")) {
                if (i2 > 1) {
                    str = str + "?vframe/jpg/offset/0/rotate/auto/w/" + i2;
                } else {
                    str = str + "?vframe/jpg/offset/0/rotate/auto/";
                }
            }
        }
        return str.startsWith("https") ? str.replaceFirst("https", "http") : str;
    }
}
