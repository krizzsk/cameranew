package com.google.android.material.button;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.annotation.BoolRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.p;
import com.google.android.material.shape.m;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public class MaterialButtonToggleGroup extends LinearLayout {

    /* renamed from: k  reason: collision with root package name */
    private static final String f4139k = MaterialButtonToggleGroup.class.getSimpleName();

    /* renamed from: l  reason: collision with root package name */
    private static final int f4140l = R.style.Widget_MaterialComponents_MaterialButtonToggleGroup;
    private final List<d> a;
    private final c b;
    private final f c;

    /* renamed from: d  reason: collision with root package name */
    private final LinkedHashSet<e> f4141d;

    /* renamed from: e  reason: collision with root package name */
    private final Comparator<MaterialButton> f4142e;

    /* renamed from: f  reason: collision with root package name */
    private Integer[] f4143f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f4144g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f4145h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f4146i;
    @IdRes

    /* renamed from: j  reason: collision with root package name */
    private int f4147j;

    /* loaded from: classes2.dex */
    class a implements Comparator<MaterialButton> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(MaterialButton materialButton, MaterialButton materialButton2) {
            int compareTo = Boolean.valueOf(materialButton.isChecked()).compareTo(Boolean.valueOf(materialButton2.isChecked()));
            if (compareTo != 0) {
                return compareTo;
            }
            int compareTo2 = Boolean.valueOf(materialButton.isPressed()).compareTo(Boolean.valueOf(materialButton2.isPressed()));
            return compareTo2 != 0 ? compareTo2 : Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton)).compareTo(Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton2)));
        }
    }

    /* loaded from: classes2.dex */
    class b extends AccessibilityDelegateCompat {
        b() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, MaterialButtonToggleGroup.this.q(view), 1, false, ((MaterialButton) view).isChecked()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c implements MaterialButton.a {
        private c() {
        }

        @Override // com.google.android.material.button.MaterialButton.a
        public void a(@NonNull MaterialButton materialButton, boolean z) {
            if (MaterialButtonToggleGroup.this.f4144g) {
                return;
            }
            if (MaterialButtonToggleGroup.this.f4145h) {
                MaterialButtonToggleGroup.this.f4147j = z ? materialButton.getId() : -1;
            }
            if (MaterialButtonToggleGroup.this.C(materialButton.getId(), z)) {
                MaterialButtonToggleGroup.this.m(materialButton.getId(), materialButton.isChecked());
            }
            MaterialButtonToggleGroup.this.invalidate();
        }

        /* synthetic */ c(MaterialButtonToggleGroup materialButtonToggleGroup, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: e  reason: collision with root package name */
        private static final com.google.android.material.shape.c f4148e = new com.google.android.material.shape.a(0.0f);
        com.google.android.material.shape.c a;
        com.google.android.material.shape.c b;
        com.google.android.material.shape.c c;

        /* renamed from: d  reason: collision with root package name */
        com.google.android.material.shape.c f4149d;

        d(com.google.android.material.shape.c cVar, com.google.android.material.shape.c cVar2, com.google.android.material.shape.c cVar3, com.google.android.material.shape.c cVar4) {
            this.a = cVar;
            this.b = cVar3;
            this.c = cVar4;
            this.f4149d = cVar2;
        }

        public static d a(d dVar) {
            com.google.android.material.shape.c cVar = f4148e;
            return new d(cVar, dVar.f4149d, cVar, dVar.c);
        }

        public static d b(d dVar, View view) {
            return p.h(view) ? c(dVar) : d(dVar);
        }

        public static d c(d dVar) {
            com.google.android.material.shape.c cVar = dVar.a;
            com.google.android.material.shape.c cVar2 = dVar.f4149d;
            com.google.android.material.shape.c cVar3 = f4148e;
            return new d(cVar, cVar2, cVar3, cVar3);
        }

        public static d d(d dVar) {
            com.google.android.material.shape.c cVar = f4148e;
            return new d(cVar, cVar, dVar.b, dVar.c);
        }

        public static d e(d dVar, View view) {
            return p.h(view) ? d(dVar) : c(dVar);
        }

        public static d f(d dVar) {
            com.google.android.material.shape.c cVar = dVar.a;
            com.google.android.material.shape.c cVar2 = f4148e;
            return new d(cVar, cVar2, dVar.b, cVar2);
        }
    }

    /* loaded from: classes2.dex */
    public interface e {
        void a(MaterialButtonToggleGroup materialButtonToggleGroup, @IdRes int i2, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class f implements MaterialButton.b {
        private f() {
        }

        @Override // com.google.android.material.button.MaterialButton.b
        public void a(@NonNull MaterialButton materialButton, boolean z) {
            MaterialButtonToggleGroup.this.invalidate();
        }

        /* synthetic */ f(MaterialButtonToggleGroup materialButtonToggleGroup, a aVar) {
            this();
        }
    }

    public MaterialButtonToggleGroup(@NonNull Context context) {
        this(context, null);
    }

    private void A(@NonNull MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.a(this.b);
        materialButton.r(this.c);
        materialButton.s(true);
    }

    private static void B(m.b bVar, @Nullable d dVar) {
        if (dVar == null) {
            bVar.o(0.0f);
            return;
        }
        bVar.F(dVar.a);
        bVar.w(dVar.f4149d);
        bVar.J(dVar.b);
        bVar.A(dVar.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean C(int i2, boolean z) {
        List<Integer> n = n();
        if (this.f4146i && n.isEmpty()) {
            y(i2, true);
            this.f4147j = i2;
            return false;
        }
        if (z && this.f4145h) {
            n.remove(Integer.valueOf(i2));
            for (Integer num : n) {
                int intValue = num.intValue();
                y(intValue, false);
                m(intValue, false);
            }
        }
        return true;
    }

    private void D() {
        TreeMap treeMap = new TreeMap(this.f4142e);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            treeMap.put(o(i2), Integer.valueOf(i2));
        }
        this.f4143f = (Integer[]) treeMap.values().toArray(new Integer[0]);
    }

    private void h() {
        int p = p();
        if (p == -1) {
            return;
        }
        for (int i2 = p + 1; i2 < getChildCount(); i2++) {
            MaterialButton o = o(i2);
            int min = Math.min(o.f(), o(i2 - 1).f());
            LinearLayout.LayoutParams i3 = i(o);
            if (getOrientation() == 0) {
                MarginLayoutParamsCompat.setMarginEnd(i3, 0);
                MarginLayoutParamsCompat.setMarginStart(i3, -min);
                i3.topMargin = 0;
            } else {
                i3.bottomMargin = 0;
                i3.topMargin = -min;
                MarginLayoutParamsCompat.setMarginStart(i3, 0);
            }
            o.setLayoutParams(i3);
        }
        w(p);
    }

    @NonNull
    private LinearLayout.LayoutParams i(@NonNull View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            return (LinearLayout.LayoutParams) layoutParams;
        }
        return new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
    }

    private void k(int i2, boolean z) {
        MaterialButton materialButton = (MaterialButton) findViewById(i2);
        if (materialButton != null) {
            materialButton.setChecked(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(@IdRes int i2, boolean z) {
        Iterator<e> it = this.f4141d.iterator();
        while (it.hasNext()) {
            it.next().a(this, i2, z);
        }
    }

    private MaterialButton o(int i2) {
        return (MaterialButton) getChildAt(i2);
    }

    private int p() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (u(i2)) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int q(@Nullable View view) {
        if (view instanceof MaterialButton) {
            int i2 = 0;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                if (getChildAt(i3) == view) {
                    return i2;
                }
                if ((getChildAt(i3) instanceof MaterialButton) && u(i3)) {
                    i2++;
                }
            }
            return -1;
        }
        return -1;
    }

    private int r() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (u(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    @Nullable
    private d s(int i2, int i3, int i4) {
        d dVar = this.a.get(i2);
        if (i3 == i4) {
            return dVar;
        }
        boolean z = getOrientation() == 0;
        if (i2 == i3) {
            return z ? d.e(dVar, this) : d.f(dVar);
        } else if (i2 == i4) {
            return z ? d.b(dVar, this) : d.a(dVar);
        } else {
            return null;
        }
    }

    private int t() {
        int i2 = 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            if ((getChildAt(i3) instanceof MaterialButton) && u(i3)) {
                i2++;
            }
        }
        return i2;
    }

    private boolean u(int i2) {
        return getChildAt(i2).getVisibility() != 8;
    }

    private void w(int i2) {
        if (getChildCount() == 0 || i2 == -1) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) o(i2).getLayoutParams();
        if (getOrientation() == 1) {
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            return;
        }
        MarginLayoutParamsCompat.setMarginEnd(layoutParams, 0);
        MarginLayoutParamsCompat.setMarginStart(layoutParams, 0);
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
    }

    private void x(int i2) {
        this.f4147j = i2;
        m(i2, true);
    }

    private void y(@IdRes int i2, boolean z) {
        View findViewById = findViewById(i2);
        if (findViewById instanceof MaterialButton) {
            this.f4144g = true;
            ((MaterialButton) findViewById).setChecked(z);
            this.f4144g = false;
        }
    }

    private void z(@NonNull MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            materialButton.setId(ViewCompat.generateViewId());
        }
    }

    @VisibleForTesting
    void E() {
        int childCount = getChildCount();
        int p = p();
        int r = r();
        for (int i2 = 0; i2 < childCount; i2++) {
            MaterialButton o = o(i2);
            if (o.getVisibility() != 8) {
                m.b v = o.e().v();
                B(v, s(i2, p, r));
                o.setShapeAppearanceModel(v.m());
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e(f4139k, "Child views must be of type MaterialButton.");
            return;
        }
        super.addView(view, i2, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        z(materialButton);
        A(materialButton);
        if (materialButton.isChecked()) {
            C(materialButton.getId(), true);
            x(materialButton.getId());
        }
        m e2 = materialButton.e();
        this.a.add(new d(e2.r(), e2.j(), e2.t(), e2.l()));
        ViewCompat.setAccessibilityDelegate(materialButton, new b());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(@NonNull Canvas canvas) {
        D();
        super.dispatchDraw(canvas);
    }

    public void g(@NonNull e eVar) {
        this.f4141d.add(eVar);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    @NonNull
    public CharSequence getAccessibilityClassName() {
        return MaterialButtonToggleGroup.class.getName();
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i2, int i3) {
        Integer[] numArr = this.f4143f;
        if (numArr != null && i3 < numArr.length) {
            return numArr[i3].intValue();
        }
        Log.w(f4139k, "Child order wasn't updated");
        return i3;
    }

    public void j(@IdRes int i2) {
        if (i2 == this.f4147j) {
            return;
        }
        k(i2, true);
    }

    public void l() {
        this.f4144g = true;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            MaterialButton o = o(i2);
            o.setChecked(false);
            m(o.getId(), false);
        }
        this.f4144g = false;
        x(-1);
    }

    @NonNull
    public List<Integer> n() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            MaterialButton o = o(i2);
            if (o.isChecked()) {
                arrayList.add(Integer.valueOf(o.getId()));
            }
        }
        return arrayList;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int i2 = this.f4147j;
        if (i2 != -1) {
            k(i2, true);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, t(), false, v() ? 1 : 2));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        E();
        h();
        super.onMeasure(i2, i3);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            MaterialButton materialButton = (MaterialButton) view;
            materialButton.o(this.b);
            materialButton.r(null);
        }
        int indexOfChild = indexOfChild(view);
        if (indexOfChild >= 0) {
            this.a.remove(indexOfChild);
        }
        E();
        h();
    }

    public void setSelectionRequired(boolean z) {
        this.f4146i = z;
    }

    public void setSingleSelection(boolean z) {
        if (this.f4145h != z) {
            this.f4145h = z;
            l();
        }
    }

    public boolean v() {
        return this.f4145h;
    }

    public MaterialButtonToggleGroup(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialButtonToggleGroupStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public MaterialButtonToggleGroup(@androidx.annotation.NonNull android.content.Context r7, @androidx.annotation.Nullable android.util.AttributeSet r8, int r9) {
        /*
            r6 = this;
            int r4 = com.google.android.material.button.MaterialButtonToggleGroup.f4140l
            android.content.Context r7 = com.google.android.material.theme.a.a.c(r7, r8, r9, r4)
            r6.<init>(r7, r8, r9)
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r6.a = r7
            com.google.android.material.button.MaterialButtonToggleGroup$c r7 = new com.google.android.material.button.MaterialButtonToggleGroup$c
            r0 = 0
            r7.<init>(r6, r0)
            r6.b = r7
            com.google.android.material.button.MaterialButtonToggleGroup$f r7 = new com.google.android.material.button.MaterialButtonToggleGroup$f
            r7.<init>(r6, r0)
            r6.c = r7
            java.util.LinkedHashSet r7 = new java.util.LinkedHashSet
            r7.<init>()
            r6.f4141d = r7
            com.google.android.material.button.MaterialButtonToggleGroup$a r7 = new com.google.android.material.button.MaterialButtonToggleGroup$a
            r7.<init>()
            r6.f4142e = r7
            r7 = 0
            r6.f4144g = r7
            android.content.Context r0 = r6.getContext()
            int[] r2 = com.google.android.material.R.styleable.MaterialButtonToggleGroup
            int[] r5 = new int[r7]
            r1 = r8
            r3 = r9
            android.content.res.TypedArray r8 = com.google.android.material.internal.k.h(r0, r1, r2, r3, r4, r5)
            int r9 = com.google.android.material.R.styleable.MaterialButtonToggleGroup_singleSelection
            boolean r9 = r8.getBoolean(r9, r7)
            r6.setSingleSelection(r9)
            int r9 = com.google.android.material.R.styleable.MaterialButtonToggleGroup_checkedButton
            r0 = -1
            int r9 = r8.getResourceId(r9, r0)
            r6.f4147j = r9
            int r9 = com.google.android.material.R.styleable.MaterialButtonToggleGroup_selectionRequired
            boolean r7 = r8.getBoolean(r9, r7)
            r6.f4146i = r7
            r7 = 1
            r6.setChildrenDrawingOrderEnabled(r7)
            r8.recycle()
            androidx.core.view.ViewCompat.setImportantForAccessibility(r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.button.MaterialButtonToggleGroup.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setSingleSelection(@BoolRes int i2) {
        setSingleSelection(getResources().getBoolean(i2));
    }
}
