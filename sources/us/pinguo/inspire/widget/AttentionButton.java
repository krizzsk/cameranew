package us.pinguo.inspire.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import rx.functions.Action1;
import us.pinguo.foundation.statistics.PageStack;
import us.pinguo.foundation.statistics.l;
import us.pinguo.foundation.utils.j0;
import us.pinguo.inspire.module.attention.InspireAttention;
import us.pinguo.inspire.module.message.category.type.InspireRelation;
import us.pinguo.inspire.util.j;
import us.pinguo.inspire.widget.AttentionButton;
import us.pinguo.user.model.IRelation;
import us.pinguo.user.s0;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class AttentionButton extends AppCompatTextView implements View.OnClickListener {
    private g a;
    protected IRelation b;
    private boolean c;

    /* renamed from: d  reason: collision with root package name */
    protected String f11306d;

    /* renamed from: e  reason: collision with root package name */
    private us.pinguo.foundation.base.c f11307e;

    /* renamed from: f  reason: collision with root package name */
    private Paint f11308f;

    /* renamed from: g  reason: collision with root package name */
    private j f11309g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f11310h;

    /* renamed from: i  reason: collision with root package name */
    private int f11311i;

    /* renamed from: j  reason: collision with root package name */
    private int f11312j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f11313k;

    /* renamed from: l  reason: collision with root package name */
    public h f11314l;
    private i m;
    private View.OnClickListener n;
    private boolean o;
    private long p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (AttentionButton.this.f11309g != null) {
                AttentionButton.this.f11309g.onAnimFinish();
            }
            AttentionButton.this.f11313k = false;
            AttentionButton.this.setVisibility(8);
            AttentionButton.this.setTextColor(-1);
            AttentionButton.this.o = false;
            AttentionButton.this.f11313k = false;
            AttentionButton.this.setTextByRelation();
            AttentionButton.this.x();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AttentionButton.this.invalidate();
            AttentionButton.this.y();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class c implements Animation.AnimationListener {
        c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            AttentionButton.this.setTextByRelation();
            AttentionButton.this.x();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class d implements Animation.AnimationListener {
        d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            AttentionButton.this.f11313k = false;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes9.dex */
    class e implements j.a {
        e() {
        }

        @Override // us.pinguo.inspire.util.j.a
        public void a(Throwable th) {
            j0.c(R.string.toast_follow_failed);
            if (AttentionButton.this.a != null) {
                AttentionButton.this.a.onAddAttentionFail(th);
            }
        }

        @Override // us.pinguo.inspire.util.j.a
        public void b(InspireAttention inspireAttention) {
            if (AttentionButton.this.a != null) {
                AttentionButton.this.a.onAddAttentionSuccess(inspireAttention);
            }
        }
    }

    /* loaded from: classes9.dex */
    class f implements j.b {
        f(AttentionButton attentionButton) {
        }

        @Override // us.pinguo.inspire.util.j.b
        public void a(InspireAttention inspireAttention) {
        }

        @Override // us.pinguo.inspire.util.j.b
        public void b(Throwable th) {
            j0.c(R.string.toast_unfollow_failed);
        }
    }

    /* loaded from: classes9.dex */
    public interface g {
        void onAddAttentionFail(Throwable th);

        void onAddAttentionSuccess(InspireAttention inspireAttention);
    }

    /* loaded from: classes9.dex */
    public interface h {
        void animingStyle(AttentionButton attentionButton);

        void followedStyle(AttentionButton attentionButton);

        void friendStyle(AttentionButton attentionButton);

        void unFollowedStyle(AttentionButton attentionButton);
    }

    /* loaded from: classes9.dex */
    public interface i {
        boolean a();
    }

    /* loaded from: classes9.dex */
    public interface j {
        void onAnimFinish();
    }

    /* loaded from: classes9.dex */
    public static class k {
        public int a;
        public String b;
        public String c;

        public k(int i2, String str, String str2) {
            this.a = i2;
            this.b = str;
            this.c = str2;
        }
    }

    public AttentionButton(Context context) {
        super(context);
        h();
    }

    private void l() {
        us.pinguo.foundation.utils.h.a(us.pinguo.foundation.r.d.a().c(k.class).subscribe(new Action1() { // from class: us.pinguo.inspire.widget.b
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                AttentionButton.this.o((AttentionButton.k) obj);
            }
        }, us.pinguo.inspire.widget.d.a));
    }

    private void m(Canvas canvas) {
        double width = getWidth() / 2;
        double height = getHeight();
        float f2 = (float) (width - (0.37d * height));
        float f3 = (float) (0.5d * height);
        float f4 = (float) (width - (0.12d * height));
        float f5 = (float) (0.75d * height);
        float f6 = f4 - f2;
        float f7 = f5 - f3;
        float f8 = ((float) (width + (0.38d * height))) - 2.0f;
        float f9 = ((float) (height * 0.25d)) + 2.0f;
        float f10 = f8 - f4;
        float f11 = f5 - f9;
        long j2 = this.p;
        if (j2 > 0 && j2 > 0) {
            float currentTimeMillis = (float) (System.currentTimeMillis() - this.p);
            if (currentTimeMillis <= 250.0f) {
                float f12 = currentTimeMillis / 200.0f;
                canvas.drawLine(f2, f3, f2 + (f6 * f12), f3 + (f12 * f7), this.f11308f);
            } else {
                canvas.drawLine(f2, f3, f4, f5, this.f11308f);
                float f13 = (currentTimeMillis - 200.0f) / 100.0f;
                float f14 = f4 + (f10 * f13);
                float f15 = f5 - (f13 * f11);
                int i2 = (f14 > f8 ? 1 : (f14 == f8 ? 0 : -1));
                if (i2 >= 0) {
                    canvas.drawLine(f4 - 2.0f, f5 + 2.0f, f8, f9, this.f11308f);
                } else {
                    canvas.drawLine(f4 - 2.0f, f5 + 2.0f, f14, f15, this.f11308f);
                }
                this.o = i2 >= 0;
            }
        }
        if (this.o) {
            canvas.drawLine(f2, f3, f4, f5, this.f11308f);
            canvas.drawLine(f4 - 2.0f, f5 + 2.0f, f8, f9, this.f11308f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public /* synthetic */ void o(k kVar) {
        String hexString = Integer.toHexString(System.identityHashCode(this));
        String str = this.f11306d;
        if (hexString == null || hexString.equals(kVar.b) || str == null || !str.equals(kVar.c)) {
            return;
        }
        this.b.setRelation(kVar.a);
        setTextByRelation();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void p(Throwable th) {
        us.pinguo.foundation.e.e(th);
        d.f.a.b.d.c(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public /* synthetic */ void r() {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.attention_anim_in);
        loadAnimation.setAnimationListener(new d());
        startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public /* synthetic */ void t() {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.attention_anim);
        loadAnimation.setAnimationListener(new a());
        startAnimation(loadAnimation);
    }

    private void v() {
        this.f11313k = true;
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.attention_anim);
        loadAnimation.setAnimationListener(new c());
        startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        if (getVisibility() == 0) {
            getHandler().post(new Runnable() { // from class: us.pinguo.inspire.widget.c
                @Override // java.lang.Runnable
                public final void run() {
                    AttentionButton.this.r();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        if (this.p == 0) {
            this.p = System.currentTimeMillis();
            this.o = false;
        }
        this.f11313k = true;
        if (this.o) {
            this.p = 0L;
            getHandler().postDelayed(new Runnable() { // from class: us.pinguo.inspire.widget.a
                @Override // java.lang.Runnable
                public final void run() {
                    AttentionButton.this.t();
                }
            }, 200L);
        } else if (getHandler() != null) {
            getHandler().postDelayed(new b(), 25L);
        }
    }

    protected void h() {
        Paint paint = new Paint(1);
        this.f11308f = paint;
        paint.setColor(-1);
        this.f11308f.setStrokeWidth(8.0f);
        setGravity(17);
        setOnClickListener(this);
        this.f11312j = getResources().getColor(us.pinguo.user.R.color.attention_bg_color);
        this.f11311i = R.drawable.attention_btn_click_selector_res_0x7d050004;
        if (isInEditMode()) {
            return;
        }
        l();
    }

    public void i(IRelation iRelation, boolean z, String str, int i2, us.pinguo.foundation.base.c cVar) {
        j(iRelation, z, str, i2, cVar, true);
    }

    public void j(IRelation iRelation, boolean z, String str, int i2, us.pinguo.foundation.base.c cVar, boolean z2) {
        this.p = 0L;
        this.o = false;
        this.c = z;
        this.f11306d = str;
        this.f11307e = cVar;
        this.b = iRelation;
        this.f11312j = i2;
        this.f11310h = z2;
        setTextByRelation();
        this.f11313k = false;
    }

    public void k(IRelation iRelation, boolean z, String str, us.pinguo.foundation.base.c cVar) {
        j(iRelation, z, str, getResources().getColor(us.pinguo.user.R.color.attention_bg_color), cVar, true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        View findViewById;
        Context context;
        i iVar = this.m;
        if ((iVar != null && iVar.a()) || (z = this.f11313k) || z) {
            return;
        }
        View.OnClickListener onClickListener = this.n;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        int relation = this.b.getRelation();
        InspireRelation inspireRelation = InspireRelation.FOLLOW;
        boolean z2 = (relation == inspireRelation.ordinal() || this.b.getRelation() == InspireRelation.FOLLOW_AND_FANS.ordinal()) ? false : true;
        if (!s0.getInstance().e()) {
            if (getContext() instanceof FragmentActivity) {
                us.pinguo.foundation.statistics.h.a.g("", us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER, "show");
                s0.getInstance().a((Activity) getContext(), 0, us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER);
                return;
            } else if (view.getRootView() == null || (findViewById = view.getRootView().findViewById(16908290)) == null || (context = findViewById.getContext()) == null || !(context instanceof FragmentActivity)) {
                return;
            } else {
                us.pinguo.foundation.statistics.h.a.g("", us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER, "show");
                s0.getInstance().a((FragmentActivity) context, 0, us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER);
                return;
            }
        }
        if (z2) {
            Context context2 = view.getContext();
            l.i(context2, "attention_click", "id=" + this.f11306d + ",src=" + PageStack.getInstance().e());
            w();
            us.pinguo.inspire.util.j.a(s0.getInstance().getUserId(), this.f11306d, this.f11307e, new e());
        } else {
            Context context3 = view.getContext();
            l.i(context3, "attention_cancelled_click", "id=" + this.f11306d + ",src=" + PageStack.getInstance().e());
            setBackgroundResource(this.f11311i);
            v();
            if (this.b.getRelation() == inspireRelation.ordinal()) {
                this.b.setRelation(InspireRelation.NONE.ordinal());
            } else {
                this.b.setRelation(InspireRelation.FANS.ordinal());
            }
            us.pinguo.inspire.util.j.b(s0.getInstance().getUserId(), this.f11306d, this.f11307e, new f(this));
        }
        us.pinguo.foundation.r.d.a().b(new k(this.b.getRelation(), Integer.toHexString(System.identityHashCode(this)), this.f11306d));
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m(canvas);
    }

    public void setAttentionListener(g gVar) {
        this.a = gVar;
    }

    public void setAttentionStyle(h hVar) {
        this.f11314l = hVar;
    }

    public void setBeforeOnClickListener(View.OnClickListener onClickListener) {
        this.n = onClickListener;
    }

    public void setBgRes(int i2) {
        this.f11311i = i2;
    }

    public void setClickInteceptor(i iVar) {
        this.m = iVar;
    }

    public void setOnAnimFinishListener(j jVar) {
        this.f11309g = jVar;
    }

    public void setTextByRelation() {
        if (getLayoutParams() != null && !this.f11310h) {
            getLayoutParams().width = getResources().getDimensionPixelSize(R.dimen.feeds_btn_min_width);
        }
        String userId = s0.getInstance().getUserId();
        if (userId != null && userId.equals(this.f11306d)) {
            setVisibility(8);
            return;
        }
        IRelation iRelation = this.b;
        if (iRelation == null) {
            setVisibility(8);
        } else if (iRelation.getRelation() != InspireRelation.FANS.ordinal() && this.b.getRelation() != InspireRelation.NONE.ordinal() && this.b.getRelation() != -1) {
            if (this.b.getRelation() == InspireRelation.SELF.ordinal()) {
                setVisibility(8);
                return;
            }
            if (getLayoutParams() != null && !this.f11310h) {
                getLayoutParams().width = -2;
            }
            setTextColor(this.f11312j);
            setBackgroundResource(this.f11311i);
            if (this.b.getRelation() == InspireRelation.FOLLOW_AND_FANS.ordinal()) {
                setText(R.string.message_relation_follow_each);
                h hVar = this.f11314l;
                if (hVar != null) {
                    hVar.friendStyle(this);
                }
            } else if (this.b.getRelation() == InspireRelation.FOLLOW.ordinal()) {
                setText(R.string.message_relation_followed);
                h hVar2 = this.f11314l;
                if (hVar2 != null) {
                    hVar2.followedStyle(this);
                }
            }
            if (this.c) {
                setVisibility(0);
            } else {
                setVisibility(8);
            }
        } else {
            setTextColor(-1);
            setBackgroundResource(this.f11311i);
            setVisibility(0);
            setText(R.string.inspire_follow);
            h hVar3 = this.f11314l;
            if (hVar3 != null) {
                hVar3.unFollowedStyle(this);
            }
            u();
        }
    }

    protected void u() {
    }

    protected void w() {
        this.f11313k = true;
        setTextColor(ViewCompat.MEASURED_SIZE_MASK);
        setBackgroundResource(this.f11311i);
        h hVar = this.f11314l;
        if (hVar != null) {
            hVar.animingStyle(this);
        }
        if (this.b.getRelation() == InspireRelation.FANS.ordinal()) {
            this.b.setRelation(InspireRelation.FOLLOW_AND_FANS.ordinal());
        } else {
            this.b.setRelation(InspireRelation.FOLLOW.ordinal());
        }
        y();
    }

    public AttentionButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h();
    }

    public AttentionButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        h();
    }
}
