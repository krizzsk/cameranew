package us.pinguo.inspire.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.growingio.android.sdk.models.PageEvent;
import java.util.List;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import us.pinguo.common.network.BaseResponse;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.api.Payload;
import us.pinguo.inspire.model.InspireWorkBulkLoader;
import us.pinguo.inspire.module.discovery.fragment.DiscoveryHotVideoFragment;
/* loaded from: classes9.dex */
public class InspireWorkBulkLoader {
    public static final int ITR_STEP = 50;
    public static final String URL = "/pic/workFeed";
    public static final String URL_DETAIL2 = "/camera360/work/list";
    private InspireWorkDiskCache mInspireWorkDiskCache;
    private String mTaskId;
    private int mListNo = 0;
    private int mPageNum = 1;
    private boolean mHasMore = true;

    /* loaded from: classes9.dex */
    public static class AdVideo implements Parcelable {
        public static final Parcelable.Creator<AdVideo> CREATOR = new Parcelable.Creator<AdVideo>() { // from class: us.pinguo.inspire.model.InspireWorkBulkLoader.AdVideo.1
            @Override // android.os.Parcelable.Creator
            public AdVideo createFromParcel(Parcel parcel) {
                return new AdVideo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public AdVideo[] newArray(int i2) {
                return new AdVideo[i2];
            }
        };
        public String adGotoUrl;
        public int height;
        public int width;
        public String workUrl;

        public AdVideo() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.workUrl);
            parcel.writeInt(this.width);
            parcel.writeInt(this.height);
            parcel.writeString(this.adGotoUrl);
        }

        protected AdVideo(Parcel parcel) {
            this.workUrl = parcel.readString();
            this.width = parcel.readInt();
            this.height = parcel.readInt();
            this.adGotoUrl = parcel.readString();
        }
    }

    /* loaded from: classes9.dex */
    public static class InspireWorkResponse {
        public List<AdVideo> adVideo;
        public List<InspireWork> items;
        public int listNo;
        public int status;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class ShareFlowerResp {
        int flower;

        private ShareFlowerResp() {
        }
    }

    public InspireWorkBulkLoader(String str) {
        this.mTaskId = str;
        this.mInspireWorkDiskCache = new InspireWorkDiskCache(str);
    }

    private /* synthetic */ InspireWorkResponse b(InspireWorkResponse inspireWorkResponse) {
        this.mListNo = inspireWorkResponse.listNo;
        if (inspireWorkResponse.items.size() > 0) {
            this.mPageNum++;
        } else {
            this.mHasMore = false;
        }
        return inspireWorkResponse;
    }

    private us.pinguo.foundation.m.j<BaseResponse<InspireWorkResponse>> createVolleyRequest(int i2, int i3) {
        Inspire.d<BaseResponse<InspireWorkResponse>> dVar = new Inspire.d<BaseResponse<InspireWorkResponse>>() { // from class: us.pinguo.inspire.model.InspireWorkBulkLoader.2
        };
        return dVar.url(Inspire.f11205f + URL_DETAIL2).put("taskId", this.mTaskId).put(PageEvent.TYPE_NAME, i2).put("num", i3).put("listNo", this.mListNo).build();
    }

    private /* synthetic */ InspireWorkResponse d(InspireWorkResponse inspireWorkResponse) {
        List<InspireWork> list = inspireWorkResponse.items;
        if (list != null && list.size() != 0) {
            us.pinguo.common.log.a.k("zhouwei", "干掉本任务所有照片");
            this.mInspireWorkDiskCache.clear();
            this.mListNo = inspireWorkResponse.listNo;
            return inspireWorkResponse;
        }
        this.mInspireWorkDiskCache.clear();
        return inspireWorkResponse;
    }

    private /* synthetic */ InspireWorkResponse f(InspireWorkResponse inspireWorkResponse) {
        if (inspireWorkResponse != null && inspireWorkResponse.items.size() > 0) {
            us.pinguo.common.log.a.m("zhouwei", "first page count:" + inspireWorkResponse.items.size(), new Object[0]);
            this.mInspireWorkDiskCache.wrap().b(inspireWorkResponse);
        }
        return inspireWorkResponse;
    }

    private /* synthetic */ InspireWorkResponse h(InspireWorkResponse inspireWorkResponse) {
        this.mPageNum = 2;
        this.mHasMore = true;
        return inspireWorkResponse;
    }

    public static Observable<Integer> increaseShareCompletion(String str) {
        Inspire.d<BaseResponse<ShareFlowerResp>> dVar = new Inspire.d<BaseResponse<ShareFlowerResp>>() { // from class: us.pinguo.inspire.model.InspireWorkBulkLoader.1
        };
        return us.pinguo.foundation.m.f.f(dVar.url(Inspire.f11205f + "/camera360/work/incrShareQty").put(DiscoveryHotVideoFragment.WORK_ID, str).build()).map(new Payload()).map(s.a);
    }

    public /* synthetic */ InspireWorkResponse c(InspireWorkResponse inspireWorkResponse) {
        b(inspireWorkResponse);
        return inspireWorkResponse;
    }

    public /* synthetic */ InspireWorkResponse e(InspireWorkResponse inspireWorkResponse) {
        d(inspireWorkResponse);
        return inspireWorkResponse;
    }

    public /* synthetic */ InspireWorkResponse g(InspireWorkResponse inspireWorkResponse) {
        f(inspireWorkResponse);
        return inspireWorkResponse;
    }

    public int getPageNum(int i2) {
        return this.mPageNum;
    }

    public InspireWorkResponse getTopCache() {
        try {
            InspireWorkResponse object = this.mInspireWorkDiskCache.getObject();
            if (object != null) {
                return object;
            }
            return null;
        } catch (Exception e2) {
            Inspire.f(e2);
            return null;
        }
    }

    public boolean hasMore() {
        return this.mHasMore;
    }

    public /* synthetic */ InspireWorkResponse i(InspireWorkResponse inspireWorkResponse) {
        h(inspireWorkResponse);
        return inspireWorkResponse;
    }

    public Observable<InspireWorkResponse> loadMore(int i2, int i3) {
        return us.pinguo.foundation.m.f.f(createVolleyRequest(i2, i3)).map(new Payload()).map(new Func1() { // from class: us.pinguo.inspire.model.p
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                InspireWorkBulkLoader.InspireWorkResponse inspireWorkResponse = (InspireWorkBulkLoader.InspireWorkResponse) obj;
                InspireWorkBulkLoader.this.c(inspireWorkResponse);
                return inspireWorkResponse;
            }
        });
    }

    public Observable<InspireWorkResponse> loadTop(int i2, int i3) {
        this.mListNo = 0;
        return us.pinguo.foundation.m.f.a(createVolleyRequest(i2, i3)).map(new Payload()).map(new Func1() { // from class: us.pinguo.inspire.model.q
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                InspireWorkBulkLoader.InspireWorkResponse inspireWorkResponse = (InspireWorkBulkLoader.InspireWorkResponse) obj;
                InspireWorkBulkLoader.this.e(inspireWorkResponse);
                return inspireWorkResponse;
            }
        }).map(new Func1() { // from class: us.pinguo.inspire.model.t
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                InspireWorkBulkLoader.InspireWorkResponse inspireWorkResponse = (InspireWorkBulkLoader.InspireWorkResponse) obj;
                InspireWorkBulkLoader.this.g(inspireWorkResponse);
                return inspireWorkResponse;
            }
        }).map(new Func1() { // from class: us.pinguo.inspire.model.r
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                InspireWorkBulkLoader.InspireWorkResponse inspireWorkResponse = (InspireWorkBulkLoader.InspireWorkResponse) obj;
                InspireWorkBulkLoader.this.i(inspireWorkResponse);
                return inspireWorkResponse;
            }
        }).observeOn(AndroidSchedulers.mainThread());
    }
}
