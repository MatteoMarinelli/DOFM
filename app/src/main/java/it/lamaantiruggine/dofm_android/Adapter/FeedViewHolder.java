package it.lamaantiruggine.dofm_android.Adapter;


import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import it.lamaantiruggine.dofm_android.Interface.ItemClickListener;
import it.lamaantiruggine.dofm_android.Model.RSSObject;
import it.lamaantiruggine.dofm_android.R;
import it.lamaantiruggine.dofm_android.Webviewer;

class FeedViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener {

    private RSSObject rssObject;
    public TextView txtTitle, txtPubDate, txtContent, txtCategory;

    private ItemClickListener itemClickListener;
    private Intent i = new Intent(itemView.getContext(), Webviewer.class);

    public FeedViewHolder (View itemView) {
        super(itemView);
        txtTitle = (TextView)itemView.findViewById(R.id.txtTitle);
        txtPubDate = (TextView)itemView.findViewById(R.id.txtPubDate);
        txtCategory = (TextView)itemView.findViewById(R.id.txtCategory);

        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
    }


    public void setItemClickListener(ItemClickListener itemClickListener) {
        String url = FeedAdapter.url_item.toString();
        i.putExtra("LINK", url);
        itemView.getContext().startActivity(i);
    }

    @Override
    public void onClick(View view) {
        String url = FeedAdapter.url_item.toString();
        i.putExtra("LINK", url);
        itemView.getContext().startActivity(i);
    }

    @Override
    public boolean onLongClick(View view) {
        String url = FeedAdapter.url_item.toString();
        i.putExtra("LINK", url);
        itemView.getContext().startActivity(i);
        return true;
    }
}