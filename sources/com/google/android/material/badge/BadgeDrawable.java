package com.google.android.material.badge;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.PluralsRes;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.f.d;
import com.google.android.material.internal.h;
import com.google.android.material.internal.k;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;
import org.slf4j.Marker;
/* loaded from: classes2.dex */
public class BadgeDrawable extends Drawable implements h.b {
    @NonNull
    private final WeakReference<Context> a;
    @NonNull
    private final com.google.android.material.shape.h b;
    @NonNull
    private final h c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final Rect f4074d;

    /* renamed from: e  reason: collision with root package name */
    private final float f4075e;

    /* renamed from: f  reason: collision with root package name */
    private final float f4076f;

    /* renamed from: g  reason: collision with root package name */
    private final float f4077g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private final SavedState f4078h;

    /* renamed from: i  reason: collision with root package name */
    private float f4079i;

    /* renamed from: j  reason: collision with root package name */
    private float f4080j;

    /* renamed from: k  reason: collision with root package name */
    private int f4081k;

    /* renamed from: l  reason: collision with root package name */
    private float f4082l;
    private float m;
    private float n;
    @Nullable
    private WeakReference<View> o;
    @Nullable
    private WeakReference<FrameLayout> p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        final /* synthetic */ View a;
        final /* synthetic */ FrameLayout b;

        a(View view, FrameLayout frameLayout) {
            this.a = view;
            this.b = frameLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            BadgeDrawable.this.B(this.a, this.b);
        }
    }

    private BadgeDrawable(@NonNull Context context) {
        this.a = new WeakReference<>(context);
        k.c(context);
        Resources resources = context.getResources();
        this.f4074d = new Rect();
        this.b = new com.google.android.material.shape.h();
        this.f4075e = resources.getDimensionPixelSize(R.dimen.mtrl_badge_radius);
        this.f4077g = resources.getDimensionPixelSize(R.dimen.mtrl_badge_long_text_horizontal_padding);
        this.f4076f = resources.getDimensionPixelSize(R.dimen.mtrl_badge_with_text_radius);
        h hVar = new h(this);
        this.c = hVar;
        hVar.e().setTextAlign(Paint.Align.CENTER);
        this.f4078h = new SavedState(context);
        w(R.style.TextAppearance_MaterialComponents_Badge);
    }

    private static void A(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.setClipChildren(false);
        viewGroup.setClipToPadding(false);
    }

    private void C() {
        Context context = this.a.get();
        WeakReference<View> weakReference = this.o;
        View view = weakReference != null ? weakReference.get() : null;
        if (context == null || view == null) {
            return;
        }
        Rect rect = new Rect();
        rect.set(this.f4074d);
        Rect rect2 = new Rect();
        view.getDrawingRect(rect2);
        WeakReference<FrameLayout> weakReference2 = this.p;
        FrameLayout frameLayout = weakReference2 != null ? weakReference2.get() : null;
        if (frameLayout != null || com.google.android.material.badge.a.a) {
            if (frameLayout == null) {
                frameLayout = (ViewGroup) view.getParent();
            }
            frameLayout.offsetDescendantRectToMyCoords(view, rect2);
        }
        b(context, rect2, view);
        com.google.android.material.badge.a.f(this.f4074d, this.f4079i, this.f4080j, this.m, this.n);
        this.b.T(this.f4082l);
        if (rect.equals(this.f4074d)) {
            return;
        }
        this.b.setBounds(this.f4074d);
    }

    private void D() {
        this.f4081k = ((int) Math.pow(10.0d, i() - 1.0d)) - 1;
    }

    private void b(@NonNull Context context, @NonNull Rect rect, @NonNull View view) {
        int i2 = this.f4078h.verticalOffset + this.f4078h.additionalVerticalOffset;
        int i3 = this.f4078h.badgeGravity;
        if (i3 != 8388691 && i3 != 8388693) {
            this.f4080j = rect.top + i2;
        } else {
            this.f4080j = rect.bottom - i2;
        }
        if (j() <= 9) {
            float f2 = !l() ? this.f4075e : this.f4076f;
            this.f4082l = f2;
            this.n = f2;
            this.m = f2;
        } else {
            float f3 = this.f4076f;
            this.f4082l = f3;
            this.n = f3;
            this.m = (this.c.f(e()) / 2.0f) + this.f4077g;
        }
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(l() ? R.dimen.mtrl_badge_text_horizontal_edge_offset : R.dimen.mtrl_badge_horizontal_edge_offset);
        int i4 = this.f4078h.horizontalOffset + this.f4078h.additionalHorizontalOffset;
        int i5 = this.f4078h.badgeGravity;
        if (i5 != 8388659 && i5 != 8388691) {
            this.f4079i = ViewCompat.getLayoutDirection(view) == 0 ? ((rect.right + this.m) - dimensionPixelSize) - i4 : (rect.left - this.m) + dimensionPixelSize + i4;
        } else {
            this.f4079i = ViewCompat.getLayoutDirection(view) == 0 ? (rect.left - this.m) + dimensionPixelSize + i4 : ((rect.right + this.m) - dimensionPixelSize) - i4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static BadgeDrawable c(@NonNull Context context, @NonNull SavedState savedState) {
        BadgeDrawable badgeDrawable = new BadgeDrawable(context);
        badgeDrawable.m(savedState);
        return badgeDrawable;
    }

    private void d(Canvas canvas) {
        Rect rect = new Rect();
        String e2 = e();
        this.c.e().getTextBounds(e2, 0, e2.length(), rect);
        canvas.drawText(e2, this.f4079i, this.f4080j + (rect.height() / 2), this.c.e());
    }

    @NonNull
    private String e() {
        if (j() <= this.f4081k) {
            return NumberFormat.getInstance().format(j());
        }
        Context context = this.a.get();
        return context == null ? "" : context.getString(R.string.mtrl_exceed_max_badge_number_suffix, Integer.valueOf(this.f4081k), Marker.ANY_NON_NULL_MARKER);
    }

    private void m(@NonNull SavedState savedState) {
        t(savedState.maxCharacterCount);
        if (savedState.number != -1) {
            u(savedState.number);
        }
        p(savedState.backgroundColor);
        r(savedState.badgeTextColor);
        q(savedState.badgeGravity);
        s(savedState.horizontalOffset);
        x(savedState.verticalOffset);
        n(savedState.additionalHorizontalOffset);
        o(savedState.additionalVerticalOffset);
        y(savedState.isVisible);
    }

    private void v(@Nullable d dVar) {
        Context context;
        if (this.c.d() == dVar || (context = this.a.get()) == null) {
            return;
        }
        this.c.h(dVar, context);
        C();
    }

    private void w(@StyleRes int i2) {
        Context context = this.a.get();
        if (context == null) {
            return;
        }
        v(new d(context, i2));
    }

    private void z(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup == null || viewGroup.getId() != R.id.mtrl_anchor_parent) {
            WeakReference<FrameLayout> weakReference = this.p;
            if (weakReference == null || weakReference.get() != viewGroup) {
                A(view);
                FrameLayout frameLayout = new FrameLayout(view.getContext());
                frameLayout.setId(R.id.mtrl_anchor_parent);
                frameLayout.setClipChildren(false);
                frameLayout.setClipToPadding(false);
                frameLayout.setLayoutParams(view.getLayoutParams());
                frameLayout.setMinimumWidth(view.getWidth());
                frameLayout.setMinimumHeight(view.getHeight());
                int indexOfChild = viewGroup.indexOfChild(view);
                viewGroup.removeViewAt(indexOfChild);
                view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                frameLayout.addView(view);
                viewGroup.addView(frameLayout, indexOfChild);
                this.p = new WeakReference<>(frameLayout);
                frameLayout.post(new a(view, frameLayout));
            }
        }
    }

    public void B(@NonNull View view, @Nullable FrameLayout frameLayout) {
        this.o = new WeakReference<>(view);
        boolean z = com.google.android.material.badge.a.a;
        if (z && frameLayout == null) {
            z(view);
        } else {
            this.p = new WeakReference<>(frameLayout);
        }
        if (!z) {
            A(view);
        }
        C();
        invalidateSelf();
    }

    @Override // com.google.android.material.internal.h.b
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void a() {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (getBounds().isEmpty() || getAlpha() == 0 || !isVisible()) {
            return;
        }
        this.b.draw(canvas);
        if (l()) {
            d(canvas);
        }
    }

    @Nullable
    public CharSequence f() {
        Context context;
        if (isVisible()) {
            if (l()) {
                if (this.f4078h.contentDescriptionQuantityStrings <= 0 || (context = this.a.get()) == null) {
                    return null;
                }
                if (j() <= this.f4081k) {
                    return context.getResources().getQuantityString(this.f4078h.contentDescriptionQuantityStrings, j(), Integer.valueOf(j()));
                }
                return context.getString(this.f4078h.contentDescriptionExceedsMaxBadgeNumberRes, Integer.valueOf(this.f4081k));
            }
            return this.f4078h.contentDescriptionNumberless;
        }
        return null;
    }

    @Nullable
    public FrameLayout g() {
        WeakReference<FrameLayout> weakReference = this.p;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f4078h.alpha;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f4074d.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f4074d.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public int h() {
        return this.f4078h.horizontalOffset;
    }

    public int i() {
        return this.f4078h.maxCharacterCount;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return false;
    }

    public int j() {
        if (l()) {
            return this.f4078h.number;
        }
        return 0;
    }

    @NonNull
    public SavedState k() {
        return this.f4078h;
    }

    public boolean l() {
        return this.f4078h.number != -1;
    }

    void n(int i2) {
        this.f4078h.additionalHorizontalOffset = i2;
        C();
    }

    void o(int i2) {
        this.f4078h.additionalVerticalOffset = i2;
        C();
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.h.b
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    public void p(@ColorInt int i2) {
        this.f4078h.backgroundColor = i2;
        ColorStateList valueOf = ColorStateList.valueOf(i2);
        if (this.b.x() != valueOf) {
            this.b.W(valueOf);
            invalidateSelf();
        }
    }

    public void q(int i2) {
        if (this.f4078h.badgeGravity != i2) {
            this.f4078h.badgeGravity = i2;
            WeakReference<View> weakReference = this.o;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            View view = this.o.get();
            WeakReference<FrameLayout> weakReference2 = this.p;
            B(view, weakReference2 != null ? weakReference2.get() : null);
        }
    }

    public void r(@ColorInt int i2) {
        this.f4078h.badgeTextColor = i2;
        if (this.c.e().getColor() != i2) {
            this.c.e().setColor(i2);
            invalidateSelf();
        }
    }

    public void s(int i2) {
        this.f4078h.horizontalOffset = i2;
        C();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f4078h.alpha = i2;
        this.c.e().setAlpha(i2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void t(int i2) {
        if (this.f4078h.maxCharacterCount != i2) {
            this.f4078h.maxCharacterCount = i2;
            D();
            this.c.i(true);
            C();
            invalidateSelf();
        }
    }

    public void u(int i2) {
        int max = Math.max(0, i2);
        if (this.f4078h.number != max) {
            this.f4078h.number = max;
            this.c.i(true);
            C();
            invalidateSelf();
        }
    }

    public void x(int i2) {
        this.f4078h.verticalOffset = i2;
        C();
    }

    public void y(boolean z) {
        setVisible(z, false);
        this.f4078h.isVisible = z;
        if (!com.google.android.material.badge.a.a || g() == null || z) {
            return;
        }
        ((ViewGroup) g().getParent()).invalidate();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public static final class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        @Dimension(unit = 1)
        private int additionalHorizontalOffset;
        @Dimension(unit = 1)
        private int additionalVerticalOffset;
        private int alpha;
        @ColorInt
        private int backgroundColor;
        private int badgeGravity;
        @ColorInt
        private int badgeTextColor;
        @StringRes
        private int contentDescriptionExceedsMaxBadgeNumberRes;
        @Nullable
        private CharSequence contentDescriptionNumberless;
        @PluralsRes
        private int contentDescriptionQuantityStrings;
        @Dimension(unit = 1)
        private int horizontalOffset;
        private boolean isVisible;
        private int maxCharacterCount;
        private int number;
        @Dimension(unit = 1)
        private int verticalOffset;

        /* loaded from: classes2.dex */
        static class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: a */
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: b */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        public SavedState(@NonNull Context context) {
            this.alpha = 255;
            this.number = -1;
            this.badgeTextColor = new d(context, R.style.TextAppearance_MaterialComponents_Badge).a.getDefaultColor();
            this.contentDescriptionNumberless = context.getString(R.string.mtrl_badge_numberless_content_description);
            this.contentDescriptionQuantityStrings = R.plurals.mtrl_badge_content_description;
            this.contentDescriptionExceedsMaxBadgeNumberRes = R.string.mtrl_exceed_max_badge_number_content_description;
            this.isVisible = true;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            parcel.writeInt(this.backgroundColor);
            parcel.writeInt(this.badgeTextColor);
            parcel.writeInt(this.alpha);
            parcel.writeInt(this.number);
            parcel.writeInt(this.maxCharacterCount);
            parcel.writeString(this.contentDescriptionNumberless.toString());
            parcel.writeInt(this.contentDescriptionQuantityStrings);
            parcel.writeInt(this.badgeGravity);
            parcel.writeInt(this.horizontalOffset);
            parcel.writeInt(this.verticalOffset);
            parcel.writeInt(this.additionalHorizontalOffset);
            parcel.writeInt(this.additionalVerticalOffset);
            parcel.writeInt(this.isVisible ? 1 : 0);
        }

        protected SavedState(@NonNull Parcel parcel) {
            this.alpha = 255;
            this.number = -1;
            this.backgroundColor = parcel.readInt();
            this.badgeTextColor = parcel.readInt();
            this.alpha = parcel.readInt();
            this.number = parcel.readInt();
            this.maxCharacterCount = parcel.readInt();
            this.contentDescriptionNumberless = parcel.readString();
            this.contentDescriptionQuantityStrings = parcel.readInt();
            this.badgeGravity = parcel.readInt();
            this.horizontalOffset = parcel.readInt();
            this.verticalOffset = parcel.readInt();
            this.additionalHorizontalOffset = parcel.readInt();
            this.additionalVerticalOffset = parcel.readInt();
            this.isVisible = parcel.readInt() != 0;
        }
    }
}
