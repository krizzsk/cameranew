package com.tapjoy.internal;

import android.content.SharedPreferences;
/* loaded from: classes3.dex */
public final class l extends m {
    private final long c;

    public l(SharedPreferences sharedPreferences, String str) {
        super(sharedPreferences, str);
        this.c = 0L;
    }

    public final long a() {
        return this.a.getLong(this.b, this.c);
    }

    public final void a(long j2) {
        this.a.edit().putLong(this.b, j2).apply();
    }

    public final SharedPreferences.Editor a(SharedPreferences.Editor editor) {
        return editor.remove(this.b);
    }

    public final SharedPreferences.Editor a(SharedPreferences.Editor editor, long j2) {
        return editor.putLong(this.b, j2);
    }
}
