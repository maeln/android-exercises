package fr.android.androidexercises;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class BookAdapter extends BaseAdapter {
    protected LayoutInflater inflater;

    private final List<Book> books;

    public BookAdapter(Context context, List<Book> books) {
        this.books = books;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return this.books.size();
    }

    @Override
    public Book getItem(int position) {
        return this.books.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.books.get(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BookItemView view;
        if(convertView == null) {
            view = (BookItemView) inflater.inflate(R.layout.custom_view_item_book, parent, false);
        } else {
            view = (BookItemView) convertView;
        }
        view.bindView(getItem(position));
        return view;
    }
}
