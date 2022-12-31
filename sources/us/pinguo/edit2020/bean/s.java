package us.pinguo.edit2020.bean;

import us.pinguo.edit2020.bean.x;
import us.pinguo.repository2020.entity.FilterItem;
import us.pinguo.repository2020.entity.OperationLabel;
/* compiled from: FilterFunction.kt */
/* loaded from: classes4.dex */
public final class s implements x {
    private final FilterItem a;

    public s(FilterItem filterItem) {
        kotlin.jvm.internal.s.h(filterItem, "filterItem");
        this.a = filterItem;
    }

    @Override // us.pinguo.edit2020.bean.x
    public boolean a() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.a.isVip()) {
            int tagContent = this.a.getTagContent();
            OperationLabel operationLabel = OperationLabel.LABEL_FREE;
            if (tagContent != operationLabel.ordinal()) {
                return true;
            }
            if (this.a.getTagContent() == operationLabel.ordinal()) {
                if (!(currentTimeMillis <= this.a.getTagOffTime() && this.a.getTagOnTime() <= currentTimeMillis)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // us.pinguo.edit2020.bean.x
    public boolean b() {
        return x.a.a(this);
    }

    @Override // us.pinguo.edit2020.bean.x
    public String c() {
        return this.a.getName();
    }

    @Override // us.pinguo.edit2020.bean.x
    public int d() {
        return 0;
    }

    @Override // us.pinguo.edit2020.bean.x
    public boolean e() {
        return false;
    }

    @Override // us.pinguo.edit2020.bean.x
    public String f() {
        return this.a.getFilterId();
    }
}
