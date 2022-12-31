package us.pinguo.payssion;
/* loaded from: classes5.dex */
public class Conditions {
    public static Configs current = Configs.Google;

    /* loaded from: classes5.dex */
    public enum Configs {
        Other2,
        Google,
        DebugGoogle,
        Xiaomi,
        Anzhi,
        GoogleBeforeL,
        Huawei,
        Debug,
        ProguardOther,
        Other
    }

    public static boolean isAnzhi() {
        return false;
    }

    public static boolean isDebug() {
        return false;
    }

    public static boolean isDebugGoogle() {
        return false;
    }

    public static boolean isGoogle() {
        return true;
    }

    public static boolean isGoogleBeforeL() {
        return false;
    }

    public static boolean isHuawei() {
        return false;
    }

    public static boolean isOther() {
        return false;
    }

    public static boolean isOther2() {
        return false;
    }

    public static boolean isProguardOther() {
        return false;
    }

    public static boolean isXiaomi() {
        return false;
    }
}
