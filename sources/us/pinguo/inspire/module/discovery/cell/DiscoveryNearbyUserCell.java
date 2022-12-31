package us.pinguo.inspire.module.discovery.cell;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import rx.Subscription;
import rx.functions.Action1;
import us.pinguo.foundation.r.d;
import us.pinguo.inspire.cell.recycler.e;
import us.pinguo.inspire.module.contact.RecommendPhotoView;
import us.pinguo.inspire.module.discovery.entity.nearby.NearbyUser;
import us.pinguo.inspire.util.l;
import us.pinguo.inspire.widget.AttentionButton;
import us.pinguo.user.model.IRelation;
import us.pinguo.widet.PortraitImageView;
import us.pinguo.widget.common.cell.recycler.c;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class DiscoveryNearbyUserCell extends e<NearbyUser, c> implements View.OnClickListener {
    private Subscription mAttentionSubscription;

    public DiscoveryNearbyUserCell(NearbyUser nearbyUser) {
        super(nearbyUser);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void b(us.pinguo.inspire.event.a aVar) {
        T t = this.mData;
        if (t == 0 || ((NearbyUser) t).userId == null || !((NearbyUser) t).userId.equals(aVar.a)) {
            return;
        }
        ((NearbyUser) this.mData).relation = aVar.b;
        ((AttentionButton) this.mViewHolder.getView(R.id.ab_attention_include_user)).setTextByRelation();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c(Throwable th) {
        us.pinguo.foundation.e.e(th);
        us.pinguo.common.log.a.f(th);
    }

    private void listenAttentionEvent() {
        if (this.mAttentionSubscription == null) {
            Subscription subscribe = d.a().c(us.pinguo.inspire.event.a.class).subscribe(new Action1() { // from class: us.pinguo.inspire.module.discovery.cell.b
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    DiscoveryNearbyUserCell.this.b((us.pinguo.inspire.event.a) obj);
                }
            }, a.a);
            this.mAttentionSubscription = subscribe;
            addSubscription(subscribe);
        }
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public c createViewHolder(ViewGroup viewGroup) {
        return createHolderByLayout(R.layout.nearby_user_cell, viewGroup);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return 0;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    protected void onBindViewHolder(c cVar) {
        PortraitImageView portraitImageView = (PortraitImageView) cVar.getView(R.id.piv_portrait_include_user);
        portraitImageView.setImageUri(((NearbyUser) this.mData).avatar, us.pinguo.ui.R.drawable.default_avatar);
        portraitImageView.setUserId(((NearbyUser) this.mData).userId);
        portraitImageView.setUserType(((NearbyUser) this.mData).type);
        portraitImageView.setMark(((NearbyUser) this.mData).mark);
        cVar.setText(R.id.tv_nickname_include_user, ((NearbyUser) this.mData).nickname);
        l.b((TextView) cVar.getView(R.id.tv_second_line_include_user), ((NearbyUser) this.mData).distance);
        cVar.setText(R.id.tv_third_line_include_user, ((NearbyUser) this.mData).desc);
        if (TextUtils.isEmpty(((NearbyUser) this.mData).desc)) {
            cVar.hide(R.id.tv_third_line_include_user);
        } else {
            cVar.show(R.id.tv_third_line_include_user);
        }
        T t = this.mData;
        ((AttentionButton) cVar.getView(R.id.ab_attention_include_user)).k((IRelation) t, false, ((NearbyUser) t).userId, this);
        ((RecommendPhotoView) cVar.getView(R.id.rpv_nearby_user_cell)).setImageUris(((NearbyUser) this.mData).work);
        cVar.itemView.setOnClickListener(this);
        listenAttentionEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PortraitImageView.f(view.getContext(), ((NearbyUser) this.mData).userId);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public void reloadResource() {
    }
}
