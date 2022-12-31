package kotlinx.coroutines.selects;

import kotlinx.coroutines.internal.c0;
/* compiled from: Select.kt */
/* loaded from: classes3.dex */
public final class g {
    private static final Object a = new c0("NOT_SELECTED");
    private static final Object b = new c0("ALREADY_SELECTED");
    private static final Object c = new c0("UNDECIDED");

    /* renamed from: d  reason: collision with root package name */
    private static final Object f8820d = new c0("RESUMED");

    /* renamed from: e  reason: collision with root package name */
    private static final h f8821e = new h();

    public static final Object d() {
        return b;
    }

    public static final Object e() {
        return a;
    }
}
