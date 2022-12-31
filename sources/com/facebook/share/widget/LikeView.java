package com.facebook.share.widget;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.FacebookException;
import com.facebook.common.R;
import com.facebook.internal.n;
import com.facebook.internal.t;
import com.facebook.internal.x;
import com.facebook.share.internal.LikeBoxCountView;
import com.facebook.share.internal.LikeButton;
import com.facebook.share.internal.c;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.growingio.android.sdk.models.PageEvent;
import com.tapjoy.TJAdUnitConstants;
@Deprecated
/* loaded from: classes.dex */
public class LikeView extends FrameLayout {
    private String a;
    private ObjectType b;
    private LinearLayout c;

    /* renamed from: d  reason: collision with root package name */
    private LikeButton f3249d;

    /* renamed from: e  reason: collision with root package name */
    private LikeBoxCountView f3250e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f3251f;

    /* renamed from: g  reason: collision with root package name */
    private com.facebook.share.internal.c f3252g;

    /* renamed from: h  reason: collision with root package name */
    private e f3253h;

    /* renamed from: i  reason: collision with root package name */
    private BroadcastReceiver f3254i;

    /* renamed from: j  reason: collision with root package name */
    private c f3255j;

    /* renamed from: k  reason: collision with root package name */
    private Style f3256k;

    /* renamed from: l  reason: collision with root package name */
    private HorizontalAlignment f3257l;
    private AuxiliaryViewPosition m;
    private int n;
    private int o;
    private int p;
    private n q;
    private boolean r;

    @Deprecated
    /* loaded from: classes.dex */
    public enum AuxiliaryViewPosition {
        BOTTOM(TJAdUnitConstants.String.BOTTOM, 0),
        INLINE(TJAdUnitConstants.String.INLINE, 1),
        TOP(TJAdUnitConstants.String.TOP, 2);
        
        static AuxiliaryViewPosition DEFAULT = BOTTOM;
        private int intValue;
        private String stringValue;

        AuxiliaryViewPosition(String str, int i2) {
            this.stringValue = str;
            this.intValue = i2;
        }

        static AuxiliaryViewPosition fromInt(int i2) {
            AuxiliaryViewPosition[] values;
            for (AuxiliaryViewPosition auxiliaryViewPosition : values()) {
                if (auxiliaryViewPosition.getValue() == i2) {
                    return auxiliaryViewPosition;
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getValue() {
            return this.intValue;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.stringValue;
        }
    }

    @Deprecated
    /* loaded from: classes.dex */
    public enum HorizontalAlignment {
        CENTER("center", 0),
        LEFT(TJAdUnitConstants.String.LEFT, 1),
        RIGHT(TJAdUnitConstants.String.RIGHT, 2);
        
        static HorizontalAlignment DEFAULT = CENTER;
        private int intValue;
        private String stringValue;

        HorizontalAlignment(String str, int i2) {
            this.stringValue = str;
            this.intValue = i2;
        }

        static HorizontalAlignment fromInt(int i2) {
            HorizontalAlignment[] values;
            for (HorizontalAlignment horizontalAlignment : values()) {
                if (horizontalAlignment.getValue() == i2) {
                    return horizontalAlignment;
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getValue() {
            return this.intValue;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.stringValue;
        }
    }

    @Deprecated
    /* loaded from: classes.dex */
    public enum ObjectType {
        UNKNOWN("unknown", 0),
        OPEN_GRAPH("open_graph", 1),
        PAGE(PageEvent.TYPE_NAME, 2);
        
        private int intValue;
        private String stringValue;
        public static ObjectType DEFAULT = UNKNOWN;

        ObjectType(String str, int i2) {
            this.stringValue = str;
            this.intValue = i2;
        }

        public static ObjectType fromInt(int i2) {
            ObjectType[] values;
            for (ObjectType objectType : values()) {
                if (objectType.getValue() == i2) {
                    return objectType;
                }
            }
            return null;
        }

        public int getValue() {
            return this.intValue;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.stringValue;
        }
    }

    @Deprecated
    /* loaded from: classes.dex */
    public enum Style {
        STANDARD("standard", 0),
        BUTTON("button", 1),
        BOX_COUNT("box_count", 2);
        
        private int intValue;
        private String stringValue;
        static Style DEFAULT = STANDARD;

        Style(String str, int i2) {
            this.stringValue = str;
            this.intValue = i2;
        }

        static Style fromInt(int i2) {
            Style[] values;
            for (Style style : values()) {
                if (style.getValue() == i2) {
                    return style;
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getValue() {
            return this.intValue;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.stringValue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                LikeView.this.s();
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[AuxiliaryViewPosition.values().length];
            a = iArr;
            try {
                iArr[AuxiliaryViewPosition.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[AuxiliaryViewPosition.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[AuxiliaryViewPosition.INLINE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements c.o {
        private boolean a;

        private c() {
        }

        @Override // com.facebook.share.internal.c.o
        public void a(com.facebook.share.internal.c cVar, FacebookException facebookException) {
            if (this.a) {
                return;
            }
            if (cVar != null) {
                if (!cVar.q0()) {
                    facebookException = new FacebookException("Cannot use LikeView. The device may not be supported.");
                }
                LikeView.this.i(cVar);
                LikeView.this.v();
            }
            if (facebookException != null && LikeView.this.f3253h != null) {
                LikeView.this.f3253h.onError(facebookException);
            }
            LikeView.this.f3255j = null;
        }

        public void b() {
            this.a = true;
        }

        /* synthetic */ c(LikeView likeView, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d extends BroadcastReceiver {
        private d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            VdsAgent.onBroadcastReceiver(this, context, intent);
            String action = intent.getAction();
            Bundle extras = intent.getExtras();
            boolean z = true;
            if (extras != null) {
                String string = extras.getString("com.facebook.sdk.LikeActionController.OBJECT_ID");
                if (!x.S(string) && !x.b(LikeView.this.a, string)) {
                    z = false;
                }
            }
            if (z) {
                if ("com.facebook.sdk.LikeActionController.UPDATED".equals(action)) {
                    LikeView.this.v();
                } else if ("com.facebook.sdk.LikeActionController.DID_ERROR".equals(action)) {
                    if (LikeView.this.f3253h != null) {
                        LikeView.this.f3253h.onError(t.t(extras));
                    }
                } else if ("com.facebook.sdk.LikeActionController.DID_RESET".equals(action)) {
                    LikeView likeView = LikeView.this;
                    likeView.q(likeView.a, LikeView.this.b);
                    LikeView.this.v();
                }
            }
        }

        /* synthetic */ d(LikeView likeView, a aVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        void onError(FacebookException facebookException);
    }

    @Deprecated
    public LikeView(Context context) {
        super(context);
        this.f3256k = Style.DEFAULT;
        this.f3257l = HorizontalAlignment.DEFAULT;
        this.m = AuxiliaryViewPosition.DEFAULT;
        this.n = -1;
        this.r = true;
        l(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(com.facebook.share.internal.c cVar) {
        this.f3252g = cVar;
        this.f3254i = new d(this, null);
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(getContext());
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.facebook.sdk.LikeActionController.UPDATED");
        intentFilter.addAction("com.facebook.sdk.LikeActionController.DID_ERROR");
        intentFilter.addAction("com.facebook.sdk.LikeActionController.DID_RESET");
        localBroadcastManager.registerReceiver(this.f3254i, intentFilter);
    }

    private Activity j() {
        boolean z;
        Context context = getContext();
        while (true) {
            z = context instanceof Activity;
            if (z || !(context instanceof ContextWrapper)) {
                break;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (z) {
            return (Activity) context;
        }
        throw new FacebookException("Unable to get Activity.");
    }

    private Bundle k() {
        Bundle bundle = new Bundle();
        bundle.putString(TJAdUnitConstants.String.STYLE, this.f3256k.toString());
        bundle.putString("auxiliary_position", this.m.toString());
        bundle.putString("horizontal_alignment", this.f3257l.toString());
        bundle.putString("object_id", x.i(this.a, ""));
        bundle.putString("object_type", this.b.toString());
        return bundle;
    }

    private void l(Context context) {
        this.o = getResources().getDimensionPixelSize(R.dimen.com_facebook_likeview_edge_padding);
        this.p = getResources().getDimensionPixelSize(R.dimen.com_facebook_likeview_internal_padding);
        if (this.n == -1) {
            this.n = getResources().getColor(R.color.com_facebook_likeview_text_color);
        }
        setBackgroundColor(0);
        this.c = new LinearLayout(context);
        this.c.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        m(context);
        o(context);
        n(context);
        this.c.addView(this.f3249d);
        this.c.addView(this.f3251f);
        this.c.addView(this.f3250e);
        addView(this.c);
        q(this.a, this.b);
        v();
    }

    private void m(Context context) {
        com.facebook.share.internal.c cVar = this.f3252g;
        LikeButton likeButton = new LikeButton(context, cVar != null && cVar.X());
        this.f3249d = likeButton;
        likeButton.setOnClickListener(new a());
        this.f3249d.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    }

    private void n(Context context) {
        this.f3250e = new LikeBoxCountView(context);
        this.f3250e.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    }

    private void o(Context context) {
        TextView textView = new TextView(context);
        this.f3251f = textView;
        textView.setTextSize(0, getResources().getDimension(R.dimen.com_facebook_likeview_text_size));
        this.f3251f.setMaxLines(2);
        this.f3251f.setTextColor(this.n);
        this.f3251f.setGravity(17);
        this.f3251f.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
    }

    private void p(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes;
        if (attributeSet == null || getContext() == null || (obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.com_facebook_like_view)) == null) {
            return;
        }
        this.a = x.i(obtainStyledAttributes.getString(R.styleable.com_facebook_like_view_com_facebook_object_id), null);
        this.b = ObjectType.fromInt(obtainStyledAttributes.getInt(R.styleable.com_facebook_like_view_com_facebook_object_type, ObjectType.DEFAULT.getValue()));
        Style fromInt = Style.fromInt(obtainStyledAttributes.getInt(R.styleable.com_facebook_like_view_com_facebook_style, Style.DEFAULT.getValue()));
        this.f3256k = fromInt;
        if (fromInt != null) {
            AuxiliaryViewPosition fromInt2 = AuxiliaryViewPosition.fromInt(obtainStyledAttributes.getInt(R.styleable.com_facebook_like_view_com_facebook_auxiliary_view_position, AuxiliaryViewPosition.DEFAULT.getValue()));
            this.m = fromInt2;
            if (fromInt2 != null) {
                HorizontalAlignment fromInt3 = HorizontalAlignment.fromInt(obtainStyledAttributes.getInt(R.styleable.com_facebook_like_view_com_facebook_horizontal_alignment, HorizontalAlignment.DEFAULT.getValue()));
                this.f3257l = fromInt3;
                if (fromInt3 != null) {
                    this.n = obtainStyledAttributes.getColor(R.styleable.com_facebook_like_view_com_facebook_foreground_color, -1);
                    obtainStyledAttributes.recycle();
                    return;
                }
                throw new IllegalArgumentException("Unsupported value for LikeView 'horizontal_alignment'");
            }
            throw new IllegalArgumentException("Unsupported value for LikeView 'auxiliary_view_position'");
        }
        throw new IllegalArgumentException("Unsupported value for LikeView 'style'");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(String str, ObjectType objectType) {
        r();
        this.a = str;
        this.b = objectType;
        if (x.S(str)) {
            return;
        }
        this.f3255j = new c(this, null);
        if (isInEditMode()) {
            return;
        }
        com.facebook.share.internal.c.P(str, objectType, this.f3255j);
    }

    private void r() {
        if (this.f3254i != null) {
            LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(this.f3254i);
            this.f3254i = null;
        }
        c cVar = this.f3255j;
        if (cVar != null) {
            cVar.b();
            this.f3255j = null;
        }
        this.f3252g = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (this.f3252g != null) {
            this.f3252g.s0(this.q == null ? j() : null, this.q, k());
        }
    }

    private void t() {
        int i2 = b.a[this.m.ordinal()];
        if (i2 == 1) {
            this.f3250e.setCaretPosition(LikeBoxCountView.LikeBoxCountViewCaretPosition.BOTTOM);
        } else if (i2 == 2) {
            this.f3250e.setCaretPosition(LikeBoxCountView.LikeBoxCountViewCaretPosition.TOP);
        } else if (i2 != 3) {
        } else {
            this.f3250e.setCaretPosition(this.f3257l == HorizontalAlignment.RIGHT ? LikeBoxCountView.LikeBoxCountViewCaretPosition.RIGHT : LikeBoxCountView.LikeBoxCountViewCaretPosition.LEFT);
        }
    }

    private void u() {
        com.facebook.share.internal.c cVar;
        View view;
        com.facebook.share.internal.c cVar2;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.c.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f3249d.getLayoutParams();
        HorizontalAlignment horizontalAlignment = this.f3257l;
        int i2 = horizontalAlignment == HorizontalAlignment.LEFT ? 3 : horizontalAlignment == HorizontalAlignment.CENTER ? 1 : 5;
        layoutParams.gravity = i2 | 48;
        layoutParams2.gravity = i2;
        TextView textView = this.f3251f;
        textView.setVisibility(8);
        VdsAgent.onSetViewVisibility(textView, 8);
        LikeBoxCountView likeBoxCountView = this.f3250e;
        likeBoxCountView.setVisibility(8);
        VdsAgent.onSetViewVisibility(likeBoxCountView, 8);
        if (this.f3256k == Style.STANDARD && (cVar2 = this.f3252g) != null && !x.S(cVar2.U())) {
            view = this.f3251f;
        } else if (this.f3256k != Style.BOX_COUNT || (cVar = this.f3252g) == null || x.S(cVar.R())) {
            return;
        } else {
            t();
            view = this.f3250e;
        }
        view.setVisibility(0);
        VdsAgent.onSetViewVisibility(view, 0);
        ((LinearLayout.LayoutParams) view.getLayoutParams()).gravity = i2;
        LinearLayout linearLayout = this.c;
        AuxiliaryViewPosition auxiliaryViewPosition = this.m;
        AuxiliaryViewPosition auxiliaryViewPosition2 = AuxiliaryViewPosition.INLINE;
        linearLayout.setOrientation(auxiliaryViewPosition != auxiliaryViewPosition2 ? 1 : 0);
        AuxiliaryViewPosition auxiliaryViewPosition3 = this.m;
        if (auxiliaryViewPosition3 != AuxiliaryViewPosition.TOP && (auxiliaryViewPosition3 != auxiliaryViewPosition2 || this.f3257l != HorizontalAlignment.RIGHT)) {
            this.c.removeView(view);
            this.c.addView(view);
        } else {
            this.c.removeView(this.f3249d);
            this.c.addView(this.f3249d);
        }
        int i3 = b.a[this.m.ordinal()];
        if (i3 == 1) {
            int i4 = this.o;
            view.setPadding(i4, i4, i4, this.p);
        } else if (i3 == 2) {
            int i5 = this.o;
            view.setPadding(i5, this.p, i5, i5);
        } else if (i3 != 3) {
        } else {
            if (this.f3257l == HorizontalAlignment.RIGHT) {
                int i6 = this.o;
                view.setPadding(i6, i6, this.p, i6);
                return;
            }
            int i7 = this.p;
            int i8 = this.o;
            view.setPadding(i7, i8, i8, i8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        boolean z = !this.r;
        com.facebook.share.internal.c cVar = this.f3252g;
        if (cVar == null) {
            this.f3249d.setSelected(false);
            this.f3251f.setText((CharSequence) null);
            this.f3250e.setText(null);
        } else {
            this.f3249d.setSelected(cVar.X());
            this.f3251f.setText(this.f3252g.U());
            this.f3250e.setText(this.f3252g.R());
            z &= this.f3252g.q0();
        }
        super.setEnabled(z);
        this.f3249d.setEnabled(z);
        u();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        setObjectIdAndType(null, ObjectType.UNKNOWN);
        super.onDetachedFromWindow();
    }

    @Deprecated
    public void setAuxiliaryViewPosition(AuxiliaryViewPosition auxiliaryViewPosition) {
        if (auxiliaryViewPosition == null) {
            auxiliaryViewPosition = AuxiliaryViewPosition.DEFAULT;
        }
        if (this.m != auxiliaryViewPosition) {
            this.m = auxiliaryViewPosition;
            u();
        }
    }

    @Override // android.view.View
    @Deprecated
    public void setEnabled(boolean z) {
        this.r = true;
        v();
    }

    @Deprecated
    public void setForegroundColor(int i2) {
        if (this.n != i2) {
            this.f3251f.setTextColor(i2);
        }
    }

    @Deprecated
    public void setFragment(Fragment fragment) {
        this.q = new n(fragment);
    }

    @Deprecated
    public void setHorizontalAlignment(HorizontalAlignment horizontalAlignment) {
        if (horizontalAlignment == null) {
            horizontalAlignment = HorizontalAlignment.DEFAULT;
        }
        if (this.f3257l != horizontalAlignment) {
            this.f3257l = horizontalAlignment;
            u();
        }
    }

    @Deprecated
    public void setLikeViewStyle(Style style) {
        if (style == null) {
            style = Style.DEFAULT;
        }
        if (this.f3256k != style) {
            this.f3256k = style;
            u();
        }
    }

    @Deprecated
    public void setObjectIdAndType(String str, ObjectType objectType) {
        String i2 = x.i(str, null);
        if (objectType == null) {
            objectType = ObjectType.DEFAULT;
        }
        if (x.b(i2, this.a) && objectType == this.b) {
            return;
        }
        q(i2, objectType);
        v();
    }

    @Deprecated
    public void setOnErrorListener(e eVar) {
        this.f3253h = eVar;
    }

    @Deprecated
    public void setFragment(android.app.Fragment fragment) {
        this.q = new n(fragment);
    }

    @Deprecated
    public LikeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3256k = Style.DEFAULT;
        this.f3257l = HorizontalAlignment.DEFAULT;
        this.m = AuxiliaryViewPosition.DEFAULT;
        this.n = -1;
        this.r = true;
        p(attributeSet);
        l(context);
    }
}
