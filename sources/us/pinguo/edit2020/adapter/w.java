package us.pinguo.edit2020.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Space;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.bean.TutorialModel;
import us.pinguo.edit2020.manager.AutoPlayDetector;
import us.pinguo.edit2020.view.ListPlayView;
/* compiled from: BodyShapingTutorialAdapter.kt */
/* loaded from: classes4.dex */
public final class w extends RecyclerView.Adapter<a> {
    private final TutorialModel[] a;
    private final AutoPlayDetector b;

    /* compiled from: BodyShapingTutorialAdapter.kt */
    /* loaded from: classes4.dex */
    public static final class a extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            kotlin.jvm.internal.s.h(view, "view");
        }

        public final void a(TutorialModel tutorialModel, boolean z) {
            kotlin.jvm.internal.s.h(tutorialModel, "tutorialModel");
            Context context = this.itemView.getContext();
            ((ListPlayView) this.itemView.findViewById(R.id.videoPlayer)).e(tutorialModel.getSourcePath(), tutorialModel.getCoverPath(), tutorialModel.getDefaultCoverImg());
            Space space = (Space) this.itemView.findViewById(R.id.spacer);
            kotlin.jvm.internal.s.g(space, "itemView.spacer");
            int i2 = z ? 0 : 8;
            space.setVisibility(i2);
            VdsAgent.onSetViewVisibility(space, i2);
            ((TextView) this.itemView.findViewById(R.id.funcName)).setText(context.getString(tutorialModel.getTitle()));
            ((TextView) this.itemView.findViewById(R.id.funDesc)).setText(context.getString(tutorialModel.getDesc()));
        }
    }

    public w(TutorialModel[] dataList, AutoPlayDetector playDetector) {
        kotlin.jvm.internal.s.h(dataList, "dataList");
        kotlin.jvm.internal.s.h(playDetector, "playDetector");
        this.a = dataList;
        this.b = playDetector;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: e */
    public void onBindViewHolder(a holder, int i2) {
        kotlin.jvm.internal.s.h(holder, "holder");
        holder.a(this.a[i2], i2 == getItemCount() - 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: f */
    public a onCreateViewHolder(ViewGroup parent, int i2) {
        kotlin.jvm.internal.s.h(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tutorial_list_layout, parent, false);
        kotlin.jvm.internal.s.g(inflate, "from(parent.context).inf…t,\n                false)");
        return new a(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: g */
    public void onViewAttachedToWindow(a holder) {
        kotlin.jvm.internal.s.h(holder, "holder");
        super.onViewAttachedToWindow(holder);
        AutoPlayDetector autoPlayDetector = this.b;
        ListPlayView listPlayView = (ListPlayView) holder.itemView.findViewById(R.id.videoPlayer);
        kotlin.jvm.internal.s.g(listPlayView, "holder.itemView.videoPlayer");
        autoPlayDetector.k(listPlayView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.a.length;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h */
    public void onViewDetachedFromWindow(a holder) {
        kotlin.jvm.internal.s.h(holder, "holder");
        super.onViewDetachedFromWindow(holder);
        AutoPlayDetector autoPlayDetector = this.b;
        ListPlayView listPlayView = (ListPlayView) holder.itemView.findViewById(R.id.videoPlayer);
        kotlin.jvm.internal.s.g(listPlayView, "holder.itemView.videoPlayer");
        autoPlayDetector.s(listPlayView);
    }
}
