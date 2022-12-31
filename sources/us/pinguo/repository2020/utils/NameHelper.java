package us.pinguo.repository2020.utils;

import android.text.TextUtils;
import com.pinguo.lib.GsonUtilKt;
import java.util.Locale;
import java.util.Map;
import us.pinguo.admobvista.StaticsAdv.IADStatisticBase;
import us.pinguo.foundation.utils.NoProguard;
/* loaded from: classes6.dex */
public class NameHelper {
    private String a;
    private Map<String, Name> b = null;

    /* loaded from: classes6.dex */
    public class Name implements NoProguard {
        public String name = null;
        public String description = null;

        public Name() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a extends com.google.gson.t.a<Map<String, Name>> {
        a(NameHelper nameHelper) {
        }
    }

    public NameHelper(String str) {
        this.a = str;
    }

    private void b() {
        try {
            if (this.b == null) {
                this.b = (Map) GsonUtilKt.getCachedGson().k(this.a, new a(this).getType());
            }
        } catch (Exception unused) {
            this.b = null;
        }
    }

    public String a(Locale locale) {
        String str;
        if (TextUtils.isEmpty(this.a)) {
            return "";
        }
        if (this.a.startsWith("{") && this.a.endsWith("}")) {
            if (this.b == null) {
                b();
            }
            if (this.b == null) {
                return "";
            }
            String language = locale.getLanguage();
            String country = locale.getCountry();
            if (!TextUtils.isEmpty(country)) {
                String lowerCase = country.toLowerCase(Locale.ENGLISH);
                Map<String, Name> map = this.b;
                Name name = map.get(language + "_" + lowerCase);
                if (name != null && !TextUtils.isEmpty(name.name)) {
                    return name.name;
                }
            }
            Name name2 = this.b.get(language);
            if (name2 != null && !TextUtils.isEmpty(name2.name)) {
                return name2.name;
            }
            Name name3 = this.b.get(IADStatisticBase.VARCHAR_DEFALUT_VALUE);
            return (name3 == null || (str = name3.name) == null) ? "" : str;
        }
        return this.a;
    }
}
