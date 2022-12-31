package us.pinguo.inspire.module.discovery.cell;

import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.cell.recycler.e;
import us.pinguo.widget.common.cell.recycler.c;
/* loaded from: classes9.dex */
public abstract class ADiscoveryWaterFallCell<T, VH extends c> extends e<T, VH> implements IWaterFallCell {
    protected static final double MAX_ASPECT_RATIO = 1.3333333333333333d;
    protected static final double MIN_ASPECT_RATIO = 0.75d;
    protected int mScreenWidth;

    public ADiscoveryWaterFallCell(T t) {
        super(t);
        this.mScreenWidth = us.pinguo.foundation.t.b.a.j(Inspire.a());
    }
}
