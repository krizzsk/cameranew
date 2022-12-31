package us.pinguo.inspire.module.contact.cell;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import us.pinguo.foundation.ui.view.CommonItemView;
import us.pinguo.inspire.Conditions;
import us.pinguo.inspire.module.contact.AddressBookActivity;
import us.pinguo.inspire.module.contact.entry.ThirdSiteRedDot;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class FindFriendHeaderCell extends us.pinguo.widget.common.cell.recycler.b {
    public static final String FACEBOOK = "facebook";
    public static final String SINA = "sina";
    public static final String TWITTER = "twitter";
    private int mAddressBookFriendCount;
    private FindFriendHeaderHolder mFindFriendHeaderHolder;
    private ThirdSiteRedDot mThirdSiteRedDot;
    private ThirdSiteItemOnClickListener onThirdSiteItemOnClickListener;

    /* loaded from: classes9.dex */
    public static class FindFriendHeaderHolder extends us.pinguo.widget.common.cell.recycler.c {
        public CommonItemView addressBookView;
        public CommonItemView facebookView;
        public CommonItemView twitterView;
        public CommonItemView weiboView;

        public FindFriendHeaderHolder(View view) {
            super(view);
            this.addressBookView = (CommonItemView) view.findViewById(R.id.address_book_view);
            this.weiboView = (CommonItemView) view.findViewById(R.id.address_weibo_view);
            this.facebookView = (CommonItemView) view.findViewById(R.id.address_facebook_view);
            this.twitterView = (CommonItemView) view.findViewById(R.id.address_twitter_view);
        }
    }

    /* loaded from: classes9.dex */
    public interface ThirdSiteItemOnClickListener {
        void onThirdSiteItemOnClick(View view);
    }

    public FindFriendHeaderCell(String str) {
        super(str);
        this.mAddressBookFriendCount = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(View view) {
        Intent intent = new Intent(view.getContext(), AddressBookActivity.class);
        intent.putExtra(AddressBookActivity.FLAG_KEY, 0);
        view.getContext().startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void c(View view) {
        if (this.onThirdSiteItemOnClickListener != null) {
            view.setTag("sina");
            this.onThirdSiteItemOnClickListener.onThirdSiteItemOnClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void e(View view) {
        if (this.onThirdSiteItemOnClickListener != null) {
            view.setTag("facebook");
            this.onThirdSiteItemOnClickListener.onThirdSiteItemOnClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public /* synthetic */ void g(View view) {
        if (this.onThirdSiteItemOnClickListener != null) {
            view.setTag(TWITTER);
            this.onThirdSiteItemOnClickListener.onThirdSiteItemOnClick(view);
        }
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public us.pinguo.widget.common.cell.recycler.c createViewHolder(ViewGroup viewGroup) {
        return new FindFriendHeaderHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.find_friend_header_layout, (ViewGroup) null));
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return 0;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    protected void onBindViewHolder(us.pinguo.widget.common.cell.recycler.c cVar) {
        FindFriendHeaderHolder findFriendHeaderHolder = (FindFriendHeaderHolder) cVar;
        this.mFindFriendHeaderHolder = findFriendHeaderHolder;
        findFriendHeaderHolder.addressBookView.setRightCount(this.mAddressBookFriendCount, true);
        ThirdSiteRedDot thirdSiteRedDot = this.mThirdSiteRedDot;
        if (thirdSiteRedDot != null) {
            findFriendHeaderHolder.weiboView.setRightCount(thirdSiteRedDot.sina, true);
            findFriendHeaderHolder.facebookView.setRightCount(this.mThirdSiteRedDot.facebook, true);
            findFriendHeaderHolder.twitterView.setRightCount(this.mThirdSiteRedDot.twitter, true);
        }
        findFriendHeaderHolder.addressBookView.setOnItemClickListener(c.a);
        findFriendHeaderHolder.weiboView.setOnItemClickListener(new CommonItemView.a() { // from class: us.pinguo.inspire.module.contact.cell.d
            @Override // us.pinguo.foundation.ui.view.CommonItemView.a
            public final void onItemClick(View view) {
                FindFriendHeaderCell.this.c(view);
            }
        });
        findFriendHeaderHolder.facebookView.setOnItemClickListener(new CommonItemView.a() { // from class: us.pinguo.inspire.module.contact.cell.e
            @Override // us.pinguo.foundation.ui.view.CommonItemView.a
            public final void onItemClick(View view) {
                FindFriendHeaderCell.this.e(view);
            }
        });
        findFriendHeaderHolder.twitterView.setOnItemClickListener(new CommonItemView.a() { // from class: us.pinguo.inspire.module.contact.cell.f
            @Override // us.pinguo.foundation.ui.view.CommonItemView.a
            public final void onItemClick(View view) {
                FindFriendHeaderCell.this.g(view);
            }
        });
        if (Conditions.a()) {
            findFriendHeaderHolder.hide(R.id.divider_address_book_view);
            findFriendHeaderHolder.hide(R.id.address_book_view);
            return;
        }
        findFriendHeaderHolder.show(R.id.divider_address_book_view);
        findFriendHeaderHolder.show(R.id.address_book_view);
    }

    public void setAddressBookFriendCount(int i2) {
        this.mAddressBookFriendCount = i2;
    }

    public void setOnThirdSiteItemOnClickListener(ThirdSiteItemOnClickListener thirdSiteItemOnClickListener) {
        this.onThirdSiteItemOnClickListener = thirdSiteItemOnClickListener;
    }

    public void setThirdSiteFriendCount(ThirdSiteRedDot thirdSiteRedDot) {
        this.mThirdSiteRedDot = thirdSiteRedDot;
    }

    public void updateCell(int i2, ThirdSiteRedDot thirdSiteRedDot) {
        this.mAddressBookFriendCount = i2;
        this.mThirdSiteRedDot = thirdSiteRedDot;
        onBindViewHolder(this.mFindFriendHeaderHolder);
    }
}
