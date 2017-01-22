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

    private TextView miwokTextView;
    private TextView defaultTextView;
    private ImageView image;

    private int bgColor;
    private LinearLayout rightLayout;

    WordAdapter(Context context, ArrayList<Word> words, int bgColor) {
        super(context, 0, words);
        this.bgColor = bgColor;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        View listView = convertView;
        if (listView == null) {
            listView = LayoutInflater.from(parent.getContext()).inflate(R.layout.two_text_layout, parent, false);
        }
        Word currentWord = getItem(position);

        miwokTextView = (TextView) listView.findViewById(R.id.ttl_miwok_text);
        defaultTextView = (TextView) listView.findViewById(R.id.ttl_english_text);
        image = (ImageView) listView.findViewById(R.id.ttl_image);
        rightLayout = (LinearLayout) listView.findViewById(R.id.ttl_textView_layout);
        rightLayout.setBackgroundColor(ContextCompat.getColor(getContext(), bgColor));

        assert currentWord != null;
        miwokTextView.setText(currentWord.getMiwokTranslation());
        defaultTextView.setText(currentWord.getDefaultTranslation());

        if (currentWord.hasImage()) {
            image.setImageResource(currentWord.getImageId());
            image.setVisibility(View.VISIBLE);
        } else {
            image.setVisibility(View.GONE);
        }

        return listView;
    }
}
