package com.google.android.play.core.internal;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
/* loaded from: classes2.dex */
public final class bx {
    private final Context a;

    public bx(Context context) {
        this.a = context;
    }

    private static String a(Locale locale) {
        String concat;
        String valueOf = String.valueOf(locale.getLanguage());
        if (locale.getCountry().isEmpty()) {
            concat = "";
        } else {
            String valueOf2 = String.valueOf(locale.getCountry());
            concat = valueOf2.length() != 0 ? "_".concat(valueOf2) : new String("_");
        }
        String valueOf3 = String.valueOf(concat);
        return valueOf3.length() != 0 ? valueOf.concat(valueOf3) : new String(valueOf);
    }

    public final List<String> b() {
        Configuration configuration = this.a.getResources().getConfiguration();
        if (Build.VERSION.SDK_INT >= 24) {
            LocaleList locales = configuration.getLocales();
            ArrayList arrayList = new ArrayList(locales.size());
            for (int i2 = 0; i2 < locales.size(); i2++) {
                arrayList.add(a(locales.get(i2)));
            }
            return arrayList;
        }
        return Collections.singletonList(a(configuration.locale));
    }
}
