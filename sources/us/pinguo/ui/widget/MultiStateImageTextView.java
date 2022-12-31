package us.pinguo.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.collections.h0;
import kotlin.jvm.internal.s;
import us.pinguo.ui.R;
/* compiled from: MultiStateImageTextView.kt */
/* loaded from: classes6.dex */
public final class MultiStateImageTextView extends ConstraintLayout {
    private int[] a;
    private int[] b;
    private int[] c;

    /* renamed from: d  reason: collision with root package name */
    private int f12155d;

    /* renamed from: e  reason: collision with root package name */
    private int f12156e;

    /* renamed from: f  reason: collision with root package name */
    private int f12157f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f12158g;

    /* renamed from: h  reason: collision with root package name */
    private int f12159h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f12160i;

    /* renamed from: j  reason: collision with root package name */
    private SparseArray<k> f12161j;

    /* renamed from: k  reason: collision with root package name */
    private int f12162k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiStateImageTextView(Context context) {
        super(context);
        s.h(context, "context");
        new LinkedHashMap();
        this.f12155d = -1;
        this.f12162k = -1;
        i(null, 0);
    }

    private final void i(AttributeSet attributeSet, int i2) {
        kotlin.z.d h2;
        kotlin.z.d h3;
        kotlin.z.d h4;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.MultiStateImageTextView, i2, 0);
        s.g(obtainStyledAttributes, "context.obtainStyledAttr…ageTextView, defStyle, 0)");
        Resources resources = obtainStyledAttributes.getResources();
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.MultiStateImageTextView_images, 0);
        if (resourceId != 0) {
            TypedArray obtainTypedArray = resources.obtainTypedArray(resourceId);
            s.g(obtainTypedArray, "res.obtainTypedArray(imageResArrayId)");
            int length = obtainTypedArray.length();
            if (length > 0) {
                this.a = new int[length];
                h4 = kotlin.z.j.h(0, length);
                Iterator<Integer> it = h4.iterator();
                while (it.hasNext()) {
                    int nextInt = ((h0) it).nextInt();
                    int[] iArr = this.a;
                    if (iArr != null) {
                        iArr[nextInt] = obtainTypedArray.getResourceId(nextInt, 0);
                    }
                }
            }
            obtainTypedArray.recycle();
        }
        int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.MultiStateImageTextView_texts, 0);
        if (resourceId2 != 0) {
            TypedArray obtainTypedArray2 = resources.obtainTypedArray(resourceId2);
            s.g(obtainTypedArray2, "res.obtainTypedArray(textResArrayId)");
            int length2 = obtainTypedArray2.length();
            if (length2 > 0) {
                this.b = new int[length2];
                h3 = kotlin.z.j.h(0, length2);
                Iterator<Integer> it2 = h3.iterator();
                while (it2.hasNext()) {
                    int nextInt2 = ((h0) it2).nextInt();
                    int[] iArr2 = this.b;
                    if (iArr2 != null) {
                        iArr2[nextInt2] = obtainTypedArray2.getResourceId(nextInt2, 0);
                    }
                }
            }
            obtainTypedArray2.recycle();
        }
        int resourceId3 = obtainStyledAttributes.getResourceId(R.styleable.MultiStateImageTextView_text_styles, 0);
        if (resourceId3 != 0) {
            TypedArray obtainTypedArray3 = resources.obtainTypedArray(resourceId3);
            s.g(obtainTypedArray3, "res.obtainTypedArray(styleResArrayId)");
            int length3 = obtainTypedArray3.length();
            if (length3 > 0) {
                this.c = new int[length3];
                h2 = kotlin.z.j.h(0, length3);
                Iterator<Integer> it3 = h2.iterator();
                while (it3.hasNext()) {
                    int nextInt3 = ((h0) it3).nextInt();
                    int[] iArr3 = this.c;
                    if (iArr3 != null) {
                        iArr3[nextInt3] = obtainTypedArray3.getResourceId(nextInt3, 0);
                    }
                }
            }
            obtainTypedArray3.recycle();
        }
        int[] iArr4 = this.a;
        this.f12156e = iArr4 == null ? 0 : iArr4.length;
        int resourceId4 = obtainStyledAttributes.getResourceId(R.styleable.MultiStateImageTextView_image_view_id, 0);
        if (resourceId4 != 0) {
            this.f12157f = resourceId4;
        }
        int resourceId5 = obtainStyledAttributes.getResourceId(R.styleable.MultiStateImageTextView_text_view_id, 0);
        if (resourceId5 != 0) {
            this.f12159h = resourceId5;
        }
        obtainStyledAttributes.recycle();
    }

    private final void l(int i2, int i3) {
        TextView textView = this.f12160i;
        if (textView == null) {
            return;
        }
        textView.setText(i2);
        textView.setTextAppearance(getContext(), i3);
    }

    public final void g() {
        if (this.f12161j == null && this.f12156e > 0 && isEnabled()) {
            int i2 = this.f12155d + 1;
            if (i2 >= this.f12156e) {
                i2 = 0;
            }
            ImageView imageView = this.f12158g;
            if (imageView != null) {
                int[] iArr = this.a;
                imageView.setImageResource(iArr == null ? 0 : iArr[i2]);
            }
            TextView textView = this.f12160i;
            if (textView != null) {
                int[] iArr2 = this.b;
                textView.setText(iArr2 == null ? 0 : iArr2[i2]);
            }
            TextView textView2 = this.f12160i;
            if (textView2 != null) {
                Context context = getContext();
                int[] iArr3 = this.c;
                textView2.setTextAppearance(context, iArr3 != null ? iArr3[i2] : 0);
            }
            this.f12155d = i2;
        }
    }

    public final void h(int i2) {
        if (this.f12161j == null && this.f12156e > 0 && isEnabled() && i2 >= 0 && i2 < this.f12156e) {
            this.f12155d = i2;
            ImageView imageView = this.f12158g;
            if (imageView != null) {
                int[] iArr = this.a;
                imageView.setImageResource(iArr == null ? 0 : iArr[i2]);
            }
            int[] iArr2 = this.b;
            int i3 = iArr2 == null ? 0 : iArr2[i2];
            int[] iArr3 = this.c;
            l(i3, iArr3 != null ? iArr3[i2] : 0);
        }
    }

    public final void j(int i2) {
        this.f12155d = i2;
    }

    public final void k(int[] imageArray, int[] textArray, int[] textStyleArray) {
        s.h(imageArray, "imageArray");
        s.h(textArray, "textArray");
        s.h(textStyleArray, "textStyleArray");
        this.a = imageArray;
        this.b = textArray;
        this.c = textStyleArray;
        this.f12156e = imageArray.length;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f12158g = (ImageView) findViewById(this.f12157f);
        this.f12160i = (TextView) findViewById(this.f12159h);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        k kVar;
        super.setEnabled(z);
        SparseArray<k> sparseArray = this.f12161j;
        if (sparseArray != null) {
            if (z) {
                kVar = sparseArray.get(this.f12162k);
                if (kVar == null) {
                    return;
                }
            } else {
                kVar = sparseArray.get(0);
                if (kVar == null) {
                    return;
                }
            }
            setAlpha(z ? 1.0f : 0.5f);
            ImageView imageView = this.f12158g;
            if (imageView != null) {
                imageView.setImageResource(kVar.a());
            }
            l(kVar.b(), kVar.c());
        } else if (z) {
            setAlpha(1.0f);
            int i2 = this.f12155d;
            if (i2 < 0) {
                i2++;
                this.f12155d = i2;
            }
            ImageView imageView2 = this.f12158g;
            if (imageView2 != null) {
                int[] iArr = this.a;
                imageView2.setImageResource(iArr == null ? 0 : iArr[i2]);
            }
            int[] iArr2 = this.b;
            int i3 = iArr2 == null ? 0 : iArr2[i2];
            int[] iArr3 = this.c;
            l(i3, iArr3 != null ? iArr3[i2] : 0);
        } else {
            setAlpha(0.5f);
            ImageView imageView3 = this.f12158g;
            if (imageView3 != null) {
                int[] iArr4 = this.a;
                imageView3.setImageResource(iArr4 == null ? 0 : iArr4[0]);
            }
            int[] iArr5 = this.b;
            int i4 = iArr5 == null ? 0 : iArr5[0];
            int[] iArr6 = this.c;
            l(i4, iArr6 != null ? iArr6[0] : 0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiStateImageTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        s.h(context, "context");
        s.h(attrs, "attrs");
        new LinkedHashMap();
        this.f12155d = -1;
        this.f12162k = -1;
        i(attrs, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiStateImageTextView(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        s.h(context, "context");
        s.h(attrs, "attrs");
        new LinkedHashMap();
        this.f12155d = -1;
        this.f12162k = -1;
        i(attrs, i2);
    }
}
