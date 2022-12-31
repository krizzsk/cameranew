package us.pinguo.inspire.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.airbnb.lottie.LottieAnimationView;
import rx.functions.Action1;
import us.pinguo.foundation.statistics.PageStack;
import us.pinguo.foundation.statistics.l;
import us.pinguo.foundation.utils.f0;
import us.pinguo.foundation.utils.j0;
import us.pinguo.inspire.module.attention.InspireAttention;
import us.pinguo.inspire.module.message.category.type.InspireRelation;
import us.pinguo.inspire.util.j;
import us.pinguo.inspire.widget.AttentionButton;
import us.pinguo.user.model.IRelation;
import us.pinguo.user.s0;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class InfoAttentionButton extends LottieAnimationView implements View.OnClickListener {
    private boolean A;
    protected IRelation u;
    private View.OnClickListener v;
    private AttentionButton.g w;
    private String x;
    private us.pinguo.foundation.base.c y;
    private Drawable z;

    /* loaded from: classes9.dex */
    class a implements j.a {
        a() {
        }

        @Override // us.pinguo.inspire.util.j.a
        public void a(Throwable th) {
            j0.c(R.string.toast_follow_failed);
            if (InfoAttentionButton.this.w != null) {
                InfoAttentionButton.this.w.onAddAttentionFail(th);
            }
        }

        @Override // us.pinguo.inspire.util.j.a
        public void b(InspireAttention inspireAttention) {
            if (InfoAttentionButton.this.w != null) {
                InfoAttentionButton.this.w.onAddAttentionSuccess(inspireAttention);
            }
            InfoAttentionButton.this.u.setRelation(inspireAttention.relation);
        }
    }

    /* loaded from: classes9.dex */
    class b implements j.b {
        b(InfoAttentionButton infoAttentionButton) {
        }

        @Override // us.pinguo.inspire.util.j.b
        public void a(InspireAttention inspireAttention) {
        }

        @Override // us.pinguo.inspire.util.j.b
        public void b(Throwable th) {
            j0.c(R.string.toast_unfollow_failed);
        }
    }

    public InfoAttentionButton(Context context) {
        super(context);
    }

    private void w() {
        us.pinguo.foundation.utils.h.a(us.pinguo.foundation.r.d.a().c(AttentionButton.k.class).subscribe(new Action1() { // from class: us.pinguo.inspire.widget.e
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                InfoAttentionButton.this.y((AttentionButton.k) obj);
            }
        }, f.a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x */
    public /* synthetic */ void y(AttentionButton.k kVar) {
        if (Integer.toHexString(System.identityHashCode(this)).equals(kVar.b) || !this.x.equals(kVar.c)) {
            return;
        }
        this.u.setRelation(kVar.a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void z(Throwable th) {
        us.pinguo.foundation.e.e(th);
        d.f.a.b.d.c(th);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View findViewById;
        Context context;
        if (m() || k() == 1.0f) {
            return;
        }
        View.OnClickListener onClickListener = this.v;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        int relation = this.u.getRelation();
        InspireRelation inspireRelation = InspireRelation.FOLLOW;
        boolean z = (relation == inspireRelation.ordinal() || this.u.getRelation() == InspireRelation.FOLLOW_AND_FANS.ordinal()) ? false : true;
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
        if (z) {
            this.A = false;
            us.pinguo.common.log.a.m("hwLog", "mDrawAdd:" + this.A, new Object[0]);
            invalidate();
            Context context2 = view.getContext();
            l.i(context2, "attention_click", "id=" + this.x + ",src=" + PageStack.getInstance().e());
            p();
            j.a(s0.getInstance().getUserId(), this.x, this.y, new a());
        } else {
            this.A = true;
            us.pinguo.common.log.a.m("hwLog", "mDrawAdd:" + this.A, new Object[0]);
            invalidate();
            Context context3 = view.getContext();
            l.i(context3, "attention_cancelled_click", "id=" + this.x + ",src=" + PageStack.getInstance().e());
            f();
            setClickable(true);
            if (this.u.getRelation() == inspireRelation.ordinal()) {
                this.u.setRelation(InspireRelation.NONE.ordinal());
            } else {
                this.u.setRelation(InspireRelation.FANS.ordinal());
            }
            j.b(s0.getInstance().getUserId(), this.x, this.y, new b(this));
        }
        us.pinguo.foundation.r.d.a().b(new AttentionButton.k(this.u.getRelation(), Integer.toHexString(System.identityHashCode(this)), this.x));
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable;
        super.onDraw(canvas);
        if (!this.A || (drawable = this.z) == null) {
            return;
        }
        drawable.setBounds(0, 0, getWidth(), getHeight());
        this.z.draw(canvas);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        super.setOnClickListener(this);
        this.z = getResources().getDrawable(R.drawable.icon_vedio_add);
        w();
        setAnimation("lottie/follow/follow.json");
        setImageAssetsFolder("lottie/follow");
        this.A = true;
    }

    public void setBeforeOnClickListener(View.OnClickListener onClickListener) {
        this.v = onClickListener;
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        throw new RuntimeException("please call setBeforeOnClickListener");
    }

    public void v(IRelation iRelation, String str, us.pinguo.foundation.base.c cVar) {
        this.x = str;
        this.y = cVar;
        this.u = iRelation;
        if (f0.b(s0.getInstance().getUserId(), str)) {
            setVisibility(8);
        } else if (!InspireRelation.isFollowed(iRelation.getRelation())) {
            setAlpha(1.0f);
            setVisibility(0);
            setProgress(0.0f);
            setClickable(true);
            this.A = true;
            invalidate();
        } else {
            this.A = false;
            setVisibility(0);
            setProgress(1.0f);
            invalidate();
        }
    }

    public InfoAttentionButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public InfoAttentionButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
