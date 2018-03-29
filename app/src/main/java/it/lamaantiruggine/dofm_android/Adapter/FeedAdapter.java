package it.lamaantiruggine.dofm_android.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import it.lamaantiruggine.dofm_android.Model.RSSObject;
import it.lamaantiruggine.dofm_android.R;

public class FeedAdapter extends RecyclerView.Adapter<FeedViewHolder> {

    private RSSObject rssObject;
    private Context mContext;
    private LayoutInflater inflater;
    public String url_item;

    public FeedAdapter(RSSObject rssObject, Context mContext) {
        this.rssObject = rssObject;
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public FeedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.row,parent,false);
        return new FeedViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FeedViewHolder holder, int position) {
        holder.txtTitle.setText(rssObject.getItems().get(position).getTitle());
        holder.txtPubDate.setText(rssObject.getItems().get(position).getPubDate());
        // holder.txtContent.setText(replacer(rssObject.getItems().get(position).getContent()));
        holder.txtCategory.setText(rssObject.getItems().get(position).getCategories().toString());
        url_item = rssObject.getItems().get(position).getLink();
    }

    /*
    public String replacer (String s) {
        s.replaceAll("<p>","").replaceAll("</p>","");
        return s;
    }
    */

    @Override
    public int getItemCount() {
        return rssObject.items.size();
    }
}
