package us.pinguo.inspire.module.comment.widget;

import android.animation.Animator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import us.pinguo.inspire.R;
import us.pinguo.inspire.module.comment.IInfoView;
import us.pinguo.ui.widget.j;
/* compiled from: InfoBottomLayout.kt */
/* loaded from: classes9.dex */
public final class InfoBottomLayout extends FrameLayout {
    public static final Companion Companion = new Companion(null);
    private static final long DURATION = 300;
    private final float CHAT_TRANS_DP;
    public Map<Integer, View> _$_findViewCache;
    private IInfoView mIInfoView;

    /* compiled from: InfoBottomLayout.kt */
    /* loaded from: classes9.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(o oVar) {
            this();
        }

        public final long getDURATION() {
            return InfoBottomLayout.DURATION;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InfoBottomLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        s.h(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.CHAT_TRANS_DP = 80.0f;
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i2));
        if (view == null) {
            View findViewById = findViewById(i2);
            if (findViewById == null) {
                return null;
            }
            map.put(Integer.valueOf(i2), findViewById);
            return findViewById;
        }
        return view;
    }

    public final IInfoView getMIInfoView() {
        return this.mIInfoView;
    }

    public final void hideChatBottom$Inspire_marketGoogleRelease() {
        ((InfoChatBottom) _$_findCachedViewById(R.id.info_bottom_chat_layout)).animate().translationY(us.pinguo.foundation.t.b.a.a(getContext(), this.CHAT_TRANS_DP)).alpha(0.0f).setDuration(DURATION).setListener(new j() { // from class: us.pinguo.inspire.module.comment.widget.InfoBottomLayout$hideChatBottom$1
            @Override // us.pinguo.ui.widget.j, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ((InfoChatBottom) InfoBottomLayout.this._$_findCachedViewById(R.id.info_bottom_chat_layout)).setVisibility(8);
            }
        }).start();
        IInfoView iInfoView = this.mIInfoView;
        if (iInfoView == null) {
            return;
        }
        iInfoView.onChatBottomHide();
    }

    public final boolean onBackPressed() {
        int i2 = R.id.info_bottom_chat_layout;
        if (((InfoChatBottom) _$_findCachedViewById(i2)).getVisibility() == 0) {
            if (((InfoChatBottom) _$_findCachedViewById(i2)).onBackPressed()) {
                return true;
            }
            hideChatBottom$Inspire_marketGoogleRelease();
            return true;
        }
        return false;
    }

    public final void setMIInfoView(IInfoView iInfoView) {
        this.mIInfoView = iInfoView;
    }

    public final void showChatBottom() {
        int i2 = R.id.info_bottom_chat_layout;
        ((InfoChatBottom) _$_findCachedViewById(i2)).setAlpha(0.0f);
        ((InfoChatBottom) _$_findCachedViewById(i2)).setTranslationY(us.pinguo.foundation.t.b.a.a(getContext(), this.CHAT_TRANS_DP));
        ((InfoChatBottom) _$_findCachedViewById(i2)).setVisibility(0);
        ((InfoChatBottom) _$_findCachedViewById(i2)).animate().translationY(0.0f).alpha(1.0f).setListener(null).setDuration(DURATION).start();
        ((InfoChatBottom) _$_findCachedViewById(i2)).setCommentMode();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InfoBottomLayout(Context context) {
        this(context, null, 0);
        s.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InfoBottomLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        s.h(context, "context");
    }
}
