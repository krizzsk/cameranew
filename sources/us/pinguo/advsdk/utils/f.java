package us.pinguo.advsdk.utils;

import android.text.TextUtils;
import java.util.Locale;
import us.pinguo.inspire.module.message.category.entity.InspireMsg;
/* compiled from: AreaUtil.java */
/* loaded from: classes3.dex */
public class f {
    private String[] a = {InspireMsg.TYPE_AT, "be", "bg", "cy", "hr", "cz", "dk", "ee", "fl", "fr", "de", "gr", "hu", "ie", "it", "lv", "lt", "lu", "mt", "nl", "pl", "pt", "ro", "sk", "sl", "es", "se", "gb", "is", "li", "no"};

    public boolean a() {
        String country = Locale.getDefault().getCountry();
        if (TextUtils.isEmpty(country)) {
            return false;
        }
        for (String str : this.a) {
            if (str.equals(country.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
