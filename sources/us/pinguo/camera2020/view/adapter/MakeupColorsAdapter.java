package us.pinguo.camera2020.view.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.List;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.text.StringsKt__StringsKt;
import us.pinguo.camera2020.R;
import us.pinguo.camera2020.widget.HalfColorView;
/* compiled from: MakeupColorsAdapter.kt */
/* loaded from: classes3.dex */
public final class MakeupColorsAdapter extends RecyclerView.Adapter<m> {
    private final Context a;
    private List<String> b;
    private l c;

    /* renamed from: d  reason: collision with root package name */
    private int f9338d;

    /* renamed from: e  reason: collision with root package name */
    private float f9339e;

    public MakeupColorsAdapter(Context context) {
        kotlin.jvm.internal.s.h(context, "context");
        this.a = context;
        this.f9338d = -1;
        this.f9339e = 1.75f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(MakeupColorsAdapter this$0, m holder, int i2, Ref$ObjectRef color1, Ref$ObjectRef color2, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(holder, "$holder");
        kotlin.jvm.internal.s.h(color1, "$color1");
        kotlin.jvm.internal.s.h(color2, "$color2");
        l lVar = this$0.c;
        if (lVar == null) {
            return;
        }
        View view2 = holder.itemView;
        kotlin.jvm.internal.s.g(view2, "holder.itemView");
        lVar.d(view2, i2, (String) color1.element, (String) color2.element);
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v6, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v4, types: [T, java.lang.Object] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: f */
    public void onBindViewHolder(final m holder, final int i2) {
        List o0;
        kotlin.jvm.internal.s.h(holder, "holder");
        List<String> list = this.b;
        if (list == null) {
            return;
        }
        o0 = StringsKt__StringsKt.o0(list.get(i2), new char[]{'|'}, false, 0, 6, null);
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = "";
        final Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        ref$ObjectRef2.element = "";
        HalfColorView halfColorView = (HalfColorView) holder.itemView.findViewById(R.id.hvMakeupColorItem);
        try {
            halfColorView.setEnableColorShow(true);
            if (o0.size() > 1) {
                ref$ObjectRef.element = o0.get(0);
                ref$ObjectRef2.element = o0.get(1);
                halfColorView.setEnableHalfShow(true);
                halfColorView.setTwoColors(Color.parseColor((String) ref$ObjectRef.element), Color.parseColor((String) ref$ObjectRef2.element));
            } else {
                ref$ObjectRef.element = o0.get(0);
                halfColorView.setEnableHalfShow(false);
                halfColorView.setColor(Color.parseColor((String) ref$ObjectRef.element));
            }
            if (i2 == this.f9338d) {
                holder.itemView.setScaleX(this.f9339e);
                holder.itemView.setScaleY(this.f9339e);
            } else {
                holder.itemView.setScaleX(1.0f);
                holder.itemView.setScaleY(1.0f);
            }
        } catch (Exception unused) {
            halfColorView.setEnableColorShow(false);
            halfColorView.setImageResource(Integer.parseInt((String) ref$ObjectRef.element));
        }
        halfColorView.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.camera2020.view.adapter.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MakeupColorsAdapter.g(MakeupColorsAdapter.this, holder, i2, ref$ObjectRef, ref$ObjectRef2, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<String> list = this.b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: h */
    public m onCreateViewHolder(ViewGroup parent, int i2) {
        kotlin.jvm.internal.s.h(parent, "parent");
        View itemView = LayoutInflater.from(this.a).inflate(R.layout.item_color, parent, false);
        kotlin.jvm.internal.s.g(itemView, "itemView");
        return new m(itemView);
    }

    public final boolean i(List<String> data, int i2) {
        kotlin.jvm.internal.s.h(data, "data");
        List<String> list = this.b;
        if (list != null && kotlin.jvm.internal.s.c(list, data) && this.f9338d == i2) {
            return false;
        }
        this.b = data;
        this.f9338d = i2;
        notifyDataSetChanged();
        return true;
    }

    public final void j(float f2) {
        this.f9339e = f2;
    }

    public final void k(l l2) {
        kotlin.jvm.internal.s.h(l2, "l");
        this.c = l2;
    }
}
