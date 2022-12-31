package us.pinguo.inspire.module.feeds.model;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import us.pinguo.foundation.base.InspireRedirectActivity;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.inspire.module.challenge.ChallengeActivity;
import us.pinguo.inspire.module.comment.FeedsInfoActivity;
import us.pinguo.inspire.module.discovery.entity.InspireFeed;
import us.pinguo.inspire.module.feeds.cell.FeedsPhotoCellProxy;
/* loaded from: classes9.dex */
public class FeedsList {
    private static InspireWork curWork;
    private static int selectIndex;
    private static int selectInnerIndex;
    public static Bitmap[] tempBitmaps;
    private static ArrayList<InspireWork> workList = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(us.pinguo.widget.common.cell.recycler.a aVar, Context context, int i2, Intent intent) {
        if (aVar == null || aVar.getRecyclerView() == null || (context instanceof ChallengeActivity)) {
            return;
        }
        onActivityResult(FeedsPhotoCellProxy.REQUEST_DETAIL, i2, intent, aVar.getRecyclerView());
    }

    public static void enterDetailPage(Context context, String str, String str2, InspireWork inspireWork, String str3, us.pinguo.widget.common.cell.recycler.a aVar, us.pinguo.widget.common.cell.recycler.b bVar) {
        enterDetailPage(context, str, str2, inspireWork, str3, aVar, bVar, 0, null);
    }

    public static int getCount() {
        ArrayList<InspireWork> arrayList = workList;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public static int getCurIndex(List<us.pinguo.widget.common.cell.recycler.b> list, InspireWork inspireWork) {
        if (inspireWork != null && list != null && inspireWork.workId != null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (list.get(i2).getData() instanceof InspireFeed) {
                    InspireFeed inspireFeed = (InspireFeed) list.get(i2).getData();
                    if (inspireFeed.getFcnt() != null && inspireWork.workId.equals(inspireFeed.getFcnt().workId)) {
                        return i2;
                    }
                } else if ((list.get(i2).getData() instanceof InspireWork) && inspireWork.workId.equals(((InspireWork) list.get(i2).getData()).workId)) {
                    return i2;
                }
            }
            return selectIndex;
        }
        return selectIndex;
    }

    public static InspireWork getCurWork() {
        return curWork;
    }

    public static InspireWork getItem(int i2) {
        if (i2 < 0 || i2 >= getCount()) {
            return null;
        }
        return workList.get(i2);
    }

    public static int getSelectIndex() {
        return selectIndex;
    }

    public static int getSelectInnerIndex() {
        return selectInnerIndex;
    }

    public static List<InspireWork> getWorkList() {
        ArrayList arrayList = new ArrayList(workList);
        workList.clear();
        return arrayList;
    }

    public static void onActivityResult(int i2, int i3, Intent intent, RecyclerView recyclerView) {
        if (i2 != 63213 || intent == null || recyclerView == null || !(recyclerView.getAdapter() instanceof us.pinguo.widget.common.cell.recycler.a)) {
            return;
        }
        int curIndex = getCurIndex(((us.pinguo.widget.common.cell.recycler.a) recyclerView.getAdapter()).getCells(), (InspireWork) intent.getParcelableExtra("curWork"));
        if (curIndex >= 0) {
            boolean z = false;
            if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
                int findFirstVisibleItemPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
                int findLastVisibleItemPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findLastVisibleItemPosition();
                if (curIndex >= findFirstVisibleItemPosition && curIndex <= findLastVisibleItemPosition) {
                    z = true;
                }
            }
            if (z) {
                return;
            }
            recyclerView.getLayoutManager().scrollToPosition(curIndex);
        }
    }

    public static void onRestoreInstanceState(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        ArrayList<InspireWork> parcelableArrayList = bundle.getParcelableArrayList("workList");
        workList = parcelableArrayList;
        if (parcelableArrayList == null) {
            workList = new ArrayList<>();
        }
        selectIndex = bundle.getInt("selectIndex");
        curWork = (InspireWork) bundle.getParcelable("curWork");
        us.pinguo.common.log.a.m("hwLog", "onRestoreInstanceState,selectIndex:" + selectIndex, new Object[0]);
    }

    public static void onSaveInstanceState(Bundle bundle, ArrayList<InspireWork> arrayList) {
        if (arrayList != null) {
            bundle.putParcelableArrayList("workList", arrayList);
        }
        bundle.putInt("selectIndex", selectIndex);
        bundle.putParcelable("curWork", curWork);
    }

    public static void setCurrentWork(InspireWork inspireWork) {
        curWork = inspireWork;
    }

    public static void setFeedsList(List<us.pinguo.widget.common.cell.recycler.b> list, us.pinguo.widget.common.cell.recycler.b bVar) {
        setFeedsList(list, bVar, 0);
    }

    public static void enterDetailPage(Context context, String str, String str2, InspireWork inspireWork, String str3, us.pinguo.widget.common.cell.recycler.a aVar, us.pinguo.widget.common.cell.recycler.b bVar, int i2, Bundle bundle) {
        enterDetailPage(context, str, str2, inspireWork, str3, aVar, bVar, i2, bundle, null);
    }

    public static void setFeedsList(List<us.pinguo.widget.common.cell.recycler.b> list, us.pinguo.widget.common.cell.recycler.b bVar, int i2) {
        workList.clear();
        if (list == null) {
            return;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            us.pinguo.widget.common.cell.recycler.b bVar2 = list.get(i3);
            if (bVar2.getData() instanceof InspireFeed) {
                InspireFeed inspireFeed = (InspireFeed) bVar2.getData();
                if (InspireFeed.TYPE_MULTI.equals(inspireFeed.type) || "photo".equals(inspireFeed.type) || "video".equals(inspireFeed.type)) {
                    workList.add(inspireFeed.convertFeedToWork());
                    if (bVar2 == bVar) {
                        selectIndex = workList.size() - 1;
                    }
                }
            } else if (bVar2.getData() instanceof InspireWork) {
                workList.add((InspireWork) bVar2.getData());
                if (bVar2 == bVar) {
                    selectIndex = workList.size() - 1;
                }
            }
        }
        selectInnerIndex = i2;
    }

    public static void enterDetailPage(final Context context, String str, String str2, InspireWork inspireWork, String str3, final us.pinguo.widget.common.cell.recycler.a aVar, us.pinguo.widget.common.cell.recycler.b bVar, int i2, Bundle bundle, Intent intent) {
        Intent intent2;
        selectInnerIndex = i2;
        if (intent != null) {
            intent2 = new Intent(intent);
            intent2.setClass(context, FeedsInfoActivity.class);
        } else {
            intent2 = new Intent(context, FeedsInfoActivity.class);
        }
        intent2.putExtra("feed_detail_from", str3);
        intent2.putExtra("work_id", str);
        intent2.putExtra("key_comment_id", str2);
        intent2.putExtra("select_work", inspireWork);
        if (aVar != null && bVar != null) {
            setFeedsList(aVar.getCells(), bVar, i2);
        }
        if (context instanceof InspireRedirectActivity) {
            ((InspireRedirectActivity) context).startActivityForResult(intent2, new us.pinguo.foundation.proxy.c() { // from class: us.pinguo.inspire.module.feeds.model.o
                @Override // us.pinguo.foundation.proxy.c
                public final void onActivityResult(int i3, Intent intent3) {
                    FeedsList.a(us.pinguo.widget.common.cell.recycler.a.this, context, i3, intent3);
                }
            }, bundle);
        } else {
            ContextCompat.startActivity(context, intent2, bundle);
        }
    }
}
