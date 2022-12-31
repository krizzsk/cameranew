package com.tapjoy.internal;

import android.view.animation.Animation;
/* loaded from: classes3.dex */
public class ad {
    protected final Animation a;

    /* renamed from: com.tapjoy.internal.ad$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[a.a().length];
            a = iArr;
            try {
                iArr[a.a - 1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[a.b - 1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[a.c - 1] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[a.f7295d - 1] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class a {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;

        /* renamed from: d  reason: collision with root package name */
        public static final int f7295d = 4;

        /* renamed from: e  reason: collision with root package name */
        private static final /* synthetic */ int[] f7296e = {1, 2, 3, 4};

        public static int[] a() {
            return (int[]) f7296e.clone();
        }
    }

    public ad(Animation animation) {
        this.a = animation;
        animation.setDuration(400L);
    }

    public Animation a() {
        return this.a;
    }

    public final ad b() {
        this.a.setDuration(600L);
        return this;
    }
}
