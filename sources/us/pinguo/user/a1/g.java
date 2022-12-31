package us.pinguo.user.a1;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import us.pinguo.inspire.module.profile.GeoResp;
import us.pinguo.user.R;
/* compiled from: EditAreaHeaderCell.java */
/* loaded from: classes6.dex */
public class g extends us.pinguo.widget.common.cell.recycler.b<GeoResp, a> {
    private a a;
    private b b;
    private boolean c;

    /* compiled from: EditAreaHeaderCell.java */
    /* loaded from: classes6.dex */
    public static class a extends us.pinguo.widget.common.cell.recycler.c {
        public TextView a;
        public View b;
        public View c;

        public a(View view) {
            super(view);
            this.a = (TextView) view.findViewById(R.id.edit_area_header_location);
            this.b = view.findViewById(R.id.edit_area_header_no_location_tip);
            this.c = view.findViewById(R.id.edit_area_header_location_layout);
        }
    }

    /* compiled from: EditAreaHeaderCell.java */
    /* loaded from: classes6.dex */
    public interface b {
        void a();
    }

    public g(GeoResp geoResp) {
        super(geoResp);
        this.c = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void c(View view) {
        VdsAgent.lambdaOnClick(view);
        b bVar = this.b;
        if (bVar != null) {
            bVar.a();
        }
        if (this.mData != 0) {
            us.pinguo.foundation.r.d.a().b(new us.pinguo.user.event.b((GeoResp) this.mData));
            ((Activity) view.getContext()).finish();
        }
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    /* renamed from: a */
    public a createViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.edit_area_header_cell, viewGroup, false));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.widget.common.cell.recycler.b
    /* renamed from: d */
    public void onBindViewHolder(a aVar) {
        this.a = aVar;
        aVar.c.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.user.a1.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g.this.c(view);
            }
        });
        if (this.c) {
            View view = aVar.c;
            view.setVisibility(0);
            VdsAgent.onSetViewVisibility(view, 0);
            View view2 = aVar.b;
            view2.setVisibility(8);
            VdsAgent.onSetViewVisibility(view2, 8);
        } else {
            View view3 = aVar.c;
            view3.setVisibility(8);
            VdsAgent.onSetViewVisibility(view3, 8);
            View view4 = aVar.b;
            view4.setVisibility(0);
            VdsAgent.onSetViewVisibility(view4, 0);
        }
        T t = this.mData;
        if (t == 0) {
            return;
        }
        aVar.a.setText(((GeoResp) t).info.toString());
    }

    public void e(b bVar) {
        this.b = bVar;
    }

    public void f() {
        this.c = false;
        a aVar = this.a;
        if (aVar != null) {
            View view = aVar.b;
            view.setVisibility(0);
            VdsAgent.onSetViewVisibility(view, 0);
            View view2 = this.a.c;
            view2.setVisibility(8);
            VdsAgent.onSetViewVisibility(view2, 8);
        }
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return 0;
    }
}
