package pl.droidsonroids.gif;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Surface;
import android.view.TextureView;
import android.widget.ImageView;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.IOException;
import java.lang.ref.WeakReference;
import pl.droidsonroids.gif.f;
@RequiresApi(14)
/* loaded from: classes3.dex */
public class GifTextureView extends TextureView {

    /* renamed from: g  reason: collision with root package name */
    private static final ImageView.ScaleType[] f8973g = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    private ImageView.ScaleType a;
    private final Matrix b;
    private f c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f8974d;

    /* renamed from: e  reason: collision with root package name */
    private c f8975e;

    /* renamed from: f  reason: collision with root package name */
    private float f8976f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(Canvas canvas);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class c extends Thread implements TextureView.SurfaceTextureListener {
        final pl.droidsonroids.gif.b a;
        private GifInfoHandle b;
        long[] c;

        /* renamed from: d  reason: collision with root package name */
        private final WeakReference<GifTextureView> f8977d;

        /* loaded from: classes3.dex */
        class a implements Runnable {
            final /* synthetic */ GifTextureView a;

            a(GifTextureView gifTextureView) {
                this.a = gifTextureView;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.h(c.this.b);
            }
        }

        c(GifTextureView gifTextureView) {
            super("GifRenderThread");
            this.a = new pl.droidsonroids.gif.b();
            this.b = new GifInfoHandle();
            this.f8977d = new WeakReference<>(gifTextureView);
        }

        void b(@NonNull GifTextureView gifTextureView, @Nullable b bVar) {
            this.a.b();
            gifTextureView.g(bVar != null ? new i(bVar) : null);
            this.b.postUnbindSurface();
            interrupt();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            GifTextureView gifTextureView = this.f8977d.get();
            if (gifTextureView != null) {
                gifTextureView.h(this.b);
            }
            this.a.c();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.a.b();
            this.b.postUnbindSurface();
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                GifTextureView gifTextureView = this.f8977d.get();
                if (gifTextureView == null) {
                    return;
                }
                GifInfoHandle a2 = gifTextureView.c.a();
                this.b = a2;
                a2.setOptions((char) 1, gifTextureView.isOpaque());
                GifTextureView gifTextureView2 = this.f8977d.get();
                if (gifTextureView2 != null) {
                    gifTextureView2.g(this);
                    boolean isAvailable = gifTextureView2.isAvailable();
                    this.a.d(isAvailable);
                    if (isAvailable) {
                        gifTextureView2.post(new a(gifTextureView2));
                    }
                    this.b.setSpeedFactor(gifTextureView2.f8976f);
                    while (!isInterrupted()) {
                        try {
                            this.a.a();
                            SurfaceTexture surfaceTexture = gifTextureView2.getSurfaceTexture();
                            if (surfaceTexture != null) {
                                Surface surface = new Surface(surfaceTexture);
                                try {
                                    this.b.bindSurface(surface, this.c);
                                } finally {
                                    surface.release();
                                    surfaceTexture.release();
                                }
                            }
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    this.b.recycle();
                    this.b = new GifInfoHandle();
                    return;
                }
                this.b.recycle();
            } catch (IOException unused2) {
            }
        }
    }

    public GifTextureView(Context context) {
        super(context);
        this.a = ImageView.ScaleType.FIT_CENTER;
        this.b = new Matrix();
        this.f8976f = 1.0f;
        f(null, 0, 0);
    }

    private static f e(TypedArray typedArray) {
        TypedValue typedValue = new TypedValue();
        if (typedArray.getValue(R.styleable.GifTextureView_gifSource, typedValue)) {
            if (typedValue.resourceId != 0) {
                String resourceTypeName = typedArray.getResources().getResourceTypeName(typedValue.resourceId);
                if (e.a.contains(resourceTypeName)) {
                    return new f.c(typedArray.getResources(), typedValue.resourceId);
                }
                if (!TypedValues.Custom.S_STRING.equals(resourceTypeName)) {
                    throw new IllegalArgumentException("Expected string, drawable, mipmap or raw resource type. '" + resourceTypeName + "' is not supported");
                }
            }
            return new f.b(typedArray.getResources().getAssets(), typedValue.string.toString());
        }
        return null;
    }

    private void f(AttributeSet attributeSet, int i2, int i3) {
        if (attributeSet != null) {
            int attributeIntValue = attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "scaleType", -1);
            if (attributeIntValue >= 0) {
                ImageView.ScaleType[] scaleTypeArr = f8973g;
                if (attributeIntValue < scaleTypeArr.length) {
                    this.a = scaleTypeArr[attributeIntValue];
                }
            }
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.GifTextureView, i2, i3);
            this.c = e(obtainStyledAttributes);
            super.setOpaque(obtainStyledAttributes.getBoolean(R.styleable.GifTextureView_isOpaque, false));
            obtainStyledAttributes.recycle();
            this.f8974d = e.d(this, attributeSet, i2, i3);
        } else {
            super.setOpaque(false);
        }
        if (isInEditMode()) {
            return;
        }
        c cVar = new c(this);
        this.f8975e = cVar;
        if (this.c != null) {
            cVar.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(TextureView.SurfaceTextureListener surfaceTextureListener) {
        super.setSurfaceTextureListener(surfaceTextureListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(GifInfoHandle gifInfoHandle) {
        Matrix matrix = new Matrix();
        float width = getWidth();
        float height = getHeight();
        float width2 = gifInfoHandle.getWidth() / width;
        float height2 = gifInfoHandle.getHeight() / height;
        RectF rectF = new RectF(0.0f, 0.0f, gifInfoHandle.getWidth(), gifInfoHandle.getHeight());
        RectF rectF2 = new RectF(0.0f, 0.0f, width, height);
        float f2 = 1.0f;
        switch (a.a[this.a.ordinal()]) {
            case 1:
                matrix.setScale(width2, height2, width / 2.0f, height / 2.0f);
                break;
            case 2:
                float min = 1.0f / Math.min(width2, height2);
                matrix.setScale(width2 * min, min * height2, width / 2.0f, height / 2.0f);
                break;
            case 3:
                if (gifInfoHandle.getWidth() > width || gifInfoHandle.getHeight() > height) {
                    f2 = Math.min(1.0f / width2, 1.0f / height2);
                }
                matrix.setScale(width2 * f2, f2 * height2, width / 2.0f, height / 2.0f);
                break;
            case 4:
                matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
                matrix.preScale(width2, height2);
                break;
            case 5:
                matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
                matrix.preScale(width2, height2);
                break;
            case 6:
                matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
                matrix.preScale(width2, height2);
                break;
            case 7:
                return;
            case 8:
                matrix.set(this.b);
                matrix.preScale(width2, height2);
                break;
        }
        super.setTransform(matrix);
    }

    @Override // android.view.TextureView
    public TextureView.SurfaceTextureListener getSurfaceTextureListener() {
        return null;
    }

    @Override // android.view.TextureView
    public Matrix getTransform(Matrix matrix) {
        if (matrix == null) {
            matrix = new Matrix();
        }
        matrix.set(this.b);
        return matrix;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        this.f8975e.b(this, null);
        super.onDetachedFromWindow();
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof GifViewSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        GifViewSavedState gifViewSavedState = (GifViewSavedState) parcelable;
        super.onRestoreInstanceState(gifViewSavedState.getSuperState());
        this.f8975e.c = gifViewSavedState.a[0];
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        c cVar = this.f8975e;
        cVar.c = cVar.b.getSavedState();
        return new GifViewSavedState(super.onSaveInstanceState(), this.f8974d ? this.f8975e.c : null);
    }

    public void setFreezesAnimation(boolean z) {
        this.f8974d = z;
    }

    public void setImageMatrix(Matrix matrix) {
        setTransform(matrix);
    }

    public synchronized void setInputSource(@Nullable f fVar) {
        setInputSource(fVar, null);
    }

    @Override // android.view.TextureView
    public void setOpaque(boolean z) {
        if (z != isOpaque()) {
            super.setOpaque(z);
            setInputSource(this.c);
        }
    }

    public void setScaleType(@NonNull ImageView.ScaleType scaleType) {
        this.a = scaleType;
        h(this.f8975e.b);
    }

    public void setSpeed(@FloatRange(from = 0.0d, fromInclusive = false) float f2) {
        this.f8976f = f2;
        this.f8975e.b.setSpeedFactor(f2);
    }

    @Override // android.view.TextureView
    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        throw new UnsupportedOperationException("Changing SurfaceTexture is not supported");
    }

    @Override // android.view.TextureView
    public void setSurfaceTextureListener(TextureView.SurfaceTextureListener surfaceTextureListener) {
        throw new UnsupportedOperationException("Changing SurfaceTextureListener is not supported");
    }

    @Override // android.view.TextureView
    public void setTransform(Matrix matrix) {
        this.b.set(matrix);
        h(this.f8975e.b);
    }

    public synchronized void setInputSource(@Nullable f fVar, @Nullable b bVar) {
        this.f8975e.b(this, bVar);
        this.c = fVar;
        c cVar = new c(this);
        this.f8975e = cVar;
        if (fVar != null) {
            cVar.start();
        }
    }

    public GifTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = ImageView.ScaleType.FIT_CENTER;
        this.b = new Matrix();
        this.f8976f = 1.0f;
        f(attributeSet, 0, 0);
    }

    public GifTextureView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = ImageView.ScaleType.FIT_CENTER;
        this.b = new Matrix();
        this.f8976f = 1.0f;
        f(attributeSet, i2, 0);
    }
}
