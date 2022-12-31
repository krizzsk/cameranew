package us.pinguo.inspire.module.discovery.cell;

import android.view.ViewGroup;
import us.pinguo.inspire.model.InspireTask;
import us.pinguo.widget.common.cell.recycler.c;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class IndexChallengeCell extends DiscoveryChallengeCell {
    public IndexChallengeCell(InspireTask inspireTask) {
        super(inspireTask);
    }

    @Override // us.pinguo.inspire.module.discovery.cell.DiscoveryChallengeCell, us.pinguo.widget.common.cell.recycler.b
    public c createViewHolder(ViewGroup viewGroup) {
        return createHolderByLayout(R.layout.index_challenge_cell, viewGroup);
    }

    @Override // us.pinguo.inspire.module.discovery.cell.DiscoveryChallengeCell, us.pinguo.inspire.cell.recycler.a
    protected String getShowKey() {
        return "Community_Portal_Feed_Show";
    }

    public IndexChallengeCell(InspireTask inspireTask, boolean z) {
        super(inspireTask, z);
    }

    public IndexChallengeCell(InspireTask inspireTask, int i2, boolean z) {
        super(inspireTask, i2, z);
    }
}
