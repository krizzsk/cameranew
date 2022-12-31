package us.pinguo.inspire.module.publishguide;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.nostra13.universalimageloader.core.assist.FailReason;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import us.pinguo.foundation.base.InspireBaseActivity;
import us.pinguo.foundation.domain.PublishMediaItem;
import us.pinguo.foundation.t.a.h;
import us.pinguo.inspire.module.discovery.entity.InspireFeedPhoto;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
import us.pinguo.inspire.util.y;
import us.pinguo.inspire.widget.photopager.FullScreenPhoto;
import us.pinguo.inspire.widget.photopager.PictureViewPagerDialogFragment;
import us.pinguo.inspire_proxy.media.e;
import us.pinguo.ui.uilview.PhotoImageView;
import us.pinguo.widget.common.cell.recycler.c;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class PublishGuideGridCell extends us.pinguo.widget.common.cell.recycler.b<PublishMediaItem, c> implements View.OnClickListener {
    private boolean mChecked;
    private OnCheckedListener mOnCheckedListener;
    private boolean mRecycled;
    private com.nostra13.universalimageloader.core.k.c mSimpleImageLoadingListener;

    /* loaded from: classes9.dex */
    public interface OnCheckedListener {
        void onChecked(boolean z, PublishGuideGridCell publishGuideGridCell);
    }

    public PublishGuideGridCell(PublishMediaItem publishMediaItem) {
        super(publishMediaItem);
        this.mSimpleImageLoadingListener = new com.nostra13.universalimageloader.core.k.c() { // from class: us.pinguo.inspire.module.publishguide.PublishGuideGridCell.1
            @Override // com.nostra13.universalimageloader.core.k.c, com.nostra13.universalimageloader.core.k.a
            public void onLoadingFailed(String str, View view, FailReason failReason) {
                super.onLoadingFailed(str, view, failReason);
                if (PublishGuideGridCell.this.mRecycled) {
                    us.pinguo.common.log.a.k("onLoadingFailed:" + str + " cell已回收，不再重试", new Object[0]);
                } else if (PublishGuideGridCell.this.mViewHolder == 0 || failReason == null || !FailReason.FailType.IO_ERROR.equals(failReason.b())) {
                } else {
                    us.pinguo.common.log.a.k("onLoadingFailed:" + str + " 可能大图没做好，尝试重新加载", new Object[0]);
                    PublishGuideGridCell publishGuideGridCell = PublishGuideGridCell.this;
                    publishGuideGridCell.loadPhoto(publishGuideGridCell.mViewHolder);
                }
            }
        };
    }

    private String getUri(PublishMediaItem publishMediaItem) {
        return InspirePublishFragment.FILE_HEADER + publishMediaItem.getFilePath();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadPhoto(c cVar) {
        PhotoImageView photoImageView = (PhotoImageView) cVar.getView(R.id.publish_guide_item_img);
        photoImageView.setSimpleImageLoadingListener(this.mSimpleImageLoadingListener);
        T t = this.mData;
        if (((PublishMediaItem) t).isVideo) {
            photoImageView.setLocalVideoUri(getUri((PublishMediaItem) t));
        } else {
            photoImageView.setImageUri(getUri((PublishMediaItem) t));
        }
        photoImageView.setOnClickListener(this);
    }

    private void onCheckClick() {
        setChecked(!this.mChecked);
        OnCheckedListener onCheckedListener = this.mOnCheckedListener;
        if (onCheckedListener != null) {
            onCheckedListener.onChecked(this.mChecked, this);
        }
    }

    private void setCheckState() {
        VH vh = this.mViewHolder;
        if (vh != 0) {
            vh.setImageResource(R.id.publish_guide_item_check, this.mChecked ? R.drawable.publish_guide_select : R.drawable.publish_guide_unselected);
        }
    }

    private void toDetail(View view) {
        Bitmap a;
        if (((PublishMediaItem) this.mData).isVideo) {
            e.j(view.getContext(), ((PublishMediaItem) this.mData).getFilePath()).a((InspireBaseActivity) view.getContext());
            return;
        }
        final PhotoImageView photoImageView = (PhotoImageView) view;
        Bitmap[] bitmapArr = null;
        Drawable drawable = photoImageView.getDrawable();
        if ((drawable instanceof h) && (a = ((h) drawable).a()) != null) {
            bitmapArr = new Bitmap[]{a};
        }
        Rect rect = new Rect();
        int[] iArr = new int[2];
        photoImageView.getLocationInWindow(iArr);
        rect.set(iArr[0], iArr[1], iArr[0] + photoImageView.getWidth(), iArr[1] + photoImageView.getHeight());
        ArrayList arrayList = new ArrayList();
        FullScreenPhoto fullScreenPhoto = new FullScreenPhoto();
        fullScreenPhoto.rect = rect;
        InspireFeedPhoto inspireFeedPhoto = new InspireFeedPhoto();
        fullScreenPhoto.photo = inspireFeedPhoto;
        inspireFeedPhoto.url = InspirePublishFragment.FILE_HEADER + ((PublishMediaItem) this.mData).getFilePath();
        fullScreenPhoto.photo.width = ((PublishMediaItem) this.mData).getWidth();
        fullScreenPhoto.photo.height = ((PublishMediaItem) this.mData).getHeight();
        arrayList.add(fullScreenPhoto);
        PictureViewPagerDialogFragment.showFullScreenPics(((FragmentActivity) view.getContext()).getSupportFragmentManager(), bitmapArr, arrayList, 0, new PictureViewPagerDialogFragment.c() { // from class: us.pinguo.inspire.module.publishguide.PublishGuideGridCell.2
            @Override // us.pinguo.inspire.widget.photopager.PictureViewPagerDialogFragment.c
            public Rect getPicRect(int i2) {
                Rect rect2 = new Rect();
                int[] iArr2 = new int[2];
                photoImageView.getLocationInWindow(iArr2);
                rect2.set(iArr2[0], iArr2[1], iArr2[0] + photoImageView.getWidth(), iArr2[1] + photoImageView.getHeight());
                return rect2;
            }
        });
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public c createViewHolder(ViewGroup viewGroup) {
        Resources resources = viewGroup.getResources();
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.publish_guide_item, viewGroup, false);
        PhotoImageView photoImageView = (PhotoImageView) inflate.findViewById(R.id.publish_guide_item_img);
        photoImageView.setCacheOnDisc(false);
        photoImageView.setLoadingColor(resources.getColor(us.pinguo.ui.R.color.inspire_loading_color));
        photoImageView.setImgCenterCrop(false);
        return new c(inflate);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return 0;
    }

    public boolean isChecked() {
        return this.mChecked;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    protected void onBindViewHolder(c cVar) {
        this.mRecycled = false;
        setCheckState();
        View view = cVar.getView(R.id.publish_guide_item_video_layout);
        T t = this.mData;
        if (((PublishMediaItem) t).isVideo) {
            String durationStr = ((PublishMediaItem) t).getDurationStr();
            if (durationStr == null) {
                try {
                    durationStr = new SimpleDateFormat("mm:ss").format(y.a(((PublishMediaItem) this.mData).getFilePath()));
                } catch (Exception e2) {
                    us.pinguo.common.log.a.f(e2);
                }
            }
            us.pinguo.common.log.a.k("durationStr:" + durationStr, new Object[0]);
            cVar.setText(R.id.publish_guide_item_video_txt, durationStr);
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
        loadPhoto(cVar);
        cVar.getView(R.id.publish_guide_item_check).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.publish_guide_item_check) {
            onCheckClick();
        } else if (view.getId() == R.id.publish_guide_item_img) {
            toDetail(view);
        }
    }

    @Override // us.pinguo.widget.common.cell.recycler.b, us.pinguo.widget.common.cell.recycler.c.a
    public void onViewRecycled() {
        super.onViewRecycled();
        this.mRecycled = true;
    }

    public void setChecked(boolean z) {
        this.mChecked = z;
        setCheckState();
    }

    public void setOnCheckedListener(OnCheckedListener onCheckedListener) {
        this.mOnCheckedListener = onCheckedListener;
    }
}
