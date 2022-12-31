package com.google.android.material.chip;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.annotation.BoolRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.internal.FlowLayout;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class ChipGroup extends FlowLayout {
    private static final int n = R.style.Widget_MaterialComponents_ChipGroup;
    @Dimension

    /* renamed from: e  reason: collision with root package name */
    private int f4184e;
    @Dimension

    /* renamed from: f  reason: collision with root package name */
    private int f4185f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f4186g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f4187h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private c f4188i;

    /* renamed from: j  reason: collision with root package name */
    private final b f4189j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    private d f4190k;
    @IdRes

    /* renamed from: l  reason: collision with root package name */
    private int f4191l;
    private boolean m;

    /* loaded from: classes2.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
        }
    }

    /* loaded from: classes2.dex */
    private class b implements CompoundButton.OnCheckedChangeListener {
        private b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        @Instrumented
        public void onCheckedChanged(@NonNull CompoundButton compoundButton, boolean z) {
            VdsAgent.onCheckedChanged(this, compoundButton, z);
            if (ChipGroup.this.m) {
                return;
            }
            if (ChipGroup.this.r().isEmpty() && ChipGroup.this.f4187h) {
                ChipGroup.this.x(compoundButton.getId(), true);
                ChipGroup.this.w(compoundButton.getId(), false);
                return;
            }
            int id = compoundButton.getId();
            if (z) {
                if (ChipGroup.this.f4191l != -1 && ChipGroup.this.f4191l != id && ChipGroup.this.f4186g) {
                    ChipGroup chipGroup = ChipGroup.this;
                    chipGroup.x(chipGroup.f4191l, false);
                }
                ChipGroup.this.v(id);
            } else if (ChipGroup.this.f4191l == id) {
                ChipGroup.this.v(-1);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a(ChipGroup chipGroup, @IdRes int i2);
    }

    /* loaded from: classes2.dex */
    private class d implements ViewGroup.OnHierarchyChangeListener {
        private ViewGroup.OnHierarchyChangeListener a;

        private d() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            if (view == ChipGroup.this && (view2 instanceof Chip)) {
                if (view2.getId() == -1) {
                    view2.setId(ViewCompat.generateViewId());
                }
                Chip chip = (Chip) view2;
                if (chip.isChecked()) {
                    ((ChipGroup) view).p(chip.getId());
                }
                chip.D(ChipGroup.this.f4189j);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.a;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            if (view == ChipGroup.this && (view2 instanceof Chip)) {
                ((Chip) view2).D(null);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.a;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    public ChipGroup(Context context) {
        this(context, null);
    }

    private int s() {
        int i2 = 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            if (getChildAt(i3) instanceof Chip) {
                i2++;
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(int i2) {
        w(i2, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(int i2, boolean z) {
        this.f4191l = i2;
        c cVar = this.f4188i;
        if (cVar != null && this.f4186g && z) {
            cVar.a(this, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(@IdRes int i2, boolean z) {
        View findViewById = findViewById(i2);
        if (findViewById instanceof Chip) {
            this.m = true;
            ((Chip) findViewById).setChecked(z);
            this.m = false;
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof Chip) {
            Chip chip = (Chip) view;
            if (chip.isChecked()) {
                int i3 = this.f4191l;
                if (i3 != -1 && this.f4186g) {
                    x(i3, false);
                }
                v(chip.getId());
            }
        }
        super.addView(view, i2, layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    @Override // com.google.android.material.internal.FlowLayout
    public boolean d() {
        return super.d();
    }

    @Override // android.view.ViewGroup
    @NonNull
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    @NonNull
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int i2 = this.f4191l;
        if (i2 != -1) {
            x(i2, true);
            v(this.f4191l);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(b(), d() ? s() : -1, false, u() ? 1 : 2));
    }

    public void p(@IdRes int i2) {
        int i3 = this.f4191l;
        if (i2 == i3) {
            return;
        }
        if (i3 != -1 && this.f4186g) {
            x(i3, false);
        }
        if (i2 != -1) {
            x(i2, true);
        }
        v(i2);
    }

    public void q() {
        this.m = true;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof Chip) {
                ((Chip) childAt).setChecked(false);
            }
        }
        this.m = false;
        v(-1);
    }

    @NonNull
    public List<Integer> r() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if ((childAt instanceof Chip) && ((Chip) childAt).isChecked()) {
                arrayList.add(Integer.valueOf(childAt.getId()));
                if (this.f4186g) {
                    return arrayList;
                }
            }
        }
        return arrayList;
    }

    public void setChipSpacing(@Dimension int i2) {
        setChipSpacingHorizontal(i2);
        setChipSpacingVertical(i2);
    }

    public void setChipSpacingHorizontal(@Dimension int i2) {
        if (this.f4184e != i2) {
            this.f4184e = i2;
            f(i2);
            requestLayout();
        }
    }

    public void setChipSpacingHorizontalResource(@DimenRes int i2) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(i2));
    }

    public void setChipSpacingResource(@DimenRes int i2) {
        setChipSpacing(getResources().getDimensionPixelOffset(i2));
    }

    public void setChipSpacingVertical(@Dimension int i2) {
        if (this.f4185f != i2) {
            this.f4185f = i2;
            g(i2);
            requestLayout();
        }
    }

    public void setChipSpacingVerticalResource(@DimenRes int i2) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(i2));
    }

    @Deprecated
    public void setDividerDrawableHorizontal(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setDividerDrawableVertical(@Nullable Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setFlexWrap(int i2) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    public void setOnCheckedChangeListener(c cVar) {
        this.f4188i = cVar;
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f4190k.a = onHierarchyChangeListener;
    }

    public void setSelectionRequired(boolean z) {
        this.f4187h = z;
    }

    @Deprecated
    public void setShowDividerHorizontal(int i2) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerVertical(int i2) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Override // com.google.android.material.internal.FlowLayout
    public void setSingleLine(boolean z) {
        super.setSingleLine(z);
    }

    public void setSingleSelection(boolean z) {
        if (this.f4186g != z) {
            this.f4186g = z;
            q();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int t(@Nullable View view) {
        if (view instanceof Chip) {
            int i2 = 0;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                if (getChildAt(i3) instanceof Chip) {
                    if (((Chip) getChildAt(i3)) == view) {
                        return i2;
                    }
                    i2++;
                }
            }
            return -1;
        }
        return -1;
    }

    public boolean u() {
        return this.f4186g;
    }

    public ChipGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.chipGroupStyle);
    }

    @Override // android.view.ViewGroup
    @NonNull
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public void setSingleLine(@BoolRes int i2) {
        setSingleLine(getResources().getBoolean(i2));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ChipGroup(android.content.Context r8, android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r4 = com.google.android.material.chip.ChipGroup.n
            android.content.Context r8 = com.google.android.material.theme.a.a.c(r8, r9, r10, r4)
            r7.<init>(r8, r9, r10)
            com.google.android.material.chip.ChipGroup$b r8 = new com.google.android.material.chip.ChipGroup$b
            r0 = 0
            r8.<init>()
            r7.f4189j = r8
            com.google.android.material.chip.ChipGroup$d r8 = new com.google.android.material.chip.ChipGroup$d
            r8.<init>()
            r7.f4190k = r8
            r8 = -1
            r7.f4191l = r8
            r6 = 0
            r7.m = r6
            android.content.Context r0 = r7.getContext()
            int[] r2 = com.google.android.material.R.styleable.ChipGroup
            int[] r5 = new int[r6]
            r1 = r9
            r3 = r10
            android.content.res.TypedArray r9 = com.google.android.material.internal.k.h(r0, r1, r2, r3, r4, r5)
            int r10 = com.google.android.material.R.styleable.ChipGroup_chipSpacing
            int r10 = r9.getDimensionPixelOffset(r10, r6)
            int r0 = com.google.android.material.R.styleable.ChipGroup_chipSpacingHorizontal
            int r0 = r9.getDimensionPixelOffset(r0, r10)
            r7.setChipSpacingHorizontal(r0)
            int r0 = com.google.android.material.R.styleable.ChipGroup_chipSpacingVertical
            int r10 = r9.getDimensionPixelOffset(r0, r10)
            r7.setChipSpacingVertical(r10)
            int r10 = com.google.android.material.R.styleable.ChipGroup_singleLine
            boolean r10 = r9.getBoolean(r10, r6)
            r7.setSingleLine(r10)
            int r10 = com.google.android.material.R.styleable.ChipGroup_singleSelection
            boolean r10 = r9.getBoolean(r10, r6)
            r7.setSingleSelection(r10)
            int r10 = com.google.android.material.R.styleable.ChipGroup_selectionRequired
            boolean r10 = r9.getBoolean(r10, r6)
            r7.setSelectionRequired(r10)
            int r10 = com.google.android.material.R.styleable.ChipGroup_checkedChip
            int r10 = r9.getResourceId(r10, r8)
            if (r10 == r8) goto L69
            r7.f4191l = r10
        L69:
            r9.recycle()
            com.google.android.material.chip.ChipGroup$d r8 = r7.f4190k
            super.setOnHierarchyChangeListener(r8)
            r8 = 1
            androidx.core.view.ViewCompat.setImportantForAccessibility(r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.ChipGroup.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setSingleSelection(@BoolRes int i2) {
        setSingleSelection(getResources().getBoolean(i2));
    }
}
