package us.pinguo.camera360.shop.data.install;

import com.pinguo.camera360.effect.model.entity.Effect;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONObject;
import us.pinguo.camera360.shop.data.FilterType;
import us.pinguo.camera360.shop.data.show.ShowDetail;
import us.pinguo.repository2020.database.filter.FilterPackageTable;
/* compiled from: FilterPackageUpdateInstallTask.java */
/* loaded from: classes3.dex */
public class m extends l {

    /* renamed from: h  reason: collision with root package name */
    private String f9605h;

    /* renamed from: i  reason: collision with root package name */
    private String f9606i;

    public m(k kVar, p pVar) {
        super(kVar, pVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.camera360.shop.data.install.l, us.pinguo.camera360.shop.data.install.e
    public void l() {
        if (!this.c.getDisplayZipMd5().equals(this.f9606i)) {
            us.pinguo.util.l.j(t.c(this.f9606i));
        }
        if (!this.c.getPackageZipMd5().equals(this.f9605h)) {
            us.pinguo.util.l.j(t.c(this.f9605h));
        }
        super.l();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.camera360.shop.data.install.l, us.pinguo.camera360.shop.data.install.e, us.pinguo.foundation.utils.AsyncTask
    public void onPreExecute() {
        super.onPreExecute();
    }

    @Override // us.pinguo.camera360.shop.data.install.e
    public boolean s() {
        us.pinguo.camera360.shop.data.h k2 = us.pinguo.camera360.shop.data.i.e().k(this.b.b(), new FilterType[0]);
        if (k2 != null) {
            this.f9605h = k2.i().getPackageMd5();
            this.f9606i = k2.i().getDisplayMd5();
        }
        return super.s();
    }

    @Override // us.pinguo.camera360.shop.data.install.l
    protected ShowDetail w() throws Exception {
        return us.pinguo.camera360.shop.data.show.u.b().g(this.b.b());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.camera360.shop.data.install.l
    public q y() throws Exception {
        us.pinguo.repository2020.database.a.a.w().c(us.pinguo.repository2020.database.a.a.w().d(this.b.b()));
        us.pinguo.repository2020.database.a.a.y().c(us.pinguo.repository2020.database.a.a.y().d(this.b.b()));
        return super.y();
    }

    @Override // us.pinguo.camera360.shop.data.install.l
    protected void z(String str, String str2) throws Exception {
        String d2 = us.pinguo.util.k.d(new File(str));
        us.pinguo.common.log.a.m("FilterPackageInstallTask", "i18n:" + d2, new Object[0]);
        FilterPackageTable filterPackageTable = new FilterPackageTable(this.b.c().getCategoryId(), this.b.b(), new JSONObject(d2).getJSONObject("i18n").toString(), this.c.getPackageType().getType(), Effect.Type.Filter.name(), str2, x(), this.c.getDisplayZipMd5(), this.c.getPackageZipMd5(), 0, 0, 1, Integer.valueOf(this.c.tagContent), Long.valueOf(this.c.tagOnTime), Long.valueOf(this.c.tagOffTime), null, null, null, null);
        ArrayList arrayList = new ArrayList();
        arrayList.add(filterPackageTable);
        us.pinguo.repository2020.database.a.a.x().b(arrayList);
        publishProgress(97);
    }
}
