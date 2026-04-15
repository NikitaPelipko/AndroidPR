package com.mirea.pelipkons.mireaproject;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.mirea.pelipkons.mireaproject.databinding.FragmentPlayerBinding;

import static android.Manifest.permission.FOREGROUND_SERVICE;
import static android.Manifest.permission.POST_NOTIFICATIONS;

public class PlayerFragment extends Fragment {

    private FragmentPlayerBinding binding;
    private static final int PERMISSION_CODE = 200;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentPlayerBinding.inflate(inflater, container, false);

        if (ContextCompat.checkSelfPermission(requireContext(), POST_NOTIFICATIONS)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(requireActivity(),
                    new String[]{POST_NOTIFICATIONS, FOREGROUND_SERVICE}, PERMISSION_CODE);
        }

        binding.playButton.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), PlayerService.class);
            ContextCompat.startForegroundService(requireContext(), intent);
        });

        binding.pauseButton.setOnClickListener(v -> {
            requireContext().stopService(new Intent(requireContext(), PlayerService.class));
        });

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}