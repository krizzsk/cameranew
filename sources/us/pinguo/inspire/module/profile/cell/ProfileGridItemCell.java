package us.pinguo.inspire.module.profile.cell;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import java.util.Collections;
import java.util.List;
import rx.functions.Action1;
import us.pinguo.foundation.utils.f0;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.inspire.module.comment.InspireComment;
import us.pinguo.inspire.module.feeds.cell.FeedsPhotoCellProxy;
import us.pinguo.inspire.module.feeds.model.FeedsList;
import us.pinguo.inspire.module.profile.view.ProfilePhotoImageView;
import us.pinguo.inspire.util.transition.TouchScaleInfo;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class ProfileGridItemCell extends us.pinguo.widget.common.cell.recycler.b<InspireWork, GridItemViewHolder> implements View.OnClickListener {
    public static final int TYPE = 4;
    private int mImageHieght;
    private int mImageWidth;

    /* loaded from: classes9.dex */
    public static class GridItemViewHolder extends us.pinguo.widget.common.cell.recycler.c {
        private ProfilePhotoImageView mProfilePhotoImageView;

        public GridItemViewHolder(View view) {
            super(view);
            this.mProfilePhotoImageView = (ProfilePhotoImageView) view.findViewById(R.id.profile_image_view);
        }
    }

    public ProfileGridItemCell(InspireWork inspireWork) {
        super(inspireWork);
        registerUpdateAttentionStatus();
        registerUpdateLikeStatus();
        registerUpdateCommentStatus();
        registerUpdateCommentCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void b(us.pinguo.inspire.event.c cVar) {
        T t = this.mData;
        if (t == 0 || !f0.b(((InspireWork) t).workId, cVar.a)) {
            return;
        }
        ((InspireWork) this.mData).setRelation(cVar.b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c(Throwable th) {
        us.pinguo.foundation.e.e(th);
        d.f.a.b.d.c(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void e(FeedsPhotoCellProxy.InspireCommentEvent inspireCommentEvent) {
        T t = this.mData;
        if (((InspireWork) t).workId == null || ((InspireWork) t).workId.equals(inspireCommentEvent.workId)) {
            if (inspireCommentEvent.add) {
                T t2 = this.mData;
                ((InspireWork) t2).commentSum++;
                if (((InspireWork) t2).commentAndLike == null || ((InspireWork) t2).commentAndLike.comment == null || ((InspireWork) t2).commentAndLike.comment.list == null) {
                    return;
                }
                ((InspireWork) t2).commentAndLike.comment.list.add(inspireCommentEvent.comment);
                Collections.sort(((InspireWork) this.mData).commentAndLike.comment.list);
                return;
            }
            T t3 = this.mData;
            InspireWork inspireWork = (InspireWork) t3;
            inspireWork.commentSum--;
            if (((InspireWork) t3).commentAndLike == null || ((InspireWork) t3).commentAndLike.comment == null || ((InspireWork) t3).commentAndLike.comment.list == null) {
                return;
            }
            ((InspireWork) t3).commentAndLike.comment.list.remove(inspireCommentEvent.comment);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void f(Throwable th) {
        us.pinguo.common.log.a.f(th);
        us.pinguo.foundation.e.e(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public /* synthetic */ void h(us.pinguo.inspire.event.b bVar) {
        T t = this.mData;
        if (t == 0 || !f0.b(((InspireWork) t).workId, bVar.a)) {
            return;
        }
        T t2 = this.mData;
        InspireWork inspireWork = (InspireWork) t2;
        inspireWork.commentSum--;
        if (((InspireWork) t2).commentAndLike == null || ((InspireWork) t2).commentAndLike.comment == null) {
            return;
        }
        List<InspireComment> list = ((InspireWork) t2).commentAndLike.comment.list;
        for (int i2 = 0; list != null && i2 < list.size(); i2++) {
            if (f0.b(list.get(i2).commentId, bVar.b)) {
                list.remove(i2);
                return;
            }
        }
    }

    private ProfilePhotoImageView.TYPE getType(InspireWork inspireWork) {
        int i2 = inspireWork.workType;
        if (i2 == 1) {
            return ProfilePhotoImageView.TYPE.NONE;
        }
        if (i2 == 2) {
            return ProfilePhotoImageView.TYPE.VIDEO;
        }
        return ProfilePhotoImageView.TYPE.MUTIL_PHOTO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public /* synthetic */ void k(us.pinguo.inspire.event.f fVar) {
        T t = this.mData;
        if (t == 0 || !f0.b(((InspireWork) t).workId, fVar.a)) {
            return;
        }
        T t2 = this.mData;
        ((InspireWork) t2).likeSum = fVar.b;
        ((InspireWork) t2).like = fVar.c;
    }

    private void registerUpdateAttentionStatus() {
        us.pinguo.foundation.utils.h.a(us.pinguo.foundation.r.d.a().c(us.pinguo.inspire.event.c.class).subscribe(new Action1() { // from class: us.pinguo.inspire.module.profile.cell.i
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                ProfileGridItemCell.this.b((us.pinguo.inspire.event.c) obj);
            }
        }, f.a));
    }

    private void registerUpdateCommentCount() {
        us.pinguo.foundation.utils.h.a(us.pinguo.foundation.r.d.a().c(FeedsPhotoCellProxy.InspireCommentEvent.class).subscribe(new Action1() { // from class: us.pinguo.inspire.module.profile.cell.l
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                ProfileGridItemCell.this.e((FeedsPhotoCellProxy.InspireCommentEvent) obj);
            }
        }, e.a));
    }

    private void registerUpdateCommentStatus() {
        us.pinguo.foundation.utils.h.a(us.pinguo.foundation.r.d.a().c(us.pinguo.inspire.event.b.class).subscribe(new Action1() { // from class: us.pinguo.inspire.module.profile.cell.j
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                ProfileGridItemCell.this.h((us.pinguo.inspire.event.b) obj);
            }
        }, h.a));
    }

    private void registerUpdateLikeStatus() {
        us.pinguo.foundation.utils.h.a(us.pinguo.foundation.r.d.a().c(us.pinguo.inspire.event.f.class).subscribe(new Action1() { // from class: us.pinguo.inspire.module.profile.cell.k
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                ProfileGridItemCell.this.k((us.pinguo.inspire.event.f) obj);
            }
        }, g.a));
    }

    private void setImageUri(ProfilePhotoImageView profilePhotoImageView, InspireWork inspireWork) {
        ViewCompat.setTransitionName(profilePhotoImageView, us.pinguo.inspire.util.transition.h.a.i((InspireWork) this.mData));
        if (inspireWork.isVideo()) {
            profilePhotoImageView.setVideoImageUrl(inspireWork.getWorkUrl(), inspireWork.width, inspireWork.height, this.mImageWidth, this.mImageHieght);
            profilePhotoImageView.setShowType(getType(inspireWork));
            return;
        }
        List<InspireWork.WorkMember> list = inspireWork.members;
        if (list != null && list.size() > 1) {
            profilePhotoImageView.setShowType(getType(inspireWork), inspireWork.members.size());
        } else {
            profilePhotoImageView.setShowType(getType(inspireWork));
        }
        profilePhotoImageView.setImageUri(inspireWork.getWorkUrl());
    }

    public View getShareElement() {
        VH vh = this.mViewHolder;
        if (vh == 0) {
            return null;
        }
        return ((GridItemViewHolder) vh).mProfilePhotoImageView;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return 4;
    }

    public String getWorkId() {
        return ((InspireWork) this.mData).getWorkId();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (us.pinguo.foundation.utils.j.a(1000L)) {
            return;
        }
        TouchScaleInfo touchScaleInfo = new TouchScaleInfo();
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        Rect rect = new Rect(0, 0, view.getWidth(), view.getHeight());
        touchScaleInfo.bounds = rect;
        rect.offset(iArr[0], iArr[1]);
        touchScaleInfo.workWidth = ((InspireWork) this.mData).getWidth();
        touchScaleInfo.workHeight = ((InspireWork) this.mData).getHeight();
        view.setTag(R.id.tag_element_info, touchScaleInfo);
        FeedsList.enterDetailPage(view.getContext(), "", "", (InspireWork) this.mData, "from_profile", this.mAdapter, this, 0, us.pinguo.inspire.util.transition.h.a.f((Activity) view.getContext(), view));
    }

    public void setSize(ProfilePhotoImageView profilePhotoImageView) {
        Context context = profilePhotoImageView.getContext();
        int j2 = (int) ((us.pinguo.foundation.t.b.a.j(context) - (us.pinguo.foundation.t.b.a.a(context, 3.0f) * 2)) / 3.0f);
        this.mImageWidth = j2;
        this.mImageHieght = j2;
        ViewGroup.LayoutParams layoutParams = profilePhotoImageView.getLayoutParams();
        layoutParams.height = j2;
        layoutParams.width = j2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // us.pinguo.widget.common.cell.recycler.b
    public GridItemViewHolder createViewHolder(ViewGroup viewGroup) {
        return new GridItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.profile_grid_item_cell, viewGroup, false));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.widget.common.cell.recycler.b
    public void onBindViewHolder(GridItemViewHolder gridItemViewHolder) {
        gridItemViewHolder.mProfilePhotoImageView.getContext();
        setSize(gridItemViewHolder.mProfilePhotoImageView);
        gridItemViewHolder.mProfilePhotoImageView.setOnClickListener(this);
        gridItemViewHolder.mProfilePhotoImageView.setShowType(getType((InspireWork) this.mData));
        setImageUri(gridItemViewHolder.mProfilePhotoImageView, (InspireWork) this.mData);
        gridItemViewHolder.mProfilePhotoImageView.setTag(this.mData);
    }
}
