package us.pinguo.inspire.module.contact;

import android.content.Intent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.base.BaseAbsListFragment;
import us.pinguo.inspire.module.contact.cell.FindFriendHeaderCell;
import us.pinguo.inspire.module.contact.cell.FindFriendItemCell;
import us.pinguo.inspire.module.contact.cell.RecommendHeaderCell;
import us.pinguo.inspire.module.contact.entry.HotUserEntry;
import us.pinguo.inspire.module.contact.entry.Recommend;
import us.pinguo.inspire.module.contact.entry.ThirdSitePlatformFactory;
import us.pinguo.inspire.module.contact.entry.ThirdSiteRedDot;
import us.pinguo.inspire.module.contact.entry.TokenAccess;
/* loaded from: classes9.dex */
public class FindFriendFragment extends BaseAbsListFragment implements IContactView, FindFriendHeaderCell.ThirdSiteItemOnClickListener {
    private ContactPresenter mContactPresenter;
    private ThirdSiteRedDot mThirdSiteRedDot;
    private int mAddressFriendCount = 0;
    private int returnCount = 0;

    private List<us.pinguo.widget.common.cell.recycler.b> getCell(int i2, ThirdSiteRedDot thirdSiteRedDot) {
        ArrayList arrayList = new ArrayList();
        FindFriendHeaderCell findFriendHeaderCell = new FindFriendHeaderCell("");
        findFriendHeaderCell.setAddressBookFriendCount(i2);
        findFriendHeaderCell.setThirdSiteFriendCount(thirdSiteRedDot);
        findFriendHeaderCell.setOnThirdSiteItemOnClickListener(this);
        arrayList.add(findFriendHeaderCell);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static FindFriendFragment getInstance() {
        return new FindFriendFragment();
    }

    private List<us.pinguo.widget.common.cell.recycler.b> getRecommedCells(List<Recommend> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                arrayList.add(new FindFriendItemCell(list.get(i2)));
            }
        }
        return arrayList;
    }

    private void intentToFriendsListPage(String str, String str2) {
        Intent intent = new Intent(getActivity(), AddressBookActivity.class);
        intent.putExtra("siteName", str);
        intent.putExtra(AddressBookActivity.FLAG_KEY, 1);
        getActivity().startActivity(intent);
    }

    private void launchThirdSiteAuthorize(final String str) {
        Platform wechat;
        if ("sina".equals(str)) {
            wechat = ThirdSitePlatformFactory.getSinaWeibo();
        } else {
            wechat = ConstantsAPI.Token.WX_TOKEN_PLATFORMID_VALUE.equals(str) ? ThirdSitePlatformFactory.getWechat() : null;
        }
        if (wechat != null) {
            if (wechat.isAuthValid()) {
                wechat.removeAccount(true);
            }
            wechat.SSOSetting(false);
            wechat.setPlatformActionListener(new PlatformActionListener() { // from class: us.pinguo.inspire.module.contact.FindFriendFragment.1
                @Override // cn.sharesdk.framework.PlatformActionListener
                public void onCancel(Platform platform, int i2) {
                    us.pinguo.common.log.a.c("onLoginCancel:" + platform.getName(), new Object[0]);
                }

                @Override // cn.sharesdk.framework.PlatformActionListener
                public void onComplete(Platform platform, int i2, HashMap<String, Object> hashMap) {
                    us.pinguo.common.log.a.c("onLoginComplete:" + platform.getName(), new Object[0]);
                    PlatformDb db = platform.getDb();
                    String token = db.getToken();
                    String userId = db.getUserId();
                    String tokenSecret = db.getTokenSecret();
                    long expiresIn = db.getExpiresIn();
                    us.pinguo.common.log.a.m("zhouwei", "token:" + token + "tokenSecret:" + tokenSecret + " uId:" + userId + " expireIn:" + expiresIn, new Object[0]);
                    TokenAccess.saveToken(new TokenAccess(token, expiresIn, str));
                    FindFriendFragment.this.mContactPresenter.bindThirdSite(userId, token, str, expiresIn, tokenSecret);
                }

                @Override // cn.sharesdk.framework.PlatformActionListener
                public void onError(Platform platform, int i2, Throwable th) {
                    us.pinguo.common.log.a.e("onLoginError:" + platform.getName() + th.toString(), new Object[0]);
                }
            });
            wechat.authorize();
        }
    }

    private void updateCell(int i2, ThirdSiteRedDot thirdSiteRedDot) {
        us.pinguo.common.log.a.d("zhouwei", "update cell................", new Object[0]);
        FindFriendHeaderCell findFriendHeaderCell = (FindFriendHeaderCell) this.mAdapter.getItem(0);
        if (findFriendHeaderCell != null) {
            findFriendHeaderCell.updateCell(i2, thirdSiteRedDot);
        }
    }

    @Override // us.pinguo.inspire.module.contact.IContactView
    public void appendRecommend(List<Recommend> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.mAdapter.addAll(getRecommedCells(list));
    }

    @Override // us.pinguo.foundation.base.BaseFragment
    protected String getPageId() {
        return "Community_AddFriends_Page";
    }

    @Override // us.pinguo.inspire.module.contact.IContactView
    public void hideLoadMore() {
        this.mAdapter.hideFooter();
    }

    @Override // us.pinguo.inspire.module.contact.IContactView
    public void hideLoading() {
        this.mAdapter.hideLoading();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.BaseAbsListFragment
    public void initRecycleView(RecyclerView recyclerView, us.pinguo.widget.common.cell.recycler.a aVar) {
        super.initRecycleView(recyclerView, aVar);
        replaceTitle(null);
        aVar.set(getCell(this.mAddressFriendCount, this.mThirdSiteRedDot));
        setPullToRefreshEnabled(false);
        recyclerView.addItemDecoration(new us.pinguo.inspire.cell.recycler.c(Inspire.a(), us.pinguo.foundation.t.b.a.a(getContext(), 5.0f), 3, false));
        ContactPresenter contactPresenter = new ContactPresenter();
        this.mContactPresenter = contactPresenter;
        contactPresenter.attachView(this);
    }

    @Override // us.pinguo.inspire.module.contact.IContactView
    public void notifyData(List<HotUserEntry> list) {
    }

    @Override // us.pinguo.inspire.module.contact.IContactView
    public void onBindThirdSiteSuccess(String str, String str2) {
        intentToFriendsListPage(str, str2);
    }

    @Override // us.pinguo.inspire.base.BaseAbsListFragment
    protected void onDataRefresh() {
    }

    @Override // us.pinguo.inspire.base.BaseAbsListFragment, us.pinguo.foundation.base.SubscriptionFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        ContactPresenter contactPresenter = this.mContactPresenter;
        if (contactPresenter != null) {
            contactPresenter.detachView();
        }
    }

    @Override // us.pinguo.inspire.base.BaseAbsListFragment
    protected void onLoadMore() {
        this.mContactPresenter.loadMoreRecommed();
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // us.pinguo.inspire.module.contact.cell.FindFriendHeaderCell.ThirdSiteItemOnClickListener
    public void onThirdSiteItemOnClick(View view) {
        String str = (String) view.getTag();
        if (!TokenAccess.isTokenValide(str)) {
            try {
                launchThirdSiteAuthorize(str);
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        intentToFriendsListPage(str, "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.BaseAbsListFragment
    public void replaceTitle(View view) {
        super.replaceTitle(null);
    }

    @Override // us.pinguo.inspire.module.contact.IContactView
    public void setRecommend(List<Recommend> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        List<us.pinguo.widget.common.cell.recycler.b> cell = getCell(this.mAddressFriendCount, this.mThirdSiteRedDot);
        if (cell != null) {
            cell.add(new RecommendHeaderCell(null));
            cell.addAll(getRecommedCells(list));
        }
        this.mAdapter.set(cell);
    }

    @Override // us.pinguo.inspire.module.contact.IContactView
    public void setRedDotCount(int i2) {
        this.mAddressFriendCount = i2;
        int i3 = this.returnCount + 1;
        this.returnCount = i3;
        if (i3 >= 2) {
            i2 = 0;
        }
        updateCell(i2, this.mThirdSiteRedDot);
    }

    @Override // us.pinguo.inspire.module.contact.IContactView
    public void setThirdSiteFriendCount(ThirdSiteRedDot thirdSiteRedDot) {
        this.mThirdSiteRedDot = thirdSiteRedDot;
        updateCell(this.mAddressFriendCount, thirdSiteRedDot);
    }

    @Override // us.pinguo.inspire.module.contact.IContactView
    public void showLoadingKeepHeader() {
        this.mAdapter.showLoading(1);
    }

    @Override // us.pinguo.inspire.base.BaseAbsListFragment
    protected void triggerFirstRefresh(View view) {
    }
}
