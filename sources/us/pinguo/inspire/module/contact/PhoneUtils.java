package us.pinguo.inspire.module.contact;

import java.util.regex.Pattern;
import us.pinguo.common.network.common.header.PGTransHeader;
/* loaded from: classes9.dex */
public class PhoneUtils {
    public static boolean isValid(String str) {
        return Pattern.compile("^\\d{6,13}$").matcher(phoneFormat(str)).matches();
    }

    public static String phoneFormat(String str) {
        return str.replaceAll(" ", "").replaceAll("\\+", "").replaceAll(PGTransHeader.CONNECTOR, "");
    }
}
