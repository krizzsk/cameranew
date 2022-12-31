package us.pinguo.camera360.shop.data;

import com.coremedia.iso.boxes.FreeBox;
import java.util.ArrayList;
import java.util.HashSet;
import kotlin.jvm.internal.s;
import us.pinguo.camera360.shop.data.show.ShowPkg;
import us.pinguo.camera360.shop.data.show.UnlockType;
import us.pinguo.camera360.shop.data.show.u;
/* compiled from: StoreStat.kt */
/* loaded from: classes2.dex */
public final class k {
    private static String b = "";
    private static int c = -1;
    public static final k a = new k();

    /* renamed from: d  reason: collision with root package name */
    private static final HashSet<l> f9609d = new HashSet<>();

    /* renamed from: e  reason: collision with root package name */
    private static final HashSet<l> f9610e = new HashSet<>();

    private k() {
    }

    public static final String c(ShowPkg showPkg) {
        s.h(showPkg, "showPkg");
        boolean j2 = u.b().j(showPkg);
        return showPkg.getType() == UnlockType.PAY ? j2 ? "unpaid" : "paid" : showPkg.getType() == UnlockType.MEMBER ? j2 ? "locked" : "unlocked" : showPkg.getType() == UnlockType.FREE ? FreeBox.TYPE : us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER;
    }

    public static final String d() {
        return b;
    }

    public static final void f(String str) {
        s.h(str, "<set-?>");
        b = str;
    }

    public final void a(int i2, ShowPkg showPkg) {
        s.h(showPkg, "showPkg");
        l lVar = new l(i2, showPkg);
        HashSet<l> hashSet = f9609d;
        if (hashSet.contains(lVar)) {
            return;
        }
        hashSet.add(lVar);
        if (c == i2) {
            HashSet<l> hashSet2 = f9610e;
            if (hashSet2.contains(lVar)) {
                return;
            }
            us.pinguo.foundation.statistics.h.a.p(c(showPkg), b, showPkg.getId(), "show");
            hashSet2.add(lVar);
        }
    }

    public final void b() {
        f9609d.clear();
        f9610e.clear();
        c = -1;
        b = "";
    }

    public final void e(int i2) {
        c = i2;
        HashSet<l> hashSet = f9609d;
        ArrayList<l> arrayList = new ArrayList();
        for (Object obj : hashSet) {
            l lVar = (l) obj;
            if (lVar.a() == i2 && !f9610e.contains(lVar)) {
                arrayList.add(obj);
            }
        }
        for (l lVar2 : arrayList) {
            us.pinguo.foundation.statistics.h.a.p(c(lVar2.b()), d(), lVar2.b().getId(), "show");
            f9610e.add(lVar2);
        }
    }
}
