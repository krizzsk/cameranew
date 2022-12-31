package us.pinguo.repository2020.database;

import kotlin.jvm.internal.s;
/* compiled from: EffectDbManager.kt */
/* loaded from: classes6.dex */
public final class a {
    public static EffectDbManager a;

    public static final EffectDbManager a() {
        EffectDbManager effectDbManager = a;
        if (effectDbManager != null) {
            return effectDbManager;
        }
        s.z("effectDbManager");
        throw null;
    }

    public static final void b(EffectDbManager effectDbManager) {
        s.h(effectDbManager, "<set-?>");
        a = effectDbManager;
    }
}
