package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import java.util.HashSet;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class q {
    private final Context a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(@NonNull Context context) {
        this.a = context;
    }

    private final SharedPreferences b() {
        return this.a.getSharedPreferences("playcore_split_install_internal", 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized Set<String> a() {
        Set<String> stringSet;
        try {
            stringSet = b().getStringSet("deferred_uninstall_module_list", new HashSet());
            if (stringSet == null) {
                stringSet = new HashSet<>();
            }
        } catch (Exception unused) {
            return new HashSet();
        }
        return stringSet;
    }
}
