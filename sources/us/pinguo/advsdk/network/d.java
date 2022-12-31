package us.pinguo.advsdk.network;

import android.content.Context;
import java.util.List;
import us.pinguo.advsdk.PgAdvConstants$CountMode;
import us.pinguo.advsdk.bean.AdsItem;
import us.pinguo.advsdk.manager.PgAdvManager;
/* compiled from: AdvDeepLinkTask.java */
/* loaded from: classes3.dex */
public class d extends AbsAdvBaseTask {
    List<String> a;
    protected AdsItem b;
    protected PgAdvConstants$CountMode c;

    /* compiled from: AdvDeepLinkTask.java */
    /* loaded from: classes3.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[PgAdvConstants$CountMode.values().length];
            a = iArr;
            try {
                iArr[PgAdvConstants$CountMode.DISABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[PgAdvConstants$CountMode.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public d(Context context, AdsItem adsItem, PgAdvConstants$CountMode pgAdvConstants$CountMode) {
        super(context);
        this.c = PgAdvConstants$CountMode.NORMAL;
        this.b = adsItem;
        if (adsItem != null) {
            this.a = adsItem.deep;
        }
        this.c = pgAdvConstants$CountMode;
    }

    protected void a(String str, String str2, us.pinguo.advsdk.network.a aVar) {
        if (PgAdvManager.getInstance().w(str)) {
            g.k().q(str, aVar);
        }
    }

    @Override // us.pinguo.advsdk.network.AbsAdvBaseTask
    protected void doInBackground() {
        List<String> list = this.a;
        if (list == null || list.size() == 0) {
            return;
        }
        int i2 = a.a[this.c.ordinal()];
        if (i2 == 1) {
            us.pinguo.advsdk.utils.b.a("AdvClickTask CountMode is DISABLE");
        } else if (i2 == 2) {
            us.pinguo.advsdk.utils.b.a("AdvClickTask CountMode is NORMAL , addClickTimes");
            PgAdvManager.getInstance().i().f();
        }
        for (int i3 = 0; i3 < this.a.size(); i3++) {
            a(this.a.get(i3), null, null);
        }
    }
}
