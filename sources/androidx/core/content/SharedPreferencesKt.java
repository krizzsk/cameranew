package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: SharedPreferences.kt */
/* loaded from: classes.dex */
public final class SharedPreferencesKt {
    @SuppressLint({"ApplySharedPref"})
    public static final void edit(SharedPreferences sharedPreferences, boolean z, l<? super SharedPreferences.Editor, u> action) {
        s.h(sharedPreferences, "<this>");
        s.h(action, "action");
        SharedPreferences.Editor editor = sharedPreferences.edit();
        s.g(editor, "editor");
        action.invoke(editor);
        if (z) {
            editor.commit();
        } else {
            editor.apply();
        }
    }

    public static /* synthetic */ void edit$default(SharedPreferences sharedPreferences, boolean z, l action, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        s.h(sharedPreferences, "<this>");
        s.h(action, "action");
        SharedPreferences.Editor editor = sharedPreferences.edit();
        s.g(editor, "editor");
        action.invoke(editor);
        if (z) {
            editor.commit();
        } else {
            editor.apply();
        }
    }
}
