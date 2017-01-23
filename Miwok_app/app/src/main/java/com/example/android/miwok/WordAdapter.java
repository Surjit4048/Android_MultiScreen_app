package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

class WordAdapter extends ArrayAdapter<Word> {
    private int bgColor;

    WordAdapter(Context context, ArrayList<Word> words, int bgColor) {
        super(context, 0, words);
        this.bgColor = bgColor;
    }

    private static class ViewHolder {
        TextView miwokTextView;
        TextView englishTextView;
        ImageView iconImageView;
        LinearLayout rightLayout;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View listView = convertView;
        if (listView == null) {
            listView = LayoutInflater.from(parent.getContext()).inflate(R.layout.two_text_layout, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.miwokTextView = (TextView) listView.findViewById(R.id.ttl_miwok_text);
            viewHolder.englishTextView = (TextView) listView.findViewById(R.id.ttl_english_text);
            viewHolder.iconImageView = (ImageView) listView.findViewById(R.id.ttl_image);
            viewHolder.rightLayout = (LinearLayout) listView.findViewById(R.id.ttl_textView_layout);
            listView.setTag(viewHolder);
        }

        Word currentWord = getItem(position);
        ViewHolder holder = (ViewHolder) listView.getTag();
        holder.rightLayout.setBackgroundColor(ContextCompat.getColor(getContext(), bgColor));

        assert currentWord != null;
        holder.miwokTextView.setText(currentWord.getMiwokTranslation());
        holder.englishTextView.setText(currentWord.getDefaultTranslation());

        if (currentWord.hasImage()) {
            holder.iconImageView.setImageResource(currentWord.getImageId());
            holder.iconImageView.setVisibility(View.VISIBLE);
        } else {
            holder.iconImageView.setVisibility(View.GONE);
        }

        return listView;
    }
}
