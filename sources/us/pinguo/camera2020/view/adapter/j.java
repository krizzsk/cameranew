package us.pinguo.camera2020.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.text.StringsKt__StringsKt;
import us.pinguo.camera2020.R;
import us.pinguo.repository2020.entity.BeautyData;
import us.pinguo.repository2020.entity.Material;
/* compiled from: BeautyAdapter.kt */
/* loaded from: classes3.dex */
public final class j extends RecyclerView.Adapter<a> implements us.pinguo.common.m.e {
    private final Context a;
    private final boolean b;
    private ObservableBoolean c;

    /* renamed from: d  reason: collision with root package name */
    private final ArrayList<BeautyData> f9344d;

    /* renamed from: e  reason: collision with root package name */
    private final ArrayList<ArrayList<BeautyData>> f9345e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<BeautyData> f9346f;

    /* renamed from: g  reason: collision with root package name */
    private int f9347g;

    /* renamed from: h  reason: collision with root package name */
    private int f9348h;

    /* renamed from: i  reason: collision with root package name */
    private int f9349i;

    /* renamed from: j  reason: collision with root package name */
    private b f9350j;

    /* renamed from: k  reason: collision with root package name */
    private BeautyData f9351k;

    /* renamed from: l  reason: collision with root package name */
    private ObservableBoolean f9352l;

    /* compiled from: BeautyAdapter.kt */
    /* loaded from: classes3.dex */
    public static final class a extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View itemView) {
            super(itemView);
            kotlin.jvm.internal.s.h(itemView, "itemView");
        }
    }

    /* compiled from: BeautyAdapter.kt */
    /* loaded from: classes3.dex */
    public interface b {
        void l(View view, BeautyData beautyData, BeautyData beautyData2, BeautyData beautyData3, Boolean bool, int i2, int i3);

        void m(boolean z);
    }

    public j(Context context, boolean z) {
        kotlin.jvm.internal.s.h(context, "context");
        this.a = context;
        this.b = z;
        this.c = new ObservableBoolean(false);
        this.f9344d = new ArrayList<>();
        this.f9345e = new ArrayList<>();
        this.f9346f = new ArrayList<>();
        this.f9347g = -1;
        this.f9348h = -1;
        this.f9349i = -1;
        this.f9352l = new ObservableBoolean(true);
    }

    private final void i() {
        boolean C;
        int i2 = 0;
        for (Object obj : this.f9344d) {
            int i3 = i2 + 1;
            if (i2 >= 0) {
                BeautyData beautyData = (BeautyData) obj;
                if (beautyData.getBeautyType() == 1) {
                    if (beautyData.isGroup()) {
                        ArrayList<BeautyData> arrayList = this.f9345e.get(beautyData.getGroupId());
                        kotlin.jvm.internal.s.g(arrayList, "mExpandableBeautyData[beautyData.groupId]");
                        for (BeautyData beautyData2 : arrayList) {
                            if (beautyData2.isSelected().get()) {
                                C = StringsKt__StringsKt.C(beautyData2.getBeautyKey(), Material.MATERIAL_SELECT_NONE_FLAG, false, 2, null);
                                if (!C) {
                                    beautyData.getHasModify().set(true);
                                } else {
                                    beautyData.getHasModify().set(false);
                                }
                            }
                        }
                    }
                } else {
                    beautyData.getHasModify().set(beautyData.getCurrentValue().get() != 0);
                }
                i2 = i3;
            } else {
                kotlin.collections.s.n();
                throw null;
            }
        }
    }

    private final void n() {
        int i2 = -1;
        this.f9349i = -1;
        if (this.f9344d.size() > 0) {
            this.f9344d.clear();
        }
        if (this.f9345e.size() > 0) {
            Iterator<T> it = this.f9345e.iterator();
            while (it.hasNext()) {
                ((ArrayList) it.next()).clear();
            }
            this.f9345e.clear();
        }
        this.f9344d.addAll(this.f9346f);
        int i3 = 0;
        ArrayList<BeautyData> arrayList = null;
        int i4 = -1;
        int i5 = 0;
        boolean z = false;
        for (Object obj : this.f9346f) {
            int i6 = i5 + 1;
            if (i5 >= 0) {
                BeautyData beautyData = (BeautyData) obj;
                beautyData.setDark(this.c);
                if (beautyData.isGroup()) {
                    if (!z) {
                        z = true;
                    }
                    i2++;
                    arrayList = new ArrayList<>();
                    this.f9345e.add(arrayList);
                    beautyData.setGroupId(i2);
                    if (beautyData.isExtended().get()) {
                        this.f9349i = i2;
                        i4 = i2;
                    }
                } else if (z) {
                    beautyData.setGroupId(i2);
                    if (arrayList != null) {
                        arrayList.add(beautyData);
                    }
                }
                i5 = i6;
            } else {
                kotlin.collections.s.n();
                throw null;
            }
        }
        for (Object obj2 : this.f9345e) {
            int i7 = i3 + 1;
            if (i3 >= 0) {
                ArrayList arrayList2 = (ArrayList) obj2;
                if (i3 != i4 && !this.f9344d.get(i3).isExtended().get()) {
                    this.f9344d.removeAll(arrayList2);
                }
                i3 = i7;
            } else {
                kotlin.collections.s.n();
                throw null;
            }
        }
        p();
        i();
        notifyDataSetChanged();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void r(final a aVar, int i2, BeautyData beautyData) {
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.element = i2;
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = beautyData;
        aVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.camera2020.view.adapter.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                j.s(Ref$IntRef.this, aVar, this, ref$ObjectRef, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:107:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x02ec  */
    /* JADX WARN: Type inference failed for: r1v16, types: [T, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void s(kotlin.jvm.internal.Ref$IntRef r11, us.pinguo.camera2020.view.adapter.j.a r12, us.pinguo.camera2020.view.adapter.j r13, kotlin.jvm.internal.Ref$ObjectRef r14, android.view.View r15) {
        /*
            Method dump skipped, instructions count: 781
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.camera2020.view.adapter.j.s(kotlin.jvm.internal.Ref$IntRef, us.pinguo.camera2020.view.adapter.j$a, us.pinguo.camera2020.view.adapter.j, kotlin.jvm.internal.Ref$ObjectRef, android.view.View):void");
    }

    private final void t(a aVar) {
        if (this.b) {
            us.pinguo.camera2020.f.c cVar = (us.pinguo.camera2020.f.c) DataBindingUtil.findBinding(aVar.itemView);
            if (cVar != null) {
                cVar.b(this.f9352l);
            }
            ((SwitchMaterial) aVar.itemView.findViewById(R.id.switcher)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: us.pinguo.camera2020.view.adapter.a
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    j.u(j.this, compoundButton, z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(j this$0, CompoundButton compoundButton, boolean z) {
        VdsAgent.lambdaOnCheckedChangedCompoundButton(compoundButton, z);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.f9352l.set(z);
        b bVar = this$0.f9350j;
        if (bVar == null) {
            return;
        }
        bVar.m(z);
    }

    @Override // us.pinguo.common.m.e
    public void d(boolean z) {
        this.c.set(z);
    }

    public final BeautyData e() {
        int i2 = this.f9349i;
        if (i2 == -1 || i2 >= this.f9344d.size()) {
            return null;
        }
        return this.f9344d.get(this.f9349i);
    }

    public final BeautyData f() {
        int i2 = this.f9347g;
        if (i2 == -1 || i2 >= this.f9344d.size()) {
            return null;
        }
        return this.f9344d.get(this.f9347g);
    }

    public final ObservableBoolean g() {
        return this.f9352l;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f9344d.size();
    }

    public final int h(BeautyData beautyData) {
        kotlin.jvm.internal.s.h(beautyData, "beautyData");
        return this.f9344d.indexOf(beautyData);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l */
    public void onBindViewHolder(a holder, int i2) {
        kotlin.jvm.internal.s.h(holder, "holder");
        if (i2 < 0) {
            return;
        }
        BeautyData beautyData = this.f9344d.get(i2);
        kotlin.jvm.internal.s.g(beautyData, "mDisplayBeautyData[position]");
        BeautyData beautyData2 = beautyData;
        us.pinguo.camera2020.f.c cVar = (us.pinguo.camera2020.f.c) DataBindingUtil.findBinding(holder.itemView);
        if (cVar != null) {
            cVar.a(beautyData2);
        }
        LinearLayout linearLayout = (LinearLayout) holder.itemView.findViewById(R.id.llContainer);
        kotlin.jvm.internal.s.g(linearLayout, "holder.itemView.llContainer");
        int i3 = this.b && i2 == 0 ? 0 : 8;
        linearLayout.setVisibility(i3);
        VdsAgent.onSetViewVisibility(linearLayout, i3);
        r(holder, i2, beautyData2);
        t(holder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m */
    public a onCreateViewHolder(ViewGroup parent, int i2) {
        kotlin.jvm.internal.s.h(parent, "parent");
        View root = ((us.pinguo.camera2020.f.c) DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_makeup, parent, false)).getRoot();
        kotlin.jvm.internal.s.g(root, "inflate<ItemMakeupBindin…     false\n        ).root");
        return new a(root);
    }

    public final void o(List<BeautyData> data) {
        kotlin.jvm.internal.s.h(data, "data");
        if (!this.f9346f.isEmpty()) {
            this.f9346f.clear();
        }
        this.f9346f.addAll(data);
        n();
    }

    public final void p() {
        this.f9349i = -1;
        int i2 = 0;
        for (Object obj : this.f9344d) {
            int i3 = i2 + 1;
            if (i2 >= 0) {
                BeautyData beautyData = (BeautyData) obj;
                if (beautyData.getBeautyType() == 1) {
                    if (beautyData.isExtended().get()) {
                        this.f9349i = i2;
                        ArrayList<BeautyData> arrayList = this.f9345e.get(beautyData.getGroupId());
                        kotlin.jvm.internal.s.g(arrayList, "mExpandableBeautyData[beautyData.groupId]");
                        Iterator<T> it = arrayList.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                BeautyData beautyData2 = (BeautyData) it.next();
                                if (beautyData2.isSelected().get()) {
                                    this.f9348h = this.f9344d.indexOf(beautyData2);
                                    this.f9347g = this.f9344d.indexOf(beautyData2);
                                    break;
                                }
                            }
                        }
                    }
                } else if (beautyData.isSelected().get()) {
                    this.f9347g = i2;
                    this.f9348h = i2;
                }
                i2 = i3;
            } else {
                kotlin.collections.s.n();
                throw null;
            }
        }
    }

    public final void q(b onBeautyItemClick) {
        kotlin.jvm.internal.s.h(onBeautyItemClick, "onBeautyItemClick");
        this.f9350j = onBeautyItemClick;
    }
}
