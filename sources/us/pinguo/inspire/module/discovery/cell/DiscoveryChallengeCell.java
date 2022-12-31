package us.pinguo.inspire.module.discovery.cell;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.google.android.material.timepicker.TimeModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import us.pinguo.foundation.statistics.l;
import us.pinguo.foundation.utils.e0;
import us.pinguo.foundation.utils.s;
import us.pinguo.inspire.cell.recycler.f;
import us.pinguo.inspire.model.InspireTask;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.inspire.module.MissionDetail.TaskDetailActivity;
import us.pinguo.inspire.module.discovery.type.DiscoverySquareCellType;
import us.pinguo.inspire.widget.PhotoGridView;
import us.pinguo.ui.uilview.PhotoImageView;
import us.pinguo.widget.common.cell.recycler.c;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class DiscoveryChallengeCell extends us.pinguo.inspire.cell.recycler.a<InspireTask, c> implements View.OnClickListener {
    private static int COLUMN_COUNT = 3;
    private static int PHOTO_SIZE = 6;
    private static int[] mBottomBgs = {R.drawable.challenge_bottom_bg_1, R.drawable.challenge_bottom_bg_2};
    private Runnable changePhotoRunnable;
    private Handler mHandler;
    private boolean mIsFirst;
    private int mType;

    public DiscoveryChallengeCell(InspireTask inspireTask) {
        this(inspireTask, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int changePhotoWithAnim(int i2) {
        int nextInt;
        PhotoGridView photoGridView = (PhotoGridView) this.mViewHolder.getView(R.id.pgv_discovery_challenge_cell);
        do {
            nextInt = new Random().nextInt(PHOTO_SIZE);
        } while (nextInt == i2);
        int toChangeIndex = getToChangeIndex(photoGridView);
        if (toChangeIndex > ((InspireTask) this.mData).work.size() - 1 || nextInt > ((InspireTask) this.mData).work.size() - 1) {
            return -1;
        }
        InspireWork inspireWork = ((InspireTask) this.mData).work.get(toChangeIndex);
        ((InspireTask) this.mData).work.set(nextInt, inspireWork);
        ((InspireTask) this.mData).work.set(toChangeIndex, ((InspireTask) this.mData).work.get(nextInt));
        PhotoGridView.b bVar = new PhotoGridView.b(inspireWork.getWidth(), inspireWork.getHeight(), inspireWork.getWorkUrl(), inspireWork.isVideo());
        convertPhoto(bVar);
        photoGridView.addPushPhoto(bVar, nextInt);
        return nextInt;
    }

    private void convertPhoto(PhotoGridView.b bVar) {
        if (bVar == null || !bVar.f11336d || bVar.a != 1 || bVar.b != 1 || TextUtils.isEmpty(bVar.c) || bVar.c.contains("vframe")) {
            return;
        }
        bVar.c = PhotoImageView.addQiNiuSuffix(bVar.c, 0, 0, true);
    }

    private int getToChangeIndex(PhotoGridView photoGridView) {
        PhotoGridView.b bVar;
        HashMap hashMap = new HashMap();
        for (InspireWork inspireWork : ((InspireTask) this.mData).work) {
            if (inspireWork.getWorkUrl() != null) {
                hashMap.put(inspireWork.getWorkUrl(), inspireWork);
            }
        }
        PhotoGridView.b[] photos = photoGridView.getPhotos();
        List<PhotoGridView.d> pushPhotos = photoGridView.getPushPhotos();
        if (photos != null) {
            for (PhotoGridView.b bVar2 : photos) {
                if (bVar2 != null) {
                    hashMap.remove(bVar2.c);
                }
            }
        }
        if (pushPhotos != null) {
            for (PhotoGridView.d dVar : pushPhotos) {
                if (dVar != null && (bVar = dVar.f11338d) != null) {
                    hashMap.remove(bVar.c);
                }
            }
        }
        Collection values = hashMap.values();
        if (values == null || values.isEmpty()) {
            return 0;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(values);
        return ((InspireTask) this.mData).work.indexOf((InspireWork) arrayList.get(new Random().nextInt(arrayList.size())));
    }

    private void onClickItemView(View view) {
        Intent intent = new Intent(view.getContext(), TaskDetailActivity.class);
        intent.putExtra("task_id", ((InspireTask) this.mData).taskId);
        if (this.mType == DiscoverySquareCellType.CHALLENGE.ordinal()) {
            intent.putExtra("key_from_page", "广场");
        } else {
            intent.putExtra("key_from_page", "首页");
        }
        view.getContext().startActivity(intent);
    }

    private void registerLifeCycleListener() {
        s.a(this, new e0() { // from class: us.pinguo.inspire.module.discovery.cell.DiscoveryChallengeCell.1
            @Override // us.pinguo.foundation.utils.e0, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                DiscoveryChallengeCell discoveryChallengeCell = DiscoveryChallengeCell.this;
                if (discoveryChallengeCell.mViewHolder != 0) {
                    discoveryChallengeCell.stopPushAnim();
                }
            }

            @Override // us.pinguo.foundation.utils.e0, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                DiscoveryChallengeCell discoveryChallengeCell = DiscoveryChallengeCell.this;
                if (discoveryChallengeCell.mViewHolder != 0) {
                    discoveryChallengeCell.resumeAnim();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resumeAnim() {
        Handler handler = this.mHandler;
        if (handler == null || this.mViewHolder == 0) {
            return;
        }
        handler.removeCallbacks(this.changePhotoRunnable);
        this.mHandler.postDelayed(this.changePhotoRunnable, 3000L);
    }

    private void setGridViews(c cVar) {
        cVar.hide(R.id.piv_cover_discovery_challenge_cell);
        cVar.show(R.id.pgv_discovery_challenge_cell);
        PhotoGridView photoGridView = (PhotoGridView) cVar.getView(R.id.pgv_discovery_challenge_cell);
        int i2 = 0;
        photoGridView.setGridMarginPx(0);
        photoGridView.setOnClickListener(this);
        T t = this.mData;
        if (((InspireTask) t).work == null) {
            ((InspireTask) t).work = new ArrayList();
        }
        photoGridView.setColumn(PHOTO_SIZE);
        ArrayList<InspireWork> arrayList = new ArrayList();
        int size = ((InspireTask) this.mData).work.size();
        int i3 = PHOTO_SIZE;
        if (size <= i3) {
            InspireWork inspireWork = new InspireWork();
            while (((InspireTask) this.mData).work.size() < PHOTO_SIZE) {
                ((InspireTask) this.mData).work.add(inspireWork);
            }
            arrayList.addAll(((InspireTask) this.mData).work);
        } else {
            arrayList.addAll(((InspireTask) this.mData).work.subList(0, i3));
            this.mHandler.removeCallbacks(this.changePhotoRunnable);
            this.mHandler.postDelayed(this.changePhotoRunnable, 3000L);
        }
        PhotoGridView.b[] bVarArr = new PhotoGridView.b[arrayList.size()];
        for (InspireWork inspireWork2 : arrayList) {
            PhotoGridView.b bVar = new PhotoGridView.b(inspireWork2.getWidth(), inspireWork2.getHeight(), inspireWork2.getWorkUrl(), inspireWork2.isVideo());
            convertPhoto(bVar);
            bVarArr[i2] = bVar;
            i2++;
        }
        photoGridView.clearPushPhotos();
        photoGridView.setColumn(COLUMN_COUNT);
        photoGridView.setPhotos(bVarArr, 100);
    }

    private void setPhotos(c cVar) {
        T t = this.mData;
        if (((InspireTask) t).work != null && ((InspireTask) t).work.size() >= PHOTO_SIZE) {
            setGridViews(cVar);
            return;
        }
        int j2 = us.pinguo.foundation.t.b.a.j(cVar.itemView.getContext()) - us.pinguo.foundation.t.b.a.a(cVar.itemView.getContext(), 24.0f);
        f.e(cVar, R.id.piv_cover_discovery_challenge_cell, ((InspireTask) this.mData).taskCover, j2, (j2 * 2) / 3);
        cVar.show(R.id.piv_cover_discovery_challenge_cell);
        cVar.hide(R.id.pgv_discovery_challenge_cell);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPushAnim() {
        PhotoGridView photoGridView;
        VH vh = this.mViewHolder;
        if (vh != 0 && (photoGridView = (PhotoGridView) vh.getView(R.id.pgv_discovery_challenge_cell)) != null) {
            photoGridView.clearPushPhotos();
        }
        this.mHandler.removeCallbacks(this.changePhotoRunnable);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public c createViewHolder(ViewGroup viewGroup) {
        return createHolderByLayout(R.layout.discovery_challenge_cell, viewGroup);
    }

    @Override // us.pinguo.inspire.cell.recycler.a
    protected String getShowKey() {
        return "Community_Portal_Feed_Show";
    }

    @Override // us.pinguo.inspire.cell.recycler.a
    protected String getTimeKey() {
        return null;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return this.mType;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    protected void onBindViewHolder(c cVar) {
        ViewGroup.LayoutParams layoutParams = cVar.itemView.getLayoutParams();
        if (layoutParams != null && (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams)) {
            ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
        }
        cVar.setOnClickListener(R.id.ll_item_view_challenge_cell, this);
        cVar.setOnClickListener(R.id.ll_container_more_challenge_cell, this);
        cVar.setText(R.id.tv_title_discovery_challenge_cell, ((InspireTask) this.mData).taskName);
        cVar.setText(R.id.tv_desc_discovery_challenge_cell, ((InspireTask) this.mData).shortDesc);
        cVar.setText(R.id.tv_challengers_discovery_challenge_cell, cVar.itemView.getContext().getString(R.string.join_task_num, String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(((InspireTask) this.mData).picSum))));
        T t = this.mData;
        if (((InspireTask) t).authorInfo != null) {
            if (((InspireTask) t).authorInfo.size() > 0 && ((InspireTask) this.mData).picSum > 0) {
                cVar.show(R.id.civ_avatar_0_challenge_cell);
                f.c(cVar, R.id.civ_avatar_0_challenge_cell, ((InspireTask) this.mData).authorInfo.get(0).avatar);
            } else {
                cVar.setText(R.id.tv_challengers_discovery_challenge_cell, cVar.itemView.getContext().getString(R.string.participate_challenge));
                cVar.hide(R.id.civ_avatar_0_challenge_cell);
                cVar.hide(R.id.civ_avatar_1_challenge_cell);
                cVar.hide(R.id.civ_avatar_2_challenge_cell);
            }
            if (((InspireTask) this.mData).authorInfo.size() > 1 && ((InspireTask) this.mData).picSum > 1) {
                cVar.show(R.id.civ_avatar_0_challenge_cell);
                f.c(cVar, R.id.civ_avatar_1_challenge_cell, ((InspireTask) this.mData).authorInfo.get(1).avatar);
            } else {
                cVar.hide(R.id.civ_avatar_1_challenge_cell);
                cVar.hide(R.id.civ_avatar_2_challenge_cell);
            }
            if (((InspireTask) this.mData).authorInfo.size() > 2 && ((InspireTask) this.mData).picSum > 2) {
                cVar.show(R.id.civ_avatar_0_challenge_cell);
                f.c(cVar, R.id.civ_avatar_2_challenge_cell, ((InspireTask) this.mData).authorInfo.get(2).avatar);
            } else {
                cVar.hide(R.id.civ_avatar_2_challenge_cell);
            }
        }
        if (this.mIsFirst) {
            cVar.show(R.id.ll_container_more_challenge_cell);
        } else {
            cVar.hide(R.id.ll_container_more_challenge_cell);
        }
        if (this.mIsFirst && this.mType == DiscoverySquareCellType.CHALLENGE.ordinal()) {
            cVar.hide(R.id.v_divider_challenge_cell);
        } else {
            cVar.show(R.id.v_divider_challenge_cell);
        }
        setPhotos(cVar);
        cVar.setOnClickListener(R.id.view_more_challenge_cell, this);
        int indexOf = this.mAdapter.indexOf(this);
        int[] iArr = mBottomBgs;
        cVar.setBackgroundRes(R.id.ll_bottom_bg_challenge_cell, iArr[indexOf % iArr.length]);
        if (this.mType == DiscoverySquareCellType.CHALLENGE.ordinal()) {
            Context context = cVar.itemView.getContext();
            l.onEvent(context, "Community_Challenge_Show", "challenge_id=" + ((InspireTask) this.mData).taskId);
        }
        registerLifeCycleListener();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mType == DiscoverySquareCellType.CHALLENGE.ordinal()) {
            Context context = view.getContext();
            l.onEvent(context, "Community_Challenge_Click", "challenge_id =" + ((InspireTask) this.mData).taskId);
        } else {
            l.c("Feed_DetailClick", getStat());
        }
        onClickItemView(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.widget.common.cell.recycler.b
    public void onDestroyView() {
        super.onDestroyView();
        stopPushAnim();
        s.b(this);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b, us.pinguo.widget.common.cell.recycler.c.a
    public void onViewRecycled() {
        super.onViewRecycled();
        stopPushAnim();
        s.b(this);
    }

    protected void releasePhotos(c cVar) {
        PhotoGridView photoGridView = (PhotoGridView) cVar.getView(R.id.pgv_discovery_challenge_cell);
        if (photoGridView.isShown()) {
            photoGridView.setPhotos(null);
            photoGridView.clearPushPhotos();
            return;
        }
        ((PhotoImageView) cVar.getView(R.id.piv_cover_discovery_challenge_cell)).setImageBitmap(null);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public void releaseResource() {
        c cVar = this.mViewHolder;
        if (cVar == null) {
            return;
        }
        releasePhotos(cVar);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public void reloadResource() {
        if (this.mViewHolder == 0) {
            return;
        }
        us.pinguo.common.log.a.k("重新加载图片资源", new Object[0]);
        setPhotos(this.mViewHolder);
    }

    public DiscoveryChallengeCell(InspireTask inspireTask, boolean z) {
        super(inspireTask);
        this.mHandler = new Handler();
        this.changePhotoRunnable = new Runnable() { // from class: us.pinguo.inspire.module.discovery.cell.DiscoveryChallengeCell.2
            @Override // java.lang.Runnable
            public void run() {
                if (DiscoveryChallengeCell.this.mViewHolder == 0) {
                    return;
                }
                if (new Random().nextInt(2) == 0) {
                    DiscoveryChallengeCell.this.changePhotoWithAnim(-1);
                } else {
                    DiscoveryChallengeCell.this.changePhotoWithAnim(DiscoveryChallengeCell.this.changePhotoWithAnim(-1));
                }
                DiscoveryChallengeCell.this.mHandler.postDelayed(DiscoveryChallengeCell.this.changePhotoRunnable, 3000L);
            }
        };
        this.mIsFirst = z;
        this.mType = DiscoverySquareCellType.CHALLENGE.ordinal();
    }

    public DiscoveryChallengeCell(InspireTask inspireTask, int i2, boolean z) {
        super(inspireTask);
        this.mHandler = new Handler();
        this.changePhotoRunnable = new Runnable() { // from class: us.pinguo.inspire.module.discovery.cell.DiscoveryChallengeCell.2
            @Override // java.lang.Runnable
            public void run() {
                if (DiscoveryChallengeCell.this.mViewHolder == 0) {
                    return;
                }
                if (new Random().nextInt(2) == 0) {
                    DiscoveryChallengeCell.this.changePhotoWithAnim(-1);
                } else {
                    DiscoveryChallengeCell.this.changePhotoWithAnim(DiscoveryChallengeCell.this.changePhotoWithAnim(-1));
                }
                DiscoveryChallengeCell.this.mHandler.postDelayed(DiscoveryChallengeCell.this.changePhotoRunnable, 3000L);
            }
        };
        this.mType = i2;
        this.mIsFirst = z;
    }
}
