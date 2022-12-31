package us.pinguo.inspire.module.feeds.cell;

import android.content.Intent;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.growingio.android.sdk.collection.Constants;
import java.util.List;
import us.pinguo.foundation.statistics.FeedStat;
import us.pinguo.foundation.statistics.l;
import us.pinguo.inspire.model.InspireTask;
import us.pinguo.inspire.module.MissionDetail.TaskDetailActivity;
import us.pinguo.inspire.module.discovery.entity.InspireFeed;
import us.pinguo.inspire.module.discovery.entity.InspireFeedPhoto;
import us.pinguo.inspire.module.discovery.entity.InspireFeedSender;
import us.pinguo.inspire.module.discovery.entity.InspireTaskCnt;
import us.pinguo.inspire.util.p;
import us.pinguo.inspire.widget.PhotoGridView;
import us.pinguo.widet.PortraitImageView;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class FeedsTaskCellProxy implements View.OnClickListener, PhotoGridView.a, View.OnTouchListener {
    protected static final int COVER_HEIGHT = 550;
    protected static final int COVER_WIDTH = 750;
    private InspireFeed mData;
    private long mDataCalcuTime;
    private FeedStat mStat;
    private us.pinguo.widget.common.cell.recycler.c mViewHolder;

    public FeedsTaskCellProxy(InspireFeed inspireFeed) {
        this.mData = inspireFeed;
    }

    private void intentToDetail(View view) {
        InspireTaskCnt inspireTaskCnt;
        InspireTask inspireTask;
        InspireFeed inspireFeed = this.mData;
        if (inspireFeed == null || (inspireTaskCnt = inspireFeed.latestTaskCnt) == null || (inspireTask = inspireTaskCnt.task) == null || TextUtils.isEmpty(inspireTask.taskId)) {
            return;
        }
        String str = this.mData.latestTaskCnt.task.taskId;
        Intent intent = new Intent(view.getContext(), TaskDetailActivity.class);
        intent.putExtra("key_from_page", "首页");
        intent.putExtra("task_id", str);
        view.getContext().startActivity(intent);
    }

    private void setContent(TextView textView) {
        if (TextUtils.isEmpty(this.mData.latestTaskCnt.desc)) {
            textView.setVisibility(8);
            return;
        }
        if (textView.getVisibility() != 0) {
            textView.setVisibility(0);
        }
        InspireTask inspireTask = this.mData.latestTaskCnt.task;
        String str = inspireTask == null ? "" : inspireTask.taskName;
        String string = textView.getResources().getString(R.string.feeds_photo_chanllenge);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(-10053940);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        SpannableString spannableString = new SpannableString(Constants.ID_PREFIX + string + Constants.ID_PREFIX);
        spannableString.setSpan(foregroundColorSpan, 0, spannableString.length(), 33);
        spannableStringBuilder.append((CharSequence) spannableString);
        textView.setText(spannableStringBuilder);
    }

    public us.pinguo.widget.common.cell.recycler.c createViewHolder(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.feeds_task_layout, viewGroup, false);
        inflate.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return new us.pinguo.widget.common.cell.recycler.c(inflate);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onBindViewHolder(us.pinguo.widget.common.cell.recycler.c cVar) {
        this.mViewHolder = cVar;
        InspireFeed inspireFeed = this.mData;
        if (inspireFeed == null || inspireFeed.latestTaskCnt == null) {
            return;
        }
        if (getClass().equals(FeedsTaskCellProxy.class)) {
            cVar.getView(R.id.feeds_task_video).setVisibility(8);
            cVar.getView(R.id.feeds_task_photo).setVisibility(0);
        } else {
            cVar.getView(R.id.feeds_task_video).setVisibility(0);
            cVar.getView(R.id.feeds_task_photo).setVisibility(8);
        }
        PortraitImageView portraitImageView = (PortraitImageView) cVar.getView(R.id.feeds_task_avatar);
        InspireFeedSender inspireFeedSender = this.mData.sender;
        portraitImageView.setImageUri((inspireFeedSender == null || (r1 = inspireFeedSender.avatar) == null) ? "" : "");
        InspireFeedSender inspireFeedSender2 = this.mData.sender;
        portraitImageView.setUserId(inspireFeedSender2 == null ? null : inspireFeedSender2.userId);
        InspireFeedSender inspireFeedSender3 = this.mData.sender;
        portraitImageView.setUserType(inspireFeedSender3 == null ? 0 : inspireFeedSender3.type);
        InspireFeedSender inspireFeedSender4 = this.mData.sender;
        portraitImageView.setMark(inspireFeedSender4 != null ? inspireFeedSender4.mark : 0);
        portraitImageView.setBeforeOnClickListener(this);
        InspireFeedSender inspireFeedSender5 = this.mData.sender;
        cVar.setText(R.id.feeds_task_name, (inspireFeedSender5 == null || (r1 = inspireFeedSender5.nickname) == null) ? "" : "");
        setContent((TextView) cVar.getView(R.id.feeds_task_content));
        setPhotos(cVar);
        cVar.setText(R.id.feeds_task_time, p.f(cVar.itemView.getContext(), this.mData.timeline * 1000, System.currentTimeMillis()));
        cVar.setText(R.id.feeds_task_count_txt, this.mData.latestTaskCnt.challengeCount + "");
        cVar.setText(R.id.feeds_task_browse_num, this.mData.latestTaskCnt.browseCount + "");
        cVar.itemView.setOnClickListener(this);
        cVar.getView(R.id.feeds_task_enter).setOnClickListener(this);
        cVar.getView(R.id.feeds_task_enter).setOnTouchListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FeedStat feedStat;
        int id = view.getId();
        if (id == R.id.feeds_task_avatar) {
            FeedStat feedStat2 = this.mStat;
            if (feedStat2 != null) {
                l.c("Feed_OwnerInfoClick", feedStat2);
                return;
            }
            return;
        }
        intentToDetail(view);
        if (id != R.id.feeds_task_enter || this.mData == null || (feedStat = this.mStat) == null) {
            return;
        }
        l.c("Feed_ButtonClick", feedStat);
    }

    @Override // us.pinguo.inspire.widget.PhotoGridView.a
    public void onItemClick(PhotoGridView photoGridView, int i2) {
        intentToDetail(photoGridView);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            Rect rect = new Rect();
            view.getHitRect(rect);
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (x < rect.left || x > rect.right || y < rect.top || y > rect.bottom) {
            }
        }
        return false;
    }

    public void onViewRecycled() {
        this.mViewHolder = null;
    }

    public void releaseResource(us.pinguo.widget.common.cell.recycler.c cVar) {
    }

    public void reloadResource(us.pinguo.widget.common.cell.recycler.c cVar) {
    }

    protected void setPhotos(us.pinguo.widget.common.cell.recycler.c cVar) {
        PhotoGridView photoGridView = (PhotoGridView) cVar.getView(R.id.feeds_task_photo);
        List<InspireFeedPhoto> list = this.mData.latestTaskCnt.photos;
        if (list != null && list.size() != 0) {
            if (photoGridView.getVisibility() != 0) {
                photoGridView.setVisibility(0);
            }
            PhotoGridView.b[] bVarArr = new PhotoGridView.b[1];
            for (int i2 = 0; i2 < 1; i2++) {
                InspireFeedPhoto inspireFeedPhoto = this.mData.latestTaskCnt.photos.get(0);
                int i3 = inspireFeedPhoto.width;
                if (i3 <= 0) {
                    i3 = COVER_WIDTH;
                }
                int i4 = inspireFeedPhoto.height;
                if (i4 <= 0) {
                    i4 = COVER_HEIGHT;
                }
                String str = inspireFeedPhoto.url;
                if (str == null) {
                    str = "";
                }
                bVarArr[i2] = new PhotoGridView.b(i3, i4, str);
            }
            if (photoGridView.getVisibility() != 0) {
                photoGridView.setVisibility(0);
            }
            photoGridView.setPhotos(bVarArr);
            photoGridView.forceLayout();
            photoGridView.setOnClickListener(this);
            photoGridView.setOnItemClick(this);
            return;
        }
        photoGridView.setVisibility(4);
    }

    public void setStat(FeedStat feedStat) {
        this.mStat = feedStat;
    }

    public void updateData(InspireFeed inspireFeed) {
        this.mData = inspireFeed;
    }
}
