package us.pinguo.edit2020.bean;

import us.pinguo.repository2020.entity.MaterialColor;
/* compiled from: SelfDefMakeupColorFunction.kt */
/* loaded from: classes4.dex */
public final class i0 extends k0 {
    private final MaterialColor c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i0(MaterialColor selfDefMakeupColor, String topicName) {
        super(selfDefMakeupColor, topicName);
        kotlin.jvm.internal.s.h(selfDefMakeupColor, "selfDefMakeupColor");
        kotlin.jvm.internal.s.h(topicName, "topicName");
        this.c = selfDefMakeupColor;
    }

    @Override // us.pinguo.edit2020.bean.k0, us.pinguo.edit2020.bean.x
    public String f() {
        String cid = this.c.getCid();
        return cid == null ? "" : cid;
    }
}
