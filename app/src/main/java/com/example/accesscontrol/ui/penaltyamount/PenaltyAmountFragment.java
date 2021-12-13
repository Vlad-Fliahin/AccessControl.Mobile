package com.example.accesscontrol.ui.penaltyamount;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.accesscontrol.databinding.FragmentPenaltyAmountBinding;

public class PenaltyAmountFragment extends Fragment{
    private PenaltyAmountViewModel penaltyAmountViewModel;
    private FragmentPenaltyAmountBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        penaltyAmountViewModel =
                new ViewModelProvider(this).get(PenaltyAmountViewModel.class);

        binding = FragmentPenaltyAmountBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textView3;
//        profileViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
