package com.mob.tools.log;
/* loaded from: classes2.dex */
public interface LogCollector {
    public static final int LEVEL_CRASH = 1;
    public static final int LEVEL_NATIVE = 2;
    public static final int LEVEL_NORMAL = 0;
    public static final int LEVEL_NORMAL_UPLOAD = 3;

    void log(String str, int i2, int i3, String str2, String str3);
}
