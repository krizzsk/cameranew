package us.pinguo.admobvista.f;

import android.text.TextUtils;
import java.util.regex.Pattern;
/* compiled from: SystemUtils.java */
/* loaded from: classes3.dex */
public class b {
    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("^[0-9a-z_-][_.0-9a-z-]{0,31}@([0-9a-z][0-9a-z-]{0,30}\\.){1,4}[a-z]{2,4}$", 2).matcher(str).matches();
    }
}
