package us.pinguo.inspire.module.discovery.cell.niceuser;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.pinguo.camera360.effect.model.entity.param.ParamItem;
import java.util.ArrayList;
import java.util.List;
import us.pinguo.foundation.utils.k;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.cell.recycler.e;
import us.pinguo.inspire.cell.recycler.f;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.inspire.module.discovery.entity.InspireFeedPhoto;
import us.pinguo.inspire.module.discovery.entity.niceuser.NiceUser;
import us.pinguo.inspire.module.publish.PublishGridView;
import us.pinguo.inspire.widget.AttentionButton;
import us.pinguo.inspire.widget.photopager.FullScreenPhoto;
import us.pinguo.inspire.widget.photopager.PictureViewPagerDialogFragment;
import us.pinguo.user.model.IRelation;
import us.pinguo.widet.PortraitImageView;
import us.pinguo.widget.common.cell.recycler.c;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class NiceUserCell extends e<NiceUser, c> implements View.OnClickListener, PublishGridView.OnItemClick {
    private int mScreenWidth;

    public NiceUserCell(NiceUser niceUser) {
        super(niceUser);
        this.mScreenWidth = us.pinguo.foundation.t.b.a.j(Inspire.a());
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public c createViewHolder(ViewGroup viewGroup) {
        return createHolderByLayout(R.layout.nice_user_cell, viewGroup);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return 0;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    protected void onBindViewHolder(c cVar) {
        int a = this.mScreenWidth - us.pinguo.foundation.t.b.a.a(cVar.itemView.getContext(), 24.0f);
        int i2 = (a * 112) / 344;
        if (TextUtils.isEmpty(((NiceUser) this.mData).cover)) {
            ((NiceUser) this.mData).cover = ParamItem.DRAWABLE_PREFIX + us.pinguo.user.R.drawable.profile_header_default_bg;
        }
        f.e(cVar, R.id.piv_cover_nice_user_cell, ((NiceUser) this.mData).cover, a, i2);
        T t = this.mData;
        ((AttentionButton) cVar.getView(R.id.ab_nice_user_cell)).k((IRelation) t, false, ((NiceUser) t).userId, this);
        f.c(cVar, R.id.piv_portrait_nice_user_cell, ((NiceUser) this.mData).avatar);
        PortraitImageView portraitImageView = (PortraitImageView) cVar.getView(R.id.piv_portrait_nice_user_cell);
        portraitImageView.setUserId(((NiceUser) this.mData).userId);
        portraitImageView.setUserType(((NiceUser) this.mData).type);
        portraitImageView.setMark(((NiceUser) this.mData).mark);
        cVar.setText(R.id.tv_nickname_nice_user_cell, ((NiceUser) this.mData).nickname);
        cVar.setText(R.id.tv_desc_nice_user_cell, ((NiceUser) this.mData).desc);
        PublishGridView publishGridView = (PublishGridView) cVar.getView(R.id.pgv_nice_user_cell);
        if (k.a(((NiceUser) this.mData).work)) {
            publishGridView.setVisibility(8);
        } else {
            publishGridView.setColumn(3);
            publishGridView.setWorks(((NiceUser) this.mData).work);
            publishGridView.setVisibility(0);
        }
        publishGridView.setOnItemClick(this);
        cVar.itemView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        T t;
        if ((view != this.mViewHolder.itemView && view.getId() != R.id.pgv_nice_user_cell) || this.mViewHolder == 0 || (t = this.mData) == 0 || TextUtils.isEmpty(((NiceUser) t).userId)) {
            return;
        }
        PortraitImageView.f(view.getContext(), ((NiceUser) this.mData).userId);
    }

    @Override // us.pinguo.inspire.module.publish.PublishGridView.OnItemClick
    public void onItemClick(View view, final int i2) {
        T t = this.mData;
        if (t == 0 || ((NiceUser) t).work == null || ((NiceUser) t).work.size() <= i2) {
            return;
        }
        final PublishGridView publishGridView = (PublishGridView) view;
        InspireWork inspireWork = ((NiceUser) this.mData).work.get(i2);
        if (!inspireWork.isVideo()) {
            ArrayList arrayList = new ArrayList();
            List<InspireWork.WorkMember> list = inspireWork.members;
            int size = list == null ? 0 : list.size();
            if (size > 9) {
                size = 9;
            }
            if (inspireWork.isMulityPhotos()) {
                for (int i3 = 0; i3 < size; i3++) {
                    InspireWork.WorkMember workMember = inspireWork.members.get(i3);
                    InspireFeedPhoto inspireFeedPhoto = new InspireFeedPhoto();
                    inspireFeedPhoto.url = workMember.memUrl;
                    inspireFeedPhoto.width = workMember.width;
                    inspireFeedPhoto.height = workMember.height;
                    FullScreenPhoto fullScreenPhoto = new FullScreenPhoto();
                    fullScreenPhoto.photo = inspireFeedPhoto;
                    fullScreenPhoto.rect = publishGridView.getItemBoundsInWindow(i2);
                    arrayList.add(fullScreenPhoto);
                }
            } else {
                InspireFeedPhoto inspireFeedPhoto2 = new InspireFeedPhoto();
                inspireFeedPhoto2.url = inspireWork.getWorkUrl();
                inspireFeedPhoto2.width = inspireWork.width;
                inspireFeedPhoto2.height = inspireWork.height;
                FullScreenPhoto fullScreenPhoto2 = new FullScreenPhoto();
                fullScreenPhoto2.photo = inspireFeedPhoto2;
                fullScreenPhoto2.rect = publishGridView.getItemBoundsInWindow(i2);
                arrayList.add(fullScreenPhoto2);
            }
            PictureViewPagerDialogFragment.showFullScreenPics(((FragmentActivity) view.getContext()).getSupportFragmentManager(), new Bitmap[]{publishGridView.getBitmap(i2)}, arrayList, 0, new PictureViewPagerDialogFragment.c() { // from class: us.pinguo.inspire.module.discovery.cell.niceuser.a
                @Override // us.pinguo.inspire.widget.photopager.PictureViewPagerDialogFragment.c
                public final Rect getPicRect(int i4) {
                    Rect itemBoundsInWindow;
                    itemBoundsInWindow = PublishGridView.this.getItemBoundsInWindow(i2);
                    return itemBoundsInWindow;
                }
            });
            return;
        }
        String workUrl = inspireWork.getWorkUrl();
        if (TextUtils.isEmpty(workUrl)) {
            return;
        }
        us.pinguo.inspire_proxy.media.e.l(publishGridView.getContext(), Uri.parse(workUrl));
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public void reloadResource() {
    }
}
