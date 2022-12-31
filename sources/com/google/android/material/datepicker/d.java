package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Build;
import android.text.format.DateUtils;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DateStrings.java */
/* loaded from: classes2.dex */
public class d {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static Pair<String, String> a(@Nullable Long l2, @Nullable Long l3) {
        return b(l2, l3, null);
    }

    static Pair<String, String> b(@Nullable Long l2, @Nullable Long l3, @Nullable SimpleDateFormat simpleDateFormat) {
        if (l2 == null && l3 == null) {
            return Pair.create(null, null);
        }
        if (l2 == null) {
            return Pair.create(null, d(l3.longValue(), simpleDateFormat));
        }
        if (l3 == null) {
            return Pair.create(d(l2.longValue(), simpleDateFormat), null);
        }
        Calendar o = l.o();
        Calendar q = l.q();
        q.setTimeInMillis(l2.longValue());
        Calendar q2 = l.q();
        q2.setTimeInMillis(l3.longValue());
        if (simpleDateFormat != null) {
            return Pair.create(simpleDateFormat.format(new Date(l2.longValue())), simpleDateFormat.format(new Date(l3.longValue())));
        } else if (q.get(1) == q2.get(1)) {
            if (q.get(1) == o.get(1)) {
                return Pair.create(f(l2.longValue(), Locale.getDefault()), f(l3.longValue(), Locale.getDefault()));
            }
            return Pair.create(f(l2.longValue(), Locale.getDefault()), k(l3.longValue(), Locale.getDefault()));
        } else {
            return Pair.create(k(l2.longValue(), Locale.getDefault()), k(l3.longValue(), Locale.getDefault()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c(long j2) {
        return d(j2, null);
    }

    static String d(long j2, @Nullable SimpleDateFormat simpleDateFormat) {
        Calendar o = l.o();
        Calendar q = l.q();
        q.setTimeInMillis(j2);
        if (simpleDateFormat != null) {
            return simpleDateFormat.format(new Date(j2));
        }
        if (o.get(1) == q.get(1)) {
            return e(j2);
        }
        return j(j2);
    }

    static String e(long j2) {
        return f(j2, Locale.getDefault());
    }

    static String f(long j2, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return l.c(locale).format(new Date(j2));
        }
        return l.j(locale).format(new Date(j2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String g(long j2) {
        return h(j2, Locale.getDefault());
    }

    static String h(long j2, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return l.d(locale).format(new Date(j2));
        }
        return l.h(locale).format(new Date(j2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String i(Context context, long j2) {
        return DateUtils.formatDateTime(context, j2 - TimeZone.getDefault().getOffset(j2), 36);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String j(long j2) {
        return k(j2, Locale.getDefault());
    }

    static String k(long j2, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return l.s(locale).format(new Date(j2));
        }
        return l.i(locale).format(new Date(j2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String l(long j2) {
        return m(j2, Locale.getDefault());
    }

    static String m(long j2, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return l.t(locale).format(new Date(j2));
        }
        return l.h(locale).format(new Date(j2));
    }
}
