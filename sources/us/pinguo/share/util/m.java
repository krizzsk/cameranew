package us.pinguo.share.util;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.ArrayList;
import java.util.List;
import us.pinguo.share.R;
/* compiled from: ShareItemAdapter.java */
/* loaded from: classes6.dex */
public class m extends RecyclerView.Adapter<a> {
    private DialogFragment a;
    private List<ExpandShareSite> b;
    private OnShareSiteClickListener c;

    /* renamed from: d  reason: collision with root package name */
    private String f11968d;

    /* compiled from: ShareItemAdapter.java */
    /* loaded from: classes6.dex */
    public static class a extends RecyclerView.ViewHolder {
        private ImageView a;
        private TextView b;

        public a(View view) {
            super(view);
            this.a = (ImageView) view.findViewById(R.id.iv);
            this.b = (TextView) view.findViewById(R.id.tv_title);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.container);
        }
    }

    public m(@Nullable DialogFragment dialogFragment, List<ExpandShareSite> list, OnShareSiteClickListener onShareSiteClickListener) {
        this.f11968d = "";
        this.a = dialogFragment;
        this.b = new ArrayList(list);
        this.c = onShareSiteClickListener;
        if (dialogFragment != null) {
            FragmentActivity activity = dialogFragment.getActivity();
            if (activity != null && activity.getClass().getSimpleName().equals("Camera2020Activity")) {
                this.f11968d = "photo_preview";
            } else if (activity instanceof us.pinguo.foundation.statistics.e) {
                this.f11968d = ((us.pinguo.foundation.statistics.e) activity).C();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void f(View view) {
        VdsAgent.lambdaOnClick(view);
        View view2 = (View) view.getParent();
        if (view2 == null || !(view2.getTag() instanceof ExpandShareSite) || this.c == null) {
            return;
        }
        ExpandShareSite expandShareSite = (ExpandShareSite) view2.getTag();
        us.pinguo.foundation.statistics.h.a.m(BaseShareDialog.a0(expandShareSite.a()), this.f11968d, "click");
        this.c.onShareSiteClick(this.a, expandShareSite);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: g */
    public void onBindViewHolder(a aVar, int i2) {
        int a2;
        int b;
        ImageView imageView = aVar.a;
        ExpandShareSite expandShareSite = this.b.get(i2);
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
        aVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.share.util.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                m.this.f(view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.b.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h */
    public a onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.inspire_publish_item, (ViewGroup) null));
    }
}
