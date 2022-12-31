package d.d.a.a.a.g;

import android.text.TextUtils;
import com.iab.omid.library.ironsrc.adsession.CreativeType;
import com.iab.omid.library.ironsrc.adsession.ImpressionType;
import com.iab.omid.library.ironsrc.adsession.Owner;
import com.iab.omid.library.ironsrc.adsession.g;
/* loaded from: classes2.dex */
public class e {
    public static void a() {
        if (!d.d.a.a.a.a.c()) {
            throw new IllegalStateException("Method called before OM SDK activation");
        }
    }

    public static void b(Owner owner, CreativeType creativeType, ImpressionType impressionType) {
        if (owner == Owner.NONE) {
            throw new IllegalArgumentException("Impression owner is none");
        }
        if (creativeType == CreativeType.DEFINED_BY_JAVASCRIPT && owner == Owner.NATIVE) {
            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        }
        if (impressionType == ImpressionType.DEFINED_BY_JAVASCRIPT && owner == Owner.NATIVE) {
            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        }
    }

    public static void c(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void d(String str, int i2, String str2) {
        if (str.length() > i2) {
            throw new IllegalArgumentException(str2);
        }
    }

    public static void e(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(str2);
        }
    }

    public static void f(g gVar) {
        if (gVar.m()) {
            throw new IllegalStateException("AdSession is finished");
        }
    }

    public static void g(g gVar) {
        j(gVar);
        f(gVar);
    }

    public static void h(g gVar) {
        if (gVar.o().l() != null) {
            throw new IllegalStateException("AdEvents already exists for AdSession");
        }
    }

    public static void i(g gVar) {
        if (!gVar.p()) {
            throw new IllegalStateException("Impression event is not expected from the Native AdSession");
        }
    }

    private static void j(g gVar) {
        if (!gVar.l()) {
            throw new IllegalStateException("AdSession is not started");
        }
    }
}
