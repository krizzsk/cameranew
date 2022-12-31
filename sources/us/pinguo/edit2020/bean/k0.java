package us.pinguo.edit2020.bean;

import androidx.databinding.ObservableBoolean;
import us.pinguo.edit2020.bean.x;
import us.pinguo.repository2020.entity.SelfDefMakeupMaterial;
/* compiled from: SelfDefMakeupMaterialFunction.kt */
/* loaded from: classes4.dex */
public class k0 implements x {
    private final SelfDefMakeupMaterial a;
    private final String b;

    public k0(SelfDefMakeupMaterial selfDefMakeupMaterial, String topicName) {
        kotlin.jvm.internal.s.h(selfDefMakeupMaterial, "selfDefMakeupMaterial");
        kotlin.jvm.internal.s.h(topicName, "topicName");
        this.a = selfDefMakeupMaterial;
        this.b = topicName;
    }

    @Override // us.pinguo.edit2020.bean.x
    public boolean a() {
        Integer vip = this.a.getVip();
        return vip != null && vip.intValue() == 1;
    }

    @Override // us.pinguo.edit2020.bean.x
    public boolean b() {
        return x.a.a(this);
    }

    @Override // us.pinguo.edit2020.bean.x
    public String c() {
        String name = this.a.getName();
        return name == null ? "" : name;
    }

    @Override // us.pinguo.edit2020.bean.x
    public int d() {
        return 0;
    }

    @Override // us.pinguo.edit2020.bean.x
    public boolean e() {
        ObservableBoolean isSelected = this.a.isSelected();
        return isSelected != null && isSelected.get();
    }

    @Override // us.pinguo.edit2020.bean.x
    public String f() {
        String pid = this.a.getPid();
        return pid == null ? "" : pid;
    }

    public final String g() {
        return this.b;
    }
}
