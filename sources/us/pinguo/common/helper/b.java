package us.pinguo.common.helper;

import android.graphics.PointF;
import java.util.List;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.libdeepvision.callback.RestorationCancelCallback;
import us.pinguo.libdeepvision.callback.ResultImageCallback;
import us.pinguo.util.v;
/* compiled from: RestorationHelper.kt */
/* loaded from: classes4.dex */
public final class b {
    public static final a c = new a(null);

    /* renamed from: d  reason: collision with root package name */
    private static String f9921d;

    /* renamed from: e  reason: collision with root package name */
    private static String f9922e;
    private c a;
    private String b;

    /* compiled from: RestorationHelper.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }

        public final String a() {
            return b.f9922e;
        }

        public final String b() {
            return b.f9921d;
        }
    }

    static {
        String c2 = us.pinguo.libdeepvision.a.c(v.a(), "img_restoration.jpg");
        s.g(c2, "getModelPath(UtilContext…), \"img_restoration.jpg\")");
        f9921d = c2;
        f9922e = us.pinguo.libdeepvision.a.c(v.a(), "face_restoration.jpg");
    }

    public final void c(RestorationCancelCallback restorationCancelCallback) {
        s.h(restorationCancelCallback, "restorationCancelCallback");
        c cVar = this.a;
        if (cVar != null) {
            cVar.a(restorationCancelCallback);
        }
        this.a = null;
    }

    public final boolean d() {
        c cVar = this.a;
        return cVar != null && cVar.c();
    }

    public final synchronized void e(String srcPath, List<? extends List<? extends PointF>> list, l<? super String, u> lVar, ResultImageCallback progressCallback) {
        s.h(srcPath, "srcPath");
        s.h(progressCallback, "progressCallback");
        if (srcPath.length() == 0) {
            if (lVar != null) {
                lVar.invoke("");
            }
            return;
        }
        c cVar = this.a;
        if (cVar != null) {
            c.b(cVar, null, 1, null);
        }
        String str = this.b;
        if (str == null) {
            str = "";
        }
        c cVar2 = new c(str, srcPath, list, lVar, progressCallback);
        this.b = srcPath;
        this.a = cVar2;
        cVar2.e(true);
        cVar2.run();
    }
}
