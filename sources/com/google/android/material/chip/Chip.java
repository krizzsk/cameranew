package com.google.android.material.chip;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.annotation.AnimatorRes;
import androidx.annotation.BoolRes;
import androidx.annotation.CallSuper;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.google.android.material.R;
import com.google.android.material.animation.g;
import com.google.android.material.chip.a;
import com.google.android.material.f.d;
import com.google.android.material.f.f;
import com.google.android.material.internal.k;
import com.google.android.material.internal.p;
import com.google.android.material.shape.i;
import com.google.android.material.shape.m;
import com.google.android.material.shape.o;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
/* loaded from: classes2.dex */
public class Chip extends AppCompatCheckBox implements a.InterfaceC0168a, o {
    private static final int q = R.style.Widget_MaterialComponents_Chip_Action;
    private static final Rect r = new Rect();
    private static final int[] s = {16842913};
    private static final int[] t = {16842911};
    @Nullable
    private com.google.android.material.chip.a a;
    @Nullable
    private InsetDrawable b;
    @Nullable
    private RippleDrawable c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private View.OnClickListener f4175d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private CompoundButton.OnCheckedChangeListener f4176e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f4177f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f4178g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f4179h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f4180i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f4181j;

    /* renamed from: k  reason: collision with root package name */
    private int f4182k;
    @Dimension(unit = 1)

    /* renamed from: l  reason: collision with root package name */
    private int f4183l;
    @NonNull
    private final c m;
    private final Rect n;
    private final RectF o;
    private final f p;

    /* loaded from: classes2.dex */
    class a extends f {
        a() {
        }

        @Override // com.google.android.material.f.f
        public void a(int i2) {
        }

        @Override // com.google.android.material.f.f
        public void b(@NonNull Typeface typeface, boolean z) {
            Chip chip = Chip.this;
            chip.setText(chip.a.y2() ? Chip.this.a.U0() : Chip.this.getText());
            Chip.this.requestLayout();
            Chip.this.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b extends ViewOutlineProvider {
        b() {
        }

        @Override // android.view.ViewOutlineProvider
        @TargetApi(21)
        public void getOutline(View view, @NonNull Outline outline) {
            if (Chip.this.a != null) {
                Chip.this.a.getOutline(outline);
            } else {
                outline.setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c extends ExploreByTouchHelper {
        c(Chip chip) {
            super(chip);
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected int getVirtualViewAt(float f2, float f3) {
            return (Chip.this.t() && Chip.this.p().contains(f2, f3)) ? 1 : 0;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void getVisibleVirtualViews(@NonNull List<Integer> list) {
            list.add(0);
            if (Chip.this.t() && Chip.this.y() && Chip.this.f4175d != null) {
                list.add(1);
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected boolean onPerformActionForVirtualView(int i2, int i3, Bundle bundle) {
            if (i3 == 16) {
                if (i2 == 0) {
                    return Chip.this.performClick();
                }
                if (i2 == 1) {
                    return Chip.this.z();
                }
                return false;
            }
            return false;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void onPopulateNodeForHost(@NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            accessibilityNodeInfoCompat.setCheckable(Chip.this.x());
            accessibilityNodeInfoCompat.setClickable(Chip.this.isClickable());
            if (!Chip.this.x() && !Chip.this.isClickable()) {
                accessibilityNodeInfoCompat.setClassName("android.view.View");
            } else {
                accessibilityNodeInfoCompat.setClassName(Chip.this.x() ? "android.widget.CompoundButton" : "android.widget.Button");
            }
            CharSequence text = Chip.this.getText();
            if (Build.VERSION.SDK_INT >= 23) {
                accessibilityNodeInfoCompat.setText(text);
            } else {
                accessibilityNodeInfoCompat.setContentDescription(text);
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void onPopulateNodeForVirtualView(int i2, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (i2 == 1) {
                CharSequence o = Chip.this.o();
                if (o != null) {
                    accessibilityNodeInfoCompat.setContentDescription(o);
                } else {
                    CharSequence text = Chip.this.getText();
                    Context context = Chip.this.getContext();
                    int i3 = R.string.mtrl_chip_close_icon_content_description;
                    Object[] objArr = new Object[1];
                    objArr[0] = TextUtils.isEmpty(text) ? "" : text;
                    accessibilityNodeInfoCompat.setContentDescription(context.getString(i3, objArr).trim());
                }
                accessibilityNodeInfoCompat.setBoundsInParent(Chip.this.q());
                accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
                accessibilityNodeInfoCompat.setEnabled(Chip.this.isEnabled());
                return;
            }
            accessibilityNodeInfoCompat.setContentDescription("");
            accessibilityNodeInfoCompat.setBoundsInParent(Chip.r);
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void onVirtualViewKeyboardFocusChanged(int i2, boolean z) {
            if (i2 == 1) {
                Chip.this.f4180i = z;
                Chip.this.refreshDrawableState();
            }
        }
    }

    public Chip(Context context) {
        this(context, null);
    }

    private void A() {
        if (this.b != null) {
            this.b = null;
            setMinWidth(0);
            setMinHeight((int) n());
            H();
        }
    }

    private void B(boolean z) {
        if (this.f4179h != z) {
            this.f4179h = z;
            refreshDrawableState();
        }
    }

    private void C(boolean z) {
        if (this.f4178g != z) {
            this.f4178g = z;
            refreshDrawableState();
        }
    }

    private void F(@Nullable com.google.android.material.chip.a aVar) {
        if (aVar != null) {
            aVar.c2(null);
        }
    }

    private void G() {
        if (t() && y() && this.f4175d != null) {
            ViewCompat.setAccessibilityDelegate(this, this.m);
        } else {
            ViewCompat.setAccessibilityDelegate(this, null);
        }
    }

    private void H() {
        if (com.google.android.material.g.b.a) {
            I();
            return;
        }
        this.a.x2(true);
        ViewCompat.setBackground(this, m());
        J();
        l();
    }

    private void I() {
        this.c = new RippleDrawable(com.google.android.material.g.b.d(this.a.T0()), m(), null);
        this.a.x2(false);
        ViewCompat.setBackground(this, this.c);
        J();
    }

    private void J() {
        com.google.android.material.chip.a aVar;
        if (TextUtils.isEmpty(getText()) || (aVar = this.a) == null) {
            return;
        }
        int I0 = (int) (aVar.I0() + this.a.W0() + this.a.s0());
        int L0 = (int) (this.a.L0() + this.a.X0() + this.a.o0());
        if (this.b != null) {
            Rect rect = new Rect();
            this.b.getPadding(rect);
            L0 += rect.left;
            I0 += rect.right;
        }
        ViewCompat.setPaddingRelative(this, L0, getPaddingTop(), I0, getPaddingBottom());
    }

    private void K() {
        TextPaint paint = getPaint();
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            paint.drawableState = aVar.getState();
        }
        d r2 = r();
        if (r2 != null) {
            r2.j(getContext(), paint, this.p);
        }
    }

    private void L(@Nullable AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background") != null) {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") == null) {
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") == null) {
                if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") == null) {
                    if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") == null) {
                        if (attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) && attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) == 1 && attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) == 1 && attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) == 1) {
                            if (attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627) != 8388627) {
                                Log.w("Chip", "Chip text must be vertically center and start aligned");
                                return;
                            }
                            return;
                        }
                        throw new UnsupportedOperationException("Chip does not support multi-line text");
                    }
                    throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
                }
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            }
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
    }

    private void i(@NonNull com.google.android.material.chip.a aVar) {
        aVar.c2(this);
    }

    @NonNull
    private int[] j() {
        int i2 = 0;
        int i3 = isEnabled() ? 1 : 0;
        if (this.f4180i) {
            i3++;
        }
        if (this.f4179h) {
            i3++;
        }
        if (this.f4178g) {
            i3++;
        }
        if (isChecked()) {
            i3++;
        }
        int[] iArr = new int[i3];
        if (isEnabled()) {
            iArr[0] = 16842910;
            i2 = 1;
        }
        if (this.f4180i) {
            iArr[i2] = 16842908;
            i2++;
        }
        if (this.f4179h) {
            iArr[i2] = 16843623;
            i2++;
        }
        if (this.f4178g) {
            iArr[i2] = 16842919;
            i2++;
        }
        if (isChecked()) {
            iArr[i2] = 16842913;
        }
        return iArr;
    }

    private void l() {
        if (m() == this.b && this.a.getCallback() == null) {
            this.a.setCallback(this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public RectF p() {
        this.o.setEmpty();
        if (t() && this.f4175d != null) {
            this.a.P0(this.o);
        }
        return this.o;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public Rect q() {
        RectF p = p();
        this.n.set((int) p.left, (int) p.top, (int) p.right, (int) p.bottom);
        return this.n;
    }

    @Nullable
    private d r() {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            return aVar.V0();
        }
        return null;
    }

    @SuppressLint({"PrivateApi"})
    private boolean s(@NonNull MotionEvent motionEvent) {
        if (motionEvent.getAction() == 10) {
            try {
                Field declaredField = ExploreByTouchHelper.class.getDeclaredField("mHoveredVirtualViewId");
                declaredField.setAccessible(true);
                if (((Integer) declaredField.get(this.m)).intValue() != Integer.MIN_VALUE) {
                    Method declaredMethod = ExploreByTouchHelper.class.getDeclaredMethod("updateHoveredVirtualView", Integer.TYPE);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(this.m, Integer.MIN_VALUE);
                    return true;
                }
            } catch (IllegalAccessException e2) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e2);
            } catch (NoSuchFieldException e3) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e3);
            } catch (NoSuchMethodException e4) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e4);
            } catch (InvocationTargetException e5) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e5);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean t() {
        com.google.android.material.chip.a aVar = this.a;
        return (aVar == null || aVar.M0() == null) ? false : true;
    }

    private void u(Context context, @Nullable AttributeSet attributeSet, int i2) {
        TypedArray h2 = k.h(context, attributeSet, R.styleable.Chip, i2, q, new int[0]);
        this.f4181j = h2.getBoolean(R.styleable.Chip_ensureMinTouchTargetSize, false);
        this.f4183l = (int) Math.ceil(h2.getDimension(R.styleable.Chip_chipMinTouchTargetSize, (float) Math.ceil(p.c(getContext(), 48))));
        h2.recycle();
    }

    private void v() {
        if (Build.VERSION.SDK_INT >= 21) {
            setOutlineProvider(new b());
        }
    }

    private void w(int i2, int i3, int i4, int i5) {
        this.b = new InsetDrawable((Drawable) this.a, i2, i3, i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f4176e = onCheckedChangeListener;
    }

    public boolean E() {
        return this.f4181j;
    }

    @Override // com.google.android.material.chip.a.InterfaceC0168a
    public void a() {
        k(this.f4183l);
        requestLayout();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    @Override // android.view.View
    protected boolean dispatchHoverEvent(@NonNull MotionEvent motionEvent) {
        return s(motionEvent) || this.m.dispatchHoverEvent(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.m.dispatchKeyEvent(keyEvent) || this.m.getKeyboardFocusedVirtualViewId() == Integer.MIN_VALUE) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        com.google.android.material.chip.a aVar = this.a;
        if ((aVar == null || !aVar.c1()) ? false : this.a.Y1(j())) {
            invalidate();
        }
    }

    @Override // android.widget.TextView
    @Nullable
    public TextUtils.TruncateAt getEllipsize() {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            return aVar.S0();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(@NonNull Rect rect) {
        if (this.m.getKeyboardFocusedVirtualViewId() != 1 && this.m.getAccessibilityFocusedVirtualViewId() != 1) {
            super.getFocusedRect(rect);
        } else {
            rect.set(q());
        }
    }

    public boolean k(@Dimension int i2) {
        this.f4183l = i2;
        if (!E()) {
            if (this.b != null) {
                A();
            } else {
                H();
            }
            return false;
        }
        int max = Math.max(0, i2 - this.a.getIntrinsicHeight());
        int max2 = Math.max(0, i2 - this.a.getIntrinsicWidth());
        if (max2 <= 0 && max <= 0) {
            if (this.b != null) {
                A();
            } else {
                H();
            }
            return false;
        }
        int i3 = max2 > 0 ? max2 / 2 : 0;
        int i4 = max > 0 ? max / 2 : 0;
        if (this.b != null) {
            Rect rect = new Rect();
            this.b.getPadding(rect);
            if (rect.top == i4 && rect.bottom == i4 && rect.left == i3 && rect.right == i3) {
                H();
                return true;
            }
        }
        if (Build.VERSION.SDK_INT >= 16) {
            if (getMinHeight() != i2) {
                setMinHeight(i2);
            }
            if (getMinWidth() != i2) {
                setMinWidth(i2);
            }
        } else {
            setMinHeight(i2);
            setMinWidth(i2);
        }
        w(i3, i4, i3, i4);
        H();
        return true;
    }

    @Nullable
    public Drawable m() {
        InsetDrawable insetDrawable = this.b;
        return insetDrawable == null ? this.a : insetDrawable;
    }

    public float n() {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            return aVar.K0();
        }
        return 0.0f;
    }

    @Nullable
    public CharSequence o() {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            return aVar.N0();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        i.f(this, this.a);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 2);
        if (isChecked()) {
            CheckBox.mergeDrawableStates(onCreateDrawableState, s);
        }
        if (x()) {
            CheckBox.mergeDrawableStates(onCreateDrawableState, t);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z, int i2, Rect rect) {
        super.onFocusChanged(z, i2, rect);
        this.m.onFocusChanged(z, i2, rect);
    }

    @Override // android.view.View
    public boolean onHoverEvent(@NonNull MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 7) {
            B(p().contains(motionEvent.getX(), motionEvent.getY()));
        } else if (actionMasked == 10) {
            B(false);
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (!x() && !isClickable()) {
            accessibilityNodeInfo.setClassName("android.view.View");
        } else {
            accessibilityNodeInfo.setClassName(x() ? "android.widget.CompoundButton" : "android.widget.Button");
        }
        accessibilityNodeInfo.setCheckable(x());
        accessibilityNodeInfo.setClickable(isClickable());
        if (getParent() instanceof ChipGroup) {
            ChipGroup chipGroup = (ChipGroup) getParent();
            AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(chipGroup.c(this), 1, chipGroup.d() ? chipGroup.t(this) : -1, 1, false, isChecked()));
        }
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    @Nullable
    @TargetApi(24)
    public PointerIcon onResolvePointerIcon(@NonNull MotionEvent motionEvent, int i2) {
        if (p().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) {
            return PointerIcon.getSystemIcon(getContext(), 1002);
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    @TargetApi(17)
    public void onRtlPropertiesChanged(int i2) {
        super.onRtlPropertiesChanged(i2);
        if (this.f4182k != i2) {
            this.f4182k = i2;
            J();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
        if (r0 != 3) goto L16;
     */
    @Override // android.widget.TextView, android.view.View
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(@androidx.annotation.NonNull android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getActionMasked()
            android.graphics.RectF r1 = r5.p()
            float r2 = r6.getX()
            float r3 = r6.getY()
            boolean r1 = r1.contains(r2, r3)
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L39
            if (r0 == r3) goto L2b
            r4 = 2
            if (r0 == r4) goto L21
            r1 = 3
            if (r0 == r1) goto L34
            goto L40
        L21:
            boolean r0 = r5.f4178g
            if (r0 == 0) goto L40
            if (r1 != 0) goto L3e
            r5.C(r2)
            goto L3e
        L2b:
            boolean r0 = r5.f4178g
            if (r0 == 0) goto L34
            r5.z()
            r0 = 1
            goto L35
        L34:
            r0 = 0
        L35:
            r5.C(r2)
            goto L41
        L39:
            if (r1 == 0) goto L40
            r5.C(r3)
        L3e:
            r0 = 1
            goto L41
        L40:
            r0 = 0
        L41:
            if (r0 != 0) goto L49
            boolean r6 = super.onTouchEvent(r6)
            if (r6 == 0) goto L4a
        L49:
            r2 = 1
        L4a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable != m() && drawable != this.c) {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        } else {
            super.setBackground(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable != m() && drawable != this.c) {
            Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
        } else {
            super.setBackgroundDrawable(drawable);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundResource(int i2) {
        Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z) {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.k1(z);
        }
    }

    public void setCheckableResource(@BoolRes int i2) {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.l1(i2);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        com.google.android.material.chip.a aVar = this.a;
        if (aVar == null) {
            this.f4177f = z;
        } else if (aVar.b1()) {
            boolean isChecked = isChecked();
            super.setChecked(z);
            if (isChecked == z || (onCheckedChangeListener = this.f4176e) == null) {
                return;
            }
            onCheckedChangeListener.onCheckedChanged(this, z);
        }
    }

    public void setCheckedIcon(@Nullable Drawable drawable) {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.m1(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z) {
        setCheckedIconVisible(z);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(@BoolRes int i2) {
        setCheckedIconVisible(i2);
    }

    public void setCheckedIconResource(@DrawableRes int i2) {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.n1(i2);
        }
    }

    public void setCheckedIconTint(@Nullable ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.o1(colorStateList);
        }
    }

    public void setCheckedIconTintResource(@ColorRes int i2) {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.p1(i2);
        }
    }

    public void setCheckedIconVisible(@BoolRes int i2) {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.q1(i2);
        }
    }

    public void setChipBackgroundColor(@Nullable ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.s1(colorStateList);
        }
    }

    public void setChipBackgroundColorResource(@ColorRes int i2) {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.t1(i2);
        }
    }

    @Deprecated
    public void setChipCornerRadius(float f2) {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.u1(f2);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(@DimenRes int i2) {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.v1(i2);
        }
    }

    public void setChipDrawable(@NonNull com.google.android.material.chip.a aVar) {
        com.google.android.material.chip.a aVar2 = this.a;
        if (aVar2 != aVar) {
            F(aVar2);
            this.a = aVar;
            aVar.n2(false);
            i(this.a);
            k(this.f4183l);
        }
    }

    public void setChipEndPadding(float f2) {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.w1(f2);
        }
    }

    public void setChipEndPaddingResource(@DimenRes int i2) {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.x1(i2);
        }
    }

    public void setChipIcon(@Nullable Drawable drawable) {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.y1(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z) {
        setChipIconVisible(z);
    }

    @Deprecated
    public void setChipIconEnabledResource(@BoolRes int i2) {
        setChipIconVisible(i2);
    }

    public void setChipIconResource(@DrawableRes int i2) {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.z1(i2);
        }
    }

    public void setChipIconSize(float f2) {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.A1(f2);
        }
    }

    public void setChipIconSizeResource(@DimenRes int i2) {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.B1(i2);
        }
    }

    public void setChipIconTint(@Nullable ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.C1(colorStateList);
        }
    }

    public void setChipIconTintResource(@ColorRes int i2) {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.D1(i2);
        }
    }

    public void setChipIconVisible(@BoolRes int i2) {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.E1(i2);
        }
    }

    public void setChipMinHeight(float f2) {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.G1(f2);
        }
    }

    public void setChipMinHeightResource(@DimenRes int i2) {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.H1(i2);
        }
    }

    public void setChipStartPadding(float f2) {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.I1(f2);
        }
    }

    public void setChipStartPaddingResource(@DimenRes int i2) {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.J1(i2);
        }
    }

    public void setChipStrokeColor(@Nullable ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.K1(colorStateList);
        }
    }

    public void setChipStrokeColorResource(@ColorRes int i2) {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.L1(i2);
        }
    }

    public void setChipStrokeWidth(float f2) {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.M1(f2);
        }
    }

    public void setChipStrokeWidthResource(@DimenRes int i2) {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.N1(i2);
        }
    }

    @Deprecated
    public void setChipText(@Nullable CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(@StringRes int i2) {
        setText(getResources().getString(i2));
    }

    public void setCloseIcon(@Nullable Drawable drawable) {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.P1(drawable);
        }
        G();
    }

    public void setCloseIconContentDescription(@Nullable CharSequence charSequence) {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.Q1(charSequence);
        }
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z) {
        setCloseIconVisible(z);
    }

    @Deprecated
    public void setCloseIconEnabledResource(@BoolRes int i2) {
        setCloseIconVisible(i2);
    }

    public void setCloseIconEndPadding(float f2) {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.R1(f2);
        }
    }

    public void setCloseIconEndPaddingResource(@DimenRes int i2) {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.S1(i2);
        }
    }

    public void setCloseIconResource(@DrawableRes int i2) {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.T1(i2);
        }
        G();
    }

    public void setCloseIconSize(float f2) {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.U1(f2);
        }
    }

    public void setCloseIconSizeResource(@DimenRes int i2) {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.V1(i2);
        }
    }

    public void setCloseIconStartPadding(float f2) {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.W1(f2);
        }
    }

    public void setCloseIconStartPaddingResource(@DimenRes int i2) {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.X1(i2);
        }
    }

    public void setCloseIconTint(@Nullable ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.Z1(colorStateList);
        }
    }

    public void setCloseIconTintResource(@ColorRes int i2) {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.a2(i2);
        }
    }

    public void setCloseIconVisible(@BoolRes int i2) {
        setCloseIconVisible(getResources().getBoolean(i2));
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        if (i2 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i4 == 0) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(i2, i3, i4, i5);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        if (i2 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i4 == 0) {
            super.setCompoundDrawablesWithIntrinsicBounds(i2, i3, i4, i5);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f2) {
        super.setElevation(f2);
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.V(f2);
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.a == null) {
            return;
        }
        if (truncateAt != TextUtils.TruncateAt.MARQUEE) {
            super.setEllipsize(truncateAt);
            com.google.android.material.chip.a aVar = this.a;
            if (aVar != null) {
                aVar.d2(truncateAt);
                return;
            }
            return;
        }
        throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
    }

    public void setEnsureMinTouchTargetSize(boolean z) {
        this.f4181j = z;
        k(this.f4183l);
    }

    @Override // android.widget.TextView
    public void setGravity(int i2) {
        if (i2 != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i2);
        }
    }

    public void setHideMotionSpec(@Nullable g gVar) {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.e2(gVar);
        }
    }

    public void setHideMotionSpecResource(@AnimatorRes int i2) {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.f2(i2);
        }
    }

    public void setIconEndPadding(float f2) {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.g2(f2);
        }
    }

    public void setIconEndPaddingResource(@DimenRes int i2) {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.h2(i2);
        }
    }

    public void setIconStartPadding(float f2) {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.i2(f2);
        }
    }

    public void setIconStartPaddingResource(@DimenRes int i2) {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.j2(i2);
        }
    }

    @Override // android.view.View
    public void setLayoutDirection(int i2) {
        if (this.a != null && Build.VERSION.SDK_INT >= 17) {
            super.setLayoutDirection(i2);
        }
    }

    @Override // android.widget.TextView
    public void setLines(int i2) {
        if (i2 <= 1) {
            super.setLines(i2);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i2) {
        if (i2 <= 1) {
            super.setMaxLines(i2);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setMaxWidth(@Px int i2) {
        super.setMaxWidth(i2);
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.k2(i2);
        }
    }

    @Override // android.widget.TextView
    public void setMinLines(int i2) {
        if (i2 <= 1) {
            super.setMinLines(i2);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.f4175d = onClickListener;
        G();
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.l2(colorStateList);
        }
        if (this.a.Z0()) {
            return;
        }
        I();
    }

    public void setRippleColorResource(@ColorRes int i2) {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.m2(i2);
            if (this.a.Z0()) {
                return;
            }
            I();
        }
    }

    @Override // com.google.android.material.shape.o
    public void setShapeAppearanceModel(@NonNull m mVar) {
        this.a.setShapeAppearanceModel(mVar);
    }

    public void setShowMotionSpec(@Nullable g gVar) {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.o2(gVar);
        }
    }

    public void setShowMotionSpecResource(@AnimatorRes int i2) {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.p2(i2);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z) {
        if (z) {
            super.setSingleLine(z);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        super.setText(aVar.y2() ? null : charSequence, bufferType);
        com.google.android.material.chip.a aVar2 = this.a;
        if (aVar2 != null) {
            aVar2.q2(charSequence);
        }
    }

    public void setTextAppearance(@Nullable d dVar) {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.r2(dVar);
        }
        K();
    }

    public void setTextAppearanceResource(@StyleRes int i2) {
        setTextAppearance(getContext(), i2);
    }

    public void setTextEndPadding(float f2) {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.t2(f2);
        }
    }

    public void setTextEndPaddingResource(@DimenRes int i2) {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.u2(i2);
        }
    }

    public void setTextStartPadding(float f2) {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.v2(f2);
        }
    }

    public void setTextStartPaddingResource(@DimenRes int i2) {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.w2(i2);
        }
    }

    public boolean x() {
        com.google.android.material.chip.a aVar = this.a;
        return aVar != null && aVar.b1();
    }

    public boolean y() {
        com.google.android.material.chip.a aVar = this.a;
        return aVar != null && aVar.d1();
    }

    @CallSuper
    public boolean z() {
        boolean z = false;
        playSoundEffect(0);
        View.OnClickListener onClickListener = this.f4175d;
        if (onClickListener != null) {
            onClickListener.onClick(this);
            z = true;
        }
        this.m.sendEventForVirtualView(1, 1);
        return z;
    }

    public Chip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.chipStyle);
    }

    public void setCloseIconVisible(boolean z) {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.b2(z);
        }
        G();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Chip(android.content.Context r8, android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r4 = com.google.android.material.chip.Chip.q
            android.content.Context r8 = com.google.android.material.theme.a.a.c(r8, r9, r10, r4)
            r7.<init>(r8, r9, r10)
            android.graphics.Rect r8 = new android.graphics.Rect
            r8.<init>()
            r7.n = r8
            android.graphics.RectF r8 = new android.graphics.RectF
            r8.<init>()
            r7.o = r8
            com.google.android.material.chip.Chip$a r8 = new com.google.android.material.chip.Chip$a
            r8.<init>()
            r7.p = r8
            android.content.Context r8 = r7.getContext()
            r7.L(r9)
            com.google.android.material.chip.a r6 = com.google.android.material.chip.a.x0(r8, r9, r10, r4)
            r7.u(r8, r9, r10)
            r7.setChipDrawable(r6)
            float r0 = androidx.core.view.ViewCompat.getElevation(r7)
            r6.V(r0)
            int[] r2 = com.google.android.material.R.styleable.Chip
            r0 = 0
            int[] r5 = new int[r0]
            r0 = r8
            r1 = r9
            r3 = r10
            android.content.res.TypedArray r9 = com.google.android.material.internal.k.h(r0, r1, r2, r3, r4, r5)
            int r10 = android.os.Build.VERSION.SDK_INT
            r0 = 23
            if (r10 >= r0) goto L51
            int r10 = com.google.android.material.R.styleable.Chip_android_textColor
            android.content.res.ColorStateList r8 = com.google.android.material.f.c.a(r8, r9, r10)
            r7.setTextColor(r8)
        L51:
            int r8 = com.google.android.material.R.styleable.Chip_shapeAppearance
            boolean r8 = r9.hasValue(r8)
            r9.recycle()
            com.google.android.material.chip.Chip$c r9 = new com.google.android.material.chip.Chip$c
            r9.<init>(r7)
            r7.m = r9
            r7.G()
            if (r8 != 0) goto L69
            r7.v()
        L69:
            boolean r8 = r7.f4177f
            r7.setChecked(r8)
            java.lang.CharSequence r8 = r6.U0()
            r7.setText(r8)
            android.text.TextUtils$TruncateAt r8 = r6.S0()
            r7.setEllipsize(r8)
            r7.K()
            com.google.android.material.chip.a r8 = r7.a
            boolean r8 = r8.y2()
            if (r8 != 0) goto L8e
            r8 = 1
            r7.setLines(r8)
            r7.setHorizontallyScrolling(r8)
        L8e:
            r8 = 8388627(0x800013, float:1.175497E-38)
            r7.setGravity(r8)
            r7.J()
            boolean r8 = r7.E()
            if (r8 == 0) goto La2
            int r8 = r7.f4183l
            r7.setMinHeight(r8)
        La2:
            int r8 = androidx.core.view.ViewCompat.getLayoutDirection(r7)
            r7.f4182k = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setCheckedIconVisible(boolean z) {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.r1(z);
        }
    }

    public void setChipIconVisible(boolean z) {
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.F1(z);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.s2(i2);
        }
        K();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i2) {
        super.setTextAppearance(i2);
        com.google.android.material.chip.a aVar = this.a;
        if (aVar != null) {
            aVar.s2(i2);
        }
        K();
    }
}
