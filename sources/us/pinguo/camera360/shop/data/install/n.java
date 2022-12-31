package us.pinguo.camera360.shop.data.install;

import us.pinguo.repository2020.database.filter.FilterPackageTable;
/* compiled from: FilterPkgUninstallTask.java */
/* loaded from: classes3.dex */
public class n extends g {
    public n(us.pinguo.camera360.shop.data.h hVar, w wVar) {
        super(hVar, wVar);
    }

    @Override // us.pinguo.camera360.shop.data.install.g
    public int d(us.pinguo.camera360.shop.data.h hVar) {
        try {
            FilterOperateManager.h().f(hVar.f());
            FilterPackageTable i2 = hVar.i();
            String displayMd5 = i2.getDisplayMd5();
            String packageMd5 = i2.getPackageMd5();
            String c = t.c(displayMd5);
            String c2 = t.c(packageMd5);
            us.pinguo.util.l.j(c);
            us.pinguo.util.l.j(c2);
            String a = t.a(displayMd5);
            String a2 = t.a(packageMd5);
            us.pinguo.util.l.j(a);
            us.pinguo.util.l.j(a2);
            us.pinguo.repository2020.database.a.a.x().c(i2);
            us.pinguo.repository2020.database.a.a.y().c(us.pinguo.repository2020.database.a.a.y().d(i2.getId()));
            us.pinguo.repository2020.database.a.a.w().c(us.pinguo.repository2020.database.a.a.w().d(i2.getId()));
            return 0;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 1;
        }
    }
}
