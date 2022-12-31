package us.pinguo.inspire.module.feeds.model;

import android.content.SharedPreferences;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.module.contact.cell.FindFriendItemCell;
import us.pinguo.inspire.module.contact.entry.Recommend;
import us.pinguo.inspire.module.discovery.entity.InspireFeed;
import us.pinguo.inspire.module.discovery.entity.InspireFeedVideo;
import us.pinguo.inspire.module.feeds.InspireFollowFeedLoader;
import us.pinguo.inspire.module.feeds.cell.FeedsCompositeCell;
import us.pinguo.inspire.module.feeds.cell.FeedsInterestCell;
import us.pinguo.inspire.module.feeds.cell.FeedsPhotoCell;
import us.pinguo.inspire.module.feeds.cell.FeedsTaskCell;
import us.pinguo.inspire.module.feeds.cell.FeedsTaskVideoCell;
import us.pinguo.inspire.module.feeds.cell.FeedsUploadStateCell;
import us.pinguo.inspire.module.feeds.cell.FeedsVideoCell;
import us.pinguo.inspire.module.feeds.model.PortalFollowFeeds;
import us.pinguo.inspire.module.publish.InspirePublishTask;
import us.pinguo.inspire.module.publish.vo.PublishData;
import us.pinguo.inspire.module.publish.vo.PublishDataCache;
import us.pinguo.user.s0;
/* loaded from: classes9.dex */
public class FeedsFollowManager {
    private static final String KEY_LAST_TIME = "key_last_time";
    private static final String KEY_PRE_CLOSE_REC = "key_pre_close_rec";
    private static final long NOT_SHOW_REC_DUTATION = 259200000;
    public static final String NO_MORE_SP = "-1__0";
    private static String sLastTime;
    public static String sSp;
    private static int sUnReadCount;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ List b(PortalFollowFeeds portalFollowFeeds) {
        sSp = portalFollowFeeds.sp;
        sLastTime = portalFollowFeeds.lastTime;
        return dataToCells(portalFollowFeeds);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ List c(PortalFollowFeeds portalFollowFeeds) {
        if (!PortalFollowFeeds.TYPE_NONE.equals(portalFollowFeeds.type)) {
            sSp = portalFollowFeeds.sp;
        }
        sLastTime = portalFollowFeeds.lastTime;
        cacheLastTime();
        return dataToCells(portalFollowFeeds);
    }

    private static void cacheLastTime() {
        SharedPreferences.Editor edit = Inspire.c().edit();
        edit.putString("key_last_time_" + s0.getInstance().getUserId(), sLastTime).apply();
    }

    private static boolean checkShowRecCell() {
        return System.currentTimeMillis() - Inspire.c().getLong(KEY_PRE_CLOSE_REC, 0L) >= NOT_SHOW_REC_DUTATION;
    }

    public static void clearRecCloseTime() {
        Inspire.c().edit().putLong(KEY_PRE_CLOSE_REC, 0L).apply();
    }

    public static void clearTime() {
        sSp = null;
        sLastTime = null;
    }

    private static List<us.pinguo.widget.common.cell.recycler.b> dataToCells(PortalFollowFeeds portalFollowFeeds) {
        String str;
        List<Recommend> list;
        ArrayList arrayList = new ArrayList();
        if (portalFollowFeeds == null) {
            return arrayList;
        }
        if (PortalFollowFeeds.TYPE_ALL.equals(portalFollowFeeds.type) && (list = portalFollowFeeds.recUsers) != null && list.size() > 0) {
            tryShowRecCell(arrayList, portalFollowFeeds.recUsers);
        }
        int i2 = 0;
        while (true) {
            List<PortalFollowFeeds.FeedFollowItem> list2 = portalFollowFeeds.list;
            if (list2 != null && i2 < list2.size()) {
                PortalFollowFeeds.FeedFollowItem feedFollowItem = portalFollowFeeds.list.get(i2);
                InspireFeed inspireFeed = feedFollowItem == null ? null : feedFollowItem.content;
                if (inspireFeed != null && (str = inspireFeed.type) != null) {
                    str.hashCode();
                    char c = 65535;
                    switch (str.hashCode()) {
                        case -2027282712:
                            if (str.equals(InspireFeed.TYPE_DYNAMIC)) {
                                c = 0;
                                break;
                            }
                            break;
                        case -124838484:
                            if (str.equals(InspireFeed.TYPE_LAST_TASK)) {
                                c = 1;
                                break;
                            }
                            break;
                        case 104256825:
                            if (str.equals(InspireFeed.TYPE_MULTI)) {
                                c = 2;
                                break;
                            }
                            break;
                        case 106642994:
                            if (str.equals("photo")) {
                                c = 3;
                                break;
                            }
                            break;
                        case 112202875:
                            if (str.equals("video")) {
                                c = 4;
                                break;
                            }
                            break;
                        case 1081823355:
                            if (str.equals(InspireFeed.TYPE_RECUSER)) {
                                c = 5;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            arrayList.add(new FeedsCompositeCell(inspireFeed.fid, inspireFeed.followLikeCnt));
                            break;
                        case 1:
                            List<InspireFeedVideo> list3 = inspireFeed.latestTaskCnt.videos;
                            if (list3 != null && list3.size() > 0) {
                                arrayList.add(new FeedsTaskVideoCell(inspireFeed));
                                break;
                            } else {
                                arrayList.add(new FeedsTaskCell(inspireFeed));
                                break;
                            }
                            break;
                        case 2:
                            arrayList.add(new FeedsPhotoCell(inspireFeed));
                            break;
                        case 3:
                            arrayList.add(new FeedsPhotoCell(inspireFeed));
                            break;
                        case 4:
                            arrayList.add(new FeedsVideoCell(inspireFeed));
                            break;
                        case 5:
                            Recommend recommend = inspireFeed.recUserCnt;
                            if (recommend != null) {
                                arrayList.add(new FindFriendItemCell(recommend));
                                break;
                            }
                            break;
                    }
                    us.pinguo.widget.common.cell.recycler.b bVar = (us.pinguo.widget.common.cell.recycler.b) arrayList.get(arrayList.size() - 1);
                    if (arrayList.size() > 0 && (bVar instanceof us.pinguo.inspire.cell.recycler.a)) {
                        ((us.pinguo.inspire.cell.recycler.a) arrayList.get(arrayList.size() - 1)).setStat(feedFollowItem.stat);
                    }
                    if (bVar instanceof us.pinguo.inspire.cell.recycler.a) {
                        ((us.pinguo.inspire.cell.recycler.a) bVar).setPageType(us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_FOLLOW);
                    }
                }
                i2++;
            }
        }
        return arrayList;
    }

    public static String getLastTime() {
        if (sLastTime == null && s0.getInstance().e()) {
            SharedPreferences c = Inspire.c();
            sLastTime = c.getString("key_last_time_" + s0.getInstance().getUserId(), null);
        }
        return sLastTime;
    }

    public static int getUnReadCount() {
        return sUnReadCount;
    }

    public static List<us.pinguo.widget.common.cell.recycler.b> getUploadStateCells() {
        try {
            PublishDataCache publishDataCache = (PublishDataCache) new us.pinguo.inspire.base.easyload.k(s0.getInstance().getUserId(), "publish_data", PublishDataCache.class).getObject();
            if (publishDataCache != null && !us.pinguo.foundation.utils.k.a(publishDataCache.publishDataList)) {
                ArrayList arrayList = new ArrayList();
                boolean z = true;
                for (PublishData publishData : publishDataCache.publishDataList) {
                    if (publishData.state != 4 && !InspirePublishTask.isPublishDataUploading(publishData)) {
                        FeedsUploadStateCell feedsUploadStateCell = new FeedsUploadStateCell(publishData);
                        if (z) {
                            feedsUploadStateCell.setDividerVisibility(false);
                            z = false;
                        } else {
                            feedsUploadStateCell.setDividerVisibility(true);
                        }
                        arrayList.add(feedsUploadStateCell);
                    }
                }
                return arrayList;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return new ArrayList();
    }

    public static Observable<List<us.pinguo.widget.common.cell.recycler.b>> loadCacheFollowFeeds() {
        return InspireFollowFeedLoader.getInstance().getInspireFeedRespFromCache().map(new PortalFollowFeeds.Assert()).map(a.a);
    }

    public static Observable<List<us.pinguo.widget.common.cell.recycler.b>> loadMoreFeeds() {
        return InspireFollowFeedLoader.getInstance().getFollowFeedRespFromServer(sSp, sLastTime, true, 0).map(new PortalFollowFeeds.Assert()).map(b.a);
    }

    public static Observable<List<us.pinguo.widget.common.cell.recycler.b>> refreshFollowFeeds() {
        return InspireFollowFeedLoader.getInstance().getFollowFeedRespFromServer("0", sLastTime, true, checkShowRecCell() ? 1 : 0).map(new PortalFollowFeeds.Assert()).map(c.a);
    }

    static void setLastTimeFromServerTime(double d2) {
        sLastTime = String.valueOf(d2);
        cacheLastTime();
    }

    public static void setPublishDataToFail() {
        us.pinguo.inspire.base.easyload.k kVar = new us.pinguo.inspire.base.easyload.k(s0.getInstance().getUserId(), "publish_data", PublishDataCache.class);
        try {
            PublishDataCache publishDataCache = (PublishDataCache) kVar.getObject();
            if (publishDataCache == null || us.pinguo.foundation.utils.k.a(publishDataCache.publishDataList)) {
                return;
            }
            for (PublishData publishData : publishDataCache.publishDataList) {
                if (publishData.state != 4) {
                    publishData.state = 2;
                }
            }
            kVar.putObject(publishDataCache);
        } catch (IOException e2) {
            e2.printStackTrace();
            Inspire.f(e2);
        } catch (Exception e3) {
            e3.printStackTrace();
            Inspire.f(e3);
        }
    }

    public static void setRecClosed() {
        Inspire.c().edit().putLong(KEY_PRE_CLOSE_REC, System.currentTimeMillis()).apply();
    }

    public static void setUnReadCount(int i2) {
        sUnReadCount = i2;
    }

    private static void tryShowRecCell(List<us.pinguo.widget.common.cell.recycler.b> list, List<Recommend> list2) {
        if (checkShowRecCell()) {
            list.add(new FeedsInterestCell(list2));
        }
    }
}
