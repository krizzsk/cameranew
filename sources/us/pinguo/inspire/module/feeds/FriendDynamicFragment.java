package us.pinguo.inspire.module.feeds;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.matrix.report.Issue;
import java.util.ArrayList;
import java.util.List;
import rx.functions.Action1;
import rx.functions.Func1;
import us.pinguo.c360.i18n.R;
import us.pinguo.inspire.base.BaseAbsListFragment;
import us.pinguo.inspire.module.feeds.model.InspireFeedLoader;
import us.pinguo.inspire.module.feeds.model.InspireFollowAndLikeDetail;
import us.pinguo.inspire.widget.InspireToast;
/* loaded from: classes9.dex */
public class FriendDynamicFragment extends BaseAbsListFragment {
    private long mLastTime;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: dataToCells */
    public List<us.pinguo.widget.common.cell.recycler.b> f0(List<InspireFollowAndLikeDetail> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        for (InspireFollowAndLikeDetail inspireFollowAndLikeDetail : list) {
            if (inspireFollowAndLikeDetail != null) {
                if ("like".equals(inspireFollowAndLikeDetail.type)) {
                    arrayList.add(new FriendDynamicWorkCell(inspireFollowAndLikeDetail));
                } else if ("follow".equals(inspireFollowAndLikeDetail.type)) {
                    arrayList.add(new FriendDynamicFollowCell(inspireFollowAndLikeDetail));
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g0 */
    public /* synthetic */ void h0(List list) {
        this.mAdapter.clear();
        this.mAdapter.addAll(list);
        onRefreshComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i0 */
    public /* synthetic */ void j0(Throwable th) {
        us.pinguo.foundation.e.e(th);
        d.f.a.b.d.c(th);
        onRefreshComplete();
        InspireToast.makeText(getActivity(), R.string.network_error, 0).show();
    }

    @Override // us.pinguo.inspire.base.BaseAbsListFragment
    protected void onDataRefresh() {
        refresh();
    }

    @Override // us.pinguo.inspire.base.BaseAbsListFragment
    protected void onLoadMore() {
        us.pinguo.user.recycler.c cVar = this.mAdapter;
        if (cVar != null) {
            cVar.hideFooter();
        }
    }

    @Override // us.pinguo.inspire.base.BaseAbsListFragment, us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        setTitle(vStudio.Android.Camera360.R.string.friend_dynamic);
        View findViewById = view.findViewById(us.pinguo.user.R.id.base_title_back);
        if (findViewById != null) {
            findViewById.setVisibility(0);
        }
        this.mLastTime = getArguments().getLong(Issue.ISSUE_REPORT_TIME);
    }

    public void refresh() {
        addSubscription(InspireFeedLoader.getInstance().getFollowAndLikeDetail(this.mLastTime).map(new Func1() { // from class: us.pinguo.inspire.module.feeds.b
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                return FriendDynamicFragment.this.f0((List) obj);
            }
        }).subscribe(new Action1() { // from class: us.pinguo.inspire.module.feeds.a
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                FriendDynamicFragment.this.h0((List) obj);
            }
        }, new Action1() { // from class: us.pinguo.inspire.module.feeds.c
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                FriendDynamicFragment.this.j0((Throwable) obj);
            }
        }));
    }
}
