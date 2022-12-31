package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.Filterable;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.ListPopupWindow;
import com.google.android.material.R;
import com.google.android.material.internal.k;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
/* loaded from: classes2.dex */
public class MaterialAutoCompleteTextView extends AppCompatAutoCompleteTextView {
    @NonNull
    private final ListPopupWindow a;
    @Nullable
    private final AccessibilityManager b;
    @NonNull
    private final Rect c;

    /* loaded from: classes2.dex */
    class a implements AdapterView.OnItemClickListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        @Instrumented
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            VdsAgent.onItemClick(this, adapterView, view, i2, j2);
            MaterialAutoCompleteTextView.this.e(i2 < 0 ? MaterialAutoCompleteTextView.this.a.getSelectedItem() : MaterialAutoCompleteTextView.this.getAdapter().getItem(i2));
            AdapterView.OnItemClickListener onItemClickListener = MaterialAutoCompleteTextView.this.getOnItemClickListener();
            if (onItemClickListener != null) {
                if (view == null || i2 < 0) {
                    view = MaterialAutoCompleteTextView.this.a.getSelectedView();
                    i2 = MaterialAutoCompleteTextView.this.a.getSelectedItemPosition();
                    j2 = MaterialAutoCompleteTextView.this.a.getSelectedItemId();
                }
                onItemClickListener.onItemClick(MaterialAutoCompleteTextView.this.a.getListView(), view, i2, j2);
            }
            MaterialAutoCompleteTextView.this.a.dismiss();
        }
    }

    public MaterialAutoCompleteTextView(@NonNull Context context) {
        this(context, null);
    }

    @Nullable
    private TextInputLayout c() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    private int d() {
        ListAdapter adapter = getAdapter();
        TextInputLayout c = c();
        int i2 = 0;
        if (adapter == null || c == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int min = Math.min(adapter.getCount(), Math.max(0, this.a.getSelectedItemPosition()) + 15);
        View view = null;
        int i3 = 0;
        for (int max = Math.max(0, min - 15); max < min; max++) {
            int itemViewType = adapter.getItemViewType(max);
            if (itemViewType != i2) {
                view = null;
                i2 = itemViewType;
            }
            view = adapter.getView(max, view, c);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i3 = Math.max(i3, view.getMeasuredWidth());
        }
        Drawable background = this.a.getBackground();
        if (background != null) {
            background.getPadding(this.c);
            Rect rect = this.c;
            i3 += rect.left + rect.right;
        }
        return i3 + c.Q().getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public <T extends ListAdapter & Filterable> void e(Object obj) {
        if (Build.VERSION.SDK_INT >= 17) {
            setText(convertSelectionToString(obj), false);
            return;
        }
        ListAdapter adapter = getAdapter();
        setAdapter(null);
        setText(convertSelectionToString(obj));
        setAdapter(adapter);
    }

    @Override // android.widget.TextView
    @Nullable
    public CharSequence getHint() {
        TextInputLayout c = c();
        if (c != null && c.h0()) {
            return c.U();
        }
        return super.getHint();
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout c = c();
        if (c != null && c.h0() && super.getHint() == null && com.google.android.material.internal.d.c()) {
            setHint("");
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), d()), View.MeasureSpec.getSize(i2)), getMeasuredHeight());
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(@Nullable T t) {
        super.setAdapter(t);
        this.a.setAdapter(getAdapter());
    }

    @Override // android.widget.AutoCompleteTextView
    public void showDropDown() {
        AccessibilityManager accessibilityManager = this.b;
        if (accessibilityManager != null && accessibilityManager.isTouchExplorationEnabled()) {
            this.a.show();
        } else {
            super.showDropDown();
        }
    }

    public MaterialAutoCompleteTextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.autoCompleteTextViewStyle);
    }

    public MaterialAutoCompleteTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(com.google.android.material.theme.a.a.c(context, attributeSet, i2, 0), attributeSet, i2);
        this.c = new Rect();
        Context context2 = getContext();
        TypedArray h2 = k.h(context2, attributeSet, R.styleable.MaterialAutoCompleteTextView, i2, R.style.Widget_AppCompat_AutoCompleteTextView, new int[0]);
        int i3 = R.styleable.MaterialAutoCompleteTextView_android_inputType;
        if (h2.hasValue(i3) && h2.getInt(i3, 0) == 0) {
            setKeyListener(null);
        }
        this.b = (AccessibilityManager) context2.getSystemService("accessibility");
        ListPopupWindow listPopupWindow = new ListPopupWindow(context2);
        this.a = listPopupWindow;
        listPopupWindow.setModal(true);
        listPopupWindow.setAnchorView(this);
        listPopupWindow.setInputMethodMode(2);
        listPopupWindow.setAdapter(getAdapter());
        listPopupWindow.setOnItemClickListener(new a());
        h2.recycle();
    }
}
