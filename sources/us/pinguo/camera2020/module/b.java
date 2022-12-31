package us.pinguo.camera2020.module;

import java.util.ArrayList;
import kotlin.jvm.internal.s;
/* compiled from: ExclusiveEffectManager.kt */
/* loaded from: classes3.dex */
public final class b {
    private final ArrayList<a> a = new ArrayList<>();

    public final void a(ExclusiveEffectType effectType) {
        s.h(effectType, "effectType");
        for (a aVar : this.a) {
            aVar.c(effectType);
        }
    }

    public final boolean b(ExclusiveEffectType effectType) {
        s.h(effectType, "effectType");
        for (a aVar : this.a) {
            if (!aVar.b(effectType)) {
                return false;
            }
        }
        return true;
    }

    public final void c(ExclusiveEffectType effectType) {
        s.h(effectType, "effectType");
        for (a aVar : this.a) {
            aVar.a(effectType);
        }
    }

    public final void d(a observer) {
        s.h(observer, "observer");
        if (this.a.contains(observer)) {
            return;
        }
        this.a.add(observer);
    }
}
