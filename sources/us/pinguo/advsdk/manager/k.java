package us.pinguo.advsdk.manager;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import us.pinguo.advsdk.bean.AdsItem;
import us.pinguo.advsdk.utils.AdvPrefUtil;
/* compiled from: RotateManager.java */
/* loaded from: classes3.dex */
class k {
    private List<AdsItem> a(List<AdsItem> list, int i2) {
        if (list != null && list.size() != 0 && i2 != 0 && list.size() != 1) {
            for (int i3 = 0; i3 < i2; i3++) {
                list.add(list.remove(0));
            }
        }
        return list;
    }

    private int c(String str, String str2) {
        String e2 = AdvPrefUtil.getInstance().e("key_rotating" + str2, null);
        if (!TextUtils.isEmpty(e2) && e2.startsWith(str)) {
            try {
                return Integer.valueOf(e2.substring(str.length() + 1, e2.length())).intValue();
            } catch (Exception unused) {
                return 0;
            }
        }
        return 0;
    }

    private String d(List<AdsItem> list) {
        String str = null;
        if (list != null && list.size() != 0) {
            for (AdsItem adsItem : list) {
                str = TextUtils.isEmpty(str) ? adsItem.loadSDK + "" : str + adsItem.loadSDK;
            }
        }
        return str;
    }

    private void e(String str, String str2, int i2) {
        AdvPrefUtil.getInstance().h("key_rotating" + str, str2 + "_" + i2);
    }

    public List<AdsItem> b(List<AdsItem> list, String str) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String d2 = d(list);
        ArrayList arrayList3 = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            AdsItem adsItem = list.get(i2);
            if (adsItem.rotating == 1) {
                arrayList.add(Integer.valueOf(i2));
                arrayList2.add(adsItem);
            } else {
                arrayList3.add(adsItem);
            }
        }
        if (arrayList2.size() == 0) {
            return arrayList3;
        }
        int c = c(d2, str);
        us.pinguo.advsdk.utils.b.a("order:curIndex:" + c);
        if (c >= arrayList2.size()) {
            c = 0;
        }
        a(arrayList2, c);
        e(str, d2, c + 1);
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            arrayList3.add(((Integer) arrayList.get(i3)).intValue(), arrayList2.get(i3));
        }
        return arrayList3;
    }
}
