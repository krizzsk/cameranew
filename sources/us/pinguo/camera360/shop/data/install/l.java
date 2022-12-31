package us.pinguo.camera360.shop.data.install;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.pinguo.camera360.effect.model.entity.Effect;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;
import us.pinguo.camera360.shop.data.show.ShowDetail;
import us.pinguo.foundation.utils.m0;
import us.pinguo.repository2020.database.filter.FilterPackageTable;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FilterPackageInstallTask.java */
/* loaded from: classes3.dex */
public class l extends e {
    ShowDetail c;

    /* renamed from: d  reason: collision with root package name */
    String f9601d;

    /* renamed from: e  reason: collision with root package name */
    String f9602e;

    /* renamed from: f  reason: collision with root package name */
    private final CountDownLatch f9603f;

    /* renamed from: g  reason: collision with root package name */
    private volatile boolean f9604g;

    /* compiled from: FilterPackageInstallTask.java */
    /* loaded from: classes3.dex */
    class a extends v {
        a() {
        }

        @Override // us.pinguo.camera360.shop.data.install.v
        protected boolean o(boolean z) {
            l.this.f9604g = z;
            l.this.f9603f.countDown();
            Log.e("FilterPackageInstallTask", "shaderInstalled:" + z);
            return false;
        }
    }

    /* compiled from: FilterPackageInstallTask.java */
    /* loaded from: classes3.dex */
    private class b {
        public int a;
        public int b;

        private b(l lVar) {
        }

        /* synthetic */ b(l lVar, a aVar) {
            this(lVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar, p pVar) {
        super(kVar, pVar);
        this.f9603f = new CountDownLatch(1);
        this.f9604g = false;
    }

    private boolean A() {
        us.pinguo.common.log.a.e("wait shader result", new Object[0]);
        try {
            this.f9603f.await();
        } catch (InterruptedException e2) {
            us.pinguo.common.log.a.e("wait shader result exception", new Object[0]);
            e2.printStackTrace();
            this.f9604g = false;
        }
        us.pinguo.common.log.a.e("shader result:" + this.f9604g, new Object[0]);
        return this.f9604g;
    }

    protected o B() {
        return new i();
    }

    protected o C() {
        return new s();
    }

    @Nullable
    protected q D() {
        try {
            if (!TextUtils.isEmpty(this.c.getDisplayZipMd5()) && !TextUtils.isEmpty(this.c.getPackageZipMd5())) {
                String c = t.c(this.c.getDisplayZipMd5());
                String c2 = t.c(this.c.getPackageZipMd5());
                us.pinguo.util.l.j(c);
                us.pinguo.util.l.j(c2);
                us.pinguo.util.l.f(c);
                us.pinguo.util.l.f(c2);
                m0.c(this.f9602e, c);
                publishProgress(92);
                m0.c(this.f9601d, c2);
                publishProgress(95);
                return null;
            }
            us.pinguo.common.log.a.e("package md5 is empty", new Object[0]);
            throw new IOException("package md5 is empty");
        } catch (IOException e2) {
            e2.printStackTrace();
            return new q(this.b.b(), false, 6, e2);
        }
    }

    @Override // us.pinguo.camera360.shop.data.install.e
    public q g() {
        us.pinguo.common.log.a.c("newShop,start download", new Object[0]);
        publishProgress(2);
        try {
            ShowDetail w = w();
            this.c = w;
            if (w == null) {
                return new q(this.b.b(), false, 5, null);
            }
            us.pinguo.common.log.a.c("newShop,getDetail success:", new Object[0]);
            publishProgress(5);
            this.f9602e = t.a(this.c.getDisplayZipMd5());
            b bVar = new b(this, null);
            bVar.a = 5;
            bVar.b = 5;
            q h2 = h(this.c.getDisplayZip(), this.f9602e, bVar);
            if (h2.d()) {
                this.f9601d = t.a(this.c.getPackageZipMd5());
                b bVar2 = new b(this, null);
                bVar2.a = 10;
                bVar2.b = 80;
                return h(this.c.getPackageZip(), this.f9601d, bVar2);
            }
            return h2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return new q(this.b.b(), false, 5, e2);
        }
    }

    @Override // us.pinguo.camera360.shop.data.install.e
    protected void k(String str, float f2, Object obj) {
        b bVar = (b) obj;
        publishProgress(Integer.valueOf((int) (bVar.a + (bVar.b * f2))));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.camera360.shop.data.install.e
    public void l() {
        super.l();
        publishProgress(100);
    }

    @Override // us.pinguo.camera360.shop.data.install.e
    protected String m() {
        return this.f9602e;
    }

    @Override // us.pinguo.camera360.shop.data.install.e
    protected String n() {
        return this.f9601d;
    }

    @Override // us.pinguo.camera360.shop.data.install.e
    public q o() {
        us.pinguo.common.log.a.c("newShop,start unzip", new Object[0]);
        q D = D();
        if (D != null) {
            return D;
        }
        String str = this.c.getDisplayZipMd5() + "/icon.png";
        StringBuilder sb = new StringBuilder();
        String str2 = t.b;
        sb.append(str2);
        sb.append(this.c.getDisplayZipMd5() + "/display.json");
        String sb2 = sb.toString();
        String str3 = str2 + str;
        if (!new File(sb2).exists()) {
            return new q(this.b.b(), false, 6, null);
        }
        if (!new File(str3).exists()) {
            str = this.c.getDisplayZipMd5() + "/icon.jpg";
            if (!new File(str2 + str).exists()) {
                str = this.c.getDisplayZipMd5() + "/icon.jpeg";
                if (!new File(str2 + str).exists()) {
                    return new q(this.b.b(), false, 6, null);
                }
            }
        }
        if (isCancelled()) {
            return new q(this.b.b(), false, 3, null);
        }
        try {
            z(sb2, str);
            q y = y();
            if (y != null) {
                return y;
            }
            if (isCancelled()) {
                return new q(this.b.b(), false, 3, null);
            }
            p(this.c.getDisplayZipMd5());
            if (A()) {
                if (!us.pinguo.foundation.d.f10985d) {
                    us.pinguo.util.l.j(this.f9602e);
                    us.pinguo.util.l.j(this.f9601d);
                }
                publishProgress(99);
                return new q(this.b.b(), true, 0, null);
            }
            return new q(this.b.b(), false, 9, null);
        } catch (Exception e2) {
            e2.printStackTrace();
            return new q(this.b.b(), false, 6, e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.camera360.shop.data.install.e, us.pinguo.foundation.utils.AsyncTask
    public void onPreExecute() {
        super.onPreExecute();
        new a().execute(new Void[0]);
    }

    protected ShowDetail w() throws Exception {
        return us.pinguo.camera360.shop.data.show.u.b().f(this.b.b());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long x() {
        long currentTimeMillis = System.currentTimeMillis();
        List<FilterPackageTable> a2 = us.pinguo.repository2020.database.a.a.x().a();
        if (a2.size() == 0) {
            return currentTimeMillis;
        }
        long sort = a2.get(0).getSort();
        return currentTimeMillis > sort ? currentTimeMillis : sort + currentTimeMillis;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0124 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0101 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public us.pinguo.camera360.shop.data.install.q y() throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 372
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.camera360.shop.data.install.l.y():us.pinguo.camera360.shop.data.install.q");
    }

    protected void z(String str, String str2) throws Exception {
        String d2 = us.pinguo.util.k.d(new File(str));
        us.pinguo.common.log.a.m("FilterPackageInstallTask", "i18n:" + d2, new Object[0]);
        FilterPackageTable filterPackageTable = new FilterPackageTable(this.b.c().getCategoryId(), this.b.c().getId(), new JSONObject(d2).getJSONObject("i18n").toString(), this.c.getPackageType().getType(), Effect.Type.Filter.name(), str2, x(), this.c.getDisplayZipMd5(), this.c.getPackageZipMd5(), 0, Integer.valueOf(this.c.unity_engine_filter), Integer.valueOf(this.c.camera_support), Integer.valueOf(this.c.tagContent), Long.valueOf(this.c.tagOnTime), Long.valueOf(this.c.tagOffTime), null, null, null, null);
        ArrayList arrayList = new ArrayList();
        arrayList.add(filterPackageTable);
        us.pinguo.repository2020.database.a.a.x().b(arrayList);
        publishProgress(97);
    }
}
