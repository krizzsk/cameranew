package us.pinguo.cameramanger.info;

import android.hardware.Camera;
import android.util.Rational;
import android.util.Size;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import us.pinguo.cameramanger.d;
import us.pinguo.util.n;
/* compiled from: CameraResolutionInfo.kt */
/* loaded from: classes4.dex */
public final class b {

    /* renamed from: d  reason: collision with root package name */
    public static final a f9775d = new a(null);

    /* renamed from: e  reason: collision with root package name */
    private static final int f9776e = n.d();
    private final List<Camera.Size> a;
    private final EnumMap<CameraFrame, Size> b;
    private final EnumMap<CameraFrame, Size> c;

    /* compiled from: CameraResolutionInfo.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }

        private final boolean b(boolean z, int i2, int i3) {
            return !z || i3 <= i2;
        }

        private final boolean c(Camera.Size size, Size size2, int i2, boolean z) {
            if (size2 == null) {
                return true;
            }
            return Math.abs(i2 - (z ? size.height : size.width)) < Math.abs(i2 - (z ? size2.getHeight() : size2.getWidth()));
        }

        private final boolean d(Camera.Size size, Size size2, Rational rational, int i2, boolean z) {
            if (size2 != null) {
                Rational rational2 = new Rational(size.width, size.height);
                Rational rational3 = new Rational(size2.getWidth(), size2.getHeight());
                if (!f(rational2, rational3)) {
                    if (Math.abs(rational.floatValue() - rational2.floatValue()) >= Math.abs(rational.floatValue() - rational3.floatValue())) {
                        return false;
                    }
                } else {
                    if (Math.abs(i2 - (z ? size.height : size.width)) >= Math.abs(i2 - (z ? size2.getHeight() : size2.getWidth()))) {
                        return false;
                    }
                }
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<Camera.Size> e(List<? extends Camera.Size> list, List<? extends Camera.Size> list2, Rational rational) {
            ArrayList arrayList = new ArrayList();
            for (Camera.Size size : list) {
                Rational rational2 = new Rational(size.width, size.height);
                if (!f(rational2, d.c()) && !f(rational2, d.b())) {
                    if (rational2.floatValue() - d.b().floatValue() >= -0.03f) {
                        Iterator<? extends Camera.Size> it = list2.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                Camera.Size next = it.next();
                                if (f(rational2, new Rational(next.width, next.height))) {
                                    arrayList.add(size);
                                    break;
                                }
                            }
                        }
                    }
                } else {
                    arrayList.add(size);
                }
            }
            return arrayList;
        }

        private final boolean f(Rational rational, Rational rational2) {
            return Math.abs(rational.floatValue() - rational2.floatValue()) < 0.03f;
        }

        private final void g(List<? extends Camera.Size> list, EnumMap<CameraFrame, Size> enumMap, Rational rational, int i2, boolean z, boolean z2) {
            for (Camera.Size size : list) {
                Rational rational2 = new Rational(size.width, size.height);
                int i3 = z ? size.height : size.width;
                if (rational2.compareTo(d.b()) > 0 && rational.compareTo(d.b()) > 0) {
                    if (b(z2, i2, i3)) {
                        CameraFrame cameraFrame = CameraFrame.FRAME_FULL;
                        if (d(size, enumMap.get(cameraFrame), rational, i2, z)) {
                            enumMap.put((EnumMap<CameraFrame, Size>) cameraFrame, (CameraFrame) new Size(size.width, size.height));
                        }
                    }
                } else if (f(rational2, d.b())) {
                    if (b(z2, i2, i3)) {
                        CameraFrame cameraFrame2 = CameraFrame.FRAME_16_9;
                        if (c(size, enumMap.get(cameraFrame2), i2, z)) {
                            enumMap.put((EnumMap<CameraFrame, Size>) cameraFrame2, (CameraFrame) new Size(size.width, size.height));
                        }
                    }
                } else if (f(rational2, d.c()) && b(z2, i2, i3)) {
                    CameraFrame cameraFrame3 = CameraFrame.FRAME_4_3;
                    if (c(size, enumMap.get(cameraFrame3), i2, z)) {
                        enumMap.put((EnumMap<CameraFrame, Size>) cameraFrame3, (CameraFrame) new Size(size.width, size.height));
                        enumMap.put((EnumMap<CameraFrame, Size>) CameraFrame.FRAME_1_1, (CameraFrame) new Size(size.width, size.height));
                    }
                }
            }
        }

        static /* synthetic */ void h(a aVar, List list, EnumMap enumMap, Rational rational, int i2, boolean z, boolean z2, int i3, Object obj) {
            aVar.g(list, enumMap, rational, i2, (i3 & 16) != 0 ? true : z, (i3 & 32) != 0 ? true : z2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(List<? extends Camera.Size> previewSizesAll, List<? extends Camera.Size> pictureSizesAll, Size screenSize) {
        s.h(previewSizesAll, "previewSizesAll");
        s.h(pictureSizesAll, "pictureSizesAll");
        s.h(screenSize, "screenSize");
        this.a = pictureSizesAll;
        EnumMap<CameraFrame, Size> enumMap = new EnumMap<>(CameraFrame.class);
        this.b = enumMap;
        EnumMap<CameraFrame, Size> enumMap2 = new EnumMap<>(CameraFrame.class);
        this.c = enumMap2;
        long currentTimeMillis = System.currentTimeMillis();
        int width = screenSize.getWidth() < screenSize.getHeight() ? screenSize.getWidth() : screenSize.getHeight();
        Rational rational = new Rational(screenSize.getWidth() > screenSize.getHeight() ? screenSize.getWidth() : screenSize.getHeight(), width);
        us.pinguo.common.log.a.c("屏幕尺寸:width=" + screenSize.getWidth() + ", height=" + screenSize.getHeight() + ", ration=" + rational + " -- " + rational.floatValue(), new Object[0]);
        us.pinguo.common.log.a.c("预览原始尺寸:", new Object[0]);
        d(previewSizesAll);
        us.pinguo.common.log.a.c("照片原始尺寸:", new Object[0]);
        d(pictureSizesAll);
        a aVar = f9775d;
        List<? extends Camera.Size> e2 = aVar.e(previewSizesAll, pictureSizesAll, rational);
        List<? extends Camera.Size> e3 = aVar.e(pictureSizesAll, e2, rational);
        us.pinguo.common.log.a.c("预览筛选尺寸:", new Object[0]);
        d(e2);
        us.pinguo.common.log.a.c("图片筛选尺寸:", new Object[0]);
        d(e3);
        a.h(aVar, e2, enumMap, rational, width, false, false, 48, null);
        a.h(aVar, e3, enumMap2, rational, f9776e, false, false, 32, null);
        e(enumMap, enumMap2);
        if (rational.doubleValue() + 0.03d < d.b().floatValue()) {
            us.pinguo.common.log.a.c("删除大于16:9的比例", new Object[0]);
            CameraFrame cameraFrame = CameraFrame.FRAME_16_9;
            enumMap.remove(cameraFrame);
            enumMap2.remove(cameraFrame);
            CameraFrame cameraFrame2 = CameraFrame.FRAME_FULL;
            enumMap.remove(cameraFrame2);
            enumMap2.remove(cameraFrame2);
        }
        us.pinguo.common.log.a.c("筛选完成consume:" + (System.currentTimeMillis() - currentTimeMillis) + ", targetPreviewSize=" + enumMap + ", targetPictureSize=" + enumMap2, new Object[0]);
    }

    private final void d(List<? extends Camera.Size> list) {
        us.pinguo.common.log.a.c(s.q("printSizeInfo length:", Integer.valueOf(list.size())), new Object[0]);
        for (Camera.Size size : list) {
            us.pinguo.common.log.a.c("size:" + size.width + " x " + size.height + " -- " + new Rational(size.width, size.height) + " -- " + (size.width / size.height), new Object[0]);
        }
    }

    private final void e(EnumMap<CameraFrame, Size> enumMap, EnumMap<CameraFrame, Size> enumMap2) {
        ArrayList<CameraFrame> arrayList = new ArrayList();
        Iterator it = enumMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (!enumMap2.containsKey(entry.getKey())) {
                arrayList.add(entry.getKey());
            }
        }
        for (CameraFrame cameraFrame : arrayList) {
            enumMap.remove(cameraFrame);
            enumMap2.remove(cameraFrame);
        }
    }

    public final List<Camera.Size> a() {
        return this.a;
    }

    public final EnumMap<CameraFrame, Size> b() {
        return this.c;
    }

    public final EnumMap<CameraFrame, Size> c() {
        return this.b;
    }
}
