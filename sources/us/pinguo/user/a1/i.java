package us.pinguo.user.a1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import us.pinguo.inspire.module.profile.entry.GeoProvince;
import us.pinguo.user.R;
import us.pinguo.user.a1.h;
/* compiled from: EditAreaProvinceCell.java */
/* loaded from: classes6.dex */
public class i extends us.pinguo.widget.common.cell.recycler.b<GeoProvince, a> {
    private h.b a;

    /* compiled from: EditAreaProvinceCell.java */
    /* loaded from: classes6.dex */
    public static class a extends us.pinguo.widget.common.cell.recycler.c {
        public TextView a;

        public a(View view) {
            super(view);
            this.a = (TextView) view.findViewById(R.id.edit_area_item_text);
        }
    }

    public i(GeoProvince geoProvince) {
        super(geoProvince);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void c(View view) {
        VdsAgent.lambdaOnClick(view);
        h.b bVar = this.a;
        if (bVar != null) {
            bVar.M((GeoProvince) this.mData);
        }
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    /* renamed from: a */
    public a createViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.eidt_area_item_cell, viewGroup, false));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.widget.common.cell.recycler.b
    /* renamed from: d */
    public void onBindViewHolder(a aVar) {
        aVar.a.setText(((GeoProvince) this.mData).name);
        aVar.a.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.user.a1.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i.this.c(view);
            }
        });
    }

    public void e(h.b bVar) {
        this.a = bVar;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return 3;
    }
}
