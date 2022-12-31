package us.pinguo.inspire.module.feeds.cell;

import us.pinguo.widget.common.cell.recycler.c;
/* loaded from: classes9.dex */
public abstract class FeedsBaseCell<T, VH extends us.pinguo.widget.common.cell.recycler.c> extends us.pinguo.inspire.cell.recycler.a<T, VH> {
    public FeedsBaseCell(T t) {
        super(t);
    }

    @Override // us.pinguo.inspire.cell.recycler.a
    protected String getShowKey() {
        return "Community_Portal_Feed_Show";
    }

    @Override // us.pinguo.inspire.cell.recycler.a
    protected String getTimeKey() {
        return "community_feed_focus_timespend";
    }
}
