package com.camera360.dynamic_feature_splice;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import us.pinguo.share.util.ExpandShareSite;
/* compiled from: ShareItemAdapter.java */
/* loaded from: classes8.dex */
public abstract class j1 extends RecyclerView.Adapter<a> {
    private List<ExpandShareSite> a;

    /* compiled from: ShareItemAdapter.java */
    /* loaded from: classes8.dex */
    public static class a extends RecyclerView.ViewHolder {
        private ImageView a;
        private TextView b;

        public a(View view) {
            super(view);
            this.a = (ImageView) view.findViewById(vStudio.Android.Camera360.R.id.iv);
            this.b = (TextView) view.findViewById(vStudio.Android.Camera360.R.id.tv_title);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(vStudio.Android.Camera360.R.id.container_res_0x7f0901da);
        }
    }

    public j1(List<ExpandShareSite> list) {
        this.a = new ArrayList(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void f(View view) {
        View view2 = (View) view.getParent();
        if (view2 == null || !(view2.getTag() instanceof ExpandShareSite)) {
            return;
        }
        i((ExpandShareSite) view2.getTag());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: g */
    public void onBindViewHolder(a aVar, int i2) {
        int a2;
        int b;
        ImageView imageView = aVar.a;
        ExpandShareSite expandShareSite = this.a.get(i2);
        if (!TextUtils.isEmpty(expandShareSite.f())) {
            a2 = expandShareSite.b();
            b = expandShareSite.c();
        } else {
            a2 = us.pinguo.pgshare.commons.e.a(expandShareSite.a());
            b = us.pinguo.pgshare.commons.e.b(expandShareSite.a());
        }
        imageView.setBackgroundResource(a2);
        aVar.b.setText(imageView.getContext().getString(b));
        aVar.itemView.setTag(expandShareSite);
        aVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.camera360.dynamic_feature_splice.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                j1.this.f(view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h */
    public a onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(vStudio.Android.Camera360.R.layout.inspire_publish_item, (ViewGroup) null));
    }

    abstract void i(ExpandShareSite expandShareSite);
}
