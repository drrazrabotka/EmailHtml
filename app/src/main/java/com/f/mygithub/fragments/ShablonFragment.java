package com.f.mygithub.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.f.mygithub.R;
import com.f.mygithub.jsoup.EditHtml;
import com.f.mygithub.utility.ParseHtml;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class ShablonFragment extends Fragment {
    private String title_ = "";
    private String heading_ = "";
    private String body_ = "";
    private String lower_ = "";

    Fragment fragment;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shablon_fragment, container, false);
        EditText title = (EditText) view.findViewById(R.id.title);
        EditText heading = (EditText) view.findViewById(R.id.heading);
        EditText body = (EditText) view.findViewById(R.id.body);
        EditText lower = (EditText) view.findViewById(R.id.lower);
        Button button = (Button) view.findViewById(R.id.button_shblon_fragment);

        assert getArguments() != null;
        String file = getArguments().getString("file");
        ParseHtml parseHtml = new ParseHtml(getContext());
        EditHtml editHtml = new EditHtml(parseHtml.getHtmlParse(file));

        title_ = editHtml.getTitle();
        heading_ = editHtml.getHeading();
        body_ = editHtml.getBody();
        lower_ = editHtml.getLower();

        title.setText(title_);
        heading.setText(heading_);
        body.setText(body_);
        lower.setText(lower_);

        button.setOnClickListener(v -> {
            editHtml.setTitle(title.getText().toString());
            editHtml.setHeading(heading.getText().toString());
            editHtml.setBody(body.getText().toString());
            editHtml.setLower(lower.getText().toString());

            String html = editHtml.getHtml();
            fragment = ShablonFragment.this;
            Bundle bundle = new Bundle();
            bundle.putString("email", html);
            FragmentTransaction fragmentTransaction = fragment
                    .getActivity()
                    .getSupportFragmentManager()
                    .beginTransaction();

            fragmentTransaction.replace(R.id.container, LetterFragment.class, bundle);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        });



        return view;
    }
}
