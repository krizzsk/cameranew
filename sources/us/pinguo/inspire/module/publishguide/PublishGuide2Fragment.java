package us.pinguo.inspire.module.publishguide;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.rockerhieu.emoji.model.Emoticon;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import us.pinguo.foundation.domain.PublishMediaItem;
import us.pinguo.foundation.statistics.k;
import us.pinguo.foundation.statistics.l;
import us.pinguo.foundation.utils.j;
import us.pinguo.foundation.utils.j0;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.module.feeds.PublishManager;
import us.pinguo.inspire.module.publishguide.PublishGuideGridCell;
import us.pinguo.inspire.portal.view.DragDetectLinearLayout;
import us.pinguo.librouter.c.d;
import us.pinguo.librouter.module.camera.e;
import us.pinguo.librouter.module.inspire.BasePublishGuideFragment;
import us.pinguo.ui.R;
import us.pinguo.user.recycler.c;
import us.pinguo.util.v;
/* loaded from: classes9.dex */
public class PublishGuide2Fragment extends BasePublishGuideFragment implements View.OnClickListener, PublishGuideGridCell.OnCheckedListener, PublishManager.PublishCompleteLister {
    private static final int PAGE_ITEM_COUNT = 40;
    private static final int PRELOAD_SIZE = 3;
    public static final int TYPE_CAMERA = 1;
    public static final int TYPE_EMPTY = 2;
    public static final int TYPE_GRID = 0;
    private c mAdapter;
    private boolean mClickedEntrance;
    private e mMediaAlbum;
    private PublishGuideAnim mPublishAnim;
    private RecyclerView mRecyclerView;
    private volatile boolean mEnableLoadMore = true;
    private List<PublishGuideGridCell> mCheckedList = new LinkedList();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a0 */
    public /* synthetic */ void b0(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            PublishGuideGridCell publishGuideGridCell = new PublishGuideGridCell((PublishMediaItem) it.next());
            publishGuideGridCell.setOnCheckedListener(this);
            arrayList2.add(publishGuideGridCell);
        }
        this.mAdapter.addAll(arrayList2);
        if (this.mAdapter.getItemCount() == 0) {
            this.mRecyclerView.setPadding(0, 0, 0, 0);
            this.mAdapter.showEmpty();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c0 */
    public /* synthetic */ void d0(Throwable th) {
        us.pinguo.foundation.e.e(th);
        this.mAdapter.showEmpty();
    }

    private void changePublishBtn() {
        this.mPublishAnim.changePublishNum(this.mCheckedList.size());
    }

    private boolean checkFileExist(String str) {
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            j0.c(R.string.plus_sandbox_tips_file_not_exit_without_sync);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0042, code lost:
        if (((androidx.recyclerview.widget.LinearLayoutManager) r0).findLastVisibleItemPosition() >= ((r6.mAdapter.getItemCount() - 1) - 3)) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005d, code lost:
        if (r0.findLastVisibleItemPosition() >= ((r6.mAdapter.getItemCount() - 1) - (r0.getSpanCount() * 3))) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void checkLoadMore() {
        /*
            r6 = this;
            boolean r0 = r6.mEnableLoadMore
            if (r0 == 0) goto L90
            us.pinguo.user.recycler.c r0 = r6.mAdapter
            if (r0 == 0) goto L90
            boolean r0 = r0.isFootShowing()
            if (r0 != 0) goto L90
            us.pinguo.user.recycler.c r0 = r6.mAdapter
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L90
            us.pinguo.user.recycler.c r0 = r6.mAdapter
            boolean r0 = r0.isError()
            if (r0 != 0) goto L90
            us.pinguo.user.recycler.c r0 = r6.mAdapter
            boolean r0 = r0.isLoadingShowing()
            if (r0 == 0) goto L27
            goto L90
        L27:
            androidx.recyclerview.widget.RecyclerView r0 = r6.mRecyclerView
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r0.getLayoutManager()
            boolean r1 = r0 instanceof androidx.recyclerview.widget.LinearLayoutManager
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L45
            androidx.recyclerview.widget.LinearLayoutManager r0 = (androidx.recyclerview.widget.LinearLayoutManager) r0
            int r0 = r0.findLastVisibleItemPosition()
            us.pinguo.user.recycler.c r1 = r6.mAdapter
            int r1 = r1.getItemCount()
            int r1 = r1 - r3
            int r1 = r1 + (-3)
            if (r0 < r1) goto L86
            goto L81
        L45:
            boolean r1 = r0 instanceof androidx.recyclerview.widget.GridLayoutManager
            if (r1 == 0) goto L60
            androidx.recyclerview.widget.GridLayoutManager r0 = (androidx.recyclerview.widget.GridLayoutManager) r0
            int r1 = r0.findLastVisibleItemPosition()
            us.pinguo.user.recycler.c r4 = r6.mAdapter
            int r4 = r4.getItemCount()
            int r4 = r4 - r3
            int r0 = r0.getSpanCount()
            int r0 = r0 * 3
            int r4 = r4 - r0
            if (r1 < r4) goto L86
            goto L81
        L60:
            boolean r1 = r0 instanceof androidx.recyclerview.widget.StaggeredGridLayoutManager
            if (r1 == 0) goto L86
            androidx.recyclerview.widget.StaggeredGridLayoutManager r0 = (androidx.recyclerview.widget.StaggeredGridLayoutManager) r0
            r1 = 0
            int[] r1 = r0.findLastVisibleItemPositions(r1)
            us.pinguo.user.recycler.c r4 = r6.mAdapter
            int r4 = r4.getItemCount()
            int r4 = r4 - r3
            int r0 = r0.getSpanCount()
            int r0 = r0 * 3
            int r4 = r4 - r0
            r0 = 0
        L7a:
            int r5 = r1.length
            if (r0 >= r5) goto L86
            r5 = r1[r0]
            if (r5 < r4) goto L83
        L81:
            r2 = 1
            goto L86
        L83:
            int r0 = r0 + 1
            goto L7a
        L86:
            if (r2 == 0) goto L90
            us.pinguo.user.recycler.c r0 = r6.mAdapter
            r0.showFooter()
            r6.onLoadMore()
        L90:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.inspire.module.publishguide.PublishGuide2Fragment.checkLoadMore():void");
    }

    private void checkShowVideo(View view) {
        if (d.b().getInterface().k()) {
            return;
        }
        view.findViewById(vStudio.Android.Camera360.R.id.publish_guide_video_parent).setVisibility(8);
    }

    private void gotoCamera() {
        PublishManager.launchPublishPage(1, getActivity(), this);
        this.mClickedEntrance = true;
        l.onEvent(Inspire.a(), "Community_SendGuide_Camera_Click");
    }

    private void gotoCameraVideo() {
        PublishManager.launchPublishPage(2, getActivity(), this);
        this.mClickedEntrance = true;
        l.onEvent(Inspire.a(), "video_button_click");
    }

    private void gotoSelfie() {
        PublishManager.launchPublishPage(7, getActivity(), this);
        this.mClickedEntrance = true;
        l.onEvent(Inspire.a(), "selfiecamerafragment_entrypage_click");
    }

    private void initAlbum() {
        this.mMediaAlbum = d.b().getInterface().d();
        onLoadMore();
    }

    private void initRecyclerView() {
        final int dimensionPixelSize = getResources().getDimensionPixelSize(vStudio.Android.Camera360.R.dimen.publish_grid_divider);
        this.mRecyclerView.setLayoutManager(new GridLayoutManager((Context) getActivity(), 2, 0, false));
        this.mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: us.pinguo.inspire.module.publishguide.PublishGuide2Fragment.3
            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
                int i2 = dimensionPixelSize;
                rect.right = i2;
                if ((childAdapterPosition + 1) % 2 == 0) {
                    rect.bottom = 0;
                } else {
                    rect.bottom = i2;
                }
            }
        });
        c cVar = new c();
        this.mAdapter = cVar;
        cVar.setEmptyCell(new PublishGuideEmptyCell(this));
        this.mRecyclerView.setAdapter(this.mAdapter);
        this.mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: us.pinguo.inspire.module.publishguide.PublishGuide2Fragment.4
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                if (i2 != 0) {
                    PublishGuide2Fragment.this.checkLoadMore();
                }
            }
        });
    }

    private void onLoadMore() {
        this.mAdapter.hideFooter();
        addSubscription(this.mMediaAlbum.a(40).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() { // from class: us.pinguo.inspire.module.publishguide.a
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                PublishGuide2Fragment.this.b0((ArrayList) obj);
            }
        }, new Action1() { // from class: us.pinguo.inspire.module.publishguide.b
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                PublishGuide2Fragment.this.d0((Throwable) obj);
            }
        }));
    }

    private void publishPics() {
        if (this.mCheckedList == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (PublishGuideGridCell publishGuideGridCell : this.mCheckedList) {
            arrayList.add(publishGuideGridCell.getData().getFilePath());
        }
        PublishManager.launchPublishPageFromPortal(getActivity(), arrayList, null, this);
    }

    private void publishVideo(String str) {
        PublishManager.launchPublishPageFromPortal(getActivity(), null, str, this);
    }

    @Override // us.pinguo.inspire.module.publishguide.PublishGuideGridCell.OnCheckedListener
    public void onChecked(boolean z, PublishGuideGridCell publishGuideGridCell) {
        PublishMediaItem data = publishGuideGridCell.getData();
        if (!checkFileExist(data.getFilePath())) {
            this.mAdapter.remove(publishGuideGridCell);
            e eVar = this.mMediaAlbum;
            if (eVar != null) {
                eVar.b(data);
            }
        } else if (!TextUtils.isEmpty(data.getFilePath()) && data.getFilePath().toLowerCase().endsWith(Emoticon.TYPE_GIF)) {
            j0.c(R.string.not_support_gif);
        } else if (data.isVideo) {
            publishGuideGridCell.setChecked(false);
            if (this.mCheckedList.size() > 0) {
                j0.c(R.string.photo_pick_video_multi_not_support);
            } else if (data.durationInSec > 60) {
                j0.d(String.format(getResources().getString(R.string.photo_pick_video_time_filter), 60));
            } else {
                publishVideo(data.getFilePath());
            }
        } else if (z && this.mCheckedList.size() == 9) {
            j0.c(vStudio.Android.Camera360.R.string.portal_publish_max);
            publishGuideGridCell.setChecked(false);
        } else {
            if (z) {
                this.mCheckedList.add(publishGuideGridCell);
            } else {
                this.mCheckedList.remove(publishGuideGridCell);
            }
            changePublishBtn();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (j.a(600L)) {
            return;
        }
        int id = view.getId();
        if (id == vStudio.Android.Camera360.R.id.publish_guide_camera) {
            gotoCamera();
            k.b();
        } else if (id == vStudio.Android.Camera360.R.id.publish_guide_selfie) {
            gotoSelfie();
        } else if (id == vStudio.Android.Camera360.R.id.publish_guide_video) {
            gotoCameraVideo();
        } else if (id == vStudio.Android.Camera360.R.id.publish_guide_all_gallery) {
            PublishManager.launchPublishPage(7, getActivity(), this);
            l.onEvent(view.getContext(), "Community_SendGuide_Ablum_Click");
        } else if (id == vStudio.Android.Camera360.R.id.publish_guide_close || id == vStudio.Android.Camera360.R.id.publish_guide_top_cover) {
            getActivity().onBackPressed();
        } else if (id == vStudio.Android.Camera360.R.id.publish_guide_publish) {
            publishPics();
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(vStudio.Android.Camera360.R.layout.publish_guide2_fragment, viewGroup, false);
        final int b = us.pinguo.foundation.t.b.a.b(getResources(), 50.0f);
        ((DragDetectLinearLayout) inflate).setSimpleOnGestureListener(new GestureDetector.SimpleOnGestureListener() { // from class: us.pinguo.inspire.module.publishguide.PublishGuide2Fragment.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                if (motionEvent != null && motionEvent2 != null) {
                    float y = motionEvent2.getY() - motionEvent.getY();
                    if (Math.abs(y) > b && Math.abs(f3) > Math.abs(f2)) {
                        us.pinguo.common.log.a.k("yDis:" + y, new Object[0]);
                        PublishGuide2Fragment.this.getActivity().onBackPressed();
                        return true;
                    }
                }
                return false;
            }
        });
        return inflate;
    }

    public void onEmptyClick() {
        gotoCamera();
    }

    @Override // us.pinguo.inspire.module.feeds.PublishManager.PublishCompleteLister
    public void onPublishCancel() {
    }

    @Override // us.pinguo.inspire.module.feeds.PublishManager.PublishCompleteLister
    public void onPublishComplete(String str) {
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.mClickedEntrance) {
            Object obj = this.mPublishAnim2;
            if (obj != null) {
                ((PublishAnim2) obj).hideNoAnim();
            }
            this.mClickedEntrance = false;
        }
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(final View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.findViewById(vStudio.Android.Camera360.R.id.publish_guide_all_gallery).setOnClickListener(this);
        view.findViewById(vStudio.Android.Camera360.R.id.publish_guide_camera_parent).setOnClickListener(this);
        view.findViewById(vStudio.Android.Camera360.R.id.publish_guide_selfie_parent).setOnClickListener(this);
        view.findViewById(vStudio.Android.Camera360.R.id.publish_guide_video_parent).setOnClickListener(this);
        view.findViewById(vStudio.Android.Camera360.R.id.publish_guide_close).setOnClickListener(this);
        view.findViewById(vStudio.Android.Camera360.R.id.publish_guide_publish_ripple).setOnClickListener(this);
        view.findViewById(vStudio.Android.Camera360.R.id.publish_guide_top_cover).setOnClickListener(this);
        view.setOnClickListener(this);
        checkShowVideo(view);
        this.mPublishAnim = new PublishGuideAnim(view);
        if (v.j()) {
            view.findViewById(vStudio.Android.Camera360.R.id.layout_publish).setVisibility(0);
            this.mRecyclerView = (RecyclerView) view.findViewById(vStudio.Android.Camera360.R.id.publish_guide_recycleview);
            initRecyclerView();
            initAlbum();
            view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: us.pinguo.inspire.module.publishguide.PublishGuide2Fragment.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (view.getHeight() > PublishGuide2Fragment.this.getActivity().getWindow().getDecorView().getHeight() * 0.9d && view.findViewById(vStudio.Android.Camera360.R.id.publish_guide_top_cover).getHeight() == 0 && ((GridLayoutManager) PublishGuide2Fragment.this.mRecyclerView.getLayoutManager()).getSpanCount() > 1) {
                        ViewGroup.LayoutParams layoutParams = PublishGuide2Fragment.this.mRecyclerView.getLayoutParams();
                        layoutParams.height = (int) ((layoutParams.height * 1.0f) / ((GridLayoutManager) PublishGuide2Fragment.this.mRecyclerView.getLayoutManager()).getSpanCount());
                        PublishGuide2Fragment.this.mRecyclerView.setLayoutParams(layoutParams);
                        ((GridLayoutManager) PublishGuide2Fragment.this.mRecyclerView.getLayoutManager()).setSpanCount(1);
                    }
                    if (Build.VERSION.SDK_INT >= 16) {
                        view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                }
            });
            return;
        }
        view.findViewById(vStudio.Android.Camera360.R.id.layout_publish).setVisibility(8);
    }
}
