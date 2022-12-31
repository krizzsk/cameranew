package com.pinguo.camera360.test;

import com.pinguo.camera360.abtest.Plan;
import kotlin.jvm.internal.Lambda;
/* compiled from: ABActivity.kt */
/* loaded from: classes3.dex */
final class ABActivity$buildAbPlanOnline$plans$1 extends Lambda implements kotlin.jvm.b.l<Plan, String> {
    public static final ABActivity$buildAbPlanOnline$plans$1 INSTANCE = new ABActivity$buildAbPlanOnline$plans$1();

    ABActivity$buildAbPlanOnline$plans$1() {
        super(1);
    }

    @Override // kotlin.jvm.b.l
    public final String invoke(Plan it) {
        kotlin.jvm.internal.s.h(it, "it");
        return it.getGid();
    }
}
