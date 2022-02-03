package com.example.viewpager2demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viewpager2demo.ApiPackage.ApiClient;
import com.example.viewpager2demo.ApiPackage.ApiService;
import com.example.viewpager2demo.ApiPackage.ApproveOrRejectRequest;
import com.example.viewpager2demo.ApiPackage.ApproveOrRejectResponse;
import com.example.viewpager2demo.ApiPackage.Item;
import com.example.viewpager2demo.ApiPackage.PendingStudentsDetail;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Page1 extends Fragment {

    private String title;
    private RecyclerView recyclerView;
    private View view;
    private ArrayList<CardModel> cardModels;
    private Retrofit retrofit;
    private ApiService apiService;
    private ArrayList<Item> itemArrayList;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerViewAdapter recyclerViewAdapter;

    public Page1(String title) {
        // Required empty public constructor

        this.title = title;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_page1, container, false);
        apiInit();
        getPendingStudentsDetail();
        return view;
    }

    private void apiInit() {
        retrofit = ApiClient.getRetrofit();
        apiService = ApiClient.getApiService();
    }

    private void getPendingStudentsDetail() {
        String status = "Pending";
        Call<PendingStudentsDetail> pendingStudentsDetailCall = apiService.getPendingStudentsDetails(status);
        pendingStudentsDetailCall.enqueue(new Callback<PendingStudentsDetail>() {
            @Override
            public void onResponse(Call<PendingStudentsDetail> call, Response<PendingStudentsDetail> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getContext(), String.valueOf(response.code()), Toast.LENGTH_LONG).show();
                }
                PendingStudentsDetail pendingStudentsDetail = response.body();
                //Toast.makeText(getContext(), String.valueOf(pendingStudentsDetail.getSettings().isStudentAutoApprove()), Toast.LENGTH_LONG).show();
                itemArrayList = pendingStudentsDetail.getItems();
                cardModels = new ArrayList<>();
                for (Item i :
                        itemArrayList) {
                    cardModels.add(new CardModel(i.getId(), i.getName(),
                            i.getPhone(),
                            "XI",
                            "Science",
                            i.getSubmittedOnDate(),
                            i.getSubmittedOnTime()));
                }
                buildRecyclerview();
            }

            @Override
            public void onFailure(Call<PendingStudentsDetail> call, Throwable t) {
                Toast.makeText(getContext(), "Error :(", Toast.LENGTH_LONG).show();
            }
        });
    }

//    private void createCard() {
//        cardModels = new ArrayList<>();
//        cardModels.add(new CardModel("Andrew L. Hennen", "+91 9834173204", "XI", "Science", "Science", "09:00 AM"));
//        cardModels.add(new CardModel("Andrew L. Hennen", "+91 9834173204", "XI", "Science", "Science", "09:00 AM"));
//        cardModels.add(new CardModel("Andrew L. Hennen", "+91 9834173204", "XI", "Science", "Science", "09:00 AM"));
//        cardModels.add(new CardModel("Andrew L. Hennen", "+91 9834173204", "XI", "Science", "Science", "09:00 AM"));
//    }

    private void buildRecyclerview() {
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerViewAdapter = new RecyclerViewAdapter(cardModels);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerViewAdapter.setOnItemClickedListener(new RecyclerViewAdapter.OnButtonClickedListener() {
            @Override
            public void onRejectClicked(int position) {
                rejectUser("Rejected", cardModels.get(position).getUserId());
                cardModels.remove(position);
                recyclerViewAdapter.notifyItemRemoved(position);
            }

            @Override
            public void onApproveClick(int position) {
                approveUser("Approved", cardModels.get(position).getUserId());
                cardModels.remove(position);
                recyclerViewAdapter.notifyItemRemoved(position);
            }
        });
    }

    private void approveUser(String approved, int userId) {
        ApproveOrRejectRequest approveOrRejectRequest = new ApproveOrRejectRequest(userId,approved);
        Call<ApproveOrRejectResponse> approveOrRejectResponseCall = apiService.getRejectResponse(approveOrRejectRequest);
        approveOrRejectResponseCall.enqueue(new Callback<ApproveOrRejectResponse>() {
            @Override
            public void onResponse(Call<ApproveOrRejectResponse> call, Response<ApproveOrRejectResponse> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(getContext(), String.valueOf(response.code()), Toast.LENGTH_LONG).show();
                }
                ApproveOrRejectResponse approveOrRejectResponse = response.body();
                
            }

            @Override
            public void onFailure(Call<ApproveOrRejectResponse> call, Throwable t) {
                Toast.makeText(getContext(), "Error :(", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void rejectUser(String rejected, int userId) {
        ApproveOrRejectRequest approveOrRejectRequest = new ApproveOrRejectRequest(userId, rejected);
        Call<ApproveOrRejectResponse> approveOrRejectResponseCall = apiService.getRejectResponse(approveOrRejectRequest);
        approveOrRejectResponseCall.enqueue(new Callback<ApproveOrRejectResponse>() {
            @Override
            public void onResponse(Call<ApproveOrRejectResponse> call, Response<ApproveOrRejectResponse> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getContext(), String.valueOf(response.code()), Toast.LENGTH_LONG).show();
                }
                ApproveOrRejectResponse approveOrRejectResponse = response.body();
                //Toast.makeText(getContext(), approveOrRejectResponse.getEmail(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<ApproveOrRejectResponse> call, Throwable t) {
                Toast.makeText(getContext(), "Error :(", Toast.LENGTH_LONG).show();
            }
        });
    }
}