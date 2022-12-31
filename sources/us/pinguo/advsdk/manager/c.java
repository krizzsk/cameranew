package us.pinguo.advsdk.manager;

import android.content.Context;
import java.util.HashMap;
import us.pinguo.advsdk.bean.BaseBean;
import us.pinguo.advsdk.network.AbsAdvBaseTask;
import us.pinguo.advsdk.utils.AdvPrefUtil;
/* compiled from: DauStatisticReport.java */
/* loaded from: classes3.dex */
class c extends AbsAdvBaseTask {
    private long a;
    private int b;
    private String[] c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DauStatisticReport.java */
    /* loaded from: classes3.dex */
    public class a extends us.pinguo.advsdk.network.a<BaseBean> {
        a(c cVar, Class cls) {
            super(cls);
        }

        @Override // us.pinguo.advsdk.network.a
        public void b(int i2, String str) {
        }

        @Override // us.pinguo.advsdk.network.a
        /* renamed from: d */
        public void c(BaseBean baseBean) {
            AdvPrefUtil.getInstance().g("key_dau_report_time", System.currentTimeMillis());
        }
    }

    public c(Context context, int i2, String[] strArr) {
        super(context);
        this.a = 10000L;
        this.b = 0;
        this.b = i2;
        this.c = strArr;
    }

    private void a(Context context, int i2, String[] strArr) {
        if (strArr != null && strArr.length != 0 && context != null) {
            if (!us.pinguo.advsdk.utils.g.a(AdvPrefUtil.getInstance().b("key_dau_report_time"))) {
                us.pinguo.advsdk.utils.b.a("Dau report time at the same day");
                return;
            }
            String str = "";
            for (String str2 : strArr) {
                str = str + str2 + ",";
            }
            String substring = str.substring(0, str.length() - 1);
            HashMap hashMap = new HashMap();
            hashMap.put("activeType", String.valueOf(i2));
            hashMap.put("initSdk", substring);
            us.pinguo.advsdk.network.g.k().t(PgAdvManager.getInstance().h() + "/api/stat/dau", hashMap, new a(this, BaseBean.class));
            return;
        }
        us.pinguo.advsdk.utils.b.a("DAU context is null");
    }

    @Override // us.pinguo.advsdk.network.AbsAdvBaseTask
    protected void doInBackground() {
        try {
            Thread.sleep(this.a);
            a(this.mContext.get(), this.b, this.c);
        } catch (Exception unused) {
        }
    }
}
