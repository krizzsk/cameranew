package us.pinguo.hawkeye;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class InternalPref {
    private static InternalPref b;
    private SharedPreferences a;

    private InternalPref() {
    }

    public static InternalPref getInstance() {
        if (b == null) {
            b = new InternalPref();
        }
        return b;
    }

    public boolean a(String str, boolean z) {
        return this.a.getBoolean(str, z);
    }

    public Set<String> b(String str) {
        return new HashSet(Arrays.asList(TextUtils.split(this.a.getString(str, ""), "‚‗‚")));
    }

    public void c(String str, boolean z) {
        SharedPreferences.Editor edit = this.a.edit();
        edit.putBoolean(str, z);
        edit.apply();
    }
}
