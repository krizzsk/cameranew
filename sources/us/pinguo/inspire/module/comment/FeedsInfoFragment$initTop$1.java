package us.pinguo.inspire.module.comment;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView;
import androidx.fragment.app.FragmentActivity;
import java.util.Objects;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.inspire.module.comment.cell.ContentInfoCell;
import us.pinguo.inspire.module.comment.widget.OnInfoTopClickListener;
import us.pinguo.inspire.module.discovery.entity.dicovery.AuthorInfo;
import us.pinguo.inspire.widget.menu.InspirePopupMenu;
import vStudio.Android.Camera360.R;
/* compiled from: FeedsInfoFragment.kt */
/* loaded from: classes9.dex */
public final class FeedsInfoFragment$initTop$1 implements OnInfoTopClickListener {
    final /* synthetic */ FeedsInfoFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FeedsInfoFragment$initTop$1(FeedsInfoFragment feedsInfoFragment) {
        this.this$0 = feedsInfoFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onMoreClick$lambda-0  reason: not valid java name */
    public static final void m145onMoreClick$lambda0(boolean z, FeedsInfoFragment this$0, boolean z2, InspirePopupMenu popupMenu, AdapterView adapterView, View view, int i2, long j2) {
        FeedsInfoPresenter mPresenter;
        InspireWork.TaskInfo taskInfo;
        String str;
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(popupMenu, "$popupMenu");
        if (z) {
            i2--;
        }
        if (i2 != -1 && !us.pinguo.user.s0.getInstance().e()) {
            us.pinguo.user.s0.getInstance().a(this$0.getActivity(), 1, us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER);
            return;
        }
        InspireWork currentWork = this$0.getCurrentWork();
        if (currentWork == null) {
            return;
        }
        if (i2 == -1) {
            this$0.shareWithCheck();
        } else if (i2 != 0) {
            if (i2 == 1) {
                InspireWork currentWork2 = this$0.getCurrentWork();
                if (currentWork2 != null && (mPresenter = this$0.getMPresenter()) != null) {
                    mPresenter.cancelRec(currentWork2);
                }
            } else if (i2 == 2) {
                Object systemService = us.pinguo.foundation.e.b().getSystemService("clipboard");
                Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
                ClipboardManager clipboardManager = (ClipboardManager) systemService;
                InspireWork currentWork3 = this$0.getCurrentWork();
                String str2 = "NULL";
                if (currentWork3 != null && (taskInfo = currentWork3.taskInfo) != null && (str = taskInfo.taskId) != null) {
                    str2 = str;
                }
                clipboardManager.setPrimaryClip(ClipData.newPlainText("taskId", str2));
                us.pinguo.foundation.utils.j0.d("已复制到剪切板");
            }
        } else if (z2) {
            FeedsInfoPresenter mPresenter2 = this$0.getMPresenter();
            if (mPresenter2 != null) {
                mPresenter2.delete("", currentWork.workId, currentWork.authorId);
            }
        } else {
            FeedsInfoPresenter mPresenter3 = this$0.getMPresenter();
            if (mPresenter3 != null) {
                mPresenter3.report(currentWork.workId, currentWork.authorId);
            }
        }
        popupMenu.a();
    }

    @Override // us.pinguo.inspire.module.comment.widget.OnInfoTopClickListener
    public void onCloseClick() {
        if (this.this$0.getActivity() instanceof FeedsInfoActivity) {
            FragmentActivity activity = this.this$0.getActivity();
            Objects.requireNonNull(activity, "null cannot be cast to non-null type us.pinguo.inspire.module.comment.FeedsInfoActivity");
            ((FeedsInfoActivity) activity).onBackPressed();
        }
    }

    @Override // us.pinguo.inspire.module.comment.widget.OnInfoTopClickListener
    public void onMoreClick(View v) {
        boolean z;
        String[] strArr;
        OtherInfo otherInfo;
        String bucketName;
        InspireWork.TaskInfo taskInfo;
        String str;
        OtherInfo otherInfo2;
        String bucketName2;
        InspireWork.TaskInfo taskInfo2;
        String str2;
        AuthorInfo authorInfo;
        kotlin.jvm.internal.s.h(v, "v");
        String userId = us.pinguo.user.s0.getInstance().getUserId();
        InspireWork currentWork = this.this$0.getCurrentWork();
        String str3 = currentWork == null ? null : currentWork.authorId;
        if (str3 == null) {
            InspireWork currentWork2 = this.this$0.getCurrentWork();
            str3 = (currentWork2 == null || (authorInfo = currentWork2.authorInfo) == null) ? null : authorInfo.userId;
        }
        final boolean c = kotlin.jvm.internal.s.c(userId, str3);
        Resources resources = v.getResources();
        final boolean z2 = this.this$0.getCurrentCell() instanceof ContentInfoCell;
        z = this.this$0.isAdmin;
        int i2 = R.string.report;
        if (z) {
            String str4 = "NULL";
            if (z2) {
                strArr = new String[5];
                String string = resources.getString(R.string.msg_share);
                kotlin.jvm.internal.s.g(string, "res.getString(R.string.msg_share)");
                strArr[0] = string;
                if (c) {
                    i2 = us.pinguo.c360.i18n.R.string.delete;
                }
                String string2 = resources.getString(i2);
                kotlin.jvm.internal.s.g(string2, "res.getString(if (isMine…re_proxy.R.string.report)");
                strArr[1] = string2;
                strArr[2] = "取消推荐";
                InspireWork currentWork3 = this.this$0.getCurrentWork();
                if (currentWork3 == null || (otherInfo2 = currentWork3.otherInfo) == null || (bucketName2 = otherInfo2.getBucketName()) == null) {
                    bucketName2 = "NULL";
                }
                strArr[3] = bucketName2;
                InspireWork currentWork4 = this.this$0.getCurrentWork();
                if (currentWork4 != null && (taskInfo2 = currentWork4.taskInfo) != null && (str2 = taskInfo2.taskId) != null) {
                    str4 = str2;
                }
                strArr[4] = str4;
            } else {
                strArr = new String[4];
                if (c) {
                    i2 = us.pinguo.c360.i18n.R.string.delete;
                }
                String string3 = resources.getString(i2);
                kotlin.jvm.internal.s.g(string3, "res.getString(if (isMine…re_proxy.R.string.report)");
                strArr[0] = string3;
                strArr[1] = "取消推荐";
                InspireWork currentWork5 = this.this$0.getCurrentWork();
                if (currentWork5 == null || (otherInfo = currentWork5.otherInfo) == null || (bucketName = otherInfo.getBucketName()) == null) {
                    bucketName = "NULL";
                }
                strArr[2] = bucketName;
                InspireWork currentWork6 = this.this$0.getCurrentWork();
                if (currentWork6 != null && (taskInfo = currentWork6.taskInfo) != null && (str = taskInfo.taskId) != null) {
                    str4 = str;
                }
                strArr[3] = str4;
            }
        } else if (z2) {
            strArr = new String[2];
            String string4 = resources.getString(R.string.msg_share);
            kotlin.jvm.internal.s.g(string4, "res.getString(R.string.msg_share)");
            strArr[0] = string4;
            if (c) {
                i2 = us.pinguo.c360.i18n.R.string.delete;
            }
            String string5 = resources.getString(i2);
            kotlin.jvm.internal.s.g(string5, "res.getString(if (isMine…re_proxy.R.string.report)");
            strArr[1] = string5;
        } else {
            strArr = new String[1];
            if (c) {
                i2 = us.pinguo.c360.i18n.R.string.delete;
            }
            String string6 = resources.getString(i2);
            kotlin.jvm.internal.s.g(string6, "res.getString(if (isMine…re_proxy.R.string.report)");
            strArr[0] = string6;
        }
        final InspirePopupMenu inspirePopupMenu = new InspirePopupMenu(this.this$0.getContext());
        inspirePopupMenu.c(us.pinguo.foundation.t.b.a.a(this.this$0.getContext(), 170.0f));
        inspirePopupMenu.b(strArr);
        final FeedsInfoFragment feedsInfoFragment = this.this$0;
        inspirePopupMenu.d(new AdapterView.OnItemClickListener() { // from class: us.pinguo.inspire.module.comment.t
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i3, long j2) {
                FeedsInfoFragment$initTop$1.m145onMoreClick$lambda0(z2, feedsInfoFragment, c, inspirePopupMenu, adapterView, view, i3, j2);
            }
        });
        inspirePopupMenu.e(v, 0, us.pinguo.foundation.t.b.a.a(this.this$0.getContext(), 8.0f));
        us.pinguo.foundation.statistics.c cVar = us.pinguo.foundation.statistics.h.a;
        String element_id = FeedsInfoFragment.Companion.getElement_id();
        InspireWork currentWork7 = this.this$0.getCurrentWork();
        cVar.M(element_id, "more", "", currentWork7 == null ? null : currentWork7.workId, "click");
    }
}
