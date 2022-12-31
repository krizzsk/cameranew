package us.pinguo.inspire.module.comment;

import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import us.pinguo.common.network.BaseResponse;
import us.pinguo.foundation.m.f;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.api.Payload;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.inspire.module.discovery.fragment.DiscoveryHotVideoFragment;
import us.pinguo.inspire.module.profile.activity.GuestProfileFragment;
/* compiled from: RecLoader.kt */
/* loaded from: classes9.dex */
public final class RecLoader {
    private static final String BROWSE_NUM_URL;
    private static final String CANCEL_REC_URL;
    public static final RecLoader INSTANCE = new RecLoader();
    private static final String KEY_VIEWSUM;
    private static final int PAGE_SIZE;
    private static final String REC_URL;
    private static int lastPageNo;
    private static String listName;

    static {
        String str = Inspire.f11205f;
        REC_URL = kotlin.jvm.internal.s.q(str, "/camera360/rec/list");
        CANCEL_REC_URL = kotlin.jvm.internal.s.q(str, "/camera360/rec/cancelWorkRec");
        BROWSE_NUM_URL = kotlin.jvm.internal.s.q(str, "/camera360/work/incrWatchSum");
        KEY_VIEWSUM = "key_viewsum";
        PAGE_SIZE = 30;
    }

    private RecLoader() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<InspireWork> filterRecList(List<? extends InspireWork> list) {
        boolean z;
        SharedPreferences sharedPreferences = Inspire.a().getSharedPreferences("rec_list_filter", 0);
        int size = sharedPreferences.getAll().size();
        us.pinguo.common.log.a.k(kotlin.jvm.internal.s.q("过滤名单size:", Integer.valueOf(size)), new Object[0]);
        if (size >= 100) {
            us.pinguo.common.log.a.k("过滤名单size达到100，全部清空", new Object[0]);
            sharedPreferences.edit().clear().apply();
        }
        if (us.pinguo.foundation.utils.k.a(list)) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            InspireWork inspireWork = (InspireWork) obj;
            String str = inspireWork.workId;
            if (str == null) {
                z = false;
            } else {
                int i2 = sharedPreferences.getInt(str, 0);
                z = i2 >= 1;
                if (z) {
                    us.pinguo.common.log.a.s("workId:" + ((Object) inspireWork.workId) + "展示次数" + i2 + ",过滤", new Object[0]);
                }
            }
            if (!z) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: loadRecList$lambda-2  reason: not valid java name */
    public static final RecResp m156loadRecList$lambda2(RecResp recResp) {
        if (recResp.getItems() != null) {
            List<InspireWork> filterRecList = INSTANCE.filterRecList(recResp.getItems());
            recResp.getItems().clear();
            recResp.getItems().addAll(filterRecList);
        }
        return recResp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: loadRecList$lambda-3  reason: not valid java name */
    public static final RecResp m157loadRecList$lambda3(RecResp recResp) {
        listName = recResp.getListName();
        lastPageNo = recResp.getPageNo();
        return recResp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: refreshRecList$lambda-0  reason: not valid java name */
    public static final RecResp m158refreshRecList$lambda0(RecResp recResp) {
        if (recResp.getItems() != null) {
            List<InspireWork> filterRecList = INSTANCE.filterRecList(recResp.getItems());
            recResp.getItems().clear();
            recResp.getItems().addAll(filterRecList);
        }
        return recResp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: refreshRecList$lambda-1  reason: not valid java name */
    public static final RecResp m159refreshRecList$lambda1(RecResp recResp) {
        listName = recResp.getListName();
        lastPageNo = recResp.getPageNo();
        return recResp;
    }

    public final Observable<BaseResponse<Object>> cancelRec(InspireWork work) {
        kotlin.jvm.internal.s.h(work, "work");
        Observable<BaseResponse<Object>> f2 = us.pinguo.foundation.m.f.f(new Inspire.d<BaseResponse<Object>>() { // from class: us.pinguo.inspire.module.comment.RecLoader$cancelRec$builder$1
        }.url(CANCEL_REC_URL).put(GuestProfileFragment.USER_ID, us.pinguo.user.s0.getInstance().getUserId()).put(DiscoveryHotVideoFragment.WORK_ID, work.workId).setCacheKey(String.valueOf(System.nanoTime())).build());
        kotlin.jvm.internal.s.g(f2, "observe<BaseResponse<Object>>(builder.build())");
        return f2;
    }

    public final int getLastPageNo() {
        return lastPageNo;
    }

    public final Observable<BaseResponse<Object>> incrWatchSum(InspireWork work) {
        kotlin.jvm.internal.s.h(work, "work");
        f.a<BaseResponse<Object>> url = new Inspire.d<BaseResponse<Object>>() { // from class: us.pinguo.inspire.module.comment.RecLoader$incrWatchSum$builder$1
        }.url(BROWSE_NUM_URL);
        Observable<BaseResponse<Object>> f2 = us.pinguo.foundation.m.f.f(url.put("workIds", "{\"" + ((Object) work.workId) + "\":1}").setCacheKey(String.valueOf(System.nanoTime())).build());
        kotlin.jvm.internal.s.g(f2, "observe<BaseResponse<Object>>(builder.build())");
        return f2;
    }

    public final Observable<RecResp> loadRecList(int i2) {
        SharedPreferences c = Inspire.c();
        String str = KEY_VIEWSUM;
        int i3 = c.getInt(str, 1);
        f.a<BaseResponse<RecResp>> cacheKey = new Inspire.d<BaseResponse<RecResp>>() { // from class: us.pinguo.inspire.module.comment.RecLoader$loadRecList$builder$1
        }.url(REC_URL).put("listName", listName).put("pageNo", i2).put("pageSize", PAGE_SIZE).put("viewSum", i3).put(GuestProfileFragment.USER_ID, us.pinguo.user.s0.getInstance().getUserId()).setCacheKey(String.valueOf(System.nanoTime()));
        Inspire.c().edit().putInt(str, i3 + 1).apply();
        Observable<RecResp> map = us.pinguo.foundation.m.f.f(cacheKey.build()).observeOn(Schedulers.io()).map(new Payload()).map(m1.a).observeOn(AndroidSchedulers.mainThread()).map(n1.a);
        kotlin.jvm.internal.s.g(map, "observe<BaseResponse<Rec…     it\n                }");
        return map;
    }

    public final void recordWorkBrowsed(String workId) {
        kotlin.jvm.internal.s.h(workId, "workId");
        SharedPreferences sharedPreferences = Inspire.a().getSharedPreferences("rec_list_filter", 0);
        int i2 = sharedPreferences.getInt(workId, 0);
        StringBuilder sb = new StringBuilder();
        sb.append("workId:");
        sb.append(workId);
        sb.append("展示次数");
        int i3 = i2 + 1;
        sb.append(i3);
        us.pinguo.common.log.a.s(sb.toString(), new Object[0]);
        sharedPreferences.edit().putInt(workId, i3).apply();
    }

    public final Observable<RecResp> refreshRecList(String str) {
        lastPageNo = 0;
        SharedPreferences c = Inspire.c();
        String str2 = KEY_VIEWSUM;
        int i2 = c.getInt(str2, 1);
        f.a<BaseResponse<RecResp>> cacheKey = new Inspire.d<BaseResponse<RecResp>>() { // from class: us.pinguo.inspire.module.comment.RecLoader$refreshRecList$builder$1
        }.url(REC_URL).putNonNull("workIds", str).put("listName", "").put("pageNo", 1).put("pageSize", PAGE_SIZE).put("viewSum", i2).put(GuestProfileFragment.USER_ID, us.pinguo.user.s0.getInstance().getUserId()).setCacheKey(String.valueOf(System.nanoTime()));
        Inspire.c().edit().putInt(str2, i2 + 1).apply();
        Observable<RecResp> map = us.pinguo.foundation.m.f.f(cacheKey.build()).observeOn(Schedulers.io()).map(new Payload()).map(k1.a).observeOn(AndroidSchedulers.mainThread()).map(l1.a);
        kotlin.jvm.internal.s.g(map, "observe<BaseResponse<Rec…     it\n                }");
        return map;
    }

    public final void setLastPageNo(int i2) {
        lastPageNo = i2;
    }
}
