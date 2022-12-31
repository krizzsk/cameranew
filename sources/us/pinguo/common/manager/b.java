package us.pinguo.common.manager;

import java.util.Calendar;
import java.util.List;
import kotlin.jvm.internal.s;
import us.pinguo.advconfigdata.AdvConfigManager;
import us.pinguo.advconfigdata.Utils.AdvPrefUtil;
import us.pinguo.advconfigdata.database.AdvItem;
/* compiled from: AdvCountManager.kt */
/* loaded from: classes4.dex */
public final class b {
    public static final b a = new b();

    private b() {
    }

    private final String c(AdvItem advItem) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(Calendar.getInstance().get(1));
        stringBuffer.append(Calendar.getInstance().get(2));
        stringBuffer.append(Calendar.getInstance().get(5));
        String stringBuffer2 = stringBuffer.toString();
        s.g(stringBuffer2, "StringBuffer().append(Ca…DAY_OF_MONTH)).toString()");
        return advItem.guid + '_' + ((Object) advItem.advId) + '_' + stringBuffer2;
    }

    public static /* synthetic */ AdvItem e(b bVar, String str, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = "homePage";
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return bVar.d(str, str2, z);
    }

    private final boolean f(AdvItem advItem) {
        return AdvPrefUtil.getInstance().getLong(c(advItem), 0L) >= ((long) advItem.dayCount);
    }

    public final void a(AdvItem advItem) {
        s.h(advItem, "advItem");
        String c = c(advItem);
        AdvPrefUtil.getInstance().putLong(c, AdvPrefUtil.getInstance().getLong(c) + 1);
    }

    public final void b() {
        AdvPrefUtil.getInstance().putLong("take_pic_count", AdvPrefUtil.getInstance().getLong("take_pic_count") + 1);
    }

    public final AdvItem d(String guid, String showPosition, boolean z) {
        s.h(guid, "guid");
        s.h(showPosition, "showPosition");
        List<AdvItem> items = AdvConfigManager.getInstance().getItems(guid);
        if (items == null) {
            return null;
        }
        for (AdvItem advItem : items) {
            AdvItem loadDownloadedImage = AdvConfigManager.getInstance().loadDownloadedImage(advItem);
            if (loadDownloadedImage != null && s.c(showPosition, loadDownloadedImage.popPosition)) {
                int i2 = loadDownloadedImage.afterCameraPopNum;
                if (i2 > 0) {
                    if (z) {
                        int i3 = (int) AdvPrefUtil.getInstance().getLong("take_pic_count", 0L);
                        boolean z2 = i3 % i2 == 0;
                        us.pinguo.common.log.a.k("AdvCountManager", "is times match==>" + z2 + "==current===>" + i3);
                        if (z2 && !a.f(loadDownloadedImage)) {
                            us.pinguo.common.log.a.k("展示 after Camera 弹窗", new Object[0]);
                            return loadDownloadedImage;
                        }
                    } else {
                        continue;
                    }
                } else if (!a.f(loadDownloadedImage)) {
                    return loadDownloadedImage;
                }
            }
        }
        return null;
    }
}
