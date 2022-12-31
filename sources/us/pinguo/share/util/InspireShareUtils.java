package us.pinguo.share.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import cn.sharesdk.tencent.qq.QQClientNotExistException;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.tencent.connect.common.Constants;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.open.SocialConstants;
import java.util.List;
import us.pinguo.admobvista.StaticsAdv.IADStatisticBase;
import us.pinguo.inspire.module.contact.cell.FindFriendHeaderCell;
import us.pinguo.share.R;
import us.pinguo.share.c.e;
import us.pinguo.share.core.PGShareInfo;
import us.pinguo.share.core.PGShareListener;
import us.pinguo.share.core.PGShareManager;
import us.pinguo.share.core.ShareSite;
import us.pinguo.share.exception.AppNotExistException;
import us.pinguo.share.util.OnShareSiteClickListener;
/* loaded from: classes6.dex */
public class InspireShareUtils {
    public static final String CONTENT_SHARE_PANNEL_ACTION = "content_share_pannel_action";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements e.a {
        final /* synthetic */ ExpandShareSite a;
        final /* synthetic */ Activity b;
        final /* synthetic */ PGShareListener c;

        a(ExpandShareSite expandShareSite, Activity activity, PGShareListener pGShareListener) {
            this.a = expandShareSite;
            this.b = activity;
            this.c = pGShareListener;
        }

        @Override // us.pinguo.share.c.e.a
        public void a(l lVar) {
            if (this.a.a() == ShareSite.FACEBOOK) {
                us.pinguo.share.b.e(this.b, lVar, this.c);
            } else if (this.a.a() != ShareSite.SINAWEIBO && this.a.a() != ShareSite.WECHAT_FRIENDS && this.a.a() != ShareSite.WECHAT_MOMENTS && this.a.a() != ShareSite.DOUYIN) {
                if (this.a.a() == ShareSite.QQ) {
                    PGShareManager.getInstance().intentShare(this.b, this.a.a().getPackageName(), "com.tencent.mobileqq.activity.JumpActivity", InspireShareUtils.b(lVar.a()), this.c);
                    return;
                }
                PGShareManager.getInstance().intentShare(this.b, this.a.a().getPackageName(), null, InspireShareUtils.b(lVar.a()), this.c);
            } else {
                PGShareManager.getInstance().siteShare(this.b, this.a.a(), lVar.a(), this.c);
            }
        }

        @Override // us.pinguo.share.c.e.a
        public void onError(Throwable th) {
            PGShareListener pGShareListener = this.c;
            if (pGShareListener != null) {
                pGShareListener.onShareError(this.a.a(), th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b implements OnShareSiteClickListener {
        final /* synthetic */ String a;
        final /* synthetic */ FragmentActivity b;
        final /* synthetic */ PGShareListener c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ us.pinguo.share.c.e f11964d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ OnShareSiteClickListener f11965e;

        /* loaded from: classes6.dex */
        class a implements PGShareListener {
            final /* synthetic */ ExpandShareSite a;
            final /* synthetic */ DialogFragment b;

            a(ExpandShareSite expandShareSite, DialogFragment dialogFragment) {
                this.a = expandShareSite;
                this.b = dialogFragment;
            }

            @Override // us.pinguo.share.core.PGShareListener
            public void onShareCancel(ShareSite shareSite) {
                PGShareListener pGShareListener = b.this.c;
                if (pGShareListener != null) {
                    pGShareListener.onShareCancel(shareSite);
                }
                if (!b.this.a.isEmpty()) {
                    us.pinguo.foundation.statistics.h.a.k(InspireShareUtils.CONTENT_SHARE_PANNEL_ACTION, BaseShareDialog.a0(this.a.a()), b.this.a, "", "share_cancel");
                }
                us.pinguo.common.log.a.c("onShareCancel:" + shareSite, new Object[0]);
            }

            @Override // us.pinguo.share.core.PGShareListener
            public void onShareComplete(ShareSite shareSite, boolean z) {
                us.pinguo.common.log.a.c("onShareComplete:" + shareSite + ", fakeComplete" + z, new Object[0]);
                if (!b.this.a.isEmpty()) {
                    us.pinguo.foundation.statistics.h.a.k(InspireShareUtils.CONTENT_SHARE_PANNEL_ACTION, BaseShareDialog.a0(this.a.a()), b.this.a, "", "share_success");
                }
                if (!z) {
                    b.this.b.runOnUiThread(d.a);
                }
                PGShareListener pGShareListener = b.this.c;
                if (pGShareListener != null) {
                    pGShareListener.onShareComplete(shareSite, z);
                }
                DialogFragment dialogFragment = this.b;
                if (dialogFragment != null) {
                    dialogFragment.dismissAllowingStateLoss();
                }
                InspireShareUtils.g(b.this.f11964d, "share_success", shareSite);
            }

            @Override // us.pinguo.share.core.PGShareListener
            public void onShareError(ShareSite shareSite, Throwable th) {
                us.pinguo.common.log.a.e("onShareError:" + shareSite + ":" + th.toString(), new Object[0]);
                us.pinguo.foundation.e.e(th);
                if (!b.this.a.isEmpty()) {
                    us.pinguo.foundation.statistics.h.a.k(InspireShareUtils.CONTENT_SHARE_PANNEL_ACTION, BaseShareDialog.a0(this.a.a()), b.this.a, "", "share_error");
                }
                PGShareListener pGShareListener = b.this.c;
                if (pGShareListener != null) {
                    pGShareListener.onShareError(shareSite, th);
                }
                if (th instanceof AppNotExistException) {
                    b.this.b.runOnUiThread(f.a);
                } else if (th instanceof QQClientNotExistException) {
                    b.this.b.runOnUiThread(e.a);
                } else {
                    b.this.b.runOnUiThread(us.pinguo.share.util.c.a);
                }
                InspireShareUtils.g(b.this.f11964d, "share_failed", shareSite);
            }
        }

        b(String str, FragmentActivity fragmentActivity, PGShareListener pGShareListener, us.pinguo.share.c.e eVar, OnShareSiteClickListener onShareSiteClickListener) {
            this.a = str;
            this.b = fragmentActivity;
            this.c = pGShareListener;
            this.f11964d = eVar;
            this.f11965e = onShareSiteClickListener;
        }

        @Override // us.pinguo.share.util.OnShareSiteClickListener
        public void onShareOtherClick(OnShareSiteClickListener.ShareDialogContent shareDialogContent) {
            InspireShareUtils.h(this.f11964d, shareDialogContent.getContentType());
            OnShareSiteClickListener onShareSiteClickListener = this.f11965e;
            if (onShareSiteClickListener != null) {
                onShareSiteClickListener.onShareOtherClick(shareDialogContent);
            }
        }

        @Override // us.pinguo.share.util.OnShareSiteClickListener
        public void onShareSiteClick(DialogFragment dialogFragment, ExpandShareSite expandShareSite) {
            if (!this.a.isEmpty()) {
                us.pinguo.foundation.statistics.h.a.k(InspireShareUtils.CONTENT_SHARE_PANNEL_ACTION, BaseShareDialog.a0(expandShareSite.a()), this.a, "", "click");
            }
            InspireShareUtils.share(this.b, this.f11964d, expandShareSite, new a(expandShareSite, dialogFragment));
            OnShareSiteClickListener onShareSiteClickListener = this.f11965e;
            if (onShareSiteClickListener != null) {
                onShareSiteClickListener.onShareSiteClick(dialogFragment, expandShareSite);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class c {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ShareSite.values().length];
            a = iArr;
            try {
                iArr[ShareSite.WECHAT_FRIENDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ShareSite.WECHAT_MOMENTS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ShareSite.DOUYIN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ShareSite.QQ.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[ShareSite.QZONE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ShareSite.FACEBOOK.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[ShareSite.INSTAGRAM.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[ShareSite.TWITTER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[ShareSite.SINAWEIBO.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    static {
        us.pinguo.pgshare.commons.e.c(ShareSite.FACEBOOK, R.drawable.share_facebook);
        us.pinguo.pgshare.commons.e.c(ShareSite.INSTAGRAM, R.drawable.share_instagram);
        us.pinguo.pgshare.commons.e.c(ShareSite.QZONE, R.drawable.share_qzone);
        us.pinguo.pgshare.commons.e.c(ShareSite.QQ, R.drawable.share_qq_friends);
        us.pinguo.pgshare.commons.e.c(ShareSite.SINAWEIBO, R.drawable.share_sinaweibo);
        us.pinguo.pgshare.commons.e.c(ShareSite.TWITTER, R.drawable.share_twitter);
        us.pinguo.pgshare.commons.e.c(ShareSite.DOUYIN, R.drawable.share_douyin);
        us.pinguo.pgshare.commons.e.c(ShareSite.WECHAT_FRIENDS, R.drawable.share_wechat_friends);
        us.pinguo.pgshare.commons.e.c(ShareSite.WECHAT_MOMENTS, R.drawable.share_wechat_moments);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static PGShareInfo b(PGShareInfo pGShareInfo) {
        PGShareInfo pGShareInfo2 = new PGShareInfo();
        if (pGShareInfo.hasWebUrl()) {
            if (pGShareInfo.getText() != null) {
                pGShareInfo2.setText(pGShareInfo.getText() + " " + pGShareInfo.getWebUrl());
            } else if (pGShareInfo.getTitle() != null) {
                pGShareInfo2.setText(pGShareInfo.getTitle() + " " + pGShareInfo.getWebUrl());
            } else {
                pGShareInfo2.setText("");
            }
        } else {
            pGShareInfo2.setText(pGShareInfo.getText() != null ? pGShareInfo.getText() : "");
        }
        pGShareInfo2.setImageUri(pGShareInfo.getImageUri());
        pGShareInfo2.setVideoUri(pGShareInfo.getVideoUri());
        pGShareInfo2.setTitle(pGShareInfo.getTitle());
        pGShareInfo2.setThumbnailUri(pGShareInfo.getThumbnailUri());
        return pGShareInfo2;
    }

    static boolean c(us.pinguo.share.c.e eVar) {
        return us.pinguo.librouter.c.d.c().getInterface().g(eVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void d(String str, DialogInterface dialogInterface) {
        if (str.isEmpty()) {
            return;
        }
        us.pinguo.foundation.statistics.h.a.k(CONTENT_SHARE_PANNEL_ACTION, "", str, "", "close_panel");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void e(String str, DialogInterface dialogInterface) {
        if (str.isEmpty()) {
            return;
        }
        us.pinguo.foundation.statistics.h.a.k(CONTENT_SHARE_PANNEL_ACTION, "", str, "", "close_panel");
    }

    static void f(us.pinguo.share.c.e eVar) {
        boolean c2 = c(eVar);
        StringBuilder sb = new StringBuilder();
        sb.append("src=");
        sb.append(c2 ? "community" : "host");
        us.pinguo.foundation.statistics.l.onEvent(us.pinguo.foundation.e.b(), "community_sharebtn_click", sb.toString());
    }

    static void g(us.pinguo.share.c.e eVar, String str, ShareSite shareSite) {
        String str2;
        boolean c2 = c(eVar);
        switch (c.a[shareSite.ordinal()]) {
            case 1:
                str2 = ConstantsAPI.Token.WX_TOKEN_PLATFORMID_VALUE;
                break;
            case 2:
                str2 = "moment";
                break;
            case 3:
                str2 = "douyin";
                break;
            case 4:
                str2 = "qq";
                break;
            case 5:
                str2 = Constants.SOURCE_QZONE;
                break;
            case 6:
                str2 = "facebook";
                break;
            case 7:
                str2 = "ins";
                break;
            case 8:
                str2 = FindFriendHeaderCell.TWITTER;
                break;
            case 9:
                str2 = "weibo";
                break;
            default:
                str2 = IADStatisticBase.VARCHAR_DEFALUT_VALUE;
                break;
        }
        Object[] objArr = new Object[3];
        objArr[0] = c2 ? "community" : "host";
        objArr[1] = str;
        objArr[2] = str2;
        us.pinguo.foundation.statistics.l.onEvent(us.pinguo.foundation.e.b(), "community_3edparty_icon", String.format("src=%s,type=%s,channel=%s", objArr));
    }

    public static OnShareSiteClickListener getDefaultShareSiteClickListener(FragmentActivity fragmentActivity, us.pinguo.share.c.e eVar, PGShareListener pGShareListener, OnShareSiteClickListener onShareSiteClickListener, String str) {
        if (!str.isEmpty()) {
            us.pinguo.foundation.statistics.h.a.k(CONTENT_SHARE_PANNEL_ACTION, "", str, "", "panel_show");
        }
        return new b(str, fragmentActivity, pGShareListener, eVar, onShareSiteClickListener);
    }

    static void h(us.pinguo.share.c.e eVar, String str) {
        Object[] objArr = new Object[2];
        objArr[0] = c(eVar) ? "community" : "host";
        objArr[1] = str;
        us.pinguo.foundation.statistics.l.onEvent(us.pinguo.foundation.e.b(), "community_share_popup", String.format("src=%s,type=%s", objArr));
    }

    public static void share(Activity activity, us.pinguo.share.c.e eVar, ExpandShareSite expandShareSite, PGShareListener pGShareListener) {
        eVar.l(activity, expandShareSite.a(), new a(expandShareSite, activity, pGShareListener));
        g(eVar, "click", expandShareSite.a());
    }

    public static BaseShareDialog showShareDialog(FragmentActivity fragmentActivity, us.pinguo.share.c.e eVar, PGShareListener pGShareListener, OnShareSiteClickListener onShareSiteClickListener, boolean z, String str) {
        return showShareDialog(fragmentActivity, eVar, k.d(z), pGShareListener, onShareSiteClickListener, z, str);
    }

    @Keep
    public static void showShareDialogForShop(FragmentActivity fragmentActivity, p pVar, us.pinguo.pgshare.commons.f fVar, PGShareListener pGShareListener, boolean z, String str) {
        showShareDialog(fragmentActivity, new us.pinguo.share.c.f(pVar), fVar, pGShareListener, (OnShareSiteClickListener) null, z, str);
    }

    @Keep
    public static void showShareDialogForSticker(FragmentActivity fragmentActivity, p pVar, us.pinguo.pgshare.commons.f fVar, PGShareListener pGShareListener, boolean z, String str) {
        showShareStickerDialog(fragmentActivity, new us.pinguo.share.c.f(pVar), k.b(fVar), pGShareListener, pVar.f11970e, z, str);
    }

    public static void showShareDialogToSNS(FragmentActivity fragmentActivity, String str, boolean z, boolean z2, String str2) {
        showShareDialogToSNS(z ? 2 : 1, str, (String) null, fragmentActivity, z2, str2);
    }

    public static InspirePublishDialog showShareDialogWithPictureParamToSNS(int i2, int i3, String str, String str2, Context context, String str3, boolean z, String str4, OnShareSiteClickListener onShareSiteClickListener) {
        if (!(context instanceof FragmentActivity)) {
            if (!us.pinguo.foundation.d.f10985d) {
                us.pinguo.common.log.a.e("activityContext:" + context + " isn't FragmentActivity", new Object[0]);
                return null;
            }
            throw new RuntimeException("测试环境");
        }
        List<ExpandShareSite> a2 = k.a(z);
        us.pinguo.share.c.e eVar = (us.pinguo.share.c.e) us.pinguo.librouter.c.d.c().getInterface().e(str, i3 == 2);
        return showShareDialogToSNS(context, i2, i3, str, a2, eVar, getDefaultShareSiteClickListener((FragmentActivity) context, eVar, null, onShareSiteClickListener, str4), str4);
    }

    public static void showShareStickerDialog(FragmentActivity fragmentActivity, us.pinguo.share.c.e eVar, List<ExpandShareSite> list, PGShareListener pGShareListener, String str, boolean z, String str2) {
        StickerShareDialog stickerShareDialog = new StickerShareDialog();
        Bundle bundle = new Bundle();
        eVar.n(list);
        k.e(bundle, list);
        if (!TextUtils.isEmpty(str)) {
            bundle.putString(SocialConstants.PARAM_IMG_URL, str);
        }
        stickerShareDialog.setArguments(bundle);
        stickerShareDialog.c0(getDefaultShareSiteClickListener(fragmentActivity, eVar, pGShareListener, null, str2));
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        stickerShareDialog.show(supportFragmentManager, "publish");
        VdsAgent.showDialogFragment(stickerShareDialog, supportFragmentManager, "publish");
        f(eVar);
        h(eVar, "view");
    }

    public static void showShareDialog(FragmentActivity fragmentActivity, us.pinguo.share.c.e eVar, us.pinguo.pgshare.commons.f fVar, PGShareListener pGShareListener, OnShareSiteClickListener onShareSiteClickListener, boolean z, String str) {
        showShareDialog(fragmentActivity, eVar, k.b(fVar), pGShareListener, onShareSiteClickListener, z, str);
    }

    public static void showShareDialogToSNS(FragmentActivity fragmentActivity, String str, boolean z, boolean z2, String str2, OnShareSiteClickListener onShareSiteClickListener) {
        int i2 = z ? 2 : 1;
        showShareDialogWithPictureParamToSNS(i2, i2, str, (String) null, fragmentActivity, (String) null, z2, str2, onShareSiteClickListener);
    }

    public static BaseShareDialog showShareDialog(FragmentActivity fragmentActivity, us.pinguo.share.c.e eVar, List<ExpandShareSite> list, PGShareListener pGShareListener, OnShareSiteClickListener onShareSiteClickListener, boolean z, final String str) {
        BaseShareDialog baseShareDialog = new BaseShareDialog();
        Bundle bundle = new Bundle();
        eVar.n(list);
        k.e(bundle, list);
        baseShareDialog.setArguments(bundle);
        baseShareDialog.i0(getDefaultShareSiteClickListener(fragmentActivity, eVar, pGShareListener, onShareSiteClickListener, str));
        baseShareDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: us.pinguo.share.util.g
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                InspireShareUtils.d(str, dialogInterface);
            }
        });
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        baseShareDialog.show(supportFragmentManager, "publish");
        VdsAgent.showDialogFragment(baseShareDialog, supportFragmentManager, "publish");
        f(eVar);
        h(eVar, "view");
        return baseShareDialog;
    }

    public static InspirePublishDialog showShareDialogToSNS(int i2, String str, String str2, Context context, boolean z, String str3) {
        return showShareDialogWithPictureParamToSNS(i2, i2, str, str2, context, (String) null, z, str3, (OnShareSiteClickListener) null);
    }

    public static InspirePublishDialog showShareDialogToSNS(Context context, int i2, int i3, String str, List<ExpandShareSite> list, us.pinguo.share.c.e eVar, OnShareSiteClickListener onShareSiteClickListener, final String str2) {
        InspirePublishDialog inspirePublishDialog = new InspirePublishDialog();
        Bundle bundle = new Bundle();
        bundle.putString("key_bmpPath", str);
        bundle.putInt("key_type", i3);
        bundle.putInt("key_entranceType", i2);
        inspirePublishDialog.setArguments(bundle);
        if (context instanceof FragmentActivity) {
            eVar.n(list);
            k.e(bundle, list);
            int size = list.size();
            if (size == 0) {
                return null;
            }
            if (size == 1) {
                onShareSiteClickListener.onShareSiteClick(null, list.get(0));
                return null;
            }
            inspirePublishDialog.i0(onShareSiteClickListener);
            inspirePublishDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: us.pinguo.share.util.h
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    InspireShareUtils.e(str2, dialogInterface);
                }
            });
            FragmentManager supportFragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
            inspirePublishDialog.show(supportFragmentManager, "publish");
            VdsAgent.showDialogFragment(inspirePublishDialog, supportFragmentManager, "publish");
            f(eVar);
            h(eVar, "view");
            return inspirePublishDialog;
        } else if (us.pinguo.foundation.d.f10985d) {
            throw new RuntimeException("测试环境");
        } else {
            return inspirePublishDialog;
        }
    }

    public static InspirePublishDialog showShareDialogWithPictureParamToSNS(int i2, int i3, String str, String str2, Context context, String str3, OnShareSiteClickListener onShareSiteClickListener, boolean z, String str4) {
        if (!(context instanceof FragmentActivity)) {
            if (!us.pinguo.foundation.d.f10985d) {
                us.pinguo.common.log.a.e("activityContext:" + context + " isn't FragmentActivity", new Object[0]);
                return null;
            }
            throw new RuntimeException("测试环境");
        }
        List<ExpandShareSite> a2 = k.a(z);
        us.pinguo.share.c.e eVar = (us.pinguo.share.c.e) us.pinguo.librouter.c.d.c().getInterface().e(str, i3 == 2);
        return showShareDialogToSNS(context, i2, i3, str, a2, eVar, getDefaultShareSiteClickListener((FragmentActivity) context, eVar, null, onShareSiteClickListener, str4), str4);
    }
}
