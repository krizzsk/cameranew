package com.mob;

import com.mob.tools.proguard.PublicMemberKeeper;
@Deprecated
/* loaded from: classes2.dex */
public class RHolder implements PublicMemberKeeper {
    private static RHolder a;
    private int b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private int f5848d;

    private RHolder() {
    }

    public static RHolder getInstance() {
        if (a == null) {
            synchronized (RHolder.class) {
                if (a == null) {
                    a = new RHolder();
                }
            }
        }
        return a;
    }

    public int getActivityThemeId() {
        return this.b;
    }

    public int getDialogLayoutId() {
        return this.c;
    }

    public int getDialogThemeId() {
        return this.f5848d;
    }

    public RHolder setActivityThemeId(int i2) {
        this.b = i2;
        return a;
    }

    public RHolder setDialogLayoutId(int i2) {
        this.c = i2;
        return a;
    }

    public RHolder setDialogThemeId(int i2) {
        this.f5848d = i2;
        return a;
    }
}
