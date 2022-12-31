package us.pinguo.user.a1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import us.pinguo.inspire.module.profile.entry.GeoCity;
import us.pinguo.user.R;
import us.pinguo.user.a1.h;
/* compiled from: EditAreaCityCell.java */
/* loaded from: classes6.dex */
public class e extends us.pinguo.widget.common.cell.recycler.b<GeoCity, a> {
    private h.b a;

    /* compiled from: EditAreaCityCell.java */
    /* loaded from: classes6.dex */
    public static class a extends us.pinguo.widget.common.cell.recycler.c {
        public TextView a;

        public a(View view) {
            super(view);
            this.a = (TextView) view.findViewById(R.id.edit_area_item_text);
        }
    }

    public e(GeoCity geoCity) {
        super(geoCity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void c(View view) {
        VdsAgent.lambdaOnClick(view);
        h.b bVar = this.a;
        if (bVar != null) {
            bVar.M((GeoCity) this.mData);
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
        aVar.a.setText(((GeoCity) this.mData).name);
        aVar.a.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.user.a1.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.this.c(view);
            }
        });
    }

    public void e(h.b bVar) {
        this.a = bVar;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return 1;
    }
}
