package com.machalahubert.pl.java1_project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment_author_site extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_author_site,container,false);

        WebView webwiev = (WebView)view.findViewById(R.id.webView);
        webwiev.getSettings().setJavaScriptEnabled(true);
        webwiev.setWebViewClient(new WebViewClient());
        webwiev.loadUrl("http://machalahubert.pl/");

        return view;
    }
}
