package us.pinguo.inspire.module.message.category.cell;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import us.pinguo.inspire.module.publish.vo.LocationInfo;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class SelectLocCell extends us.pinguo.widget.common.cell.recycler.b<LocationInfo, us.pinguo.widget.common.cell.recycler.c> implements View.OnClickListener {
    private boolean mSelected;

    public SelectLocCell(LocationInfo locationInfo) {
        super(locationInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void b() {
        if (this.mViewHolder.itemView.getContext() instanceof Activity) {
            Activity activity = (Activity) this.mViewHolder.itemView.getContext();
            Intent intent = new Intent();
            intent.putExtra("extra_location_info", (Parcelable) this.mData);
            activity.setResult(-1, intent);
            activity.finish();
        }
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public us.pinguo.widget.common.cell.recycler.c createViewHolder(ViewGroup viewGroup) {
        return createHolderByLayout(R.layout.cell_select_loc, viewGroup);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return 1;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    protected void onBindViewHolder(us.pinguo.widget.common.cell.recycler.c cVar) {
        T t = this.mData;
        cVar.setText(R.id.tv_poi_select_loc, ((LocationInfo) t).poi == null ? "" : ((LocationInfo) t).poi);
        T t2 = this.mData;
        cVar.setText(R.id.tv_address_select_loc, ((LocationInfo) t2).address != null ? ((LocationInfo) t2).address : "");
        if (TextUtils.isEmpty(((LocationInfo) this.mData).address)) {
            cVar.hide(R.id.tv_address_select_loc);
        } else {
            cVar.show(R.id.tv_address_select_loc);
        }
        if (this.mSelected) {
            cVar.show(R.id.iv_status_select_loc);
        } else {
            cVar.hide(R.id.iv_status_select_loc);
        }
        cVar.itemView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        List<us.pinguo.widget.common.cell.recycler.b> cells = this.mAdapter.getCells();
        if (cells != null) {
            for (us.pinguo.widget.common.cell.recycler.b bVar : cells) {
                if (bVar instanceof SelectLocCell) {
                    ((SelectLocCell) bVar).setSelected(false);
                }
            }
        }
        setSelected(true);
        view.postDelayed(new Runnable() { // from class: us.pinguo.inspire.module.message.category.cell.j
            @Override // java.lang.Runnable
            public final void run() {
                SelectLocCell.this.b();
            }
        }, 300L);
    }

    public void setSelected(boolean z) {
        if (this.mSelected != z) {
            this.mSelected = z;
            updateData((LocationInfo) this.mData);
        }
    }
}
