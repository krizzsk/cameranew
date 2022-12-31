package us.pinguo.foundation.utils;
/* compiled from: StringUtils.java */
/* loaded from: classes4.dex */
public class f0 {
    public static String[] a(String str, String str2) {
        return str == null ? new String[0] : str.split(str2);
    }

    public static boolean b(String str, String str2) {
        if (str == str2) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }

    public static String c(String str) {
        if (str == null) {
            return null;
        }
        return str.trim();
    }

    public static String d(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(Character.toLowerCase(str.charAt(0)));
        stringBuffer.append(str.substring(1));
        return stringBuffer.toString();
    }
}
