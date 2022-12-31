package us.pinguo.inspire.widget.like;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import rx.Subscriber;
import rx.Subscription;
import us.pinguo.foundation.statistics.h;
import us.pinguo.inspire.cell.recycler.e;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.user.s0;
import us.pinguo.user.util.f;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class LikeImageView extends ImageView implements View.OnClickListener {
    private us.pinguo.inspire.widget.like.a a;
    private String b;
    private e c;

    /* renamed from: d  reason: collision with root package name */
    private int f11370d;

    /* renamed from: e  reason: collision with root package name */
    private int f11371e;

    /* renamed from: f  reason: collision with root package name */
    private f f11372f;

    /* renamed from: g  reason: collision with root package name */
    private View f11373g;

    /* renamed from: h  reason: collision with root package name */
    private View.OnClickListener f11374h;

    /* renamed from: i  reason: collision with root package name */
    private ObjectAnimator f11375i;

    /* renamed from: j  reason: collision with root package name */
    private Runnable f11376j;

    /* renamed from: k  reason: collision with root package name */
    private Handler f11377k;

    /* renamed from: l  reason: collision with root package name */
    private ImageView f11378l;
    private f.b m;
    private View.OnClickListener n;
    private f.b o;

    /* loaded from: classes9.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LikeImageView.this.f11372f.d(view, LikeImageView.this.o);
        }
    }

    /* loaded from: classes9.dex */
    class b implements f.b {
        b() {
        }

        @Override // us.pinguo.user.util.f.b
        public void onDoubleClick(View view) {
            if (LikeImageView.this.a.isLiked()) {
                LikeImageView.this.m();
                InspireWork inspireWork = new InspireWork();
                inspireWork.workId = LikeImageView.this.b;
                LikeImageView.this.c.addSubscription(inspireWork.like().subscribe((Subscriber<? super Boolean>) new us.pinguo.inspire.lib.rx.a()));
            } else {
                LikeImageView likeImageView = LikeImageView.this;
                likeImageView.onClick(likeImageView);
            }
            if (LikeImageView.this.m != null) {
                LikeImageView.this.m.onDoubleClick(view);
            }
        }

        @Override // us.pinguo.user.util.f.b
        public void onSingleClick(View view) {
            if (LikeImageView.this.f11374h != null) {
                LikeImageView.this.f11374h.onClick(view);
            }
            if (LikeImageView.this.m != null) {
                LikeImageView.this.m.onSingleClick(view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class c implements Animator.AnimatorListener {
        final /* synthetic */ AnimationDrawable a;
        final /* synthetic */ ImageView b;

        c(LikeImageView likeImageView, AnimationDrawable animationDrawable, ImageView imageView) {
            this.a = animationDrawable;
            this.b = imageView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.a.isRunning()) {
                return;
            }
            this.b.setVisibility(8);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LikeImageView.this.f11375i.start();
        }
    }

    public LikeImageView(Context context) {
        super(context);
        this.f11372f = new f();
        this.f11377k = new Handler(Looper.getMainLooper());
        this.n = new a();
        this.o = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        ImageView imageView = this.f11378l;
        if (imageView == null) {
            return;
        }
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
        if (this.f11375i == null) {
            ObjectAnimator ofInt = ObjectAnimator.ofInt(imageView, "alpha", 255, 0);
            this.f11375i = ofInt;
            ofInt.setDuration(300L);
            this.f11375i.addListener(new c(this, animationDrawable, imageView));
        }
        if (this.f11376j == null) {
            this.f11376j = new d();
        }
        this.f11377k.removeCallbacks(this.f11376j);
        if (animationDrawable.isRunning()) {
            animationDrawable.stop();
        }
        if (this.f11375i.isStarted()) {
            this.f11375i.end();
        }
        imageView.setAlpha(255);
        imageView.setVisibility(0);
        animationDrawable.start();
        this.f11377k.postDelayed(this.f11376j, 900L);
    }

    public us.pinguo.inspire.widget.like.a j() {
        return this.a;
    }

    public void k(us.pinguo.inspire.widget.like.a aVar, int i2, int i3, String str, e eVar, View view, View.OnClickListener onClickListener, ImageView imageView) {
        this.b = str;
        this.c = eVar;
        this.a = aVar;
        this.f11370d = i2;
        this.f11371e = i3;
        this.f11378l = imageView;
        setSrcByState();
        setOnClickListener(this);
        this.f11373g = view;
        this.f11374h = onClickListener;
        if (view != null) {
            view.setOnClickListener(this.n);
        }
    }

    public void l(us.pinguo.inspire.widget.like.a aVar, String str, e eVar) {
        k(aVar, R.drawable.icon_square_unlike, R.drawable.icon_square_like, str, eVar, null, null, null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Subscription subscribe;
        if (!s0.getInstance().e()) {
            h.a.g("", us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER, "show");
            s0.getInstance().a((Activity) getContext(), 0, us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER);
            return;
        }
        InspireWork inspireWork = new InspireWork();
        inspireWork.workId = this.b;
        if (this.a.isLiked()) {
            subscribe = inspireWork.disLike().subscribe((Subscriber<? super Boolean>) new us.pinguo.inspire.lib.rx.a());
            this.a.setLikeState(false);
        } else {
            subscribe = inspireWork.like().subscribe((Subscriber<? super Boolean>) new us.pinguo.inspire.lib.rx.a());
            this.a.setLikeState(true);
            m();
        }
        this.c.addSubscription(subscribe);
        setSrcByState();
    }

    public void setOnDoubleClickListener(f.b bVar) {
        this.m = bVar;
    }

    public void setSrcByState() {
        if (this.a.isLiked()) {
            setImageResource(this.f11371e);
        } else {
            setImageResource(this.f11370d);
        }
    }

    public LikeImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11372f = new f();
        this.f11377k = new Handler(Looper.getMainLooper());
        this.n = new a();
        this.o = new b();
    }

    public LikeImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11372f = new f();
        this.f11377k = new Handler(Looper.getMainLooper());
        this.n = new a();
        this.o = new b();
    }
}
