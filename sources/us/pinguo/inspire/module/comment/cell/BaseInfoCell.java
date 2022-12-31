package us.pinguo.inspire.module.comment.cell;

import android.graphics.Bitmap;
import android.view.View;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.user.util.f;
/* compiled from: BaseInfoCell.kt */
/* loaded from: classes9.dex */
public abstract class BaseInfoCell extends us.pinguo.inspire.y.a.b<InspireWork, us.pinguo.inspire.y.a.c> implements us.pinguo.foundation.base.c {
    private static final int TYPE_PIC = 0;
    private f.b onDoubleClickListener;
    private boolean showTransition;
    public static final Companion Companion = new Companion(null);
    private static final int TYPE_VIDEO = 1;
    private static final int TYPE_WORKID = 2;
    private static final int TYPE_VIDEO_AD = 3;
    private static final int MAX_BLUR_SIZE = us.pinguo.foundation.t.b.a.j(us.pinguo.foundation.e.b()) / 2;
    private static final int BLUR_RADIUS = 20;

    /* compiled from: BaseInfoCell.kt */
    /* loaded from: classes9.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.o oVar) {
            this();
        }

        public final int getTYPE_PIC() {
            return BaseInfoCell.TYPE_PIC;
        }

        public final int getTYPE_VIDEO() {
            return BaseInfoCell.TYPE_VIDEO;
        }

        public final int getTYPE_VIDEO_AD() {
            return BaseInfoCell.TYPE_VIDEO_AD;
        }

        public final int getTYPE_WORKID() {
            return BaseInfoCell.TYPE_WORKID;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseInfoCell(InspireWork data) {
        super(data);
        kotlin.jvm.internal.s.h(data, "data");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: doBlur$lambda-0  reason: not valid java name */
    public static final void m161doBlur$lambda0(Bitmap bitmap, Subscriber subscriber) {
        kotlin.jvm.internal.s.h(bitmap, "$bitmap");
        long currentTimeMillis = System.currentTimeMillis();
        Bitmap a = new us.pinguo.ui.widget.GaussianBlur.stackblur.c(bitmap, MAX_BLUR_SIZE).a(BLUR_RADIUS);
        long currentTimeMillis2 = System.currentTimeMillis();
        us.pinguo.common.log.a.k("blur time:" + (currentTimeMillis2 - currentTimeMillis) + "ms", new Object[0]);
        subscriber.onNext(a);
        subscriber.onCompleted();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: doBlur$lambda-1  reason: not valid java name */
    public static final void m162doBlur$lambda1(BaseInfoCell this$0, Bitmap it) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.g(it, "it");
        this$0.onBlured(it);
    }

    @Override // us.pinguo.foundation.base.c
    public void addSubscription(Subscription subscription) {
        us.pinguo.foundation.utils.h.a(subscription);
    }

    public final void doBlur(final Bitmap bitmap) {
        kotlin.jvm.internal.s.h(bitmap, "bitmap");
        boolean z = ((float) bitmap.getWidth()) / ((float) bitmap.getHeight()) > ((float) us.pinguo.foundation.t.b.a.j(us.pinguo.foundation.e.b())) / ((float) us.pinguo.foundation.t.b.a.h(us.pinguo.foundation.e.b()));
        us.pinguo.common.log.a.k(kotlin.jvm.internal.s.q("shouldBlur:", Boolean.valueOf(z)), new Object[0]);
        if (z) {
            Observable.create(new Observable.OnSubscribe() { // from class: us.pinguo.inspire.module.comment.cell.c
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    BaseInfoCell.m161doBlur$lambda0(bitmap, (Subscriber) obj);
                }
            }).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() { // from class: us.pinguo.inspire.module.comment.cell.b
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    BaseInfoCell.m162doBlur$lambda1(BaseInfoCell.this, (Bitmap) obj);
                }
            }, a.a);
        }
    }

    public final f.b getOnDoubleClickListener() {
        return this.onDoubleClickListener;
    }

    public View getShareElement() {
        return null;
    }

    public final boolean getShowTransition() {
        return this.showTransition;
    }

    public abstract boolean isContentPreparedForShare();

    public boolean isFullScreen(View root) {
        kotlin.jvm.internal.s.h(root, "root");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.y.a.b
    public void onBindViewHolder(us.pinguo.inspire.y.a.c viewHolder) {
        View view;
        kotlin.jvm.internal.s.h(viewHolder, "viewHolder");
        us.pinguo.inspire.y.a.c mViewHolder = getMViewHolder();
        if (mViewHolder == null || (view = mViewHolder.b) == null) {
            return;
        }
        view.setBackgroundDrawable(null);
    }

    protected final void onBlured(Bitmap bitmap) {
        View view;
        kotlin.jvm.internal.s.h(bitmap, "bitmap");
        us.pinguo.inspire.y.a.c mViewHolder = getMViewHolder();
        if (mViewHolder == null || (view = mViewHolder.b) == null) {
            return;
        }
        view.setBackgroundDrawable(new BlurBgDrawable(bitmap));
    }

    public final void setOnDoubleClickListener(f.b bVar) {
        this.onDoubleClickListener = bVar;
    }

    public final void setShowTransition(boolean z) {
        this.showTransition = z;
    }

    public void updateWork(InspireWork work) {
        kotlin.jvm.internal.s.h(work, "work");
        setMData(work);
    }
}
