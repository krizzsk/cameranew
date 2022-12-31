package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.internal.p;
import java.util.Calendar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class MaterialCalendarGridView extends GridView {
    private final Calendar a;
    private final boolean b;

    /* loaded from: classes2.dex */
    class a extends AccessibilityDelegateCompat {
        a(MaterialCalendarGridView materialCalendarGridView) {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCollectionInfo(null);
        }
    }

    public MaterialCalendarGridView(Context context) {
        this(context, null);
    }

    private void a(int i2, Rect rect) {
        if (i2 == 33) {
            setSelection(getAdapter2().i());
        } else if (i2 == 130) {
            setSelection(getAdapter2().b());
        } else {
            super.onFocusChanged(true, i2, rect);
        }
    }

    private static int c(@NonNull View view) {
        return view.getLeft() + (view.getWidth() / 2);
    }

    private static boolean d(@Nullable Long l2, @Nullable Long l3, @Nullable Long l4, @Nullable Long l5) {
        return l2 == null || l3 == null || l4 == null || l5 == null || l4.longValue() > l3.longValue() || l5.longValue() < l2.longValue();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    @NonNull
    /* renamed from: b */
    public g getAdapter2() {
        return (g) super.getAdapter();
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter2().notifyDataSetChanged();
    }

    @Override // android.view.View
    protected final void onDraw(@NonNull Canvas canvas) {
        int a2;
        int c;
        int a3;
        int c2;
        int width;
        int i2;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        g adapter2 = getAdapter2();
        DateSelector<?> dateSelector = adapter2.b;
        b bVar = adapter2.f4247d;
        Long item = adapter2.getItem(adapter2.b());
        Long item2 = adapter2.getItem(adapter2.i());
        for (Pair<Long, Long> pair : dateSelector.v()) {
            Long l2 = pair.first;
            if (l2 != null) {
                if (pair.second != null) {
                    long longValue = l2.longValue();
                    long longValue2 = pair.second.longValue();
                    if (!d(item, item2, Long.valueOf(longValue), Long.valueOf(longValue2))) {
                        boolean h2 = p.h(this);
                        if (longValue < item.longValue()) {
                            a2 = adapter2.b();
                            if (adapter2.f(a2)) {
                                c = 0;
                            } else if (!h2) {
                                c = materialCalendarGridView.getChildAt(a2 - 1).getRight();
                            } else {
                                c = materialCalendarGridView.getChildAt(a2 - 1).getLeft();
                            }
                        } else {
                            materialCalendarGridView.a.setTimeInMillis(longValue);
                            a2 = adapter2.a(materialCalendarGridView.a.get(5));
                            c = c(materialCalendarGridView.getChildAt(a2));
                        }
                        if (longValue2 > item2.longValue()) {
                            a3 = Math.min(adapter2.i(), getChildCount() - 1);
                            if (adapter2.g(a3)) {
                                c2 = getWidth();
                            } else if (!h2) {
                                c2 = materialCalendarGridView.getChildAt(a3).getRight();
                            } else {
                                c2 = materialCalendarGridView.getChildAt(a3).getLeft();
                            }
                        } else {
                            materialCalendarGridView.a.setTimeInMillis(longValue2);
                            a3 = adapter2.a(materialCalendarGridView.a.get(5));
                            c2 = c(materialCalendarGridView.getChildAt(a3));
                        }
                        int itemId = (int) adapter2.getItemId(a2);
                        int itemId2 = (int) adapter2.getItemId(a3);
                        while (itemId <= itemId2) {
                            int numColumns = getNumColumns() * itemId;
                            int numColumns2 = (getNumColumns() + numColumns) - 1;
                            View childAt = materialCalendarGridView.getChildAt(numColumns);
                            int top = childAt.getTop() + bVar.a.c();
                            int bottom = childAt.getBottom() - bVar.a.b();
                            if (!h2) {
                                i2 = numColumns > a2 ? 0 : c;
                                width = a3 > numColumns2 ? getWidth() : c2;
                            } else {
                                int i3 = a3 > numColumns2 ? 0 : c2;
                                width = numColumns > a2 ? getWidth() : c;
                                i2 = i3;
                            }
                            canvas.drawRect(i2, top, width, bottom, bVar.f4241h);
                            itemId++;
                            materialCalendarGridView = this;
                            adapter2 = adapter2;
                        }
                    }
                }
            }
            materialCalendarGridView = this;
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    protected void onFocusChanged(boolean z, int i2, Rect rect) {
        if (z) {
            a(i2, rect);
        } else {
            super.onFocusChanged(false, i2, rect);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (super.onKeyDown(i2, keyEvent)) {
            if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= getAdapter2().b()) {
                return true;
            }
            if (19 == i2) {
                setSelection(getAdapter2().b());
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i2, int i3) {
        if (this.b) {
            super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(ViewCompat.MEASURED_SIZE_MASK, Integer.MIN_VALUE));
            getLayoutParams().height = getMeasuredHeight();
            return;
        }
        super.onMeasure(i2, i3);
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public void setSelection(int i2) {
        if (i2 < getAdapter2().b()) {
            super.setSelection(getAdapter2().b());
        } else {
            super.setSelection(i2);
        }
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(ListAdapter listAdapter) {
        if (listAdapter instanceof g) {
            super.setAdapter(listAdapter);
            return;
        }
        throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), g.class.getCanonicalName()));
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = l.q();
        if (MaterialDatePicker.p0(getContext())) {
            setNextFocusLeftId(R.id.cancel_button);
            setNextFocusRightId(R.id.confirm_button);
        }
        this.b = MaterialDatePicker.q0(getContext());
        ViewCompat.setAccessibilityDelegate(this, new a(this));
    }
}
