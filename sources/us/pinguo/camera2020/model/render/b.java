package us.pinguo.camera2020.model.render;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Size;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import java.io.File;
import kotlin.Pair;
import kotlin.jvm.b.q;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.processor.d;
import us.pinguo.processor.e;
import us.pinguo.processor.i;
import us.pinguo.repository2020.m;
import us.pinguo.repository2020.utils.k;
import us.pinguo.u3dengine.api.HDCameraSessionResult;
import us.pinguo.u3dengine.api.NativeFacesData;
import us.pinguo.u3dengine.api.UnityMethodCaller;
/* compiled from: CaptureRenderManager.kt */
/* loaded from: classes3.dex */
public final class b {
    private byte[] b;
    private String c;

    /* renamed from: e  reason: collision with root package name */
    private a f9195e;

    /* renamed from: f  reason: collision with root package name */
    private us.pinguo.camera2020.utils.c<Integer> f9196f;

    /* renamed from: g  reason: collision with root package name */
    private us.pinguo.camera2020.utils.c<HDCameraSessionResult> f9197g;

    /* renamed from: i  reason: collision with root package name */
    private q<? super Boolean, ? super Boolean, ? super String, u> f9199i;
    private NativeFacesData a = new NativeFacesData();

    /* renamed from: d  reason: collision with root package name */
    private final HDCameraSessionResult f9194d = new HDCameraSessionResult();

    /* renamed from: h  reason: collision with root package name */
    private d f9198h = e.a();

    /* compiled from: CaptureRenderManager.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private final int a;
        private final int b;
        private final int c;

        public a(int i2, int i3, int i4) {
            this.a = i2;
            this.b = i3;
            this.c = i4;
        }

        public final int a() {
            return this.c;
        }

        public final int b() {
            return this.a;
        }

        public final int c() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.a == aVar.a && this.b == aVar.b && this.c == aVar.c;
            }
            return false;
        }

        public int hashCode() {
            return (((this.a * 31) + this.b) * 31) + this.c;
        }

        public String toString() {
            return "TextureInfo(textureId=" + this.a + ", width=" + this.b + ", height=" + this.c + ')';
        }
    }

    private final int h(int i2, boolean z) {
        return i2 != 90 ? i2 != 180 ? i2 != 270 ? 0 : 90 : BaseBlurEffect.ROTATION_180 : BaseBlurEffect.ROTATION_270;
    }

    public final Bitmap a(Bitmap bitmap) {
        s.h(bitmap, "bitmap");
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i2 = width >= height ? height : width;
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, (width - i2) / 2, (height - i2) / 2, i2, i2);
        s.g(createBitmap, "createBitmap(bitmap, (w … 2, cropWidth, cropWidth)");
        return createBitmap;
    }

    public final void b() {
        a aVar = this.f9195e;
        if (aVar == null) {
            return;
        }
        d e2 = e();
        i iVar = i.a;
        boolean i2 = iVar.i(e2);
        q<Boolean, Boolean, String, u> i3 = i();
        if (i3 != null) {
            i3.invoke(Boolean.TRUE, Boolean.valueOf(i2), null);
        }
        m mVar = m.a;
        Boolean value = mVar.j().getValue();
        Boolean bool = Boolean.FALSE;
        Pair<Integer, String> h2 = iVar.h(aVar.b(), new Size(aVar.c(), aVar.a()), e2, s.c(value, bool) && s.c(mVar.y().getValue(), Boolean.TRUE), i2);
        int intValue = h2.getFirst().intValue();
        String second = h2.getSecond();
        if (intValue == 0) {
            us.pinguo.camera2020.utils.c<Integer> cVar = this.f9196f;
            if (cVar != null) {
                cVar.c(Integer.valueOf(aVar.b()));
            }
        } else {
            us.pinguo.camera2020.utils.c<Integer> cVar2 = this.f9196f;
            if (cVar2 != null) {
                cVar2.c(Integer.valueOf(intValue));
            }
        }
        q<Boolean, Boolean, String, u> i4 = i();
        if (i4 == null) {
            return;
        }
        i4.invoke(bool, Boolean.valueOf(i2), second);
    }

    public final HDCameraSessionResult c() {
        us.pinguo.camera2020.utils.c<HDCameraSessionResult> cVar = this.f9197g;
        HDCameraSessionResult hDCameraSessionResult = cVar != null ? (HDCameraSessionResult) us.pinguo.camera2020.utils.c.e(cVar, 0L, 1, null) : null;
        return hDCameraSessionResult == null ? new HDCameraSessionResult() : hDCameraSessionResult;
    }

    public final HDCameraSessionResult d() {
        return this.f9194d;
    }

    public final d e() {
        return this.f9198h;
    }

    public final NativeFacesData f() {
        return this.a;
    }

    public final int g() {
        Integer num;
        us.pinguo.camera2020.utils.c<Integer> cVar = this.f9196f;
        if (cVar == null || (num = (Integer) us.pinguo.camera2020.utils.c.e(cVar, 0L, 1, null)) == null) {
            return -1;
        }
        return num.intValue();
    }

    public final q<Boolean, Boolean, String, u> i() {
        return this.f9199i;
    }

    public final int j(boolean z, boolean z2, int i2, int i3, boolean z3) {
        Bitmap decodeFile;
        boolean z4;
        us.pinguo.common.log.a.c("takePicture-start make Capture Texture", new Object[0]);
        int i4 = -1;
        boolean z5 = true;
        if (this.b == null && this.c == null) {
            if (!z || !z2) {
                this.f9194d.setCaputureMirrorState(0);
            } else if (i2 != 90 && i2 != 270) {
                this.f9194d.setCaputureMirrorState(1);
            } else {
                this.f9194d.setCaputureMirrorState(2);
            }
            us.pinguo.camera2020.utils.c<HDCameraSessionResult> cVar = this.f9197g;
            if (cVar != null) {
                cVar.c(this.f9194d);
            }
        } else {
            us.pinguo.common.log.a.c("takePicture-start before decode", new Object[0]);
            if (this.b != null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                byte[] bArr = this.b;
                s.e(bArr);
                BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                us.pinguo.common.log.a.c(s.q("max texture size = ", 5000), new Object[0]);
                if (options.outWidth > 5000 || options.outHeight > 5000) {
                    options.inSampleSize = 2;
                }
                options.inJustDecodeBounds = false;
                byte[] bArr2 = this.b;
                s.e(bArr2);
                decodeFile = BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length, options);
                z4 = true;
            } else if (this.c != null && new File(this.c).exists()) {
                decodeFile = BitmapFactory.decodeFile(this.c);
                z4 = false;
            } else {
                this.f9194d.setInputTextureID(-1);
                us.pinguo.camera2020.utils.c<HDCameraSessionResult> cVar2 = this.f9197g;
                if (cVar2 != null) {
                    cVar2.c(this.f9194d);
                }
                return -1;
            }
            if (decodeFile == null) {
                return -1;
            }
            us.pinguo.common.log.a.c("takePicture-start after decode", new Object[0]);
            this.b = null;
            this.c = null;
            if (z3) {
                decodeFile = a(decodeFile);
            }
            us.pinguo.common.log.a.c("takePicture-start after crop", new Object[0]);
            if (z4) {
                int a2 = us.pinguo.camera2020.utils.a.a.a(z, i3, i2);
                us.pinguo.facedetector.c q = k.a.q(decodeFile, a2);
                if (q == null) {
                    q = new us.pinguo.facedetector.c(new us.pinguo.facedetector.b[0], 0, 0);
                }
                us.pinguo.facedetector.c.b(q, (a2 + BaseBlurEffect.ROTATION_180) % BaseBlurEffect.ROTATION_360, !z ? 1 : 0, 0, 0, 12, null);
                q.i();
                this.a = us.pinguo.repository2020.utils.i.d(q, z, i2 == 90 || i2 == 270);
            }
            us.pinguo.common.log.a.c("takePicture-start after face detect", new Object[0]);
            i4 = us.pinguo.processor.b.b(decodeFile, us.pinguo.processor.b.c(), false, 4, null);
            us.pinguo.common.log.a.c("takePicture-start after bind texture", new Object[0]);
            HDCameraSessionResult hDCameraSessionResult = this.f9194d;
            hDCameraSessionResult.setCameraPressent(z ? 1 : 0);
            if (i2 != 90 && i2 != 270) {
                hDCameraSessionResult.setTextureWidth(decodeFile.getHeight());
                hDCameraSessionResult.setTextureHeight(decodeFile.getWidth());
                hDCameraSessionResult.setOutputWidth(decodeFile.getHeight());
                hDCameraSessionResult.setOutputHeight(decodeFile.getWidth());
            } else {
                hDCameraSessionResult.setTextureWidth(decodeFile.getWidth());
                hDCameraSessionResult.setTextureHeight(decodeFile.getHeight());
                hDCameraSessionResult.setOutputWidth(decodeFile.getWidth());
                hDCameraSessionResult.setOutputHeight(decodeFile.getHeight());
            }
            hDCameraSessionResult.setInputTextureID(i4);
            if (z4) {
                hDCameraSessionResult.setVerFlip(!z ? 1 : 0);
                hDCameraSessionResult.setRotation((i3 + BaseBlurEffect.ROTATION_180) - i2);
                if (z && z2) {
                    hDCameraSessionResult.setMirrorState(1);
                    hDCameraSessionResult.setCaputureMirrorState(1);
                } else {
                    hDCameraSessionResult.setMirrorState(0);
                    hDCameraSessionResult.setCaputureMirrorState(0);
                }
            } else {
                hDCameraSessionResult.setVerFlip(1);
                hDCameraSessionResult.setRotation(h(i2, (z && z2) ? false : false));
                hDCameraSessionResult.setMirrorState(0);
                hDCameraSessionResult.setCaputureMirrorState(0);
            }
            hDCameraSessionResult.setLength(100);
            us.pinguo.common.log.a.c("takePicture-start after apply", new Object[0]);
            us.pinguo.camera2020.utils.c<HDCameraSessionResult> cVar3 = this.f9197g;
            if (cVar3 != null) {
                cVar3.c(this.f9194d);
            }
            us.pinguo.common.log.a.c("takePicture-start after set capture session result", new Object[0]);
        }
        return i4;
    }

    public final void k() {
        this.f9197g = new us.pinguo.camera2020.utils.c<>();
    }

    public final void l(int i2, int i3, int i4) {
        this.f9195e = new a(i2, i3, i4);
        this.f9196f = new us.pinguo.camera2020.utils.c<>();
    }

    public final void m(d dVar) {
        s.h(dVar, "<set-?>");
        this.f9198h = dVar;
    }

    public final void n(q<? super Boolean, ? super Boolean, ? super String, u> qVar) {
        this.f9199i = qVar;
    }

    public final void o(int i2, String imagePath) {
        s.h(imagePath, "imagePath");
        this.b = null;
        this.c = imagePath;
        UnityMethodCaller.startCaptureRender();
    }

    public final void p(int i2, byte[] jpegData) {
        s.h(jpegData, "jpegData");
        this.b = jpegData;
        this.c = null;
        UnityMethodCaller.startCaptureRender();
    }
}
