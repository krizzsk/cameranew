package us.pinguo.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import com.nostra13.universalimageloader.core.assist.c;
import us.pinguo.foundation.t.b.b;
import us.pinguo.util.n;
/* compiled from: CenterCropDecoder.java */
/* loaded from: classes6.dex */
public class a extends com.nostra13.universalimageloader.core.h.a {
    private static final String c = "a";

    /* renamed from: d  reason: collision with root package name */
    private static int f12092d = n.d();
    private Context b;

    /* compiled from: CenterCropDecoder.java */
    /* renamed from: us.pinguo.ui.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0453a {
        public boolean a = true;
        public boolean b = false;
        public boolean c = true;

        /* renamed from: d  reason: collision with root package name */
        public boolean f12093d = false;

        /* renamed from: e  reason: collision with root package name */
        public int f12094e = 0;

        /* renamed from: f  reason: collision with root package name */
        public boolean f12095f = true;

        public static C0453a a() {
            return new C0453a();
        }

        public C0453a b(boolean z) {
            this.b = z;
            return this;
        }

        public C0453a c(boolean z) {
            this.f12093d = z;
            return this;
        }

        public C0453a d(boolean z) {
            this.a = z;
            return this;
        }

        public C0453a e(boolean z) {
            this.c = z;
            return this;
        }
    }

    public a(Context context, boolean z) {
        super(z);
        this.b = context;
    }

    private Bitmap j(String str, c cVar, boolean z) {
        String path = Uri.parse(str).getPath();
        Bitmap i2 = i(path);
        if (i2 == null) {
            us.pinguo.common.log.a.e("获取:" + path + "缩略图失败", new Object[0]);
        }
        if (i2 != null) {
            us.pinguo.common.log.a.k("获取:" + path + "缩略图成功", new Object[0]);
            if (i2.getWidth() * i2.getHeight() > cVar.b() * cVar.a()) {
                i2 = b.g(i2, cVar.b(), cVar.a());
            }
            if (z) {
                Rect rect = new Rect();
                b.b(rect, i2.getWidth(), i2.getHeight(), cVar.b(), cVar.a());
                return b.e(i2, rect);
            }
            return i2;
        }
        return i2;
    }

    private Bitmap k(Bitmap bitmap, float f2, float f3, int i2) {
        if (bitmap == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(f2, f3);
        if (i2 != 0) {
            matrix.postRotate(i2);
        }
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:142:0x02cb, code lost:
        if (r3.b == false) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x02cd, code lost:
        us.pinguo.foundation.t.b.b.b(r12, r14.getWidth(), r14.getHeight(), r9.b(), r9.a());
        r14 = us.pinguo.foundation.t.b.b.e(r14, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x02e8, code lost:
        if (r3.c == false) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x02ea, code lost:
        r14 = us.pinguo.foundation.t.b.b.f(r14, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x02f1, code lost:
        return r14;
     */
    @Override // com.nostra13.universalimageloader.core.h.a, com.nostra13.universalimageloader.core.h.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.graphics.Bitmap a(com.nostra13.universalimageloader.core.h.c r20) throws java.io.IOException, java.lang.OutOfMemoryError {
        /*
            Method dump skipped, instructions count: 759
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.ui.a.a(com.nostra13.universalimageloader.core.h.c):android.graphics.Bitmap");
    }

    public Bitmap i(String str) {
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
        } catch (IllegalArgumentException | OutOfMemoryError | RuntimeException unused3) {
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
}
