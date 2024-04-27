package com.ucompensar.apptiendaonline.ui.compras;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.ucompensar.apptiendaonline.databinding.FragmentComprasBinding;

public class ComprasFragment extends Fragment {

    private FragmentComprasBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ComprasViewModel slideshowViewModel =
                new ViewModelProvider(this).get(ComprasViewModel.class);

        binding = FragmentComprasBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textCompras;
        slideshowViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}