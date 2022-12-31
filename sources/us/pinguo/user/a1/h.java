package us.pinguo.user.a1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import us.pinguo.inspire.module.profile.entry.BaseGeoEntry;
import us.pinguo.inspire.module.profile.entry.GeoCountry;
import us.pinguo.user.R;
/* compiled from: EditAreaItemCell.java */
/* loaded from: classes6.dex */
public class h extends us.pinguo.widget.common.cell.recycler.b<GeoCountry, a> {
    private b a;

    /* compiled from: EditAreaItemCell.java */
    /* loaded from: classes6.dex */
    public static class a extends us.pinguo.widget.common.cell.recycler.c {
        public TextView a;

        public a(View view) {
            super(view);
            this.a = (TextView) view.findViewById(R.id.edit_area_item_text);
        }
    }

    /* compiled from: EditAreaItemCell.java */
    /* loaded from: classes6.dex */
    public interface b {
        <T extends BaseGeoEntry> void M(T t);
    }

    public h(GeoCountry geoCountry) {
        super(geoCountry);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void c(View view) {
        VdsAgent.lambdaOnClick(view);
        b bVar = this.a;
        if (bVar != null) {
            bVar.M((GeoCountry) this.mData);
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
        aVar.a.setText(((GeoCountry) this.mData).name);
        aVar.a.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.user.a1.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.this.c(view);
            }
        });
    }

    public void e(b bVar) {
        this.a = bVar;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return 1;
    }
}
