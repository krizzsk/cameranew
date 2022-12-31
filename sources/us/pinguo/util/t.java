package us.pinguo.util;

import android.text.TextUtils;
import java.util.regex.Pattern;
/* compiled from: TextPlusUtils.kt */
/* loaded from: classes6.dex */
public final class t {
    public static final boolean a(String email) {
        kotlin.jvm.internal.s.h(email, "email");
        if (TextUtils.isEmpty(email)) {
            return false;
        }
        return Pattern.compile("^[0-9a-z_-][_.0-9a-z-]{0,31}@([0-9a-z][0-9a-z-]{0,30}\\.){1,4}[a-z]{2,4}$", 2).matcher(email).matches();
    }

    public static final boolean b(String phoneNumber) {
        kotlin.jvm.internal.s.h(phoneNumber, "phoneNumber");
        if (TextUtils.isEmpty(phoneNumber)) {
            return false;
        }
        return Pattern.compile("^1[0-9]{10}$|^([6|9])\\d{7}$|^[0][9]\\d{8}$|^[6]([8|6])\\d{5}$").matcher(phoneNumber).matches();
    }
}
