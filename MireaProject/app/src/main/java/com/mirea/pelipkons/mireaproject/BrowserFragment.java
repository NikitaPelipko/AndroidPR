package com.mirea.pelipkons.mireaproject;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.mirea.pelipkons.mireaproject.databinding.FragmentBrowserBinding;


public class BrowserFragment extends Fragment {

    private static final String DEFAULT_URL = "https://google.com";
    private FragmentBrowserBinding binding;

    @SuppressLint("SetJavaScriptEnabled")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentBrowserBinding.inflate(inflater, container, false);

        WebView webView = binding.webView;

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                binding.urlEditText.setText(url);
                binding.progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onPageStarted(WebView view, String url, android.graphics.Bitmap favicon) {
                binding.progressBar.setVisibility(View.VISIBLE);
            }
        });

        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                binding.progressBar.setProgress(newProgress);
            }
        });

        webView.loadUrl(DEFAULT_URL);
        binding.urlEditText.setText(DEFAULT_URL);

        binding.urlEditText.setOnEditorActionListener((TextView v, int actionId, KeyEvent event) -> {
            if (actionId == EditorInfo.IME_ACTION_GO
                    || (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {
                String url = v.getText().toString().trim();
                if (!url.startsWith("http://") && !url.startsWith("https://")) {
                    url = "https://" + url;
                }
                webView.loadUrl(url);
                return true;
            }
            return false;
        });

        binding.btnGo.setOnClickListener(v -> {
            String url = binding.urlEditText.getText().toString().trim();
            if (!url.startsWith("http://") && !url.startsWith("https://")) {
                url = "https://" + url;
            }
            webView.loadUrl(url);
        });

        binding.btnBack.setOnClickListener(v -> {
            if (webView.canGoBack()) webView.goBack();
        });

        binding.btnForward.setOnClickListener(v -> {
            if (webView.canGoForward()) webView.goForward();
        });

        binding.btnRefresh.setOnClickListener(v -> webView.reload());

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
