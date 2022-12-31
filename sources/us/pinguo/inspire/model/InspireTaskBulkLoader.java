package us.pinguo.inspire.model;

import com.rockerhieu.emoji.model.LocaleUtils;
import com.tapjoy.TapjoyAuctionFlags;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import us.pinguo.common.network.BaseResponse;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.api.Payload;
import us.pinguo.inspire.data.DataManager;
import us.pinguo.inspire.model.InspireTaskBulkLoader;
/* loaded from: classes9.dex */
public class InspireTaskBulkLoader {
    public static final int ITR_STEP = 20;
    public static final String URL = "/task/taskListV2";
    public static final String URL2 = "/camera360/task/list";
    public static final String URL_DETAIL = Inspire.f11205f + "/camera360/task/detail";
    private InspireTaskDiskCache mInspireTaskDiskCache = new InspireTaskDiskCache();
    public String sort;

    /* loaded from: classes9.dex */
    public static class TaskListBanner {
        public String gotoUrl;
        public String imgUrl;
    }

    /* loaded from: classes9.dex */
    public static class TaskListResp {
        public TaskListBanner banner;
        public int count;
        public List<InspireTask> items = new ArrayList();
        public String sort;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ List b(TaskListResp taskListResp) {
        this.sort = taskListResp.sort;
        return taskListResp.items;
    }

    private /* synthetic */ List c(List list) {
        String lowerCase = LocaleUtils.getDefault().getLanguage().toLowerCase();
        DataManager.getInstance().a(list);
        if (list != null && list.size() > 0 && !((InspireTask) list.get(0)).language.equals(lowerCase)) {
            this.mInspireTaskDiskCache.clear();
        }
        return list;
    }

    private us.pinguo.foundation.m.j<BaseResponse<TaskListResp>> createVolleyRequest(String str, int i2) {
        return new Inspire.d<BaseResponse<TaskListResp>>() { // from class: us.pinguo.inspire.model.InspireTaskBulkLoader.3
        }.url(URL).put("sort", str).put("num", i2).put("supportSticker", 1).put("supportVideo", 1).build();
    }

    private us.pinguo.foundation.m.j<BaseResponse<TaskListResp>> createVolleyRequest2(String str, int i2) {
        Inspire.d<BaseResponse<TaskListResp>> dVar = new Inspire.d<BaseResponse<TaskListResp>>() { // from class: us.pinguo.inspire.model.InspireTaskBulkLoader.4
        };
        return dVar.url(Inspire.f11205f + URL2).put("sort", str).put("num", i2).put("supportSticker", 1).put("supportVideo", 1).build();
    }

    private /* synthetic */ InspireTask e(InspireTask inspireTask) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(inspireTask);
        processTaskStatusChange(arrayList);
        return inspireTask;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public /* synthetic */ List h(TaskListResp taskListResp) {
        this.sort = taskListResp.sort;
        return taskListResp.items;
    }

    private InspireTask getCacheTaskById(String str) {
        try {
            List<InspireTask> object = this.mInspireTaskDiskCache.getObject();
            if (object == null || object.size() <= 0) {
                return null;
            }
            for (InspireTask inspireTask : object) {
                if (inspireTask.taskId.equals(str)) {
                    return inspireTask;
                }
            }
            return null;
        } catch (Exception e2) {
            Inspire.f(e2);
            return null;
        }
    }

    private /* synthetic */ List i(List list) {
        String lowerCase = LocaleUtils.getDefault().getLanguage().toString().toLowerCase();
        DataManager.getInstance().b(list);
        if (list != null && list.size() > 0 && !((InspireTask) list.get(0)).language.equals(lowerCase)) {
            this.mInspireTaskDiskCache.clear();
        }
        return list;
    }

    private /* synthetic */ List k(List list) {
        processTaskStatusChange(list);
        return list;
    }

    public static Observable<InspireTask> loadByStickerId(String str, String str2) {
        return us.pinguo.foundation.m.f.f(new Inspire.d<BaseResponse<InspireTask>>() { // from class: us.pinguo.inspire.model.InspireTaskBulkLoader.2
        }.url("/task/getTaskId").put(TapjoyAuctionFlags.AUCTION_ID, str).put("type", str2).build()).map(new Payload());
    }

    private /* synthetic */ List m(List list) {
        this.mInspireTaskDiskCache.wrap().b(list);
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public /* synthetic */ List p(TaskListResp taskListResp) {
        this.sort = taskListResp.sort;
        return taskListResp.items;
    }

    private void processTaskStatusChange(List<InspireTask> list) {
        InspireTask cacheTaskById;
        if (list == null || list.size() == 0) {
            return;
        }
        for (InspireTask inspireTask : list) {
            if (inspireTask.finished && (cacheTaskById = getCacheTaskById(inspireTask.taskId)) != null && !cacheTaskById.finished) {
                new InspireWorkDiskCache(inspireTask.taskId).clear();
            }
        }
    }

    private /* synthetic */ List q(List list) {
        String lowerCase = Locale.getDefault().getLanguage().toLowerCase();
        DataManager.getInstance().b(list);
        if (list != null && list.size() > 0 && !((InspireTask) list.get(0)).language.equals(lowerCase)) {
            this.mInspireTaskDiskCache.clear();
        }
        return list;
    }

    private /* synthetic */ List s(List list) {
        processTaskStatusChange(list);
        return list;
    }

    private /* synthetic */ List u(List list) {
        this.mInspireTaskDiskCache.wrap().b(list);
        return list;
    }

    public /* synthetic */ List d(List list) {
        c(list);
        return list;
    }

    public /* synthetic */ InspireTask f(InspireTask inspireTask) {
        e(inspireTask);
        return inspireTask;
    }

    public List<InspireTask> getTop() {
        ArrayList arrayList = new ArrayList();
        try {
            us.pinguo.common.log.a.m("zhouwei", "TaskLoader: load the cache data", new Object[0]);
            return this.mInspireTaskDiskCache.getObject();
        } catch (Exception e2) {
            Inspire.f(e2);
            return arrayList;
        }
    }

    public /* synthetic */ List j(List list) {
        i(list);
        return list;
    }

    public /* synthetic */ List l(List list) {
        k(list);
        return list;
    }

    public Observable<List<InspireTask>> loadMore(int i2) {
        return us.pinguo.foundation.m.f.a(createVolleyRequest2(this.sort, i2)).map(new Payload()).map(new Func1() { // from class: us.pinguo.inspire.model.h
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                return InspireTaskBulkLoader.this.b((InspireTaskBulkLoader.TaskListResp) obj);
            }
        }).map(new Func1() { // from class: us.pinguo.inspire.model.b
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                List list = (List) obj;
                InspireTaskBulkLoader.this.d(list);
                return list;
            }
        }).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<InspireTask> loadTask(String str) {
        return us.pinguo.foundation.m.f.a(new Inspire.d<BaseResponse<InspireTask>>() { // from class: us.pinguo.inspire.model.InspireTaskBulkLoader.1
        }.url(URL_DETAIL).put("taskId", str).build()).map(new Payload()).map(new Func1() { // from class: us.pinguo.inspire.model.l
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                InspireTask inspireTask = (InspireTask) obj;
                InspireTaskBulkLoader.this.f(inspireTask);
                return inspireTask;
            }
        }).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<List<InspireTask>> loadTop(String str, int i2) {
        this.sort = null;
        return us.pinguo.foundation.m.f.a(createVolleyRequest(str, i2)).map(new Payload()).map(new Func1() { // from class: us.pinguo.inspire.model.c
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                return InspireTaskBulkLoader.this.h((InspireTaskBulkLoader.TaskListResp) obj);
            }
        }).map(new Func1() { // from class: us.pinguo.inspire.model.g
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                List list = (List) obj;
                InspireTaskBulkLoader.this.j(list);
                return list;
            }
        }).map(new Func1() { // from class: us.pinguo.inspire.model.k
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                List list = (List) obj;
                InspireTaskBulkLoader.this.l(list);
                return list;
            }
        }).map(new Func1() { // from class: us.pinguo.inspire.model.i
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                List list = (List) obj;
                InspireTaskBulkLoader.this.n(list);
                return list;
            }
        }).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<List<InspireTask>> loadTop2(int i2) {
        this.sort = "0";
        return us.pinguo.foundation.m.f.a(createVolleyRequest2("0", i2)).map(new Payload()).map(new Func1() { // from class: us.pinguo.inspire.model.d
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                return InspireTaskBulkLoader.this.p((InspireTaskBulkLoader.TaskListResp) obj);
            }
        }).map(new Func1() { // from class: us.pinguo.inspire.model.j
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                List list = (List) obj;
                InspireTaskBulkLoader.this.r(list);
                return list;
            }
        }).map(new Func1() { // from class: us.pinguo.inspire.model.e
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                List list = (List) obj;
                InspireTaskBulkLoader.this.t(list);
                return list;
            }
        }).map(new Func1() { // from class: us.pinguo.inspire.model.f
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                List list = (List) obj;
                InspireTaskBulkLoader.this.v(list);
                return list;
            }
        }).observeOn(AndroidSchedulers.mainThread());
    }

    public /* synthetic */ List n(List list) {
        m(list);
        return list;
    }

    public /* synthetic */ List r(List list) {
        q(list);
        return list;
    }

    public /* synthetic */ List t(List list) {
        s(list);
        return list;
    }

    public /* synthetic */ List v(List list) {
        u(list);
        return list;
    }
}
