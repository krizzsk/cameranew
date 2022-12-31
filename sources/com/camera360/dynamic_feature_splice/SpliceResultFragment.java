package com.camera360.dynamic_feature_splice;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.sharesdk.tencent.qq.QQClientNotExistException;
import com.camera360.dynamic_feature_splice.SpliceResultFragment;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mob.OperationCallback;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import us.pinguo.inspire.module.contact.cell.FindFriendHeaderCell;
import us.pinguo.share.core.PGShareInfo;
import us.pinguo.share.core.PGShareListener;
import us.pinguo.share.core.PGShareManager;
import us.pinguo.share.core.ShareSite;
import us.pinguo.share.exception.AppNotExistException;
import us.pinguo.share.util.ExpandShareSite;
import us.pinguo.share.util.ShareDataType;
import us.pinguo.ui.widget.TitleBarLayout;
/* compiled from: SpliceResultFragment.kt */
/* loaded from: classes8.dex */
public final class SpliceResultFragment extends Fragment {
    private SpliceResult b;
    private View c;

    /* renamed from: e  reason: collision with root package name */
    private ExpandShareSite f2178e;
    public Map<Integer, View> a = new LinkedHashMap();

    /* renamed from: d  reason: collision with root package name */
    private boolean f2177d = true;

    /* compiled from: SpliceResultFragment.kt */
    /* loaded from: classes8.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ShareSite.values().length];
            iArr[ShareSite.FACEBOOK.ordinal()] = 1;
            iArr[ShareSite.QQ.ordinal()] = 2;
            iArr[ShareSite.QZONE.ordinal()] = 3;
            iArr[ShareSite.WECHAT_MOMENTS.ordinal()] = 4;
            iArr[ShareSite.WECHAT_FRIENDS.ordinal()] = 5;
            iArr[ShareSite.DOUYIN.ordinal()] = 6;
            iArr[ShareSite.SINAWEIBO.ordinal()] = 7;
            iArr[ShareSite.TWITTER.ordinal()] = 8;
            a = iArr;
        }
    }

    /* compiled from: SpliceResultFragment.kt */
    /* loaded from: classes8.dex */
    public static final class b implements TitleBarLayout.a {
        b() {
        }

        @Override // us.pinguo.ui.widget.TitleBarLayout.a
        public void onLeftBtnClick(View view) {
            us.pinguo.foundation.statistics.h.a.B("back_btn");
            FragmentActivity activity = SpliceResultFragment.this.getActivity();
            if (activity != null && (activity instanceof SpliceActivity)) {
                ((SpliceActivity) activity).r0();
            }
        }

        @Override // us.pinguo.ui.widget.TitleBarLayout.a
        public void onRightBtnClick(View view) {
            FragmentActivity activity = SpliceResultFragment.this.getActivity();
            if (activity == null) {
                return;
            }
            Intent intent = new Intent();
            intent.setClassName(activity, "com.pinguo.camera360.homepage.HomePageActivity");
            intent.setFlags(603979776);
            intent.putExtra("show-home-only", true);
            intent.putExtra("is_launch", true);
            us.pinguo.common.log.a.k("launch CameraActivity", new Object[0]);
            activity.startActivity(intent);
            activity.finish();
            us.pinguo.foundation.statistics.h.a.B("home_page");
        }
    }

    /* compiled from: SpliceResultFragment.kt */
    /* loaded from: classes8.dex */
    public static final class c extends j1 {
        final /* synthetic */ List<ExpandShareSite> b;
        final /* synthetic */ SpliceResultFragment c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(List<ExpandShareSite> list, SpliceResultFragment spliceResultFragment) {
            super(list);
            this.b = list;
            this.c = spliceResultFragment;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void k(SpliceResultFragment this$0, ExpandShareSite expandShareSite) {
            kotlin.jvm.internal.s.h(this$0, "this$0");
            ShareSite a = expandShareSite.a();
            kotlin.jvm.internal.s.g(a, "site.shareSite");
            SpliceResult spliceResult = this$0.b;
            if (spliceResult == null) {
                kotlin.jvm.internal.s.z("result");
                throw null;
            }
            String str = spliceResult.path;
            kotlin.jvm.internal.s.g(str, "result.path");
            this$0.v0(a, str);
        }

        @Override // com.camera360.dynamic_feature_splice.j1
        protected void i(final ExpandShareSite expandShareSite) {
            if (expandShareSite == null || this.c.f2177d) {
                return;
            }
            this.c.f2178e = expandShareSite;
            FragmentActivity activity = this.c.getActivity();
            if (activity != null) {
                us.pinguo.user.util.j jVar = us.pinguo.user.util.j.a;
                final SpliceResultFragment spliceResultFragment = this.c;
                us.pinguo.user.util.j.c(jVar, activity, new Runnable() { // from class: com.camera360.dynamic_feature_splice.y0
                    @Override // java.lang.Runnable
                    public final void run() {
                        SpliceResultFragment.c.k(SpliceResultFragment.this, expandShareSite);
                    }
                }, null, null, 12, null);
            }
        }
    }

    /* compiled from: SpliceResultFragment.kt */
    /* loaded from: classes8.dex */
    public static final class d extends OperationCallback<Boolean> {
        final /* synthetic */ String a;
        final /* synthetic */ ShareSite b;
        final /* synthetic */ SpliceResultFragment c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Context f2179d;

        /* compiled from: SpliceResultFragment.kt */
        /* loaded from: classes8.dex */
        public static final class a implements PGShareListener {
            final /* synthetic */ SpliceResultFragment a;
            final /* synthetic */ ShareSite b;

            a(SpliceResultFragment spliceResultFragment, ShareSite shareSite) {
                this.a = spliceResultFragment;
                this.b = shareSite;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void d() {
                us.pinguo.foundation.utils.k0.a.a(vStudio.Android.Camera360.R.string.share_not_install_app);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void e() {
                us.pinguo.foundation.utils.k0.a.a(vStudio.Android.Camera360.R.string.share_qq_not_installed);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void f() {
                us.pinguo.foundation.utils.k0.a.a(vStudio.Android.Camera360.R.string.share_callback_msg_error);
            }

            @Override // us.pinguo.share.core.PGShareListener
            public void onShareCancel(ShareSite shareSite) {
                us.pinguo.foundation.statistics.h.a.P(this.a.m0(this.b), "interrupt");
            }

            @Override // us.pinguo.share.core.PGShareListener
            public void onShareComplete(ShareSite shareSite, boolean z) {
                us.pinguo.foundation.statistics.h.a.P(this.a.m0(this.b), FirebaseAnalytics.Param.SUCCESS);
            }

            @Override // us.pinguo.share.core.PGShareListener
            public void onShareError(ShareSite shareSite, Throwable th) {
                FragmentActivity activity;
                us.pinguo.foundation.statistics.h.a.P(this.a.m0(this.b), "fail");
                if (this.a.f2177d || (activity = this.a.getActivity()) == null) {
                    return;
                }
                if (th instanceof AppNotExistException) {
                    activity.runOnUiThread(d1.a);
                } else if (th instanceof QQClientNotExistException) {
                    activity.runOnUiThread(c1.a);
                } else {
                    activity.runOnUiThread(b1.a);
                }
            }
        }

        d(String str, ShareSite shareSite, SpliceResultFragment spliceResultFragment, Context context) {
            this.a = str;
            this.b = shareSite;
            this.c = spliceResultFragment;
            this.f2179d = context;
        }

        @Override // com.mob.OperationCallback
        public void onFailure(Throwable th) {
        }

        @Override // com.mob.OperationCallback
        public void onComplete(Boolean bool) {
            PGShareInfo pGShareInfo = new PGShareInfo();
            pGShareInfo.setImageUri(this.a);
            pGShareInfo.setTitle(us.pinguo.share.util.o.b(this.b, ShareDataType.SINGLE_PHOTO));
            pGShareInfo.setText(us.pinguo.share.util.o.a(this.b, pGShareInfo.getTitle(), null, null));
            SpliceResultFragment spliceResultFragment = this.c;
            a aVar = new a(spliceResultFragment, this.b);
            FragmentActivity activity = spliceResultFragment.getActivity();
            if (activity == null) {
                return;
            }
            us.pinguo.foundation.statistics.h.a.P(this.c.m0(this.b), "click");
            ShareSite shareSite = this.b;
            if (shareSite == ShareSite.FACEBOOK) {
                if (!us.pinguo.util.s.h("com.facebook.katana", activity)) {
                    us.pinguo.foundation.utils.k0.a.a(vStudio.Android.Camera360.R.string.not_install_app);
                } else {
                    us.pinguo.share.b.e(activity, new us.pinguo.share.util.l(pGShareInfo, this.b), aVar);
                }
            } else if (shareSite != ShareSite.QQ && shareSite != ShareSite.SINAWEIBO && shareSite != ShareSite.WECHAT_FRIENDS && shareSite != ShareSite.WECHAT_MOMENTS && (shareSite != ShareSite.DOUYIN || !pGShareInfo.hasVideo())) {
                PGShareManager.getInstance().intentShare(this.f2179d, this.b.getPackageName(), null, pGShareInfo, aVar);
            } else {
                PGShareManager.getInstance().siteShare(this.f2179d, this.b, pGShareInfo, aVar);
            }
        }
    }

    private final void initViews() {
        View view = this.c;
        if (view != null) {
            TitleBarLayout titleBarLayout = (TitleBarLayout) view.findViewById(R.id.title_bar_layout);
            titleBarLayout.setTiTleText(vStudio.Android.Camera360.R.string.splice_result_title);
            titleBarLayout.setRightImageBtnRes(vStudio.Android.Camera360.R.drawable.ic_splice_camera_home_button);
            titleBarLayout.j();
            titleBarLayout.setOnTitleBarClickListener(new b());
            List<ExpandShareSite> d2 = us.pinguo.share.util.k.d(true);
            View view2 = this.c;
            if (view2 != null) {
                RecyclerView recyclerView = (RecyclerView) view2.findViewById(R.id.rv_share_list);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext());
                linearLayoutManager.setOrientation(0);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setAdapter(new c(d2, this));
                return;
            }
            kotlin.jvm.internal.s.z("rootView");
            throw null;
        }
        kotlin.jvm.internal.s.z("rootView");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j0() {
        View view = this.c;
        if (view != null) {
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.big_layout);
            if (frameLayout.getChildCount() > 0) {
                View childAt = frameLayout.getChildAt(0);
                if (childAt instanceof LongImageView) {
                    ((LongImageView) childAt).f(new SpliceResultFragment$animHideBigLayout$1(frameLayout));
                    return;
                }
                frameLayout.removeAllViews();
                frameLayout.setVisibility(4);
                return;
            }
            return;
        }
        kotlin.jvm.internal.s.z("rootView");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k0(n1 n1Var) {
        View view = this.c;
        if (view == null) {
            kotlin.jvm.internal.s.z("rootView");
            throw null;
        }
        int i2 = R.id.big_layout;
        if (((FrameLayout) view.findViewById(i2)).getVisibility() == 0) {
            return;
        }
        View view2 = this.c;
        if (view2 != null) {
            ((FrameLayout) view2.findViewById(i2)).removeAllViews();
            Context context = getContext();
            kotlin.jvm.internal.s.e(context);
            kotlin.jvm.internal.s.g(context, "context!!");
            final LongImageView longImageView = new LongImageView(context, n1Var.a());
            View view3 = this.c;
            if (view3 != null) {
                ((FrameLayout) view3.findViewById(i2)).addView(longImageView, -1, -1);
                longImageView.o(n1Var.c());
                final Rect rect = new Rect();
                View view4 = this.c;
                if (view4 != null) {
                    ((ImageView) view4.findViewById(R.id.puzzle_img)).getGlobalVisibleRect(rect);
                    longImageView.j(new SpliceResultFragment$animShowBitLayout$2(this));
                    View view5 = this.c;
                    if (view5 != null) {
                        ((FrameLayout) view5.findViewById(i2)).setVisibility(0);
                        us.pinguo.foundation.ui.c.b(longImageView, new Runnable() { // from class: com.camera360.dynamic_feature_splice.x0
                            @Override // java.lang.Runnable
                            public final void run() {
                                SpliceResultFragment.l0(LongImageView.this, rect);
                            }
                        });
                        return;
                    }
                    kotlin.jvm.internal.s.z("rootView");
                    throw null;
                }
                kotlin.jvm.internal.s.z("rootView");
                throw null;
            }
            kotlin.jvm.internal.s.z("rootView");
            throw null;
        }
        kotlin.jvm.internal.s.z("rootView");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(LongImageView longView, Rect rect) {
        kotlin.jvm.internal.s.h(longView, "$longView");
        kotlin.jvm.internal.s.h(rect, "$rect");
        longView.g(rect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String m0(ShareSite shareSite) {
        switch (a.a[shareSite.ordinal()]) {
            case 1:
                return "facebook";
            case 2:
                return "qq_friend";
            case 3:
                return "qq_zone";
            case 4:
                return "wechat_moments";
            case 5:
                return "wechat_friend";
            case 6:
                return "douyin";
            case 7:
                return "weibo";
            case 8:
                return FindFriendHeaderCell.TWITTER;
            default:
                return "unknow";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(SpliceResultFragment this$0, ExpandShareSite site) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(site, "$site");
        ShareSite a2 = site.a();
        kotlin.jvm.internal.s.g(a2, "site.shareSite");
        SpliceResult spliceResult = this$0.b;
        if (spliceResult == null) {
            kotlin.jvm.internal.s.z("result");
            throw null;
        }
        String str = spliceResult.path;
        kotlin.jvm.internal.s.g(str, "result.path");
        this$0.v0(a2, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(View view) {
    }

    private final void s0() {
        View view = this.c;
        if (view != null) {
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.big_layout);
            if (frameLayout.getChildCount() > 0) {
                View childAt = frameLayout.getChildAt(0);
                if (childAt instanceof LongImageView) {
                    ((LongImageView) childAt).n();
                }
                frameLayout.removeAllViews();
                return;
            }
            return;
        }
        kotlin.jvm.internal.s.z("rootView");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t0(n1 n1Var) {
        StringBuilder sb = new StringBuilder();
        sb.append("time:");
        SpliceResult spliceResult = this.b;
        if (spliceResult != null) {
            sb.append(spliceResult.time);
            sb.append("\n");
            if (n1Var == null) {
                sb.append("error");
            } else {
                sb.append("size:");
                sb.append(n1Var.d().x);
                sb.append("x");
                sb.append(n1Var.d().y);
                sb.append("\n");
                sb.append("path:");
                SpliceResult spliceResult2 = this.b;
                if (spliceResult2 == null) {
                    kotlin.jvm.internal.s.z("result");
                    throw null;
                } else {
                    sb.append(spliceResult2.path);
                    sb.append("\n");
                }
            }
            us.pinguo.foundation.utils.k0 k0Var = us.pinguo.foundation.utils.k0.a;
            String sb2 = sb.toString();
            kotlin.jvm.internal.s.g(sb2, "builder.toString()");
            k0Var.e(sb2);
            return;
        }
        kotlin.jvm.internal.s.z("result");
        throw null;
    }

    private final void u0() {
        View view = this.c;
        if (view != null) {
            int i2 = R.id.puzzle_img;
            ((ImageView) view.findViewById(i2)).setVisibility(4);
            View view2 = this.c;
            if (view2 != null) {
                ((ImageView) view2.findViewById(i2)).setOnClickListener(null);
                kotlinx.coroutines.l.d(kotlinx.coroutines.n0.a(kotlinx.coroutines.z0.b()), null, null, new SpliceResultFragment$showImageInfo$1(this, null), 3, null);
                return;
            }
            kotlin.jvm.internal.s.z("rootView");
            throw null;
        }
        kotlin.jvm.internal.s.z("rootView");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v0(ShareSite shareSite, String str) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        us.pinguo.share.d.a.d(true, new d(str, shareSite, this, context));
    }

    public void _$_clearFindViewByIdCache() {
        this.a.clear();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        final ExpandShareSite expandShareSite;
        FragmentActivity activity;
        if ((i2 == 205 || i2 == 1005) && i3 == -1 && (expandShareSite = this.f2178e) != null && (activity = getActivity()) != null) {
            us.pinguo.user.util.j.c(us.pinguo.user.util.j.a, activity, new Runnable() { // from class: com.camera360.dynamic_feature_splice.v0
                @Override // java.lang.Runnable
                public final void run() {
                    SpliceResultFragment.q0(SpliceResultFragment.this, expandShareSite);
                }
            }, null, null, 12, null);
        }
    }

    public final boolean onBackPressed() {
        View view = this.c;
        if (view != null) {
            if (((FrameLayout) view.findViewById(R.id.big_layout)).getVisibility() == 0) {
                j0();
                return true;
            }
            return false;
        }
        kotlin.jvm.internal.s.z("rootView");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.s.h(inflater, "inflater");
        View inflate = inflater.inflate(vStudio.Android.Camera360.R.layout.fragment_splice_result, viewGroup, false);
        kotlin.jvm.internal.s.g(inflate, "inflater.inflate(R.layou…result, container, false)");
        this.c = inflate;
        if (inflate != null) {
            inflate.setOnClickListener(w0.a);
            initViews();
            View view = this.c;
            if (view != null) {
                return view;
            }
            kotlin.jvm.internal.s.z("rootView");
            throw null;
        }
        kotlin.jvm.internal.s.z("rootView");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        s0();
        this.f2177d = true;
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        us.pinguo.foundation.statistics.f.e("splice_succes_page", true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        us.pinguo.foundation.statistics.f.f("splice_succes_page");
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.s.h(view, "view");
        super.onViewCreated(view, bundle);
        Bundle requireArguments = requireArguments();
        kotlin.jvm.internal.s.g(requireArguments, "requireArguments()");
        Parcelable parcelable = requireArguments.getParcelable("arg_result");
        kotlin.jvm.internal.s.e(parcelable);
        kotlin.jvm.internal.s.g(parcelable, "arg.getParcelable(SpliceActivity.ARG_RESULT)!!");
        this.b = (SpliceResult) parcelable;
        u0();
        this.f2177d = false;
    }
}
