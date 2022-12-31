package us.pinguo.inspire.module.publish.cell;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import us.pinguo.inspire.module.publish.vo.LocationInfo;
import us.pinguo.widget.common.cell.recycler.b;
import us.pinguo.widget.common.cell.recycler.c;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class SelectNoLocCell extends b<LocationInfo, c> implements View.OnClickListener {
    private boolean mSelected;

    public SelectNoLocCell(LocationInfo locationInfo) {
        super(locationInfo);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public c createViewHolder(ViewGroup viewGroup) {
        return createHolderByLayout(R.layout.cell_select_no_cell, viewGroup);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return 0;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    protected void onBindViewHolder(c cVar) {
        cVar.itemView.setOnClickListener(this);
        if (this.mSelected) {
            cVar.show(R.id.iv_status_select_no_loc);
        } else {
            cVar.hide(R.id.iv_status_select_no_loc);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mViewHolder.itemView.getContext() instanceof Activity) {
            Activity activity = (Activity) this.mViewHolder.itemView.getContext();
            Intent intent = new Intent();
            intent.putExtra("extra_location_info", (Parcelable) this.mData);
            activity.setResult(-1, intent);
            activity.finish();
        }
    }

    public void setSelected(boolean z) {
        this.mSelected = z;
    }
}
