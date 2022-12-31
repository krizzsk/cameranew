package us.pinguo.inspire.module.feeds.cell;

import us.pinguo.inspire.module.discovery.cell.DiscoveryHotVideoCell;
import us.pinguo.inspire.module.discovery.entity.dicovery.DiscoveryFixedItem;
/* loaded from: classes9.dex */
public class FeedsHotVideoCell extends DiscoveryHotVideoCell {
    public FeedsHotVideoCell(DiscoveryFixedItem discoveryFixedItem) {
        super(discoveryFixedItem);
    }

    @Override // us.pinguo.inspire.module.discovery.cell.DiscoveryHotVideoCell, us.pinguo.inspire.widget.videocell.d, us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return 20;
    }
}
