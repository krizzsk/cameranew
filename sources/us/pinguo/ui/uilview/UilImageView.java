package us.pinguo.ui.uilview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.c;
import com.pinguo.camera360.effect.model.entity.param.ParamItem;
import d.f.a.b.e;
import java.io.File;
import us.pinguo.foundation.utils.l0;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
/* loaded from: classes6.dex */
public class UilImageView extends ImageView implements com.nostra13.universalimageloader.core.k.a, com.nostra13.universalimageloader.core.k.b {
    protected static final String TAG = UilImageView.class.getSimpleName();
    private static final SparseIntArray mDeletedCache = new SparseIntArray();
    private static com.nostra13.universalimageloader.core.assist.c sEmptyImageSize;
    protected com.nostra13.universalimageloader.core.c mDisplayImageOptions;
    private com.nostra13.universalimageloader.core.k.b mImageLoadingProgressListener;
    protected com.nostra13.universalimageloader.core.j.b mImageViewAware;
    private boolean mIsPlugin;
    private com.nostra13.universalimageloader.core.k.c mSimpleImageLoadingListener;
    private long mStartStmp;

    public UilImageView(Context context) {
        super(context);
        this.mIsPlugin = false;
        init(null);
    }

    private void checkAndDeleteResCache(int i2, String str, String str2) {
        SparseIntArray sparseIntArray = mDeletedCache;
        if (sparseIntArray.get(i2) == 0) {
            ImageLoader.getInstance().m().remove(str);
            ImageLoader.getInstance().o().remove(str2);
            sparseIntArray.put(i2, 1);
        }
    }

    protected void defaultDrawableLoaded(Drawable drawable) {
    }

    public com.nostra13.universalimageloader.core.c getDisplayImageOptions() {
        return this.mDisplayImageOptions;
    }

    public com.nostra13.universalimageloader.core.j.b getImageViewAware() {
        return this.mImageViewAware;
    }

    protected String getProcessedUri(String str) {
        return str;
    }

    protected Drawable getResDrawable(int i2) {
        try {
            if (sEmptyImageSize == null) {
                sEmptyImageSize = new com.nostra13.universalimageloader.core.assist.c(0, 0);
            }
            String b = e.b(String.valueOf(getResources().hashCode()) + String.valueOf(i2), sEmptyImageSize);
            Bitmap bitmap = ImageLoader.getInstance().o().get(b);
            if (bitmap != null) {
                return new BitmapDrawable(getResources(), bitmap);
            }
            Drawable drawable = getResources().getDrawable(i2);
            if (drawable instanceof BitmapDrawable) {
                ImageLoader.getInstance().o().put(b, ((BitmapDrawable) drawable).getBitmap());
            }
            return drawable;
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
            return new ColorDrawable(-7829368);
        }
    }

    protected void init(AttributeSet attributeSet) {
        this.mImageViewAware = new com.nostra13.universalimageloader.core.j.b(this);
        c.b bVar = new c.b();
        bVar.v(true);
        bVar.u(true);
        this.mDisplayImageOptions = bVar.t();
    }

    @Override // android.widget.ImageView, android.view.View
    @Deprecated
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void onLoadingCancelled(String str, View view) {
        com.nostra13.universalimageloader.core.k.c cVar = this.mSimpleImageLoadingListener;
        if (cVar != null) {
            cVar.onLoadingCancelled(str, view);
        }
    }

    public void onLoadingComplete(String str, View view, Bitmap bitmap) {
        com.nostra13.universalimageloader.core.k.c cVar = this.mSimpleImageLoadingListener;
        if (cVar != null) {
            cVar.onLoadingComplete(str, view, bitmap);
        }
    }

    public void onLoadingFailed(String str, View view, FailReason failReason) {
        com.nostra13.universalimageloader.core.k.c cVar = this.mSimpleImageLoadingListener;
        if (cVar != null) {
            cVar.onLoadingFailed(str, view, failReason);
        }
    }

    public void onLoadingStarted(String str, View view) {
        com.nostra13.universalimageloader.core.k.c cVar = this.mSimpleImageLoadingListener;
        if (cVar != null) {
            cVar.onLoadingStarted(str, view);
        }
    }

    @Override // com.nostra13.universalimageloader.core.k.b
    public void onProgressUpdate(String str, View view, int i2, int i3) {
        com.nostra13.universalimageloader.core.k.b bVar = this.mImageLoadingProgressListener;
        if (bVar != null) {
            bVar.onProgressUpdate(str, view, i2, i3);
        }
    }

    public void setCacheInMemory(boolean z) {
        if (z || this.mDisplayImageOptions.F()) {
            c.b bVar = new c.b();
            bVar.w(this.mDisplayImageOptions);
            bVar.u(z);
            this.mDisplayImageOptions = bVar.t();
        }
    }

    public void setCacheOnDisc(boolean z) {
        if (z || this.mDisplayImageOptions.G()) {
            c.b bVar = new c.b();
            bVar.w(this.mDisplayImageOptions);
            bVar.v(z);
            this.mDisplayImageOptions = bVar.t();
        }
    }

    public void setDisplayImageOptions(com.nostra13.universalimageloader.core.c cVar) {
        if (cVar != null) {
            this.mDisplayImageOptions = cVar;
        }
    }

    public void setDisplayer(com.nostra13.universalimageloader.core.i.a aVar) {
        if (aVar == null || this.mDisplayImageOptions.w() == aVar) {
            return;
        }
        c.b bVar = new c.b();
        bVar.w(this.mDisplayImageOptions);
        bVar.y(aVar);
        this.mDisplayImageOptions = bVar.t();
    }

    public void setImageByResouceId(int i2) {
        setImageUri(ParamItem.DRAWABLE_PREFIX + i2, this.mDisplayImageOptions);
    }

    public void setImageLoadingProgressListener(com.nostra13.universalimageloader.core.k.b bVar) {
        this.mImageLoadingProgressListener = bVar;
    }

    public void setImageUri(String str, boolean z) {
        if (z) {
            String str2 = TAG;
            us.pinguo.common.log.a.m(str2, "清除缓存 uri:" + str, new Object[0]);
            ImageLoader.getInstance().o().remove(e.b(str, new com.nostra13.universalimageloader.core.assist.c(this.mImageViewAware.getWidth(), this.mImageViewAware.getHeight())));
            ImageLoader.getInstance().m().remove(str);
        }
        setImageUri(str);
    }

    public void setImageViewAware(com.nostra13.universalimageloader.core.j.b bVar) {
        if (bVar != null && bVar.getWrappedView() == this) {
            this.mImageViewAware = bVar;
            return;
        }
        throw new RuntimeException("aware must wrap this imageview");
    }

    public void setIsPlugin(boolean z) {
        this.mIsPlugin = z;
    }

    public void setSimpleImageLoadingListener(com.nostra13.universalimageloader.core.k.c cVar) {
        this.mSimpleImageLoadingListener = cVar;
    }

    public void showImageForEmptyUri(int i2) {
        c.b bVar = new c.b();
        bVar.w(this.mDisplayImageOptions);
        bVar.F(getResDrawable(i2));
        this.mDisplayImageOptions = bVar.t();
    }

    public void showImageOnFail(int i2) {
        c.b bVar = new c.b();
        bVar.w(this.mDisplayImageOptions);
        bVar.H(getResDrawable(i2));
        this.mDisplayImageOptions = bVar.t();
    }

    public void showImageOnLoading(int i2) {
        c.b bVar = new c.b();
        bVar.w(this.mDisplayImageOptions);
        bVar.J(getResDrawable(i2));
        this.mDisplayImageOptions = bVar.t();
    }

    protected boolean tryLoadCache(String str, boolean z) {
        File file;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        com.nostra13.universalimageloader.core.assist.c cVar = new com.nostra13.universalimageloader.core.assist.c(this.mImageViewAware.getWidth(), this.mImageViewAware.getHeight());
        Bitmap bitmap = ImageLoader.getInstance().o().get(e.b(str, cVar));
        if (bitmap != null) {
            setImageBitmap(bitmap);
            com.nostra13.universalimageloader.core.k.c cVar2 = this.mSimpleImageLoadingListener;
            if (cVar2 != null) {
                cVar2.onLoadingComplete(str, this, bitmap);
            }
            return true;
        } else if (z && (file = ImageLoader.getInstance().m().get(str)) != null && file.exists()) {
            ImageLoader imageLoader = ImageLoader.getInstance();
            Bitmap v = imageLoader.v(InspirePublishFragment.FILE_HEADER + file.getAbsolutePath(), cVar, this.mDisplayImageOptions);
            setImageBitmap(v);
            com.nostra13.universalimageloader.core.k.c cVar3 = this.mSimpleImageLoadingListener;
            if (cVar3 != null) {
                cVar3.onLoadingComplete(str, this, v);
            }
            return true;
        } else {
            return false;
        }
    }

    public UilImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsPlugin = false;
        init(attributeSet);
    }

    public UilImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mIsPlugin = false;
        init(attributeSet);
    }

    public void setImageUri(String str, int i2) {
        String str2 = TAG;
        us.pinguo.common.log.a.m(str2, "setImageUri:" + str, new Object[0]);
        setImageUri(str, i2, false);
    }

    public void setImageUri(String str, int i2, boolean z) {
        if (!tryLoadCache(getProcessedUri(str), z)) {
            Drawable resDrawable = getResDrawable(i2);
            c.b bVar = new c.b();
            bVar.w(this.mDisplayImageOptions);
            bVar.F(resDrawable);
            bVar.J(resDrawable);
            bVar.H(resDrawable);
            com.nostra13.universalimageloader.core.c t = bVar.t();
            defaultDrawableLoaded(resDrawable);
            setImageUri(str, t);
        }
        String str2 = TAG;
        us.pinguo.common.log.a.m(str2, "成功加载缓存 uri:" + str, new Object[0]);
    }

    public void setImageUri(String str) {
        setImageUri(str, this.mDisplayImageOptions);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setImageUri(String str, com.nostra13.universalimageloader.core.c cVar) {
        String str2 = TAG;
        us.pinguo.common.log.a.m(str2, "display uri:" + str, new Object[0]);
        if (!TextUtils.isEmpty(str) && str.startsWith("https")) {
            str = str.replaceFirst("https", "http");
        }
        ImageLoader.getInstance().l(str, this.mImageViewAware, cVar, this, this);
        l0.a(this.mImageViewAware);
    }
}
