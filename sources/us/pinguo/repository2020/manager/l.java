package us.pinguo.repository2020.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.s;
import us.pinguo.repository2020.entity.Package;
import us.pinguo.repository2020.entity.Scene;
import us.pinguo.repository2020.entity.ShopData;
import us.pinguo.repository2020.entity.ShopResponse;
/* compiled from: FilterServerDataManager.kt */
/* loaded from: classes6.dex */
public final class l {
    private final k a = new k();
    private final HashMap<String, ArrayList<Package>> b = new HashMap<>();
    private final HashMap<String, Package> c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private final ArrayList<Scene> f11927d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    private final ArrayList<Package> f11928e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    private boolean f11929f;

    /* compiled from: FilterServerDataManager.kt */
    /* loaded from: classes6.dex */
    public static final class a implements us.pinguo.repository2020.network.b<ShopResponse> {
        a() {
        }

        @Override // us.pinguo.repository2020.network.b
        /* renamed from: a */
        public void onSuccess(ShopResponse response) {
            s.h(response, "response");
            ShopData data = response.getData();
            if (data == null) {
                return;
            }
            l lVar = l.this;
            l.i(lVar, data, false, 2, null);
            lVar.a.d(data);
            lVar.j(true);
        }

        @Override // us.pinguo.repository2020.network.b
        public void onError(int i2, String errMsg) {
            s.h(errMsg, "errMsg");
        }
    }

    private final boolean g(long j2, Package r11) {
        Long onsale_time = r11.getOnsale_time();
        if (onsale_time == null) {
            return false;
        }
        long longValue = onsale_time.longValue();
        Long off_time = r11.getOff_time();
        if (off_time == null) {
            return false;
        }
        long longValue2 = off_time.longValue();
        if (j2 != 0) {
            long j3 = 1000;
            if (j2 < longValue * j3 || j2 > longValue2 * j3) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0054, code lost:
        if ((!(r12.getProducts_in_camera().length == 0)) == false) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ea A[LOOP:3: B:40:0x00b6->B:56:0x00ea, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f5 A[EDGE_INSN: B:90:0x00f5->B:58:0x00f5 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void h(us.pinguo.repository2020.entity.ShopData r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 375
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.manager.l.h(us.pinguo.repository2020.entity.ShopData, boolean):void");
    }

    static /* synthetic */ void i(l lVar, ShopData shopData, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        lVar.h(shopData, z);
    }

    public final void b() {
        us.pinguo.repository2020.network.a.a.b(new a(), "0");
    }

    public final List<Scene> c(boolean z) {
        if (this.f11927d.isEmpty() || z) {
            h(this.a.a(), z);
        }
        return this.f11927d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Package d(String packageId) {
        s.h(packageId, "packageId");
        Package r1 = null;
        if (this.c.isEmpty()) {
            i(this, this.a.a(), false, 2, null);
        }
        Package r0 = this.c.get(packageId);
        if (r0 == null) {
            Iterator<T> it = this.f11928e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (s.c(((Package) next).getPid(), packageId)) {
                    r1 = next;
                    break;
                }
            }
            return r1;
        }
        return r0;
    }

    public final List<Package> e(String categoryId, boolean z) {
        s.h(categoryId, "categoryId");
        if (this.b.isEmpty() || z) {
            h(this.a.a(), z);
        }
        return this.b.get(categoryId);
    }

    public final boolean f() {
        return this.f11929f;
    }

    public final void j(boolean z) {
        this.f11929f = z;
    }
}
