package us.pinguo.camera2020.module.frame;

import android.content.Context;
import android.content.res.Resources;
import android.util.Size;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.j;
import kotlin.jvm.internal.s;
import us.pinguo.camera2020.R;
import us.pinguo.cameramanger.info.CameraFrame;
import us.pinguo.cameramanger.info.LensFacing;
import us.pinguo.common.h;
import us.pinguo.foundation.d;
import us.pinguo.foundation.e;
import us.pinguo.repository2020.m;
import us.pinguo.repository2020.u;
import us.pinguo.util.g;
/* compiled from: FrameRatioModule.kt */
/* loaded from: classes3.dex */
public final class FrameRatioModule implements LifecycleObserver {

    /* renamed from: d  reason: collision with root package name */
    private int f9225d;

    /* renamed from: e  reason: collision with root package name */
    private int f9226e;

    /* renamed from: g  reason: collision with root package name */
    private EnumMap<CameraFrame, Size> f9228g;

    /* renamed from: i  reason: collision with root package name */
    private EnumMap<CameraFrame, a> f9230i;

    /* renamed from: j  reason: collision with root package name */
    private Size f9231j;
    private a m;
    private final u<CameraFrame> a = m.a.e();
    private int b = e.b().getResources().getDimensionPixelSize(R.dimen.camera_bottom_base_height);
    private int c = e.b().getResources().getDimensionPixelSize(R.dimen.view_finder_bottom_video_photo_switch_area_height);

    /* renamed from: f  reason: collision with root package name */
    private final EnumMap<LensFacing, EnumMap<CameraFrame, Size>> f9227f = new EnumMap<>(LensFacing.class);

    /* renamed from: h  reason: collision with root package name */
    private final EnumMap<LensFacing, EnumMap<CameraFrame, a>> f9229h = new EnumMap<>(LensFacing.class);

    /* renamed from: k  reason: collision with root package name */
    private ArrayList<h> f9232k = new ArrayList<>(3);

    /* renamed from: l  reason: collision with root package name */
    private boolean f9233l = true;

    private final void j(int i2) {
        EnumMap<CameraFrame, a> enumMap;
        Context context;
        int i3;
        int i4;
        int width;
        EnumMap<CameraFrame, Size> enumMap2 = this.f9228g;
        if (enumMap2 == null || (enumMap = this.f9230i) == null || (!enumMap.isEmpty())) {
            return;
        }
        Context context2 = e.b();
        Resources resources = context2.getResources();
        s.g(context2, "context");
        int g2 = us.pinguo.util.h.g(context2);
        int i5 = us.pinguo.util.h.i(context2);
        if (d.f10985d) {
            us.pinguo.util.h.e(context2);
            us.pinguo.util.h.h(context2);
            us.pinguo.util.h.f(context2);
            resources.getDimension(R.dimen.dp1);
        }
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.view_finder_top_bar_height);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.view_finder_top_bar_extend);
        int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.view_finder_bottom_black_safe_area_height);
        int dimensionPixelSize4 = resources.getDimensionPixelSize(R.dimen.upper_black_extra_height_max_16x9_full);
        int dimensionPixelSize5 = resources.getDimensionPixelSize(R.dimen.effect_tab_height);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = enumMap2.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            CameraFrame cameraFrame = (CameraFrame) entry.getKey();
            Iterator it2 = it;
            if (cameraFrame == CameraFrame.FRAME_16_9 || cameraFrame == CameraFrame.FRAME_FULL) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
            it = it2;
        }
        int i6 = this.f9225d;
        Iterator it3 = linkedHashMap.entrySet().iterator();
        while (it3.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it3.next();
            a aVar = new a();
            Size size = (Size) entry2.getValue();
            Iterator it4 = it3;
            Context context3 = context2;
            if (entry2.getKey() == CameraFrame.FRAME_FULL) {
                float f2 = i5;
                i4 = dimensionPixelSize2;
                float f3 = g2;
                i3 = dimensionPixelSize5;
                float min = Math.min(f2 / size.getHeight(), f3 / size.getWidth());
                aVar.e((int) ((f2 - (size.getHeight() * min)) * 0.5f));
                width = (int) (f3 - (min * size.getWidth()));
            } else {
                i3 = dimensionPixelSize5;
                i4 = dimensionPixelSize2;
                width = (int) (g2 - (i5 * (size.getWidth() / size.getHeight())));
            }
            if (width < i2) {
                aVar.h(0);
                aVar.f(Integer.valueOf(width));
                if (width > i6) {
                    i6 = width;
                }
                enumMap.put((EnumMap<CameraFrame, a>) entry2.getKey(), aVar);
            } else if (width == i2) {
                aVar.h(Integer.valueOf(i2));
                aVar.f(0);
                enumMap.put((EnumMap<CameraFrame, a>) entry2.getKey(), aVar);
            } else if (width <= i2 || width >= i2 + dimensionPixelSize) {
                int i7 = i2 + dimensionPixelSize;
                if (width < i7 || width > i7 + dimensionPixelSize3) {
                    int i8 = i7 + dimensionPixelSize3;
                    if (width >= i8 && width <= i8 + dimensionPixelSize4) {
                        aVar.h(Integer.valueOf(width - dimensionPixelSize3));
                        aVar.f(Integer.valueOf(dimensionPixelSize3));
                        if (dimensionPixelSize3 > i6) {
                            i6 = dimensionPixelSize3;
                        }
                        enumMap.put((EnumMap<CameraFrame, a>) entry2.getKey(), aVar);
                    }
                } else {
                    int i9 = width - i2;
                    int i10 = i9 - dimensionPixelSize;
                    if (i10 <= i2) {
                        aVar.h(Integer.valueOf(i2));
                        aVar.f(Integer.valueOf(i9));
                        if (i9 > i6) {
                            i6 = i9;
                        }
                    } else {
                        aVar.h(Integer.valueOf(i7));
                        aVar.f(Integer.valueOf(i10));
                        if (i10 > i6) {
                            i6 = i10;
                        }
                    }
                    enumMap.put((EnumMap<CameraFrame, a>) entry2.getKey(), aVar);
                }
            } else {
                aVar.h(Integer.valueOf(i2));
                int i11 = width - i2;
                aVar.f(Integer.valueOf(i11));
                if (i11 > i6) {
                    i6 = i11;
                }
                enumMap.put((EnumMap<CameraFrame, a>) entry2.getKey(), aVar);
            }
            it3 = it4;
            context2 = context3;
            dimensionPixelSize2 = i4;
            dimensionPixelSize5 = i3;
        }
        Context context4 = context2;
        int i12 = dimensionPixelSize5;
        int i13 = dimensionPixelSize2;
        l(i6, this.c);
        p(this.f9225d);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        CameraFrame cameraFrame2 = CameraFrame.FRAME_4_3;
        if (enumMap2.containsKey(cameraFrame2)) {
            Size size2 = enumMap2.get(cameraFrame2);
            s.e(size2);
            s.g(size2, "sizeMap[CameraFrame.FRAME_4_3]!!");
            linkedHashMap2.put(cameraFrame2, size2);
        }
        CameraFrame cameraFrame3 = CameraFrame.FRAME_1_1;
        if (enumMap2.containsKey(cameraFrame3)) {
            Size size3 = enumMap2.get(cameraFrame3);
            s.e(size3);
            s.g(size3, "sizeMap[CameraFrame.FRAME_1_1]!!");
            linkedHashMap2.put(cameraFrame3, size3);
        }
        for (Map.Entry entry3 : linkedHashMap2.entrySet()) {
            int i14 = this.b + this.f9225d;
            Size size4 = (Size) entry3.getValue();
            int width2 = entry3.getKey() == CameraFrame.FRAME_1_1 ? g2 - i5 : (int) (g2 - (i5 * (size4.getWidth() / size4.getHeight())));
            a aVar2 = new a();
            if (width2 >= i14 && width2 < i14 + i2 + dimensionPixelSize) {
                aVar2.h(0);
                aVar2.f(Integer.valueOf(width2));
                enumMap.put((EnumMap<CameraFrame, a>) entry3.getKey(), aVar2);
            } else if (width2 < i14 + i2 + dimensionPixelSize || width2 > i14 + i12 + i2 + dimensionPixelSize) {
                int i15 = i14 + i12;
                int i16 = i15 + i2 + dimensionPixelSize;
                if (width2 > i16 && width2 <= i16 + i13) {
                    aVar2.h(Integer.valueOf((width2 - i14) - i12));
                    aVar2.f(Integer.valueOf(i15));
                    enumMap.put((EnumMap<CameraFrame, a>) entry3.getKey(), aVar2);
                } else if (width2 > i16 + i13) {
                    aVar2.h(Integer.valueOf(i2 + dimensionPixelSize + i13));
                    aVar2.f(Integer.valueOf(((width2 - i2) - dimensionPixelSize) - i13));
                    enumMap.put((EnumMap<CameraFrame, a>) entry3.getKey(), aVar2);
                } else if (width2 < i14) {
                    if (width2 <= dimensionPixelSize3) {
                        aVar2.h(0);
                        aVar2.f(Integer.valueOf(width2));
                        if (width2 > this.f9225d) {
                            this.f9225d = width2;
                        }
                        enumMap.put((EnumMap<CameraFrame, a>) entry3.getKey(), aVar2);
                        context = context4;
                    } else {
                        context = context4;
                        if (width2 >= i14 - g.a(context, 16.0f)) {
                            this.c -= i14 - width2;
                            this.b = width2;
                            aVar2.h(0);
                            aVar2.f(Integer.valueOf(width2));
                            enumMap.put((EnumMap<CameraFrame, a>) entry3.getKey(), aVar2);
                        } else {
                            aVar2.g(false);
                            aVar2.h(0);
                            aVar2.f(Integer.valueOf(width2));
                            enumMap.put((EnumMap<CameraFrame, a>) entry3.getKey(), aVar2);
                        }
                    }
                    m(this.f9225d, this.c);
                    context4 = context;
                }
            } else {
                aVar2.h(Integer.valueOf(i2 + dimensionPixelSize));
                aVar2.f(Integer.valueOf((width2 - i2) - dimensionPixelSize));
                enumMap.put((EnumMap<CameraFrame, a>) entry3.getKey(), aVar2);
            }
        }
    }

    private final void l(int i2, int i3) {
        a aVar;
        Integer b;
        a aVar2;
        Integer b2;
        if (i2 > this.f9225d) {
            this.f9225d = i2;
        }
        if (i2 >= i3) {
            EnumMap<CameraFrame, a> enumMap = this.f9230i;
            int i4 = 0;
            int intValue = (enumMap == null || (aVar = enumMap.get(CameraFrame.FRAME_16_9)) == null || (b = aVar.b()) == null) ? 0 : b.intValue();
            EnumMap<CameraFrame, a> enumMap2 = this.f9230i;
            if (enumMap2 != null && (aVar2 = enumMap2.get(CameraFrame.FRAME_FULL)) != null && (b2 = aVar2.b()) != null) {
                i4 = b2.intValue();
            }
            int i5 = i2 - i3;
            if (intValue == i4 || Math.min(intValue, i4) <= i5) {
                this.f9225d = i5;
            }
        }
    }

    private final void m(int i2, int i3) {
        a aVar;
        Integer b;
        a aVar2;
        Integer b2;
        a aVar3;
        Integer b3;
        if (i2 > this.f9225d) {
            this.f9225d = i2;
        }
        if (i2 >= i3) {
            EnumMap<CameraFrame, a> enumMap = this.f9230i;
            int intValue = (enumMap == null || (aVar = enumMap.get(CameraFrame.FRAME_16_9)) == null || (b = aVar.b()) == null) ? 0 : b.intValue();
            EnumMap<CameraFrame, a> enumMap2 = this.f9230i;
            int intValue2 = (enumMap2 == null || (aVar2 = enumMap2.get(CameraFrame.FRAME_FULL)) == null || (b2 = aVar2.b()) == null) ? 0 : b2.intValue();
            EnumMap<CameraFrame, a> enumMap3 = this.f9230i;
            int intValue3 = (enumMap3 == null || (aVar3 = enumMap3.get(CameraFrame.FRAME_4_3)) == null || (b3 = aVar3.b()) == null) ? 0 : b3.intValue();
            int i4 = i2 - i3;
            if (intValue != intValue2 || intValue2 != intValue3) {
                Integer num = (Integer) j.z(new Integer[]{Integer.valueOf(intValue), Integer.valueOf(intValue2), Integer.valueOf(intValue3)});
                if ((num != null ? num.intValue() : 0) > i4) {
                    return;
                }
            }
            this.f9225d = i4;
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private final void onDestroy() {
        this.f9232k.clear();
    }

    private final void p(int i2) {
        Context context = e.b();
        s.g(context, "context");
        int g2 = us.pinguo.util.h.g(context) - ((us.pinguo.util.h.i(context) * 4) / 3);
        int i3 = this.b + i2;
        int a = i3 - g.a(context, 40.0f);
        if (g2 < a) {
            this.b = a;
            return;
        }
        boolean z = false;
        if (a <= g2 && g2 < i3) {
            z = true;
        }
        if (z) {
            this.b = g2 - i2;
        }
    }

    public final void a(CameraFrame frameRatio, boolean z) {
        s.h(frameRatio, "frameRatio");
        if (frameRatio != this.a.getValue() || z) {
            this.a.setValue(frameRatio);
        }
    }

    public final int b() {
        return this.b;
    }

    public final int c() {
        return this.f9225d;
    }

    public final u<CameraFrame> d() {
        return this.a;
    }

    public final Map<CameraFrame, Size> e() {
        return this.f9228g;
    }

    public final Map<CameraFrame, a> f() {
        return this.f9230i;
    }

    public final a g() {
        return this.m;
    }

    public final int h() {
        return this.c;
    }

    public final void i(int i2, EnumMap<CameraFrame, Size> previewMap, LensFacing facing) {
        s.h(previewMap, "previewMap");
        s.h(facing, "facing");
        this.f9226e = i2;
        if (this.f9227f.get(facing) == null) {
            this.f9227f.put((EnumMap<LensFacing, EnumMap<CameraFrame, Size>>) facing, (LensFacing) previewMap);
        }
        this.f9228g = previewMap;
        EnumMap<CameraFrame, a> enumMap = this.f9229h.get(facing);
        if (enumMap == null) {
            enumMap = new EnumMap<>(CameraFrame.class);
            this.f9229h.put((EnumMap<LensFacing, EnumMap<CameraFrame, a>>) facing, (LensFacing) enumMap);
        }
        this.f9230i = enumMap;
        j(i2);
    }

    public final void k(a ratioInfo) {
        s.h(ratioInfo, "ratioInfo");
        int i2 = this.f9225d;
        Integer b = ratioInfo.b();
        int intValue = b == null ? 0 : b.intValue();
        for (h hVar : this.f9232k) {
            if (hVar.s()) {
                if (intValue > h() + i2) {
                    hVar.p(true);
                    hVar.h(true);
                } else {
                    hVar.p(false);
                    hVar.h(false);
                }
                int D = hVar.D();
                int G = hVar.G();
                int x = hVar.x();
                int i3 = x + G;
                if (intValue > i3 && intValue < i3 + D) {
                    hVar.w((intValue - x) - G);
                } else {
                    hVar.w(0);
                }
                if (intValue >= i3 + D) {
                    hVar.J(true);
                } else {
                    hVar.J(false);
                }
                int O = hVar.O();
                if (O == -1) {
                    O = e.b().getResources().getDimensionPixelSize(R.dimen.view_finder_top_bar_height);
                }
                Integer d2 = ratioInfo.d();
                if ((d2 == null ? 0 : d2.intValue()) >= O + this.f9226e) {
                    Integer b2 = ratioInfo.b();
                    if ((b2 == null ? 0 : b2.intValue()) <= h() + i2) {
                        hVar.i(false);
                    } else {
                        hVar.i(true);
                    }
                } else {
                    hVar.i(false);
                }
            }
        }
    }

    public final void n(h adapter) {
        s.h(adapter, "adapter");
        if (this.f9232k.contains(adapter)) {
            return;
        }
        this.f9232k.add(adapter);
    }

    public final a o() {
        a aVar;
        Size size = this.f9231j;
        if (size == null) {
            return null;
        }
        if (this.f9233l) {
            float height = size.getHeight() / size.getWidth();
            Context b = e.b();
            s.g(b, "getAppContext()");
            int i2 = us.pinguo.util.h.i(b);
            Context b2 = e.b();
            s.g(b2, "getAppContext()");
            int g2 = (int) ((us.pinguo.util.h.g(b2) - (i2 * height)) * 0.5f);
            aVar = new a();
            aVar.h(Integer.valueOf(g2));
            aVar.f(Integer.valueOf(g2));
            this.m = aVar;
        } else {
            this.m = null;
            EnumMap<CameraFrame, a> enumMap = this.f9230i;
            aVar = enumMap == null ? null : enumMap.get(this.a.getValue());
        }
        this.f9233l = !this.f9233l;
        this.f9231j = new Size(size.getHeight(), size.getWidth());
        if (aVar == null) {
            return null;
        }
        k(aVar);
        return aVar;
    }

    public final void q(CameraFrame frame) {
        s.h(frame, "frame");
        EnumMap<CameraFrame, Size> enumMap = this.f9228g;
        this.f9231j = enumMap == null ? null : enumMap.get(frame);
    }

    public final void r(LensFacing facing) {
        s.h(facing, "facing");
        EnumMap<CameraFrame, Size> enumMap = this.f9227f.get(facing);
        if (enumMap == null) {
            return;
        }
        this.f9228g = enumMap;
        EnumMap<CameraFrame, a> enumMap2 = this.f9229h.get(facing);
        if (enumMap2 == null) {
            return;
        }
        this.f9230i = enumMap2;
        CameraFrame value = this.a.getValue();
        if (value == null) {
            return;
        }
        a(value, true);
    }
}
