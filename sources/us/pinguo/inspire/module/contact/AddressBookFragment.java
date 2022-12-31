package us.pinguo.inspire.module.contact;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import rx.functions.Action1;
import us.pinguo.inspire.PhoneBindActivity;
import us.pinguo.inspire.base.BaseAbsListFragment;
import us.pinguo.inspire.module.comment.InspireUser;
import us.pinguo.inspire.module.contact.cell.AddressBookHeaderCell;
import us.pinguo.inspire.module.contact.cell.AddressBookItemCell;
import us.pinguo.inspire.module.contact.cell.FindFriendHeaderCell;
import us.pinguo.inspire.module.contact.cell.ThirdSiteItemCell;
import us.pinguo.inspire.module.contact.entry.AddressBookFriend;
import us.pinguo.inspire.module.contact.entry.ThirdSiteFriend;
import us.pinguo.user.ui.view.CompatibleToolbar;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class AddressBookFragment extends BaseAbsListFragment implements AddressBookHeaderCell.OnBindListener {
    private boolean mIsThirdSite = false;
    private String mSiteName;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e0 */
    public /* synthetic */ void f0(List list) {
        us.pinguo.common.log.a.m("zhouwei", "size:" + list.size(), new Object[0]);
        refreshCells(getAddressBookFriendCell(list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g0 */
    public /* synthetic */ void h0(Throwable th) {
        us.pinguo.foundation.e.e(th);
        us.pinguo.common.log.a.g("zhouwei", th.getMessage(), new Object[0]);
        this.mRefreshLayout.setRefreshing(false);
        if (this.mAdapter.getCells() != null && !this.mAdapter.getCells().isEmpty() && (this.mAdapter.getCells().get(0) instanceof AddressBookHeaderCell)) {
            this.mAdapter.showError(1);
        } else {
            this.mAdapter.showError();
        }
    }

    private List<us.pinguo.widget.common.cell.recycler.b> getAddressBookFriendCell(List<AddressBookFriend> list) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(getHeaderCell());
        if (list != null && list.size() > 0) {
            for (AddressBookFriend addressBookFriend : list) {
                arrayList.add(new AddressBookItemCell(addressBookFriend));
            }
        }
        return arrayList;
    }

    private AddressBookHeaderCell getHeaderCell() {
        AddressBookHeaderCell addressBookHeaderCell = new AddressBookHeaderCell("");
        addressBookHeaderCell.setOnBindListener(this);
        return addressBookHeaderCell;
    }

    private List<ThirdSiteFriend> getList() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 10; i2++) {
            ThirdSiteFriend thirdSiteFriend = new ThirdSiteFriend();
            thirdSiteFriend.tName = "周为";
            thirdSiteFriend.tAvatar = "http://phototask.c360dn.com/Fs6oovveHpl8PETroETyAcbDQslN";
            InspireUser inspireUser = new InspireUser();
            inspireUser.nickname = "Mr.周先森";
            inspireUser.avatar = "http://phototask.c360dn.com/Fs6oovveHpl8PETroETyAcbDQslN";
            if (i2 % 2 == 0) {
                inspireUser.relation = 1;
            } else {
                inspireUser.relation = 0;
            }
            thirdSiteFriend.user = inspireUser;
            arrayList.add(thirdSiteFriend);
        }
        return arrayList;
    }

    private List<us.pinguo.widget.common.cell.recycler.b> getThirdFirendCell(List<ThirdSiteFriend> list, String str) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (ThirdSiteFriend thirdSiteFriend : list) {
                ThirdSiteItemCell thirdSiteItemCell = new ThirdSiteItemCell(thirdSiteFriend);
                thirdSiteItemCell.setSiteName(str);
                arrayList.add(thirdSiteItemCell);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i0 */
    public /* synthetic */ void j0(String str, List list) {
        us.pinguo.common.log.a.m("zhouwei", "third site friends size:" + list.size(), new Object[0]);
        refreshCells(getThirdFirendCell(list, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k0 */
    public /* synthetic */ void l0(Throwable th) {
        us.pinguo.common.log.a.f(th);
        us.pinguo.foundation.e.e(th);
        this.mRefreshLayout.setRefreshing(false);
        if (this.mAdapter.getCells() != null && !this.mAdapter.getCells().isEmpty() && (this.mAdapter.getCells().get(0) instanceof AddressBookHeaderCell)) {
            this.mAdapter.showError(1);
        } else {
            this.mAdapter.showError();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m0 */
    public /* synthetic */ void n0(View view) {
        us.pinguo.foundation.r.d.a().b(new us.pinguo.inspire.event.d(((AddressBookActivity) getActivity()).getIsAddressBook()));
        getActivity().finish();
    }

    private void refreshCells(List<us.pinguo.widget.common.cell.recycler.b> list) {
        this.mAdapter.beginChange();
        this.mAdapter.hideLoading();
        if (list != null && !list.isEmpty()) {
            this.mAdapter.set(list);
        } else {
            us.pinguo.inspire.base.c.b(this.mAdapter);
        }
        this.mAdapter.endChange(false);
        this.mAdapter.notifyDataSetChanged();
    }

    public void fetchAddressBookFriend() {
        addSubscription(new ContactLoader().fetchAddressBookFriends().subscribe(new Action1() { // from class: us.pinguo.inspire.module.contact.c
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                AddressBookFragment.this.f0((List) obj);
            }
        }, new Action1() { // from class: us.pinguo.inspire.module.contact.d
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                AddressBookFragment.this.h0((Throwable) obj);
            }
        }));
    }

    public void fetchThirdSiteFriendList(final String str) {
        addSubscription(new ContactLoader().fetchThirdFirendList(str).subscribe(new Action1() { // from class: us.pinguo.inspire.module.contact.a
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                AddressBookFragment.this.j0(str, (List) obj);
            }
        }, new Action1() { // from class: us.pinguo.inspire.module.contact.b
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                AddressBookFragment.this.l0((Throwable) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.BaseAbsListFragment
    public void initRecycleView(RecyclerView recyclerView, us.pinguo.widget.common.cell.recycler.a aVar) {
        super.initRecycleView(recyclerView, aVar);
        replaceTitle(null);
        setLoadMoreEnabled(false);
        setPullToRefreshEnabled(false);
        this.mAdapter.showLoading();
        if (this.mIsThirdSite) {
            fetchThirdSiteFriendList(this.mSiteName);
        } else {
            fetchAddressBookFriend();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        AddressBookHeaderCell addressBookHeaderCell;
        us.pinguo.common.log.a.m("zhouwei", "AddressBookFragment onActivityResult........", new Object[0]);
        us.pinguo.user.recycler.c cVar = this.mAdapter;
        if (cVar == null || !(cVar.getItem(0) instanceof AddressBookHeaderCell) || (addressBookHeaderCell = (AddressBookHeaderCell) this.mAdapter.getItem(0)) == null) {
            return;
        }
        addressBookHeaderCell.updateBind();
    }

    @Override // us.pinguo.inspire.module.contact.cell.AddressBookHeaderCell.OnBindListener
    public void onBind() {
        startActivityForResult(new Intent(getActivity(), PhoneBindActivity.class), 1);
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getActivity().getIntent().hasExtra("siteName")) {
            this.mSiteName = getActivity().getIntent().getStringExtra("siteName");
        }
        if (!TextUtils.isEmpty(this.mSiteName)) {
            this.mIsThirdSite = true;
        } else {
            this.mIsThirdSite = false;
        }
    }

    @Override // us.pinguo.inspire.base.BaseAbsListFragment
    protected void onDataRefresh() {
    }

    @Override // us.pinguo.inspire.base.BaseAbsListFragment
    protected void onLoadMore() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.BaseAbsListFragment
    public void replaceTitle(View view) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.public_toolbar_layout, (ViewGroup) null);
        CompatibleToolbar compatibleToolbar = (CompatibleToolbar) inflate.findViewById(R.id.public_toolbar);
        compatibleToolbar.setNavigationIcon(us.pinguo.ui.R.drawable.navigation_back_black);
        compatibleToolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.module.contact.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AddressBookFragment.this.n0(view2);
            }
        });
        compatibleToolbar.setTitleTextAppearance(getActivity(), us.pinguo.user.R.style.ToolBar_TextSize);
        if (this.mIsThirdSite) {
            if (this.mSiteName.equals("sina")) {
                compatibleToolbar.setTitle(R.string.weibo_friend);
            } else if (this.mSiteName.equals("facebook")) {
                compatibleToolbar.setTitle(R.string.facebook_friend);
            } else if (this.mSiteName.equals(FindFriendHeaderCell.TWITTER)) {
                compatibleToolbar.setTitle(R.string.titter_friend);
            }
        } else {
            compatibleToolbar.setTitle(R.string.address_book);
        }
        super.replaceTitle(inflate);
    }

    @Override // us.pinguo.inspire.base.BaseAbsListFragment
    protected void triggerFirstRefresh(View view) {
    }
}
