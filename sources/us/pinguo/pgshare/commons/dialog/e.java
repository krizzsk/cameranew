package us.pinguo.pgshare.commons.dialog;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.List;
import java.util.concurrent.Executors;
import us.pinguo.pgshare.commons.R;
import us.pinguo.pgshare.commons.dialog.SheetContentView;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareSiteAdapter.java */
/* loaded from: classes5.dex */
public class e extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<us.pinguo.pgshare.commons.dialog.b> a;
    private SheetContentView.d b;

    /* compiled from: ShareSiteAdapter.java */
    /* loaded from: classes5.dex */
    class a extends RecyclerView.ViewHolder {
        a(e eVar, View view) {
            super(view);
        }
    }

    /* compiled from: ShareSiteAdapter.java */
    /* loaded from: classes5.dex */
    class b extends AsyncTask<Void, Void, Drawable> {
        final /* synthetic */ us.pinguo.pgshare.commons.dialog.d a;
        final /* synthetic */ PackageManager b;
        final /* synthetic */ d c;

        b(e eVar, us.pinguo.pgshare.commons.dialog.d dVar, PackageManager packageManager, d dVar2) {
            this.a = dVar;
            this.b = packageManager;
            this.c = dVar2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Drawable doInBackground(@NonNull Void... voidArr) {
            return this.a.c.loadIcon(this.b);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(@NonNull Drawable drawable) {
            us.pinguo.pgshare.commons.dialog.d dVar = this.a;
            dVar.a = drawable;
            dVar.f11635d = null;
            this.c.a.setImageDrawable(drawable);
        }
    }

    /* compiled from: ShareSiteAdapter.java */
    /* loaded from: classes5.dex */
    class c implements View.OnClickListener {
        final /* synthetic */ int a;

        c(int i2) {
            this.a = i2;
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            if (e.this.b != null) {
                e.this.b.onItemClick(view, this.a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ShareSiteAdapter.java */
    /* loaded from: classes5.dex */
    public static class d extends RecyclerView.ViewHolder {
        public ImageView a;
        public TextView b;

        public d(View view) {
            super(view);
            this.a = (ImageView) this.itemView.findViewById(R.id.share_site_icon);
            this.b = (TextView) this.itemView.findViewById(R.id.share_site_title);
        }
    }

    public e(List<us.pinguo.pgshare.commons.dialog.b> list, SheetContentView.d dVar) {
        this.a = list;
        this.b = dVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<us.pinguo.pgshare.commons.dialog.b> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        return this.a.get(i2).a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
        us.pinguo.pgshare.commons.dialog.b bVar = this.a.get(i2);
        int i3 = bVar.a;
        if (i3 == 1) {
            d dVar = (d) viewHolder;
            f fVar = bVar.c;
            dVar.b.setText(fVar.a);
            dVar.a.setImageResource(fVar.b);
        } else if (i3 == 4) {
            d dVar2 = (d) viewHolder;
            us.pinguo.pgshare.commons.dialog.c cVar = bVar.f11634d;
            dVar2.b.setText(cVar.a);
            dVar2.a.setImageResource(cVar.b);
        } else if (i3 == 3) {
            d dVar3 = (d) viewHolder;
            dVar3.b.setText("");
            dVar3.a.setImageBitmap(null);
            viewHolder.itemView.setBackgroundColor(0);
        } else if (i3 == 0) {
            d dVar4 = (d) viewHolder;
            us.pinguo.pgshare.commons.dialog.d dVar5 = bVar.b;
            dVar4.b.setText(dVar5.b);
            AsyncTask<Void, Void, Drawable> asyncTask = dVar5.f11635d;
            if (asyncTask != null) {
                asyncTask.cancel(true);
                dVar5.f11635d = null;
            }
            Drawable drawable = dVar5.a;
            if (drawable != null) {
                dVar4.a.setImageDrawable(drawable);
            } else {
                Resources resources = dVar4.itemView.getResources();
                PackageManager packageManager = dVar4.itemView.getContext().getPackageManager();
                dVar4.a.setImageDrawable(resources.getDrawable(R.color.divider_gray));
                b bVar2 = new b(this, dVar5, packageManager, dVar4);
                dVar5.f11635d = bVar2;
                bVar2.executeOnExecutor(Executors.newSingleThreadExecutor(), new Void[0]);
            }
        }
        viewHolder.itemView.setOnClickListener(new c(i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        Context context = viewGroup.getContext();
        if (i2 == 2) {
            return new a(this, LayoutInflater.from(context).inflate(R.layout.vw_share_send_to_title, viewGroup, false));
        }
        return new d(LayoutInflater.from(context).inflate(R.layout.adapter_share_site_item, viewGroup, false));
    }
}
