package us.pinguo.common.filter.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.c0;
import kotlin.jvm.internal.s;
import kotlin.text.Regex;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.v1;
import kotlinx.coroutines.z0;
import us.pinguo.image.ImageNative;
import us.pinguo.repository2020.u;
/* compiled from: AutoFilterProducer.kt */
/* loaded from: classes4.dex */
public final class AutoFilterProducer {
    private us.pinguo.facedetector.c b;
    private b c;

    /* renamed from: e  reason: collision with root package name */
    private boolean f9822e;

    /* renamed from: f  reason: collision with root package name */
    private int f9823f;

    /* renamed from: g  reason: collision with root package name */
    private int f9824g;

    /* renamed from: h  reason: collision with root package name */
    private int f9825h;

    /* renamed from: i  reason: collision with root package name */
    private v1 f9826i;
    private final u<us.pinguo.processor.d> a = new u<>();

    /* renamed from: d  reason: collision with root package name */
    private boolean f9821d = true;

    /* renamed from: j  reason: collision with root package name */
    private final us.pinguo.processor.d f9827j = new us.pinguo.processor.d("C360_EasyCamera_Other_PN", "Effect=Normal", null, false, 12, null);

    /* renamed from: k  reason: collision with root package name */
    private final us.pinguo.processor.d f9828k = new us.pinguo.processor.d("C360_EasyCamera_Other_PB", "Effect=Normal", null, false, 12, null);

    /* renamed from: l  reason: collision with root package name */
    private final us.pinguo.processor.d f9829l = new us.pinguo.processor.d("C360_EasyCamera_Other_PL", "Effect=Normal", null, false, 12, null);
    private final us.pinguo.processor.d m = new us.pinguo.processor.d("C360_EasyCamera_Other_PSN", "Enhance_AutoLevel;Curve0=<A>127=136</A>|Effect=FastSharpen;sharpness=0.3;minLight=0.5|Effect=RGB2HSV_Fuse;mrq=35,30,20;rotate=33|Effect=HDR_Light_L_Fuse;guassFrame=<PyramidLevel>1</PyramidLevel><StandLength>50</StandLength><StandAmount>5</StandAmount>;Shadow=0.3;Highlight=0.3|Effect=HSV2RGB", null, false, 12, null);
    private final us.pinguo.processor.d n = new us.pinguo.processor.d("C360_EasyCamera_Other_PSB", "Effect=Enhance_AutoLevel|Effect=RGB2HSV|Effect=HDR_Light_L;guassFrame=<PyramidLevel>1</PyramidLevel><StandLength>50</StandLength><StandAmount>5</StandAmount>;Shadow=0.7;Highlight=0.2|Effect=HSV2RGB", null, false, 12, null);
    private final us.pinguo.processor.d o = new us.pinguo.processor.d("C360_EasyCamera_Other_PSL", "Enhance_AutoLevel;Curve0=<A>127=136</A>|Effect=RGB2HSV_Fuse;mrq=35,30,20;rotate=33|Effect=HDR_Light_L_Fuse;guassFrame=<PyramidLevel>1</PyramidLevel><StandLength>50</StandLength><StandAmount>5</StandAmount>;Shadow=0.5;Highlight=0.3|Effect=HSV2RGB", null, false, 12, null);
    private final us.pinguo.processor.d p = new us.pinguo.processor.d("C360_EasyCamera_Other_PL", "Enhance_AutoLevel|Effect=RGB2HSV|Effect=HDR_Light_L;guassFrame=<PyramidLevel>1</PyramidLevel><StandLength>50</StandLength><StandAmount>5</StandAmount>;Shadow=0.2;Highlight=0.2|Effect=HSV2RGB", null, false, 12, null);
    private final us.pinguo.processor.d q = new us.pinguo.processor.d("C360_EasyCamera_Other_SN", "Enhance_AutoLevel|Effect=RGB2HSV|Effect=HDR_Light_L;guassFrame=<PyramidLevel>1</PyramidLevel><StandLength>50</StandLength><StandAmount>5</StandAmount>;Shadow=0.3;Highlight=0.3|Effect=HSV2RGB", null, false, 12, null);
    private final us.pinguo.processor.d r = new us.pinguo.processor.d("C360_EasyCamera_Other_SB", "Enhance_AutoLevel|Effect=RGB2HSV|Effect=HDR_Light_L;guassFrame=<PyramidLevel>1</PyramidLevel><StandLength>50</StandLength><StandAmount>5</StandAmount>;Shadow=0.7;Highlight=0.2|Effect=HSV2RGB", null, false, 12, null);
    private final us.pinguo.processor.d s = new us.pinguo.processor.d("C360_EasyCamera_Other_SL", "Enhance_AutoLevel|Effect=RGB2HSV|Effect=HDR_Light_L;guassFrame=<PyramidLevel>1</PyramidLevel><StandLength>50</StandLength><StandAmount>5</StandAmount>;Shadow=0.6;Highlight=0.3;Overlay=0|Effect=HSV2RGB", null, false, 12, null);

    /* compiled from: AutoFilterProducer.kt */
    /* loaded from: classes4.dex */
    public enum Scene {
        PERSON,
        SCENERY,
        PERSON_SCENERY
    }

    /* compiled from: AutoFilterProducer.kt */
    /* loaded from: classes4.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Scene.values().length];
            iArr[Scene.PERSON.ordinal()] = 1;
            iArr[Scene.SCENERY.ordinal()] = 2;
            iArr[Scene.PERSON_SCENERY.ordinal()] = 3;
            a = iArr;
        }
    }

    /* compiled from: AutoFilterProducer.kt */
    /* loaded from: classes4.dex */
    public static final class b {
        private final byte[] a;
        private final int b;
        private final int c;

        public b(byte[] data, int i2, int i3) {
            s.h(data, "data");
            this.a = data;
            this.b = i2;
            this.c = i3;
        }

        public final byte[] a() {
            return this.a;
        }

        public final int b() {
            return this.c;
        }

        public final int c() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                b bVar = (b) obj;
                return s.c(this.a, bVar.a) && this.b == bVar.b && this.c == bVar.c;
            }
            return false;
        }

        public int hashCode() {
            return (((Arrays.hashCode(this.a) * 31) + this.b) * 31) + this.c;
        }

        public String toString() {
            return "YUVFrame(data=" + Arrays.toString(this.a) + ", width=" + this.b + ", height=" + this.c + ')';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b() {
        Scene scene;
        b bVar = this.c;
        if (bVar == null) {
            return;
        }
        float e2 = e();
        int f2 = f(bVar);
        if (f2 != this.f9823f) {
            if (f2 == this.f9824g) {
                int i2 = this.f9825h;
                if (i2 >= 3) {
                    this.f9825h = 0;
                    this.f9823f = f2;
                } else {
                    this.f9825h = i2 + 1;
                }
            } else {
                this.f9824g = f2;
            }
        } else {
            this.f9825h = 0;
        }
        if (this.f9821d) {
            scene = Scene.PERSON;
        } else if (e2 > 0.05d) {
            scene = Scene.PERSON;
        } else if (e2 > 0.0f) {
            scene = Scene.PERSON_SCENERY;
        } else {
            scene = Scene.SCENERY;
        }
        if (this.f9823f == 2 && scene != Scene.SCENERY) {
            this.f9823f = 1;
        }
        h(scene);
    }

    private final float e() {
        us.pinguo.facedetector.c cVar = this.b;
        float f2 = 0.0f;
        if (cVar != null && cVar.h()) {
            us.pinguo.facedetector.b[] d2 = cVar.d();
            int i2 = 0;
            int length = d2.length;
            while (i2 < length) {
                us.pinguo.facedetector.b bVar = d2[i2];
                i2++;
                f2 += Math.abs((bVar.g().left - bVar.g().right) * (bVar.g().top - bVar.g().bottom));
            }
            return f2 / (cVar.e() * cVar.f());
        }
        return 0.0f;
    }

    private final int f(b bVar) {
        return ImageNative.analyzeLightFromYuv(bVar.a(), bVar.c(), bVar.b(), g() ? 1 : 0);
    }

    private final boolean g() {
        List h2;
        boolean z;
        String now = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH).format(new Date(System.currentTimeMillis()));
        s.g(now, "now");
        List<String> split = new Regex(":").split(now, 0);
        if (!split.isEmpty()) {
            ListIterator<String> listIterator = split.listIterator(split.size());
            while (listIterator.hasPrevious()) {
                if (listIterator.previous().length() == 0) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (!z) {
                    h2 = c0.S(split, listIterator.nextIndex() + 1);
                    break;
                }
            }
        }
        h2 = kotlin.collections.u.h();
        Object[] array = h2.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        Integer hour = Integer.valueOf(((String[]) array)[0]);
        s.g(hour, "hour");
        return hour.intValue() >= 19 || hour.intValue() <= 7;
    }

    private final void h(Scene scene) {
        us.pinguo.processor.d dVar;
        int i2 = a.a[scene.ordinal()];
        if (i2 == 1) {
            int i3 = this.f9823f;
            if (i3 == 0) {
                dVar = this.f9827j;
            } else if (i3 == 1) {
                dVar = this.f9828k;
            } else if (i3 != 2 && i3 != 3) {
                dVar = this.f9827j;
            } else {
                dVar = this.f9829l;
            }
        } else if (i2 == 2) {
            int i4 = this.f9823f;
            if (i4 == 0) {
                dVar = this.q;
            } else if (i4 == 1) {
                dVar = this.r;
            } else if (i4 == 2) {
                dVar = this.p;
            } else if (i4 != 3) {
                dVar = this.q;
            } else {
                dVar = this.s;
            }
        } else if (i2 == 3) {
            int i5 = this.f9823f;
            if (i5 == 0) {
                dVar = this.m;
            } else if (i5 == 1) {
                dVar = this.n;
            } else if (i5 != 2 && i5 != 3) {
                dVar = this.m;
            } else {
                dVar = this.o;
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
        if (s.c(this.a.getValue(), dVar)) {
            return;
        }
        this.a.postValue(dVar);
    }

    public final void c() {
        this.f9822e = false;
        v1 v1Var = this.f9826i;
        if (v1Var != null) {
            v1.a.a(v1Var, null, 1, null);
        }
        this.a.setValue(null);
    }

    public final u<us.pinguo.processor.d> d() {
        return this.a;
    }

    public final void i(us.pinguo.facedetector.c cVar) {
        this.b = cVar;
    }

    public final void j(boolean z) {
        this.f9821d = z;
    }

    public final void k(b bVar) {
        this.c = bVar;
    }

    public final void l() {
        v1 d2;
        if (this.f9822e) {
            return;
        }
        this.f9822e = true;
        d2 = kotlinx.coroutines.l.d(n0.a(z0.a()), null, null, new AutoFilterProducer$start$1(this, null), 3, null);
        this.f9826i = d2;
    }
}
