package com.example.accesscontrol.ui.livingcost;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.accesscontrol.databinding.FragmentLivingCostBinding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class LivingCostFragment extends Fragment{
    private LivingCostViewModel livingCostViewModel;
    private FragmentLivingCostBinding binding;

    private TextView electricityRowValue, gasRowValue, waterRowValue, totalRowValue;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        livingCostViewModel =
                new ViewModelProvider(this).get(LivingCostViewModel.class);

        binding = FragmentLivingCostBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        electricityRowValue = binding.electricityRowValue;
        gasRowValue = binding.gasRowValue;
        waterRowValue = binding.waterRowValue;
        totalRowValue = binding.totalRowValue;

        String url = "http://192.168.7.100:8000/api/student/3/get_living_payment/";
        new GetData().execute(url);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private class GetData extends AsyncTask<String, String, String> {

        protected void onPreExecute() {
            super.onPreExecute();
            totalRowValue.setText("Loading...");
        }

        @Override
        protected String doInBackground(String... strings) {
            HttpURLConnection connection = null;
            BufferedReader reader = null;
    
            URL url = null;
            try {
                url = new URL(strings[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuffer buffer = new StringBuffer();
                String line = "";

                while((line = reader.readLine()) != null) {
                    buffer.append(line).append("\n");
                }
                return buffer.toString();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }

                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            totalRowValue.setText(result);
        }
    }
}
