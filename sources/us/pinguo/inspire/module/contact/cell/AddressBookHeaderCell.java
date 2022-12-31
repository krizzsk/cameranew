package us.pinguo.inspire.module.contact.cell;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import us.pinguo.user.User;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class AddressBookHeaderCell extends us.pinguo.widget.common.cell.recycler.b {
    private HeaderHolder mHeaderHolder;
    private OnBindListener mOnBindListener;

    /* loaded from: classes9.dex */
    public static class HeaderHolder extends us.pinguo.widget.common.cell.recycler.c {
        private View bindPhoneTips;
        private TextView btnBind;
        private TextView phoneBindedTips;
        private TextView phoneNumber;

        public HeaderHolder(View view) {
            super(view);
            this.btnBind = (TextView) view.findViewById(R.id.addr_btn_phone_bind);
            this.bindPhoneTips = view.findViewById(R.id.bind_phone_tips);
            this.phoneBindedTips = (TextView) view.findViewById(R.id.phone_binded_tips);
            this.phoneNumber = (TextView) view.findViewById(R.id.addr_bind_phone_number);
        }
    }

    /* loaded from: classes9.dex */
    public interface OnBindListener {
        void onBind();
    }

    public AddressBookHeaderCell(String str) {
        super(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void b(View view) {
        OnBindListener onBindListener = this.mOnBindListener;
        if (onBindListener != null) {
            onBindListener.onBind();
        }
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public us.pinguo.widget.common.cell.recycler.c createViewHolder(ViewGroup viewGroup) {
        return new HeaderHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.address_book_header_layout, viewGroup, false));
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return 0;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    protected void onBindViewHolder(us.pinguo.widget.common.cell.recycler.c cVar) {
        HeaderHolder headerHolder = (HeaderHolder) cVar;
        this.mHeaderHolder = headerHolder;
        headerHolder.btnBind.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.module.contact.cell.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddressBookHeaderCell.this.b(view);
            }
        });
        updateBind();
    }

    public void setOnBindListener(OnBindListener onBindListener) {
        this.mOnBindListener = onBindListener;
    }

    public void updateBind() {
        if (this.mHeaderHolder == null) {
            return;
        }
        String str = User.d().h().mobile;
        if (TextUtils.isEmpty(str)) {
            this.mHeaderHolder.bindPhoneTips.setVisibility(0);
            this.mHeaderHolder.phoneBindedTips.setVisibility(8);
            this.mHeaderHolder.btnBind.setVisibility(0);
            this.mHeaderHolder.phoneNumber.setVisibility(8);
            return;
        }
        this.mHeaderHolder.bindPhoneTips.setVisibility(8);
        this.mHeaderHolder.phoneBindedTips.setVisibility(0);
        this.mHeaderHolder.btnBind.setVisibility(8);
        this.mHeaderHolder.phoneNumber.setVisibility(0);
        String substring = str.substring(0, 3);
        String substring2 = str.substring(str.length() - 4, str.length());
        TextView textView = this.mHeaderHolder.phoneNumber;
        textView.setText(substring + "****" + substring2);
    }
}
