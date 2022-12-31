package us.pinguo.paylibcenter;

import android.app.Activity;
import android.content.Context;
import java.util.List;
import us.pinguo.paylibcenter.PayHelp;
import us.pinguo.paylibcenter.bean.PayCenterParm;
/* compiled from: PayHuaweiCenterInterface.java */
/* loaded from: classes5.dex */
public interface j {
    void a(Context context, List<String> list, PayHelp.j jVar);

    void b(Context context, String str);

    void c(Context context, PayHelp.k kVar);

    void d(PayCenterParm payCenterParm);

    void e(Activity activity, PayCallback payCallback);
}
