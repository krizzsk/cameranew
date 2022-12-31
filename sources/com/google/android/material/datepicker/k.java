package com.google.android.material.datepicker;

import androidx.annotation.Nullable;
import java.util.Calendar;
import java.util.TimeZone;
/* compiled from: TimeSource.java */
/* loaded from: classes2.dex */
class k {
    private static final k c = new k(null, null);
    @Nullable
    private final Long a;
    @Nullable
    private final TimeZone b;

    private k(@Nullable Long l2, @Nullable TimeZone timeZone) {
        this.a = l2;
        this.b = timeZone;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static k c() {
        return c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Calendar a() {
        return b(this.b);
    }

    Calendar b(@Nullable TimeZone timeZone) {
        Calendar calendar = timeZone == null ? Calendar.getInstance() : Calendar.getInstance(timeZone);
        Long l2 = this.a;
        if (l2 != null) {
            calendar.setTimeInMillis(l2.longValue());
        }
        return calendar;
    }
}
