package com.nostra13.universalimageloader.core.h;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import d.f.a.b.d;
import java.io.IOException;
import java.io.InputStream;
/* compiled from: BaseImageDecoder.java */
/* loaded from: classes3.dex */
public class a implements com.nostra13.universalimageloader.core.h.b {
    protected final boolean a;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: BaseImageDecoder.java */
    /* loaded from: classes3.dex */
    public static class b {
        public final com.nostra13.universalimageloader.core.assist.c a;
        public final C0227a b;

        protected b(com.nostra13.universalimageloader.core.assist.c cVar, C0227a c0227a) {
            this.a = cVar;
            this.b = c0227a;
        }
    }

    public a(boolean z) {
        this.a = z;
    }

    private boolean b(String str, String str2) {
        return "image/jpeg".equalsIgnoreCase(str2) && ImageDownloader.Scheme.ofUri(str) == ImageDownloader.Scheme.FILE;
    }

    @Override // com.nostra13.universalimageloader.core.h.b
    public Bitmap a(c cVar) throws IOException {
        InputStream f2 = f(cVar);
        try {
            b e2 = e(f2, cVar);
            f2 = h(f2, cVar);
            Bitmap decodeStream = BitmapFactory.decodeStream(f2, null, g(e2.a, cVar));
            if (decodeStream == null) {
                d.b("Image can't be decoded [%s]", cVar.g());
                return decodeStream;
            }
            C0227a c0227a = e2.b;
            return c(decodeStream, cVar, c0227a.a, c0227a.b);
        } finally {
            d.f.a.b.c.a(f2);
        }
    }

    protected Bitmap c(Bitmap bitmap, c cVar, int i2, boolean z) {
        Matrix matrix = new Matrix();
        ImageScaleType h2 = cVar.h();
        if (h2 == ImageScaleType.EXACTLY || h2 == ImageScaleType.EXACTLY_STRETCHED) {
            com.nostra13.universalimageloader.core.assist.c cVar2 = new com.nostra13.universalimageloader.core.assist.c(bitmap.getWidth(), bitmap.getHeight(), i2);
            float b2 = d.f.a.b.b.b(cVar2, cVar.j(), cVar.k(), h2 == ImageScaleType.EXACTLY_STRETCHED);
            if (Float.compare(b2, 1.0f) != 0) {
                matrix.setScale(b2, b2);
                if (this.a) {
                    d.a("Scale subsampled image (%1$s) to %2$s (scale = %3$.5f) [%4$s]", cVar2, cVar2.c(b2), Float.valueOf(b2), cVar.g());
                }
            }
        }
        if (z) {
            matrix.postScale(-1.0f, 1.0f);
            if (this.a) {
                d.a("Flip image horizontally [%s]", cVar.g());
            }
        }
        if (i2 != 0) {
            matrix.postRotate(i2);
            if (this.a) {
                d.a("Rotate image on %1$d° [%2$s]", Integer.valueOf(i2), cVar.g());
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (createBitmap != bitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    protected C0227a d(String str) {
        int i2 = 0;
        boolean z = 1;
        try {
        } catch (IOException unused) {
            d.f("Can't read EXIF tags from file [%s]", str);
        }
        switch (new ExifInterface(ImageDownloader.Scheme.FILE.crop(str)).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1)) {
            case 1:
            default:
                z = 0;
                break;
            case 2:
                break;
            case 3:
                z = i2;
                i2 = BaseBlurEffect.ROTATION_180;
                break;
            case 4:
                i2 = 1;
                z = i2;
                i2 = BaseBlurEffect.ROTATION_180;
                break;
            case 5:
                i2 = 1;
                z = i2;
                i2 = BaseBlurEffect.ROTATION_270;
                break;
            case 6:
                z = i2;
                i2 = 90;
                break;
            case 7:
                i2 = 1;
                z = i2;
                i2 = 90;
                break;
            case 8:
                z = i2;
                i2 = BaseBlurEffect.ROTATION_270;
                break;
        }
        return new C0227a(i2, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b e(InputStream inputStream, c cVar) throws IOException {
        C0227a c0227a;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, options);
        String i2 = cVar.i();
        if (cVar.l() && b(i2, options.outMimeType)) {
            c0227a = d(i2);
        } else {
            c0227a = new C0227a();
        }
        return new b(new com.nostra13.universalimageloader.core.assist.c(options.outWidth, options.outHeight, c0227a.a), c0227a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public InputStream f(c cVar) throws IOException {
        return cVar.e().a(cVar.i(), cVar.f());
    }

    protected BitmapFactory.Options g(com.nostra13.universalimageloader.core.assist.c cVar, c cVar2) {
        int a;
        ImageScaleType h2 = cVar2.h();
        if (h2 == ImageScaleType.NONE) {
            a = 1;
        } else if (h2 == ImageScaleType.NONE_SAFE) {
            a = d.f.a.b.b.c(cVar);
        } else {
            a = d.f.a.b.b.a(cVar, cVar2.j(), cVar2.k(), h2 == ImageScaleType.IN_SAMPLE_POWER_OF_2);
        }
        if (a > 1 && this.a) {
            d.a("Subsample original image (%1$s) to %2$s (scale = %3$d) [%4$s]", cVar, cVar.d(a), Integer.valueOf(a), cVar2.g());
        }
        BitmapFactory.Options d2 = cVar2.d();
        d2.inSampleSize = a;
        return d2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public InputStream h(InputStream inputStream, c cVar) throws IOException {
        try {
            inputStream.reset();
            return inputStream;
        } catch (IOException unused) {
            d.f.a.b.c.a(inputStream);
            return f(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: BaseImageDecoder.java */
    /* renamed from: com.nostra13.universalimageloader.core.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0227a {
        public final int a;
        public final boolean b;

        protected C0227a() {
            this.a = 0;
            this.b = false;
        }

        protected C0227a(int i2, boolean z) {
            this.a = i2;
            this.b = z;
        }
    }
}
