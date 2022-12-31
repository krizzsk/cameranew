package cn.sharesdk.onekeyshare.themes.classic;

import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import cn.sharesdk.facebook.Facebook;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.twitter.Twitter;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mob.tools.gui.PullToRequestListAdapter;
import com.mob.tools.gui.PullToRequestView;
import com.mob.tools.utils.UIHandler;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyAuctionFlags;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes.dex */
public class FriendAdapter extends PullToRequestListAdapter implements PlatformActionListener {
    private FriendListPage activity;
    private int curPage;
    private ArrayList<Following> follows;
    private boolean hasNext;
    private PRTHeader llHeader;
    private HashMap<String, Boolean> map;
    private final int pageCount;
    private Platform platform;
    private float ratio;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class FollowersResult {
        public boolean hasNextPage;
        public ArrayList<Following> list;

        private FollowersResult() {
            this.hasNextPage = false;
        }
    }

    /* loaded from: classes.dex */
    public static class Following {
        public String atName;
        public boolean checked;
        public String description;
        public String icon;
        public String screenName;
        public String uid;
    }

    public FriendAdapter(FriendListPage friendListPage, PullToRequestView pullToRequestView) {
        super(pullToRequestView);
        this.pageCount = 15;
        this.activity = friendListPage;
        this.curPage = -1;
        this.hasNext = true;
        this.map = new HashMap<>();
        this.follows = new ArrayList<>();
        getListView().setDivider(new ColorDrawable(-1381654));
    }

    private void next() {
        if (this.hasNext) {
            this.platform.listFriend(15, this.curPage + 1, null);
        }
    }

    private FollowersResult parseFollowers(String str, HashMap<String, Object> hashMap, HashMap<String, Boolean> hashMap2) {
        if (hashMap == null || hashMap.size() <= 0) {
            return null;
        }
        ArrayList<Following> arrayList = new ArrayList<>();
        boolean z = false;
        if (SinaWeibo.NAME.equals(str)) {
            Iterator it = ((ArrayList) hashMap.get("users")).iterator();
            while (it.hasNext()) {
                HashMap hashMap3 = (HashMap) it.next();
                String valueOf = String.valueOf(hashMap3.get(TapjoyAuctionFlags.AUCTION_ID));
                if (!hashMap2.containsKey(valueOf)) {
                    Following following = new Following();
                    following.uid = valueOf;
                    following.screenName = String.valueOf(hashMap3.get("name"));
                    following.description = String.valueOf(hashMap3.get(SocialConstants.PARAM_COMMENT));
                    following.icon = String.valueOf(hashMap3.get("profile_image_url"));
                    following.atName = following.screenName;
                    hashMap2.put(following.uid, Boolean.TRUE);
                    arrayList.add(following);
                }
            }
            if (((Integer) hashMap.get("total_number")).intValue() <= hashMap2.size()) {
                r6 = false;
            }
        } else if ("TencentWeibo".equals(str)) {
            r6 = ((Integer) hashMap.get("hasnext")).intValue() == 0;
            Iterator it2 = ((ArrayList) hashMap.get(TJAdUnitConstants.String.VIDEO_INFO)).iterator();
            while (it2.hasNext()) {
                HashMap hashMap4 = (HashMap) it2.next();
                String valueOf2 = String.valueOf(hashMap4.get("name"));
                if (!hashMap2.containsKey(valueOf2)) {
                    Following following2 = new Following();
                    following2.screenName = String.valueOf(hashMap4.get("nick"));
                    following2.uid = valueOf2;
                    following2.atName = valueOf2;
                    Iterator it3 = ((ArrayList) hashMap4.get("tweet")).iterator();
                    if (it3.hasNext()) {
                        following2.description = String.valueOf(((HashMap) it3.next()).get("text"));
                    }
                    following2.icon = String.valueOf(hashMap4.get("head")) + "/100";
                    hashMap2.put(following2.uid, Boolean.TRUE);
                    arrayList.add(following2);
                }
            }
        } else {
            if (Facebook.NAME.equals(str)) {
                Iterator it4 = ((ArrayList) hashMap.get("data")).iterator();
                while (it4.hasNext()) {
                    HashMap hashMap5 = (HashMap) it4.next();
                    String valueOf3 = String.valueOf(hashMap5.get(TapjoyAuctionFlags.AUCTION_ID));
                    if (!hashMap2.containsKey(valueOf3)) {
                        Following following3 = new Following();
                        following3.uid = valueOf3;
                        following3.atName = "[" + valueOf3 + "]";
                        following3.screenName = String.valueOf(hashMap5.get("name"));
                        HashMap hashMap6 = (HashMap) hashMap5.get("picture");
                        if (hashMap6 != null) {
                            following3.icon = String.valueOf(((HashMap) hashMap6.get("data")).get("url"));
                        }
                        hashMap2.put(following3.uid, Boolean.TRUE);
                        arrayList.add(following3);
                    }
                }
                z = ((HashMap) hashMap.get("paging")).containsKey("next");
            } else if (Twitter.NAME.equals(str)) {
                Iterator it5 = ((ArrayList) hashMap.get("users")).iterator();
                while (it5.hasNext()) {
                    HashMap hashMap7 = (HashMap) it5.next();
                    String valueOf4 = String.valueOf(hashMap7.get(FirebaseAnalytics.Param.SCREEN_NAME));
                    if (!hashMap2.containsKey(valueOf4)) {
                        Following following4 = new Following();
                        following4.uid = valueOf4;
                        following4.atName = valueOf4;
                        following4.screenName = String.valueOf(hashMap7.get("name"));
                        following4.description = String.valueOf(hashMap7.get(SocialConstants.PARAM_COMMENT));
                        following4.icon = String.valueOf(hashMap7.get("profile_image_url"));
                        hashMap2.put(following4.uid, Boolean.TRUE);
                        arrayList.add(following4);
                    }
                }
            }
            FollowersResult followersResult = new FollowersResult();
            followersResult.list = arrayList;
            followersResult.hasNextPage = z;
            return followersResult;
        }
        z = r6;
        FollowersResult followersResult2 = new FollowersResult();
        followersResult2.list = arrayList;
        followersResult2.hasNextPage = z;
        return followersResult2;
    }

    @Override // com.mob.tools.gui.PullToRequestBaseListAdapter
    public int getCount() {
        ArrayList<Following> arrayList = this.follows;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // com.mob.tools.gui.PullToRequestAdatper
    public View getFooterView() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setMinimumHeight(10);
        return linearLayout;
    }

    @Override // com.mob.tools.gui.PullToRequestAdatper
    public View getHeaderView() {
        if (this.llHeader == null) {
            this.llHeader = new PRTHeader(getContext());
        }
        return this.llHeader;
    }

    @Override // com.mob.tools.gui.PullToRequestBaseListAdapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // com.mob.tools.gui.PullToRequestBaseListAdapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = new FriendListItem(viewGroup.getContext(), this.ratio);
        }
        ((FriendListItem) view).update(getItem(i2), isFling());
        if (i2 == getCount() - 1) {
            next();
        }
        return view;
    }

    @Override // cn.sharesdk.framework.PlatformActionListener
    public void onCancel(Platform platform, int i2) {
        UIHandler.sendEmptyMessage(0, new Handler.Callback() { // from class: cn.sharesdk.onekeyshare.themes.classic.FriendAdapter.3
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                FriendAdapter.this.activity.finish();
                return false;
            }
        });
    }

    @Override // cn.sharesdk.framework.PlatformActionListener
    public void onComplete(Platform platform, int i2, HashMap<String, Object> hashMap) {
        final FollowersResult parseFollowers = parseFollowers(this.platform.getName(), hashMap, this.map);
        if (parseFollowers == null) {
            UIHandler.sendEmptyMessage(0, new Handler.Callback() { // from class: cn.sharesdk.onekeyshare.themes.classic.FriendAdapter.1
                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    FriendAdapter.this.notifyDataSetChanged();
                    return false;
                }
            });
            return;
        }
        this.hasNext = parseFollowers.hasNextPage;
        ArrayList<Following> arrayList = parseFollowers.list;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        this.curPage++;
        Message message = new Message();
        message.what = 1;
        message.obj = parseFollowers.list;
        UIHandler.sendMessage(message, new Handler.Callback() { // from class: cn.sharesdk.onekeyshare.themes.classic.FriendAdapter.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message2) {
                if (FriendAdapter.this.curPage <= 0) {
                    FriendAdapter.this.follows.clear();
                }
                FriendAdapter.this.follows.addAll(parseFollowers.list);
                FriendAdapter.this.notifyDataSetChanged();
                return false;
            }
        });
    }

    @Override // cn.sharesdk.framework.PlatformActionListener
    public void onError(Platform platform, int i2, Throwable th) {
        th.printStackTrace();
    }

    @Override // com.mob.tools.gui.PullToRequestAdatper
    public void onPullDown(int i2) {
        this.llHeader.onPullDown(i2);
    }

    @Override // com.mob.tools.gui.PullToRequestAdatper
    public void onRefresh() {
        this.llHeader.onRequest();
        this.curPage = -1;
        this.hasNext = true;
        this.map.clear();
        next();
    }

    @Override // com.mob.tools.gui.PullToRequestAdatper
    public void onReversed() {
        this.llHeader.reverse();
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        getListView().setOnItemClickListener(onItemClickListener);
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
        platform.setPlatformActionListener(this);
    }

    public void setRatio(float f2) {
        this.ratio = f2;
        ListView listView = getListView();
        if (f2 < 1.0f) {
            f2 = 1.0f;
        }
        listView.setDividerHeight((int) f2);
    }

    @Override // com.mob.tools.gui.PullToRequestBaseListAdapter
    public Following getItem(int i2) {
        return this.follows.get(i2);
    }
}
