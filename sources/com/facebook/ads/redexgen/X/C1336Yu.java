package com.facebook.ads.redexgen.X;

import android.app.KeyguardManager;
import android.os.Build;
/* renamed from: com.facebook.ads.redexgen.X.Yu  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1336Yu implements InterfaceC06356k {
    public static String[] A01 = {"wdcki9TayB0epgOAqgPZ60vGLzXQskFg", "eaUsA8pmkvwqM9uF8kH4nQuKK9Zu7ymc", "2dfJX", "k6tMd5tlxlmCEJMQTJf7pwLJqfV91j3Q", "YVwPmyUK2b9QSHLRAwsi84oHRZQXtzOF", "hpSXL0XJUd77PKoaf1", "iaFmBfogLFf9YiLH80pKK2KW3oFuZo4T", "28ANuaZ3OB7zLgtTtX"};
    public final /* synthetic */ C1334Ys A00;

    public C1336Yu(C1334Ys c1334Ys) {
        this.A00 = c1334Ys;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() {
        KeyguardManager keyguardManager;
        KeyguardManager keyguardManager2;
        if (Build.VERSION.SDK_INT >= 16) {
            keyguardManager = this.A00.A00;
            if (keyguardManager == null) {
                C1334Ys c1334Ys = this.A00;
                String[] strArr = A01;
                if (strArr[7].length() != strArr[5].length()) {
                    throw new RuntimeException();
                }
                A01[0] = "xEd7j65KlJaDHlrOXF5qOqVEOzAiF9i5";
                return c1334Ys.A07(EnumC06466v.A07);
            }
            C1334Ys c1334Ys2 = this.A00;
            keyguardManager2 = c1334Ys2.A00;
            return c1334Ys2.A0F(keyguardManager2.isKeyguardLocked());
        }
        return this.A00.A07(EnumC06466v.A05);
    }
}
