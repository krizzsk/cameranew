package com.mob.tools.gui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.mob.tools.MobLog;
import com.mob.tools.gui.BitmapProcessor;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.UIHandler;
import java.lang.ref.WeakReference;
import java.util.Random;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
/* loaded from: classes2.dex */
public class AsyncImageView extends ImageView implements BitmapProcessor.BitmapCallback, Handler.Callback {
    private static final int MSG_IMG_GOT = 1;
    private static final Random RND = new Random();
    private Bitmap defaultBm;
    private int defaultRes;
    private int desiredHeight;
    private int desiredWidth;
    private long diskCacheTime;
    private Bitmap errorBm;
    private int errorRes;
    private boolean lastReqIsOk;
    private long maxBytes;
    private Path path;
    private int quality;
    private float[] rect;
    private WeakReference<AsyncImageView> refAiv;
    private Bitmap result;
    private boolean scaleToCrop;
    private String url;
    private boolean useDiskCache;
    private boolean useRamCache;

    public AsyncImageView(Context context) {
        super(context);
        this.errorRes = 0;
        this.errorBm = null;
        this.refAiv = null;
        this.useRamCache = true;
        this.useDiskCache = true;
        this.diskCacheTime = 0L;
        this.desiredWidth = 0;
        this.desiredHeight = 0;
        this.maxBytes = 0L;
        this.quality = 0;
        init(context);
    }

    private BitmapProcessor.BitmapDesiredOptions getBitmapDesiredOptions() {
        if ((this.desiredWidth <= 1 || this.desiredHeight <= 1) && this.maxBytes < 10240 && this.quality <= 0) {
            return null;
        }
        BitmapProcessor.BitmapDesiredOptions bitmapDesiredOptions = new BitmapProcessor.BitmapDesiredOptions();
        bitmapDesiredOptions.desiredWidth = this.desiredWidth;
        bitmapDesiredOptions.desiredHeight = this.desiredHeight;
        bitmapDesiredOptions.maxBytes = this.maxBytes;
        bitmapDesiredOptions.quality = this.quality;
        return bitmapDesiredOptions;
    }

    private int[] getSize() {
        ViewGroup.LayoutParams layoutParams;
        int width = getWidth();
        int height = getHeight();
        if ((width == 0 || height == 0) && (layoutParams = getLayoutParams()) != null) {
            width = layoutParams.width;
            height = layoutParams.height;
        }
        if (width == 0 || height == 0) {
            measure(0, 0);
            width = getMeasuredWidth();
            height = getMeasuredHeight();
        }
        return new int[]{width, height};
    }

    private Bitmap goCrop(Bitmap bitmap) {
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        if (width == 0.0f || height == 0.0f) {
            return bitmap;
        }
        int[] size = getSize();
        if (size[0] == 0 || size[1] == 0) {
            return bitmap;
        }
        float f2 = (size[1] * width) / size[0];
        if (f2 == height) {
            return bitmap;
        }
        int[] iArr = new int[4];
        if (f2 < height) {
            iArr[1] = (int) ((height - f2) / 2.0f);
            iArr[3] = iArr[1];
        } else {
            iArr[0] = (int) ((width - ((size[0] * height) / size[1])) / 2.0f);
            iArr[2] = iArr[0];
        }
        try {
            return BitmapHelper.cropBitmap(bitmap, iArr[0], iArr[1], iArr[2], iArr[3]);
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return bitmap;
        }
    }

    private void init(Context context) {
        if (isInEditMode()) {
            setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        } else {
            BitmapProcessor.prepare(context);
        }
    }

    private void myClip(Canvas canvas) {
        if (this.rect != null) {
            if (this.path == null) {
                int width = getWidth();
                int height = getHeight();
                this.path = new Path();
                this.path.addRoundRect(new RectF(0.0f, 0.0f, width, height), this.rect, Path.Direction.CW);
            }
            canvas.clipPath(this.path);
        }
    }

    public void deleteCachedFile(String str) {
        BitmapProcessor.deleteCachedFile(str, getBitmapDesiredOptions());
    }

    public void execute(String str, int i2) {
        execute(str, i2, 0);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        WeakReference<AsyncImageView> weakReference;
        if (message.what == 1 && (weakReference = this.refAiv) != null && weakReference.get() != null) {
            try {
                Object obj = message.obj;
                Object obj2 = ((Object[]) obj)[0];
                Object obj3 = ((Object[]) obj)[1];
                if (obj3 != null && obj2 != null && obj2.equals(this.url)) {
                    this.result = (Bitmap) obj3;
                    this.refAiv.get().setImageBitmap(this.result);
                    this.lastReqIsOk = true;
                } else if (this.errorRes > 0) {
                    this.refAiv.get().setImageResource(this.errorRes);
                } else {
                    Bitmap bitmap = this.errorBm;
                    if (bitmap != null && !bitmap.isRecycled()) {
                        this.refAiv.get().setImageBitmap(this.errorBm);
                    } else {
                        Bitmap bitmap2 = this.defaultBm;
                        if (bitmap2 != null && !bitmap2.isRecycled()) {
                            this.refAiv.get().setImageBitmap(this.defaultBm);
                        } else {
                            this.refAiv.get().setImageResource(this.defaultRes);
                        }
                    }
                }
            } catch (Throwable th) {
                MobLog.getInstance().d(th);
            }
        }
        return false;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (getDrawable() == null || getDrawable().getIntrinsicWidth() == 0 || getDrawable().getIntrinsicHeight() == 0) {
            return;
        }
        Matrix imageMatrix = getImageMatrix();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int saveCount = canvas.getSaveCount();
        canvas.save();
        if (this.result != null) {
            myClip(canvas);
            canvas.drawBitmap(this.result, imageMatrix, new Paint(6));
        } else {
            if (imageMatrix != null || paddingLeft != 0 || paddingTop != 0) {
                if (Build.VERSION.SDK_INT >= 16 && getCropToPadding()) {
                    int scrollX = getScrollX();
                    int scrollY = getScrollY();
                    canvas.clipRect(scrollX + paddingLeft, scrollY + paddingTop, ((scrollX + getRight()) - getLeft()) - getPaddingRight(), ((scrollY + getBottom()) - getTop()) - getPaddingBottom());
                }
                canvas.translate(paddingLeft, paddingTop);
                if (imageMatrix != null) {
                    canvas.concat(imageMatrix);
                }
            }
            getDrawable().draw(canvas);
        }
        canvas.restoreToCount(saveCount);
    }

    public void onImageGot(String str, Bitmap bitmap) {
        WeakReference<AsyncImageView> weakReference = this.refAiv;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        if (str == null || str.trim().length() <= 0 || !str.equals(this.url)) {
            bitmap = null;
        }
        if (bitmap != null && this.scaleToCrop) {
            bitmap = goCrop(bitmap);
        }
        Message message = new Message();
        message.what = 1;
        message.obj = new Object[]{str, bitmap};
        UIHandler.sendMessageDelayed(message, RND.nextInt(IjkMediaCodecInfo.RANK_SECURE), this);
    }

    public void removeRamCache(String str) {
        if (this.useRamCache) {
            BitmapProcessor.removeBitmapFromRamCache(str, getBitmapDesiredOptions());
        }
    }

    public void setBitmap(Bitmap bitmap) {
        if (this.scaleToCrop) {
            bitmap = goCrop(bitmap);
        }
        setImageBitmap(bitmap);
        this.result = bitmap;
    }

    public void setCompressOptions(int i2, int i3, int i4, long j2) {
        this.desiredWidth = i2;
        this.desiredHeight = i3;
        this.quality = i4;
        this.maxBytes = j2;
    }

    @Override // android.view.View
    public void setPadding(int i2, int i3, int i4, int i5) {
        MobLog.getInstance().w(new RuntimeException("Not Support"));
    }

    public void setRound(float f2) {
        setRound(f2, f2, f2, f2);
    }

    public void setScaleToCropCenter(boolean z) {
        this.scaleToCrop = z;
    }

    public void setUseCacheOption(boolean z, boolean z2) {
        setUseCacheOption(z, z2, 0L);
    }

    public void execute(String str, int i2, int i3) {
        Bitmap bitmapFromCache;
        if ((this.useRamCache || this.useDiskCache) && this.lastReqIsOk && !TextUtils.isEmpty(str) && str.equals(this.url)) {
            return;
        }
        this.lastReqIsOk = false;
        this.url = str;
        this.result = null;
        this.defaultRes = i2;
        this.errorRes = i3;
        if (TextUtils.isEmpty(str)) {
            if (i3 != 0) {
                i2 = i3;
            }
            setImageResource(i2);
            return;
        }
        BitmapProcessor.BitmapDesiredOptions bitmapDesiredOptions = getBitmapDesiredOptions();
        if (this.useRamCache && (bitmapFromCache = BitmapProcessor.getBitmapFromCache(str, bitmapDesiredOptions)) != null && !bitmapFromCache.isRecycled()) {
            setBitmap(bitmapFromCache);
            this.lastReqIsOk = true;
            return;
        }
        if (i2 > 0) {
            setImageResource(i2);
        }
        WeakReference<AsyncImageView> weakReference = this.refAiv;
        if (weakReference == null || weakReference.get() == null) {
            this.refAiv = new WeakReference<>(this);
        }
        BitmapProcessor.process(str, bitmapDesiredOptions, this.useRamCache, this.useDiskCache, this.diskCacheTime, this);
    }

    public void setRound(float f2, float f3, float f4, float f5) {
        this.rect = new float[]{f2, f2, f3, f3, f4, f4, f5, f5};
    }

    public void setUseCacheOption(boolean z, boolean z2, long j2) {
        this.useRamCache = z;
        this.useDiskCache = z2;
        if (z2) {
            this.diskCacheTime = j2;
        }
    }

    public AsyncImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.errorRes = 0;
        this.errorBm = null;
        this.refAiv = null;
        this.useRamCache = true;
        this.useDiskCache = true;
        this.diskCacheTime = 0L;
        this.desiredWidth = 0;
        this.desiredHeight = 0;
        this.maxBytes = 0L;
        this.quality = 0;
        init(context);
    }

    public void execute(String str, Bitmap bitmap) {
        execute(str, bitmap, (Bitmap) null);
    }

    public void execute(String str, Bitmap bitmap, Bitmap bitmap2) {
        Bitmap bitmapFromCache;
        if ((this.useRamCache || this.useDiskCache) && this.lastReqIsOk && !TextUtils.isEmpty(str) && str.equals(this.url)) {
            return;
        }
        this.lastReqIsOk = false;
        this.url = str;
        this.result = null;
        this.defaultBm = bitmap;
        this.errorBm = bitmap2;
        if (TextUtils.isEmpty(str)) {
            if (bitmap2 != null) {
                bitmap = bitmap2;
            }
            setImageBitmap(bitmap);
            return;
        }
        BitmapProcessor.BitmapDesiredOptions bitmapDesiredOptions = getBitmapDesiredOptions();
        if (this.useRamCache && (bitmapFromCache = BitmapProcessor.getBitmapFromCache(str, bitmapDesiredOptions)) != null && !bitmapFromCache.isRecycled()) {
            setBitmap(bitmapFromCache);
            this.lastReqIsOk = true;
            return;
        }
        if (bitmap != null && !bitmap.isRecycled()) {
            setImageBitmap(bitmap);
        }
        WeakReference<AsyncImageView> weakReference = this.refAiv;
        if (weakReference == null || weakReference.get() == null) {
            this.refAiv = new WeakReference<>(this);
        }
        BitmapProcessor.process(str, bitmapDesiredOptions, this.useRamCache, this.useDiskCache, this.diskCacheTime, this);
    }

    public AsyncImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.errorRes = 0;
        this.errorBm = null;
        this.refAiv = null;
        this.useRamCache = true;
        this.useDiskCache = true;
        this.diskCacheTime = 0L;
        this.desiredWidth = 0;
        this.desiredHeight = 0;
        this.maxBytes = 0L;
        this.quality = 0;
        init(context);
    }
}
