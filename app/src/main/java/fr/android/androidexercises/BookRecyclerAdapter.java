package fr.android.androidexercises;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by maeln on 21/02/17.
 */

public class BookRecyclerAdapter extends RecyclerView.Adapter {
    private LayoutInflater inflate;
    private List<Book> books;

    public BookRecyclerAdapter(LayoutInflater inf, List<Book> b) {
        inflate = inf;
        books = b;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflate.inflate(R.layout.custom_view_item_book, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        BookItemView itemView = (BookItemView) holder.itemView;
        itemView.bindView(books.get(position));
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
